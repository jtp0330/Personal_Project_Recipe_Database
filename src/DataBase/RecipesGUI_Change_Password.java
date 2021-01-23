package DataBase;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
//SQL imports
import java.sql.*;
import java.sql.SQLException;
//AWT imports
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RecipesGUI_Change_Password extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel pan;
    private JTextField newPword;
    private JLabel enp;
    private JButton enter;


    public RecipesGUI_Change_Password(String user)
    {
        setBounds(450,360,1024,234);
        setResizable(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pan = new JPanel();
        pan.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(pan);
        pan.setLayout(null);

        newPword = new JTextField();
        newPword.setFont(new Font("Tahoma", Font.PLAIN, 34));
        newPword.setBounds(373,35,609,67);
        pan.add(newPword);
        newPword.setColumns(10);

        enp = new JLabel("Enter New Password");
        enp.setFont(new Font("Tahoma", Font.PLAIN, 30));
        enp.setBounds(45, 37, 326, 67);
        pan.add(enp);

        enter = new JButton("Enter");
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ptr = newPword.getText();

                try{

                    Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/recipes",
                            "root", "tIMOpa9559+");
                    Statement st = conn.createStatement();
                    String exe = "UPDATE recipe SET password='"+ ptr + "' where username='" + user + "'";
                    st.executeUpdate(exe);
                    //exe
                    JOptionPane.showMessageDialog(enter, "Password has been successfully changed");

                }catch(SQLException sqer){
                    sqer.printStackTrace();
                }

            }
        });

        enter.setFont(new Font("Tahoma", Font.PLAIN, 29));
        enter.setBackground(new Color(240,240,240));
        enter.setBounds(438,127,170,59);
        pan.add(enter);
    }
}
