package db;

import java.sql.Connection;
import java.sql.DriverManager;
    
public class db {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","mobile","22647");
            System.out.println("Connected");
        }catch(Exception e){e.printStackTrace();}
        return con;
    }
}
/*
    create table profiles(user_id int primary key, name varchar(50), roles varchar(15) not null, email varchar(50) unique not null, password varchar(20) not null, contact_no varchar(15) not null);

    create table Login_History(serial_no int primary key, email varchar(50) not null, password varchar(20), login_at date default sysdate, status varchar(15) );

    create table Feedback(serial_no int primary key, email varchar(50) not null, name varchar(50), description varchar(100) );

    create table mobile(mobile_id int primary key, Manufacturer varchar(50) not null, model_no varchar(50) not null, manufacturing_year varchar(10) not null, storage varchar(50) not null,ram varchar(10) not null, wifi varchar(10) not null,bluetooth varchar(10) not null,usb varchar(10) not null, battery varchar(30) not null,weight varchar(10) not null,color varchar(10) not null, gps varchar(10) not null,fm varchar(10) not null,unit_price varchar(10) not null,stock_avaiable varchar(10) not null,image varchar(500));

    create table sales_report(Invoice_No int primary key, customer_name varchar(50) not null,customer_contact varchar(12) not null, sale_date date default sysdate not null, mobile_id int references mobile(mobile_id),quantity varchar(10) not null, amount int not null, gst int default 28 not null );

    create table purchase_report(purchase_note int primary key, seller_name varchar(50) not null,seller_contact varchar(12) not null, purchase_date date default sysdate not null , mobile_id int references mobile(mobile_id),cost_price int not null,sale_price int not null,quantity varchar(10) not null, gst int default 28 not null ,total_amount int not null);

*/