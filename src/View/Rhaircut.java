package View;

import Controller.ControllerHaircut;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;


public class Rhaircut extends javax.swing.JDialog {

    private ControllerHaircut controllerHairCut;
    public void setControllerHairCut(ControllerHaircut controllerHairCut){
        this.controllerHairCut = controllerHairCut;
        setListener();
    }
    public ControllerHaircut getControllerHairCut(){
        return controllerHairCut;
    }
    private void setListener(){
        
        registerBtt.addActionListener(controllerHairCut);
        deleteBtt.addActionListener(controllerHairCut);
        exitBtt.addActionListener(controllerHairCut);
        getPrice().addKeyListener(controllerHairCut);
        
        
    }
    public JButton getDelete() {
        return deleteBtt;
    }

    public void setDelete(JButton delete) {
        this.deleteBtt = delete;
    }

    public JButton getExit() {
        return exitBtt;
    }

    public void setExit(JButton exit) {
        this.exitBtt = exit;
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

    public JButton getRegisterBtt() {
        return registerBtt;
    }

    public void setRegisterBtt(JButton registerBtt) {
        this.registerBtt = registerBtt;
    }

    public JLabel getComment() {
        return comment;
    }

    public void setComment(JLabel comment) {
        this.comment = comment;
    }

    public JRadioButton getMale() {
        return male;
    }

    public void setMale(JRadioButton male) {
        this.male = male;
    }

    public JTextField getPrice() {
        return price;
    }

    public void setPrice(JTextField price) {
        this.price = price;
    }

    public JTextField getStyle() {
        return style;
    }

    public void setStyle(JTextField style) {
        this.style = style;
    }


    
    
    /**
     * Creates new form Rhaircut
     * @param parent
     * @param model
     */
    public Rhaircut(java.awt.Frame parent, boolean model) {
        super(parent, model);
        variablesForm();
        setTitle("Haircut");
        setResizable(false);
        setLocationRelativeTo(null);
    }


    private void variablesForm() {

        gender = new javax.swing.ButtonGroup();
        newHairCutPanel = new org.edisoncor.gui.panel.Panel();
        header2 = new org.edisoncor.gui.panel.Panel();
        detailsHaircutPanel = new javax.swing.JPanel();
        detailsPanel = new javax.swing.JPanel();
        detailsPanel2 = new javax.swing.JPanel();
        styleLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        style = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jPanelChoosing = new javax.swing.JPanel();
        registerBtt = new javax.swing.JButton();
        deleteBtt = new javax.swing.JButton();
        exitBtt = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        comment = new javax.swing.JLabel();

        getContentPane().setLayout(new java.awt.CardLayout());

        newHairCutPanel.setMaximumSize(new java.awt.Dimension(737, 504));
        newHairCutPanel.setLayout(new java.awt.BorderLayout());

        header2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/header/Haircut type.png"))); // NOI18N
        header2.setMaximumSize(new java.awt.Dimension(737, 75));
        header2.setMinimumSize(new java.awt.Dimension(737, 75));
        header2.setPreferredSize(new java.awt.Dimension(737, 75));

        javax.swing.GroupLayout header2Layout = new javax.swing.GroupLayout(header2);
        header2.setLayout(header2Layout);
        header2Layout.setHorizontalGroup(
            header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
        );
        header2Layout.setVerticalGroup(
            header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        newHairCutPanel.add(header2, java.awt.BorderLayout.NORTH);

        detailsHaircutPanel.setOpaque(false);
        detailsHaircutPanel.setLayout(new java.awt.BorderLayout());

        detailsPanel.setPreferredSize(new java.awt.Dimension(683, 100));

        detailsPanel2.setPreferredSize(new java.awt.Dimension(619, 85));

        styleLabel.setFont(new java.awt.Font("Serif", 1, 14)); 
        styleLabel.setForeground(new java.awt.Color(0, 0, 0));
        styleLabel.setText("Style:");

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

        style.setFont(new java.awt.Font("Serif", 0, 12)); 
        style.setForeground(new java.awt.Color(0, 0, 0));
        style.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                styleFocusGained(evt);
            }
        });

        genderLabel.setFont(new java.awt.Font("Serif", 1, 14)); 
        genderLabel.setForeground(new java.awt.Color(0, 0, 0));
        genderLabel.setText("Gender:");

