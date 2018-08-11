package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import Controller.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vmeeting extends javax.swing.JDialog {
    
    private ControllerMeeting controllerMeeting;
    
    public void setControllerMeeting(ControllerMeeting controllerMeeting){
        this.controllerMeeting = controllerMeeting;
        setListener();
    }
    public ControllerMeeting getControllerMeeting(){
        return controllerMeeting;
    }
    private void setListener(){
        newBtt.addActionListener(controllerMeeting);
        getTextSearch().addKeyListener(controllerMeeting);
        tableMeeting.addMouseListener(controllerMeeting);
    }

    public JTextField getTextSearch() {
        return TextSearch;
    }

    public void setTextSearch(JTextField TextSearch) {
        this.TextSearch = TextSearch;
    }

    public JTable gettableMeeting() {
        return tableMeeting;
    }

    public void setTableMeeting(JTable tableMeeting) {
        this.tableMeeting = tableMeeting;
    }

    public JLabel getCommend() {
        return commend;
    }

    public void setCommend(JLabel commend) {
        this.commend = commend;
    }

    public JButton getNewBtt() {
        return newBtt;
    }

    public void setNewBtt(JButton newBtt) {
        this.newBtt = newBtt;
    }
    
    public void close(){    
        try {
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Vmeeting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Creates new form Vmeeting
     * @param parent
     * @param modal
     */
    public Vmeeting(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        variablesForm();
        setTitle("Meeting");
        setResizable(false);
        setLocationRelativeTo(null);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void variablesForm() {

        jPanelTableMeeting = new org.edisoncor.gui.panel.Panel();
        header = new org.edisoncor.gui.panel.Panel();
        center = new javax.swing.JPanel();
        jPanelSearch = new javax.swing.JPanel();
        TextSearch = new javax.swing.JTextField();
        jPanelChoosing = new javax.swing.JPanel();
        newBtt = new javax.swing.JButton();
        exitBtt = new javax.swing.JButton();
        centerTable = new javax.swing.JPanel();
        jScrollPaneTable = new javax.swing.JScrollPane();
        tableMeeting = new javax.swing.JTable();
        footer = new javax.swing.JPanel();
        commend = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanelTableMeeting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/center.png"))); // NOI18N
        jPanelTableMeeting.setMaximumSize(new java.awt.Dimension(440, 451));
        jPanelTableMeeting.setPreferredSize(new java.awt.Dimension(440, 451));
        jPanelTableMeeting.setLayout(new java.awt.BorderLayout());

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/Meeting.png"))); // NOI18N
        header.setMaximumSize(new java.awt.Dimension(464, 75));
        header.setOpaque(false);
        header.setPreferredSize(new java.awt.Dimension(464, 75));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        jPanelTableMeeting.add(header, java.awt.BorderLayout.NORTH);

        center.setOpaque(false);
        center.setLayout(new java.awt.BorderLayout(0, 10));

        jPanelSearch.setForeground(new java.awt.Color(0, 0, 0));
        jPanelSearch.setOpaque(false);
        jPanelSearch.setPreferredSize(new java.awt.Dimension(442, 40));
        jPanelSearch.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 2));

        TextSearch.setForeground(new java.awt.Color(0, 0, 0));
        TextSearch.setPreferredSize(new java.awt.Dimension(500, 37));
        TextSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textSearchFocusGained(evt);
            }
        });
        TextSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textSearchKeyTyped(evt);
            }
        });
        jPanelSearch.add(TextSearch);

        center.add(jPanelSearch, java.awt.BorderLayout.NORTH);

        jPanelChoosing.setOpaque(false);
        jPanelChoosing.setPreferredSize(new java.awt.Dimension(448, 30));
        jPanelChoosing.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        newBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/new.png"))); // NOI18N
        newBtt.setBorderPainted(false);
        newBtt.setContentAreaFilled(false);
        newBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newBtt.setFocusPainted(false);
        newBtt.setPreferredSize(new java.awt.Dimension(150, 30));
        newBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBttActionPerformed(evt);
            }
        });
        jPanelChoosing.add(newBtt);

        exitBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/exit.png"))); // NOI18N
        exitBtt.setBorderPainted(false);
        exitBtt.setContentAreaFilled(false);
        exitBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtt.setFocusPainted(false);
        exitBtt.setPreferredSize(new java.awt.Dimension(150, 30));
        exitBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanelChoosing.add(exitBtt);

        center.add(jPanelChoosing, java.awt.BorderLayout.SOUTH);

        centerTable.setOpaque(false);
        centerTable.setLayout(new java.awt.BorderLayout());

        jScrollPaneTable.setOpaque(false);
        jScrollPaneTable.setPreferredSize(new java.awt.Dimension(500, 403));

        tableMeeting.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tableMeeting.setForeground(new java.awt.Color(0, 0, 0));
        tableMeeting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
            		"Phone", "Name", "Last Name", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMeeting.setToolTipText("Users");
        tableMeeting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableMeeting.setOpaque(false);
        tableMeeting.setPreferredSize(new java.awt.Dimension(450, 160));
        tableMeeting.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableMeetingKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tableMeetingKeyTyped(evt);
            }
        });
        jScrollPaneTable.setViewportView(tableMeeting);

        centerTable.add(jScrollPaneTable, java.awt.BorderLayout.CENTER);

        center.add(centerTable, java.awt.BorderLayout.CENTER);

        jPanelTableMeeting.add(center, java.awt.BorderLayout.CENTER);

        footer.setBackground(new java.awt.Color(0, 102, 255));
        footer.setOpaque(false);
        footer.setPreferredSize(new java.awt.Dimension(0, 30));
        footer.setLayout(new java.awt.BorderLayout());

        commend.setFont(new java.awt.Font("Serif", 2, 14)); // NOI18N
        commend.setForeground(new java.awt.Color(0, 0, 0));
        footer.add(commend, java.awt.BorderLayout.CENTER);

        jPanelTableMeeting.add(footer, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanelTableMeeting, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textSearchFocusGained
        String commend = "Fint the appointment you want, either to modify it or cancel it or even to process it";
        getCommend().setText(commend);
    }//GEN-LAST:event_textSearchFocusGained

    private void textSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyTyped
        //
    }//GEN-LAST:event_textSearchKeyTyped

    private void newBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBttActionPerformed

    }//GEN-LAST:event_newBttActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        try {
            //  getController().getModel().conexionClosed();
     getControllerMeeting().meeting.close();
            finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Vmeeting.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        
    }//GEN-LAST:event_exitActionPerformed

    private void tableMeetingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableMeetingKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMeetingKeyReleased

    private void tableMeetingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableMeetingKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMeetingKeyTyped

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextSearch;
    private org.edisoncor.gui.panel.Panel jPanelTableMeeting;
    private javax.swing.JTable tableMeeting;
    private javax.swing.JPanel centerTable;
    private javax.swing.JPanel center;
    private javax.swing.JButton exitBtt;
    private javax.swing.JPanel footer;
    private org.edisoncor.gui.panel.Panel header;
    private javax.swing.JPanel jPanelChoosing;
    private javax.swing.JPanel jPanelSearch;
    private javax.swing.JScrollPane jScrollPaneTable;
    private javax.swing.JLabel commend;
    private javax.swing.JButton newBtt;
    // End of variables declaration//GEN-END:variables
}
