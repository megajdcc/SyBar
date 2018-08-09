package View;

import Controller.ControllerEmployee;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import lu.tudor.santec.jtimechooser.JTimeChooser;
import View.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import javax.swing.event.ChangeEvent;
import lu.tudor.santec.jtimechooser.TimeChangedEvent;
import lu.tudor.santec.jtimechooser.TimeChangedListener;
public class Remployee extends JDialog {
    
    /*******************************************/
    /*         VARIABLES OF CLASS
    ********************************************/
    private JPanel detailsPanel,center,detailsEmployee,opnBtnPanel,footer;
    private JLabel idLabel,phoneLabel,nameLabel,lastNameLabel,jobTitleLabel,genderLabel,comment,workdayslabel,entrylabel,departurelabel;
    private JButton delete,register,exit,searchJob,workdays,workhours;
    private JTextField idPerson,jobTitle,lastName,namePerson,phone;
    private JRadioButton female,male;
    private ButtonGroup gender;
    private org.edisoncor.gui.panel.Panel header,container1;
    private GridBagConstraints ct;
    private JTimeChooser entry;
    private JTimeChooser departure;
    private SelectTime selectedtime;
    private Principal principal;
    private ControllerEmployee controllerEmployee;
    private JButton setdays,cancel;
    private JToggleButton Monday,Tuesday,Wednesday,Thursday, Friday, Saturday,Sunday;
    private ArrayList dt;
    private ArrayList dayselect;
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
    
    /*******************************************/
    /*         GETTERS Y SETTERS 
    ********************************************/
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

    public JButton getWorkdays() {
        return workdays;
    }

    public void setWorkdays(JButton workdays) {
        this.workdays = workdays;
    }

    public JTimeChooser getEntry() {
        return entry;
    }

    public void setEntry(JTimeChooser entry) {
        this.entry = entry;
    }

    public JTimeChooser getDeparture() {
        return departure;
    }

    public void setDeparture(JTimeChooser departure) {
        this.departure = departure;
    }

    public ArrayList getDt() {
        return dt;
    }

    public void setDt(ArrayList dt) {
        this.dt = dt;
         getEntry().setVisible(true);
         getDeparture().setVisible(true);
    }

    public JButton getWorkhours() {
        return workhours;
    }
    
    
    
