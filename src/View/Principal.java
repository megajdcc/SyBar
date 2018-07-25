/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerPrincipal;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import org.edisoncor.gui.panel.Panel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
/**
 *
 * @author Jnatn'h
 */
public class Principal extends javax.swing.JFrame {

    //Field of class
    private static ControllerPrincipal controller;
    protected static int idUser;
    private JLabel user,dni,carg,date,time;
    private JButton getout,close;
    
    public static void setIduser(int iduser){
     Principal.idUser = iduser;   
    }
    public static int getIduser(){
     return Principal.idUser;   
    }
    
    public static ControllerPrincipal getController(){
      return controller;
    }
    public static void setController(ControllerPrincipal controlle){
     controller = controlle;
     
    }

    public static int getIdUser() {
        return idUser;
    }

    public static void setIdUser(int idUser) {
        Principal.idUser = idUser;
    }

    public JButton getGetout() {
        return getout;
    }

    public void setGetout(JButton getout) {
        this.getout = getout;
    }

    public JButton getClose() {
        return close;
    }

    public void setClose(JButton close) {
        this.close = close;
    }

    public JTree getMenu() {
        return menu;
    }

    public void setMenu(JTree menu) {
        this.menu = menu;
    }
    
    private void Listener(){
        getMenu().addTreeSelectionListener(controller);
        getMenu().addTreeExpansionListener(controller);
        getGetout().addActionListener(controller);
        getClose().addActionListener(controller);
    }
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        setDefaultLookAndFeelDecorated(false);
        setPreferredSize(new Dimension(600,400));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        
        starwindow();
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setController(new ControllerPrincipal(this));
        this.Listener();
        setTitle("BarberQ");
        setLocationRelativeTo(null);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        screenshotscreen();
        datetime();
        

    }
    private void datetime(){
    Date date = new Date();
    DateFormat hor = new SimpleDateFormat("HH:mm:ss");
     this.getTime().setText("Time: "+hor.format(date));
//     obtenemos date
    DateFormat fech = new SimpleDateFormat("dd/MM/yyyy");
    this.getDate().setText("Date: "+fech.format(date));    
}
    private void header(Panel principal){
        header = new Panel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/View/img/header2.png"));  
        header.setIcon(icon);
        header.setPreferredSize(new Dimension(0,100));
        header.setOpaque(true);
     
        principal.add(header,BorderLayout.NORTH);
    }
    private void footer(Panel principal){
        footer = new JPanel();
        footer.setPreferredSize(new Dimension(0,30));
        footer.setBackground(Color.LIGHT_GRAY);
        this.optionfooter(footer);
        principal.add(footer,BorderLayout.SOUTH);
    }
    private void optionfooter(JPanel footer){
        footer.setLayout(new GridLayout(1,5));
        
        
        user = new JLabel("");
        user.setForeground(Color.BLACK);
        user.setFont(new Font(Font.SERIF,Font.ITALIC,14));
        footer.add(user);
        
        
        
        dni = new JLabel("");
        dni.setForeground(Color.BLACK);
        dni.setFont(new Font(Font.SERIF,Font.ITALIC,14));
        footer.add(dni);
        
        carg = new JLabel("");
        carg.setForeground(Color.BLACK);
        carg.setFont(new Font(Font.SERIF,Font.ITALIC,14));
        footer.add(carg);
        
        date = new JLabel("");
        date.setForeground(Color.BLACK);
        date.setFont(new Font(Font.SERIF,Font.ITALIC,14));
        footer.add(date);
        
        

        
        time = new JLabel("");
        time.setForeground(Color.BLACK);
        time.setFont(new Font(Font.SERIF,Font.ITALIC,14));
        footer.add(time);
        
    }
    private void menuside(Panel principal){
        left = new JPanel();
        left.setLayout(new CardLayout());
        left.setPreferredSize(new Dimension(200,300));
        contenmenu = new JScrollPane();
        menu = new JTree();
        menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu.setForeground(new Color(Color.OPAQUE,false));
        menu.setBackground(Color.WHITE);
        optioneofmenu();
        principal.add(left,BorderLayout.WEST);
    }
    private void center(Panel principal){
        center = new Panel();
        center.setLayout(new BorderLayout(0,0));
        center.setPreferredSize(new Dimension(0,30));
        ImageIcon icon = new ImageIcon(getClass().getResource("/View/img/fondo.png"));  
        center.setIcon(icon);
        JPanel opcenter = new JPanel();
        FlowLayout layoutopcenter = new FlowLayout(FlowLayout.RIGHT);
        opcenter.setOpaque(false);
        opcenter.setLayout(layoutopcenter);
        
        close = new JButton();
        ImageIcon closes = new ImageIcon(getClass().getResource("/View/img/close.png"));
        close.setIcon(closes);
        close.setBackground(Color.LIGHT_GRAY);
        
        close.setBorderPainted(false);
        close.setOpaque(false);
        close.setPreferredSize(new Dimension(150,30));
        close.setCursor(new Cursor(Cursor.HAND_CURSOR));
        opcenter.add(close);
        
        getout = new JButton();
        ImageIcon cerra = new ImageIcon(getClass().getResource("/View/img/exit.png"));
        getout.setIcon(cerra);
        getout.setBackground(Color.LIGHT_GRAY);
        getout.setBorderPainted(false);
        getout.setOpaque(false);
        getout.setPreferredSize(new Dimension(150,30));
        getout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        opcenter.add(getout);
        
        opcenter.setPreferredSize(new Dimension(0,50));
        center.add(opcenter,BorderLayout.SOUTH);
        left.setPreferredSize(new Dimension(200,200));
        principal.add(center,BorderLayout.CENTER);
    }
    private void starwindow(){
       
        this.screenshotscreen();
        setLocationRelativeTo(null);
//        setLayout(new BorderLayout());
        princ = new Panel();
      
        
        princ.setLayout(new BorderLayout(0,0));
        
        this.header(princ);
        this.footer(princ);
        this.menuside(princ);
        this.center(princ);

        add(princ,BorderLayout.CENTER);
                
    }
    private void optioneofmenu(){
        treeprinc = new DefaultMutableTreeNode("BarberQ");
        
        nodo1 = new DefaultMutableTreeNode("Files");
       
        
        nodo1.add(new DefaultMutableTreeNode("Person"));
        nodo1.add(new DefaultMutableTreeNode("Employee"));
        nodo1.add(new DefaultMutableTreeNode("Work position"));
        nodo1.add(new DefaultMutableTreeNode("Job title"));
        nodo1.add(new DefaultMutableTreeNode("Service"));
        nodo1.add(new DefaultMutableTreeNode("Haircut type"));
        nodo1.add(new DefaultMutableTreeNode("Client"));
        treeprinc.add(nodo1);
        
        nodo2 = new DefaultMutableTreeNode("Process");
        nodo2.add(new DefaultMutableTreeNode("Meeting"));
        treeprinc.add(nodo2);
        
        nodo3 = new DefaultMutableTreeNode("Report");
        nodo3.add(new DefaultMutableTreeNode("Customers served"));
        nodo3.add(new DefaultMutableTreeNode("Income"));
        treeprinc.add(nodo3);
        
        DefaultMutableTreeNode nodo4 = new DefaultMutableTreeNode("Administratión");
        nodo4.add(new DefaultMutableTreeNode("Users"));
        treeprinc.add(nodo4);
        
        menu.setModel(new DefaultTreeModel(treeprinc));
        menu.setRootVisible(false);
        contenmenu.setViewportView(menu);
        contenmenu.setBackground(new Color(Color.OPAQUE));
        left.add(contenmenu,"MenuPrincipal");
        
    }
    private void screenshotscreen(){
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = screenSize.width;
    int height = screenSize.height;
    this.setMinimumSize(new Dimension(width - 300, height - 300));
    this.setMaximumSize(new Dimension(width, height));
}
    private Panel princ,header,center;
    private JPanel footer,left;
    private JScrollPane contenmenu;
    private JTree menu;
    private DefaultMutableTreeNode  treeprinc, nodo1,nodo2, nodo3;

    public JLabel getUser() {
        return user;
    }

    public void setUser(JLabel user) {
        this.user = user;
    }

    public JLabel getDni() {
        return dni;
    }

    public void setDni(JLabel dni) {
        this.dni = dni;
    }

    public JLabel getCarg() {
        return carg;
    }

    public void setCarg(JLabel carg) {
        this.carg = carg;
    }

    public JLabel getDate() {
        return date;
    }

    public void setDate(JLabel date) {
        this.date = date;
    }

    public JLabel getTime() {
        return time;
    }

    public void setTime(JLabel time) {
        this.time = time;
    }
    
  
    
    
    
}
