/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
public class Game extends Product implements Serializable {

    @NotNull
    @Size(min = 1, max = 5)
    private String parentAdvisory;
    private List<String> gamePicturesURLs;
    private List<String> gameTrailersURLS;
    //TODO: Add relational mapping

    public Game() {
        super();
    }

    public Game(String parentAdvisory, List<String> gamePictures,
            List<String> gameTrailers, String name, String description,
            String computerRequirements, double price, double averageRating, List<String> tags) {
        super(name, description, computerRequirements, price, averageRating, tags);
        this.parentAdvisory = parentAdvisory;
        this.gamePicturesURLs = gamePictures;
        this.gameTrailersURLS = gameTrailers;
    }

    /**
     * @return the parentAdvisory
     */
    public String getParentAdvisory() {
        return parentAdvisory;
    }

    /**
     * @param parentAdvisory the parentAdvisory to set
     */
    public void setParentAdvisory(String parentAdvisory) {
        this.parentAdvisory = parentAdvisory;
    }

    /**
     * @return the gamePicturesURLs
     */
    public List<String> getGamePicturesURLs() {
        return gamePicturesURLs;
    }

    /**
     * @param gamePicturesURLs the gamePicturesURLs to set
     */
    public void setGamePicturesURLs(List<String> gamePicturesURLs) {
        this.gamePicturesURLs = gamePicturesURLs;
    }

    /**
     * @return the gameTrailersURLS
     */
    public List<String> getGameTrailersURLS() {
        return gameTrailersURLS;
    }

    /**
     * @param gameTrailersURLS the gameTrailersURLS to set
     */
    public void setGameTrailersURLS(List<String> gameTrailersURLS) {
        this.gameTrailersURLS = gameTrailersURLS;
    }
}
