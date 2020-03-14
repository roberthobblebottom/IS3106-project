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
import javax.persistence.Query;

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
        em.persist(customer);
        em.flush();
        return customer.getUserID();
    }

    @Override
    public List<Customer> retrieveAllCustomers() {
        Query query = em.createQuery("SELECT c FROM Customer c");
        List<Customer> customers = query.getResultList();
        customers.forEach(customer -> {
            this.lazyLoadCustomer(customer);
        });
        return customers;
    }

    @Override
    public Customer retrieveCustomerByID(long userID) {
        Customer customerToBeRetrieved = em.find(Customer.class, userID);
        this.lazyLoadCustomer(customerToBeRetrieved);
        return customerToBeRetrieved;
    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer customerToBeUpdated = this.retrieveCustomerByID(customer.getUserID());
        customerToBeUpdated.setAddress(customer.getAddress());
        customerToBeUpdated.setChats(customer.getChats());
        customerToBeUpdated.setCountry(customer.getCountry());
        customerToBeUpdated.setCurrentGamePlaying(customer.getCurrentGamePlaying());
        customerToBeUpdated.setCustomers(customer.getCustomers());
        customerToBeUpdated.setEmail(customer.getEmail());
        customerToBeUpdated.setGameAccounts(customer.getGameAccounts());
        customerToBeUpdated.setIsBanned(customer.isIsBanned());
        customerToBeUpdated.setLastOnline(customer.getLastOnline());
        customerToBeUpdated.setOwnedItems(customer.getOwnedItems());
        customerToBeUpdated.setPassword(customer.getPassword());
        customerToBeUpdated.setPhoneNumber(customer.getPhoneNumber());
        customerToBeUpdated.setProfilePictureURL(customer.getProfilePictureURL());
        customerToBeUpdated.setRatings(customer.getRatings());
        customerToBeUpdated.setSecurityAnswer(customer.getSecurityQuestion());
        customerToBeUpdated.setSecurityQuestion(customer.getSecurityQuestion());
        customerToBeUpdated.setShoppingCart(customer.getShoppingCart());
        customerToBeUpdated.setUnbanDate(customer.getUnbanDate());
        customerToBeUpdated.setUsername(customer.getUsername());
    }

    @Override
    public void deleteCustomer(long customerID) {
        Customer customerToBeDeleted = this.retrieveCustomerByID(customerID);
        em.remove(customerToBeDeleted);
    }

    private void lazyLoadCustomer(Customer customer) {
        customer.getChats().size();
        customer.getCustomers().size();
        customer.getGameAccounts().size();
        customer.getOwnedItems().size();
        customer.getRatings().size();

    }
}
