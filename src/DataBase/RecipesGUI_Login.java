package DataBase;

//sql imports

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
//Java Swing imports
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
//AWT imports
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RecipesGUI_Login extends JFrame {

    private static final long serialVersionUID = 1L;
    //fields
    private JTextField nameField = new JTextField(30);
    private JTextField addedUserField = new JTextField(30);
    private JTextField dateField = new JTextField(15);
    private JTextField idField = new JTextField(10);
    //username field
    private JTextField unametxt = new JTextField();
    //password field
    private JPasswordField jpf = new JPasswordField();
    //buttons
    private JButton login;
    private JButton addRecipe = new JButton("+add");

    //labels
    private JLabel welcome;
    private JLabel username;
    private JLabel password;
    private JLabel l;
    //panel
    private JPanel pan = new JPanel();

    public RecipesGUI_Login()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 40, 1014, 597);
        setResizable(false);
        pan = new JPanel();
        pan.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(pan);
        pan.setLayout(null);

        JLabel welcome = new JLabel("Recipe Database");
        welcome.setForeground(Color.BLACK);
        welcome.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        welcome.setBounds(400, 13, 273, 46);
        pan.add(welcome);

        unametxt = new JTextField();
        unametxt.setFont(new Font("Tahoma", Font.PLAIN, 32));
        unametxt.setBounds(481, 170, 281, 68);
        pan.add(unametxt);
        unametxt.setColumns(10);

        jpf = new JPasswordField();
        jpf.setFont(new Font("Tahoma", Font.PLAIN, 32));
        jpf.setBounds(481,286,281,68);
        pan.add(jpf);

        username = new JLabel("Username");
        username.setForeground(Color.BLACK);
        username.setBackground(Color.BLACK);
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(250, 166, 193, 52);
        pan.add(username);

        password = new JLabel("Password");
        password.setForeground(Color.BLACK);
        password.setBackground(Color.BLACK);
        password.setFont(new Font("Tahoma", Font.PLAIN, 32));
        password.setBounds(250, 286, 193, 52);
        pan.add(password);

        login = new JButton("Login");
        login.setFont(new Font("Tahoma", Font.PLAIN, 26));
        login.setBounds(545, 392, 162, 73);
        login.addActionListener(new ActionListener(){

            //gets the username and password from user input
            //and checks with the database if the credentials
            //are true or not
            public void actionPerformed(ActionEvent e){
                String unam = unametxt.getText().trim();
                String pword = jpf.getText().trim();

                try{
                    Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/recipes",
                            "root", "tIMOpa9559+");
                    Statement st = connect.createStatement();
                    String exe = "Select * from recipes.recipe where username='"+ unam + "' and password='" + pword + "'";


                    ResultSet rs = st.executeQuery(exe);

                    if(rs.next()) {
                        dispose();
                        RecipesGUI_Home obj = new RecipesGUI_Home(unam);
                        obj.setTitle("Recipes Home");
                        obj.setVisible(true);
                        JOptionPane.showMessageDialog(login, "You have successfully logged in");
                    }
                    else
                        JOptionPane.showMessageDialog(login, "Wrong Username and Password");

                }catch(SQLException s){
                    s.printStackTrace();
                }
            }

        });

        pan.add(login);

        l = new JLabel(" ");
        l.setBounds(0,0,1008,562);
        pan.add(l);

    }
}
