/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author root
 */
@Entity
public class Company extends User implements Serializable {

    @OneToMany(mappedBy="Company")
    private List<Product> products;
    @OneToMany(mappedBy="Company")
    private List<Chat> chats;

    public Company() {
        super();
    }

    public Company(List<Product> products, int phoneNumber, String address, String email, String country, String username, String password, SerialBlob profilePicture, Date lastOnline,List<Chat> chats) {
        super(phoneNumber, address, email, country, username, password, profilePicture, lastOnline);
        this.products = products;
        this.chats=chats;
    }

    /**
     * @return the products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return the chats
     */
    public List<Chat> getChats() {
        return chats;
    }

    /**
     * @param chats the chats to set
     */
    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }

}
