package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import Controller.*;
import javax.swing.ButtonGroup;

public class Rclient extends javax.swing.JDialog {

    private ControllerClient controllerClient;
    public void setControllerClient(ControllerClient controller){
        this.controllerClient = controller;
        setListener();
    }
    public ControllerClient getControllerClient(){
        return controllerClient;
    }
    private void setListener(){
        register.addActionListener(controllerClient);
        delete.addActionListener(controllerClient);
        exit.addActionListener(controllerClient);
        
        phone.addKeyListener(controllerClient);
        maill.addKeyListener(controllerClient);
    }
    public JRadioButton getMan() {
        return man;
    }

    public void setMan(JRadioButton Man) {
        this.man = Man;
    }

    public JRadioButton getWom() {
        return wom;
    }

    public void setWom(JRadioButton Wom) {
        this.wom = Wom;
    }

    public JButton getDelete() {
        return delete;
    }

    public void setDelete(JButton delete) {
        this.delete = delete;
    }
 
    public JButton getExit() {
        return exit;
    }

    public void setExit(JButton exit) {
        this.exit = exit;
    }

    public JButton getRegister() {
        return register;
    }

    public void setRegister(JButton register) {
        this.register = register;
    }

    public JTextField getLastName() {
        return lastName;
    }

    public void setLastName(JTextField lastName) {
        this.lastName = lastName;
    }

    public JLabel getComment() {
        return comment;
    }

    public void setComment(JLabel comment) {
        this.comment = comment;
    }

    public JTextField getMaill() {
        return maill;
    }

    public void setMaill(JTextField mail) {
        this.maill = mail;
    }
  
    public JTextField getNamee() {
        return name;
    }

    public void setName(JTextField name) {
        this.name = name;
    }

    public JTextField getPhone() {
        return phone;
    }

    public void setPhone(JTextField phone) {
        this.phone = phone;
    }



    public ButtonGroup getGender() {
        return gender;
    }

    public void setGender(ButtonGroup gender) {
        this.gender = gender;
    }

    public JTextField getId() {
        return id;
    }

    public void setId(JTextField id) {
        this.id = id;
    }

    

    public Rclient(java.awt.Frame parent, boolean model) {
        super(parent, model);
        variablesForm();
        setTitle("Client");
        setResizable(false);
        setLocationRelativeTo(null);

    }


