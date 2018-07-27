package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Table {
    public String column[],data[][]=null;

    public Table(String table_name) {
        try{
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from "+table_name+"",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=ps.executeQuery();

            ResultSetMetaData rsmd=rs.getMetaData();
            int cols=rsmd.getColumnCount();
            column=new String[cols];
            for(int i=1;i<=cols;i++){
                    column[i-1]=rsmd.getColumnName(i);
            }

            rs.last();
            int rows=rs.getRow();
            rs.beforeFirst();

            data=new String[rows][cols];
            int count=0;
            while(rs.next()){
                    for(int i=1;i<=cols;i++){
                            data[count][i-1]=rs.getString(i);
                    }
                    count++;
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }       
    }    
}
