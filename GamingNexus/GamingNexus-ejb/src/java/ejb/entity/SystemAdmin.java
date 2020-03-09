/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;

/**
 *
 * @author root
 */
@Entity
public class SystemAdmin extends User implements Serializable {
private String adminType;

    public SystemAdmin() {
    }

    public SystemAdmin(String adminType, int phoneNumber, String address, String email, String country, String username, String password, String profilePictureURL, Date lastOnline) {
        super(phoneNumber, address, email, country, username, password, profilePictureURL, lastOnline);
        this.adminType = adminType;
    }
    
    

    /**
     * @return the adminType
     */
    public String getAdminType() {
        return adminType;
    }

    /**
     * @param adminType the adminType to set
     */
    public void setAdminType(String adminType) {
        this.adminType = adminType;
    }

  
}
