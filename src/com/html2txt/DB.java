package com.html2txt;

import java.sql.*;

import static com.html2txt.DB_information.*;


/**
 * Created by sunqilong on 2017/7/4.
 */
public class DB {

    public static void main(String args[]){
        //DB.DB_add(2, "iphone", "5.2", "8995", "4GB", "8000W", "www.baidu.com", "www.google.com");
        System.out.println(DB.DB_getram(33));
    }
    public static void DB_add(int num, String type, String size, String cpu, String ram, String camera, String url, String picurl){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            System.out.print(e);
        }
        try{
            String SQL="insert into "+tableName+ " value (" + "'" + num + "'," + "'" + type + "'," + "'" + size + "'," + "'" + cpu + "','"+  ram+ "','"+ camera + "','" + url + "','" + picurl + "');";

            System.out.println(SQL);
            Connection con;
            PreparedStatement sql;

            con=DriverManager.getConnection(uri,id,password);
            sql=con.prepareStatement(SQL);

            sql.executeUpdate();
            System.out.println("work done");
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    public static String DB_geturl(int num){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            System.out.print(e);
        }
        try{

            String SQL="SELECT url FROM "+ tableName + " where id=" + "'" + num + "'";

            System.out.println(SQL);
            Connection con=DriverManager.getConnection(uri,id,password);
            DatabaseMetaData metadata=con.getMetaData();//
            ResultSet rs1=metadata.getColumns(null,null,tableName,null);//

            Statement sql=con.createStatement();
            ResultSet rs=sql.executeQuery(SQL);
            String data = "null";
            while(rs.next())
            {data = rs.getString(1);}
            con.close();
            return data;
        }catch(SQLException e){
            System.out.print(e);
        }
        return "null";
    }
    public static String DB_getpicurl(int num){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            System.out.print(e);
        }
        try{

            String SQL="SELECT picurl FROM "+ tableName + " where id=" + "'" + num + "'";

            System.out.println(SQL);
            Connection con=DriverManager.getConnection(uri,id,password);
            DatabaseMetaData metadata=con.getMetaData();//
            ResultSet rs1=metadata.getColumns(null,null,tableName,null);//

            Statement sql=con.createStatement();
            ResultSet rs=sql.executeQuery(SQL);
            String data = "null";
            while(rs.next())
            {data = rs.getString(1);}
            con.close();
            return data;
        }catch(SQLException e){
            System.out.print(e);
        }
        return "null";
    }

    public static String DB_getsize(int num){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            System.out.print(e);
        }
        try{

            String SQL="SELECT size FROM "+ tableName + " where id=" + "'" + num + "'";

            System.out.println(SQL);
            Connection con=DriverManager.getConnection(uri,id,password);
            DatabaseMetaData metadata=con.getMetaData();//
            ResultSet rs1=metadata.getColumns(null,null,tableName,null);//

            Statement sql=con.createStatement();
            ResultSet rs=sql.executeQuery(SQL);
            String data = "null";
            while(rs.next())
            {data = rs.getString(1);}
            con.close();
            return data;
        }catch(SQLException e){
            System.out.print(e);
        }
        return "null";
    }

    public static String DB_gettype(int num){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            System.out.print(e);
        }
        try{

            String SQL="SELECT type FROM "+ tableName + " where id=" + "'" + num + "'";

            System.out.println(SQL);
            Connection con=DriverManager.getConnection(uri,id,password);
            DatabaseMetaData metadata=con.getMetaData();//
            ResultSet rs1=metadata.getColumns(null,null,tableName,null);//

            Statement sql=con.createStatement();
            ResultSet rs=sql.executeQuery(SQL);
            String data = "null";
            while(rs.next())
            {data = rs.getString(1);}
            con.close();
            return data;
        }catch(SQLException e){
            System.out.print(e);
        }
        return "null";
    }

    public static String DB_getcpu(int num){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            System.out.print(e);
        }
        try{

            String SQL="SELECT cpu FROM "+ tableName + " where id=" + "'" + num + "'";

            System.out.println(SQL);
            Connection con=DriverManager.getConnection(uri,id,password);
            DatabaseMetaData metadata=con.getMetaData();//
            ResultSet rs1=metadata.getColumns(null,null,tableName,null);//

            Statement sql=con.createStatement();
            ResultSet rs=sql.executeQuery(SQL);
            String data = "null";
            while(rs.next())
            {data = rs.getString(1);}
            con.close();
            return data;
        }catch(SQLException e){
            System.out.print(e);
        }
        return "null";
    }

    public static String DB_getram(int num){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            System.out.print(e);
        }
        try{

            String SQL="SELECT ram FROM "+ tableName + " where id=" + "'" + num + "'";

            System.out.println(SQL);
            Connection con=DriverManager.getConnection(uri,id,password);
            DatabaseMetaData metadata=con.getMetaData();//
            ResultSet rs1=metadata.getColumns(null,null,tableName,null);//

            Statement sql=con.createStatement();
            ResultSet rs=sql.executeQuery(SQL);
            String data = "null";
            while(rs.next())
            {data = rs.getString(1);}
            con.close();
            return data;
        }catch(SQLException e){
            System.out.print(e);
        }
        return "null";
    }

    public static String DB_getcamera(int num){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            System.out.print(e);
        }
        try{
            String SQL="SELECT camera FROM "+ tableName + " where id=" + "'" + num + "'";

            System.out.println(SQL);
            Connection con=DriverManager.getConnection(uri,id,password);
            DatabaseMetaData metadata=con.getMetaData();//
            ResultSet rs1=metadata.getColumns(null,null,tableName,null);//

            Statement sql=con.createStatement();
            ResultSet rs=sql.executeQuery(SQL);
            String data = "null";
            while(rs.next())
            {data = rs.getString(1);}
            con.close();
            return data;
        }catch(SQLException e){
            System.out.print(e);
        }
        return "null";
    }
}
