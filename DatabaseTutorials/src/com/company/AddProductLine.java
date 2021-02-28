package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class  AddProductLine {
    public static void Add(String ProdCode, String ProdName, String ProdType, String ProdColour, Float ProdCost, int StockCount ){
    Connection conn = Connect.connect();
    String sql = "INSERT INTO ProductsInStock(ProductCode, ProductName, ProductType, ProductColour, ProductCost, StockCount) VALUES (?,?,?,?,?,?)";
    try {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,ProdCode);
        pstmt.setString(2, ProdName);
        pstmt.setString(3,ProdType);
        pstmt.setString(4, ProdColour);
        pstmt.setFloat(5,ProdCost);
        pstmt.setInt(6, StockCount);


        pstmt.executeUpdate();
        conn.close();

    } catch (
    SQLException e) {
        System.out.println(e.getMessage());
    }
    }
    }

