/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Hardware;
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
public class HardwareSessionBean implements HardwareSessionBeanLocal {

    @PersistenceContext(unitName = "GamingNexus-ejbPU")
    private EntityManager em;

    @Override
    public long createNewHardware(Hardware hardware) {
        em.persist(hardware);
        em.flush();
        return hardware.getProductID();
    }

    @Override
    public Hardware retrieveHardwareByID(long hardwareID) {
        Hardware hardware = em.find(Hardware.class, hardwareID);
        this.lazyLoadHardware(hardware);
        return hardware;
    }

    @Override
    public List<Hardware> retrieveAllHardware() {
        Query query = em.createQuery("SELECT h FROM Hardware h");
        List<Hardware> hardwares = query.getResultList();
        hardwares.forEach(hardware -> {
            this.lazyLoadHardware(hardware);
        });
        return hardwares;
    }

    @Override
    public void updateHardware(Hardware hardware) {
        Hardware hardwareToBeUpdated = em.find(Hardware.class, hardware.getProductID());
        hardwareToBeUpdated.setAverageRating(0);
        hardwareToBeUpdated.setCartItem(hardware.getCartItem());
        hardwareToBeUpdated.setCompany(hardware.getCompany());
        hardwareToBeUpdated.setComputerRequirements(hardware.getComputerRequirements());
        hardwareToBeUpdated.setDescription(hardware.getDescription());
        hardwareToBeUpdated.setName(hardware.getName());
        hardwareToBeUpdated.setOwnedItems(hardware.getOwnedItems());
        hardwareToBeUpdated.setPrice(hardware.getPrice());
        hardwareToBeUpdated.setPromotions(hardware.getPromotions());
        hardwareToBeUpdated.setRatings(hardware.getRatings());
        hardwareToBeUpdated.setTags(hardware.getTags());
        hardwareToBeUpdated.setDeliverables(hardware.getDeliverables());
        hardwareToBeUpdated.setWarrentyDescription(hardware.getWarrentyDescription());
        hardwareToBeUpdated.setTechnicalspecification(hardware.getTechnicalspecification());
        hardwareToBeUpdated.setDeliveryFirm(hardware.getDeliveryFirm());
    }

    @Override
    public void deleteHardware(Hardware hardware) {
        Hardware hardwareToBeDeleted = em.find(Hardware.class, hardware.getProductID());
        em.remove(hardwareToBeDeleted);
    }

    public void lazyLoadHardware(Hardware hardware) {
        hardware.getCartItem().size();
        hardware.getDeliverables().size();
        hardware.getPromotions().size();
        hardware.getRatings().size();
        hardware.getTags().size();
        hardware.getOwnedItems().size();

    }
}
