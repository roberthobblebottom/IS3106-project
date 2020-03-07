/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * this
 *
 * @author root
 */
@Entity
public class Hardware extends Product implements Serializable {

    @Size(min = 0, max = 5000)
    private String warrentyDescription;
    @Size(min = 0, max = 5000)
    @NotNull
    private String technicalspecification;
    @Size(min = 0, max = 100)
    @NotNull
    private String manufactoringCountry;
    @Size(min = 0, max = 100)
    @NotNull
    private String deliveryFirm;
    @OneToMany(mappedBy = "Hard")
    private List<Deliverables> deliverables;

    public Hardware() {
        super();
    }

    public Hardware(String warrentyDescription, String technicalspecification, String manufactoringCountry, String deliveryFirm, List<Deliverables> deliverables, String name, String description, String computerRequirements, double price, double averageRating, Company company, List<Tag> tags, List<Promotion> promotions, List<CartItem> cartItems, List<OwnedItem> ownedItems) {
        super(name, description, computerRequirements, price, averageRating, company, tags, promotions, cartItems, ownedItems);
        this.warrentyDescription = warrentyDescription;
        this.technicalspecification = technicalspecification;
        this.manufactoringCountry = manufactoringCountry;
        this.deliveryFirm = deliveryFirm;
        this.deliverables = deliverables;
    }


    /**
     * @return the warrentyDescription
     */
    public String getWarrentyDescription() {
        return warrentyDescription;
    }

    /**
     * @param warrentyDescription the warrentyDescription to set
     */
    public void setWarrentyDescription(String warrentyDescription) {
        this.warrentyDescription = warrentyDescription;
    }

    /**
     * @return the technicalspecification
     */
    public String getTechnicalspecification() {
        return technicalspecification;
    }

    /**
     * @param technicalspecification the technicalspecification to set
     */
    public void setTechnicalspecification(String technicalspecification) {
        this.technicalspecification = technicalspecification;
    }

    /**
     * @return the manufactoringCountry
     */
    public String getManufactoringCountry() {
        return manufactoringCountry;
    }

    /**
     * @param manufactoringCountry the manufactoringCountry to set
     */
    public void setManufactoringCountry(String manufactoringCountry) {
        this.manufactoringCountry = manufactoringCountry;
    }

    /**
     * @return the deliveryFirm
     */
    public String getDeliveryFirm() {
        return deliveryFirm;
    }

    /**
     * @param deliveryFirm the deliveryFirm to set
     */
    public void setDeliveryFirm(String deliveryFirm) {
        this.deliveryFirm = deliveryFirm;
    }

    /**
     * @return the deliverables
     */
    public List<Deliverables> getDeliverables() {
        return deliverables;
    }

    /**
     * @param deliverables the deliverables to set
     */
    public void setDeliverables(List<Deliverables> deliverables) {
        this.deliverables = deliverables;
    }

}
