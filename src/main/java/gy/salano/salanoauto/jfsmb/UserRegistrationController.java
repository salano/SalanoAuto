/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gy.salano.salanoauto.jfsmb;

import gy.salano.salanoauto.bean.LazyUserModel;
import gy.salano.salanoauto.entity.User;
import gy.salano.salanoauto.session.UserFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Salano
 */
@Named(value = "userRegistrationController")
@ViewScoped
public class UserRegistrationController implements Serializable{

    /**
     * Creates a new instance of UserRegistrationController
     */
    @EJB
    UserFacade ejbfacade;
    private User current;
    private List<User> userList;
    private LazyUserModel userModel;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    public UserRegistrationController() {
    }
    public User getCurrent() {
        System.out.println(": 0");
        if (current == null) {
            current = new User();
            current.setEnableNotification(Boolean.FALSE);
            System.out.println("setting: 1");
        }
        System.out.println("setting: " + current.getEmail());
        return current;
    }

    public String flowHandler(FlowEvent event) {
        if (current != null) {
            if (!current.getEnableNotification()) {
                return "confirm";
            } else {
                return event.getNewStep();
            }
        } else {
            return event.getNewStep();
        }
        
    }
    
    public String create(){
        int userCount = ejbfacade.findAll().size();
        current.setId(BigDecimal.valueOf(userCount + 1));
        ejbfacade.create(current);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
        "Successful User Entry", "Successful User entry"));
        return null;
    }
    public String populateUsers(){
        userModel = new LazyUserModel(ejbfacade.findAll());
        //this.setUserList(ejbfacade.findAll());
        return null;
    }

    /**
     * @return the userModel
     */
    public LazyUserModel getUserModel() {
        userModel = new LazyUserModel(ejbfacade.findAll());
        System.out.println(userModel);
        return userModel;
    }
}
