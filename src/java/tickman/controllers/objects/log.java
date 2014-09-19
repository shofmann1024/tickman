/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tickman.controllers.objects;

import java.sql.Timestamp;

/**
 *
 * @author Sebastian Hofmann
 */
public class log {
    private Timestamp timestamp = null;
    private Types_ type = null;
    private String log = "";
    
    public enum Types_ {
        error,success,warning,defect,ok
    }
    
    public log( Types_ type, String log ){
        this.timestamp =  new Timestamp((new java.util.Date()).getTime());
        this.type = type;
        this.log = log;
    }
    
    public String getlog( ){
        return this.log;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Types_ getType() {
        return type;
    }

    public void setlog( String value ){
        this.log = value;
    }
    
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setType(Types_ type) {
        this.type = type;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
