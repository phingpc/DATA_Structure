/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

class Employee implements Serializable {

    public int citizenid;
    public String name;
    public String gender;
    public String birthdate;
    public String hiredate;
    public String position;
    public int salary;

    public Employee(int a, String b, String c, String d, String f, String g, int h) {
        citizenid = a;
        name = b;
        gender = c;
        birthdate = d;
        hiredate = f;
        position = g;
        salary = h;
    }

    public Employee() {
        Random random = new Random();
        // Random citizenid
        int max_min_citizenid = 100000 - 10000 + 1;
        int random_citizenid = random.nextInt(max_min_citizenid) + 10000;
        this.citizenid = random_citizenid;
        //random name
        int big_char_name = 90 - 65 + 1;
        int first_name_char1 = random.nextInt(big_char_name) + 65;
        int second_name_char2 = random.nextInt(big_char_name) + 65;
        int total_char_name = 10 - 2 + 1;// length firts name or last name (2 to 10)
        int max_fname = random.nextInt(total_char_name) + 2;// length first name
        int max_lname = random.nextInt(total_char_name) + 2;// length last name
        String firstname = "" + Character.toString((char) first_name_char1);// import charactor
        for (int i = 0; i < max_fname - 1; i++) {
            int name_random = random.nextInt(122 - 97 + 1) + 97;
            firstname += "" + Character.toString((char) name_random);// import
        }
        String lastname = "" + Character.toString((char) second_name_char2);
        for (int i = 0; i < max_lname - 1; i++) { //why -1 becuase String import first big character
            int name_random = random.nextInt(122 - 97 + 1) + 97;
            lastname += "" + Character.toString((char) name_random);
        }
        this.name = firstname + " " + lastname;
        // random gender
        int max_gender = 2;
        int Gender_random = random.nextInt(max_gender);
        if (Gender_random == 0) {
            this.gender = "Male";
        } else {
            this.gender = "Female";
        }
        //random birthdate
        int max_Daybirth = 31;
        int max_monthbirth = 13;
        int random_Daybirth = random.nextInt(max_Daybirth) + 1;
        int random_monthbirth = random.nextInt(max_monthbirth) + 1;
        this.birthdate = random_Daybirth + "/" + random_monthbirth;
        //random hiredate
        int max_Dayhire = 31;
        int max_monthhire = 13;
        int random_Dayhire = random.nextInt(max_Dayhire) + 1;
        int random_monthhire = random.nextInt(max_monthhire) + 1;
        this.hiredate = random_Dayhire + "/" + random_monthhire;
        //random position
        int max_origin = 7;
        int Origin_random = random.nextInt(max_origin);
        if (Origin_random == 0) {
            this.position = "Frontend";
        } else if (Origin_random == 1) {
            this.position = "Backend";
        } else if (Origin_random == 2) {
            this.position = "Fullstack";
        } else if (Origin_random == 3) {
            this.position = "Lead dev";
        } else if (Origin_random == 4) {
            this.position = "Tester";
        } else if (Origin_random == 5) {
            this.position = "Dev app";
        } else {
            this.position = "Programmer";
        }
        //random salary
        int max_min_salary = 100000 - 15000 + 1;
        int random_salary = random.nextInt(max_min_salary) + 15000;
        this.salary = random_salary;
    }

    public String toString() {
        return citizenid + "," + name + "," + gender + "," + birthdate + "," + hiredate + "," + position + "," + salary;
    }

}

class Myarray {

    Object[][] data;
    Employee[] e;

    public Myarray(Object[][] data) {
        this.data = data;
    }
}

