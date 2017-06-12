/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Model encji window. Wygenerowany automatycznie.
 *
 * @author Łukasz Wojtas
 */
@Entity
@Table(name = "window")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Window.findAll", query = "SELECT w FROM Window w")
    , @NamedQuery(name = "Window.findById", query = "SELECT w FROM Window w WHERE w.id = :id")
    , @NamedQuery(name = "Window.findByStartDate", query = "SELECT w FROM Window w WHERE w.startDate = :startDate")
    , @NamedQuery(name = "Window.findByWindowTitle", query = "SELECT w FROM Window w WHERE w.windowTitle = :windowTitle")
    , @NamedQuery(name = "Window.findByFirstWindow", query = "SELECT w FROM Window w WHERE w.firstWindow = :firstWindow")})
public class Window implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "window_title")
    private String windowTitle;
    @Basic(optional = false)
    @Lob
    @Column(name = "print_screen")
    private byte[] printScreen;
    @Column(name = "first_window")
    private Short firstWindow;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "windowId")
    private Collection<MouseClick> mouseClickCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "windowId")
    private Collection<KeyboardClick> keyboardClickCollection;
    @JoinColumn(name = "workstation_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Workstation workstationId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "windowId")
    private Collection<MouseScroll> mouseScrollCollection;

    public Window() {
    }

    public Window(Integer id) {
        this.id = id;
    }

    public Window(Integer id, Date startDate, String windowTitle, byte[] printScreen) {
        this.id = id;
        this.startDate = startDate;
        this.windowTitle = windowTitle;
        this.printScreen = printScreen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getWindowTitle() {
        return windowTitle;
    }

    public void setWindowTitle(String windowTitle) {
        this.windowTitle = windowTitle;
    }

    public byte[] getPrintScreen() {
        return printScreen;
    }

    public void setPrintScreen(byte[] printScreen) {
        this.printScreen = printScreen;
    }

    public Short getFirstWindow() {
        return firstWindow;
    }

    public void setFirstWindow(Short firstWindow) {
        this.firstWindow = firstWindow;
    }

    @XmlTransient
    public Collection<MouseClick> getMouseClickCollection() {
        return mouseClickCollection;
    }

    public void setMouseClickCollection(Collection<MouseClick> mouseClickCollection) {
        this.mouseClickCollection = mouseClickCollection;
    }

    @XmlTransient
    public Collection<KeyboardClick> getKeyboardClickCollection() {
        return keyboardClickCollection;
    }

    public void setKeyboardClickCollection(Collection<KeyboardClick> keyboardClickCollection) {
        this.keyboardClickCollection = keyboardClickCollection;
    }

    public Workstation getWorkstationId() {
        return workstationId;
    }

    public void setWorkstationId(Workstation workstationId) {
        this.workstationId = workstationId;
    }

    @XmlTransient
    public Collection<MouseScroll> getMouseScrollCollection() {
        return mouseScrollCollection;
    }

    public void setMouseScrollCollection(Collection<MouseScroll> mouseScrollCollection) {
        this.mouseScrollCollection = mouseScrollCollection;
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
        if (!(object instanceof Window)) {
            return false;
        }
        Window other = (Window) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Window[ id=" + id + " ]";
    }

}
