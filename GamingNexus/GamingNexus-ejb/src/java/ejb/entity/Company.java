/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author root
 */
@Entity
public class Company extends User implements Serializable {

    public Company() {
    }
  //TODO: Add relational mapping
    
}