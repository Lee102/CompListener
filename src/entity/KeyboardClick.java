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
 * Model encji keyboard_click. Wygenerowany automatycznie.
 *
 * @author Łukasz Wojtas
 */
@Entity
@Table(name = "keyboard_click")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KeyboardClick.findAll", query = "SELECT k FROM KeyboardClick k")
    , @NamedQuery(name = "KeyboardClick.findById", query = "SELECT k FROM KeyboardClick k WHERE k.id = :id")
    , @NamedQuery(name = "KeyboardClick.findByKeyText", query = "SELECT k FROM KeyboardClick k WHERE k.keyText = :keyText")
    , @NamedQuery(name = "KeyboardClick.findByTime", query = "SELECT k FROM KeyboardClick k WHERE k.time = :time")})
public class KeyboardClick implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "key_text")
    private String keyText;
    @Basic(optional = false)
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @JoinColumn(name = "window_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Window windowId;

    public KeyboardClick() {
    }

    public KeyboardClick(Integer id) {
        this.id = id;
    }

    public KeyboardClick(Integer id, String keyText, Date time) {
        this.id = id;
        this.keyText = keyText;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyText() {
        return keyText;
    }

    public void setKeyText(String keyText) {
        this.keyText = keyText;
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
        if (!(object instanceof KeyboardClick)) {
            return false;
        }
        KeyboardClick other = (KeyboardClick) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KeyboardClick[ id=" + id + " ]";
    }

}
