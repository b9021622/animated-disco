package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class  DiscontinueProduct {
    public static void discontinue(String ProdCode){
        Connection conn = Connect.connect();
        String getCount = "Select StockCount FROM ProductsInStock WHERE ProductCode = ?";
        ResultSet rst = null;
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(getCount);     // this try block grabs the current stock count for the specified product code
            ps.setString(1, ProdCode);
            rst = ps.executeQuery();
            while (rst.next()) {
                count = rst.getInt(1);

            }


        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        if(count == 0){
        String sql = "DELETE FROM ProductsInStock WHERE ProductCode = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,ProdCode);

            pstmt.executeUpdate();
            conn.close();

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        ViewStock.view();
    }
        else{
            System.out.println("can't discontinue product, there is still existing stock");
        }
    }
}