    private void variablesForm() {

        gender = new javax.swing.ButtonGroup();
        panel1 = new org.edisoncor.gui.panel.Panel();
        header = new org.edisoncor.gui.panel.Panel();
        center = new javax.swing.JPanel();
        panelDetails = new javax.swing.JPanel();
        clientDeatils = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastName = new javax.swing.JTextField();
        man = new javax.swing.JRadioButton();
        wom = new javax.swing.JRadioButton();
        mailLabel = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        maill = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        registerJPanel = new javax.swing.JPanel();
        register = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        comment = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel1.setMaximumSize(new java.awt.Dimension(737, 504));
        panel1.setLayout(new java.awt.BorderLayout());

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/header/Client.png"))); 
        header.setMaximumSize(new java.awt.Dimension(737, 75));
        header.setMinimumSize(new java.awt.Dimension(737, 75));

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

        panel1.add(header, java.awt.BorderLayout.NORTH);

        center.setOpaque(false);
        center.setLayout(new java.awt.BorderLayout());

        panelDetails.setPreferredSize(new java.awt.Dimension(683, 150));

        clientDeatils.setPreferredSize(new java.awt.Dimension(0, 140));

        nameLabel.setFont(new java.awt.Font("Serif", 1, 12)); 
        nameLabel.setForeground(new java.awt.Color(0, 0, 0));
        nameLabel.setText("Name:");

        genderLabel.setFont(new java.awt.Font("Serif", 1, 12)); 
        genderLabel.setForeground(new java.awt.Color(0, 0, 0));
        genderLabel.setText("Gender:");

        phoneLabel.setFont(new java.awt.Font("Serif", 1, 12)); 
        phoneLabel.setForeground(new java.awt.Color(0, 0, 0));
        phoneLabel.setText("Phone:");

        name.setForeground(new java.awt.Color(0, 0, 0));
        name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameFocusGained(evt);
            }
        });

        lastNameLabel.setFont(new java.awt.Font("Serif", 1, 12)); 
        lastNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        lastNameLabel.setText("Last Name:");

        lastName.setForeground(new java.awt.Color(0, 0, 0));
        lastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastNameFocusGained(evt);
            }
        });

        gender.add(man);
        man.setText("M");
        man.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ManFocusGained(evt);
            }
        });

        gender.add(wom);
        wom.setText("F");
        wom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                WomFocusGained(evt);
            }
        });

        mailLabel.setFont(new java.awt.Font("Serif", 1, 12)); 
        mailLabel.setForeground(new java.awt.Color(0, 0, 0));
        mailLabel.setText("Maill:");

        phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneKeyTyped(evt);
            }
        });

        maill.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mailFocusGained(evt);
            }
        });
        maill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mailKeyTyped(evt);
            }
        });

        id.setFont(new java.awt.Font("Serif", 0, 12)); 
        id.setEnabled(false);

        idLabel.setFont(new java.awt.Font("Serif", 1, 12)); 
        idLabel.setForeground(new java.awt.Color(0, 0, 0));
        idLabel.setText("Id:");

        javax.swing.GroupLayout gl_clientDeatils = new javax.swing.GroupLayout(clientDeatils);
        clientDeatils.setLayout(gl_clientDeatils);
        gl_clientDeatils.setHorizontalGroup(
            gl_clientDeatils.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_clientDeatils.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(gl_clientDeatils.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lastNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_clientDeatils.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(lastName, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(phone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_clientDeatils.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_clientDeatils.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gl_clientDeatils.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(man)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wom)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_clientDeatils.createSequentialGroup()
                        .addGroup(gl_clientDeatils.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(id)
                            .addComponent(maill, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        gl_clientDeatils.setVerticalGroup(
            gl_clientDeatils.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_clientDeatils.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(gl_clientDeatils.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(gl_clientDeatils.createSequentialGroup()
                        .addGroup(gl_clientDeatils.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maill, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(gl_clientDeatils.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gl_clientDeatils.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(gl_clientDeatils.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(wom)
                        .addComponent(man)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_clientDeatils.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gl_clientDeatils.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout gl_panelDetails = new javax.swing.GroupLayout(panelDetails);
        panelDetails.setLayout(gl_panelDetails);
        gl_panelDetails.setHorizontalGroup(
            gl_panelDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_panelDetails.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(clientDeatils, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        gl_panelDetails.setVerticalGroup(
            gl_panelDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_panelDetails.createSequentialGroup()
                .addContainerGap()
                .addComponent(clientDeatils, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
        );

        center.add(panelDetails, java.awt.BorderLayout.CENTER);

        registerJPanel.setPreferredSize(new java.awt.Dimension(737, 50));

        register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/save.png"))); // NOI18N
        register.setText("register");
        register.setBorderPainted(false);
        register.setContentAreaFilled(false);
        register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        register.setFocusPainted(false);
        register.setMaximumSize(new java.awt.Dimension(150, 30));
        register.setMinimumSize(new java.awt.Dimension(150, 30));
        register.setPreferredSize(new java.awt.Dimension(150, 30));
        register.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                grabarFocusGained(evt);
            }
        });
        registerJPanel.add(register);

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/delete.png"))); 
        delete.setBorderPainted(false);
        delete.setContentAreaFilled(false);
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.setFocusPainted(false);
        delete.setMaximumSize(new java.awt.Dimension(150, 30));
        delete.setMinimumSize(new java.awt.Dimension(150, 30));
        delete.setPreferredSize(new java.awt.Dimension(150, 30));
        delete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                deleteFocusGained(evt);
            }
        });
        registerJPanel.add(delete);

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/exit.png"))); 
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setFocusPainted(false);
        exit.setMaximumSize(new java.awt.Dimension(150, 30));
        exit.setMinimumSize(new java.awt.Dimension(150, 30));
        exit.setPreferredSize(new java.awt.Dimension(150, 30));
        exit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                exitFocusGained(evt);
            }
        });
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        registerJPanel.add(exit);

        center.add(registerJPanel, java.awt.BorderLayout.SOUTH);

        panel1.add(center, java.awt.BorderLayout.CENTER);

        footer.setPreferredSize(new java.awt.Dimension(737, 32));
        footer.setLayout(new java.awt.BorderLayout());

        comment.setFont(new java.awt.Font("Serif", 1, 14)); 
        comment.setForeground(new java.awt.Color(0, 0, 0));
        footer.add(comment, java.awt.BorderLayout.CENTER);

        panel1.add(footer, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }

    private void grabarFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Save";
        getComment().setText(text);
    }

    private void deleteFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Delete a client from the list";
        getComment().setText(text);
    }

    private void exitFocusGained(java.awt.event.FocusEvent evt) {
        String text = "exit";
        getComment().setText(text);
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void mailKeyTyped(java.awt.event.KeyEvent evt) {
       //search function of mail key "abc@gmail.com"
    }

    private void mailFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Enter or modify the Mail";
        getComment().setText(text);
    }

    private void phoneKeyTyped(java.awt.event.KeyEvent evt) {
        char b = evt.getKeyChar();

        if(Character.isLetter(b) || Character.isWhitespace(b) || getPhone().getText().length() > 10 || !Character.isDigit(b)){
            evt.consume();
        }
    }

    private void WomFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Woman";
        getComment().setText(text);
    }

    private void ManFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Man";
        getComment().setText(text);
    }

    private void lastNameFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Enter or modify the last name";
        getComment().setText(text);
    }

    private void nameFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Enter or modify the name";
        getComment().setText(text);
    }

  
    private javax.swing.JPanel panelDetails;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JPanel registerJPanel;
    private javax.swing.JPanel clientDeatils;
    private javax.swing.JRadioButton man;
    private javax.swing.JRadioButton wom;
    private javax.swing.JPanel center;
    private javax.swing.JButton delete;
    private javax.swing.JButton exit;
    private javax.swing.JPanel footer;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JButton register;
    private org.edisoncor.gui.panel.Panel header;
    private javax.swing.JTextField id;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel comment;
    private javax.swing.JTextField maill;
    private javax.swing.JTextField name;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTextField phone;
  
}
