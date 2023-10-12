package assignment9;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

class Citizen {

    String id;
    String name;
    String gender;
    String birthdate;
    String address;
    String phonenumber;
    String income;

    public Citizen(String id, String name, String gender, String birthdate, String address, String phonenumber, String income) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
        this.phonenumber = phonenumber;
        this.income = income;
        this.gender = gender;
    }
    public static String sortField = "income";

    //sort
    public int getIncome() {
        return Integer.parseInt(income);
    }

    public int compareTo(Integer key) {
        //return this.getIncome().compareTo(key);
        return Integer.compare(this.getIncome(), key);
    }

}

class CitizenIdComparator implements Comparator<Citizen> {

    @Override
    public int compare(Citizen e1, Citizen e2) {
        //return e1.getIncome().compareTo(e2.getIncome());
        return Integer.compare(e1.getIncome(), e2.getIncome());
    }
}

public class NewJFrame extends javax.swing.JFrame {

    Citizen[] array1;
    Citizen[] array2;
    Object[][] data;
    Object[][] data2;
    String[] header = {"ID", "Name", "Gender", "BirthDate", "Address", "PhoneNumber", "Income"};
    public static String sortField = "income";

    public static Citizen genCitizen() {
        Random r = new Random();
        // Generate a random string for the citizenId
        String temp = "";
        String num1 = "0123456789";
        for (int i = 0; i < 10; i++) { // 13
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
        String date = birthDate + "";
        // Generate a random String for the address
        String[] text3 = {"Bangkok", "Kamphaeng Phet Province", "Chai Nat Province", "Nakhon Nayok Province", "Nakhon Pathom Province", "Nakhon Sawan Province", "Nonthaburi Province", "Nonthaburi Province", "Phra Nakhon Si Ayutthaya Province", "Phichit Province"};
        String address = text3[r.nextInt(text3.length)];
        // Generate a random int for the income
        String income = r.nextInt(1000000 - 10000 + 1) + 10000 + "";
        // Generate a random String for the phoneNumber
        String phonefirst = r.nextBoolean() == true ? "08" : "09";
        String phonelast = r.nextInt(100000000 - 10000000 + 1) + 1000000 + "";
        String phone = phonefirst + "-" + phonelast;
        return new Citizen(id, name, gender, date, address, phone, income);
    }

    public void reset(Object[][] d, Citizen[] e) {
        String[] header = {"ID", "Name", "Gender", "BirthDate", "Address", "PhoneNumber", "Income"};
        data = d;
        array1 = e;
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

    public NewJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("assignment9.1-650710673-จักรพัชร คัชชาพงษ์");

        jButton1.setText("Gen Citizen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Sort Citizen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setText("show jTable1 and show jTable1 sort ");

        jLabel2.setText("Generate and Sort show milisecond");

        jLabel3.setText("Copy array1 or jTable1 to 100 object");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField1)
                                .addComponent(jScrollPane1))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        array1 = new Citizen[1_000_000];
        array2 = new Citizen[1_000_000];
        data = new Object[1_000_000][7];
        data2 = new Object[100][7];
        long start = System.nanoTime();
        for (int i = 0; i < array1.length; i++) {
            array1[i] = genCitizen();
            data[i][0] = array1[i].id;
            data[i][1] = array1[i].name;
            data[i][2] = array1[i].gender;
            data[i][3] = array1[i].birthdate;
            data[i][4] = array1[i].address;
            data[i][5] = array1[i].phonenumber;
            data[i][6] = array1[i].income;
        }
        long stop = System.nanoTime();
        jTextField1.setText("Generate Time :" + TimeUnit.NANOSECONDS.toMillis(stop - start) + " milisecond(" + TimeUnit.NANOSECONDS.toSeconds(stop - start) + " sec.)");
        for (int i = 0; i < 100; i++) {
            array2[i] = array1[i];
            data2[i][0] = array1[i].id;
            data2[i][1] = array1[i].name;
            data2[i][2] = array1[i].gender;
            data2[i][3] = array1[i].birthdate;
            data2[i][4] = array1[i].address;
            data2[i][5] = array1[i].phonenumber;
            data2[i][6] = array1[i].income;
        }
        DefaultTableModel model = new DefaultTableModel(data, header);
        jTable1.setModel(model);
        DefaultTableModel model2 = new DefaultTableModel(data2, header);
        jTable2.setModel(model2);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        if (data != null) {
            long start = System.nanoTime();
            Arrays.sort(array1, sortField.equals("income") ? new CitizenIdComparator() : new CitizenIdComparator());

            data = new Object[1_000_000][7];
            for (int i = 0; i < 1_000_000; i++) {
                data[i][0] = array1[i].id;
                data[i][1] = array1[i].name;
                data[i][2] = array1[i].gender;
                data[i][3] = array1[i].birthdate;
                data[i][4] = array1[i].address;
                data[i][5] = array1[i].phonenumber;
                data[i][6] = array1[i].income;
            }

            reset(data, array1);
            long stop = System.nanoTime();
            jTextField1.setText("Sort Time :" + TimeUnit.NANOSECONDS.toMillis(stop - start) + " milisecond(" + TimeUnit.NANOSECONDS.toSeconds(stop - start) + " sec.)");
            JOptionPane.showMessageDialog(this, "The data is now sorted by the '" + sortField + "' field", "Sort", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please generate the data first", "No data", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
