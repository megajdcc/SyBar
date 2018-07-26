
package View;

import Controller.ControllerWorkPosition;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;

public class Vworkposition extends javax.swing.JDialog {

    
    private ControllerWorkPosition controllerWorkPosition;
    
    public void setControllerWorkPosition(ControllerWorkPosition controllerWorkPosition){
        this.controllerWorkPosition = controllerWorkPosition;
        setListener();
    }
    public ControllerWorkPosition getControllerWorkPosition(){
        return controllerWorkPosition;
    }
    private void setListener(){
        newBtt.addActionListener(getControllerWorkPosition());
        workPositionTable.addMouseListener(getControllerWorkPosition());
        getTextSearch().addKeyListener(getControllerWorkPosition());
    }
    public JTextField getTextSearch() {
        return textSearch;
    }

    public void setTextSearch(JTextField textSearch) {
        this.textSearch = textSearch;
    }

    public JTable getWorkPositionTable() {
        return workPositionTable;
    }

    public void setWorkPositionTable(JTable workPositionTable) {
        this.workPositionTable = workPositionTable;
    }

    public JButton getExitBtt() {
        return exitBtt;
    }

    public void setExitBtt(JButton exitBtt) {
        this.exitBtt = exitBtt;
    }

    public JLabel getCommand() {
        return command;
    }

    public void setCommand(JLabel command) {
        this.command = command;
    }

    public JButton getNewBtt() {
        return newBtt;
    }

    public void setNewBtt(JButton newBtt) {
        this.newBtt = newBtt;
    }

    
    
