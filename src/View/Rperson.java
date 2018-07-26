package View;

import Controller.ControllerPerson;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Rperson extends javax.swing.JDialog {

    private ControllerPerson controllerPerson;
    
    public void setControllerPerson(ControllerPerson controllerPerson){
        this.controllerPerson = controllerPerson;
        setListener();
    }
    
    public ControllerPerson getControllerPerson(){
        return controllerPerson;
    }
    private void setListener(){
        exit.addActionListener(controllerPerson);
        register.addActionListener(controllerPerson);
        delete.addActionListener(controllerPerson);
    }
       //Getters y Setters
    public JRadioButton getMan() {
        return Man;
    }
    
    public void setMan(JRadioButton Man) {
        this.Man = Man;
    }

    public JRadioButton getWom() {
        return Wom;
    }

    public void setWom(JRadioButton Wom) {
        this.Wom = Wom;
    }

    public JButton getDelete() {
        return delete;
    }

    public void setDelete(JButton delete) {
        this.delete = delete;
    }

    

    public JTextField getId() {
        return id;
    }

    public void setId(JTextField id) {
        this.id = id;
    }

    public JButton getExit() {
        return exit;
    }

    public void setExit(JButton exit) {
        this.exit = exit;
    }

    public ButtonGroup getGender() {
        return gender;
    }

    public void setGender(ButtonGroup gender) {
        this.gender = gender;
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

    public JTextField getNameP() {
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



    public JComboBox<String> getTypeperson() {
        return typePerson;
    }

    public void setTypeperson(JComboBox<String> typePerson) {
        this.typePerson = typePerson;
    }
        
    /**
     * Creates new form Rperson
     * @param parent
     * @param model
     */
    public Rperson(java.awt.Frame parent, boolean model) {
        super(parent, model);
        variablesForm();
        setTitle("person");
        setResizable(false);
        setLocationRelativeTo(null);

    }


    private void variablesForm() {

        gender = new javax.swing.ButtonGroup();
        panel1 = new org.edisoncor.gui.panel.Panel();
        header = new org.edisoncor.gui.panel.Panel();
        center = new javax.swing.JPanel();
        detailsPersonPanel = new javax.swing.JPanel();
        personDetails = new javax.swing.JPanel();
        personTypeLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastName = new javax.swing.JTextField();
        Man = new javax.swing.JRadioButton();
        Wom = new javax.swing.JRadioButton();
        id = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        noLabel = new javax.swing.JLabel();
        typePerson = new javax.swing.JComboBox<>();
        opnBtnPanel = new javax.swing.JPanel();
        register = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        comment = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(737, 310));
        getContentPane().setLayout(new java.awt.CardLayout());

        panel1.setMaximumSize(new java.awt.Dimension(737, 504));
        panel1.setPreferredSize(new java.awt.Dimension(737, 310));
        panel1.setLayout(new java.awt.BorderLayout());

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/header/Person.png"))); // NOI18N
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

        detailsPersonPanel.setPreferredSize(new java.awt.Dimension(683, 150));

        personDetails.setPreferredSize(new java.awt.Dimension(0, 140));

        personTypeLabel.setFont(new java.awt.Font("Serif", 1, 12)); 
        personTypeLabel.setForeground(new java.awt.Color(0, 0, 0));
        personTypeLabel.setText("Person type:");

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
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });

        lastNameLabel.setFont(new java.awt.Font("Serif", 1, 12)); 
        lastNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        lastNameLabel.setText("Last Name:");

        lastName.setForeground(new java.awt.Color(0, 0, 0));
        lastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastnameFocusGained(evt);
            }
        });
        lastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lastnameKeyTyped(evt);
            }
        });

        gender.add(Man);
        Man.setText("M");
        Man.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ManFocusGained(evt);
            }
        });

        gender.add(Wom);
        Wom.setText("F");
        Wom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                WomFocusGained(evt);
            }
        });

        id.setEnabled(false);
        id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idFocusGained(evt);
            }
        });
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });

        phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneKeyTyped(evt);
            }
        });

        noLabel.setFont(new java.awt.Font("Serif", 1, 12)); 
        noLabel.setForeground(new java.awt.Color(0, 0, 0));
        noLabel.setText("No:");

        typePerson.setFont(new java.awt.Font("Serif", 1, 12)); 
        typePerson.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Employee", "Client" }));
        typePerson.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                typepersonFocusGained(evt);
            }
        });

        javax.swing.GroupLayout gl_personDetails = new javax.swing.GroupLayout(personDetails);
        personDetails.setLayout(gl_personDetails);
        gl_personDetails.setHorizontalGroup(
            gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_personDetails.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(personTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lastNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(typePerson, 0, 178, Short.MAX_VALUE)
                    .addComponent(name)
                    .addComponent(lastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gl_personDetails.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(phone, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(id))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(gl_personDetails.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Man)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Wom)
                        .addGap(0, 135, Short.MAX_VALUE))))
        );
        gl_personDetails.setVerticalGroup(
            gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_personDetails.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(gl_personDetails.createSequentialGroup()
                        .addGroup(gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(personTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(typePerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gl_personDetails.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(gl_personDetails.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Wom)
                                    .addComponent(Man)))))
                    .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gl_personDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(noLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout gl_detailsPersonPanel = new javax.swing.GroupLayout(detailsPersonPanel);
        detailsPersonPanel.setLayout(gl_detailsPersonPanel);
        gl_detailsPersonPanel.setHorizontalGroup(
            gl_detailsPersonPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_detailsPersonPanel.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(personDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        gl_detailsPersonPanel.setVerticalGroup(
            gl_detailsPersonPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_detailsPersonPanel.createSequentialGroup()
                .addContainerGap()
                .addComponent(personDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        center.add(detailsPersonPanel, java.awt.BorderLayout.CENTER);

        opnBtnPanel.setPreferredSize(new java.awt.Dimension(737, 50));

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
        opnBtnPanel.add(register);

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/delete.png"))); 
        delete.setBorderPainted(false);
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.setFocusPainted(false);
        delete.setMaximumSize(new java.awt.Dimension(150, 30));
        delete.setMinimumSize(new java.awt.Dimension(150, 30));
        delete.setOpaque(false);
        delete.setPreferredSize(new java.awt.Dimension(150, 30));
        delete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                deleteFocusGained(evt);
            }
        });
        opnBtnPanel.add(delete);

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/exit.png"))); 
        exit.setBorderPainted(false);
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setFocusPainted(false);
        exit.setMaximumSize(new java.awt.Dimension(150, 30));
        exit.setMinimumSize(new java.awt.Dimension(150, 30));
        exit.setOpaque(false);
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
        opnBtnPanel.add(exit);

        center.add(opnBtnPanel, java.awt.BorderLayout.SOUTH);

        panel1.add(center, java.awt.BorderLayout.CENTER);

        footer.setPreferredSize(new java.awt.Dimension(737, 32));
        footer.setLayout(new java.awt.BorderLayout());

        comment.setFont(new java.awt.Font("Serif", 1, 14));
        comment.setForeground(new java.awt.Color(0, 0, 0));
        footer.add(comment, java.awt.BorderLayout.CENTER);

        panel1.add(footer, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panel1, "card2");

        pack();
    }

    private void grabarFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Save";
        getComment().setText(text);
    }

    private void deleteFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Delete a person from the list";
        getComment().setText(text);
    }

    private void exitFocusGained(java.awt.event.FocusEvent evt) {
        String text = "exit";
        getComment().setText(text);
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void nameFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Enter or modify the name";
        getComment().setText(text);
    }

    private void lastnameFocusGained(java.awt.event.FocusEvent evt) {
       String text = "Enter or modify the last name";
        getComment().setText(text);
    }

    private void ManFocusGained(java.awt.event.FocusEvent evt) {
         String text = "Male";
        getComment().setText(text);
    }

    private void WomFocusGained(java.awt.event.FocusEvent evt) {
         String text = "Female";
        getComment().setText(text);
    }

    private void idKeyTyped(java.awt.event.KeyEvent evt) {
    }

    private void phoneKeyTyped(java.awt.event.KeyEvent evt) {
      char b = evt.getKeyChar();
        
         if(Character.isLetter(b) || Character.isWhitespace(b) || getPhone().getText().length() > 10 || !Character.isDigit(b)){
            evt.consume();
         }
    }

    private void idFocusGained(java.awt.event.FocusEvent evt) {
        String text = "";
        getComment().setText(text);
    }

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {
        char b = evt.getKeyChar();
        
         if(Character.isDigit(b)){
            evt.consume();
         }
    }

    private void lastnameKeyTyped(java.awt.event.KeyEvent evt) {
        char b = evt.getKeyChar();
        
         if(Character.isDigit(b)){
            evt.consume();
         }
    }

    private void typepersonFocusGained(java.awt.event.FocusEvent evt) {
        String notification = "Select a type of person ";
        getComment().setText(notification);
    }

    
    private javax.swing.JPanel detailsPersonPanel;
    private javax.swing.JLabel personTypeLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel noLabel;
    private javax.swing.JPanel opnBtnPanel;
    private javax.swing.JPanel personDetails;
    private javax.swing.JRadioButton Man;
    private javax.swing.JRadioButton Wom;
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
    private javax.swing.JTextField name;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTextField phone;
    private javax.swing.JComboBox<String> typePerson;
}
