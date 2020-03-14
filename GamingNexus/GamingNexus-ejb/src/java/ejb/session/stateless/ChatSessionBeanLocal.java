/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Chat;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ChatSessionBeanLocal {

    public long createNewChat(Chat chat);

    public Chat retrieveChatByID(long chatID);

    public void deleteChat(long chatID);

    public void updateChat(Chat chat);
    
}
