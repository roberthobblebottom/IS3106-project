/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Deliverables;
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
    public Deliverables retrievedByDeliverablesID(long deliverablesID) {
        Deliverables deliverables = em.find(Deliverables.class, deliverablesID);
        this.lazyLoadDeliverables(deliverables);
        return deliverables;
    }

    public void updateDeliverables(Deliverables deliverables) {
        Deliverables deliverablesToBeUpdated = this.retrievedByDeliverablesID(deliverables.getDeliverablesID());
        deliverablesToBeUpdated.setCustomers(deliverables.getCustomers());
        deliverablesToBeUpdated.setDeliveryManPhoneNumber(deliverables.getDeliveryManPhoneNumber());
        deliverablesToBeUpdated.setExpectedDateOfArrival(deliverables.getExpectedDateOfArrival());
        deliverablesToBeUpdated.setHardwares(deliverables.getHardwares());
        deliverablesToBeUpdated.setHasArrived(deliverables.isHasArrived());
    }

    private void lazyLoadDeliverables(Deliverables deliverables) {
        deliverables.getHardwares().size();
        deliverables.getCustomers().size();

    }

}
