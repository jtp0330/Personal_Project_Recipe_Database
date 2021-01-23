package DataBase;

//***********************************************
/*
Name: Jared Park

Description:
The following 'Main' program is the driver class for the
Recipe Database. The following will call in instance of the RecipesGUI_Login class
to serve as the first step for accessing the database.
*/
//***********************************************
import java.awt.*;

public class Main {

    public static void main(String[] args) {


            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        RecipesGUI_Login frame = new RecipesGUI_Login();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            });

    }
}
