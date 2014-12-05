/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus
 */
public class ControllerConnDBMS {
    
    private Connection conn;
    private String ip;
    private String user;
    private String pass;
    private String db;

    public Connection connectDB(){
        try {
            initDataConnection();
            Class.forName("com.mysql.jdbc.Driver");
            String server = "jdbc:mysql://"+getIp()+"/"+getDb();
            Properties pro = new Properties();
            pro.setProperty("user", getUser());
            pro.setProperty("password", getPass());
            try {
                setConn(DriverManager.getConnection(server, pro));
            } catch (SQLException ex) {
                Logger.getLogger(ControllerConnDBMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerConnDBMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getConn();
    }
    
    public String testConn(){
        String result = "";
        try {
            initDataConnection();
            Class.forName("com.mysql.jdbc.Driver");
            String server = "jdbc:mysql://"+getIp()+"/"+getDb();
            Properties pro = new Properties();
            pro.setProperty("user", getUser());
            pro.setProperty("password", getPass());
            try {
                setConn(DriverManager.getConnection(server, pro));
            } catch (SQLException ex) {
                Logger.getLogger(ControllerConnDBMS.class.getName()).log(Level.SEVERE, null, ex);
                result=ex.getMessage();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerConnDBMS.class.getName()).log(Level.SEVERE, null, ex);
            result=ex.getMessage();
        }
        return result;
    }
    
    private void initDataConnection(){
        setIp("localhost");
        setDb("poscakeapp");
        setUser("root");
        setPass("");
    }
    
    public void closeConect(){
        try {
            if(conn != null && !conn.isClosed())
                conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerConnDBMS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * @param aConn the conn to set
     */
    public void setConn(Connection aConn) {
        conn = aConn;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param aIp the ip to set
     */
    public void setIp(String aIp) {
        ip = aIp;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param aUser the user to set
     */
    public void setUser(String aUser) {
        user = aUser;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param aPass the pass to set
     */
    public void setPass(String aPass) {
        pass = aPass;
    }

    /**
     * @return the db
     */
    public String getDb() {
        return db;
    }

    /**
     * @param aDb the db to set
     */
    public void setDb(String aDb) {
        db = aDb;
    }
}
