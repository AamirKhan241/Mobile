package login_History;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Login_History_DAO_Implt implements Login_History_DAO{

    Connection conn=db.db.getConnection();
    @Override
    public boolean insert(Login_History lh) {
        try {
            PreparedStatement ps=conn.prepareStatement("insert into Login_History(serial_no,email,password,status) values(?,?,?,?)");
            
            ps.setInt(1, getId());
            ps.setString(2, lh.getEmail());
            ps.setString(3, lh.getPassword());
            ps.setString(4, lh.getStatus());
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Login_History lh) {
        try {
            PreparedStatement ps=conn.prepareStatement("update Login_history set email=?,password=?,status=? "
                    + "where serial_no="+lh.getSerial_no());
            ps.setString(1, lh.getEmail());
            ps.setString(2, lh.getPassword());
            ps.setString(3, lh.getStatus());
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int serial_no) {
        try {
            PreparedStatement ps=conn.prepareStatement("delete from Login_History where serial_no="+serial_no);
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Login_History display(int serial_no) {
        Login_History lh=new Login_History();
        try {
            PreparedStatement ps=conn.prepareStatement("select * from LogIn_History where serial_no="+serial_no+" order by serial_no");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                lh.setSerial_no(rs.getInt(1));
                lh.setEmail(rs.getString(2));
                lh.setPassword(rs.getString(3));
                lh.setLogin_at(rs.getString(4));
                lh.setStatus(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lh;
    }

    @Override
    public List<Login_History> display() {
        List<Login_History> list=new ArrayList<>();
        try {
            PreparedStatement ps=conn.prepareStatement("select * from Login_history order by serial_no");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Login_History lh=new Login_History();
                lh.setSerial_no(rs.getInt(1));
                lh.setEmail(rs.getString(2));
                lh.setPassword(rs.getString(3));
                lh.setLogin_at(rs.getString(4));
                lh.setStatus(rs.getString(5));
                list.add(lh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    private int getId(){
        try {
            PreparedStatement ps=conn.prepareStatement("select max(serial_no) last from login_history");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
                return rs.getInt("last")+1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }    
}
