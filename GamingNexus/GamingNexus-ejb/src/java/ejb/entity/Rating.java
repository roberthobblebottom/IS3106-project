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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
public class Rating implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingID;
    @NotNull
    @Min(0)
    @Max(5)
    @Digits(integer = 1, fraction = 0)
    private int rating;
    @NotNull
    @Size(min = 0, max = 5000)
    private String Review;
    @NotNull
    @Past
    private Date dateOfReview;
    //TODO: Add relational mapping

    public Long getRatingID() {
        return ratingID;
    }

    public void setRatingID(Long ratingID) {
        this.ratingID = ratingID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratingID != null ? ratingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the ratingID fields are not set
        if (!(object instanceof Rating)) {
            return false;
        }
        Rating other = (Rating) object;
        if ((this.ratingID == null && other.ratingID != null) || (this.ratingID != null && !this.ratingID.equals(other.ratingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entity.Rating[ id=" + ratingID + " ]";
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @return the Review
     */
    public String getReview() {
        return Review;
    }

    /**
     * @param Review the Review to set
     */
    public void setReview(String Review) {
        this.Review = Review;
    }

    /**
     * @return the dateOfReview
     */
    public Date getDateOfReview() {
        return dateOfReview;
    }

    /**
     * @param dateOfReview the dateOfReview to set
     */
    public void setDateOfReview(Date dateOfReview) {
        this.dateOfReview = dateOfReview;
    }

}
