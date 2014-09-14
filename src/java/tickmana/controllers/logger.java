/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tickmana.controllers;

import java.util.ArrayList;
import tickmana.controllers.objects.log;
import tickmana.controllers.dblinker;

/**
 *
 * @author Sebastian Hofmann
 */
public class logger {
    public static logger instance = null;
    private ArrayList<log> logs = null;
    private dblinker link = null;
    
    //@Override
    protected logger(){
        try{
            this.logs = new ArrayList<>();
            this.link = dblinker.getinstance();
        }finally{
            this.logs = null;
        }
    }
    
    public static logger getinstance(){
        if( logger.instance == null ){
            logger.instance = new logger();
        }
        
        return logger.instance;
    }
    
    public boolean addlog( log.Types_ logtyp, String logmsg ){
        if( logmsg.compareTo("") != 0 ){
            this.logs.add(new log(logtyp, logmsg));
            
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * this class write the logs into the database when she was finalize.
     * 
     * @throws Throwable 
     */
    @Override
    public void finalize() throws Throwable {
        super.finalize();
        
        String query = "";
        
        this.link.executequery(query);
    }
}
