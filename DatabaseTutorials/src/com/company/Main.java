package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //AddProductLine.Add("PI00004", "i9-9900K", "CPU", "", 495.89F, 10 );   // add product line, using code, name, type, colour, cost and initial count
        //AdjustStock.Adjust("PI00004", -1);                                    // adjusts stock count using product code and adjustment number
        //ViewStock.view();                                                     // shows entire table of stock
        //DiscontinueProduct.discontinue("PI00004");                            // removes entire product record from database
        //UpdateProductDeets.update("PI00003", "i7-9700K", "CPU", "", 230.89F, 0 );    // allows alteration of all details apart from code
        //ArrayList<Object> lemons = ProdSearch.search("PI00001"); // Lemons will contain an arraylist showing all the details for the product matching the code in ProdSearch.search
        //System.out.println(lemons);
        //RecordDamaged.record("PI00001", "Drop", 1);                                   // Removes damaged goods with corresponding code from product table, adds correct quantity of damaged goods to damaged goods table and gives a damage reason.


    }
}
//// TODO 24/2/2021: add block to prevent discontinuation of product that has existing stock  DONE
//// TODO Fix all exceptions and make sure you understand what they all mean
//// TODO Add block to prevents reporting of damaged goods if the damaged goods report will take stock below 0 DONE
//// TODO add menu and input forms
//// TODO make a simple table for displaying tables
//// TODO  add user logins


