/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Customer;
import ejb.entity.Deliverables;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DeliverablesSessionBean implements DeliverablesSessionBeanLocal {

    @PersistenceContext(unitName = "GamingNexus-ejbPU")
    private EntityManager em;

    @Override
    public long createNewDeliverables(Deliverables deliverables) {
        em.persist(deliverables);
        em.flush();
        return deliverables.getDeliverablesID();
    }

    @Override 
    public List<Deliverables> retrieveAllDeliverablesByCustomer(Customer customer){
    Query query = em.createQuery("SELECT d FROM Deliverables d WHERE d.customers")
    }
    
    
    
    
}
