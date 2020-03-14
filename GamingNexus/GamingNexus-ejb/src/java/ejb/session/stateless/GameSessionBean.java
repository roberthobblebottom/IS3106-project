/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Game;
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
public class GameSessionBean implements GameSessionBeanLocal {
    
    @PersistenceContext(unitName = "GamingNexus-ejbPU")
    private EntityManager em;
    
    public long createNewGame(Game game) {
        em.persist(game);
        em.flush();
        return game.getProductID();
    }
    
    @Override
    public List<Game> retrieveAllGames() {
        Query query = em.createQuery("SELECT g FROM Game g");
        List<Game> games = query.getResultList();
        games.forEach(game -> {
            this.lazyLoadGame(game);
        });
        return games;
        
    }
    
    @Override
    public Game retrieveGameById(long gameID) {
        return em.find(Game.class, gameID);
    }
    
    @Override
    public void UpdateGame(Game game) {
        Game gameToBeUpdated = em.find(Game.class, game.getProductID());
        gameToBeUpdated.setAverageRating(0);
        gameToBeUpdated.setCartItem(game.getCartItem());
        gameToBeUpdated.setCompany(game.getCompany());
        gameToBeUpdated.setComputerRequirements(game.getComputerRequirements());
        gameToBeUpdated.setDescription(game.getDescription());
        gameToBeUpdated.setForums(game.getForums());
        gameToBeUpdated.setGameAccounts(game.getGameAccounts());
        gameToBeUpdated.setGamePicturesURLs(game.getGamePicturesURLs());
        gameToBeUpdated.setGameTrailersURLS(game.getGameTrailersURLS());
        gameToBeUpdated.setName(game.getName());
        gameToBeUpdated.setOwnedItems(game.getOwnedItems());
        gameToBeUpdated.setParentAdvisory(game.getParentAdvisory());
        gameToBeUpdated.setPrice(game.getPrice());
        gameToBeUpdated.setPromotions(game.getPromotions());
        gameToBeUpdated.setRatings(game.getRatings());
        gameToBeUpdated.setTags(game.getTags());
    }
    
    @Override
    public void deletedGame(Game game) {
        Game gameToBeDeleted = em.find(Game.class, game.getProductID());
        em.remove(gameToBeDeleted);
    }
    
    public void lazyLoadGame(Game game) {
        game.getCartItem().size();
        game.getForums().size();
        game.getGameAccounts().size();
        game.getGamePicturesURLs().size();
        game.getGameTrailersURLS().size();
        game.getInGameItems().size();
        game.getOwnedItems().size();
        game.getPromotions().size();
        game.getRatings().size();
        game.getTags().size();
        
    }
}
