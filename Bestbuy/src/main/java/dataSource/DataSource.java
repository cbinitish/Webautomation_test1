package dataSource;


import databases.ConnectToSqlDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataSource
{
    //public static ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();


    //  Database
    public static List<String> insertDataIntoList(){
        List<String> list = getItemValue();
        //connectToSqlDB = new ConnectToSqlDB();
        //connectToSqlDB.insertStringDataFromArrayListToSqlTable(list,"ItemList","items");
        return list;
    }

    public static List<String> getItemValue() {
        List<String> itemsList = new ArrayList<String>();
        itemsList.add("xbox");
        itemsList.add("apple TV");
        itemsList.add("airpods");
        itemsList.add("Hover Boards");
        itemsList.add("drones dji");
        itemsList.add("wireless mouse");
        itemsList.add("Iphone 11");
        return itemsList;
    }





}
