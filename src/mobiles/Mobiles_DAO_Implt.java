package mobiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Mobiles_DAO_Implt implements Mobiles_DAO{
    Connection conn=db.db.getConnection();
    @Override
    public boolean insert(Mobiles m) {
        try {
            PreparedStatement ps=conn.prepareStatement("insert into mobile"
                    + "(mobile_id,Manufacturer,model_no,manufacturing_year,storage,ram,wifi,bluetooth,usb,battery,weight,"
                    + "color,gps,fm,unit_price,stock_avaiable,image)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, getId());
            ps.setString(2, m.getManufacturer());
            ps.setString(3, m.getModel_no());
            ps.setString(4, m.getManufacturing_year());
            ps.setString(5, m.getStorage());
            ps.setString(6, m.getRam());
            ps.setString(7, m.getWifi());
            ps.setString(8, m.getBluetooth());
            ps.setString(9, m.getUsb());
            ps.setString(10, m.getBattery());
            ps.setString(11, m.getWeight());
            ps.setString(12, m.getColor());
            ps.setString(13, m.getGps());
            ps.setString(14, m.getFm());
            ps.setString(15, m.getUnit_price());
            ps.setString(16, m.getStock_avaiable());
            ps.setString(17, m.getImage());
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Mobiles m) {
        try {
            PreparedStatement ps=conn.prepareStatement("update mobile set Manufacturer=?,model_no=?,manufacturing_year=?,"
                    + "storage=?,ram=?,wifi=?,bluetooth=?,usb=?,battery=?,weight=?,color=?,gps=?,fm=?,unit_price=?,"
                    + "stock_avaiable=?,image=? where mobile_id="+m.getMobile_id());
            
            ps.setString(1, m.getManufacturer());
            ps.setString(2, m.getModel_no());
            ps.setString(3, m.getManufacturing_year());
            ps.setString(4, m.getStorage());
            ps.setString(5, m.getRam());
            ps.setString(6, m.getWifi());
            ps.setString(7, m.getBluetooth());
            ps.setString(8, m.getUsb());
            ps.setString(9, m.getBattery());
            ps.setString(10, m.getWeight());
            ps.setString(11, m.getColor());
            ps.setString(12, m.getGps());
            ps.setString(13, m.getFm());
            ps.setString(14, m.getUnit_price());
            ps.setString(15, m.getStock_avaiable());
            ps.setString(16, m.getImage());
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int mobile_id) {
        try {
            PreparedStatement ps=conn.prepareStatement("delete from mobile where mobile_id="+mobile_id);
            int i=ps.executeUpdate();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Mobiles display(int mobile_id) {
        Mobiles m=new Mobiles();
        try {
            PreparedStatement ps=conn.prepareStatement("select * from mobile where mobile_id="+mobile_id+" order by mobile_id");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                m.setMobile_id(rs.getInt(1));
                m.setManufacturer(rs.getString(2));
                m.setModel_no(rs.getString(3));
                m.setManufacturing_year(rs.getString(4));
                m.setStorage(rs.getString(5));
                m.setRam(rs.getString(6));
                m.setWifi(rs.getString(7));
                m.setBluetooth(rs.getString(8));
                m.setUsb(rs.getString(9));
                m.setBattery(rs.getString(10));
                m.setWeight(rs.getString(11));
                m.setColor(rs.getString(12));
                m.setGps(rs.getString(13));
                m.setFm(rs.getString(14));
                m.setUnit_price(rs.getString(15));
                m.setStock_avaiable(rs.getString(16));
                m.setImage(rs.getString(17));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public List<Mobiles> display() {
        List<Mobiles> list=new ArrayList<>();
        try {
            PreparedStatement ps=conn.prepareStatement("select * from mobile order by mobile_id");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Mobiles m=new Mobiles();
                m.setMobile_id(rs.getInt(1));
                m.setManufacturer(rs.getString(2));
                m.setModel_no(rs.getString(3));
                m.setManufacturing_year(rs.getString(4));
                m.setStorage(rs.getString(5));
                m.setRam(rs.getString(6));
                m.setWifi(rs.getString(7));
                m.setBluetooth(rs.getString(8));
                m.setUsb(rs.getString(9));
                m.setBattery(rs.getString(10));
                m.setWeight(rs.getString(11));
                m.setColor(rs.getString(12));
                m.setGps(rs.getString(13));
                m.setFm(rs.getString(14));
                m.setUnit_price(rs.getString(15));
                m.setStock_avaiable(rs.getString(16));
                m.setImage(rs.getString(17));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public int getId(){
        try {
            PreparedStatement ps=conn.prepareStatement("select max(mobile_id) last from mobile");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
                return rs.getInt("last")+1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int available(String manufacture, String model) {
        try {
            PreparedStatement ps=conn.prepareStatement("select * from mobile order by mobile_id");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                if(manufacture.equalsIgnoreCase(rs.getString(2)) && model.equalsIgnoreCase(rs.getString(3)))
                    return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Mobiles> display(String manufacturer) {
        List<Mobiles> list=new ArrayList<>();
        try {
            PreparedStatement ps=conn.prepareStatement("select * from mobile where manufacturer='"+manufacturer+"' order by mobile_id");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Mobiles m=new Mobiles();
                m.setMobile_id(rs.getInt(1));
                m.setManufacturer(rs.getString(2));
                m.setModel_no(rs.getString(3));
                m.setManufacturing_year(rs.getString(4));
                m.setStorage(rs.getString(5));
                m.setRam(rs.getString(6));
                m.setWifi(rs.getString(7));
                m.setBluetooth(rs.getString(8));
                m.setUsb(rs.getString(9));
                m.setBattery(rs.getString(10));
                m.setWeight(rs.getString(11));
                m.setColor(rs.getString(12));
                m.setGps(rs.getString(13));
                m.setFm(rs.getString(14));
                m.setUnit_price(rs.getString(15));
                m.setStock_avaiable(rs.getString(16));
                m.setImage(rs.getString(17));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Mobiles displayM(String model_no,String manufacturer) {
        Mobiles m=new Mobiles();
        try {
            PreparedStatement ps=conn.prepareStatement("select * from mobile where model_no='"+model_no+"' and manufacturer='"+
                    manufacturer+"' order by mobile_id");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                m.setMobile_id(rs.getInt(1));
                m.setManufacturer(rs.getString(2));
                m.setModel_no(rs.getString(3));
                m.setManufacturing_year(rs.getString(4));
                m.setStorage(rs.getString(5));
                m.setRam(rs.getString(6));
                m.setWifi(rs.getString(7));
                m.setBluetooth(rs.getString(8));
                m.setUsb(rs.getString(9));
                m.setBattery(rs.getString(10));
                m.setWeight(rs.getString(11));
                m.setColor(rs.getString(12));
                m.setGps(rs.getString(13));
                m.setFm(rs.getString(14));
                m.setUnit_price(rs.getString(15));
                m.setStock_avaiable(rs.getString(16));
                m.setImage(rs.getString(17));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }
}
