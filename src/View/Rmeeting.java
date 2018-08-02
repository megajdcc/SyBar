
package View;

import Controller.ControllerMeeting;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import lu.tudor.santec.jtimechooser.JTimeChooser;
import lu.tudor.santec.jtimechooser.TimeChangedEvent;
import lu.tudor.santec.jtimechooser.TimeChangedListener;
import lu.tudor.santec.jtimechooser.TimeChooserModel;
import org.bolivia.time.TimeChooser;

public class Rmeeting extends javax.swing.JDialog implements TimeChangedListener{
    
    private ControllerMeeting controller;
    
    
    public void setController(ControllerMeeting controller){
        this.controller = controller;
        setListener();
    }
    public ControllerMeeting getController(){
        return controller;
    }
    private void setListener(){
       grabar.addActionListener(controller);
       delete.addActionListener(controller);
       exit.addActionListener(controller);
       update.addActionListener(controller);
       
       shaircut.addActionListener(controller);
       semployee.addActionListener(controller);
       sclient.addActionListener(controller);
       
       der.addActionListener(controller);
       izq.addActionListener(controller);
       
       services.addListSelectionListener(controller);
       selectservi.addListSelectionListener(controller);
       getDateclient().getDateEditor().addPropertyChangeListener((PropertyChangeEvent pce) -> {
            getController().reloademployee();
        });
       
       
       getTime().addTimeChangedListener(this);
    }

    public JDateChooser getDateclient() {
        return dateclient;
    }

    public void setDateclient(JDateChooser dateclient) {
        this.dateclient = dateclient;
    }
    public JTimeChooser getTime(){
        return time;
    }

    public JButton getDelete() {
        return delete;
    }

    public void setDelete(JButton delete) {
        this.delete = delete;
    }

    public JButton getDer() {
        return der;
    }

    public void setDer(JButton der) {
        this.der = der;
    }
    public JTextField getDniclient() {
        return phoneclient;
    }

    public void setDniclient(JTextField dniclient) {
        this.phoneclient = dniclient;
    }

    public JTextField getEmployee() {
        return employee;
    }

    public void setEmployee(JTextField employee) {
        this.employee = employee;
    }

    public JButton getExit() {
        return exit;
    }

    public void setExit(JButton exit) {
        this.exit = exit;
    }

    public JButton getGrabar() {
        return grabar;
    }

    public void setGrabar(JButton grabar) {
        this.grabar = grabar;
    }

    public JTextField getHaircut() {
        return haircut;
    }

    public void setHaircut(JTextField haircut) {
        this.haircut = haircut;
    }

    public JButton getIzq() {
        return izq;
    }

    public void setIzq(JButton izq) {
        this.izq = izq;
    }

    public JLabel getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(JLabel leyenda) {
        this.leyenda = leyenda;
    }

    
    public JTextField getNameclient() {
        return nameclient;
    }

    public void setNameclient(JTextField nameclient) {
        this.nameclient = nameclient;
    }

    public JButton getUpdate() {
        return update;
    }

    public void setUpdate(JButton update) {
        this.update = update;
    }

    

   
    public JButton getSclient() {
        return sclient;
    }

    public void setSclient(JButton sclient) {
        this.sclient = sclient;
    }

    public JList<String> getSelectservi() {
        return selectservi;
    }

    public void setSelectservi(JList<String> selectservi) {
        this.selectservi = selectservi;
    }

    public JButton getSemployee() {
        return semployee;
    }

    public void setSemployee(JButton semployee) {
        this.semployee = semployee;
    }

    public JList<String> getServices() {
        return services;
    }

    public void setServices(JList<String> services) {
        this.services = services;
    }

    public JButton getShaircut() {
        return shaircut;
    }

    public void setShaircut(JButton shaircut) {
        this.shaircut = shaircut;
    }

    public JTextField getLastnameclient() {
        return lastnameclient;
    }

    public void setLastnameclient(JTextField lastnameclient) {
        this.lastnameclient = lastnameclient;
    }

    public JTabbedPane getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(JTabbedPane movimiento) {
        this.movimiento = movimiento;
    }
    /**
     * Creates new form Rmeeting
     * @param parent
     * @param modal
     */
    public Rmeeting(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Meeting");
        setResizable(false);
        setLocationRelativeTo(null);
        getDateclient().setMinSelectableDate(new Date());
      
        getDateclient().setDate(new Date());
        
        getTime().setLocale(Locale.US);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
         DefaultListModel model = new DefaultListModel();
         this.selectservi.setModel(model);
        
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        header = new org.edisoncor.gui.panel.Panel();
        cent = new javax.swing.JPanel();
        LDinam = new javax.swing.JPanel();
        Lperson = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        phoneclient = new javax.swing.JTextField();
        sclient = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lastnameclient = new javax.swing.JTextField();
        nameclient = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        movimiento = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        selectservi = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        services = new javax.swing.JList<>();
        der = new javax.swing.JButton();
        izq = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        employee = new javax.swing.JTextField();
        semployee = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        haircut = new javax.swing.JTextField();
        shaircut = new javax.swing.JButton();
        dateclient = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        time = new lu.tudor.santec.jtimechooser.JTimeChooser();
        Lopciones = new javax.swing.JPanel();
        grabar = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        leyenda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(737, 408));
        setPreferredSize(new java.awt.Dimension(737, 479));
        getContentPane().setLayout(new java.awt.CardLayout());

