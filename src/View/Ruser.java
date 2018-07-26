package View;

import Controller.ControllerUsers;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Dimension;


public class Ruser extends javax.swing.JDialog {

    
    
    private ControllerUsers controllerUser;
    
    public void setControllerUser(ControllerUsers controller){
        this.controllerUser = controller;
        this.asignarOyentes();
    }
    public ControllerUsers getControllerUser(){
        return controllerUser;
    }
    private void asignarOyentes(){
        getExituser().addActionListener(controllerUser);
        getDelete().addActionListener(controllerUser);
        getRegister().addActionListener(controllerUser);
        getSearchEmployee().addActionListener(controllerUser);
        getPassword().addKeyListener(controllerUser);
    }
    //Getters y Setters
    public JButton getDelete() {
        return delete;
    }

    public void setDelete(JButton delete) {
        this.delete = delete;
    }

   

    public JTextField getEmpName() {
        return name;
    }

    public void setEmpName(JTextField name) {
        this.name = name;
    }

    public JButton getExituser() {
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

    public JLabel getComment() {
        return comment;
    }

    public void setComment(JLabel comment) {
        this.comment = comment;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public void setPassword(JPasswordField password) {
        this.password = password;
    }



    public JTextField getTextuser() {
        return user;
    }

    public void setTextuser(JTextField textUser) {
        this.user = textUser;
    }

    public JButton getSearchEmployee() {
        return searchEmployee;
    }

    public void setSearchEmployee(JButton searchEmployee) {
        this.searchEmployee = searchEmployee;
    }

    public JTextField getId() {
        return id;
    }

    public void setId(JTextField id) {
        this.id = id;
    }

    public JTextField getLastName() {
        return lastName;
    }

    public void setLastName(JTextField lastName) {
        this.lastName = lastName
        		;
    }

    public JTextField getNamee() {
        return name;
    }

    public void setName(JTextField name) {
        this.name = name;
    }

    public JPasswordField getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(JPasswordField newpassword) {
        this.newPassword = newpassword;
    }

    public JLabel getLabelnewpass() {
        return newPassLabel;
    }

    public void setLabelNewPass(JLabel newPassLabel) {
        this.newPassLabel = newPassLabel;
    }
    
    /**
     * Creates new form Ruser
     * @param parent
     * @param model
     */
    public Ruser(java.awt.Frame parent, boolean model) {
        super(parent, model);
        variablesForm();

        setTitle("Users");
        setLocationRelativeTo(null);
    }

 
    private void variablesForm() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        header = new org.edisoncor.gui.panel.Panel();
        center = new javax.swing.JPanel();
        detailsUserPanel = new javax.swing.JPanel();
        detailsUser = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        searchEmployee = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        user = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        lastNameLabel = new javax.swing.JLabel();
        lastName = new javax.swing.JTextField();
        newPassLabel = new javax.swing.JLabel();
        newPassword = new javax.swing.JPasswordField();
        opnBtnUser = new javax.swing.JPanel();
        register = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        comment = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("User");
        setPreferredSize(new Dimension(737, 320));
        setResizable(false);

        panel1.setMaximumSize(new java.awt.Dimension(737, 504));
        panel1.setPreferredSize(new java.awt.Dimension(737, 300));
        panel1.setLayout(new java.awt.BorderLayout());

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/header/User.png"))); 
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

        detailsUserPanel.setPreferredSize(new java.awt.Dimension(683, 100));

        detailsUser.setPreferredSize(new java.awt.Dimension(0, 140));

        idLabel.setForeground(new java.awt.Color(0, 0, 0));
        idLabel.setText("Id:");

        nameLabel.setForeground(new java.awt.Color(0, 0, 0));
        nameLabel.setText("Name:");

        userLabel.setForeground(new java.awt.Color(0, 0, 0));
        userLabel.setText("User Name:");

        passLabel.setForeground(new java.awt.Color(0, 0, 0));
        passLabel.setText("Passworod:");

        id.setEnabled(false);

        searchEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/Sear.png"))); 
        searchEmployee.setBorderPainted(false);
        searchEmployee.setContentAreaFilled(false);
        searchEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchEmployee.setPreferredSize(new java.awt.Dimension(30, 30));
        searchEmployee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BuscpersonFocusGained(evt);
            }
        });

        name.setEnabled(false);

        user.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textuserFocusGained(evt);
            }
        });

        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
        });

        lastNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        lastNameLabel.setText("Last Name:");

        lastName.setEnabled(false);

        newPassLabel.setForeground(new java.awt.Color(0, 0, 0));
        newPassLabel.setText("New Password:");

        newPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newpasswordFocusGained(evt);
            }
        });

        javax.swing.GroupLayout gl_detailsUser = new javax.swing.GroupLayout(detailsUser);
        detailsUser.setLayout(gl_detailsUser);
        gl_detailsUser.setHorizontalGroup(
            gl_detailsUser.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_detailsUser.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(gl_detailsUser.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameLabel)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(gl_detailsUser.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastName)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gl_detailsUser.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newPassLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_detailsUser.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(user)
                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(newPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                .addContainerGap())
        );
        gl_detailsUser.setVerticalGroup(
            gl_detailsUser.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_detailsUser.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(gl_detailsUser.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(gl_detailsUser.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_detailsUser.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(gl_detailsUser.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_detailsUser.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout gl_detailsUserPanel = new javax.swing.GroupLayout(detailsUserPanel);
        detailsUserPanel.setLayout(gl_detailsUserPanel);
        gl_detailsUserPanel.setHorizontalGroup(
            gl_detailsUserPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_detailsUserPanel.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(detailsUser, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        gl_detailsUserPanel.setVerticalGroup(
            gl_detailsUserPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_detailsUserPanel.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailsUser, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        center.add(detailsUserPanel, java.awt.BorderLayout.CENTER);

        opnBtnUser.setPreferredSize(new java.awt.Dimension(737, 50));

        register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/save.png"))); 
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
        opnBtnUser.add(register);

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
        opnBtnUser.add(delete);

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
                exituserFocusGained(evt);
            }
        });
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exituserActionPerformed(evt);
            }
        });
        opnBtnUser.add(exit);

        center.add(opnBtnUser, java.awt.BorderLayout.SOUTH);

        panel1.add(center, java.awt.BorderLayout.CENTER);

        footer.setPreferredSize(new java.awt.Dimension(737, 32));
        footer.setLayout(new java.awt.BorderLayout());

        comment.setFont(new java.awt.Font("Serif", 1, 14)); 
        comment.setForeground(new java.awt.Color(0, 0, 0));
        footer.add(comment, java.awt.BorderLayout.CENTER);

        panel1.add(footer, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panel1, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void grabarFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Save";
        getComment().setText(text);
    }

    private void deleteFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Delete the user";
        getComment().setText(text);
    }

    private void exituserActionPerformed(java.awt.event.ActionEvent evt) {
    	
    }
   

    private void BuscpersonFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Find the employee you want to register as a user";
        getComment().setText(text);
    }

    private void textuserFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Enter or modify the user name";
        getComment().setText(text);
    }

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {
       String text = "";
        getComment().setText(text);
    }

    private void exituserFocusGained(java.awt.event.FocusEvent evt) {
        String text = "exit";
        getComment().setText(text);
    }

    private void newpasswordFocusGained(java.awt.event.FocusEvent evt) {
        
    }


    private javax.swing.JButton searchEmployee;
    private javax.swing.JPanel detailsUserPanel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JPanel opnBtnUser;
    private javax.swing.JPanel detailsUser;
    private javax.swing.JPanel center;
    private javax.swing.JButton delete;
    private javax.swing.JButton exit;
    private javax.swing.JPanel footer;
    private javax.swing.JButton register;
    private org.edisoncor.gui.panel.Panel header;
    private javax.swing.JTextField id;
    private javax.swing.JLabel newPassLabel;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel comment;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField newPassword;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField user;
    
}
