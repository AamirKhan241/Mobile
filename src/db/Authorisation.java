package db;

import java.util.List;
import javax.swing.JOptionPane;
import login_History.Login_History;
import login_History.Login_History_DAO;
import login_History.Login_History_DAO_Implt;
import profile.Profile;
import profile.Profile_DAO;
import profile.Profile_DAO_Implt;

public class Authorisation {

    public static  String status="denied",role="";
    public static  int id=0;
    public static  boolean authorise(String username,String password) {
        boolean log=false;
        Profile_DAO pdao=new Profile_DAO_Implt();
        List<Profile> list=pdao.display();
        Login_History_DAO lhdao=new Login_History_DAO_Implt();
        Login_History lh=new Login_History();
        lh.setEmail(username);
        lh.setPassword(password);
        
        for (Profile profile : list) {
           if(username.equalsIgnoreCase(profile.getEmail()) && password.equals(profile.getPassword())){
               role=profile.getRoles();
               status="granted";
               id=profile.getUser_id();
               return true;
           }           
        }
        return false;
    }

    public Authorisation(String status, String role) {
        this.status=status;
        this.role=role;
    }
    
    
}
