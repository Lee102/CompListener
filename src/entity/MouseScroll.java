/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Łukasz Wojtas
 */
@Entity
@Table(name = "mouse_scroll")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MouseScroll.findAll", query = "SELECT m FROM MouseScroll m")
    , @NamedQuery(name = "MouseScroll.findById", query = "SELECT m FROM MouseScroll m WHERE m.id = :id")
    , @NamedQuery(name = "MouseScroll.findByDirection", query = "SELECT m FROM MouseScroll m WHERE m.direction = :direction")
    , @NamedQuery(name = "MouseScroll.findByTime", query = "SELECT m FROM MouseScroll m WHERE m.time = :time")})
public class MouseScroll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "direction")
    private int direction;
    @Basic(optional = false)
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @JoinColumn(name = "window_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Window windowId;

    public MouseScroll() {
    }

    public MouseScroll(Integer id) {
        this.id = id;
    }

    public MouseScroll(Integer id, int direction, Date time) {
        this.id = id;
        this.direction = direction;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Window getWindowId() {
        return windowId;
    }

    public void setWindowId(Window windowId) {
        this.windowId = windowId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MouseScroll)) {
            return false;
        }
        MouseScroll other = (MouseScroll) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MouseScroll[ id=" + id + " ]";
    }
    
}