    /** Creates new form Vworkposition
     * @param parent
     * @param model */
    public Vworkposition(java.awt.Frame parent, boolean model) {
        super(parent, model);
        variablesForm();
        setTitle("WorK Position");
        setResizable(false);
        setLocationRelativeTo(null);
       
    }

   
    private void variablesForm() {

        workPositionPanel = new org.edisoncor.gui.panel.Panel();
        workPositionPanel.setColorSecundario(Color.WHITE);
        workPositionPanel.setForeground(Color.WHITE);
        header = new org.edisoncor.gui.panel.Panel();
        center = new javax.swing.JPanel();
        jPanelSearch = new javax.swing.JPanel();
        textSearch = new javax.swing.JTextField();
        jPanelChoosing = new javax.swing.JPanel();
        newBtt = new javax.swing.JButton();
        exitBtt = new javax.swing.JButton();
        workPositionTablePanel = new javax.swing.JPanel();
        jScrollPaneTable = new javax.swing.JScrollPane();
        workPositionTable = new javax.swing.JTable();
        footer = new javax.swing.JPanel();
        command = new javax.swing.JLabel();

        getContentPane().setLayout(new java.awt.CardLayout());

        workPositionPanel.setMaximumSize(new java.awt.Dimension(440, 451));
        workPositionPanel.setPreferredSize(new java.awt.Dimension(440, 451));
        workPositionPanel.setLayout(new java.awt.BorderLayout());

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/Work_Position.jpg"))); 
        header.setMaximumSize(new java.awt.Dimension(464, 75));
        header.setOpaque(false);
        header.setPreferredSize(new java.awt.Dimension(464, 75));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        workPositionPanel.add(header, java.awt.BorderLayout.NORTH);

        center.setOpaque(false);
        center.setLayout(new java.awt.BorderLayout(0, 10));

        jPanelSearch.setForeground(new java.awt.Color(0, 0, 0));
        jPanelSearch.setOpaque(false);
        jPanelSearch.setPreferredSize(new java.awt.Dimension(442, 40));
        jPanelSearch.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 2));

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

        center.add(jPanelSearch, java.awt.BorderLayout.NORTH);

        jPanelChoosing.setOpaque(false);
        jPanelChoosing.setPreferredSize(new java.awt.Dimension(448, 30));
        jPanelChoosing.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        newBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/new.png")));
        newBtt.setBorderPainted(false);
        newBtt.setContentAreaFilled(false);
        newBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newBtt.setFocusPainted(false);
        newBtt.setMaximumSize(new java.awt.Dimension(150, 30));
        newBtt.setMinimumSize(new java.awt.Dimension(150, 30));
        newBtt.setPreferredSize(new java.awt.Dimension(150, 30));
        newBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nweBttActionPerformed(evt);
            }
        });
        jPanelChoosing.add(newBtt);

        exitBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/exit.png"))); 
        exitBtt.setBorderPainted(false);
        exitBtt.setContentAreaFilled(false);
        exitBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtt.setFocusPainted(false);
        exitBtt.setMaximumSize(new java.awt.Dimension(150, 30));
        exitBtt.setMinimumSize(new java.awt.Dimension(150, 30));
        exitBtt.setPreferredSize(new java.awt.Dimension(150, 30));
        exitBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanelChoosing.add(exitBtt);

        center.add(jPanelChoosing, java.awt.BorderLayout.SOUTH);

        workPositionTablePanel.setOpaque(false);
        workPositionTablePanel.setLayout(new java.awt.BorderLayout());

        jScrollPaneTable.setOpaque(false);
        jScrollPaneTable.setPreferredSize(new java.awt.Dimension(400, 403));

        workPositionTable.setFont(new java.awt.Font("Times New Roman", 0, 18)); 
        workPositionTable.setForeground(new java.awt.Color(0, 0, 0));
        workPositionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Work Position"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workPositionTable.setToolTipText("Users");
        workPositionTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        workPositionTable.setFillsViewportHeight(true);
        workPositionTable.setOpaque(false);
        workPositionTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                workPositionTableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                workPositionTableKeyTyped(evt);
            }
        });
        jScrollPaneTable.setViewportView(workPositionTable);

        workPositionTablePanel.add(jScrollPaneTable, java.awt.BorderLayout.CENTER);

        center.add(workPositionTablePanel, java.awt.BorderLayout.CENTER);

        workPositionPanel.add(center, java.awt.BorderLayout.CENTER);

        footer.setBackground(new java.awt.Color(0, 102, 255));
        footer.setOpaque(false);
        footer.setPreferredSize(new java.awt.Dimension(0, 30));
        footer.setLayout(new java.awt.BorderLayout());

        command.setFont(new java.awt.Font("Serif", 2, 14)); 
        command.setForeground(new java.awt.Color(0, 0, 0));
        footer.add(command, java.awt.BorderLayout.CENTER);

        workPositionPanel.add(footer, java.awt.BorderLayout.SOUTH);

        getContentPane().add(workPositionPanel, "card2");

        pack();
    }

    private void textSearchFocusGained(java.awt.event.FocusEvent evt) {
        String txt = "Find the corresponding job position";
        getCommand().setText(txt);
    }

    private void textSearchKeyTyped(java.awt.event.KeyEvent evt) {
    	
    }
  

    private void nweBttActionPerformed(java.awt.event.ActionEvent evt) {
    	
    }
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void workPositionTableKeyReleased(java.awt.event.KeyEvent evt) {
    	
    }

    private void workPositionTableKeyTyped(java.awt.event.KeyEvent evt) {
    	
    }
    
    private javax.swing.JTextField textSearch;
    private org.edisoncor.gui.panel.Panel workPositionPanel;
    private javax.swing.JTable workPositionTable;
    private javax.swing.JPanel workPositionTablePanel;
    private javax.swing.JPanel center;
    private javax.swing.JButton exitBtt;
    private javax.swing.JPanel footer;
    private org.edisoncor.gui.panel.Panel header;
    private javax.swing.JPanel jPanelChoosing;
    private javax.swing.JPanel jPanelSearch;
    private javax.swing.JScrollPane jScrollPaneTable;
    private javax.swing.JLabel command;
    private javax.swing.JButton newBtt;
   

}
