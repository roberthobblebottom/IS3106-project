/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/**
 *
 * @author root
 */
@Entity
public class ItemInstance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemInstanceID;
    @Past
    private Date dateOfAquisition;
    @OneToOne(optional = false)
    @JoinColumn(nullable = false)
    @NotNull
    private GameAccount gameAccount;
 @OneToOne(optional = false)
    @JoinColumn(nullable = false)
    @NotNull
    private InGameItem inGameItem;
    public ItemInstance() {
    }

    public ItemInstance(Date dateOfAquisition, GameAccount gameAccount, InGameItem inGameItem) {
this();
        this.dateOfAquisition = dateOfAquisition;
        this.gameAccount = gameAccount;
        this.inGameItem = inGameItem;
    }

    public Long getItemInstanceID() {
        return itemInstanceID;
    }

    public void setItemInstanceID(Long itemInstanceID) {
        this.itemInstanceID = itemInstanceID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemInstanceID != null ? itemInstanceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the itemInstanceID fields are not set
        if (!(object instanceof ItemInstance)) {
            return false;
        }
        ItemInstance other = (ItemInstance) object;
        if ((this.itemInstanceID == null && other.itemInstanceID != null) || (this.itemInstanceID != null && !this.itemInstanceID.equals(other.itemInstanceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entity.ItemInstance[ id=" + itemInstanceID + " ]";
    }

    /**
     * @return the dateOfAquisition
     */
    public Date getDateOfAquisition() {
        return dateOfAquisition;
    }

    /**
     * @param dateOfAquisition the dateOfAquisition to set
     */
    public void setDateOfAquisition(Date dateOfAquisition) {
        this.dateOfAquisition = dateOfAquisition;
    }

    /**
     * @return the gameAccount
     */
    public GameAccount getGameAccount() {
        return gameAccount;
    }

    /**
     * @param gameAccount the gameAccount to set
     */
    public void setGameAccount(GameAccount gameAccount) {
        this.gameAccount = gameAccount;
    }

    /**
     * @return the inGameItem
     */
    public InGameItem getInGameItem() {
        return inGameItem;
    }

    /**
     * @param inGameItem the inGameItem to set
     */
    public void setInGameItem(InGameItem inGameItem) {
        this.inGameItem = inGameItem;
    }

}
