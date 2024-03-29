/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
public class Forum implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long forumId;
    @NotNull
    @Size(min = 1, max = 50)
    private String forumName;
    @OneToOne
    private Game game;

    @OneToOne
    private Forum forum;
    @OneToMany(mappedBy = "Forum")
    private List<Message> messages;

    public Forum() {
    }

    public Forum(String forumName, Game game, Forum forum, List<Message> messages) {
        this();
        this.forumName = forumName;
        this.game = game;
        this.forum = forum;
        this.messages = messages;
    }


    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (forumId != null ? forumId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the forumId fields are not set
        if (!(object instanceof Forum)) {
            return false;
        }
        Forum other = (Forum) object;
        if ((this.forumId == null && other.forumId != null) || (this.forumId != null && !this.forumId.equals(other.forumId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entity.Forum[ id=" + forumId + " ]";
    }

    /**
     * @return the forumName
     */
    public String getForumName() {
        return forumName;
    }

    /**
     * @param forumName the forumName to set
     */
    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    /**
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * @param game the game to set
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * @return the forum
     */
    public Forum getForum() {
        return forum;
    }

    /**
     * @param forum the forum to set
     */
    public void setForum(Forum forum) {
        this.forum = forum;
    }

    /**
     * @return the messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}
