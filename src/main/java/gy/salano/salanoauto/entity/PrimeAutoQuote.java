/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gy.salano.salanoauto.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Salano
 */
@Entity
@Table(name = "PRIME_AUTO_QUOTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrimeAutoQuote.findAll", query = "SELECT p FROM PrimeAutoQuote p")
    , @NamedQuery(name = "PrimeAutoQuote.findById", query = "SELECT p FROM PrimeAutoQuote p WHERE p.id = :id")
    , @NamedQuery(name = "PrimeAutoQuote.findByFirstName", query = "SELECT p FROM PrimeAutoQuote p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "PrimeAutoQuote.findByLastName", query = "SELECT p FROM PrimeAutoQuote p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "PrimeAutoQuote.findByPhone", query = "SELECT p FROM PrimeAutoQuote p WHERE p.phone = :phone")
    , @NamedQuery(name = "PrimeAutoQuote.findByEmail", query = "SELECT p FROM PrimeAutoQuote p WHERE p.email = :email")
    , @NamedQuery(name = "PrimeAutoQuote.findByText", query = "SELECT p FROM PrimeAutoQuote p WHERE p.text = :text")
    , @NamedQuery(name = "PrimeAutoQuote.findByQuoteDate", query = "SELECT p FROM PrimeAutoQuote p WHERE p.quoteDate = :quoteDate")
    , @NamedQuery(name = "PrimeAutoQuote.findByMake", query = "SELECT p FROM PrimeAutoQuote p WHERE p.make = :make")
    , @NamedQuery(name = "PrimeAutoQuote.findByModel", query = "SELECT p FROM PrimeAutoQuote p WHERE p.model = :model")
    , @NamedQuery(name = "PrimeAutoQuote.findByYearMade", query = "SELECT p FROM PrimeAutoQuote p WHERE p.yearMade = :yearMade")})
public class PrimeAutoQuote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 30)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 30)
    @Column(name = "LAST_NAME")
    private String lastName;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "PHONE")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 1000)
    @Column(name = "TEXT")
    private String text;
    @Column(name = "QUOTE_DATE")
    @Temporal(TemporalType.DATE)
    private Date quoteDate;
    @Size(max = 50)
    @Column(name = "MAKE")
    private String make;
    @Size(max = 50)
    @Column(name = "MODEL")
    private String model;
    @Size(max = 4)
    @Column(name = "YEAR_MADE")
    private String yearMade;

    public PrimeAutoQuote() {
    }

    public PrimeAutoQuote(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getQuoteDate() {
        return quoteDate;
    }

    public void setQuoteDate(Date quoteDate) {
        this.quoteDate = quoteDate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrimeAutoQuote)) {
            return false;
        }
        PrimeAutoQuote other = (PrimeAutoQuote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gy.salano.salanoauto.bean.PrimeAutoQuote[ id=" + id + " ]";
    }
    
}
