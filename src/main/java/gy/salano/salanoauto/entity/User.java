/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gy.salano.salanoauto.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Salano
 */
@Entity
@Table(name = "PRIME_USER")
public class User {

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the newsletter
     */
    public Boolean getNewsletter() {
        return newsletter;
    }

    /**
     * @param newsletter the newsletter to set
     */
    public void setNewsletter(Boolean newsletter) {
        this.newsletter = newsletter;
    }

    /**
     * @return the emailNotification
     */
    public Boolean getEmailNotification() {
        return emailNotification;
    }

    /**
     * @param emailNotification the emailNotification to set
     */
    public void setEmailNotification(Boolean emailNotification) {
        this.emailNotification = emailNotification;
    }

    /**
     * @return the enableNotification
     */
    public Boolean getEnableNotification() {
        return enableNotification;
    }

    /**
     * @param enableNotification the enableNotification to set
     */
    public void setEnableNotification(Boolean enableNotification) {
        this.enableNotification = enableNotification;
    }

    public User() {
    }
    @Id @GeneratedValue
    private BigDecimal id;
    @Size(min=2, message="You must specify a valid first name")
    @Column(name = "first_name")
    private String firstname;
     @Size(min=2, message="You must specify a valid last name")
    @Column(name = "last_name")
    private String lastname;
     @Min(value=18, message="You must be over 18 years of age")
    private int age;
    @Pattern(regexp="[\\w\\.-]*[a-zA-Z0-9_]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]", message="The email address of ${validatedValue} is not in the correct format")
    private String email;
    private Boolean newsletter;
    @Column(name = "email_notification")
    private Boolean emailNotification;
    @Column(name = "enable_notification")
    private Boolean enableNotification;

    /**
     * @return the id
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }
}
