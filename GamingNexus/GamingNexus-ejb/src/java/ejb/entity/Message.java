/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.sql.rowset.serial.SerialBlob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageID;
    @Past
    @NotNull
    private Date dateTimeStamp;
    @NotNull
    @Size(min = 1, max = 2000)
    private String message;
    private List<SerialBlob> multimedia;
    @NotNull
    @OneToOne
    private User fromUser;
    @NotNull
    private boolean isNewPost = false;
    //TODO: Add relational mapping
    //TODO: Make sure that the Message entity is NOT linked to both Chat entity and Forum Entity

    public Message() {
        
    }

    public Message(Date dateTimeStamp, String message, List<SerialBlob> multimedia, User from) {
        this();
        this.dateTimeStamp = dateTimeStamp;
        this.message = message;
        this.multimedia = multimedia;
        this.fromUser = from;
    }

    public Long getMessageID() {
        return messageID;
    }

    public void setMessageID(Long messageID) {
        this.messageID = messageID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messageID != null ? messageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the messageID fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.messageID == null && other.messageID != null) || (this.messageID != null && !this.messageID.equals(other.messageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entity.Message[ id=" + messageID + " ]";
    }

    /**
     * @return the dateTimeStamp
     */
    public Date getDateTimeStamp() {
        return dateTimeStamp;
    }

    /**
     * @param dateTimeStamp the dateTimeStamp to set
     */
    public void setDateTimeStamp(Date dateTimeStamp) {
        this.dateTimeStamp = dateTimeStamp;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the multimedia
     */
    public List<SerialBlob> getMultimedia() {
        return multimedia;
    }

    /**
     * @param multimedia the multimedia to set
     */
    public void setMultimedia(List<SerialBlob> multimedia) {
        this.multimedia = multimedia;
    }

    /**
     * @return the fromUser
     */
    public User getFromUser() {
        return fromUser;
    }

    /**
     * @param fromUser the fromUser to set
     */
    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    /**
     * @return the isNewPost
     */
    public boolean isIsNewPost() {
        return isNewPost;
    }

    /**
     * @param isNewPost the isNewPost to set
     */
    public void setIsNewPost(boolean isNewPost) {
        this.isNewPost = isNewPost;
    }

}