    /*******************************************/
    /*         CONSTRUCTOR OF CLASS
    ********************************************/
    /**
     * Creates new form Remployee
     * @param parent 
     * @param model
     */
    public Remployee(java.awt.Frame parent, boolean model) {
        super(parent, model);
        variablesForm();
        setTitle("Employee");
        setResizable(false);
        setLocationRelativeTo(null);
         getEntry().setVisible(true);
         getDeparture().setVisible(true);
         dt = new ArrayList();
        if(!dt.isEmpty()){
         workdays.setBackground(Color.red);
         getEntry().setVisible(true);
         getDeparture().setVisible(true);
        }else{
         workdays.setBackground(Color.GRAY);
         getEntry().setVisible(false);
         getDeparture().setVisible(false);
        }
        selectedtime = new SelectTime();
    }

    
    /**
     * METODOS PARA MOSTRAR DIALOGO PARA ENLISTAR LOS DIAS DE TRABAJO DEL EMPLEADO.... 
     */
    private void showdays(){
        
        JDialog DaysContent = new JDialog(principal, true);
        DaysContent.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        DaysContent.setTitle("Work Days");
        DaysContent.setResizable(false);
        DaysContent.setLocationRelativeTo(null);
        DaysContent.setPreferredSize(new Dimension(300,250));
        DaysContent.setMinimumSize(DaysContent.getPreferredSize());
        DaysContent.setMaximumSize(DaysContent.getPreferredSize());
        DaysContent.setLayout(new BorderLayout());
        
        JPanel contendays = new JPanel();
        ArrayList days = new ArrayList();
        
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");
        
        
        contendays.setLayout(new GridLayout(3,3));
        Iterator<String> day = days.iterator();

         
        Monday = new JToggleButton("Monday");
        Tuesday = new JToggleButton("Tuesday");
        Wednesday = new JToggleButton("Wednesday");
        Thursday = new JToggleButton("Thursday");
        Friday = new JToggleButton("Friday");
        Saturday = new JToggleButton("Saturday");
        Sunday = new JToggleButton("Sunday");
  
            if(dt.contains(Monday.getActionCommand())){
             Monday.setSelected(true);
            }
            if(dt.contains(Tuesday.getActionCommand())){
             Tuesday.setSelected(true);
            }
            if(dt.contains(Wednesday.getActionCommand())){
             Wednesday.setSelected(true);
            }
            if(dt.contains(Thursday.getActionCommand())){
             Thursday.setSelected(true);
            }
            if(dt.contains(Friday.getActionCommand())){
             Friday.setSelected(true);
            }
            if(dt.contains(Saturday.getActionCommand())){
             Saturday.setSelected(true);
            }
            if(dt.contains(Sunday.getActionCommand())){
             Sunday.setSelected(true);
            }  

        Monday.addActionListener((ActionEvent ae) -> {
            if(Monday.isSelected()){
                dt.add(ae.getActionCommand());
            }else{
                if(dt.contains(ae.getActionCommand())){
                    dt.remove(ae.getActionCommand());
                }
            }
        });
        Tuesday.addActionListener((ActionEvent ae) -> {
            if(Tuesday.isSelected()){
                dt.add(ae.getActionCommand());
            }else{
                if(dt.contains(ae.getActionCommand())){
                    dt.remove(ae.getActionCommand());
                }
            }
        });
        Wednesday.addActionListener((ActionEvent ae) -> {
            if(Wednesday.isSelected()){
                dt.add(ae.getActionCommand());
            }else{
                if(dt.contains(ae.getActionCommand())){
                    dt.remove(ae.getActionCommand());
                }
            }
        });
        Thursday.addActionListener((ActionEvent ae) -> {
            if(Thursday.isSelected()){
                dt.add(ae.getActionCommand());
            }else{
                if(dt.contains(ae.getActionCommand())){
                    dt.remove(ae.getActionCommand());
                }
            }
        });
        Friday.addActionListener((ActionEvent ae) -> {
            if(Friday.isSelected()){
                dt.add(ae.getActionCommand());
            }else{
                if(dt.contains(ae.getActionCommand())){
                    dt.remove(ae.getActionCommand());
                }
            }
        });
        Saturday.addActionListener((ActionEvent ae) -> {
            if(Saturday.isSelected()){
                dt.add(ae.getActionCommand());
            }else{
                if(dt.contains(ae.getActionCommand())){
                    dt.remove(ae.getActionCommand());
                }
            }
        });
        Sunday.addActionListener((ActionEvent ae) -> {
            if(Sunday.isSelected()){
                dt.add(ae.getActionCommand());
            }else{
                if(dt.contains(ae.getActionCommand())){
                    dt.remove(ae.getActionCommand());
                }
            }
        });
        
        contendays.add(Monday);
        contendays.add(Tuesday);
        contendays.add(Wednesday);
        contendays.add(Thursday);
        contendays.add(Friday);
        contendays.add(Saturday);
        contendays.add(Sunday);
         

        DaysContent.add(contendays,BorderLayout.CENTER);
        
        JPanel footerday = new JPanel();
        
        setdays = new JButton("Set");
        setdays.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent aee){
                if(!dt.isEmpty()){
                    entry.setVisible(true);
                    departure.setVisible(true);
                    workdays.setBackground(Color.red);
                }else{
                    entry.setVisible(false);
                    departure.setVisible(false);
                    workdays.setBackground(Color.gray);
                }
               DaysContent.dispose();
               DaysContent.setVisible(false);

            }
        });
        cancel = new JButton("Clear");
        cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               DaysContent.dispose();
               workdays.setBackground(new Color(Color.GRAY.getRGB()));
               entry.setVisible(false);
                    departure.setVisible(false);
               DaysContent.setVisible(false);
               dt.clear();
            }
            
        });
        
        JButton close = new JButton("Close");
        
        close.addActionListener((ActionEvent ae) -> {
            DaysContent.dispose();
            DaysContent.setVisible(false);
        });
        footerday.add(setdays);
        footerday.add(cancel);
        footerday.add(close);
        DaysContent.add(footerday,BorderLayout.SOUTH);
        
        DaysContent.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")

    private void showhours(){
        selectedtime.setVisible(true);
    }
    private void variablesForm() {

        gender = new ButtonGroup();
        container1 = new org.edisoncor.gui.panel.Panel();
        header = new org.edisoncor.gui.panel.Panel();
        center = new JPanel();
        detailsPanel = new JPanel();
        detailsEmployee = new JPanel();
        idLabel = new JLabel();
        phoneLabel = new JLabel();
        entry = new JTimeChooser();
        departure = new JTimeChooser();
        
        entrylabel = new JLabel("Entry Time");
        departurelabel = new JLabel("Departure ");
        JLabel hourwork = new JLabel("Work hours");
        namePerson = new JTextField();
        lastName = new JTextField();
        nameLabel = new JLabel();
        lastNameLabel = new JLabel();
        jobTitle = new JTextField();
        jobTitleLabel = new JLabel();
        workdayslabel = new JLabel();
        searchJob = new JButton();
        phone = new JTextField();
        genderLabel = new JLabel();
        male = new JRadioButton();
        female = new JRadioButton();
        opnBtnPanel = new JPanel();
        register = new JButton();
        delete = new JButton();
        exit = new JButton();
        footer = new JPanel();
        workhours = new JButton("Enter");
        workdays = new JButton("Days");
        
        comment = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        container1.setMaximumSize(container1.getPreferredSize());
        container1.setPreferredSize(new Dimension(737, 280));
        container1.setLayout(new BorderLayout());

        header.setIcon(new ImageIcon(getClass().getResource("/View/img/header/Employee.png")));
        header.setMaximumSize(new Dimension(737, 75));
        header.setMinimumSize(new Dimension(737, 75));
        header.setPreferredSize(new Dimension(737, 75));
        container1.add(header,BorderLayout.NORTH);

        center.setOpaque(false);
        center.setLayout(new BorderLayout());

        detailsPanel.setPreferredSize(new Dimension(683, 100));
        detailsEmployee.setPreferredSize(new Dimension(600, 110));
        
        JPanel conten1 , conten2;
        
        conten1 = new JPanel();
        conten1.setPreferredSize(new Dimension(280,100));
        
        conten1.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        conten2 = new JPanel();
        conten2.setPreferredSize(new Dimension(280,100));
        conten2.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        detailsEmployee.add(conten1);
        detailsEmployee.add(conten2);
        
        detailsPanel.add(detailsEmployee);
        
        idLabel.setFont(new java.awt.Font("Serif", 1, 14)); 
        idLabel.setForeground(new java.awt.Color(0, 0, 0));
        idLabel.setText("Id:");
        idLabel.setPreferredSize(new Dimension(80,20));
     
        conten1.add(idLabel);
        
        idPerson = new JTextField();
        idPerson.setMaximumSize(idPerson.getPreferredSize());
        idPerson.setPreferredSize(new Dimension(180,20));

        conten1.add(idPerson);
        
        nameLabel.setFont(new Font("Serif", 1, 14)); 
        nameLabel.setForeground(new java.awt.Color(0, 0, 0));
        nameLabel.setText("Name:");
        nameLabel.setPreferredSize(new Dimension(80,20));
        conten1.add(nameLabel);
        
        namePerson.setPreferredSize(new Dimension(180,20));
        namePerson.setForeground(Color.BLACK);
        
        conten1.add(namePerson);
        
        lastNameLabel.setFont(new Font("Serif", 1, 14));
        lastNameLabel.setForeground(new Color(0, 0, 0));
        lastNameLabel.setText("Last Name:");
        lastNameLabel.setPreferredSize(new Dimension(80,20));
        conten1.add(lastNameLabel);
        
        lastName.setPreferredSize(new Dimension(180,20));
        lastName.setForeground(Color.BLACK);
        conten1.add(lastName);
         
        genderLabel.setFont(new java.awt.Font("Serif", 1, 14));
        genderLabel.setForeground(new java.awt.Color(0, 0, 0));
        genderLabel.setText("Gender:");
        genderLabel.setPreferredSize(new Dimension(80,20));
        conten1.add(genderLabel);
        
        gender.add(male);
        male.setText("M");

        gender.add(female);
        female.setText("F");
        
        conten1.add(male);
        conten1.add(female);
        
        
        
        
        //for conten2 ...
        
        jobTitle.setEnabled(false);
        jobTitleLabel.setFont(new Font("Serif", 1, 14));
        jobTitleLabel.setForeground(new Color(0, 0, 0));
        jobTitleLabel.setText("Job Title:");
        
        jobTitleLabel.setMaximumSize(jobTitleLabel.getPreferredSize());
        jobTitleLabel.setPreferredSize(new Dimension(80,20));
        
        conten2.add(jobTitleLabel);
        jobTitle.setMaximumSize(jobTitle.getPreferredSize());
        jobTitle.setPreferredSize(new Dimension(140,20));
        conten2.add(jobTitle);
        
        searchJob.setIcon(new ImageIcon(getClass().getResource("/View/img/Sear.png"))); 
        searchJob.setBorderPainted(false);
        searchJob.setContentAreaFilled(false);
        searchJob.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        searchJob.setFocusPainted(false);
        searchJob.setMaximumSize(new Dimension(30, 20));
        searchJob.setMinimumSize(new Dimension(30, 20));
        searchJob.setPreferredSize(new Dimension(30, 20));
       
        searchJob.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                sjobFocusGained(evt);
            }
        });
        
        conten2.add(searchJob);
        
        phoneLabel.setFont(new Font("Serif", 1, 14)); 
        phoneLabel.setForeground(new Color(0, 0, 0));
        phoneLabel.setText("Phone:");
        phoneLabel.setPreferredSize(new Dimension(80,20));
        conten2.add(phoneLabel);
        idPerson.setEnabled(false);

        phone.setPreferredSize(new java.awt.Dimension(180, 20));
        phone.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                
            }
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneKeyTyped(evt);
            }
        });
        
        conten2.add(phone);
        
        workdayslabel.setPreferredSize(new Dimension(80,20));
        workdayslabel.setFont(new Font("Serif", 1, 14));
        workdayslabel.setForeground(new Color(0, 0, 0));
        workdayslabel.setText("Work Days:");
        conten2.add(workdayslabel);
