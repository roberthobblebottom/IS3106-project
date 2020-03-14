/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.InGameItem;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface InGameItemSessionBeanLocal {

    public void deleteInGameItem(InGameItem inGameItem);

    public void updateInGameItem(InGameItem inGameItem);

    public InGameItem retrieveInGameItemByID(long inGameItemID);

    public long createNewInGameItem(InGameItem inGameItem);
    
}
