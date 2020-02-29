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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/**
 *
 * @author root
 */
@Entity
public class OwnedItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownedItemID;
    @Past
    @NotNull
    private Date dateOfPurchase;
    //TODO: Add relational mapping

    public OwnedItem() {
    }

    public OwnedItem(Date dateOfPurchase) {
        this();
        this.dateOfPurchase = dateOfPurchase;
    }

    public Long getOwnedItemID() {
        return ownedItemID;
    }

    public void setOwnedItemID(Long ownedItemID) {
        this.ownedItemID = ownedItemID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ownedItemID != null ? ownedItemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the ownedItemID fields are not set
        if (!(object instanceof OwnedItem)) {
            return false;
        }
        OwnedItem other = (OwnedItem) object;
        if ((this.ownedItemID == null && other.ownedItemID != null) || (this.ownedItemID != null && !this.ownedItemID.equals(other.ownedItemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entity.OwnedItem[ id=" + ownedItemID + " ]";
    }

    /**
     * @return the dateOfPurchase
     */
    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    /**
     * @param dateOfPurchase the dateOfPurchase to set
     */
    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

}
