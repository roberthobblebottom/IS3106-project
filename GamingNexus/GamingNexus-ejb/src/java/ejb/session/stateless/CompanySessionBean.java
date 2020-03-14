/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Company;
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
public class CompanySessionBean implements CompanySessionBeanLocal {

    @PersistenceContext(unitName = "GamingNexus-ejbPU")
    private EntityManager em;

    @Override
    public long createNewCompany(Company company) {
        em.persist(company);
        em.flush();
        return company.getUserID();
    }

    @Override
    public Company retrieveCompany(Company company) {
        Company retrievedCompany = em.find(Company.class, company.getUserID());
this.lazyLoadCompany(company);
        return retrievedCompany;

    }

    public List<Company> retrieveCompanies() {
        Query query = em.createQuery("SELECT c FROM Company c");
        List<Company> companies= query.getResultList();
        companies.forEach((company) -> {
            this.lazyLoadCompany(company);
        });
        return companies;
    
    }

    public void updateCompany(Company company) {
        Company companyTobeUpdated = em.find(Company.class, company.getUserID());
        companyTobeUpdated.setAddress(company.getAddress());
        companyTobeUpdated.setChats(company.getChats());
        companyTobeUpdated.setCountry(company.getCountry());
        companyTobeUpdated.setEmail(company.getEmail());
        companyTobeUpdated.setLastOnline(company.getLastOnline());
        companyTobeUpdated.setPassword(company.getPassword());
        companyTobeUpdated.setPhoneNumber(company.getPhoneNumber());
        companyTobeUpdated.setProducts(company.getProducts());
        companyTobeUpdated.setProfilePictureURL(company.getProfilePictureURL());
        companyTobeUpdated.setUsername(company.getUsername());

    }

    public void deleteCompany(Company company) {
        Company companyToBeDeleted = this.retrieveCompany(company);
        em.remove(companyToBeDeleted);
    }

    private void lazyLoadCompany(Company company) {
        company.getChats().size();
        company.getProducts();
    }
}
