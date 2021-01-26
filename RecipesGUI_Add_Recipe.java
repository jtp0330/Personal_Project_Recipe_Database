package DataBase;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.sql.*;
import java.sql.SQLException;

public class RecipesGUI_Add_Recipe extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel pan;
    private JLabel fill;
    private JLabel rName;
    private JTextField recipeName;
    private JLabel url;
    private JTextField urlstr;
    private JLabel image_url;
    private JTextField imurl;

    private JButton create;
    private Recipe r;


    public RecipesGUI_Add_Recipe(String user, String pword)
    {
        setBounds(360,450,550, 550);
        setResizable(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pan = new JPanel();
        pan.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(pan);
        pan.setLayout(null);

        fill = new JLabel("Fill Out the Following Information");
        fill.setFont(new Font("Tahoma", Font.PLAIN, 32));
        fill.setBounds(20, 120,300,68);
        pan.add(fill);

        rName = new JLabel("Recipe Name");
        rName.setBounds(30, 220,281,68);
        rName.setFont(new Font("Tahoma",Font.PLAIN,21));
        pan.add(rName);

        recipeName = new JTextField();
        recipeName.setBounds(180, 220, 281, 68);
        recipeName.setFont(new Font("Tahoma", Font.PLAIN, 21));
        pan.add(recipeName);
        recipeName.setColumns(5);

        url = new JLabel("URL");
        url.setBounds(100,300,281,68);
        url.setFont(new Font("Tahoma", Font.PLAIN,21));
        pan.add(url);

        urlstr = new JTextField();
        urlstr.setBounds(180,300,281,68);
        urlstr.setFont(new Font("Tahoma", Font.PLAIN, 21));
        pan.add(urlstr);
        urlstr.setColumns(20);

        create = new JButton("Add");
        create.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String s1 = recipeName.getText();
                String s2 = urlstr.getText();


                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime date = LocalDateTime.now();

                try {
                    Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/recipes",
                            "root", "tIMOpa9559+");
                    Statement st = conn.createStatement();
                    String exe1 = "SELECT 'uploadedBy' FROM Recipe where username ='user' ";
                    ResultSet rs = st.executeQuery(exe1);
                    if(rs.next()) {
                        String realName = rs.getString("uploadedBy");
                        int nextID = rs.getInt("ID");
                        r = new Recipe(++nextID, s1, realName, user, pword, dtf.format(date), s2);
                        String exe = "INSERT INTO recipes.recipe " + "VALUES ('" + r.getID() + "', '" + r.getName() + "', " + "'"
                                + r.getAddedUser() + "', " + "'" + r.getUname() + "', " + "'" + r.getPword() + "'"
                                + ", '" + r.getDate() +" ', " + "'" + r.getURL() + "')";
                        st.executeQuery(exe);

                    }
                    //Loop to ensure user fills out both textfields and refuses to add recipe
                    //until both fields are not empty.
                    //CURRENTLY IN DEVELOPMENT

                    /*

                    while(s1.isEmpty() || s2.isEmpty()) {
                        if(create.)
                        JOptionPane.showMessageDialog(create, "Both fields must be filled");
                        s1 = recipeName.getText();
                        s2 = urlstr.getText();

                        if (!s1.isEmpty() && !s2.isEmpty()) {
                            JOptionPane.showMessageDialog(create, "Your Recipe has been added successfully");
                            break;
                        } else {

                            s1 = recipeName.getText();
                            s2 = urlstr.getText();
                        }
                    }

                    */
                    JOptionPane.showMessageDialog(create, "Your Recipe has been added successfully");
                    rs.close();
                    dispose();

                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        });
    create.setFont(new Font("Tahoma", Font.PLAIN, 29));
    create.setBounds(350,420,170,59);
    pan.add(create);
    }

}