//        workdays.setBorderPainted(false);
        workdays.setContentAreaFilled(false);
        
        workdays.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        workdays.setFocusPainted(false);
        
        workdays.setPreferredSize(new Dimension(180,20));
        conten2.add(workdays);
        workdays.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                String coment = "Select employee work days";
                comment.setText(coment);
            }

            @Override
            public void focusLost(FocusEvent fe) {
               
            }
        });
        
        workdays.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                showdays();
            }
        });
        
        
        hourwork.setPreferredSize(new Dimension(80,20));
        hourwork.setFont(new Font("Serif", Font.BOLD, 14));
        hourwork.setForeground(new Color(0,0,0));
        
        conten2.add(hourwork);
        
        entrylabel.setPreferredSize(new Dimension(70,20));
        entrylabel.setFont(new Font("Serif", 1, 14));
        entrylabel.setForeground(new Color(0, 0, 0));
//        conten2.add(entrylabel);
//        entry.setVisible(false);


        workhours.setPreferredSize(new Dimension(180,20));
        workhours.setContentAreaFilled(false);
        workhours.setCursor(new Cursor(Cursor.HAND_CURSOR));
        conten2.add(workhours);
        workhours.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                showhours();
            }
        });
//        departurelabel.setPreferredSize(new Dimension(70,20));
//        departurelabel.setFont(new Font("Serif", 1, 14));
//        departurelabel.setForeground(new Color(0, 0, 0));
//        conten2.add(departurelabel);
//        
//        departure.setEnabled(false);
//        
////        departure.setVisible(false);
//        departure.setPreferredSize(new Dimension(60,20));
//        departure.setLocale(Locale.US);
//        
//        conten2.add(departure);
        namePerson.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                namepersonKeyTyped(evt);
            }
        });

        lastName.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lastnameKeyTyped(evt);
            }
        });

        
        center.add(detailsPanel,BorderLayout.CENTER);

        opnBtnPanel.setPreferredSize(new Dimension(450, 40));

        register.setIcon(new ImageIcon(getClass().getResource("/View/img/save.png"))); 
        register.setBorderPainted(false);
        register.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        register.setMaximumSize(new Dimension(150, 30));
        register.setMinimumSize(new Dimension(150, 30));
        register.setOpaque(false);
        register.setPreferredSize(new java.awt.Dimension(150, 30));
        
        register.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
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
            @Override
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
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                exitFocusGained(evt);
            }
        });
        opnBtnPanel.add(exit);

        center.add(opnBtnPanel, java.awt.BorderLayout.SOUTH);

        container1.add(center, java.awt.BorderLayout.CENTER);

        footer.setPreferredSize(new java.awt.Dimension(450, 32));
        footer.setLayout(new java.awt.BorderLayout());

        comment.setFont(new java.awt.Font("Serif", 1, 14));
        comment.setForeground(new java.awt.Color(0, 0, 0));
        footer.add(comment, java.awt.BorderLayout.CENTER);

        container1.add(footer, java.awt.BorderLayout.SOUTH);

        getContentPane().add(container1);

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
    
    private void sjobFocusGained(java.awt.event.FocusEvent evt) {
         String profBtn = "Look for the profession of this employee to associate";
        getComment().setText(profBtn);
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

    private void phoneKeyTyped(java.awt.event.KeyEvent evt) {
       char b = evt.getKeyChar();
        
         if(Character.isLetter(b) || Character.isWhitespace(b) || getPhone().getText().length() > 10 || !Character.isDigit(b)){
            evt.consume();
         }
    }
    
    class SelectTime  extends JDialog implements TimeChangedListener{
        
        private JButton exit,sep;
        private JPanel panelcent,footer;
        private JSlider timesele,timerank;
        
        SelectTime(){
            super(principal,true);
            setTitle("Check in and check out time");
            setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            setPreferredSize(new Dimension(300,300));
            setMaximumSize(getPreferredSize());
            setMinimumSize(getPreferredSize());
            
            setResizable(false);
            setLocationRelativeTo(getWorkhours());
            setLayout(new BorderLayout());
            asignlam();
            setListener();
            sep.setEnabled(true);
        }
        
        private void asignlam(){
            panelcent = new JPanel();
            panelcent.setLayout(new BorderLayout());
            
            JPanel option1 = new JPanel();
            option1.setPreferredSize(new Dimension(0,100));
            
            JLabel timlab = new JLabel("Time:");
             timlab.setPreferredSize(new Dimension(100,50));
            timlab.setFont(new Font("Serif",Font.BOLD,18));
            
           
            entry =   new JTimeChooser();
            entry.setFont(new Font("Serif",Font.BOLD,34));
            
            entry.setPreferredSize(new Dimension(100,20));
            entry.setMaximumSize(entry.getPreferredSize());
            
           
            timesele = new JSlider(0, 86400,0);
            timesele.setPreferredSize(new Dimension(200,50));
            option1.add(timlab);
            option1.add(entry);
            option1.add(timesele);
            
            JPanel option2 = new JPanel();
            option2.setPreferredSize(new Dimension(0,100));
            
            JLabel timlab1 = new JLabel("End Time:");
            timlab1.setPreferredSize(new Dimension(100,50));
            timlab1.setFont(new Font("Serif",Font.BOLD,18));
            departure = new JTimeChooser();
            departure.setPreferredSize(new Dimension(100,20));
            departure.setMaximumSize(departure.getPreferredSize());
            
            
            timerank = new JSlider(0, 86400,0);
            timerank.setPreferredSize(new Dimension(200,50));
            
            option2.add(timlab1);
            option2.add(departure);
            option2.add(timerank);
            panelcent.add(option1,BorderLayout.CENTER);
            panelcent.add(option2,BorderLayout.SOUTH);
            
            add(panelcent,BorderLayout.CENTER);

            footer = new JPanel();
            
            sep = new JButton("Set");
            exit = new JButton("Exit");
            
            sep.setCursor(new Cursor(Cursor.HAND_CURSOR));
            exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            sep.setPreferredSize(new Dimension(100,30));
            exit.setPreferredSize(new Dimension(100,30));
            
            exit.addActionListener((ActionEvent ae) -> {
                setVisible(false);
                dispose();
            });
            
            
            footer.add(sep);
            footer.add(exit);
            
            add(footer,BorderLayout.SOUTH);
        } 
        private void setListener(){
            
            Calendar sl = Calendar.getInstance();
            timesele.setSnapToTicks(true);
            timerank.setSnapToTicks(true);
            entry.setShowIcon(true);
            entry.setShowIcon(true);
            
//            time.setShowSeconds(false);
//            ranktime.setShowSeconds(false);
            
            timesele.setMinorTickSpacing(1800);
            timesele.setMajorTickSpacing(3600);
            timerank.setMinorTickSpacing(1800);
            timerank.setMajorTickSpacing(3600);
            
            timesele.setPaintTicks(true);
            timesele.setPaintTrack(true);
            
             timerank.setPaintTicks(true);
            timerank.setPaintTrack(true);
            timesele.addChangeListener((ChangeEvent ce) -> {
                int valor = timesele.getValue();
                
                int h3 = sl.get(Calendar.HOUR_OF_DAY);
                int m1 = sl.get(Calendar.MINUTE);
                int s1 = sl.get(Calendar.SECOND);
                
                sl.add(Calendar.HOUR_OF_DAY,-h3);
                sl.add(Calendar.MINUTE,-m1);
                sl.add(Calendar.SECOND,-s1);
                sl.add(Calendar.SECOND, +valor);
                java.sql.Time time1 = java.sql.Time.valueOf(sl.get(Calendar.HOUR_OF_DAY)+":"+sl.get(Calendar.MINUTE)+":"+sl.get(Calendar.SECOND));
                entry.setTime(time1);
                
                sep.setEnabled(true);
                timerank.setValue(valor + 3600);
                timerank.setMinimum(valor);
            });
            timerank.addChangeListener((ChangeEvent ce) -> {
                int valor = timerank.getValue();
                
                int h3 = sl.get(Calendar.HOUR_OF_DAY);
                int m1 = sl.get(Calendar.MINUTE);
                int s1 = sl.get(Calendar.SECOND);
                
                sl.add(Calendar.HOUR_OF_DAY,-h3);
                sl.add(Calendar.MINUTE,-m1);
                sl.add(Calendar.SECOND,-s1);
                sl.add(Calendar.SECOND, +valor);
                java.sql.Time time1 = java.sql.Time.valueOf(sl.get(Calendar.HOUR_OF_DAY)+":"+sl.get(Calendar.MINUTE)+":"+sl.get(Calendar.SECOND));
                departure.setTime(time1);
                
            });
            
            sep.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent as ){
                String time1 = entry.getFormatedTime();
                String time2 = departure.getFormatedTime();
                workhours.setText(time1+" to "+time2);
                workhours.setForeground(Color.black);
                workhours.setBackground(Color.red);
                workhours.setFont(new Font("Serif",Font.ITALIC,14));
               
                setVisible(false);
                dispose();
            }
            
            });
        }
        @Override
        public void timeChanged(TimeChangedEvent event) {
          Object origin = event.getSource();
          if(origin.equals(entry)){
              
          }else if(origin.equals(departure)){
              
          }
        }

    }
   
}
