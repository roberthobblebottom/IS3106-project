/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import ejb.entity.Forum;
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
public class ForumSessionBean implements ForumSessionBeanLocal {
    
    @PersistenceContext(unitName = "GamingNexus-ejbPU")
    private EntityManager em;
    
    @Override
    public long createForum(Forum forum) {
        em.persist(forum);
        em.flush();
        return forum.getForumId();
    }
    
    @Override
    public List<Forum> retrieveForumsByGame(Game game) {
        Query query = em.createQuery("SELECT f FROM Forum f where f.game = :inputGame");
        query.setParameter("inputGame", game);
        List<Forum> forums = query.getResultList();
        forums.forEach((forum) -> {
            this.lazyLoadForum(forum);
        });
        return forums;
    }
    
    @Override
    public Forum retrieveForumByID(long forumID) {
        Forum forum = em.find(Forum.class, forumID);
        this.lazyLoadForum(forum);
        return forum;
    }
    
    @Override
    public void updateForum(Forum forum) {
        Forum forumToBeUpdated = em.find(Forum.class, forum.getForumId());
        forumToBeUpdated.setForumName(forum.getForumName());
        forumToBeUpdated.setGame(forum.getGame());
        forumToBeUpdated.setMessages(forum.getMessages());
        forumToBeUpdated.setForum(forum.getForum());
    }
    
    @Override
    public void deleteForum(Forum forum) {
        Forum forumToBeDeleted = em.find(Forum.class, forum.getForumId());
        em.remove(forumToBeDeleted);
    }

    public void lazyLoadForum(Forum forum) {
        forum.getMessages().size();
    }
}
