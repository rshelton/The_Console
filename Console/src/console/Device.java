/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package console;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author rshelton
 */
@Entity
@Table(name = "Device", catalog = "Console", schema = "")
@NamedQueries({@NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d"), @NamedQuery(name = "Device.findByName", query = "SELECT d FROM Device d WHERE d.name = :name"), @NamedQuery(name = "Device.findByLocation", query = "SELECT d FROM Device d WHERE d.location = :location"), @NamedQuery(name = "Device.findByIp", query = "SELECT d FROM Device d WHERE d.ip = :ip"), @NamedQuery(name = "Device.findByStatus", query = "SELECT d FROM Device d WHERE d.status = :status"), @NamedQuery(name = "Device.findByKey", query = "SELECT d FROM Device d WHERE d.key = :key")})
public class Device implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "LOCATION")
    private String location;
    @Basic(optional = false)
    @Column(name = "IP")
    private String ip;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private String status;
    @Id
    @Basic(optional = false)
    @Column(name = "KEY")
    private String key;

    public Device() {
    }

    public Device(String key) {
        this.key = key;
    }

    public Device(String key, String name, String location, String ip, String status) {
        this.key = key;
        this.name = name;
        this.location = location;
        this.ip = ip;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        String oldLocation = this.location;
        this.location = location;
        changeSupport.firePropertyChange("location", oldLocation, location);
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        String oldIp = this.ip;
        this.ip = ip;
        changeSupport.firePropertyChange("ip", oldIp, ip);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        String oldKey = this.key;
        this.key = key;
        changeSupport.firePropertyChange("key", oldKey, key);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (key != null ? key.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.key == null && other.key != null) || (this.key != null && !this.key.equals(other.key))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "console.Device[key=" + key + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
