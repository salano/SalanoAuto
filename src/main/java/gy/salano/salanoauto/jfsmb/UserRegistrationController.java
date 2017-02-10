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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Salano
 */
@Named(value = "userRegistrationController")
@ViewScoped
public class UserRegistrationController implements Serializable {

    /**
     * Creates a new instance of UserRegistrationController
     */
    @EJB
    UserFacade ejbfacade;
    private User current;
    private List<User> userList;
    private LazyUserModel userModel;

    public List<User> getUserList() {
        if (userList == null) {
            this.populateUsers();
            System.out.println("Here");
        }

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

    public String create() {
        int userCount = ejbfacade.findAll().size();
        current.setId(BigDecimal.valueOf(userCount + 1));
        ejbfacade.create(current);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Successful User Entry", "Successful User entry"));
        return null;
    }

    public void populateUsers() {
        //userModel = new LazyUserModel(ejbfacade.findAll());
        //this.setUserList(ejbfacade.findAll());
        this.userList = ejbfacade.findAll();
        //this.setUserList(ejbfacade.findAll());
    }

    /**
     * @return the userModel
     */
    public LazyUserModel getUserModel() {
        userModel = new LazyUserModel(ejbfacade.findAll());
        System.out.println(userModel);
        return userModel;
    }

    public void rowEditAction(RowEditEvent event) {
        User object = (User) event.getObject();
        ejbfacade.edit(object);
        FacesMessage message = new FacesMessage("Row successfully updated for user Id:" + object.getId());
        FacesContext.getCurrentInstance().addMessage(null, message);

    }
    
    public void saveUser(ActionEvent ae){
        RequestContext requestContext = RequestContext.getCurrentInstance();
        if(current.getAge() > 18){
            ejbfacade.edit(current);
            requestContext.addCallbackParam("age", true);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "User Updated", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }else{
            requestContext.addCallbackParam("age", false);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Age", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
