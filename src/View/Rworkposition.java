package View;

import Controller.ControllerWorkPosition;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Rworkposition extends javax.swing.JDialog {

    private ControllerWorkPosition controllerWorkPosition;
    public void setControllerWorkPosition(ControllerWorkPosition controllerWorkPosition){
        this.controllerWorkPosition = controllerWorkPosition;
        setListener();
    }
    public ControllerWorkPosition getControllerWorkPosition(){
        return controllerWorkPosition;
    }
    private void setListener(){
        getExit().addActionListener(controllerWorkPosition);
        getDelete().addActionListener(controllerWorkPosition);
        getRegister().addActionListener(controllerWorkPosition);        
    }
    public JButton getExit() {
        return exitBtt;
    }

    public void setExit(JButton exit) {
        this.exitBtt = exit;
    }

    
    public JButton getDelete() {
        return deleteBtt;
    }

    public void setDelete(JButton delete) {
        this.deleteBtt = delete;
    }

    public JButton getRegister() {
        return registerBtt;
    }

    public void setRegister(JButton registerBtt) {
        this.registerBtt = registerBtt;
    }

    public JLabel getCommand() {
        return command;
    }

    public void setCommand(JLabel command) {
        this.command = command;
    }

    public JTextField getPosition() {
        return position;
    }

    public void setPosition(JTextField position) {
        this.position = position;
    }

    
    /**
     * Creates new form Rworkposition
     * @param parent
     * @param model
     */
    public Rworkposition(java.awt.Frame parent, boolean model) {
        super(parent, model);
        variablesForm();
        setTitle("Work Position");
        setResizable(false);
        setLocationRelativeTo(null);
    }


    private void variablesForm() {

        workPositionPanel = new org.edisoncor.gui.panel.Panel();
        header = new org.edisoncor.gui.panel.Panel();
        centerPanel = new javax.swing.JPanel();
        detailsPanel = new javax.swing.JPanel();
        detailsWorkPosition = new javax.swing.JPanel();
        positionLabel = new javax.swing.JLabel();
        position = new javax.swing.JTextField();
        jPanelChoosing = new javax.swing.JPanel();
        registerBtt = new javax.swing.JButton();
        deleteBtt = new javax.swing.JButton();
        exitBtt = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        command = new javax.swing.JLabel();

        getContentPane().setLayout(new java.awt.CardLayout());

        workPositionPanel.setMaximumSize(new java.awt.Dimension(737, 504));
        workPositionPanel.setLayout(new java.awt.BorderLayout());

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/header/Work position.png"))); // NOI18N
        header.setMaximumSize(new java.awt.Dimension(737, 75));
        header.setMinimumSize(new java.awt.Dimension(737, 75));
        header.setPreferredSize(new java.awt.Dimension(450, 75));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        workPositionPanel.add(header, java.awt.BorderLayout.NORTH);

        centerPanel.setOpaque(false);
        centerPanel.setLayout(new java.awt.BorderLayout());

        detailsPanel.setPreferredSize(new java.awt.Dimension(683, 100));

        detailsWorkPosition.setPreferredSize(new java.awt.Dimension(0, 140));

        positionLabel.setFont(new java.awt.Font("Serif", 1, 14)); 
        positionLabel.setForeground(new java.awt.Color(0, 0, 0));
        positionLabel.setText("position");

        position.setFont(new java.awt.Font("Serif", 0, 18));
        position.setForeground(new java.awt.Color(0, 0, 0));
        position.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                positionFocusGained(evt);
            }
        });

        javax.swing.GroupLayout gl_detailsWorkPosition = new javax.swing.GroupLayout(detailsWorkPosition);
        detailsWorkPosition.setLayout(gl_detailsWorkPosition);
        gl_detailsWorkPosition.setHorizontalGroup(
            gl_detailsWorkPosition.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_detailsWorkPosition.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gl_detailsWorkPosition.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(positionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        gl_detailsWorkPosition.setVerticalGroup(
            gl_detailsWorkPosition.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_detailsWorkPosition.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(positionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout gl_detailsPanel = new javax.swing.GroupLayout(detailsPanel);
        detailsPanel.setLayout(gl_detailsPanel);
        gl_detailsPanel.setHorizontalGroup(
            gl_detailsPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_detailsPanel.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(detailsWorkPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        gl_detailsPanel.setVerticalGroup(
            gl_detailsPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_detailsPanel.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailsWorkPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        centerPanel.add(detailsPanel, java.awt.BorderLayout.CENTER);

        jPanelChoosing.setPreferredSize(new java.awt.Dimension(450, 40));

        registerBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/save.png"))); 
        registerBtt.setBorderPainted(false);
        registerBtt.setContentAreaFilled(false);
        registerBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerBtt.setFocusPainted(false);
        registerBtt.setMaximumSize(new java.awt.Dimension(150, 30));
        registerBtt.setMinimumSize(new java.awt.Dimension(150, 30));
        registerBtt.setPreferredSize(new java.awt.Dimension(150, 30));
        registerBtt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                registerFocusGained(evt);
            }
        });
        jPanelChoosing.add(registerBtt);

        deleteBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/delete.png"))); 
        deleteBtt.setBorderPainted(false);
        deleteBtt.setContentAreaFilled(false);
        deleteBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtt.setFocusPainted(false);
        deleteBtt.setMaximumSize(new java.awt.Dimension(150, 30));
        deleteBtt.setMinimumSize(new java.awt.Dimension(150, 30));
        deleteBtt.setPreferredSize(new java.awt.Dimension(150, 30));
        deleteBtt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                deleteFocusGained(evt);
            }
        });
        jPanelChoosing.add(deleteBtt);

        exitBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/exit.png"))); 
        exitBtt.setBorderPainted(false);
        exitBtt.setContentAreaFilled(false);
        exitBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtt.setFocusPainted(false);
        exitBtt.setMaximumSize(new java.awt.Dimension(150, 30));
        exitBtt.setMinimumSize(new java.awt.Dimension(150, 30));
        exitBtt.setPreferredSize(new java.awt.Dimension(150, 30));
        exitBtt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                exitFocusGained(evt);
            }
        });
        exitBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanelChoosing.add(exitBtt);

        centerPanel.add(jPanelChoosing, java.awt.BorderLayout.SOUTH);

        workPositionPanel.add(centerPanel, java.awt.BorderLayout.CENTER);

        footer.setPreferredSize(new java.awt.Dimension(450, 32));
        footer.setLayout(new java.awt.BorderLayout());

        command.setFont(new java.awt.Font("Serif", 1, 14));
        command.setForeground(new java.awt.Color(0, 0, 0));
        footer.add(command, java.awt.BorderLayout.CENTER);

        workPositionPanel.add(footer, java.awt.BorderLayout.SOUTH);

        getContentPane().add(workPositionPanel, "card2");

        pack();
    }

    private void registerFocusGained(java.awt.event.FocusEvent evt) {
        String txt = "Save";
        getCommand().setText(txt);
    }

    private void deleteFocusGained(java.awt.event.FocusEvent evt) {
        String txt = "delete the position";
        getCommand().setText(txt);
    }

    private void exitFocusGained(java.awt.event.FocusEvent evt) {
        String leyend = "exit";
        getCommand().setText(leyend);
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void positionFocusGained(java.awt.event.FocusEvent evt) {
        String txt = "Enter or modify the work position";
        getCommand().setText(txt);
    }

   
    private javax.swing.JPanel detailsPanel;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JPanel jPanelChoosing;
    private javax.swing.JPanel detailsWorkPosition;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JButton deleteBtt;
    private javax.swing.JButton exitBtt;
    private javax.swing.JPanel footer;
    private javax.swing.JButton registerBtt;
    private org.edisoncor.gui.panel.Panel header;
    private javax.swing.JLabel command;
    private org.edisoncor.gui.panel.Panel workPositionPanel;
    private javax.swing.JTextField position;
    
}
