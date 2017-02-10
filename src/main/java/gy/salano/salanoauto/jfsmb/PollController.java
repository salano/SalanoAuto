/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gy.salano.salanoauto.jfsmb;

import gy.salano.salanoauto.object.Poll;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Salano
 */
@Named(value = "pollController")
@SessionScoped
public class PollController implements Serializable {

    /**
     * Creates a new instance of PollController
     */
    private Poll current;
    public PollController() {
    }

    public Poll getCurrent() {
        if(current == null){
            current = new Poll();
        }
        return current;
    }

    public void setCurrent(Poll current) {
        
        this.current = current;
    }
   public void invokePoll(){
       Map<String, Object> options = new HashMap<>(); 
       options.put("modal", true);
       RequestContext.getCurrentInstance().openDialog("/dialog/poll.xhtml",options,null);
   }
   public void submitPoll(){
       RequestContext.getCurrentInstance().closeDialog(current);
       current = null;
   }
   public void handleReturn(SelectEvent event){
       Poll poll = (Poll) event.getObject();
       System.out.println("Poll Contents :"+ poll.getAnswer1()+" "+ poll.getAnswer2()+" "+ poll.getAnswer3()+" ");
   }
}
