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
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
public abstract class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productID;
    @NotNull
    @Size(min = 1, max = 100)
    private String name;
    @NotNull
    @Size(min = 0, max = 5000)
    private String description;
    @NotNull
    @Size(min = 10, max = 5000)
    private String computerRequirements;
    @NotNull
    @Digits(integer = 1000000000, fraction = 2)
    private double price;
    @Digits(integer = 1, fraction = 2)
    @Min(0)
    @Max(5)
    @NotNull
    private double averageRating;

    public Product() {
    }

    public Product(String name, String description, String computerRequirements, double price, double averageRating, List<String> tags) {
        this();
        this.name = name;
        this.description = description;
        this.computerRequirements = computerRequirements;
        this.price = price;
        this.averageRating = averageRating;
        
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the productID fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entity.Product[ id=" + productID + " ]";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the computerRequirements
     */
    public String getComputerRequirements() {
        return computerRequirements;
    }

    /**
     * @param computerRequirements the computerRequirements to set
     */
    public void setComputerRequirements(String computerRequirements) {
        this.computerRequirements = computerRequirements;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the averageRating
     */
    public double getAverageRating() {
        return averageRating;
    }

    /**
     * @param averageRating the averageRating to set
     */
    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

}
