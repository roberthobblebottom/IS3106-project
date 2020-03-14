/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Customer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface CustomerSessionBeanLocal {

    List<Customer> retrieveAllCustomers();

    public Long createNewCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public Customer retrieveCustomerByID(long customerID);

    public void deleteCustomer(long customerID);
    
}
