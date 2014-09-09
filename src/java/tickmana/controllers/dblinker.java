/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tickmana.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author shofmann
 */
public class dblinker {
    private Connection conn = null;
    private boolean connected = false;
    public static dblinker instance = null;

    protected dblinker(){
        String url = "jdbc:mysql://localhost/test?user=monty&password=greatsqldb";
        
        try{
            this.conn = DriverManager.getConnection(url);
            this.connected = true;
        }catch( SQLException ex ){
            ex.printStackTrace();
        }finally{
            try{
                this.conn.close();
            }catch( SQLException ex ){
                ex.printStackTrace();
            }
            this.conn = null;
            this.connected = false;
        }
        
    }
    
    public static dblinker getinstance(){
        if( dblinker.instance == null ){
            dblinker.instance = new dblinker();
        }
        
        return dblinker.instance;
    }
}
