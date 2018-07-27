package purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Purchase_Report_DAO_Implt implements Purchase_Report_DAO{
    
    Connection conn=db.db.getConnection();
    @Override
    public boolean insert(Purchase_Report pr) {
        try {
            PreparedStatement ps=conn.prepareStatement("insert into Purchase_report(purchase_note,seller_name,seller_contact,"
                    + "mobile_id,cost_price,sale_price,quantity,gst,total_amount) values(?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, getId());
            ps.setString(2, pr.getSeller_name());
            ps.setString(3, pr.getSeller_contact());
            ps.setInt(4, pr.getMobile_id());
            ps.setString(5, pr.getCost_price());
            ps.setString(6, pr.getSale_price());
            ps.setString(7, pr.getQuantity());
            ps.setString(8, pr.getGst());
            ps.setString(9, pr.getTotal_amount());
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Purchase_Report pr) {
        try {
            PreparedStatement ps=conn.prepareStatement("update purchase_Report set seller_name=?,seller_contact=?,"
                    + "mobile_id=?,cost_price=?,sale_price=?,quantity=?,gst=?,total_amount=? where Purchase_note="+pr.getPurchase_note());
            ps.setString(1, pr.getSeller_name());
            ps.setString(2, pr.getSeller_contact());
            ps.setInt(3, pr.getMobile_id());
            ps.setString(4, pr.getCost_price());
            ps.setString(5, pr.getSale_price());
            ps.setString(6, pr.getQuantity());
            ps.setString(7, pr.getGst());
            ps.setString(8, pr.getTotal_amount());
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int purchase_note) {
        try {
            PreparedStatement ps=conn.prepareStatement("delete from purchase_Report where purchase_note="+purchase_note);
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Purchase_Report display(int purchase_note) {
        Purchase_Report pr=new Purchase_Report();
        try {
            PreparedStatement ps=conn.prepareStatement("select * from purchase_Report where purchase_note="+purchase_note+" order by purchase_note");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                pr.setPurchase_note(rs.getInt(1));
                pr.setSeller_name(rs.getString(2));
                pr.setSeller_contact(rs.getString(3));
                pr.setPurchase_date(rs.getString(4));
                pr.setMobile_id(rs.getInt(5));
                pr.setCost_price(rs.getString(6));
                pr.setSale_price(rs.getString(7));
                pr.setQuantity(rs.getString(8));
                pr.setGst(rs.getString(9));
                pr.setTotal_amount(rs.getString(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }

    @Override
    public List<Purchase_Report> display() {
        List<Purchase_Report> list=new ArrayList<>();
        try {
            PreparedStatement ps=conn.prepareStatement("select * from purchase_Report order by purchase_note");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Purchase_Report pr=new Purchase_Report();
                pr.setPurchase_note(rs.getInt(1));
                pr.setSeller_name(rs.getString(2));
                pr.setSeller_contact(rs.getString(3));
                pr.setPurchase_date(rs.getString(4));
                pr.setMobile_id(rs.getInt(5));
                pr.setCost_price(rs.getString(6));
                pr.setSale_price(rs.getString(7));
                pr.setQuantity(rs.getString(8));
                pr.setGst(rs.getString(9));
                pr.setTotal_amount(rs.getString(10));
                list.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public int getId(){
        try {
            PreparedStatement ps=conn.prepareStatement("select max(purchase_note) last from purchase_Report");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
                return rs.getInt("last")+1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }    
    
}
