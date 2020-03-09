/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class CustomerSessionBean implements CustomerSessionBeanLocal {

    @PersistenceContext(unitName = "GamingNexus-ejbPU")
    private EntityManager em;


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public CustomerSessionBean() {
    }

    @Override
    public Long createNewCustomer(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> retrieveAllCustomers() {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }
    

}
