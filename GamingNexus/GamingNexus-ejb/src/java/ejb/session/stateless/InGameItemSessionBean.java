/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.InGameItem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class InGameItemSessionBean implements InGameItemSessionBeanLocal {

    @PersistenceContext(unitName = "GamingNexus-ejbPU")
    private EntityManager em;

    @Override
    public long createNewInGameItem(InGameItem inGameItem) {
        em.persist(inGameItem);
        em.flush();
        return inGameItem.getInGameItemID();
    }

    @Override
    public InGameItem retrieveInGameItemByID(long inGameItemID) {
        InGameItem inGameItem = em.find(InGameItem.class, inGameItemID);
        this.lazyLoadInGameItem(inGameItem);
        return inGameItem;
    }

    @Override
    public void updateInGameItem(InGameItem inGameItem) {
        InGameItem itemToBeUpdated = em.find(InGameItem.class, inGameItem.getInGameItemID());
        itemToBeUpdated.setDescription(inGameItem.getDescription());
        itemToBeUpdated.setGame(inGameItem.getGame());
        itemToBeUpdated.setDescription(inGameItem.getDescription());
        itemToBeUpdated.setItemInstances(inGameItem.getItemInstances());
        itemToBeUpdated.setName(inGameItem.getName());
        itemToBeUpdated.setStatistic(inGameItem.getStatistic());
        itemToBeUpdated.setType(inGameItem.getType());

    }

    @Override
    public void deleteInGameItem(InGameItem inGameItem) {
        InGameItem inGameItemToBeDeleted = em.find(InGameItem.class, inGameItem.getInGameItemID());
        em.remove(inGameItemToBeDeleted);
    }

    public void lazyLoadInGameItem(InGameItem inGameItem) {
        inGameItem.getItemInstances().size();
    }

}
