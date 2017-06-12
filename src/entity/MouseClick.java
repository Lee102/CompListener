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
 * Model encji mouse_click. Wygenerowany automatycznie.
 *
 * @author Łukasz Wojtas
 */
@Entity
@Table(name = "mouse_click")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MouseClick.findAll", query = "SELECT m FROM MouseClick m")
    , @NamedQuery(name = "MouseClick.findById", query = "SELECT m FROM MouseClick m WHERE m.id = :id")
    , @NamedQuery(name = "MouseClick.findByButton", query = "SELECT m FROM MouseClick m WHERE m.button = :button")
    , @NamedQuery(name = "MouseClick.findByX", query = "SELECT m FROM MouseClick m WHERE m.x = :x")
    , @NamedQuery(name = "MouseClick.findByY", query = "SELECT m FROM MouseClick m WHERE m.y = :y")
    , @NamedQuery(name = "MouseClick.findByTime", query = "SELECT m FROM MouseClick m WHERE m.time = :time")})
public class MouseClick implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "button")
    private int button;
    @Basic(optional = false)
    @Column(name = "x")
    private int x;
    @Basic(optional = false)
    @Column(name = "y")
    private int y;
    @Basic(optional = false)
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @JoinColumn(name = "window_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Window windowId;

    public MouseClick() {
    }

    public MouseClick(Integer id) {
        this.id = id;
    }

    public MouseClick(Integer id, int button, int x, int y, Date time) {
        this.id = id;
        this.button = button;
        this.x = x;
        this.y = y;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getButton() {
        return button;
    }

    public void setButton(int button) {
        this.button = button;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
        if (!(object instanceof MouseClick)) {
            return false;
        }
        MouseClick other = (MouseClick) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MouseClick[ id=" + id + " ]";
    }

}