        gender.add(male);
        male.setText("M");
        male.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                maleFocusGained(evt);
            }
        });

        gender.add(female);
        female.setText("F");
        female.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                femaleFocusGained(evt);
            }
        });

        javax.swing.GroupLayout gl_detailsPanel2 = new javax.swing.GroupLayout(detailsPanel2);
        detailsPanel2.setLayout(gl_detailsPanel2);
        gl_detailsPanel2.setHorizontalGroup(
            gl_detailsPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_detailsPanel2.createSequentialGroup()
                .addContainerGap()
                .addGroup(gl_detailsPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(genderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(styleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_detailsPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gl_detailsPanel2.createSequentialGroup()
                        .addComponent(style, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gl_detailsPanel2.createSequentialGroup()
                        .addComponent(male)
                        .addGap(18, 18, 18)
                        .addComponent(female))))
        );
        gl_detailsPanel2.setVerticalGroup(
            gl_detailsPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_detailsPanel2.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(gl_detailsPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(style, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(styleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_detailsPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(male)
                    .addComponent(female))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout gl_detailsPanel = new javax.swing.GroupLayout(detailsPanel);
        detailsPanel.setLayout(gl_detailsPanel);
        gl_detailsPanel.setHorizontalGroup(
            gl_detailsPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_detailsPanel.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(detailsPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        gl_detailsPanel.setVerticalGroup(
            gl_detailsPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_detailsPanel.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailsPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        detailsHaircutPanel.add(detailsPanel, java.awt.BorderLayout.CENTER);

        jPanelChoosing.setPreferredSize(new java.awt.Dimension(450, 40));

        registerBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/save.png"))); // NOI18N
        registerBtt.setBorderPainted(false);
        registerBtt.setContentAreaFilled(false);
        registerBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        detailsHaircutPanel.add(jPanelChoosing, java.awt.BorderLayout.SOUTH);

        newHairCutPanel.add(detailsHaircutPanel, java.awt.BorderLayout.CENTER);

        footer.setPreferredSize(new java.awt.Dimension(450, 32));
        footer.setLayout(new java.awt.BorderLayout());

        comment.setFont(new java.awt.Font("Serif", 1, 14)); 
        comment.setForeground(new java.awt.Color(0, 0, 0));
        footer.add(comment, java.awt.BorderLayout.CENTER);

        newHairCutPanel.add(footer, java.awt.BorderLayout.SOUTH);

        getContentPane().add(newHairCutPanel, "card2");

        pack();
    }

    private void registerBttFocusGained(java.awt.event.FocusEvent evt) {
        String saveBtn = "Save";
        getComment().setText(saveBtn);
    }

    private void deleteFocusGained(java.awt.event.FocusEvent evt) {
        String deleteBtn = "Eliminate the type of cut";
        getComment().setText(deleteBtn);
    }

    private void exitFocusGained(java.awt.event.FocusEvent evt) {
        String exitBtn = "exit of view";
        getComment().setText(exitBtn);
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void styleFocusGained(java.awt.event.FocusEvent evt) {
        String haircutBtn = "Enter the name of the type of haircut";
        getComment().setText(haircutBtn);
    }

    private void priceFocusGained(java.awt.event.FocusEvent evt) {
         String priceBtn = "Enter the corresponding price";
        getComment().setText(priceBtn);
    }

    private void maleFocusGained(java.awt.event.FocusEvent evt) {
        String mBtn = "Male";
        getComment().setText(mBtn);
    }

    private void femaleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_femaleFocusGained
          String fBtn = "Woman";
        getComment().setText(fBtn);
    }

    private javax.swing.JPanel detailsPanel;
    private javax.swing.JLabel styleLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JPanel jPanelChoosing;
    private javax.swing.JPanel detailsPanel2;
    private javax.swing.JPanel detailsHaircutPanel;
    private javax.swing.JButton deleteBtt;
    private javax.swing.JButton exitBtt;
    private javax.swing.JRadioButton female;
    private javax.swing.JPanel footer;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JButton registerBtt;
    private org.edisoncor.gui.panel.Panel header2;
    private javax.swing.JLabel comment;
    private javax.swing.JRadioButton male;
    private org.edisoncor.gui.panel.Panel newHairCutPanel;
    private javax.swing.JTextField price;
    private javax.swing.JTextField style;
    
}
