package profile;

import db.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Profile_DAO_Implt implements Profile_DAO{
    Connection conn=db.getConnection();
    @Override
    public boolean insert(Profile p) {
        try {
            PreparedStatement ps=conn.prepareStatement("insert into profiles(user_id,name,roles,email,password,contact_no) "
                                                        + "values(?,?,?,?,?,?)");
            
            ps.setInt(1, getId());
            ps.setString(2, p.getName());
            ps.setString(3, p.getRoles());
            ps.setString(4, p.getEmail());
            ps.setString(5, p.getPassword());
            ps.setString(6, p.getContact_no());
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Profile p) {
        try {
            PreparedStatement ps=conn.prepareStatement("update profiles set name=?,roles=?,password=?,contact_no=? where user_id="+p.getUser_id());
            ps.setString(1, p.getName());
            ps.setString(2, p.getRoles());
            ps.setString(3, p.getPassword());
            ps.setString(4, p.getContact_no());
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int user_id) {
        try {
            PreparedStatement ps=conn.prepareStatement("delete from profiles where user_id="+user_id);
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Profile display(int user_id) {
        Profile p=new Profile();
        try {
            PreparedStatement ps=conn.prepareStatement("select * from profiles where user_id="+user_id+" order by user_id");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                p.setUser_id(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setRoles(rs.getString(3));
                p.setEmail(rs.getString(4));
                p.setPassword(rs.getString(5));
                p.setContact_no(rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Profile> display() {
        List<Profile> list=new ArrayList();
        try {
            PreparedStatement ps=conn.prepareStatement("select * from profiles order by user_id");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Profile p=new Profile();
                p.setUser_id(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setRoles(rs.getString(3));
                p.setEmail(rs.getString(4));
                p.setPassword(rs.getString(5));
                p.setContact_no(rs.getString(6));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    private int getId(){
        try {
            PreparedStatement ps=conn.prepareStatement("select max(user_id) last from profiles");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
                return rs.getInt("last")+1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int count() {
        try {
            PreparedStatement ps=conn.prepareStatement("select count(*) cnt from profiles");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
                return rs.getInt("cnt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
}
