package View;

import Controller.ControllerEmployee;
import Controller.ControllerMeeting;
//import Controller.ControllerMeeting;
import Controller.ControllerUsers;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vemployee extends javax.swing.JDialog {

    private ControllerEmployee controllerEmployee;
    private ControllerUsers controllerUser;
    private ControllerMeeting controller2;

    public void setController(ControllerMeeting controller){
        this.controller2 = controller;
        setListener(controller2);
    }
    
    public void setControllerEmployee(ControllerEmployee controllerEmployee){
        this.controllerEmployee = controllerEmployee;
        setListener(controllerEmployee);
    }

    public ControllerEmployee getControllerEmployee(){
        return controllerEmployee;
    }
    
    private void setListener(ControllerMeeting controller){
    	newBtt.addActionListener(controller);
    	employeeTable.addMouseListener(controller);
    	getTextSearch().addKeyListener(controller);
  }
    
    private void setListener(ControllerEmployee controllerEmployee){
    	
          newBtt.addActionListener(controllerEmployee);
          employeeTable.addMouseListener(controllerEmployee);
          getTextSearch().addKeyListener(controllerEmployee);
    }

    private void setListener(ControllerUsers controllerUser){
          newBtt.addActionListener(controllerUser);
          employeeTable.addMouseListener(controllerUser);
          getTextSearch().addKeyListener(controllerUser);
    }
    public void setControllerUser(ControllerUsers controllerUser){
        this.controllerUser = controllerUser;
        setListener(controllerUser);
    }
    public ControllerUsers getControllerUser(){
        return controllerUser;
    }
    
    public JTextField getTextSearch() {
        return textSearch;
    }

    public void setTextSearch(JTextField textSearch) {
        this.textSearch = textSearch;
    }

    public JTable getEmployeeTable() {
        return employeeTable;
    }

    public void setEmployeeTable(JTable employeeTable) {
        this.employeeTable = employeeTable;
    }

    public JLabel getComment() {
        return comment;
    }

    public void setComment(JLabel comment) {
        this.comment = comment;
    }

    public JButton getNewBtt() {
        return newBtt;
    }

    public void setNewBtt(JButton newBt) {
        this.newBtt = newBt;
    }
    public void closed(){
        try {
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Vemployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Creates new form Vemployee
     * @param parent
     * @param model
     */
    public Vemployee(java.awt.Frame parent, boolean model) {
        super(parent, model);
        variablesForm();
        setTitle("Employees");
        setResizable(false);
        setLocationRelativeTo(null);

        
    }


    private void variablesForm() {

        employeePanel = new org.edisoncor.gui.panel.Panel();
        employeePanel.setColorSecundario(Color.WHITE);
        employeePanel.setForeground(Color.WHITE);
        centerPanel = new javax.swing.JPanel();
        jPanelSearch = new javax.swing.JPanel();
        jPanelChoosing = new javax.swing.JPanel();
        newBtt = new javax.swing.JButton();
        exitBt = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        jScrollPanelTable = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        footer = new javax.swing.JPanel();
        comment = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        employeePanel.setMaximumSize(new java.awt.Dimension(440, 451));
        employeePanel.setPreferredSize(new java.awt.Dimension(440, 451));
        employeePanel.setLayout(new java.awt.BorderLayout());

        centerPanel.setOpaque(false);
        centerPanel.setLayout(new java.awt.BorderLayout(0, 10));

        jPanelSearch.setForeground(new java.awt.Color(0, 0, 0));
        jPanelSearch.setOpaque(false);
        jPanelSearch.setPreferredSize(new java.awt.Dimension(442, 40));
        jPanelSearch.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 2));

        centerPanel.add(jPanelSearch, java.awt.BorderLayout.NORTH);
        textSearch = new javax.swing.JTextField();
        
                textSearch.setForeground(new java.awt.Color(0, 0, 0));
                textSearch.setPreferredSize(new java.awt.Dimension(400, 37));
                textSearch.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        textSearchFocusGained(evt);
                    }
                });
                textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        textSearchKeyTyped(evt);
                    }
                });
                jPanelSearch.add(textSearch);

        jPanelChoosing.setOpaque(false);
        jPanelChoosing.setPreferredSize(new java.awt.Dimension(448, 30));
        jPanelChoosing.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        newBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/new.png"))); 
        newBtt.setBorderPainted(false);
        newBtt.setContentAreaFilled(false);
        newBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newBtt.setFocusPainted(false);
        newBtt.setMinimumSize(new java.awt.Dimension(150, 30));
        newBtt.setPreferredSize(new java.awt.Dimension(150, 30));
        newBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtActionPerformed(evt);
            }
        });
        jPanelChoosing.add(newBtt);

        exitBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/exit.png"))); 
        exitBt.setBorderPainted(false);
        exitBt.setContentAreaFilled(false);
        exitBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBt.setFocusPainted(false);
        exitBt.setMinimumSize(new java.awt.Dimension(150, 30));
        exitBt.setPreferredSize(new java.awt.Dimension(150, 30));
        exitBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanelChoosing.add(exitBt);

        centerPanel.add(jPanelChoosing, java.awt.BorderLayout.SOUTH);

        tablePanel.setOpaque(false);
        tablePanel.setLayout(new java.awt.BorderLayout());

        jScrollPanelTable.setOpaque(false);
        jScrollPanelTable.setPreferredSize(new java.awt.Dimension(400, 403));

        employeeTable.setFont(new java.awt.Font("Times New Roman", 0, 18)); 
        employeeTable.setForeground(new java.awt.Color(0, 0, 0));
        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Last Name", "Phone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeTable.setToolTipText("Users");
        employeeTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeeTable.setOpaque(false);
        employeeTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                employeeTabelKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                employeeTabelKeyTyped(evt);
            }
        });
        header = new org.edisoncor.gui.panel.Panel();
        header.setColorSecundario(Color.WHITE);
        header.setForeground(Color.WHITE);
        
                header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/Employee.jpg"))); 
                header.setMaximumSize(new java.awt.Dimension(464, 75));
                header.setOpaque(false);
                header.setPreferredSize(new java.awt.Dimension(464, 75));
                
                        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
                        header.setLayout(headerLayout);
                        headerLayout.setHorizontalGroup(
                            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 440, Short.MAX_VALUE)
                        );
                        headerLayout.setVerticalGroup(
                            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 75, Short.MAX_VALUE)
                        );
                        
                                employeePanel.add(header, java.awt.BorderLayout.NORTH);
        jScrollPanelTable.setViewportView(employeeTable);

        tablePanel.add(jScrollPanelTable, java.awt.BorderLayout.CENTER);

        centerPanel.add(tablePanel, java.awt.BorderLayout.CENTER);

        employeePanel.add(centerPanel, java.awt.BorderLayout.CENTER);

        footer.setBackground(new java.awt.Color(0, 102, 255));
        footer.setOpaque(false);
        footer.setPreferredSize(new java.awt.Dimension(0, 30));
        footer.setLayout(new java.awt.BorderLayout());

        comment.setFont(new Font("Serif", Font.ITALIC, 16)); 
        comment.setForeground(new java.awt.Color(0, 0, 0));
        footer.add(comment, java.awt.BorderLayout.CENTER);

        employeePanel.add(footer, java.awt.BorderLayout.SOUTH);

        getContentPane().add(employeePanel, "card2");

        pack();
    }

    private void textSearchFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Find the corresponding employee";
        getComment().setText(text);
    }

    private void textSearchKeyTyped(java.awt.event.KeyEvent evt) {
        
    }

    private void newBtActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            this.finalize();
            this.setVisible(false);
            
            this.dispose();
        } catch (Throwable ex) {
            Logger.getLogger(Vemployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void employeeTabelKeyReleased(java.awt.event.KeyEvent evt) {
    	
    }

    private void employeeTabelKeyTyped(java.awt.event.KeyEvent evt) {
    
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {
    	
    }

    
    private javax.swing.JTextField textSearch;
    private org.edisoncor.gui.panel.Panel employeePanel;
    private javax.swing.JTable employeeTable;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JButton exitBt;
    private javax.swing.JPanel footer;
    private org.edisoncor.gui.panel.Panel header;
    private javax.swing.JPanel jPanelChoosing;
    private javax.swing.JPanel jPanelSearch;
    private javax.swing.JScrollPane jScrollPanelTable;
    private javax.swing.JLabel comment;
    private javax.swing.JButton newBtt;
}
