package DataBase;
import java.awt.Image;

public class Recipe
{
    private Image pic;
    private String name;
    private String addedUser;
    private String uname;
    private String pword;
    private String date;
    private String url;
    private int id;

    public Recipe(Image p, String n, String ad, String un, String pw, String d, String u, int i)
    {
        this.pic = p;
        this.name = n;
        this.addedUser = ad;
        this.uname = un;
        this.pword = pw;
        this.date = d;
        this.url = u;
        this.id = i;
    }

    public void setURL(Image pi){
        this.pic = pi;
    }

    public Image getPic()
    {
        return this.pic;
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
