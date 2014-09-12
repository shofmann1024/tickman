/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tickmana.controllers;

/**
 *
 * @author Sebastian Hofmann
 */
public class logger {
    public static logger instance = null;
    
    protected logger(){
        
    }
    
    public static logger getinstance(){
        if( logger.instance == null ){
            logger.instance = new logger();
        }
        
        return logger.instance;
    }
}
