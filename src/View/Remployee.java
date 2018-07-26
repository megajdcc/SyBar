package View;

import Controller.ControllerEmployee;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;


public class Remployee extends javax.swing.JDialog {

    private ControllerEmployee controllerEmployee;
    
    public void setControllerEmployee(ControllerEmployee controller){
        this.controllerEmployee = controller;
        setListener();
    }
    public ControllerEmployee getControllerEmployee(){
        return controllerEmployee;
    }
    private void setListener(){
        register.addActionListener(controllerEmployee);
        delete.addActionListener(controllerEmployee);
        exit.addActionListener(controllerEmployee);
        searchJob.addActionListener(controllerEmployee);
    }
    public JButton getDelete() {
        return delete;
    }

    public void setDelete(JButton delete) {
        this.delete = delete;
    }

    public JTextField getId() {
        return idPerson;
    }

    public void setId(JTextField idPerson) {
        this.idPerson = idPerson;
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

   

    public JTextField getJobtitle() {
        return jobTitle;
    }

    public void setJobtitle(JTextField jobTitle) {
        this.jobTitle = jobTitle;
    }

    public JTextField getLastname() {
        return lastName;
    }

    public void setLastname(JTextField lastName) {
        this.lastName = lastName;
    }

    public JLabel getComment() {
        return comment;
    }

    public void setComment(JLabel comment) {
        this.comment = comment;
    }

    public JTextField getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(JTextField namePerson) {
        this.namePerson = namePerson;
    }

    public JButton getSearchJob() {
        return searchJob;
    }

    public void setSearchJob(JButton searchJob) {
        this.searchJob = searchJob;
    }

   
    public JRadioButton getFemale() {
        return female;
    }

    public void setFemale(JRadioButton female) {
        this.female = female;
    }

    public ButtonGroup getGender() {
        return gender;
    }

    public void setGender(ButtonGroup gender) {
        this.gender = gender;
    }

    public JRadioButton getMale() {
        return male;
    }

    public void setMale(JRadioButton male) {
        this.male = male;
    }

    public JTextField getPhone() {
        return phone;
    }

    public void setPhone(JTextField phone) {
        this.phone = phone;
    }
    

    
    
    /**
     * Creates new form Remployee
     */
    public Remployee(java.awt.Frame parent, boolean model) {
        super(parent, model);
        variablesForm();
        setTitle("Employee");
        setResizable(false);
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")

    private void variablesForm() {

        gender = new javax.swing.ButtonGroup();
        panel1 = new org.edisoncor.gui.panel.Panel();
        header = new org.edisoncor.gui.panel.Panel();
        center = new javax.swing.JPanel();
        detailsPanel = new javax.swing.JPanel();
        detailsEmployee = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        idPerson = new javax.swing.JTextField();
        namePerson = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        jobTitle = new javax.swing.JTextField();
        jobTitleLabel = new javax.swing.JLabel();
        searchJob = new javax.swing.JButton();
        phone = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        opnBtnPanel = new javax.swing.JPanel();
        register = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        comment = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        panel1.setMaximumSize(new java.awt.Dimension(737, 504));
        panel1.setMinimumSize(new java.awt.Dimension(737, 273));
        panel1.setPreferredSize(new java.awt.Dimension(737, 273));
        panel1.setLayout(new java.awt.BorderLayout());

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/header/Employee.png"))); // NOI18N
        header.setMaximumSize(new java.awt.Dimension(737, 75));
        header.setMinimumSize(new java.awt.Dimension(737, 75));
        header.setPreferredSize(new java.awt.Dimension(737, 75));

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

        detailsPanel.setPreferredSize(new java.awt.Dimension(683, 100));

        detailsEmployee.setPreferredSize(new java.awt.Dimension(0, 140));

        idLabel.setFont(new java.awt.Font("Serif", 1, 14)); 
        idLabel.setForeground(new java.awt.Color(0, 0, 0));
        idLabel.setText("Id:");

        phoneLabel.setFont(new java.awt.Font("Serif", 1, 14)); 
        phoneLabel.setForeground(new java.awt.Color(0, 0, 0));
        phoneLabel.setText("Phone:");

        idPerson.setEnabled(false);

        namePerson.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                namepersonKeyTyped(evt);
            }
        });

        lastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lastnameKeyTyped(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Serif", 1, 14)); 
        nameLabel.setForeground(new java.awt.Color(0, 0, 0));
        nameLabel.setText("Name:");

        lastNameLabel.setFont(new java.awt.Font("Serif", 1, 14));
        lastNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        lastNameLabel.setText("Last Name:");

        jobTitle.setEnabled(false);

        jobTitleLabel.setFont(new java.awt.Font("Serif", 1, 14));
        jobTitleLabel.setForeground(new java.awt.Color(0, 0, 0));
        jobTitleLabel.setText("Job Title:");

        searchJob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/Sear.png"))); 
        searchJob.setBorderPainted(false);
        searchJob.setContentAreaFilled(false);
        searchJob.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchJob.setFocusPainted(false);
        searchJob.setMaximumSize(new java.awt.Dimension(30, 30));
        searchJob.setMinimumSize(new java.awt.Dimension(30, 30));
        searchJob.setPreferredSize(new java.awt.Dimension(30, 30));
        searchJob.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sjobFocusGained(evt);
            }
        });

        phone.setPreferredSize(new java.awt.Dimension(14, 25));
        phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phoneKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneKeyTyped(evt);
            }
        });

        genderLabel.setFont(new java.awt.Font("Serif", 1, 14));
        genderLabel.setForeground(new java.awt.Color(0, 0, 0));
        genderLabel.setText("Gender:");

        gender.add(male);
        male.setText("M");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });

        gender.add(female);
        female.setText("F");

        javax.swing.GroupLayout gl_detailsEmployee = new javax.swing.GroupLayout(detailsEmployee);
        detailsEmployee.setLayout(gl_detailsEmployee);
        gl_detailsEmployee.setHorizontalGroup(
            gl_detailsEmployee.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_detailsEmployee.createSequentialGroup()
                .addContainerGap()
                .addGroup(gl_detailsEmployee.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, gl_detailsEmployee.createSequentialGroup()
                        .addComponent(lastNameLabel)
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(gl_detailsEmployee.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(gl_detailsEmployee.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                        .addComponent(namePerson, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(47, 47, 47)
                .addGroup(gl_detailsEmployee.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gl_detailsEmployee.createSequentialGroup()
                        .addGroup(gl_detailsEmployee.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jobTitleLabel)
                            .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gl_detailsEmployee.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(gl_detailsEmployee.createSequentialGroup()
                                .addComponent(jobTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchJob, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(gl_detailsEmployee.createSequentialGroup()
                        .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(male)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(female)))
                .addContainerGap())
        );
        gl_detailsEmployee.setVerticalGroup(
            gl_detailsEmployee.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_detailsEmployee.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(gl_detailsEmployee.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchJob, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_detailsEmployee.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gl_detailsEmployee.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(namePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_detailsEmployee.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(gl_detailsEmployee.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(male)
                        .addComponent(female)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout gl_detailsPanel = new javax.swing.GroupLayout(detailsPanel);
        detailsPanel.setLayout(gl_detailsPanel);
        gl_detailsPanel.setHorizontalGroup(
            gl_detailsPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_detailsPanel.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(detailsEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        gl_detailsPanel.setVerticalGroup(
            gl_detailsPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_detailsPanel.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(detailsEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        center.add(detailsPanel, java.awt.BorderLayout.CENTER);

        opnBtnPanel.setPreferredSize(new java.awt.Dimension(450, 40));

        register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/save.png"))); 
        register.setBorderPainted(false);
        register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        register.setMaximumSize(new java.awt.Dimension(150, 30));
        register.setMinimumSize(new java.awt.Dimension(150, 30));
        register.setOpaque(false);
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

        footer.setPreferredSize(new java.awt.Dimension(450, 32));
        footer.setLayout(new java.awt.BorderLayout());

        comment.setFont(new java.awt.Font("Serif", 1, 14));
        comment.setForeground(new java.awt.Color(0, 0, 0));
        footer.add(comment, java.awt.BorderLayout.CENTER);

        panel1.add(footer, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panel1, "card2");

        pack();
    }

    private void grabarFocusGained(java.awt.event.FocusEvent evt) {
        String saveBtn = "Save";
        getComment().setText(saveBtn);
    }

    private void deleteFocusGained(java.awt.event.FocusEvent evt) {
        String deleteBtn = "Eliminate the employee implicity would be eliminating the person";
        getComment().setText(deleteBtn);
    }

    private void exitFocusGained(java.awt.event.FocusEvent evt) {
        String exitBtn = "Get out";
        getComment().setText(exitBtn);
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {

    }
    private void sjobFocusGained(java.awt.event.FocusEvent evt) {
         String profBtn = "Look for the profession of this employee to associate";
        getComment().setText(profBtn);
    }

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void namepersonKeyTyped(java.awt.event.KeyEvent evt) {
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

    private void phoneKeyReleased(java.awt.event.KeyEvent evt) {
      
    }

    private void phoneKeyTyped(java.awt.event.KeyEvent evt) {
       char b = evt.getKeyChar();
        
         if(Character.isLetter(b) || Character.isWhitespace(b) || getPhone().getText().length() > 10 || !Character.isDigit(b)){
            evt.consume();
         }
    }

    
    private javax.swing.JPanel detailsPanel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel jobTitleLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JPanel opnBtnPanel;
    private javax.swing.JPanel detailsEmployee;
    private javax.swing.JPanel center;
    private javax.swing.JButton delete;
    private javax.swing.JTextField idPerson;
    private javax.swing.JButton exit;
    private javax.swing.JRadioButton female;
    private javax.swing.JPanel footer;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JButton register;
    private org.edisoncor.gui.panel.Panel header;
    private javax.swing.JTextField jobTitle;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel comment;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField namePerson;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTextField phone;
    private javax.swing.JButton searchJob;

}