        panel1.setMaximumSize(new java.awt.Dimension(737, 504));
        panel1.setMinimumSize(new java.awt.Dimension(737, 457));
        panel1.setPreferredSize(new java.awt.Dimension(737, 479));
        panel1.setLayout(new java.awt.BorderLayout());

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

        panel1.add(header, java.awt.BorderLayout.NORTH);

        cent.setOpaque(false);
        cent.setLayout(new java.awt.BorderLayout());

        LDinam.setPreferredSize(new java.awt.Dimension(683, 150));

        Lperson.setPreferredSize(new java.awt.Dimension(0, 140));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Phone Client:");

        phoneclient.setEnabled(false);

        sclient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/Sear.png"))); // NOI18N
        sclient.setBorderPainted(false);
        sclient.setContentAreaFilled(false);
        sclient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sclient.setFocusPainted(false);
        sclient.setMaximumSize(new java.awt.Dimension(30, 30));
        sclient.setMinimumSize(new java.awt.Dimension(30, 30));
        sclient.setPreferredSize(new java.awt.Dimension(30, 30));
        sclient.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sclientFocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Last Name:");

        lastnameclient.setEnabled(false);

        nameclient.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Date:");

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

        der.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/der.png"))); // NOI18N
        der.setBorderPainted(false);
        der.setContentAreaFilled(false);
        der.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        der.setFocusPainted(false);
        der.setMinimumSize(new java.awt.Dimension(30, 30));
        der.setPreferredSize(new java.awt.Dimension(30, 30));
        der.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                derFocusGained(evt);
            }
        });

        izq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/izq.png"))); // NOI18N
        izq.setBorderPainted(false);
        izq.setContentAreaFilled(false);
        izq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        izq.setFocusPainted(false);
        izq.setMinimumSize(new java.awt.Dimension(30, 30));
        izq.setPreferredSize(new java.awt.Dimension(30, 30));
        izq.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                izqFocusGained(evt);
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
                    .addComponent(der, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(izq, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
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
                    .addComponent(der, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(izq, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        movimiento.addTab("Services", jPanel1);

        jLabel6.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Haircut:");

        employee.setEnabled(false);

        semployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/Sear.png"))); // NOI18N
        semployee.setBorderPainted(false);
        semployee.setContentAreaFilled(false);
        semployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semployee.setFocusPainted(false);
        semployee.setMaximumSize(new java.awt.Dimension(30, 30));
        semployee.setMinimumSize(new java.awt.Dimension(30, 30));
        semployee.setPreferredSize(new java.awt.Dimension(30, 30));
        semployee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                semployeeFocusGained(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Employee:");

        haircut.setEnabled(false);

        shaircut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/Sear.png"))); // NOI18N
        shaircut.setBorderPainted(false);
        shaircut.setContentAreaFilled(false);
        shaircut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        shaircut.setFocusPainted(false);
        shaircut.setMaximumSize(new java.awt.Dimension(30, 30));
        shaircut.setMinimumSize(new java.awt.Dimension(30, 30));
        shaircut.setPreferredSize(new java.awt.Dimension(30, 30));
        shaircut.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                shaircutFocusGained(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Time:");

        javax.swing.GroupLayout LpersonLayout = new javax.swing.GroupLayout(Lperson);
        Lperson.setLayout(LpersonLayout);
        LpersonLayout.setHorizontalGroup(
            LpersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LpersonLayout.createSequentialGroup()
                .addGroup(LpersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LpersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastnameclient, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneclient, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameclient, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(sclient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LpersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(LpersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LpersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(LpersonLayout.createSequentialGroup()
                            .addGroup(LpersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(employee, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                .addComponent(haircut))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(LpersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(shaircut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(semployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(dateclient, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LpersonLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(movimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        LpersonLayout.setVerticalGroup(
            LpersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LpersonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LpersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sclient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneclient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateclient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LpersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(LpersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastnameclient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LpersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LpersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(haircut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(shaircut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(movimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(LpersonLayout.createSequentialGroup()
                .addGroup(LpersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LpersonLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(LpersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameclient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(LpersonLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LpersonLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(semployee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LpersonLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LDinamLayout = new javax.swing.GroupLayout(LDinam);
        LDinam.setLayout(LDinamLayout);
        LDinamLayout.setHorizontalGroup(
            LDinamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LDinamLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(Lperson, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        LDinamLayout.setVerticalGroup(
            LDinamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LDinamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lperson, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        cent.add(LDinam, java.awt.BorderLayout.CENTER);

        Lopciones.setPreferredSize(new java.awt.Dimension(737, 50));

        grabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/process.png"))); // NOI18N
        grabar.setBorderPainted(false);
        grabar.setContentAreaFilled(false);
        grabar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        grabar.setFocusPainted(false);
        grabar.setPreferredSize(new java.awt.Dimension(150, 30));
        grabar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                grabarFocusGained(evt);
            }
        });
        Lopciones.add(grabar);

        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/update.png"))); // NOI18N
        update.setBorderPainted(false);
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.setFocusPainted(false);
        update.setOpaque(false);
        update.setPreferredSize(new java.awt.Dimension(150, 30));
        update.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                updateFocusGained(evt);
            }
        });
        Lopciones.add(update);

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/delete.png"))); // NOI18N
        delete.setBorderPainted(false);
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.setFocusPainted(false);
        delete.setOpaque(false);
        delete.setPreferredSize(new java.awt.Dimension(150, 30));
        delete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                deleteFocusGained(evt);
            }
        });
        Lopciones.add(delete);

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/exit.png"))); // NOI18N
        exit.setBorderPainted(false);
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setFocusPainted(false);
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
        Lopciones.add(exit);

        cent.add(Lopciones, java.awt.BorderLayout.SOUTH);

        panel1.add(cent, java.awt.BorderLayout.CENTER);

        footer.setPreferredSize(new java.awt.Dimension(737, 32));
        footer.setLayout(new java.awt.BorderLayout());

        leyenda.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        leyenda.setForeground(new java.awt.Color(0, 0, 0));
        footer.add(leyenda, java.awt.BorderLayout.CENTER);

        panel1.add(footer, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void grabarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_grabarFocusGained
        String leyend = "Save";
        getLeyenda().setText(leyend);
    }//GEN-LAST:event_grabarFocusGained

    private void deleteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_deleteFocusGained
        String leyend = "Cancel the appointment";
        getLeyenda().setText(leyend);
    }//GEN-LAST:event_deleteFocusGained

    private void exitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_exitFocusGained
        String leyend = "Get out";
        getLeyenda().setText(leyend);
    }//GEN-LAST:event_exitFocusGained

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed

    }//GEN-LAST:event_exitActionPerformed

    private void sclientFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sclientFocusGained
        String leyend = "Search and select the client to associate with the appointment";
        getLeyenda().setText(leyend);
    }//GEN-LAST:event_sclientFocusGained

    private void semployeeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_semployeeFocusGained
       String leyend = "Search and select the employee who will the work";
        getLeyenda().setText(leyend);
    }//GEN-LAST:event_semployeeFocusGained

    private void shaircutFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_shaircutFocusGained
        String leyend = "Search and select the type of cut desired by the customer";
        getLeyenda().setText(leyend);
    }//GEN-LAST:event_shaircutFocusGained

    private void servicesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_servicesFocusGained
       String leyend = "All the services that you can associate with work";
        getLeyenda().setText(leyend);
    }//GEN-LAST:event_servicesFocusGained

    private void derFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_derFocusGained
         String leyend = "Associate the service with the one desired by the client";
        getLeyenda().setText(leyend);
    }//GEN-LAST:event_derFocusGained

    private void izqFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_izqFocusGained
        String leyend = "if you make a mistake with the associated service, you can take";
        getLeyenda().setText(leyend);
    }//GEN-LAST:event_izqFocusGained

    private void selectserviFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_selectserviFocusGained
       String leyend = "All services taken by the client";
        getLeyenda().setText(leyend);
    }//GEN-LAST:event_selectserviFocusGained

    private void updateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updateFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_updateFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LDinam;
    private javax.swing.JPanel Lopciones;
    private javax.swing.JPanel Lperson;
    private javax.swing.JPanel cent;
    private com.toedter.calendar.JDateChooser dateclient;
    private javax.swing.JButton delete;
    private javax.swing.JButton der;
    private javax.swing.JTextField employee;
    private javax.swing.JButton exit;
    private javax.swing.JPanel footer;
    private javax.swing.JButton grabar;
    private javax.swing.JTextField haircut;
    private org.edisoncor.gui.panel.Panel header;
    private javax.swing.JButton izq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lastnameclient;
    private javax.swing.JLabel leyenda;
    private javax.swing.JTabbedPane movimiento;
    private javax.swing.JTextField nameclient;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTextField phoneclient;
    private javax.swing.JButton sclient;
    private javax.swing.JList<String> selectservi;
    private javax.swing.JButton semployee;
    private javax.swing.JList<String> services;
    private javax.swing.JButton shaircut;
    private lu.tudor.santec.jtimechooser.JTimeChooser time;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

    @Override
    public void timeChanged(TimeChangedEvent event) {
        getEmployee().setText("");
    }

  
}
