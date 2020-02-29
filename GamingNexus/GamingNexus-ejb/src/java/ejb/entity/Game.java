/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.sql.rowset.serial.SerialBlob;
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
    private List<SerialBlob> gamePictures;
    private List<SerialBlob> gameTrailers;
    //TODO: Add relational mapping

    public Game() {
        super();
    }

    public Game(String parentAdvisory, List<SerialBlob> gamePictures,
            List<SerialBlob> gameTrailers, String name, String description,
            String computerRequirements, double price, double averageRating, List<String> tags) {
        super(name, description, computerRequirements, price, averageRating, tags);
        this.parentAdvisory = parentAdvisory;
        this.gamePictures = gamePictures;
        this.gameTrailers = gameTrailers;
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
     * @return the gamePictures
     */
    public List<SerialBlob> getGamePictures() {
        return gamePictures;
    }

    /**
     * @param gamePictures the gamePictures to set
     */
    public void setGamePictures(List<SerialBlob> gamePictures) {
        this.gamePictures = gamePictures;
    }

    /**
     * @return the gameTrailers
     */
    public List<SerialBlob> getGameTrailers() {
        return gameTrailers;
    }

    /**
     * @param gameTrailers the gameTrailers to set
     */
    public void setGameTrailers(List<SerialBlob> gameTrailers) {
        this.gameTrailers = gameTrailers;
    }
}
