/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gy.salano.salanoauto.jfsmb;

import gy.salano.salanoauto.entity.Car;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.event.ResizeEvent;

/**
 *
 * @author Salano
 */
@Named(value = "mainViewController")
@RequestScoped
public class MainViewController {

    /**
     * @return the selectionType
     */
    public String getSelectionType() {
        return selectionType;
    }

    /**
     * @param selectionType the selectionType to set
     */
    public void setSelectionType(String selectionType) {
        this.selectionType = selectionType;
    }

    /**
     * Creates a new instance of MainViewController
     */
    private String selectionType;
    private List<Car> automobiles = new ArrayList();

    public MainViewController() {
    }

    public void layoutResizeEvent(ResizeEvent event) {
        System.out.println("The application has been resize:" + event.getComponent());
    }

    public String navigateToCar() {
        selectionType = "CAR";
        return "automobile";
    }

    public String navigateToPickup() {
        selectionType = "TRUCK";
        return "automobile";
    }

    public String navigateToSUV() {
        selectionType = "SUV";
        return "automobile";
    }

    /**
     * @return the automobiles
     */
    public List<Car> getAutomobiles() {
        Car car1 = new Car();
        car1.setMake("Toyota");
        car1.setModel("Premio");
        Car car2 = new Car();
        car2.setMake("Nissan");
        car2.setModel("Bluebird");
        Car car3 = new Car();
        car3.setMake("Honda");
        car3.setModel("Splash");
        automobiles = new ArrayList<>();
        automobiles.add(car1);
        automobiles.add(car2);
        automobiles.add(car3);
        return automobiles;
    }

    /**
     * @param automobiles the automobiles to set
     */
    public void setAutomobiles(List<Car> automobiles) {
        this.automobiles = automobiles;
    }
}
