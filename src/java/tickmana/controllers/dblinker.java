/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tickmana.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author shofmann
 */
public class dblinker {
    private Connection conn = null;
    private boolean connected = false;
    public static dblinker instance = null;
    final static String dbHost = "localhost"; // Hostname
    final static String dbPort = "3306";      // Port -- Standard: 3306
    final static String dbName = "test_db";   // Datenbankname
    final static String dbUser = "aleks";     // Datenbankuser
    final static String dbPass = "test";      // Datenbankpasswort

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
    
    public ArrayList<String[]> executequery( String stmt ){
        if( this.connected ){
            try{
                Statement query = this.conn.createStatement();

                // Tabelle anzeigen
                String sql = "SELECT kundeid, vorname, nachname, email FROM kunde";
                ResultSet result = query.executeQuery(sql);

                return null;
            }catch( SQLException ex ){
                ex.printStackTrace();
            }
        }else{
            return null;
        }
        
        return null;
    }
}
