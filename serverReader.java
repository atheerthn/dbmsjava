package internproject;

import com.opencsv.CSVReader;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Atheerth
 */
public class serverReader extends JFrame {

    private JButton jButton1;
    private JButton jButton2;
    private JCheckBox jCheckBox2;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPasswordField jPasswordField1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTabbedPane jTabbedPane1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private javax.swing.JButton jButton3;
    private JButton jButton4;
    private JTable jtable;

    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private final JFileChooser openfilechooser;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    String server, database, userid, password;
    char[] pass;
    private boolean DEBUG = false;

    /**
     * Creates new form serverReader
     */
    public serverReader() {
        initComponents();
        openfilechooser = new JFileChooser();
        openfilechooser.setCurrentDirectory(new File("c:\\temp;"));

    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jComboBox1 = new JComboBox<>();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jButton1 = new JButton();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jLabel6 = new JLabel();
        jComboBox2 = new JComboBox<>();
        jCheckBox2 = new JCheckBox();
        jButton2 = new JButton();
        jPasswordField1 = new JPasswordField();
        jTabbedPane1 = new JTabbedPane();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jPanel3 = new JPanel();
        jScrollPane2 = new JScrollPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new MatteBorder(null));

        jLabel1.setText("Select a Datasource");

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"postgreSQL", "CSV"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Database server");

        jLabel3.setText("Database");

        jLabel4.setText("User ID");

        jLabel5.setText("password");

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jTextField1.setText("//127.0.0.1:5432");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField2.setText("internship");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField3.setText("postgres");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Available tables");

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Evaluate result");

        jButton2.setText("Start Analyzin");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////
        jLabel7.setText("Folder name");

        jLabel8.setText("File name");

        jButton3.setText("open file");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }

        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }

        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }

        });
