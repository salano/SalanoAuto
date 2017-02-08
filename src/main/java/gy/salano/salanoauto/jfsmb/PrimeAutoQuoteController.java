/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gy.salano.salanoauto.jfsmb;

import gy.salano.salanoauto.entity.PrimeAutoQuote;
import gy.salano.salanoauto.session.PrimeAutoQuoteFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author Salano
 */
@Named(value = "primeAutoQuoteController")
@SessionScoped
public class PrimeAutoQuoteController implements Serializable {

    /**
     * Creates a new instance of PrimeAutoQuoteController
     */
    @EJB PrimeAutoQuoteFacade ejbFacade;
    private PrimeAutoQuote current;
    private Boolean optIn;
    public PrimeAutoQuoteController() {
    }

    /**
     * @return the current
     */
    public PrimeAutoQuote getCurrent() {
        if(current ==null){
            current = new PrimeAutoQuote();
        }
        
        return current;
    }
    
    public String saveQuote(){
        current.setId(ejbFacade.count() + 1);
        ejbFacade.create(current);
        
        FacesMessage message = new FacesMessage("Quote Saved");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return null;
    }
    public List modelList(){
        List<String> models = ejbFacade.obtainAutomibleModel(current.getMake());
        List returnList = new ArrayList();
        for(String model: models){
            returnList.add(new SelectItem(model, model));
        }
        return returnList;
    }
    public List autoCompleteMake(String text){
        return ejbFacade.autoCompleteMake(text);
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(PrimeAutoQuote current) {
        this.current = current;
    }

    /**
     * @return the optIn
     */
    public Boolean getOptIn() {
        return optIn;
    }

    /**
     * @param optIn the optIn to set
     */
    public void setOptIn(Boolean optIn) {
        this.optIn = optIn;
        System.out.println("optIn is now:" +optIn);
    }
    
}
