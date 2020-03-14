/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Company;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface CompanySessionBeanLocal {

    public long createNewCompany(Company company);

    public Company retrieveCompany(Company company);
    
}
