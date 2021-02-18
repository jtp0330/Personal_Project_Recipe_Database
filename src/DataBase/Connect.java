package DataBase;


/***************************************
Class:Connect

Author: Jared Park

Description: 
The following class was designed as a sample code to familiarize myself
with Java Database Connectivity(JDBC) and connect to a database, created
in MySQL and accessed with the MySQL Workbench. 
*****************************************/

import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

public class Connect {

    static final String JDBC_DRiver = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "tIMOpa9559+";

    public static void main(String[] args){
        java.sql.Connection conn = null;
        Statement stmt = null;

        try {
            //step 2: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //step 3 open
            System.out.println("Connecting to data ase...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //step 4 exe query
            System.out.println("Creating database...");
            stmt = conn.createStatement();

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a number between 1-3 for different database operations");
            //
            System.out.println(" 1->create table in current schema in database, 2->insert new row into table, 3->print table");
            int input = scan.nextInt();

            while(input < 1 || input > 3){
                System.out.println("Invalid input. Please try again");
                input = scan.nextInt();
            }

            switch(input){

            /*
            //generally bad practice to create a database 
            //using jdbc
            //create database in mysql wrkbench
            case 1:
                int sql = stmt.executeUpdate("CREATE DATABASE recipes");
                System.out.println("Database created successfully...");
                break;
            */
            //create a table in the current database
            case 1:
                Scanner tb = new Scanner(System.in);
            	System.out.println("Enter a name for the Table: ");
            	String stb = tb.next();
            	//System.out.println(stb);
                String sqld = "USE recipes_storage_1";
                stmt.executeQuery(sqld);
                String sql2 = "CREATE TABLE "+ stb.toUpperCase()
                    + "(id INTEGER not NULL, "
                    + " name VARCHAR(255), "
                    + " uploadedBy VARCHAR(255), "
                    + " username VARCHAR(255), "
                    + " password VARCHAR(255), "
                    + " date DATE, "
                    + " recipe_url VARCHAR(255), "
                    + " PRIMARY KEY ( id ))";

                stmt.executeUpdate(sql2);
                System.out.println("Table created Successfully!");
                break;
            //insertion feature into table in current database-> another GUI is opened, which then prompts user to fillout all variables
            //for a new recipe in the table, enter will add it to the base

            case 2:
            //stores sample recipe into table of schema in database
            	Scanner ib = new Scanner(System.in);
            	System.out.println("Enter the table name you would like to add to: ");
            	String itb = ib.next();
            	insertID = 1;
            	String tsqld = "USE recipes_storage_1";
                stmt.executeQuery(tsqld);
                String ins_sql = "INSERT INTO " + itb.toUpperCase()+"(id, name, uploadedBy, username, password, date, recipe_url)"
                    + " VALUES ('" + insertID++ + "', 'Mashed Potatoes', 'Jared', 'root', 'tIMOpa9559+', '1998-01-23 22:42:15', 'www.allrecipes.com/mashed_potatoes')";
                stmt.executeUpdate(ins_sql);
                System.out.println("Row inserted successfully...");
                break;
            //printing table
            case 3:
                String sqlu = "USE USE recipes_storage_1";
                stmt.executeUpdate(sqlu);
                String printSQL = "SELECT id, name, uploadedBy, date, recipe_url FROM USE recipes_storage_1";
                ResultSet rs = stmt.executeQuery(printSQL);

                while(rs.next())
                {
                    int id = rs.getInt("id");
                    String ub = rs.getString("uploadedBy");
                    String n = rs.getString("name");
                    String d = rs.getString("date");
                    // int d = rs.getDate("date");
                    String ru = rs.getString("recipe_url");

                    System.out.println("ID: " + id);
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Uploaded_By: " + ub);
                    System.out.println("Date: " + rs.getDate("date"));
                    System.out.println("URL: " + ru);

                    System.out.println(id + "   |" + n + "   |"+ ub + "   |" + d + "   |" + ru);
                    System.out.println("______________________________________________________");


                }
                rs.close();
                break;
        }

            System.out.println("Database accessed successfully...");
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Bye!");
    }

}
