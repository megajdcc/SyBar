package View;

import Controller.ControllerService;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Rservice extends javax.swing.JDialog {

    private ControllerService controllerService;
    
    public void setControllerService(ControllerService controllerService){
        this.controllerService = controllerService;
        setListener();
    }
    public ControllerService getControllerService(){
        return controllerService;
        
    }
    private void setListener(){
        registerBtt.addActionListener(controllerService);
        deleteBtt.addActionListener(controllerService);
        exitBtt.addActionListener(controllerService);
        price.addKeyListener(controllerService);
    }
    public JButton getDeleteBtt() {
        return deleteBtt;
    }

    public void setDeleteBtt(JButton deleteBtt) {
        this.deleteBtt = deleteBtt;
    }

    public JButton getExitBtt() {
        return exitBtt;
    }

    public void setExitBtt(JButton exitBtt) {
        this.exitBtt = exitBtt;
    }

    public JButton getRgisterBtt() {
        return registerBtt;
    }

    public void setRegisterBtt(JButton registerBtt) {
        this.registerBtt = registerBtt;
    }

    public JLabel getCommand() {
        return command;
    }

    public void setCommand(JLabel command) {
        this.command = command;
    }

    public JTextField getPrice() {
        return price;
    }

    public void setPrice(JTextField price) {
        this.price = price;
    }



    public JTextField getService() {
        return service;
    }

    public void setService(JTextField service) {
        this.service = service;
    }
    
    
    
    /**
     * Creates new form Rservice
     * @param parent
     * @param model
     */
    public Rservice(java.awt.Frame parent, boolean model) {
        super(parent, model);
        variablesForm();
        setTitle("Service");
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void variablesForm() {

        servicePanel = new org.edisoncor.gui.panel.Panel();
        header = new org.edisoncor.gui.panel.Panel();
        center = new javax.swing.JPanel();
        detailsService = new javax.swing.JPanel();
        details = new javax.swing.JPanel();
        serviceLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        service = new javax.swing.JTextField();
        jPanelChoosing = new javax.swing.JPanel();
        registerBtt = new javax.swing.JButton();
        deleteBtt = new javax.swing.JButton();
        exitBtt = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        command = new javax.swing.JLabel();


        servicePanel.setMaximumSize(new java.awt.Dimension(737, 504));
        servicePanel.setLayout(new java.awt.BorderLayout());

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/header/Service.png"))); // NOI18N
        header.setMaximumSize(new java.awt.Dimension(737, 75));
        header.setMinimumSize(new java.awt.Dimension(737, 75));
        header.setPreferredSize(new java.awt.Dimension(450, 75));

        javax.swing.GroupLayout gl_header = new javax.swing.GroupLayout(header);
        header.setLayout(gl_header);
        gl_header.setHorizontalGroup(
            gl_header.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
        );
        gl_header.setVerticalGroup(
            gl_header.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        servicePanel.add(header, java.awt.BorderLayout.NORTH);

        center.setOpaque(false);
        center.setLayout(new java.awt.BorderLayout());

        detailsService.setPreferredSize(new java.awt.Dimension(683, 70));

        details.setPreferredSize(new java.awt.Dimension(0, 140));

        serviceLabel.setFont(new java.awt.Font("Serif", 1, 14));
        serviceLabel.setForeground(new java.awt.Color(0, 0, 0));
        serviceLabel.setText("Service:");

        priceLabel.setFont(new java.awt.Font("Serif", 1, 14));
        priceLabel.setForeground(new java.awt.Color(0, 0, 0));
        priceLabel.setText("Price:");

        price.setFont(new java.awt.Font("Serif", 1, 12)); 
        price.setForeground(new java.awt.Color(0, 0, 0));
        price.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                priceFocusGained(evt);
            }
        });

        service.setFont(new java.awt.Font("Serif", 0, 12)); 
        service.setForeground(new java.awt.Color(0, 0, 0));
        service.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                serviceFocusGained(evt);
            }
        });

        javax.swing.GroupLayout gl_details = new javax.swing.GroupLayout(details);
        details.setLayout(gl_details);
        gl_details.setHorizontalGroup(
            gl_details.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_details.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(serviceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(service, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        gl_details.setVerticalGroup(
            gl_details.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_details.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(gl_details.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(service, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serviceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout gl_detailsService = new javax.swing.GroupLayout(detailsService);
        detailsService.setLayout(gl_detailsService);
        gl_detailsService.setHorizontalGroup(
            gl_detailsService.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_detailsService.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(details, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        gl_detailsService.setVerticalGroup(
            gl_detailsService.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_detailsService.createSequentialGroup()
                .addContainerGap()
                .addComponent(details, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
        );

        center.add(detailsService, java.awt.BorderLayout.CENTER);

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
                registerBttFocusGained(evt);
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

        center.add(jPanelChoosing, java.awt.BorderLayout.SOUTH);

        servicePanel.add(center, java.awt.BorderLayout.CENTER);

        footer.setPreferredSize(new java.awt.Dimension(450, 32));
        footer.setLayout(new java.awt.BorderLayout());

        command.setFont(new java.awt.Font("Serif", 1, 14)); 
        command.setForeground(new java.awt.Color(0, 0, 0));
        footer.add(command, java.awt.BorderLayout.CENTER);

        servicePanel.add(footer, java.awt.BorderLayout.SOUTH);

        getContentPane().add(servicePanel, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void registerBttFocusGained(java.awt.event.FocusEvent evt) {
        String txt = "Save";
        getCommand().setText(txt);
    }

    private void deleteFocusGained(java.awt.event.FocusEvent evt) {
        String txt = "Remove the service";
        getCommand().setText(txt);
    }

    private void exitFocusGained(java.awt.event.FocusEvent evt) {
        String txt = "exit";
        getCommand().setText(txt);
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void serviceFocusGained(java.awt.event.FocusEvent evt) {
        String txt = "Enter or modify the service";
        getCommand().setText(txt);
    }

    private void priceFocusGained(java.awt.event.FocusEvent evt) {
       String txt = "Enter or modify the price of the service";
        getCommand().setText(txt);
    }

    private javax.swing.JPanel detailsService;
    private javax.swing.JLabel serviceLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JPanel jPanelChoosing;
    private javax.swing.JPanel details;
    private javax.swing.JPanel center;
    private javax.swing.JButton deleteBtt;
    private javax.swing.JButton exitBtt;
    private javax.swing.JPanel footer;
    private javax.swing.JButton registerBtt;
    private org.edisoncor.gui.panel.Panel header;
    private javax.swing.JLabel command;
    private org.edisoncor.gui.panel.Panel servicePanel;
    private javax.swing.JTextField price;
    private javax.swing.JTextField service;

}
