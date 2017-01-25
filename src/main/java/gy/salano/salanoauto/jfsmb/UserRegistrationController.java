/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gy.salano.salanoauto.jfsmb;

import gy.salano.salanoauto.entity.User;
import gy.salano.salanoauto.session.UserFacade;
import java.io.Serializable;
import javax.ejb.EJB;
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
        ejbfacade.create(current);
        return null;
    }
}
