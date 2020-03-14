/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Game;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface GameSessionBeanLocal {

    public long createNewGame(Game game);

    public List<Game> retrieveAllGames();

    public Game retrieveGameById(long gameID);

    public void UpdateGame(Game game);

    public void deletedGame(Game game);
    
}
