/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chouaib
 */
public class Config {
    public static String ip;
    public static String port;
    public static Config config;
    
    static{
        FileInputStream f =null;            
        try {           
            f=new FileInputStream("configuration.properties");
            Properties p=new Properties();
            p.load(f);
            config.ip  =p.getProperty("ip");
            config.port =p.getProperty("port");
        }catch(FileNotFoundException ex){
        }catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                 f.close();
            } catch (IOException e) {
            }         
        }      
    }
       
       public static Config getConfig(){
       return config;
        }
    
}
