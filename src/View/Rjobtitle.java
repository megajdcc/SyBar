package View;

import Controller.ControllerJobTitle;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;    

public class Rjobtitle extends javax.swing.JDialog {

    
    private ControllerJobTitle controllerJobTittle;
    public void setControllerJobTittle(ControllerJobTitle controllerJobTittle){
        this.controllerJobTittle = controllerJobTittle;
        setListener();
    }
    public ControllerJobTitle getControllerJobTittle(){
        return controllerJobTittle;
    }
    private void setListener(){
        register.addActionListener(controllerJobTittle);
        delete.addActionListener(controllerJobTittle);
        exit.addActionListener(controllerJobTittle);
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

    public JTextField getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JTextField jobtitle) {
        this.jobTitle = jobtitle;
    }

    public JLabel getComment() {
        return comment;
    }

    public void setComment(JLabel comment) {
        this.comment = comment;
    }

    public JComboBox<String> getPosition() {
        return position;
    }

    public void setPosition(JComboBox<String> position) {
        this.position = position;
    }



    /**
     * Creates new form Rjobtitle
     * @param parent
     * @param model
     */
    public Rjobtitle(java.awt.Frame parent, boolean model) {
        super(parent, model);
        variablesForm();
        setTitle("Job Title");
        setResizable(false);
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
   
    private void variablesForm() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        header = new org.edisoncor.gui.panel.Panel();
        center = new javax.swing.JPanel();
        detailsJobTitlePanel = new javax.swing.JPanel();
        jobTitleDetails = new javax.swing.JPanel();
        positionLabel = new javax.swing.JLabel();
        position = new javax.swing.JComboBox<>();
        jobTitleLabel = new javax.swing.JLabel();
        jobTitle = new javax.swing.JTextField();
        opnBtnPanel = new javax.swing.JPanel();
        register = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        comment = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        panel1.setMaximumSize(new java.awt.Dimension(737, 504));
        panel1.setLayout(new java.awt.BorderLayout());

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/header/Job position.png"))); // NOI18N
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

        panel1.add(header, java.awt.BorderLayout.NORTH);

        center.setOpaque(false);
        center.setLayout(new java.awt.BorderLayout());

        detailsJobTitlePanel.setPreferredSize(new java.awt.Dimension(683, 70));

        jobTitleDetails.setPreferredSize(new java.awt.Dimension(0, 140));

        positionLabel.setForeground(new java.awt.Color(0, 0, 0));
        positionLabel.setText("position");

        position.setFont(new java.awt.Font("Serif", 1, 12)); 
        position.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                positionFocusGained(evt);
            }
        });

        jobTitleLabel.setFont(new java.awt.Font("Serif", 1, 14));
        jobTitleLabel.setForeground(new java.awt.Color(0, 0, 0));
        jobTitleLabel.setText("Job Title:");

        jobTitle.setFont(new java.awt.Font("Serif", 1, 12)); 
        jobTitle.setForeground(new java.awt.Color(0, 0, 0));
        jobTitle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jobtitleFocusGained(evt);
            }
        });

        javax.swing.GroupLayout gl_jobTittleDetails = new javax.swing.GroupLayout(jobTitleDetails);
        jobTitleDetails.setLayout(gl_jobTittleDetails);
        gl_jobTittleDetails.setHorizontalGroup(
            gl_jobTittleDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_jobTittleDetails.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(positionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jobTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        gl_jobTittleDetails.setVerticalGroup(
            gl_jobTittleDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_jobTittleDetails.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(gl_jobTittleDetails.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(positionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout gl_detailsJobTittlePanel = new javax.swing.GroupLayout(detailsJobTitlePanel);
        detailsJobTitlePanel.setLayout(gl_detailsJobTittlePanel);
        gl_detailsJobTittlePanel.setHorizontalGroup(
            gl_detailsJobTittlePanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_detailsJobTittlePanel.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jobTitleDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        gl_detailsJobTittlePanel.setVerticalGroup(
            gl_detailsJobTittlePanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_detailsJobTittlePanel.createSequentialGroup()
                .addContainerGap()
                .addComponent(jobTitleDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        center.add(detailsJobTitlePanel, java.awt.BorderLayout.CENTER);

        opnBtnPanel.setPreferredSize(new java.awt.Dimension(450, 40));

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
        opnBtnPanel.add(delete);

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
        String text = "Save";
        getComment().setText(text);
    }

    private void deleteFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Delete job tittle from list";
        getComment().setText(text);
    }

    private void exitFocusGained(java.awt.event.FocusEvent evt) {
        String text = "exit";
        getComment().setText(text);
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void positionFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Select from the list the position of this profession";
        getComment().setText(text);
    }

    private void jobtitleFocusGained(java.awt.event.FocusEvent evt) {
        String text = "Enter or modify the jobTittle";
        getComment().setText(text);
    }


    private javax.swing.JPanel detailsJobTitlePanel;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JLabel jobTitleLabel;
    private javax.swing.JPanel opnBtnPanel;
    private javax.swing.JPanel jobTitleDetails;
    private javax.swing.JPanel center;
    private javax.swing.JButton delete;
    private javax.swing.JButton exit;
    private javax.swing.JPanel footer;
    private javax.swing.JButton register;
    private org.edisoncor.gui.panel.Panel header;
    private javax.swing.JTextField jobTitle;
    private javax.swing.JLabel comment;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JComboBox<String> position;
}
