/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
public class Customer extends User implements Serializable {

    @Size(min = 1, max = 100)
    private String currentGamePlaying;
    private boolean isBanned = false;
    @Future
    private Date unbanDate;
    @NotNull
    @Size(min = 5, max = 100)
    private String securityQuestion;
    @NotNull
    @Size(min = 5, max = 100)
    private String securityAnswer;
    //TODO: Add relational mapping

    public Customer() {
    }

    public Customer(String currentGamePlaying, Date unbanDate, String securityQuestion, String securityAnswer) {
        this();
        this.currentGamePlaying = currentGamePlaying;
        this.unbanDate = unbanDate;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }

    /**
     * @return the currentGamePlaying
     */
    public String getCurrentGamePlaying() {
        return currentGamePlaying;
    }

    /**
     * @param currentGamePlaying the currentGamePlaying to set
     */
    public void setCurrentGamePlaying(String currentGamePlaying) {
        this.currentGamePlaying = currentGamePlaying;
    }

    /**
     * @return the isBanned
     */
    public boolean isIsBanned() {
        return isBanned;
    }

    /**
     * @param isBanned the isBanned to set
     */
    public void setIsBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }

    /**
     * @return the unbanDate
     */
    public Date getUnbanDate() {
        return unbanDate;
    }

    /**
     * @param unbanDate the unbanDate to set
     */
    public void setUnbanDate(Date unbanDate) {
        this.unbanDate = unbanDate;
    }

    /**
     * @return the securityQuestion
     */
    public String getSecurityQuestion() {
        return securityQuestion;
    }

    /**
     * @param securityQuestion the securityQuestion to set
     */
    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    /**
     * @return the securityAnswer
     */
    public String getSecurityAnswer() {
        return securityAnswer;
    }

    /**
     * @param securityAnswer the securityAnswer to set
     */
    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }
}
