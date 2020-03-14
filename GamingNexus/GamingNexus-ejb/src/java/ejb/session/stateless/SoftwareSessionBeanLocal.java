/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Software;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface SoftwareSessionBeanLocal {

    public long createSoftware(Software software);

    public Software retrieveSoftwareByID(long softwareID);

    public List<Software> retrieveAllSoftwares();

    public void deleteSoftware(Software software);

    public void updateSoftware(Software software);
    
}
