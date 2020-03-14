/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the templat in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Software;
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
public class SoftwareSessionBean implements SoftwareSessionBeanLocal {

    @PersistenceContext(unitName = "GamingNexus-ejbPU")
    private EntityManager em;

    @Override
    public long createSoftware(Software software) {
        em.persist(software);
        em.flush();
        return software.getProductID();
    }

    @Override
    public Software retrieveSoftwareByID(long softwareID) {
        Software retrievedSoftware = em.find(Software.class, softwareID);
        this.lazyLoadSoftware(retrievedSoftware);
        return retrievedSoftware;
    }

    @Override
    public List<Software> retrieveAllSoftwares() {
        Query query = em.createQuery("SELECT s FROM Software s");
        List<Software> listOfSoftwares = query.getResultList();
        listOfSoftwares.forEach(software -> {
            this.lazyLoadSoftware(software);
        });
        return listOfSoftwares;
    }

    @Override
    public void updateSoftware(Software software){
    Software softwareToBeUpdated = em.find(Software.class, software.getProductID());
        softwareToBeUpdated.setAverageRating(0);
        softwareToBeUpdated.setCartItem(software.getCartItem());
        softwareToBeUpdated.setCompany(software.getCompany());
        softwareToBeUpdated.setComputerRequirements(software.getComputerRequirements());
        softwareToBeUpdated.setDescription(software.getDescription());
        softwareToBeUpdated.setName(software.getName());
        softwareToBeUpdated.setOwnedItems(software.getOwnedItems());
        softwareToBeUpdated.setPrice(software.getPrice());
        softwareToBeUpdated.setPromotions(software.getPromotions());
        softwareToBeUpdated.setRatings(software.getRatings());
        softwareToBeUpdated.setTags(software.getTags());
        
        
    }
    
    @Override
    public void deleteSoftware(Software software){
        Software softwareToBeDeleted = em.find(Software.class, software.getProductID());
        em.remove(softwareToBeDeleted);
    }
    
    public void lazyLoadSoftware(Software software) {
        software.getCartItem().size();
        software.getPromotions().size();
        software.getRatings().size();
        software.getTags().size();
        software.getOwnedItems().size();
    }
}
