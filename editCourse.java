/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fee.management.system;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author sathw
 */
public class editCourse extends javax.swing.JFrame {
    DefaultTableModel model;
    /**
     * Creates new form editCourse
     */
    public editCourse() {
        initComponents();
        setRecordsTable();
    }
    
    public void setRecordsTable(){
        try{
            Connection Con=DBconnection.getConnection();
            PreparedStatement stmt=Con.prepareStatement("select * from course");
            ResultSet rs= stmt.executeQuery();
            while(rs.next()){
             String Courseid=rs.getString("Id");
             String Coursename=rs.getString("Course");
             String price=rs.getString("Cost");
             
             Object[] obj={Courseid,Coursename,price};
             model=(DefaultTableModel) tblcoursedata.getModel();
             model.addRow(obj);
             
             
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
    }
    public void addCourse(int id,String Coursename,int cost){
        try{
           Connection con=DBconnection.getConnection();
           PreparedStatement stmt=con.prepareStatement("insert into course values(?,?,?)");
           stmt.setInt(1, id);
           stmt.setString(2, Coursename);
           stmt.setInt(3, cost);
           int rowCount=stmt.executeUpdate();
           if(rowCount==1){
               JOptionPane.showMessageDialog(this, "Course added Successfully!!");
               clearTable();
               setRecordsTable();
               
           }
           else{
               JOptionPane.showMessageDialog(this, "Course addition Failed");
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Course addition Failed");
            
            e.printStackTrace();
        
    }
    }
    public void clearTable(){
        DefaultTableModel model=(DefaultTableModel) tblcoursedata.getModel();
        model.setRowCount(0);
    }
    
   public void update(int id,String Coursename,int cost){
        try{
           Connection con=DBconnection.getConnection();
           PreparedStatement stmt=con.prepareStatement("update course set Course=?,Cost=? where Id=?");
           
           stmt.setString(1, Coursename);
           stmt.setInt(2, cost);
           stmt.setInt(3, id);
           int rowCount=stmt.executeUpdate();
           if(rowCount==1){
               JOptionPane.showMessageDialog(this, "Course Updated Successfully!!");
               clearTable();
               setRecordsTable();
               
           }
           else{
               JOptionPane.showMessageDialog(this, "Course Updation Failed");
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Course Updation Failed");
            
            e.printStackTrace();
        
    }
    }
      public void delete(int id){
        try{
           Connection con=DBconnection.getConnection();
           PreparedStatement stmt=con.prepareStatement("delete from course where Id=?");
           
           
           stmt.setInt(1, id);
           int rowCount=stmt.executeUpdate();
           if(rowCount==1){
               JOptionPane.showMessageDialog(this, "Course deleted Successfully!!");
               clearTable();
               setRecordsTable();
               
           }
           else{
               JOptionPane.showMessageDialog(this, "Course deletion Failed");
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Course deletion Failed");
            
            e.printStackTrace();
        
    }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelsidebar = new javax.swing.JPanel();
        paneledit = new javax.swing.JPanel();
        btnedit = new javax.swing.JLabel();
        panelhome = new javax.swing.JPanel();
        btnhome = new javax.swing.JLabel();
        panelsearchrecord = new javax.swing.JPanel();
        btnsearchrecord = new javax.swing.JLabel();
        panelviewall = new javax.swing.JPanel();
        btnviewall = new javax.swing.JLabel();
        panellogout = new javax.swing.JPanel();
        btnlogout = new javax.swing.JLabel();
        panelback = new javax.swing.JPanel();
        btnback = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcoursedata = new javax.swing.JTable();
        txtcourseprice = new javax.swing.JTextField();
        txtcourseid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtcoursename = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelsidebar.setBackground(new java.awt.Color(255, 255, 255));
        panelsidebar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 102, 255), null, null));
        panelsidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneledit.setBackground(new java.awt.Color(153, 255, 255));
        paneledit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        paneledit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paneleditMouseEntered(evt);
            }
        });
        paneledit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnedit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnedit.setText("        Edit Course");
        btnedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btneditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btneditMouseExited(evt);
            }
        });
        paneledit.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, -1));

        panelsidebar.add(paneledit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 170, 40));

        panelhome.setBackground(new java.awt.Color(153, 255, 255));
        panelhome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelhomeMouseEntered(evt);
            }
        });
        panelhome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnhome.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnhome.setText("            Home");
        btnhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhomeMouseExited(evt);
            }
        });
        panelhome.add(btnhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, -1));

        panelsidebar.add(panelhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 170, 40));

        panelsearchrecord.setBackground(new java.awt.Color(153, 255, 255));
        panelsearchrecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 204, 255), null, null));
        panelsearchrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelsearchrecordMouseEntered(evt);
            }
        });
        panelsearchrecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnsearchrecord.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnsearchrecord.setText("      Search Record");
        btnsearchrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsearchrecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsearchrecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsearchrecordMouseExited(evt);
            }
        });
        panelsearchrecord.add(btnsearchrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, -1));

        panelsidebar.add(panelsearchrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 170, 40));

        panelviewall.setBackground(new java.awt.Color(153, 255, 255));
        panelviewall.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelviewall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelviewallMouseEntered(evt);
            }
        });
        panelviewall.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnviewall.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnviewall.setText("   View All Records");
        btnviewall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnviewallMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnviewallMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnviewallMouseExited(evt);
            }
        });
        panelviewall.add(btnviewall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, -1));

        panelsidebar.add(panelviewall, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 170, 40));

        panellogout.setBackground(new java.awt.Color(153, 255, 255));
        panellogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panellogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panellogoutMouseEntered(evt);
            }
        });
        panellogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnlogout.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnlogout.setText("          Logout ");
        btnlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlogoutMouseExited(evt);
            }
        });
        panellogout.add(btnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, -1));

        panelsidebar.add(panellogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 170, 40));

        panelback.setBackground(new java.awt.Color(153, 255, 255));
        panelback.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelbackMouseEntered(evt);
            }
        });
        panelback.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnback.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnback.setText("            Back");
        btnback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnbackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnbackMouseExited(evt);
            }
        });
        panelback.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, -1));

        panelsidebar.add(panelback, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 170, 40));

        getContentPane().add(panelsidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 190, 620));

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblcoursedata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course id", "Course name", "Course price"
            }
        ));
        tblcoursedata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblcoursedataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblcoursedata);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        txtcourseprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcoursepriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtcourseprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 120, -1));

        txtcourseid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcourseidActionPerformed(evt);
            }
        });
        jPanel1.add(txtcourseid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, -1));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        txtcoursename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcoursenameActionPerformed(evt);
            }
        });
        jPanel1.add(txtcoursename, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 120, -1));

        jLabel2.setText("Course Price:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel3.setText("Course Id:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel4.setText("Course Name:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jButton2.setBackground(new java.awt.Color(153, 255, 255));
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jButton3.setBackground(new java.awt.Color(153, 255, 255));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setText("EDIT COURSE DETAILS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("BACK");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 50, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btneditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(153,204,255);
        paneledit.setBackground(clr);
    }//GEN-LAST:event_btneditMouseEntered

    private void btneditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseExited
        // TODO add your handling code here:
        Color clr=new Color(153,255,255);
        paneledit.setBackground(clr);
    }//GEN-LAST:event_btneditMouseExited

    private void paneleditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneleditMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_paneleditMouseEntered

    private void btnhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseClicked
        // TODO add your handling code here:.
        home hm=new home();
        hm.show();
        this.dispose();
    }//GEN-LAST:event_btnhomeMouseClicked

    private void btnhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(153,204,255);
        panelhome.setBackground(clr);
    }//GEN-LAST:event_btnhomeMouseEntered

    private void btnhomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseExited
        // TODO add your handling code here:
        Color clr=new Color(153,255,255);
        panelhome.setBackground(clr);
    }//GEN-LAST:event_btnhomeMouseExited

    private void panelhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelhomeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panelhomeMouseEntered

    private void btnsearchrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchrecordMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(153,204,255);
        panelsearchrecord.setBackground(clr);
    }//GEN-LAST:event_btnsearchrecordMouseEntered

    private void btnsearchrecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchrecordMouseExited
        // TODO add your handling code here:
        Color clr=new Color(153,255,255);
        panelsearchrecord.setBackground(clr);
    }//GEN-LAST:event_btnsearchrecordMouseExited

    private void panelsearchrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsearchrecordMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panelsearchrecordMouseEntered

    private void btnviewallMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewallMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(153,204,255);
        panelviewall.setBackground(clr);
    }//GEN-LAST:event_btnviewallMouseEntered

    private void btnviewallMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewallMouseExited
        // TODO add your handling code here:
        Color clr=new Color(153,255,255);
        panelviewall.setBackground(clr);
    }//GEN-LAST:event_btnviewallMouseExited

    private void panelviewallMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelviewallMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panelviewallMouseEntered

    private void btnlogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(153,204,255);
        panellogout.setBackground(clr);
    }//GEN-LAST:event_btnlogoutMouseEntered

    private void btnlogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseExited
        // TODO add your handling code here:
        Color clr=new Color(153,255,255);
        panellogout.setBackground(clr);
    }//GEN-LAST:event_btnlogoutMouseExited

    private void panellogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panellogoutMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panellogoutMouseEntered

    private void btnbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(153,204,255);
        panelback.setBackground(clr);
    }//GEN-LAST:event_btnbackMouseEntered

    private void btnbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseExited
        // TODO add your handling code here:
        Color clr=new Color(153,255,255);
        panelback.setBackground(clr);
    }//GEN-LAST:event_btnbackMouseExited

    private void panelbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panelbackMouseEntered

    private void txtcoursepriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcoursepriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcoursepriceActionPerformed

    private void txtcourseidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcourseidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcourseidActionPerformed

    private void txtcoursenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcoursenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcoursenameActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int id=Integer.parseInt(txtcourseid.getText());
        String course=txtcoursename.getText();
        int cost=Integer.parseInt(txtcourseprice.getText());
        update(id,course,cost); 
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblcoursedataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcoursedataMouseClicked
        // TODO add your handling code here:
        int row=tblcoursedata.getSelectedRow();
        TableModel model=tblcoursedata.getModel();
        
        txtcourseid.setText(model.getValueAt(row, 0).toString());
        txtcoursename.setText(model.getValueAt(row, 1).toString());
        txtcourseprice.setText(model.getValueAt(row, 2).toString());
        
    }//GEN-LAST:event_tblcoursedataMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int id=Integer.parseInt(txtcourseid.getText());
        String course=txtcoursename.getText();
        int cost=Integer.parseInt(txtcourseprice.getText());
        addCourse(id,course,cost); 
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int id=Integer.parseInt(txtcourseid.getText());
        delete(id); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnsearchrecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchrecordMouseClicked
        // TODO add your handling code here:
        searchRecord sc=new searchRecord();
        sc.show();
        this.dispose();
    }//GEN-LAST:event_btnsearchrecordMouseClicked

    private void btnviewallMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewallMouseClicked
        // TODO add your handling code here:
        viewAllRecord var=new viewAllRecord();
        var.show();
        this.dispose();
    }//GEN-LAST:event_btnviewallMouseClicked

    private void btnbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnbackMouseClicked

    private void btnlogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseClicked
        // TODO add your handling code here:
        Login lg=new Login();
        lg.show();
        this.dispose();
    }//GEN-LAST:event_btnlogoutMouseClicked

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
            java.util.logging.Logger.getLogger(editCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnback;
    private javax.swing.JLabel btnedit;
    private javax.swing.JLabel btnhome;
    private javax.swing.JLabel btnlogout;
    private javax.swing.JLabel btnsearchrecord;
    private javax.swing.JLabel btnviewall;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelback;
    private javax.swing.JPanel paneledit;
    private javax.swing.JPanel panelhome;
    private javax.swing.JPanel panellogout;
    private javax.swing.JPanel panelsearchrecord;
    private javax.swing.JPanel panelsidebar;
    private javax.swing.JPanel panelviewall;
    private javax.swing.JTable tblcoursedata;
    private javax.swing.JTextField txtcourseid;
    private javax.swing.JTextField txtcoursename;
    private javax.swing.JTextField txtcourseprice;
    // End of variables declaration//GEN-END:variables
}
