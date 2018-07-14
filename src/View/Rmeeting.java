package View;

import Controller.ControllerMeeting;
import com.lavantech.gui.comp.DateTimePicker;

import java.util.GregorianCalendar;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class Rmeeting extends javax.swing.JDialog {
    
    private ControllerMeeting controllerMeeting;
    
    
    public void setControllerMeeting(ControllerMeeting controllerMeeting){
        this.controllerMeeting = controllerMeeting;
        setListener();
    }
    public ControllerMeeting getControllerMeeting(){
        return controllerMeeting;
    }
    private void setListener(){
       processBtt.addActionListener(controllerMeeting);
       deleteBtt.addActionListener(controllerMeeting);
       exitBtt.addActionListener(controllerMeeting);
       updateBtt.addActionListener(controllerMeeting);
       
       sHairCut.addActionListener(controllerMeeting);
       sEmployee.addActionListener(controllerMeeting);
       sClient.addActionListener(controllerMeeting);
       
       nextBtt.addActionListener(controllerMeeting);
       backBtt.addActionListener(controllerMeeting);
       
       services.addListSelectionListener(controllerMeeting);
       selectservi.addListSelectionListener(controllerMeeting);
       
    }

    public DateTimePicker getDateClient() {
        return dateClient;
    }

    public void setDateClient(DateTimePicker dateClient) {
        this.dateClient = dateClient;
    }

    public JButton getDelete() {
        return deleteBtt;
    }

    public void setDelete(JButton delete) {
        this.deleteBtt = delete;
    }

    public JButton getNextBtt() {
        return nextBtt;
    }

    public void setNextBtt(JButton nextBtt) {
        this.nextBtt = nextBtt;
    }
    public JTextField getPhoneClient() {
        return phoneClient;
    }

    public void setPhoneClient(JTextField phoneClient) {
        this.phoneClient = phoneClient;
    }

    public JTextField getEmployee() {
        return employee;
    }

    public void setEmployee(JTextField employee) {
        this.employee = employee;
    }

    public JButton getExit() {
        return exitBtt;
    }

    public void setExit(JButton exit) {
        this.exitBtt = exit;
    }

    public JButton getProcessBtt() {
        return processBtt;
    }

    public void setProcessBtt(JButton processBtt) {
        this.processBtt = processBtt;
    }

    public JTextField getHaircut() {
        return haircut;
    }

    public void setHaircut(JTextField haircut) {
        this.haircut = haircut;
    }

    public JButton getBackBtt() {
        return backBtt;
    }

    public void setBackBtt(JButton backBtt) {
        this.backBtt = backBtt;
    }

    public JLabel getCommend() {
        return commend;
    }

    public void setCommend(JLabel commend) {
        this.commend = commend;
    }

    
    public JTextField getNameClient() {
        return nameClient;
    }

    public void setNameClient(JTextField nameClient) {
        this.nameClient = nameClient;
    }

    public JButton getUpdate() {
        return updateBtt;
    }

    public void setUpdate(JButton update) {
        this.updateBtt = update;
    }

    

   
    public JButton getSClient() {
        return sClient;
    }

    public void setSClient(JButton sClient) {
        this.sClient = sClient;
    }

    public JList<String> getSelectservi() {
        return selectservi;
    }

    public void setSelectservi(JList<String> selectservi) {
        this.selectservi = selectservi;
    }

    public JButton getSemployee() {
        return sEmployee;
    }

    public void setSemployee(JButton semployee) {
        this.sEmployee = semployee;
    }

    public JList<String> getServices() {
        return services;
    }

    public void setServices(JList<String> services) {
        this.services = services;
    }

    public JButton getSHaircut() {
        return sHairCut;
    }

    public void setSHaircut(JButton sHairCut) {
        this.sHairCut = sHairCut;
    }

    public JTextField getLastNameClient() {
        return lastNameClient;
    }

    public void setLastNameClient(JTextField lastNameClient) {
        this.lastNameClient = lastNameClient;
    }

    public JTabbedPane getServicePanel() {
        return servicePanel;
    }

    public void setServicePanel(JTabbedPane servicePanel) {
        this.servicePanel = servicePanel;
    }
    /**
     * Creates new form Rmeeting
     * @param parent
     * @param modal
     */
    public Rmeeting(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        variablesForm();
        setTitle("Meeting");
        setResizable(false);
        setLocationRelativeTo(null);
        getDateClient().setMinSelectableTime(new GregorianCalendar());
         DefaultListModel model = new DefaultListModel();
         this.selectservi.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void variablesForm() {

        panelMeeting = new org.edisoncor.gui.panel.Panel();
        header = new org.edisoncor.gui.panel.Panel();
        center = new javax.swing.JPanel();
        panelDetailsMeeting = new javax.swing.JPanel();
        detailsPerson = new javax.swing.JPanel();
        jLabelPhoneClients = new javax.swing.JLabel();
        phoneClient = new javax.swing.JTextField();
        sClient = new javax.swing.JButton();
        jLabelName = new javax.swing.JLabel();
        jLabelLastName = new javax.swing.JLabel();
        lastNameClient = new javax.swing.JTextField();
        nameClient = new javax.swing.JTextField();
        jLabelDate = new javax.swing.JLabel();
        servicePanel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        selectservi = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        services = new javax.swing.JList<>();
        nextBtt = new javax.swing.JButton();
        backBtt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelHairCut = new javax.swing.JLabel();
        employee = new javax.swing.JTextField();
        sEmployee = new javax.swing.JButton();
        jLabelEmployee = new javax.swing.JLabel();
        haircut = new javax.swing.JTextField();
        sHairCut = new javax.swing.JButton();
        dateClient = new com.lavantech.gui.comp.DateTimePicker();
        Lopciones = new javax.swing.JPanel();
        processBtt = new javax.swing.JButton();
        updateBtt = new javax.swing.JButton();
        deleteBtt = new javax.swing.JButton();
        exitBtt = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        commend = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(737, 408));
        getContentPane().setLayout(new java.awt.CardLayout());

        panelMeeting.setMaximumSize(new java.awt.Dimension(737, 504));
        panelMeeting.setMinimumSize(new java.awt.Dimension(737, 457));
        panelMeeting.setPreferredSize(new java.awt.Dimension(737, 408));
        panelMeeting.setLayout(new java.awt.BorderLayout());

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/header/Meeting.png"))); // NOI18N
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

        panelMeeting.add(header, java.awt.BorderLayout.NORTH);

        center.setOpaque(false);
        center.setLayout(new java.awt.BorderLayout());

        panelDetailsMeeting.setPreferredSize(new java.awt.Dimension(683, 150));

        detailsPerson.setPreferredSize(new java.awt.Dimension(0, 140));

        jLabelPhoneClients.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabelPhoneClients.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPhoneClients.setText("Phone Client:");

        phoneClient.setEnabled(false);

        sClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/Sear.png"))); // NOI18N
        sClient.setBorderPainted(false);
        sClient.setContentAreaFilled(false);
        sClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sClient.setFocusPainted(false);
        sClient.setMaximumSize(new java.awt.Dimension(30, 30));
        sClient.setMinimumSize(new java.awt.Dimension(30, 30));
        sClient.setPreferredSize(new java.awt.Dimension(30, 30));
        sClient.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sclientFocusGained(evt);
            }
        });

        jLabelName.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName.setText("Name:");

        jLabelLastName.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabelLastName.setForeground(new java.awt.Color(0, 0, 0));
        jLabelLastName.setText("Last Name:");

        lastNameClient.setEnabled(false);

        nameClient.setEnabled(false);

        jLabelDate.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabelDate.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDate.setText("Date:");

        selectservi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                selectserviFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(selectservi);

        services.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                servicesFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(services);

        nextBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/der.png"))); // NOI18N
        nextBtt.setBorderPainted(false);
        nextBtt.setContentAreaFilled(false);
        nextBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextBtt.setFocusPainted(false);
        nextBtt.setMinimumSize(new java.awt.Dimension(30, 30));
        nextBtt.setPreferredSize(new java.awt.Dimension(30, 30));
        nextBtt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nextBttFocusGained(evt);
            }
        });

        backBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/izq.png"))); // NOI18N
        backBtt.setBorderPainted(false);
        backBtt.setContentAreaFilled(false);
        backBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtt.setFocusPainted(false);
        backBtt.setMinimumSize(new java.awt.Dimension(30, 30));
        backBtt.setPreferredSize(new java.awt.Dimension(30, 30));
        backBtt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                backBttFocusGained(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Services:");

        jLabel8.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Selected:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nextBtt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextBtt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(backBtt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        servicePanel.addTab("Services", jPanel1);

        jLabelHairCut.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabelHairCut.setForeground(new java.awt.Color(0, 0, 0));
        jLabelHairCut.setText("Haircut:");

        employee.setEnabled(false);

        sEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/Sear.png"))); // NOI18N
        sEmployee.setBorderPainted(false);
        sEmployee.setContentAreaFilled(false);
        sEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sEmployee.setFocusPainted(false);
        sEmployee.setMaximumSize(new java.awt.Dimension(30, 30));
        sEmployee.setMinimumSize(new java.awt.Dimension(30, 30));
        sEmployee.setPreferredSize(new java.awt.Dimension(30, 30));
        sEmployee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                semployeeFocusGained(evt);
            }
        });

        jLabelEmployee.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabelEmployee.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmployee.setText("Employee:");

        haircut.setEnabled(false);

        sHairCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/Sear.png"))); // NOI18N
        sHairCut.setBorderPainted(false);
        sHairCut.setContentAreaFilled(false);
        sHairCut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sHairCut.setFocusPainted(false);
        sHairCut.setMaximumSize(new java.awt.Dimension(30, 30));
        sHairCut.setMinimumSize(new java.awt.Dimension(30, 30));
        sHairCut.setPreferredSize(new java.awt.Dimension(30, 30));
        sHairCut.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                shaircutFocusGained(evt);
            }
        });

        dateClient.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dateclientFocusGained(evt);
            }
        });

        javax.swing.GroupLayout gl_detailsPerson = new javax.swing.GroupLayout(detailsPerson);
        detailsPerson.setLayout(gl_detailsPerson);
        gl_detailsPerson.setHorizontalGroup(
            gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_detailsPerson.createSequentialGroup()
                .addContainerGap()
                .addGroup(gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(servicePanel)
                    .addGroup(gl_detailsPerson.createSequentialGroup()
                        .addGroup(gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPhoneClients)
                            .addComponent(jLabelLastName)
                            .addComponent(jLabelName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneClient, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameClient, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNameClient, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gl_detailsPerson.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_detailsPerson.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelHairCut)
                                    .addComponent(jLabelEmployee))
                                .addGap(18, 18, 18)))
                        .addGroup(gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gl_detailsPerson.createSequentialGroup()
                                .addGroup(gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(employee, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(haircut, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sHairCut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(dateClient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        gl_detailsPerson.setVerticalGroup(
            gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_detailsPerson.createSequentialGroup()
                .addContainerGap()
                .addGroup(gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gl_detailsPerson.createSequentialGroup()
                        .addGroup(gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gl_detailsPerson.createSequentialGroup()
                                .addComponent(dateClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(sHairCut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(gl_detailsPerson.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelHairCut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(gl_detailsPerson.createSequentialGroup()
                        .addGroup(gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPhoneClients, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(employee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(haircut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNameClient))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(servicePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(gl_detailsPerson.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(gl_detailsPerson.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelName)
                            .addComponent(nameClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout gl_panelDetailsMeeting = new javax.swing.GroupLayout(panelDetailsMeeting);
        panelDetailsMeeting.setLayout(gl_panelDetailsMeeting);
        gl_panelDetailsMeeting.setHorizontalGroup(
            gl_panelDetailsMeeting.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_panelDetailsMeeting.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(detailsPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        gl_panelDetailsMeeting.setVerticalGroup(
            gl_panelDetailsMeeting.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_panelDetailsMeeting.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailsPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        center.add(panelDetailsMeeting, java.awt.BorderLayout.CENTER);

        Lopciones.setPreferredSize(new java.awt.Dimension(737, 50));

        processBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/process.png"))); // NOI18N
        processBtt.setBorderPainted(false);
        processBtt.setContentAreaFilled(false);
        processBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        processBtt.setFocusPainted(false);
        processBtt.setPreferredSize(new java.awt.Dimension(150, 30));
        processBtt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                processBttFocusGained(evt);
            }
        });
        Lopciones.add(processBtt);

        updateBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/update.png"))); // NOI18N
        updateBtt.setBorderPainted(false);
        updateBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtt.setFocusPainted(false);
        updateBtt.setOpaque(false);
        updateBtt.setPreferredSize(new java.awt.Dimension(150, 30));
        updateBtt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                updateFocusGained(evt);
            }
        });
        Lopciones.add(updateBtt);

        deleteBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/delete.png"))); // NOI18N
        deleteBtt.setBorderPainted(false);
        deleteBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtt.setFocusPainted(false);
        deleteBtt.setOpaque(false);
        deleteBtt.setPreferredSize(new java.awt.Dimension(150, 30));
        deleteBtt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                deleteFocusGained(evt);
            }
        });
        Lopciones.add(deleteBtt);

        exitBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/exit.png"))); // NOI18N
        exitBtt.setBorderPainted(false);
        exitBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtt.setFocusPainted(false);
        exitBtt.setOpaque(false);
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
        Lopciones.add(exitBtt);

        center.add(Lopciones, java.awt.BorderLayout.SOUTH);

        panelMeeting.add(center, java.awt.BorderLayout.CENTER);

        footer.setPreferredSize(new java.awt.Dimension(737, 32));
        footer.setLayout(new java.awt.BorderLayout());

        commend.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        commend.setForeground(new java.awt.Color(0, 0, 0));
        footer.add(commend, java.awt.BorderLayout.CENTER);

        panelMeeting.add(footer, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panelMeeting, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void processBttFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_processBttFocusGained
        String commend = "Save";
        getCommend().setText(commend);
    }//GEN-LAST:event_processBttFocusGained

    private void deleteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_deleteFocusGained
        String commend = "Cancel the appointment";
        getCommend().setText(commend);
    }//GEN-LAST:event_deleteFocusGained

    private void exitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_exitFocusGained
        String commend = "Get out";
        getCommend().setText(commend);
    }//GEN-LAST:event_exitFocusGained

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed

    }//GEN-LAST:event_exitActionPerformed

    private void sclientFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sclientFocusGained
        String commend = "Search and select the client to associate with the appointment";
        getCommend().setText(commend);
    }//GEN-LAST:event_sclientFocusGained

    private void dateclientFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateclientFocusGained
        String commend = "Select the time and date of the appointment";
        getCommend().setText(commend);
    }//GEN-LAST:event_dateclientFocusGained

    private void semployeeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_semployeeFocusGained
       String commend = "Search and select the employee who will the work";
        getCommend().setText(commend);
    }//GEN-LAST:event_semployeeFocusGained

    private void shaircutFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_shaircutFocusGained
        String commend = "Search and select the type of cut desired by the customer";
        getCommend().setText(commend);
    }//GEN-LAST:event_shaircutFocusGained

    private void servicesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_servicesFocusGained
       String commend = "All the services that you can associate with work";
        getCommend().setText(commend);
    }//GEN-LAST:event_servicesFocusGained

    private void nextBttFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nextBttFocusGained
         String commend = "Associate the service with the one desired by the client";
        getCommend().setText(commend);
    }//GEN-LAST:event_nextBttFocusGained

    private void backBttFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_backBttFocusGained
        String commend = "if you make a mistake with the associated service, you can take";
        getCommend().setText(commend);
    }//GEN-LAST:event_backBttFocusGained

    private void selectserviFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_selectserviFocusGained
       String commend = "All services taken by the client";
        getCommend().setText(commend);
    }//GEN-LAST:event_selectserviFocusGained

    private void updateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updateFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_updateFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelDetailsMeeting;
    private javax.swing.JPanel Lopciones;
    private javax.swing.JPanel detailsPerson;
    private javax.swing.JPanel center;
    private com.lavantech.gui.comp.DateTimePicker dateClient;
    private javax.swing.JButton deleteBtt;
    private javax.swing.JButton nextBtt;
    private javax.swing.JTextField employee;
    private javax.swing.JButton exitBtt;
    private javax.swing.JPanel footer;
    private javax.swing.JButton processBtt;
    private javax.swing.JTextField haircut;
    private org.edisoncor.gui.panel.Panel header;
    private javax.swing.JButton backBtt;
    private javax.swing.JLabel jLabelPhoneClients;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelHairCut;
    private javax.swing.JLabel jLabelEmployee;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lastNameClient;
    private javax.swing.JLabel commend;
    private javax.swing.JTabbedPane servicePanel;
    private javax.swing.JTextField nameClient;
    private org.edisoncor.gui.panel.Panel panelMeeting;
    private javax.swing.JTextField phoneClient;
    private javax.swing.JButton sClient;
    private javax.swing.JList<String> selectservi;
    private javax.swing.JButton sEmployee;
    private javax.swing.JList<String> services;
    private javax.swing.JButton sHairCut;
    private javax.swing.JButton updateBtt;
    // End of variables declaration//GEN-END:variables
}
