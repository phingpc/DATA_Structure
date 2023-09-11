package ass3sol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

class Employee implements Serializable, Comparable<String> {

    private String citizenId;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private String position;
    private int salary;

    public static String sortField = "id";

    Employee(String id, String n, String g, LocalDate b, LocalDate h, String p, int s) {
        citizenId = id;
        name = n;
        gender = g;
        birthDate = b;
        hireDate = h;
        position = p;
        salary = s;
    }

    public String toString() {
        return citizenId + "," + name + "," + gender + "," + birthDate + "," + hireDate + "," + position + "," + salary;
    }

    public String getId() {
        return citizenId;
    }

    public String getName() {
        return name;
    }

    public int compareTo(String key) {
        if (sortField.equals("id")) {
            return this.getId().compareTo(key);
        }

        return this.getName().compareTo(key);
    }
}

class EmployeeIdComparator implements Comparator<Employee> {

    public int compare(Employee e1, Employee e2) {
        return e1.getId().compareTo(e2.getId());
    }
}

class EmployeeNameComparator implements Comparator<Employee> {

    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}

public class NewJFrame extends javax.swing.JFrame {

    Object[][] data;
    Employee[] emps;
    String sortField = "id";

    public void reset(Object[][] d, Employee[] e) {
        String[] header = {"CitizenID", "Name", "Gender", "BirthDate", "HireDate", "Position", "Salary"};
        data = d;
        emps = e;
        DefaultTableModel model = new DefaultTableModel(data, header);
        jTable1.setModel(model);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(170);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
        TableCellRenderer rendererFromHeader = jTable1.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    public static Employee genData() {

        Random r = new Random();

        // Generate a random string for the citizenId
        String temp = "";
        String num1 = "0123456789";
        for (int i = 0; i < 3; i++) { // 13
            temp += num1.charAt(r.nextInt(num1.length()));
        }
        String id = temp;

        // Generate a random String for the name
        temp = "";
        String text1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String text2 = "abcdefghijklmnopqrstuvwxyz";
        int n = r.nextInt(10) + 2; // the first name's length
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                temp += text1.charAt(r.nextInt(text1.length()));
            } else {
                temp += text2.charAt(r.nextInt(text2.length()));
            }
        }
        temp += " "; // add a space between firstname and lastname
        n = r.nextInt(10) + 2; // the first name's length
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                temp += text1.charAt(r.nextInt(text1.length()));
            } else {
                temp += text2.charAt(r.nextInt(text2.length()));
            }
        }
        String name = temp;

        // Generate a random String for the gender field
        String gender = r.nextBoolean() == true ? "Male" : "Female";

        // Generate a LocalDate value for the birthDate value
        int year = r.nextInt(40) + 1963; // year 1963 - 2003 for the age between 20 - 60, 
        int month = r.nextInt(12) + 1;
        int day = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            day = r.nextInt(31) + 1;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = r.nextInt(30) + 1;
        } else { // for the Feb
            if (year % 4 == 0) { // leap year
                day = r.nextInt(29) + 1;
            } else {
                day = r.nextInt(28) + 1;
            }
        }
        LocalDate birthDate = LocalDate.of(year, month, day);

        // Generate a LocalDate value for the hireDate value
        year = r.nextInt(8) + 2015; // year 2015 - 2023
        month = r.nextInt(12) + 1;
        day = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            day = r.nextInt(31) + 1;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = r.nextInt(30) + 1;
        } else { // for the Feb
            if (year % 4 == 0) { // leap year
                day = r.nextInt(29) + 1;
            } else {
                day = r.nextInt(28) + 1;
            }
        }
        LocalDate hireDate = LocalDate.of(year, month, day);

        // Generate a random String for the position
        String[] text3 = {"Manager", "Programmer", "Engineer", "Accountant", "Data Scientist", "Tester", "Secretary", "Salesperson"};
        String position = text3[r.nextInt(text3.length)];

        // Generate a random int for the salary
        int salary = r.nextInt(100) * 100 + 15000;

        return new Employee(id, name, gender, birthDate, hireDate, position, salary);

    }

    public NewJFrame() {
        initComponents();
        reset(null, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Assignment-3: Sort and Search ===Solution===");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Gen Employee");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Load");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Sort");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jRadioButton1.setSelected(true);
        jRadioButton1.setText("id");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("name");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jTextField1.setText("key");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton6.setText("Binary Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2))
                    .addComponent(jTextField1)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addGap(35, 35, 35)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Gen employee button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        data = new Object[10][];
        emps = new Employee[10];
        for (int i = 0; i < 10; i++) {
            emps[i] = genData();
            data[i] = emps[i].toString().split(",");
        }

        reset(data, emps);
        /*
        String[] header = {"CitizenID", "Name", "Gender", "BirthDate", "HireDate", "Position", "Salary"};
        DefaultTableModel model = new DefaultTableModel(data, header);
        jTable1.setModel(model);
         */

    }//GEN-LAST:event_jButton1ActionPerformed

    // Reset button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        reset(null, null);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Save button
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (data != null) {
            try {
                FileOutputStream fos = new FileOutputStream("data.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(emps);
                oos.close();
                fos.close();
                JOptionPane.showMessageDialog(this, "Serialization data has been saved successfully", "Save", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
            };
        } else {
            JOptionPane.showMessageDialog(this, "Please generate the data first", "No data", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Load button
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        boolean dataOk = true;

        try {
            FileReader fileReader = new FileReader("data.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            Employee[] temp = new Employee[10];
            for (int i = 0; i < 10; i++) {
                String[] str = reader.readLine().split(",");
                temp[i] = new Employee(str[0], str[1], str[2], LocalDate.parse(str[3]), LocalDate.parse(str[4]), str[5], Integer.parseInt(str[6]));
            }
            emps = temp;
            reader.close();
            fileReader.close();

        } catch (Exception ep) {

            try {

                FileInputStream fis = new FileInputStream("data.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                Employee[] temp = new Employee[10];
                temp = (Employee[]) ois.readObject();
                ois.close();
                fis.close();
                emps = temp;
            } catch (Exception es) {
                JOptionPane.showMessageDialog(this, "Please generate and save the data first", "No data file", JOptionPane.WARNING_MESSAGE);
                dataOk = false;
            };

        };

        if (dataOk) {
            data = new Object[10][];
            for (int i = 0; i < 10; i++) {
                data[i] = emps[i].toString().split(",");
            }
            reset(data, emps);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    // tick to select the id
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jRadioButton2.setSelected(false);
        sortField = "id";
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    // tick to select the name
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jRadioButton1.setSelected(false);
        sortField = "name";
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    // Sort button
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (data != null) {

            Arrays.sort(emps, sortField.equals("id") ? new EmployeeIdComparator() : new EmployeeNameComparator());

            data = new Object[10][];
            for (int i = 0; i < 10; i++) {

                data[i] = emps[i].toString().split(",");
            }

            reset(data, emps);

            JOptionPane.showMessageDialog(this, "The data is now sorted by the '" + sortField + "' field", "Sort", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please generate the data first", "No data", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    // Binary Search button
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (data != null) {
            
            Employee.sortField = sortField;
            
            int index = Arrays.binarySearch(emps, jTextField1.getText());
            
            jTable1.getSelectionModel().clearSelection();
            if (index >= 0) {
                JOptionPane.showMessageDialog(this, "Found match record at index: "+index, "Search result", JOptionPane.INFORMATION_MESSAGE);
                jTable1.setRowSelectionInterval(index, index);
            }
            else{
                JOptionPane.showMessageDialog(this, "No match record found!!!", "Search result", JOptionPane.INFORMATION_MESSAGE);
            }

            //JOptionPane.showMessageDialog(this, "The data is now sorted by the '" + sortField + "' field", "Sort", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please generate the data first", "No data", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    // click on any row in the table
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int col = 0;
        int row = jTable1.getSelectedRow();
        if(sortField.equals("id"))
            col = 0;
        else
            col = 1;
        
        String value = jTable1.getModel().getValueAt(row, col).toString();
        jTextField1.setText(value);
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
