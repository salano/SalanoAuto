/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gy.salano.salanoauto.jfsmb;

import gy.salano.salanoauto.entity.PrimeAutomobile;
import gy.salano.salanoauto.session.PrimeAutomobileFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Salano
 */
@Named(value = "automobileController")
@RequestScoped
public class AutomobileController implements Serializable {

    /**
     * Creates a new instance of AutomobileController
     */
    @EJB
    PrimeAutomobileFacade ejbFacade;
    private List<PrimeAutomobile> automobiles;
    private DualListModel<String> automobilesList;

    public AutomobileController() {
    }

    public void loadAutomobiles() {
        automobiles = ejbFacade.findAll();
    }
    
    public void populateAutomobileFieldList(){
         List<String> automobileFieldSource = new ArrayList<>();
         List<String> automobileFieldTarget = new ArrayList<>();
         automobileFieldSource.add("Make");
         automobileFieldSource.add("Model");
           automobileFieldSource.add("Year");
         automobileFieldSource.add("Description");
         setAutomobilesList(new DualListModel<>(automobileFieldSource,automobileFieldTarget ));
         System.out.println("One");
    }

    /**
     * @return the automobiles
     */
    public List<PrimeAutomobile> getAutomobiles() {
        System.out.println("Two");
        if(automobiles == null){
            this.populateAutomobileFieldList();
        }
        return automobiles;
    }

    /**
     * @param automobiles the automobiles to set
     */
    public void setAutomobiles(List<PrimeAutomobile> automobiles) {
        this.automobiles = automobiles;
    }

    /**
     * @return the automobilesList
     */
    public DualListModel<String> getAutomobilesList() {
        return automobilesList;
    }

    /**
     * @param automobilesList the automobilesList to set
     */
    public void setAutomobilesList(DualListModel<String> automobilesList) {
        this.automobilesList = automobilesList;
    }

}
