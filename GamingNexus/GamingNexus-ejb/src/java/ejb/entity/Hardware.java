/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
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
    //TODO: Add relational mapping

    public Hardware() {
    }

    public Hardware(String warrentyDescription, String technicalspecification) {
        this();
        this.warrentyDescription = warrentyDescription;
        this.technicalspecification = technicalspecification;
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

}
