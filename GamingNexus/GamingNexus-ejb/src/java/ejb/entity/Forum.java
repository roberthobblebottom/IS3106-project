/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    //TODO: Add relational mapping

    public Forum() {
    }

    public Forum(String forumName) {
        this();
        this.forumName = forumName;
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

}
