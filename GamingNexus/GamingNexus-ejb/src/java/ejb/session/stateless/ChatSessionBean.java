/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Chat;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class ChatSessionBean implements ChatSessionBeanLocal {

    @PersistenceContext(unitName = "GamingNexus-ejbPU")
    private EntityManager em;

    @Override
    public long createNewChat(Chat chat) {
        em.persist(chat);
        em.flush();

        return chat.getChatID();
    }

    @Override
    public Chat retrieveChatByID(long chatID) {
        Chat chatToBeRetrived = em.find(Chat.class, chatID);
        chatToBeRetrived.getCompanies().size();
        chatToBeRetrived.getCustomers().size();
        chatToBeRetrived.getMessages().size();
        return chatToBeRetrived;
    }

    @Override
    public void updateChat(Chat chat) {
        Chat chatToBeUpdated = this.retrieveChatByID(chat.getChatID());
        chatToBeUpdated.setChatName(chat.getChatName());
        chatToBeUpdated.setIsGroupChat(chat.isIsGroupChat());
        chatToBeUpdated.setCompanies(chat.getCompanies());
        chatToBeUpdated.setCustomers(chat.getCustomers());
        chatToBeUpdated.setMessages(chat.getMessages());
    }

    @Override
    public void deleteChat(long chatID) {
        Chat chatToBeDeleted = this.retrieveChatByID(chatID);
        em.remove(chatToBeDeleted);
    }

}
