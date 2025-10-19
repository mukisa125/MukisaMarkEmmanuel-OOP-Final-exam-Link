/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.student_registration_form;

/**
 *
 * @author Mukisa
 */
import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.JOptionPane;
public class StudentRegistrationForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(StudentRegistrationForm.class.getName());

    /**
     * Creates new form StudentRegistrationForm
     */
    public StudentRegistrationForm() {
        initComponents();
    }
    private boolean validateForm() {
    StringBuilder warnings = new StringBuilder();
    
    // Check required fields
    if (txtFirstName.getText().trim().isEmpty()) 
        warnings.append("• First Name is required\n");
    if (txtLastName.getText().trim().isEmpty()) 
        warnings.append("• Last Name is required\n");
    if (txtEmail.getText().trim().isEmpty()) 
        warnings.append("• Email is required\n");
    if (txtConfirmEmail.getText().trim().isEmpty()) 
        warnings.append("• Confirm Email is required\n");
    if (String.valueOf(txtPassword.getPassword()).isEmpty()) 
        warnings.append("• Password is required\n");
    if (String.valueOf(txtConfirmPassword.getPassword()).isEmpty()) 
        warnings.append("• Confirm Password is required\n");
    if (cmbYear.getSelectedItem() == null) 
        warnings.append("• Year is required\n");
    if (cmbMonth.getSelectedItem() == null) 
        warnings.append("• Month is required\n");
    if (cmbDay.getSelectedItem() == null) 
        warnings.append("• Day is required\n");
    if (!radMale.isSelected() && !radFemale.isSelected()) 
        warnings.append("• Gender is required\n");
    if (cmbDepartment.getSelectedItem() == null) 
        warnings.append("• Department is required\n");
    
    if (warnings.length() > 0) {
        JOptionPane.showMessageDialog(this, 
            "Please complete the following fields:\n" + warnings.toString(),
            "Incomplete Form", 
            JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    // Get values
    String email = txtEmail.getText().trim();
    String confirmEmail = txtConfirmEmail.getText().trim();
    String password = String.valueOf(txtPassword.getPassword());
    String confirmPassword = String.valueOf(txtConfirmPassword.getPassword());
    
    // Email validation
    if (!email.equals(confirmEmail)) {
        warnings.append("• Email and Confirm Email do not match\n");
    }
    
    if (!email.contains("@") || !email.contains(".")) {
        warnings.append("• Please enter a valid email address\n");
    }
    
    // Password validation
    if (password.length() < 8 || password.length() > 20) {
        warnings.append("• Password must be 8-20 characters long\n");
    }
    
    if (!password.matches(".*[A-Za-z].*")) {
        warnings.append("• Password must contain at least one letter\n");
    }
    
    if (!password.matches(".*\\d.*")) {
        warnings.append("• Password must contain at least one number\n");
    }
    
    if (!password.equals(confirmPassword)) {
        warnings.append("• Password and Confirm Password do not match\n");
    }
    
    // Age validation
    int year = (int) cmbYear.getSelectedItem();
    int month = (int) cmbMonth.getSelectedItem();
    int day = (int) cmbDay.getSelectedItem();
    LocalDate dob = LocalDate.of(year, month, day);
    int age = Period.between(dob, LocalDate.now()).getYears();
    
    if (age < 16 || age > 60) {
        warnings.append("• Age must be between 16 and 60 years\n");
    }
    
    if (warnings.length() > 0) {
        JOptionPane.showMessageDialog(this, 
            "Please check the following:\n" + warnings.toString(),
            "Validation Warnings", 
            JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    return true;
}
   private void updateDaysComboBox() {
    if (cmbYear.getSelectedItem() == null || cmbMonth.getSelectedItem() == null) {
        return;
    }
    
    try {
        // Convert String to int
        int year = Integer.parseInt(cmbYear.getSelectedItem().toString());
        int month = Integer.parseInt(cmbMonth.getSelectedItem().toString());
        
        cmbDay.removeAllItems();
        
        LocalDate date = LocalDate.of(year, month, 1);
        int daysInMonth = date.lengthOfMonth();
        
        for (int day = 1; day <= daysInMonth; day++) {
            cmbDay.addItem(String.valueOf(day)); // Add as String
        }
        
        // Auto-select first day after update
        if (daysInMonth > 0) {
            cmbDay.setSelectedIndex(0);
        }
        
    } catch (Exception e) {
        System.out.println("Date update error: " + e.getMessage());
    }
}
    private void cmbYearActionPerformed(java.awt.event.ActionEvent evt) {
    updateDaysComboBox();
}

private void cmbMonthActionPerformed(java.awt.event.ActionEvent evt) {
    updateDaysComboBox();
}
private String generateID() {
    int currentYear = LocalDate.now().getYear();
    int nextNumber = getNextStudentNumber(currentYear);
    return String.format("%d-%05d", currentYear, nextNumber);
}

private int getNextStudentNumber(int year) {
    int maxNumber = 0;
    
    try {
        File file = new File("students.csv");
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(year + "-")) {
                    try {
                        String[] parts = line.split(",");
                        String idPart = parts[0];
                        String numberStr = idPart.split("-")[1];
                        int currentNum = Integer.parseInt(numberStr);
                        if (currentNum > maxNumber) {
                            maxNumber = currentNum;
                        }
                    } catch (Exception e) {
                        // Skip invalid lines
                    }
                }
            }
            reader.close();
        }
    } catch (IOException e) {
        // File doesn't exist, start from 1
    }
    
    return maxNumber + 1;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtConfirmEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbMonth = new javax.swing.JComboBox<>();
        cmbYear = new javax.swing.JComboBox<>();
        cmbDay = new javax.swing.JComboBox<>();
        radMale = new javax.swing.JRadioButton();
        radFemale = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmPassword = new javax.swing.JPasswordField();
        cmbDepartment = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("New Student Registration Form");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Student First Name");

        txtFirstName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtLastName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Student Last Name");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Email Address");

        txtConfirmEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Confirm Email Address");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Password");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Confirm Password");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Date of Birth");

        cmbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Month", "Item 2", "Item 3", "Item 4" }));

        cmbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Year", "2010", "2009", "2008", "2007", "2006" }));

        cmbDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Day", "Item 3", "Item 4" }));

        radMale.setText("Male");

        radFemale.setText("Female");
        radFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radFemaleActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Department");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Canacle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Your Data Below");

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtConfirmPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cmbDepartment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department", "Item 2", "Item 3", "Item 4" }));

        txtOutput.setColumns(20);
        txtOutput.setRows(5);
        jScrollPane1.setViewportView(txtOutput);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("MUKISA MARK EMMANUEL - VU-BIT-2507-3059-DAY ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(43, 43, 43)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(43, 43, 43)
                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radMale)
                                        .addGap(30, 30, 30)
                                        .addComponent(radFemale))
                                    .addComponent(cmbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(txtConfirmPassword))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtConfirmEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(txtPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cmbDay, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel11)
                        .addGap(0, 48, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtConfirmEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radMale)
                            .addComponent(radFemale))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radFemaleActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
           if (!validateForm()) {
        return; // Stop if validation fails
    }
    
    try {
        // Generate student ID
        String studentID = generateID();
        
        // Get all form values
        String firstName = txtFirstName.getText().trim();
        String lastName = txtLastName.getText().trim();
        String email = txtEmail.getText().trim();
        String gender = radMale.isSelected() ? "M" : "F";
        String department = cmbDepartment.getSelectedItem().toString();
        
        // Get date values (convert from String to int)
        int year = Integer.parseInt(cmbYear.getSelectedItem().toString());
        int month = Integer.parseInt(cmbMonth.getSelectedItem().toString());
        int day = Integer.parseInt(cmbDay.getSelectedItem().toString());
        String dob = String.format("%d-%02d-%02d", year, month, day);
        
        // Format the output display
        String output = String.format("ID: %s | %s %s | %s | %s | %s | %s",
            studentID, firstName, lastName, gender, department, dob, email);
        
        // Display in output area
        txtOutput.setText(output);
        
        // Save to CSV file
        saveToCSV(studentID, firstName + " " + lastName, gender, department, dob, email);
        
        // Show success message
        JOptionPane.showMessageDialog(this, 
            "Registration Successful!\nStudent ID: " + studentID,
            "Success", 
            JOptionPane.INFORMATION_MESSAGE);
        
    } catch (Exception ex) {
        // Show error message if something goes wrong
        JOptionPane.showMessageDialog(this, 
            "Error processing form: " + ex.getMessage(),
            "Processing Error", 
            JOptionPane.WARNING_MESSAGE);
    }
}

// Add this saveToCSV method in your class
private void saveToCSV(String id, String fullName, String gender, String department, String dob, String email) {
    try {
        File file = new File("students.csv");
        boolean fileExists = file.exists();
        
        FileWriter writer = new FileWriter(file, true);
        
        // Write header if file is new
        if (!fileExists) {
            writer.write("ID,Full Name,Gender,Department,Date of Birth,Email\n");
        }
        
        // Write student data
        String csvLine = String.format("%s,%s,%s,%s,%s,%s\n", 
            id, fullName, gender, department, dob, email);
        writer.write(csvLine);
        writer.close();
        
        System.out.println("Data saved to students.csv");
        
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, 
            "Error saving to file: " + e.getMessage(),
            "File Error", 
            JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new StudentRegistrationForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cmbDay;
    private javax.swing.JComboBox<String> cmbDepartment;
    private javax.swing.JComboBox<String> cmbMonth;
    private javax.swing.JComboBox<String> cmbYear;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radFemale;
    private javax.swing.JRadioButton radMale;
    private javax.swing.JTextField txtConfirmEmail;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextArea txtOutput;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
