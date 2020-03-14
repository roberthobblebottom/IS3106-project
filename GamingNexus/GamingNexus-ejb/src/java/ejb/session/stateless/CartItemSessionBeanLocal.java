/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.CartItem;
import java.util.List;
import javax.ejb.Local;
import util.exception.EntityInstanceNotFound;

/**
 *
 * @author root
 */
@Local
public interface CartItemSessionBeanLocal {


    public long createNewCartItem(CartItem cartItem);

//    void updateCartItem(CartItem cartItem, Long cartItemID)throws  EntityInstanceNotFound;


    public CartItem retrieveCartItembyID(Long cartItemID)throws  EntityInstanceNotFound;

    public List<CartItem> retrieveAllCartItems() throws EntityInstanceNotFound;

    public void deleteCartItem(Long cartItemID) throws EntityInstanceNotFound;
    
}
