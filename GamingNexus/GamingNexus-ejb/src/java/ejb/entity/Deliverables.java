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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Entity
public class Deliverables implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliverablesID;
    @Future
    @NotNull
    private Date expectedDateOfArrival;
    @NotNull
    @Digits(integer = 15, fraction = 0)
    private int DeliveryManPhoneNumber;
    @NotNull
    private boolean hasArrived = false;
    @OneToMany
    @JoinColumn(nullable = false)
    @NotNull
    private List<Hardware> hardwares;
    @OneToMany
    private List<Customer> customers;

    public Deliverables() {
    }

    public Deliverables(Date expectedDateOfArrival, int DeliveryManPhoneNumber, List<Hardware> hardwares, List<Customer> customers) {
        this.expectedDateOfArrival = expectedDateOfArrival;
        this.DeliveryManPhoneNumber = DeliveryManPhoneNumber;
        this.hardwares = hardwares;
        this.customers = customers;
    }

    

    public Long getDeliverablesID() {
        return deliverablesID;
    }

    public void setDeliverablesID(Long deliverablesID) {
        this.deliverablesID = deliverablesID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliverablesID != null ? deliverablesID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the deliverablesID fields are not set
        if (!(object instanceof Deliverables)) {
            return false;
        }
        Deliverables other = (Deliverables) object;
        if ((this.deliverablesID == null && other.deliverablesID != null) || (this.deliverablesID != null && !this.deliverablesID.equals(other.deliverablesID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entity.Deliverables[ id=" + deliverablesID + " ]";
    }

    /**
     * @return the expectedDateOfArrival
     */
    public Date getExpectedDateOfArrival() {
        return expectedDateOfArrival;
    }

    /**
     * @param expectedDateOfArrival the expectedDateOfArrival to set
     */
    public void setExpectedDateOfArrival(Date expectedDateOfArrival) {
        this.expectedDateOfArrival = expectedDateOfArrival;
    }

    /**
     * @return the DeliveryManPhoneNumber
     */
    public int getDeliveryManPhoneNumber() {
        return DeliveryManPhoneNumber;
    }

    /**
     * @param DeliveryManPhoneNumber the DeliveryManPhoneNumber to set
     */
    public void setDeliveryManPhoneNumber(int DeliveryManPhoneNumber) {
        this.DeliveryManPhoneNumber = DeliveryManPhoneNumber;
    }

    /**
     * @return the hasArrived
     */
    public boolean isHasArrived() {
        return hasArrived;
    }

    /**
     * @param hasArrived the hasArrived to set
     */
    public void setHasArrived(boolean hasArrived) {
        this.hasArrived = hasArrived;
    }

    /**
     * @return the hardwares
     */
    public List<Hardware> getHardwares() {
        return hardwares;
    }

    /**
     * @param hardwares the hardwares to set
     */
    public void setHardwares(List<Hardware> hardwares) {
        this.hardwares = hardwares;
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

}
