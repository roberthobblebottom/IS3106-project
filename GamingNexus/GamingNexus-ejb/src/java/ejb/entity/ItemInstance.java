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
    //TODO: Add relational mapping

    public ItemInstance() {
    }

    public ItemInstance(Date dateOfAquisition) {
        this();
        this.dateOfAquisition = dateOfAquisition;
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
    
}
