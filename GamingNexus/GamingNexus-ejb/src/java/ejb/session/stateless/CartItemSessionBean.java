/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.CartItem;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import util.exception.EntityInstanceNotFound;

/**
 *
 * @author root
 */
@Stateless
public class CartItemSessionBean implements CartItemSessionBeanLocal {

    @PersistenceContext(unitName = "GamingNexus-ejbPU")
    private EntityManager em;
    private final ValidatorFactory validatorFactory;
    private final Validator validator;

    public CartItemSessionBean() {
        this.validatorFactory = Validation.buildDefaultValidatorFactory();
        this.validator = validatorFactory.getValidator();
    }

    @Override
    public long createNewCartItem(CartItem cartItem) {
        em.persist(cartItem);
        em.flush();
        return cartItem.getCartItemID();
    }

    @Override
    public CartItem retrieveCartItembyID(Long cartItemID) throws EntityInstanceNotFound {
        CartItem cartItemToBeRetrieved = em.find(CartItem.class, cartItemID);
        if (cartItemToBeRetrieved != null) {
            return cartItemToBeRetrieved;
        } else {
            throw new EntityInstanceNotFound();
        }
    }

    @Override
    public List<CartItem> retrieveAllCartItems() throws EntityInstanceNotFound {

        Query query = em.createQuery("SELECT c FROM CartItem c ORDER BY c.product.name ASC");
        List<CartItem> cartItemsToBeRetrieved = query.getResultList();
        if (cartItemsToBeRetrieved != null) {
            return cartItemsToBeRetrieved;
        } else {
            throw new EntityInstanceNotFound();
        }
    }
    /////I realised there isn't a need to update cartitem instance
//    @Override
//    public void updateCartItem(CartItem cartItem, Long cartItemID) throws EntityInstanceNotFound {
//        CartItem cartItemToBeUpdated = this.retrieveCartItembyID(cartItemID);
//        Set<ConstraintViolation<CartItem>> constraintViolations = validator.validate(cartItemToBeUpdated);
//        
//       
////        if(constraintViolations.isEmpty()){
////        }else{
////        throw new InputData
////        }
//        
//        
//    }

    @Override
    public void deleteCartItem(Long cartItemID) throws EntityInstanceNotFound {
        CartItem cartItem = em.find(CartItem.class, cartItemID);
        if (cartItem != null) {
            em.remove(cartItem);
        } else {
            throw new EntityInstanceNotFound();
        }
    }

}
