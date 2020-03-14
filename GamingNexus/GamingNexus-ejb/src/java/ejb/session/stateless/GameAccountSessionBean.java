/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Game;
import ejb.entity.GameAccount;
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
public class GameAccountSessionBean implements GameAccountSessionBeanLocal {
    
    @PersistenceContext(unitName = "GamingNexus-ejbPU")
    private EntityManager em;
    
    public long createNewGameAccount(GameAccount gameAccount) {
        em.persist(gameAccount);
        em.flush();
        return gameAccount.getGameAccountID();
    }
    
    @Override
    public List<GameAccount> retrieveAllGameAccountsByGame(Game game) {
        Query query = em.createQuery("SELECT g FROM GameAccount g WHERE g.game=:inputGame");
        query.setParameter("inputGame", game);
        
        List<GameAccount> gameAccounts = query.getResultList();
        return gameAccounts;
    }
    
    @Override
    public GameAccount retrieveGameAccountByID(long gameAccountID) {
        return em.find(GameAccount.class, gameAccountID);
    }
    
    @Override
    public void updateGameAccount(GameAccount gameAccount) {
        GameAccount gameAccountToUpdate = em.find(GameAccount.class, gameAccount);
        gameAccountToUpdate.setCustomer(gameAccount.getCustomer());
        gameAccountToUpdate.setDateOfCreation(gameAccount.getDateOfCreation());
        gameAccountToUpdate.setGame(gameAccount.getGame());
        gameAccountToUpdate.setUsername(gameAccount.getUsername());
    }
    
    @Override
    public void deletegameAccount(GameAccount gameAccount) {
        GameAccount accountToBeRemoved = em.find(GameAccount.class, gameAccount.getGameAccountID());
        em.remove(accountToBeRemoved);
    }
}
