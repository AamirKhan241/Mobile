package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteAll {
    
    public static boolean delete(String table_name){
        try {
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from "+table_name);
            int i=ps.executeUpdate();
            if(i>0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }    
}
