package com.company;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecordDamaged {
    public static void record(String ProdCode, String CauseOfDamage, int DamagedQty) {
        Connection conn = Connect.connect();
        int count = AdjustStock.getStock(ProdCode);
        if ((count - DamagedQty) < 0) {
            System.out.println("damage report not possible, will take stock level below 0");
        } else {
        try {

            ArrayList<Object> DamagedItem = ProdSearch.search(ProdCode); // Get deets of product to be recorded as damaged
            AdjustStock.Adjust(ProdCode, -DamagedQty); // remove damaged stock from main inventory table
            String sql = "INSERT INTO DamagedProducts(ProductCode, ProductName, ProductType, ProductColour, ProductCost, CauseOfDamage, StockCount) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ProdCode);
            pstmt.setString(2, (String) DamagedItem.get(1));
            pstmt.setString(3, (String) DamagedItem.get(2));
            pstmt.setString(4, (String) DamagedItem.get(3));
            pstmt.setFloat(5, (Float) DamagedItem.get(4));
            pstmt.setString(6, CauseOfDamage);
            pstmt.setInt(7, DamagedQty);


            pstmt.executeUpdate();
            conn.close();

        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException){
            System.out.println("Incorrect product code");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }}}
