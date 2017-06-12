/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model encji workstation_additional_data. Wygenerowany automatycznie.
 *
 * @author Łukasz Wojtas
 */
@Entity
@Table(name = "workstation_additional_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkstationAdditionalData.findAll", query = "SELECT w FROM WorkstationAdditionalData w")
    , @NamedQuery(name = "WorkstationAdditionalData.findById", query = "SELECT w FROM WorkstationAdditionalData w WHERE w.id = :id")
    , @NamedQuery(name = "WorkstationAdditionalData.findByOsVersion", query = "SELECT w FROM WorkstationAdditionalData w WHERE w.osVersion = :osVersion")
    , @NamedQuery(name = "WorkstationAdditionalData.findByOsArch", query = "SELECT w FROM WorkstationAdditionalData w WHERE w.osArch = :osArch")
    , @NamedQuery(name = "WorkstationAdditionalData.findByJavaVersion", query = "SELECT w FROM WorkstationAdditionalData w WHERE w.javaVersion = :javaVersion")
    , @NamedQuery(name = "WorkstationAdditionalData.findByProcId", query = "SELECT w FROM WorkstationAdditionalData w WHERE w.procId = :procId")
    , @NamedQuery(name = "WorkstationAdditionalData.findByProcArch", query = "SELECT w FROM WorkstationAdditionalData w WHERE w.procArch = :procArch")
    , @NamedQuery(name = "WorkstationAdditionalData.findByProcCores", query = "SELECT w FROM WorkstationAdditionalData w WHERE w.procCores = :procCores")
    , @NamedQuery(name = "WorkstationAdditionalData.findByRamSize", query = "SELECT w FROM WorkstationAdditionalData w WHERE w.ramSize = :ramSize")
    , @NamedQuery(name = "WorkstationAdditionalData.findByDiskSize", query = "SELECT w FROM WorkstationAdditionalData w WHERE w.diskSize = :diskSize")})
public class WorkstationAdditionalData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "os_version")
    private String osVersion;
    @Column(name = "os_arch")
    private String osArch;
    @Basic(optional = false)
    @Column(name = "java_version")
    private String javaVersion;
    @Column(name = "proc_id")
    private String procId;
    @Column(name = "proc_arch")
    private String procArch;
    @Column(name = "proc_cores")
    private Integer procCores;
    @Column(name = "ram_size")
    private Integer ramSize;
    @Column(name = "disk_size")
    private Integer diskSize;
    @JoinColumn(name = "workstation_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Workstation workstationId;

    public WorkstationAdditionalData() {
    }

    public WorkstationAdditionalData(Integer id) {
        this.id = id;
    }

    public WorkstationAdditionalData(Integer id, String osVersion, String javaVersion) {
        this.id = id;
        this.osVersion = osVersion;
        this.javaVersion = javaVersion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getOsArch() {
        return osArch;
    }

    public void setOsArch(String osArch) {
        this.osArch = osArch;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public String getProcId() {
        return procId;
    }

    public void setProcId(String procId) {
        this.procId = procId;
    }

    public String getProcArch() {
        return procArch;
    }

    public void setProcArch(String procArch) {
        this.procArch = procArch;
    }

    public Integer getProcCores() {
        return procCores;
    }

    public void setProcCores(Integer procCores) {
        this.procCores = procCores;
    }

    public Integer getRamSize() {
        return ramSize;
    }

    public void setRamSize(Integer ramSize) {
        this.ramSize = ramSize;
    }

    public Integer getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(Integer diskSize) {
        this.diskSize = diskSize;
    }

    public Workstation getWorkstationId() {
        return workstationId;
    }

    public void setWorkstationId(Workstation workstationId) {
        this.workstationId = workstationId;
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
        if (!(object instanceof WorkstationAdditionalData)) {
            return false;
        }
        WorkstationAdditionalData other = (WorkstationAdditionalData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WorkstationAdditionalData[ id=" + id + " ]";
    }

}
