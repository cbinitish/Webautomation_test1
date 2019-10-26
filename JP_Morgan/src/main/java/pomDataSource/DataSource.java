package pomDataSource;

import databases.ConnectToSqlDB;
import utility.DataReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
    public static DataReader excelReader = new DataReader();

    // Insert Data from into Database
    public static List<String> insertDataIntoDB(){
        List<String> list = searchForAccount();
        connectToSqlDB = new ConnectToSqlDB();
        connectToSqlDB.insertStringDataFromArrayListToSqlTable(list,"AccountList","accounts");
        return list;
    }

//    public static List<String> getItemValue() {
//        List<String> itemsList = new ArrayList<String>();
//        itemsList.add("Eye Glasses");
//        itemsList.add("Backpacks");
//        itemsList.add("Energy Drinks");
//        itemsList.add("Hover Boards");
//        itemsList.add("DJI Mavic Pro 2");
//        itemsList.add("Lasers");
//        return itemsList;
//    }x

    public static List<String> searchForAccount(){
        List<String> itemsList = new ArrayList<String>();
        itemsList.add("saving account");
        itemsList.add("checking account");
        itemsList.add("credit cards");
        itemsList.add("CDS");
        itemsList.add("mortgage loans");
        itemsList.add("car loans");
        return itemsList;
    }


    //Database
    public static List<String> getItemsListFromDB() throws Exception, IOException, SQLException, ClassNotFoundException {
        List<String> list = new ArrayList<>();
        list = connectToSqlDB.readDataBase("", "items");
        return list;
    }
















    //Excel file
    public static List<String> getItemsListFromExcel() throws Exception, IOException, SQLException, ClassNotFoundException{
        //List<String> list = new ArrayList<String>(); ../Generic/browser-driver/chromedriver
        //String path = "../Generic/src/main/java/utility/CnnDataReadFromExcel1.xls";
        String path = "../Amazon/Data/AmazonDataReadFromExcel.xls";

        String[] myStringArray = excelReader.fileReader2(path, 0);
        for(int i=1;i<myStringArray.length; i++)
            System.out.print(myStringArray[i] + " ");
        ArrayList<String> list = new ArrayList<String>();

        // Using add() method to add elements in array_list
        //System.out.println();
        for (int i = 0; i < myStringArray.length; i++) {
            list.add(myStringArray[i]);
            //System.out.print(list.get(i+1) + " ");
        }
        return list;
    }
}
