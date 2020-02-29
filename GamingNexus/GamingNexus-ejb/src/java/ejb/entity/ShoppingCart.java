/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Entity
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shoppingCartID;
    @NotNull
    @Min(0)
    @Digits(integer = 1000000000, fraction = 2)
    private float subTotalPayable;
    @NotNull
    @Min(0)
    @Digits(integer = 1000000000, fraction = 2)
    private float discount;
    @NotNull
    @Min(0)
    @Digits(integer = 1000000000, fraction = 2)
    private float netTotalPayable;
    //TODO: Add relational mapping

    public Long getShoppingCartID() {
        return shoppingCartID;
    }

    public void setShoppingCartID(Long shoppingCartID) {
        this.shoppingCartID = shoppingCartID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shoppingCartID != null ? shoppingCartID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the shoppingCartID fields are not set
        if (!(object instanceof ShoppingCart)) {
            return false;
        }
        ShoppingCart other = (ShoppingCart) object;
        if ((this.shoppingCartID == null && other.shoppingCartID != null) || (this.shoppingCartID != null && !this.shoppingCartID.equals(other.shoppingCartID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entity.ShoppingCart[ id=" + shoppingCartID + " ]";
    }

    /**
     * @return the subTotalPayable
     */
    public float getSubTotalPayable() {
        return subTotalPayable;
    }

    /**
     * @param subTotalPayable the subTotalPayable to set
     */
    public void setSubTotalPayable(float subTotalPayable) {
        this.subTotalPayable = subTotalPayable;
    }

    /**
     * @return the discount
     */
    public float getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(float discount) {
        this.discount = discount;
    }

    /**
     * @return the netTotalPayable
     */
    public float getNetTotalPayable() {
        return netTotalPayable;
    }

    /**
     * @param netTotalPayable the netTotalPayable to set
     */
    public void setNetTotalPayable(float netTotalPayable) {
        this.netTotalPayable = netTotalPayable;
    }

}
