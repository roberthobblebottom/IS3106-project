/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Game;
import ejb.entity.GameAccount;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface GameAccountSessionBeanLocal {

    public List<GameAccount> retrieveAllGameAccountsByGame(Game game);

    public GameAccount retrieveGameAccountByID(long gameAccountID);

    public void updateGameAccount(GameAccount gameAccount);

    public void deletegameAccount(GameAccount gameAccount);
    
}