/**
 *
 * @author PHinG Jakkaphat
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    Object[][] data;
    Employee[] E;

    public void reset() {
        String[] header = {"CitizenID", "Name", "Gender", "BirthDate", "HireDate", "Position", "Salary"};
        data = null;
        E = null;
        DefaultTableModel model = new DefaultTableModel(data, header);
        jTable1.setModel(model);
    }

    public NewJFrame() {
        initComponents();
        reset();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sort & Search : 650710673 - จักรพัชร คัชชาพงษ์");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CitizendID", "name", "Gender", "BirthDate", "HireDate", "Position", "Salary"
            }
        ));
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

        jButton3.setText("Sort");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("load");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Binary Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Show Data select");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        data = new Object[10][7];
        E = new Employee[10];
        for (int i = 0; i < data.length; i++) {
            E[i] = new Employee();
            data[i][0] = E[i].citizenid;
            data[i][1] = E[i].name;
            data[i][2] = E[i].gender;
            data[i][3] = E[i].birthdate;
            data[i][4] = E[i].hiredate;
            data[i][5] = E[i].position;
            data[i][6] = E[i].salary;
            //System.out.println(data[i][0] + "/" + data[i][1] + "/");
        }
        System.out.println("Generate complete");
        String[] header = {"CitizenID", "Name", "Gender", "BirthDate", "HireDate", "Position", "Salary"};
        DefaultTableModel model = new DefaultTableModel(data, header);
        jTable1.setModel(model);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (data == null) {
            JOptionPane.showMessageDialog(this, "Please generate the data first", "No data", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Select the field to sort by
        String[] fields = {"CitizenID", "Name", "Gender", "BirthDate", "HireDate", "Position", "Salary"};
        String selectedField = (String) JOptionPane.showInputDialog(this, "Select a field to sort:", "Sort by", JOptionPane.PLAIN_MESSAGE, null, fields, fields[0]);

        // Check if the user selected a field
        if (selectedField != null) {
            int fieldIndex = -1;
            switch (selectedField) {
                case "CitizenID":
                    fieldIndex = 0;
                    break;
                case "Name":
                    fieldIndex = 1;
                    break;
                case "Gender":
                    fieldIndex = 2;
                    break;
                case "BirthDate":
                    fieldIndex = 3;
                    break;
                case "HireDate":
                    fieldIndex = 4;
                    break;
                case "Position":
                    fieldIndex = 5;
                    break;
                case "Salary":
                    fieldIndex = 6;
                    break;
            }

            // Sort the data based on the selected field
            sortDataByField(fieldIndex);

            // Convert the sorted Employee array to a 2D Object array for the table
            Object[][] sortedData = new Object[E.length][7];
            for (int i = 0; i < E.length; i++) {
                sortedData[i][0] = E[i].citizenid;
                sortedData[i][1] = E[i].name;
                sortedData[i][2] = E[i].gender;
                sortedData[i][3] = E[i].birthdate;
                sortedData[i][4] = E[i].hiredate;
                sortedData[i][5] = E[i].position;
                sortedData[i][6] = E[i].salary;
            }

            // Update the table model with the sorted data
            String[] header = {"CitizenID", "Name", "Gender", "BirthDate", "HireDate", "Position", "Salary"};
            DefaultTableModel model = new DefaultTableModel(sortedData, header);
            System.out.println("Sort complete");
            jTable1.setModel(model);
        }
    }

    private void sortDataByField(int fieldIndex) {
        // Use Arrays.sort() to sort the Employee array based on the selected field
        Arrays.sort(E, new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                // Use the fieldIndex to determine which field to compare
                switch (fieldIndex) {
                    case 0:
                        return Integer.compare(emp1.citizenid, emp2.citizenid);
                    case 1:
                        return emp1.name.compareTo(emp2.name);
                    case 2:
                        return emp1.gender.compareTo(emp2.gender);
                    case 3:
                        return emp1.birthdate.compareTo(emp2.birthdate);
                    case 4:
                        return emp1.hiredate.compareTo(emp2.hiredate);
                    case 5:
                        return emp1.position.compareTo(emp2.position);
                    case 6:
                        return Integer.compare(emp1.salary, emp2.salary);
                    default:
                        return 0;
                }
            }
        });
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (jTable1.getValueAt(0, 0) == null) {
            //alert from (sheet chapter-2)
            JOptionPane.showMessageDialog(this,
                    "You don't have DATA",
                    "No DATA",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            //write file to Export(slide chapter-2
            try {
                FileOutputStream fos = new FileOutputStream("d:/data.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                Object[][] DATA = new Object[jTable1.getRowCount()][jTable1.getColumnCount()];
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    DATA[i][0] = jTable1.getValueAt(i, 0);
                    DATA[i][1] = jTable1.getValueAt(i, 1);
                    DATA[i][2] = jTable1.getValueAt(i, 2);
                    DATA[i][3] = jTable1.getValueAt(i, 3);
                    DATA[i][4] = jTable1.getValueAt(i, 4);
                    DATA[i][5] = jTable1.getValueAt(i, 5);
                    DATA[i][6] = jTable1.getValueAt(i, 6);
                    //System.out.println(DATA[i][0] + "," + DATA[i][1] + "," + DATA[i][2] + "," + DATA[i][3] + "," + DATA[i][4] + "," + DATA[i][5] + "," + DATA[i][6]);
                }
                oos.writeObject(DATA);
                System.out.println("Data serialized");//check
                oos.close();
                fos.close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            FileInputStream fis = new FileInputStream("d:/data.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            //Object[][] data = null;
            data = (Object[][]) ois.readObject();
            ois.close();
            fis.close();
            String[] header = {"Citizenid", "Name", "Gender", "BirthDate", "HireDate", "Position", "Salary"};
            DefaultTableModel model = new DefaultTableModel(data, header);
            jTable1.setModel(model);

            E = new Employee[data.length];

            // Loop through the data and create new Employee objects to store in E
            for (int i = 0; i < data.length; i++) {
                int citizenid = Integer.parseInt(data[i][0].toString());
                String name = data[i][1].toString();
                String gender = data[i][2].toString();
                String birthdate = data[i][3].toString();
                String hiredate = data[i][4].toString();
                String position = data[i][5].toString();
                int salary = Integer.parseInt(data[i][6].toString());

                // Create a new Employee object and store it in the array
                E[i] = new Employee(citizenid, name, gender, birthdate, hiredate, position, salary);
            }

            System.out.println("Data Load Success");
        } catch (Exception es) {
            //JOptionPane.showMessageDialog(this, "Please generate and save the data first", "No data file", JOptionPane.WARNING_MESSAGE);
            System.out.println("Data Load Unsuccess");
        };
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        /*DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(jTextField1.getText().trim()));
        
        if (jTable1.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "Don't have data to search", "ไม่พบข้อมูล", JOptionPane.WARNING_MESSAGE);
        tr.setRowFilter(null);
        
        }*/
        if (data == null) {
            JOptionPane.showMessageDialog(this, "Please generate the data first", "No data", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String key = jTextField1.getText().trim();
        if (key.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a search key", "Missing search key", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String[] header = {"Citizen ID", "Name", "Gender", "Birth Date", "Hire Date", "Position", "Salary"};
        DefaultTableModel model = new DefaultTableModel(header, 0);

        boolean found = false;
        for (Object[] row : data) {
            for (Object cell : row) {
                if (cell.toString().toLowerCase().contains(key.toLowerCase())) {
                    model.addRow(row);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "No matching data found", "No data found", JOptionPane.INFORMATION_MESSAGE);
            jTable1.setModel(new DefaultTableModel(data, header));
        } else {
            jTable1.setModel(model);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String[] fields = {"CitizenID", "Name", "Gender", "BirthDate", "HireDate", "Position", "Salary"};
        TableModel modell = jTable1.getModel();
        int indexs[] = jTable1.getSelectedRows();
        Object[] row = new Object[10];
        DefaultTableModel model2 = new DefaultTableModel(null, fields);
        for (int i = 0; i < indexs.length; i++) {
            row[0] = modell.getValueAt(indexs[i], 0);
            row[1] = modell.getValueAt(indexs[i], 1);
            row[2] = modell.getValueAt(indexs[i], 2);
            row[3] = modell.getValueAt(indexs[i], 3);
            row[4] = modell.getValueAt(indexs[i], 4);
            row[5] = modell.getValueAt(indexs[i], 5);
            row[6] = modell.getValueAt(indexs[i], 6);
            model2.addRow(row);
        }
        jTable1.setModel(model2);
    }//GEN-LAST:event_jButton7ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
