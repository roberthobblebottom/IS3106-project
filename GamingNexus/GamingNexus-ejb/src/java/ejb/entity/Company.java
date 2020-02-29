/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author root
 */
@Entity
public class Company extends User implements Serializable {
    //TODO: Add relational mapping

    
    public Company() {
        super();
    }

    public Company(int phoneNumber, String address, String email, String country, String username, String password, SerialBlob profilePicture, Date lastOnline) {
        super(phoneNumber, address, email, country, username, password, profilePicture, lastOnline);
    }

}
