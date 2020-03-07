/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
public class Chat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatID;
    @NotNull
    @Size(min = 3, max = 100)
    private String chatName;
    @NotNull
    private boolean isGroupChat;
    @ManyToMany
    private List<Customer> customers;
    @OneToMany(mappedBy = "Chat")
    private List<Message> messages;
    @OneToMany(mappedBy = "Chat")
    private List<Company> companies;

    public Chat() {
    }

    public Chat(String chatName, boolean isGroupChat) {
        this();
        this.chatName = chatName;
        this.isGroupChat = isGroupChat;
    }

    public Long getChatID() {
        return chatID;
    }

    public void setChatID(Long chatID) {
        this.chatID = chatID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chatID != null ? chatID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the chatID fields are not set
        if (!(object instanceof Chat)) {
            return false;
        }
        Chat other = (Chat) object;
        if ((this.chatID == null && other.chatID != null) || (this.chatID != null && !this.chatID.equals(other.chatID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entity.Chat[ id=" + chatID + " ]";
    }

    /**
     * @return the chatName
     */
    public String getChatName() {
        return chatName;
    }

    /**
     * @param chatName the chatName to set
     */
    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    /**
     * @return the isGroupChat
     */
    public boolean isIsGroupChat() {
        return isGroupChat;
    }

    /**
     * @param isGroupChat the isGroupChat to set
     */
    public void setIsGroupChat(boolean isGroupChat) {
        this.isGroupChat = isGroupChat;
    }

    /**
     * @return the customers
     */
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * @param customers the customers to set
     */
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    /**
     * @return the messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * @return the companies
     */
    public List<Company> getCompanies() {
        return companies;
    }

    /**
     * @param companies the companies to set
     */
    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

}
