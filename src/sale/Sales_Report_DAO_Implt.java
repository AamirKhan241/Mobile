package sale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Sales_Report_DAO_Implt implements Sales_Report_DAO{
    
    Connection conn=db.db.getConnection();
    @Override
    public boolean insert(Sales_Report sr) {
        try {
            PreparedStatement ps=conn.prepareStatement("insert into sales_report(Invoice_No,customer_name,customer_contact,"
                    + "mobile_id,quantity,amount,gst) values(?,?,?,?,?,?,?)");
            ps.setInt(1, getId());
            ps.setString(2, sr.getCustomer_name());
            ps.setString(3, sr.getCustomer_contact());
            ps.setString(4, sr.getMobile_id());
            ps.setString(5, sr.getQuantity());
            ps.setString(6, sr.getAmount());
            ps.setString(7, sr.getGst());
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Sales_Report sr) {
        try {
            PreparedStatement ps=conn.prepareStatement("update Sales_Report set customer_name=?,customer_contact=?,mobile_id=?,"
                    + "quantity=?,amount=?,gst=? where invoice_no="+sr.getInvoice_no());
            ps.setString(1, sr.getCustomer_name());
            ps.setString(2, sr.getCustomer_contact());
            ps.setString(3, sr.getMobile_id());
            ps.setString(4, sr.getQuantity());
            ps.setString(5, sr.getAmount());
            ps.setString(6, sr.getGst());
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int invoice_no) {
        try {
            PreparedStatement ps=conn.prepareStatement("delete from Sales_Report where invoice_no="+invoice_no);
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Sales_Report display(int invoice_no) {
        Sales_Report sr=new Sales_Report();
        try {
            PreparedStatement ps=conn.prepareStatement("select * from Sales_Report where invoice_no="+invoice_no+" order by Invoice_No");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                sr.setInvoice_no(rs.getInt(1));
                sr.setCustomer_name(rs.getString(2));
                sr.setCustomer_contact(rs.getString(3));
                sr.setSale_date(rs.getString(4));
                sr.setMobile_id(rs.getString(5));
                sr.setQuantity(rs.getString(6));
                sr.setAmount(rs.getString(7));
                sr.setGst(rs.getString(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sr;
    }

    @Override
    public List<Sales_Report> display() {
        List<Sales_Report> list=new ArrayList<>();
        try {
            PreparedStatement ps=conn.prepareStatement("select * from Sales_Report order by Invoice_No");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Sales_Report sr=new Sales_Report();
                sr.setInvoice_no(rs.getInt(1));
                sr.setCustomer_name(rs.getString(2));
                sr.setCustomer_contact(rs.getString(3));
                sr.setSale_date(rs.getString(4));
                sr.setMobile_id(rs.getString(5));
                sr.setQuantity(rs.getString(6));
                sr.setAmount(rs.getString(7));
                sr.setGst(rs.getString(8));
                list.add(sr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getId(){
        try {
            PreparedStatement ps=conn.prepareStatement("select max(invoice_no) last from sales_Report");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
                return rs.getInt("last")+1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }    
}
