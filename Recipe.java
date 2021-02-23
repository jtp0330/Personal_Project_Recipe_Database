//////////////////////////////////////////////////
/*
Name: Recipe
Author: Jared

Description:
The following program is designed to act as a sample
recipe that will be implemented into the main database
after each functionality works correctly. 

*/
//////////////////////////////////////////////////


package DataBase;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class Recipe
{
    private String name;
    private String addedUser;
    private String uname;
    private String pword;
    private String date;
    private String url;
    private int id;

    public Recipe(int i, String n, String ad, String un, String pw, String d, String u)
    {

        this.name = n;
        this.addedUser = ad;
        this.uname = un;
        this.pword = pw;
        this.date = d;
        this.url = u;
        this.id = i;
    }

    public void setName(String na){
        name = na;
    }

    public String getName(){
        return this.name;
    }

    public void setAddedUser(String ad){
        addedUser = ad;
    }

    public String getAddedUser()
    {
        return this.addedUser;
    }

    public void setUname(String una){ uname = una; }

    public String getUname(){ return this.uname;}

    public void setPword(String pwo){ pword = pwo;}

    public String getPword(){ return this.pword;}

    public void setDate(String d)
    {
        this.date = d;
    }

    public String getDate(){
        return this.date;
    }

    public void setUrl(String ur){
        this.url = ur;
    }

    public String getURL(){
        return this.url;
    }

    public void setID(int i)
    {
        this.id = i;
    }

    public int getID(){
        return this.id;
    }



}
