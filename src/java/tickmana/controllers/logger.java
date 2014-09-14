/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tickmana.controllers;

import java.util.ArrayList;
import tickmana.controllers.objects.log;

/**
 *
 * @author Sebastian Hofmann
 */
public class logger {
    public static logger instance = null;
    private ArrayList<log> logs = null;
    
    //@Override
    protected logger(){
        try{
            this.logs = new ArrayList<>();
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
    
    public boolean addlog_ok( String logmsg ){
        if( logmsg.compareTo("") != 0 ){
            this.logs.add(new log(log.Types_.ok, logmsg));
            
            return true;
        }else{
            return false;
        }
    }
    
    public boolean addlog_warning( String logmsg ){
        if( logmsg.compareTo("") != 0 ){
            this.logs.add(new log(log.Types_.warning, logmsg));
            
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
        
        
    }
}
