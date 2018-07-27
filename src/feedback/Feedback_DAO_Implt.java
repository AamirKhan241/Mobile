package feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Feedback_DAO_Implt implements Feedback_DAO{
    
    Connection conn=db.db.getConnection();
    @Override
    public boolean insert(Feedback f) {
        try {
            PreparedStatement ps=conn.prepareStatement("insert into Feedback(serial_no,email,name,description) values(?,?,?,?)");
            ps.setInt(1, getId());
            ps.setString(2, f.getEmail());
            ps.setString(3, f.getName());
            ps.setString(4, f.getDescription());
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Feedback f) {
        try {
            PreparedStatement ps=conn.prepareStatement("update Feedback set email=?,name=?,description=? where serial_no="+f.getSerial_no());
            ps.setString(1, f.getEmail());
            ps.setString(2, f.getName());
            ps.setString(3, f.getDescription());
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
            PreparedStatement ps=conn.prepareStatement("delete from Feedback where serial_no="+serial_no);
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Feedback display(int serial_no) {
        Feedback f=new Feedback();
        try {
            PreparedStatement ps=conn.prepareStatement("select * from Feedback where mobile_id="+serial_no+" order by serial_no");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                f.setSerial_no(rs.getInt(1));
                f.setEmail(rs.getString(2));
                f.setName(rs.getString(3));
                f.setDescription(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public List<Feedback> display() {
        List<Feedback> list=new ArrayList<>();
        try {
            PreparedStatement ps=conn.prepareStatement("select * from Feedback order by serial_no");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Feedback f=new Feedback();
                f.setSerial_no(rs.getInt(1));
                f.setEmail(rs.getString(2));
                f.setName(rs.getString(3));
                f.setDescription(rs.getString(4));
                list.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    private int getId(){
        try {
            PreparedStatement ps=conn.prepareStatement("select max(serial_no) last from feedback");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
                return rs.getInt("last")+1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }    
    
}
