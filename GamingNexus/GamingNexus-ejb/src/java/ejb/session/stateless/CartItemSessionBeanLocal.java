/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.CartItem;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface CartItemSessionBeanLocal {


    public long createNewCartItem(CartItem cartItem);

    void updateCartItem(CartItem cartItem, Long cartItemID);


    public CartItem retrieveCartItembyID(Long cartItemID);
    
}
