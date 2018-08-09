package View;

import Controller.ControllerHaircut;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.*;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Rhaircut extends javax.swing.JDialog {

    private ControllerHaircut controllerHairCut;
    private long duratio; 
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
    
    /********************************/
    /*        GETTERS Y SETTERS 
    /********************************/
    
    public long getDuratio() {
        return duratio;
    }

    public void setDuratio(long duratio) {
        this.duratio = duratio;
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

    public JLabel getMues() {
        return mues;
    }

    public void setMues(JLabel mues) {
        this.mues = mues;
    }
    
    

/**********************************/
/*          CONSTRUCTOR
/**********************************/
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

        //propiedades of component
        gender = new ButtonGroup();
        newHairCutPanel = new org.edisoncor.gui.panel.Panel();
        header = new org.edisoncor.gui.panel.Panel();
        detailsHaircutPanel = new JPanel();
        detailsPanel = new JPanel();
        detailsPanel2 = new JPanel();
        styleLabel = new JLabel();
        priceLabel = new JLabel();
        duration = new JLabel("Duration:");
        price = new JTextField();
        style = new JTextField();
        genderLabel = new JLabel();
        male = new JRadioButton();
        female = new JRadioButton();
        jPanelChoosing = new JPanel();
        registerBtt = new JButton();
        deleteBtt = new JButton();
        exitBtt = new JButton();
        footer = new JPanel();
        comment = new JLabel();
        
        //configuration of panel
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        
        //container
        newHairCutPanel.setMaximumSize(new Dimension(737, 504));
        newHairCutPanel.setLayout(new BorderLayout());

        //HEADER 
        header.setIcon(new ImageIcon(getClass().getResource("/View/img/header/Haircut type.png"))); // NOI18N
        header.setMaximumSize(new Dimension(737, 75));
        header.setMinimumSize(new Dimension(737, 75));
        header.setPreferredSize(new Dimension(737, 75));
        newHairCutPanel.add(header,BorderLayout.NORTH);

        detailsHaircutPanel.setOpaque(false);
        detailsHaircutPanel.setLayout(new BorderLayout());

        detailsPanel.setPreferredSize(new Dimension(683, 100));
        detailsPanel2.setPreferredSize(new Dimension(600, 85));

        JPanel conten1 , conten2;
        conten1 = new JPanel();
        conten1.setPreferredSize(new Dimension(280,100));
        
        conten1.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        conten2 = new JPanel();
        conten2.setPreferredSize(new Dimension(280,100));
        conten2.setLayout(new FlowLayout(FlowLayout.LEFT));
        detailsPanel2.add(conten1);
        detailsPanel2.add(conten2);
        
        detailsPanel.add(detailsPanel2);
        
        styleLabel.setFont(new Font("Serif", 1, 14)); 
        styleLabel.setForeground(new Color(0, 0, 0));
        styleLabel.setText("Style:");
        styleLabel.setPreferredSize(new Dimension(80,20));
        conten1.add(styleLabel);
        
        style.setFont(new Font("Serif", 0, 12)); 
        style.setForeground(new Color(0, 0, 0));
        style.setMaximumSize(style.getPreferredSize());
        style.setPreferredSize(new Dimension(180,20));
        style.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                styleFocusGained(evt);
            }
        });
        conten1.add(style);
        
        priceLabel.setFont(new Font("Serif", 1, 14)); 
        priceLabel.setForeground(new Color(0, 0, 0));
        priceLabel.setText("Price:");
        priceLabel.setPreferredSize(new Dimension(80,20));
        conten2.add(priceLabel);
        
        price.setFont(new java.awt.Font("Serif", 1, 12)); 
        price.setForeground(new java.awt.Color(0, 0, 0));
        price.setPreferredSize(new Dimension(180,20));
        price.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                priceFocusGained(evt);
            }
        });
        conten2.add(price);
        

        genderLabel.setFont(new java.awt.Font("Serif", 1, 14)); 
        genderLabel.setForeground(new java.awt.Color(0, 0, 0));
        genderLabel.setPreferredSize(new Dimension(80,20));
        genderLabel.setText("Gender:");
        conten1.add(genderLabel);
        
        gender.add(male);
        male.setText("M");
        male.setPreferredSize(new Dimension(70,20));
        male.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                maleFocusGained(evt);
            }
        });
        conten1.add(male);
        
        gender.add(female);
        female.setText("F");
        female.setPreferredSize(new Dimension(70,20));
        female.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                femaleFocusGained(evt);
            }
        });
        conten1.add(female);
        
        duration.setFont(new java.awt.Font("Serif", 1, 14)); 
        duration.setForeground(new java.awt.Color(0, 0, 0));
        duration.setPreferredSize(new Dimension(80,20));
        conten2.add(duration);
        
        jdura = new JSlider(900000,7200000,900000);
      //  jdura.setMinimum(9000000);
        
        jdura.setMajorTickSpacing(1800000);
        jdura.setMinorTickSpacing(900000);
        jdura.setPaintTicks(true);
        jdura.setPaintTrack(true);
        jdura.setSnapToTicks(true);
        jdura.setPreferredSize(new Dimension(100,50));
        conten2.add(jdura);
//        
        Calendar min = Calendar.getInstance();
       
        mues = new JLabel();
        mues.setForeground(Color.black);
        mues.setFont(new Font("Serif", Font.ITALIC, 14));
        mues.setPreferredSize(new Dimension(80,50));
        mues.setText("15 minute");
        duratio = jdura.getValue();
        conten2.add(mues);
        jdura.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent ce) {
                duratio = jdura.getValue();
                 int hr = min.get(Calendar.HOUR_OF_DAY);
                int mi = min.get(Calendar.MINUTE);
                int s = min.get(Calendar.SECOND);

                min.add(Calendar.HOUR_OF_DAY, -hr);
                min.add(Calendar.MINUTE, -mi);
                min.add(Calendar.SECOND, -s);
                
                min.add(Calendar.MILLISECOND, (int) +duratio);

                 java.sql.Time time1 = java.sql.Time.valueOf(min.get(Calendar.HOUR_OF_DAY)+":"+min.get(Calendar.MINUTE)+":"+min.get(Calendar.SECOND));
                mues.setText(time1.toString() + " Hrs");

            }
            
        });
        
        
        
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

        getContentPane().add(newHairCutPanel);

        pack();
    }

    
/**********************************/
/*          METHOD OF OBJECT
/**********************************/
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

    private void femaleFocusGained(java.awt.event.FocusEvent evt) {                                   
          String fBtn = "Woman";
        getComment().setText(fBtn);
    }

    private JLabel styleLabel,comment,priceLabel,genderLabel,duration, mues;
    private JSlider jdura;
    private JPanel detailsPanel,jPanelChoosing,detailsPanel2,detailsHaircutPanel,footer;
    private JButton deleteBtt,exitBtt,registerBtt;
    private javax.swing.ButtonGroup gender;
    private org.edisoncor.gui.panel.Panel header;
    private JRadioButton male,female;
    private org.edisoncor.gui.panel.Panel newHairCutPanel;
    private JTextField price, style;


}
