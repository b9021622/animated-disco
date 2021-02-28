package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProductDeets {
    public static void update(String ProdCode, String ProdName, String ProdType, String ProdColour, Float ProdCost, int StockCount ){
        String sql = "UPDATE ProductsInStock SET ProductName = ?, ProductType= ?, ProductColour= ?, ProductCost= ?, StockCount = ? WHERE ProductCode = (?) ;";
        try {
            Connection conn = Connect.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, ProdName);
            pstmt.setString(2,ProdType);
            pstmt.setString(3, ProdColour);
            pstmt.setFloat(4,ProdCost);
            pstmt.setInt(5, StockCount);
            pstmt.setString(6,ProdCode);


            pstmt.executeUpdate();
            conn.close();

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        ViewStock.view();
    }
}
