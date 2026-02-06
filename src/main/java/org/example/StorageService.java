package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.example.DataBaseConnection.getConnection;

public class StorageService {
    public static void storeDatasTofile(int attempts,String name,int win) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("game_Results.txt",true))){
            bw.write("Player Name: "+name+"\n"+"Attempts: "+attempts+"\n"+"Results: "+((win>0)?"Win":"Loss")+"\n");
            bw.newLine();
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Result Datas are unable to be stored");
        }
    }

    public static void storeDataT0DataBase(int attempts,String name,int win) throws IOException {
        Connection con=getConnection();
        try{

        String query="INSERT INTO game_Results(Player_name,Attempts,Result) VALUES (?,?,?)";

        PreparedStatement pt=con.prepareStatement(query);
        pt.setString(1,name);
        pt.setInt(2,attempts);
        pt.setString(3,(win>0)?"Win":"Loss");
            pt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void viewStoredData() throws IOException {
        Connection con=getConnection();
        try{
        String query="SELECT * FROM game_Results";
        ResultSet rs=con.createStatement().executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));

            System.out.println("Next Details...");
        }
        }
        catch(Exception e){
            throw new IOException("Can't get stored data");
        }
    }

}
