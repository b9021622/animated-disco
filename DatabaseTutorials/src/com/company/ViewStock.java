package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewStock {

    public static void view() {
        ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
        Connection conn = Connect.connect();
        String getCount = "Select * FROM ProductsInStock";
        ResultSet rst = null;
        int count = 0;

        try {
            PreparedStatement ps = conn.prepareStatement(getCount);
            rst = ps.executeQuery();
            while (rst.next()) {
               String prodCode = rst.getString(1);
               String prodName = rst.getString(2);
               String prodType = rst.getString(3);
               String prodColour = rst.getString(4);
               Float prodCost =  rst.getFloat(5);
               int prodCount = rst.getInt(6);
                ArrayList<Object> rec = new ArrayList<Object>();//a local variable to collect each row of records
                rec.add(prodCode);
                rec.add(prodName);
                rec.add(prodType);
                rec.add(prodColour);
                rec.add(prodCost);
                rec.add(prodCount);

                data.add(rec);

            }




        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("[ProductCode, ProductName, ProductType, ProductColour, ProductCost, StockCount]");
        for(int k = 0; k < data.size(); k++ ) {
            System.out.println(data.get(k));
            System.out.println("");
        }
    }
}