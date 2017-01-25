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
@Table(name = "PRIME_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrimeUser.findAll", query = "SELECT p FROM PrimeUser p")
    , @NamedQuery(name = "PrimeUser.findById", query = "SELECT p FROM PrimeUser p WHERE p.id = :id")
    , @NamedQuery(name = "PrimeUser.findByFirstName", query = "SELECT p FROM PrimeUser p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "PrimeUser.findByLastName", query = "SELECT p FROM PrimeUser p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "PrimeUser.findByAge", query = "SELECT p FROM PrimeUser p WHERE p.age = :age")
    , @NamedQuery(name = "PrimeUser.findByEmail", query = "SELECT p FROM PrimeUser p WHERE p.email = :email")
    , @NamedQuery(name = "PrimeUser.findByEmailNotification", query = "SELECT p FROM PrimeUser p WHERE p.emailNotification = :emailNotification")
    , @NamedQuery(name = "PrimeUser.findByEnableNotification", query = "SELECT p FROM PrimeUser p WHERE p.enableNotification = :enableNotification")
    , @NamedQuery(name = "PrimeUser.findByNewsletter", query = "SELECT p FROM PrimeUser p WHERE p.newsletter = :newsletter")})
public class PrimeUser implements Serializable {

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
    @Column(name = "AGE")
    private Integer age;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "EMAIL_NOTIFICATION")
    private Integer emailNotification;
    @Column(name = "ENABLE_NOTIFICATION")
    private Integer enableNotification;
    @Column(name = "NEWSLETTER")
    private Integer newsletter;

    public PrimeUser() {
    }

    public PrimeUser(Integer id) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(Integer emailNotification) {
        this.emailNotification = emailNotification;
    }

    public Integer getEnableNotification() {
        return enableNotification;
    }

    public void setEnableNotification(Integer enableNotification) {
        this.enableNotification = enableNotification;
    }

    public Integer getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Integer newsletter) {
        this.newsletter = newsletter;
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
        if (!(object instanceof PrimeUser)) {
            return false;
        }
        PrimeUser other = (PrimeUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gy.salano.salanoauto.entity.PrimeUser[ id=" + id + " ]";
    }
    
}
