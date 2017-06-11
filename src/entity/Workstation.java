/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Łukasz Wojtas
 */
@Entity
@Table(name = "workstation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workstation.findAll", query = "SELECT w FROM Workstation w")
    , @NamedQuery(name = "Workstation.findById", query = "SELECT w FROM Workstation w WHERE w.id = :id")
    , @NamedQuery(name = "Workstation.findByComputerName", query = "SELECT w FROM Workstation w WHERE w.computerName = :computerName")
    , @NamedQuery(name = "Workstation.findByUserDomain", query = "SELECT w FROM Workstation w WHERE w.userDomain = :userDomain")
    , @NamedQuery(name = "Workstation.findByUserName", query = "SELECT w FROM Workstation w WHERE w.userName = :userName")
    , @NamedQuery(name = "Workstation.findByMacAddress", query = "SELECT w FROM Workstation w WHERE w.macAddress = :macAddress")})
public class Workstation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "computer_name")
    private String computerName;
    @Column(name = "user_domain")
    private String userDomain;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "mac_address")
    private String macAddress;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "workstationId")
    private WorkstationAdditionalData workstationAdditionalData;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workstationId")
    private Collection<Window> windowCollection;

    public Workstation() {
    }

    public Workstation(Integer id) {
        this.id = id;
    }

    public Workstation(Integer id, String computerName) {
        this.id = id;
        this.computerName = computerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getUserDomain() {
        return userDomain;
    }

    public void setUserDomain(String userDomain) {
        this.userDomain = userDomain;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public WorkstationAdditionalData getWorkstationAdditionalData() {
        return workstationAdditionalData;
    }

    public void setWorkstationAdditionalData(WorkstationAdditionalData workstationAdditionalData) {
        this.workstationAdditionalData = workstationAdditionalData;
    }

    @XmlTransient
    public Collection<Window> getWindowCollection() {
        return windowCollection;
    }

    public void setWindowCollection(Collection<Window> windowCollection) {
        this.windowCollection = windowCollection;
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
        if (!(object instanceof Workstation)) {
            return false;
        }
        Workstation other = (Workstation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Workstation[ id=" + id + " ]";
    }
    
}
