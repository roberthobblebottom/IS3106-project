/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Deliverables;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DeliverablesSessionBeanLocal {

    public long createNewDeliverables(Deliverables deliverables);

    public Deliverables retrievedByDeliverablesID(long deliverablesID);
    
}
