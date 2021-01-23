package DataBase;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

//awt imports

public class RecipesGUI_Home extends JFrame {

    private static final long serialVersionUID = 1;
    private JPanel pan;
    private JButton lgout;
    private JButton chgpwrd;
    private JButton addr;

    //Empty constructor
    public RecipesGUI_Home()
    {

    }

    public RecipesGUI_Home(String Userses)
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(150, 25, 1028,694);
        setResizable(false);
        pan = new JPanel();
        pan.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(pan);
        pan.setLayout(null);
        lgout = new JButton("Logout");
        lgout.setForeground(new Color(0,0,0));
        lgout.setBackground(UIManager.getColor("Button.disabledForeground"));
        lgout.setFont(new Font("Tahoma", Font.PLAIN, 39));
        lgout.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(lgout, "Are you Sure?");
                //JOptionPane.setRootFrame(null)
                if(a==JOptionPane.YES_OPTION)
                    dispose();
                    RecipesGUI_Login obj = new RecipesGUI_Login();
                    obj.setTitle("Recipes Login");
                    obj.setVisible(true);
                }
        });
        lgout.setBounds(247,100,491,114);
        pan.add(lgout);
        chgpwrd = new JButton("Change Password");
        chgpwrd.setBackground(UIManager.getColor("Button.disabledForeground"));
        chgpwrd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecipesGUI_Change_Password changePassword = new RecipesGUI_Change_Password(Userses);
                changePassword.setTitle("Change Password");
                changePassword.setVisible(true);

            }
        });
        chgpwrd.setFont(new Font("Tahoma", Font.PLAIN, 39));
        chgpwrd.setBounds(247,  260, 491, 114);
        pan.add(chgpwrd);

        //insertion feature, currently working on
        addr = new JButton("Add Recipe");
        addr.setForeground(new Color(0,0,0));
        addr.setBackground(UIManager.getColor("Button.disableForeground"));
        addr.setFont(new Font("Tahoma", Font.PLAIN, 39));
        addr.setBounds(247, 420, 491, 114);
        addr.addActionListener(new ActionListener() {
            //calls and opens the add recipe gui.
            //jdbc established to get the correct password corresponding to the current user's username.
            //both String variables needed to call add_recipe gui.
            public void actionPerformed(ActionEvent e) {

                try {
                    Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/recipes",
                            "root", "tIMOpa9559+");
                    Statement st = conn.createStatement();

                    String exe = "SELECT 'password' FROM recipe where username='" + Userses + "'";
                    ResultSet rs = st.executeQuery(exe);
                    if(rs.next()) {
                        String pwrd = rs.getString("password");
                        RecipesGUI_Add_Recipe add_recipe = new RecipesGUI_Add_Recipe(Userses, pwrd);
                        add_recipe.setTitle("Add Recipe");
                        add_recipe.setVisible(true);
                    }
                    rs.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
            }
        });
        pan.add(addr);


    }
    //Display all recipes button and action
    //code in progress


}
