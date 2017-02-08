/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gy.salano.salanoauto.session;

import gy.salano.salanoauto.entity.PrimeAutomobile;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Salano
 */
@Stateless
public class PrimeAutomobileFacade extends AbstractFacade<PrimeAutomobile> {

    @PersistenceContext(unitName = "SalanoAutoSales-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrimeAutomobileFacade() {
        super(PrimeAutomobile.class);
    }
    
}
