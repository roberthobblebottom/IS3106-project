/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.CartItem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class CartItemSessionBean implements CartItemSessionBeanLocal {

    @PersistenceContext(unitName = "GamingNexus-ejbPU")
    private EntityManager em;

    @Override
    public long createNewCartItem(CartItem cartItem) {
        em.persist(cartItem);
        em.flush();
        return cartItem.getCartItemID();
    }
    
     @Override
    public CartItem retrieveCartItembyID(Long cartItemID) {

        return null;
    }


    @Override
    
    
    
    
    public void updateCartItem(CartItem cartItem, Long cartItemID) {
        CartItem cartItemToUpdate = retrieveCartItemByID(cartItemID);
    }

   
}
