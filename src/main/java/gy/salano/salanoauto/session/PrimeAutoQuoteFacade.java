/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gy.salano.salanoauto.session;

import gy.salano.salanoauto.entity.PrimeAutoQuote;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Salano
 */
@Stateless
public class PrimeAutoQuoteFacade extends AbstractFacade<PrimeAutoQuote> {

    @PersistenceContext(unitName = "SalanoAutoSales-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrimeAutoQuoteFacade() {
        super(PrimeAutoQuote.class);
    }
    
    public List autoCompleteMake(String text){
        String queryString = "%"+text.toUpperCase()+"%";
        System.out.println("text :"+ text);
        List<String> matches;
        
        matches = em.createQuery("select DISTINCT (o.make) from PrimeAutomobile as o "
                + " where upper(o.make) like :make").setParameter("make", queryString).getResultList();
        
        return matches;
    }
    
    public List obtainAutomibleModel(String make){
        if(make !=null && make.length() > 1){
            return em.createQuery("select o.model from PrimeAutomobile as o "+
                    " where upper(o.make) = :make")
                    .setParameter("make", make.toUpperCase())
                    .getResultList();
            
        }else{
            return em.createQuery("select o.model from PrimeAutomobile as o")
                    .getResultList();
        }
    }
    
}
