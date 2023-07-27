/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import static java.nio.file.Files.lines;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author PHinG Jakkaphat
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    class Traveler extends javax.swing.table.AbstractTableModel implements Serializable {

        public String passportID;
        public String name;
        public String gender;
        public int age;
        public String origin;
        public String destination;
        public Object[][] data = null;
        public String[] collumname = {"PassportID", "Name", "Gender", "Age", "Origin", "Destination"};

        public Traveler() {
            Random random = new Random(); // import Random
            //random PassportID
            int max_min_ID = 90 - 65 + 1; // max-min+1 and number is ascii code number
            int Passport_random1 = random.nextInt(max_min_ID) + 65;// first character
            int Passport_random2 = random.nextInt(max_min_ID) + 65;// second character
            String str_Passport = Character.toString(Passport_random1) + "" + Character.toString(Passport_random2);// convert to character
            int NumberPassport = 10000 - 1000;
            int Number_random = random.nextInt(NumberPassport) + 1000;
            this.passportID = str_Passport + "" + Number_random;
            //random Name
            int big_char_name = 90 - 65 + 1;
            int first_name_char1 = random.nextInt(big_char_name) + 65;
            int second_name_char2 = random.nextInt(big_char_name) + 65;
            int total_char_name = 10 - 2 + 1;// length firts name or last name (2 to 10)
            int max_fname = random.nextInt(total_char_name) + 2;// length first name
            int max_lname = random.nextInt(total_char_name) + 2;// length last name
            String firstname = "" + Character.toString(first_name_char1);// import charactor
            for (int i = 0; i < max_fname - 1; i++) {
                int name_random = random.nextInt(122 - 97 + 1) + 97;
                firstname += "" + Character.toString(name_random);// import
            }
            String lastname = "" + Character.toString(second_name_char2);
            for (int i = 0; i < max_lname - 1; i++) { //why -1 becuase String import first big character
                int name_random = random.nextInt(122 - 97 + 1) + 97;
                lastname += "" + Character.toString(name_random);
            }
            this.name = firstname + " " + lastname;
            // Random Gender
            int max_gender = 2;
            int Gender_random = random.nextInt(max_gender);
            if (Gender_random == 0) {
                this.gender = "Male";
            } else {
                this.gender = "Female";
            }
            // Random Age
            int max_age = 100;
            int Age_random = random.nextInt(max_age) + 1;
            this.age = Age_random;
            //Random Origin
            int max_origin = 7;
            int Origin_random = random.nextInt(max_origin);
            if (Origin_random == 0) {
                this.origin = "Japan";
            } else if (Origin_random == 1) {
                this.origin = "USA";
            } else if (Origin_random == 2) {
                this.origin = "Australia";
            } else if (Origin_random == 3) {
                this.origin = "Canada";
            } else if (Origin_random == 4) {
                this.origin = "China";
            } else if (Origin_random == 5) {
                this.origin = "Russia";
            } else {
                this.origin = "India";
            }
            //Random Destination
            int max_destination = 5;
            int Destination_random = random.nextInt(max_destination);
            if (Destination_random == 0) {
                this.destination = "Bangkok";
            } else if (Destination_random == 1) {
                this.destination = "Pattaya";
            } else if (Destination_random == 2) {
                this.destination = "Koh-samui";
            } else if (Destination_random == 3) {
                this.destination = "Phuket";
            } else {
                this.destination = "Burirum";
            }
            // end Random class //

        }

        public Traveler(Object[][] data) {
            this.data = data;
        }

        public String toString(int i) {
            return data[i][0] + "," + data[i][1] + "," + data[i][2] + "," + data[i][3] + "," + data[i][4] + "," + data[i][5];
        }

        ///////////////////////////////////////////////////
        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return collumname.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        // I'm write from sheet chapter-2
        @Override
        public String getColumnName(int col) {
            return collumname[col];
        }

        @Override
        public Class getColumnClass(int col) {
            return getValueAt(0, col).getClass();
        }
        //
    }

    public NewJFrame() {
        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "PassportID", "Name", "Gender", "Age", "Origin", "Destination"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Gen Traveler");
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

        jButton3.setText("save1");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("save2");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Load");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Object[][] data = new Object[10][6];
        for (int i = 0; i < 10; i++) {
            Traveler travel = new Traveler();
            data[i][0] = travel.passportID;
            data[i][1] = travel.name;
            data[i][2] = travel.gender;
            data[i][3] = travel.age;
            data[i][4] = travel.origin;
            data[i][5] = travel.destination;
        }

        //check data
        /*for (int i = 0; i < 10; i++) {
            System.out.println(data[i][0] + "/" + data[i][1] + "/" + data[i][2] + "/" + data[i][3] + "/" + data[i][4] + "/" + data[i][5]);
        }*/
        // test import data to Traveler Object :: it's work
        Traveler travel_data = new Traveler(data);
        jTable1.setModel(travel_data);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTable1.setModel(new javax.swing.table.DefaultTableModel(null,
                new String[]{"PassportID", "Name", "Gender", "Age", "Origin", "Destination"}
        ));
    }//GEN-LAST:event_jButton2ActionPerformed

    @SuppressWarnings("empty-statement")
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here: 
        //alert from (sheet chapter-2)
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
                Object[][]DATA = new Object[jTable1.getRowCount()][jTable1.getColumnCount()];
                for(int i=0; i<jTable1.getRowCount(); i++){
                    DATA[i][0] = jTable1.getValueAt(i, 0);
                    DATA[i][1] = jTable1.getValueAt(i, 1);
                    DATA[i][2] = jTable1.getValueAt(i, 2);
                    DATA[i][3] = jTable1.getValueAt(i, 3);
                    DATA[i][4] = jTable1.getValueAt(i, 4);
                    DATA[i][5] = jTable1.getValueAt(i, 5);
                    System.out.println(DATA[i][0]+","+DATA[i][1]+","+DATA[i][2]+","+DATA[i][3]+","+DATA[i][4]+","+DATA[i][5]);
                }
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    oos.writeObject(DATA);
                }
                System.out.println("Data serialized");//check
                oos.close();
                fos.close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        if (jTable1.getValueAt(0, 0) == null) {
            //alert from (sheet chapter-2)
            JOptionPane.showMessageDialog(this,
                    "You don't have DATA",
                    "No DATA",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            //write file (slide chapter-2)
            try {
                FileWriter filewrite = new FileWriter("d:/data.txt");
                PrintWriter printwrite = new PrintWriter(filewrite);
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    printwrite.println(jTable1.getValueAt(i, 0).toString() + "," + jTable1.getValueAt(i, 1).toString()
                            + "," + jTable1.getValueAt(i, 2).toString() + ","
                            + jTable1.getValueAt(i, 3).toString() + "," + jTable1.getValueAt(i, 4).toString() + ","
                            + jTable1.getValueAt(i, 5).toString());
                }
                printwrite.close();
                filewrite.close();
                System.out.println("Data Normal"); // check
            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        // import file .txt to show table
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            FileReader filereader = new FileReader("d:/data.txt");
            BufferedReader reader = new BufferedReader(filereader);
            for (int i = 0; i < 10; i++) {
                String[] str = reader.readLine().split(",");
                model.addRow(str);
            }

        } catch (Exception e) {
        }
        // import file .ser to show table
        try {
            String[] header = {"PassportID", "Name", "Gender", "Age", "Origin", "Destination"};
            Object[][] data = null;
            FileInputStream fis = new FileInputStream("d:/data.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = (Object[][]) ois.readObject(); // bug
            //System.out.println(data[1].toString()+"//");//why not output
            
            // pass
            DefaultTableModel model = new DefaultTableModel(data,header);
            jTable1.setModel(model);

        } catch (Exception e) {
             JOptionPane.showMessageDialog(this,
                    "No data file found (data.txt or data.ser).",
                    "Data Not Found",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
