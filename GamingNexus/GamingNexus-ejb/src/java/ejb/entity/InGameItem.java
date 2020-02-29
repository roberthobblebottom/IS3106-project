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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
public class InGameItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inGameItemID;
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
    @NotNull
    @Size(min = 1, max = 50)
    private String type;
    @NotNull
    @Size(min = 1, max = 1000)
    private String statistic;
    @NotNull
    @Size(min = 1, max = 3000)
    private String description;
    //TODO: Add relational mapping

    public InGameItem() {
    }

    public InGameItem(String name, String type, String statistic, String description) {
        this();
        this.name = name;
        this.type = type;
        this.statistic = statistic;
        this.description = description;
    }

    public Long getInGameItemID() {
        return inGameItemID;
    }

    public void setInGameItemID(Long inGameItemID) {
        this.inGameItemID = inGameItemID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inGameItemID != null ? inGameItemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the inGameItemID fields are not set
        if (!(object instanceof InGameItem)) {
            return false;
        }
        InGameItem other = (InGameItem) object;
        if ((this.inGameItemID == null && other.inGameItemID != null) || (this.inGameItemID != null && !this.inGameItemID.equals(other.inGameItemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entity.InGameItem[ id=" + inGameItemID + " ]";
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the statistic
     */
    public String getStatistic() {
        return statistic;
    }

    /**
     * @param statistic the statistic to set
     */
    public void setStatistic(String statistic) {
        this.statistic = statistic;
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

}