////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////
        panel1db();
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        jTabbedPane1.setBorder(BorderFactory.createEtchedBorder());

        jButton4.setText("save as JSON file");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Data types", jPanel2);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Table", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jComboBox1.getSelectedItem().toString().equals("CSV")) {
            panel1csv();
        } else {
            panel1db();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="CSV Panel">  
    private void panel1csv() {
        jPanel1.removeAll();
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(32, 32, 32)
                                                .addComponent(jTextField5))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jCheckBox2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(67, 67, 67)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckBox2)
                                        .addComponent(jButton2))
                                .addGap(40, 40, 40))
        );

    }// </editor-fold>    

    // <editor-fold defaultstate="collapsed" desc="Data base Panel">  
    private void panel1db() {

        jPanel1.removeAll();
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addGap(57, 57, 57)
                                                                                .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel4)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel3)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel1)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel2)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(67, 67, 67))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jCheckBox2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                                .addGap(49, 49, 49))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jCheckBox2))
                                .addContainerGap())
        );

    } // </editor-fold>    

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        server = jTextField1.getText();

    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        database = jTextField2.getText();
    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        userid = jTextField3.getText();
        // TODO add your handling code here:
    }

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {
        pass = jPasswordField1.getPassword();

// TODO add your handling code here:
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        openfilechooser.setFileFilter(new FileNameExtensionFilter("", jComboBox1.getSelectedItem().toString()));

        int returnvalue = openfilechooser.showOpenDialog(this);
        if (returnvalue == JFileChooser.APPROVE_OPTION) {
            File file = openfilechooser.getSelectedFile();
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                //  jTextArea1.read(input, "READING FILE :-)");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Operation is CANCELLED :(");
        }
        jTextField4.setText(openfilechooser.getCurrentDirectory().toString());
        // jTextField5.setText(openfilechooser.getSelectedFile().toString());
        jTextField5.setText(openfilechooser.getSelectedFile().getName().toString());

    }

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        server = jTextField1.getText();
        database = jTextField2.getText();
        userid = jTextField3.getText();
        pass = jPasswordField1.getPassword();
        password = new String(pass);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(serverReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql:" + server + "/" + database, userid, password)) {

            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from information_schema.tables where table_type='BASE TABLE' and table_schema='public'");
            while (resultSet.next()) {
                System.out.printf("%-30.30s", resultSet.getString("table_name"));
                jComboBox2.addItem(resultSet.getString("table_name"));
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            System.out.println(server);
            System.out.println(database);
            System.out.println(userid);
            System.out.println(password);
            e.printStackTrace();
        }

    }

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jCheckBox2.isSelected()) {
            if (jComboBox1.getSelectedItem().toString().equals("CSV")) {
                csvtab2();
                csvtab1();

            } else {
                server = jTextField1.getText();
                database = jTextField2.getText();
                userid = jTextField3.getText();
                pass = jPasswordField1.getPassword();
                password = new String(pass);
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(serverReader.class.getName()).log(Level.SEVERE, null, ex);
                }

                tab1();
                tab2();

            }
        }
    }

    private void csvtab1() {
        System.out.println("csv started tab 1   ");
        try {

            // Create an object of filereader 
            // class with CSV file as a parameter. 
            FileReader filereader = new FileReader(openfilechooser.getSelectedFile());

            // create csvReader object passing 
            // file reader as a parameter 
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            // we are going to read data line by line 
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void csvtab2() {
        System.out.println("csv tab 2 started   ");
        try {

            // Create an object of filereader 
            // class with CSV file as a parameter. 
            FileReader filereader = new FileReader(openfilechooser.getSelectedFile());

            // create csvReader object passing 
            // file reader as a parameter 
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            // we are going to read data line by line 
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void tab1() {

        Vector<String> header;
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        boolean check;
        check = false;

        //  Object[][] rowdatas;//=new Object[][];
        MyTableModel model = new MyTableModel();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql:" + server + "/" + database, userid, password)) {

            System.out.println("Connected to PostgreSQL database!");
            Statement stmt = connection.createStatement();
            System.out.println("Reading  records...");
            String sql = "SELECT COLUMN_NAME,DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME ='" + jComboBox2.getSelectedItem().toString() + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                // Vector<String> rowdata = new Vector<String>();
                //  rowdata.add(rs.getString(1)); //Empid
                //  rowdata.add(rs.getString(2));//name
                //rowdata.add(check);
                model.addRow(new Object[]{false, rs.getString(1), rs.getString(2), "select encryption ", false});

                //  data.add(rowdata);
            }
            if (connection != null) {
                connection.close();
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        //  header = new Vector<String>();
        //header.add("Column Name");
        // header.add("Data Types ");
        //////////////////////////////////////////////////////////////
        /*   System.out.println("data "+data);
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++) {
            ArrayList subArray = (ArrayList) data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++) {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++) {
            columnNamesVector.add(columnNames.get(i));
        }
         */
        // JTable table = new JTable(data, header);
        jtable = new JTable(model);
        encriptColumn(jtable, jtable.getColumnModel().getColumn(3));
        jScrollPane1.setViewportView(jtable);
        pack();

    }

    void tab2() {
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql:" + server + "/" + database, userid, password)) {

            System.out.println("Connected to PostgreSQL database!");
            Statement stmt = connection.createStatement();
            System.out.println("Reading  records...");
            String sql = "SELECT * FROM " + jComboBox2.getSelectedItem().toString();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            for (int i = 1; i <= columns; i++) {
                columnNames.add(md.getColumnName(i));
            }

            while (rs.next()) {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++) {
                    row.add(rs.getObject(i));
                }

                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++) {
            ArrayList subArray = (ArrayList) data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++) {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++) {
            columnNamesVector.add(columnNames.get(i));
        }

        JTable table = new JTable(dataVector, columnNamesVector);

        jScrollPane2.setViewportView(table);

    }

    public void encriptColumn(JTable table, TableColumn encript) {
        //Set up the editor for the sport cells.
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("blank");
        comboBox.addItem("Mask");
        comboBox.addItem("Hash");
        comboBox.addItem("NO Encryption ");

        encript.setCellEditor(new DefaultCellEditor(comboBox));

        //Set up tool tips for the sport cells.
        DefaultTableCellRenderer renderer
                = new DefaultTableCellRenderer();
        renderer.setToolTipText("Click for combo box");
        encript.setCellRenderer(renderer);

    }

    public class MyTableModel extends DefaultTableModel {

        public MyTableModel() {
            super(new String[]{"Check", "Column name", "Data type", " Encryption type", "Validation"}, 0);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            Class clazz = String.class;
            switch (columnIndex) {
                case 0:
                    clazz = Boolean.class;
                    break;
                case 4:
                    clazz = Boolean.class;
                    break;
            }
            return clazz;
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            switch (column) {
                case 0:
                    return true;
                case 1:
                    return false;
                case 2:
                    return false;
                case 3:
                    return true;
                case 4:
                    return true;

            }
            return false;
        }

        @Override
        public void setValueAt(Object aValue, int row, int column) {
            if (aValue instanceof Boolean && column == 0) {
                System.out.println(aValue);
                Vector rowData = (Vector) getDataVector().get(row);
                rowData.setElementAt((boolean) aValue, column);
                fireTableCellUpdated(row, column);
            } else if (column == 3) {
                System.out.println(aValue);
                Vector rowData = (Vector) getDataVector().get(row);
                rowData.setElementAt(aValue, column);
                fireTableCellUpdated(row, column);

            } else if (aValue instanceof Boolean && column == 4) {
                System.out.println(aValue);
                Vector rowData = (Vector) getDataVector().get(row);
                rowData.setElementAt((boolean) aValue, column);
                fireTableCellUpdated(row, column);

            }
        }

    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

       
        try {
            for (int i = 0; i < jtable.getRowCount(); i++) {
                Boolean isChecked = Boolean.valueOf(jtable.getValueAt(i, 0).toString());
         
                String message="Saving as JSON file in system";
                if (isChecked) {
                    //get the values of the columns you need.
                    JOptionPane.showMessageDialog(null, message);
            
                } else {
                    System.out.printf("Row %d is not checked \n", i);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static void main(String args[]) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(serverReader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(serverReader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(serverReader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(serverReader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new serverReader().setVisible(true);
            }
        });
    }

}
