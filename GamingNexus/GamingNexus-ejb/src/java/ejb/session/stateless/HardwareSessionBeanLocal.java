/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Hardware;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface HardwareSessionBeanLocal {

    public long createNewHardware(Hardware hardware);

    public Hardware retrieveHardwareByID(long hardwareID);

    public List<Hardware> retrieveAllHardware();

    public void updateHardware(Hardware hardware);

    public void deleteHardware(Hardware hardware);
    
}
