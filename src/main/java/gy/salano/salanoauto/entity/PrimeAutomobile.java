/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gy.salano.salanoauto.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Salano
 */
@Entity
@Table(name = "PRIME_AUTOMOBILE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrimeAutomobile.findAll", query = "SELECT p FROM PrimeAutomobile p")
    , @NamedQuery(name = "PrimeAutomobile.findById", query = "SELECT p FROM PrimeAutomobile p WHERE p.id = :id")
    , @NamedQuery(name = "PrimeAutomobile.findByMake", query = "SELECT p FROM PrimeAutomobile p WHERE p.make = :make")
    , @NamedQuery(name = "PrimeAutomobile.findByModel", query = "SELECT p FROM PrimeAutomobile p WHERE p.model = :model")
    , @NamedQuery(name = "PrimeAutomobile.findByYearMade", query = "SELECT p FROM PrimeAutomobile p WHERE p.yearMade = :yearMade")
    , @NamedQuery(name = "PrimeAutomobile.findByDescription", query = "SELECT p FROM PrimeAutomobile p WHERE p.description = :description")})
public class PrimeAutomobile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MAKE")
    private String make;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MODEL")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "YEAR_MADE")
    private String yearMade;
    @Size(max = 1000)
    @Column(name = "DESCRIPTION")
    private String description;

    public PrimeAutomobile() {
    }

    public PrimeAutomobile(Integer id) {
        this.id = id;
    }

    public PrimeAutomobile(Integer id, String make, String model, String yearMade) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.yearMade = yearMade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYearMade() {
        return yearMade;
    }

    public void setYearMade(String yearMade) {
        this.yearMade = yearMade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof PrimeAutomobile)) {
            return false;
        }
        PrimeAutomobile other = (PrimeAutomobile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gy.salano.salanoauto.entity.PrimeAutomobile[ id=" + id + " ]";
    }
    
}
