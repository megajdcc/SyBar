/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import org.edisoncor.gui.panel.Panel;
import Controller.*;
/**
 *
 * @author Jnatn'h
 */
public class Begin extends JFrame{
    
    // Fiels of class ... 
    private javax.swing.JButton getin, getout;
    private JTextField username;
    private JPasswordField password;
    private org.edisoncor.gui.panel.Panel heade;
    private JLabel leyend;
    private ControllerLogin controller;
    private void setController(ControllerLogin controller){
        this.controller = controller;
        this.setListener();
     }
    public ControllerLogin getController(){
        return controller;
    }
    private void setListener(){
        username.addKeyListener(controller);
        username.addFocusListener(controller);
        
        password.addKeyListener(controller);
        password.addFocusListener(controller);
        
        getin.addActionListener(controller);
        getout.addActionListener(controller);
    }
    public JButton getGetin() {
        return getin;
    }

    public void setGetin(JButton getin) {
        this.getin = getin;
    }

    public JButton getGetout() {
        return getout;
    }

    public void setGetout(JButton getout) {
        this.getout = getout;
    }

    public JTextField getUsername() {
        return username;
    }

    public void setUsername(JTextField username) {
        this.username = username;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public void setPassword(JPasswordField password) {
        this.password = password;
    }

    public JLabel getLeyend() {
        return leyend;
    }

    public void setLeyend(JLabel leyend) {
        this.leyend = leyend;
    }
       
    //Construct of Class... 
    
    public Begin(){
        
        setSize(350,400);
        setUndecorated(true);
        
        setDefaultLookAndFeelDecorated(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setForeground(Color.BLACK);
        
        Shape form = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,50,50);
        
        this.setShape(form);
        setLayout(new BorderLayout());
        this.assignHeader();
        this.assignCenter();
        this.assignFooter();
        this.setController(new ControllerLogin(this));
        setVisible(true);
      
    }
 
    private void assignHeader(){
        JPanel header = new JPanel();
        header.setSize(this.getBounds().width,this.getBounds().height);
        header.setBackground(Color.BLACK);
        JLabel title = new JLabel("Login");
        title.setForeground(Color.white);
        title.setFont(new Font(Font.SERIF,Font.BOLD,24));
        header.add(title);
        this.add(header,BorderLayout.NORTH);
    }
    private void addLogo(JPanel center){
        JPanel logo = new JPanel();
        logo.setPreferredSize(new Dimension(200,80));
        FlowLayout fl = new FlowLayout();
        fl.setAlignOnBaseline(true);
        fl.setAlignment(FlowLayout.CENTER);
        logo.setLayout(fl);
        heade = new Panel();
        heade.setPreferredSize(new Dimension(200,80));
        ImageIcon icon = new ImageIcon(getClass().getResource("/View/img/Logo1.png"));   
        heade.setIcon(icon);
        logo.add(heade);
        center.add(logo,BorderLayout.NORTH);
    }
    private void addOptione(JPanel pane){
        JPanel us = new JPanel();
        us.setPreferredSize(new Dimension(300,60));
        us.setLayout(new GridLayout(2,1));
        
        JLabel usname = new JLabel("User Name");
        us.add(usname);
        
        Panel inus = new Panel();
        inus.setLayout(new BorderLayout(0,0));
        JPanel fond1 = new JPanel();
        fond1.setBackground(Color.WHITE);
        Panel iconus = new Panel();
        iconus.setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon(getClass().getResource("/View/img/Username.png"));

        
        iconus.setPreferredSize(new Dimension(50,40));
        iconus.setMaximumSize(new Dimension(50,40));
        iconus.setIcon(icon);
        fond1.add(iconus);
        inus.add(fond1,BorderLayout.WEST);
        inus.setBackground(new Color(484848));
        username = new JTextField();
        username.setPreferredSize(new Dimension(250,40));
        username.setForeground(Color.BLACK);
        inus.add(username,BorderLayout.EAST);
        
        us.add(inus);
        
        JPanel pass = new JPanel();
        pass.setPreferredSize(new Dimension(300,60));
        pass.setLayout(new GridLayout(2,1));
        JLabel uspass = new JLabel("Password");
        pass.add(uspass);
        Panel inpass = new Panel();
        inpass.setLayout(new BorderLayout(0,0));
        JPanel fond = new JPanel();
        fond.setBackground(Color.WHITE);
        fond.setPreferredSize(new Dimension(50,40));
        fond.setMaximumSize(new Dimension(50,40));
        Panel iconpass = new Panel();
        ImageIcon iconp = new ImageIcon(getClass().getResource("/View/img/Password.png"));
        iconpass.setPreferredSize(new Dimension(50,40));
        iconpass.setMaximumSize(new Dimension(50,40));
        iconpass.setIcon(iconp);
        
        fond.add(iconpass);
        inpass.add(fond,BorderLayout.WEST);
        inpass.setBackground(new Color(484848));
        password = new JPasswordField();
        password.setPreferredSize(new Dimension(250,40));
        password.setForeground(Color.BLACK);
        inpass.add(password,BorderLayout.EAST);
       
        pass.add(inpass);
       
        pane.add(us);
        pane.add(pass);
        
       leyend = new JLabel();
       leyend.setSize(new Dimension(250,40));
       leyend.setForeground(Color.BLACK);
       leyend.setFont(new Font(Font.SERIF,Font.ITALIC,12));
       
       pane.add(leyend);
    }
    private void addContent(JPanel center){
        Color colo = new Color(484848);
        
        JPanel centr = new JPanel();
        centr.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        this.addOptione(centr);
        
        center.add(centr,BorderLayout.CENTER);
    }
    private void addBtn(JPanel center){
        JPanel btns = new JPanel();
        btns.setLayout(new FlowLayout(FlowLayout.CENTER));
       
        
        this.getin = new JButton("Sign in");
       
        getin.setFont(new Font(Font.SERIF,Font.BOLD,20));
        getin.setBackground(Color.BLACK);
        getin.setForeground(Color.WHITE);
        getin.setPreferredSize(new Dimension(150,40));
        getin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getin.setBorderPainted(false);
        getin.setFocusPainted(false);
       
        
        
        Graphics g2 = getin.getGraphics();
        
        RoundRectangle2D.Double form = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,100,100);
      
//        g2.drawRoundRect(0,0,getin.getBounds().width,getin.getBounds().height,100,100);
   //     getin.paintComponents(g2);
        
        btns.add(getin);
        
        getout = new JButton("Exit");
        getout.setFont(new Font(Font.SERIF,Font.BOLD,20));
        getout.setBackground(Color.BLACK);
        getout.setPreferredSize(new Dimension(150,40));
        getout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getout.setBorderPainted(false);
        getout.setFocusPainted(false);
        btns.add(getout);
        center.add(btns,BorderLayout.SOUTH);
    }
    private void assignCenter(){
        JPanel center = new JPanel();
        BorderLayout Bl = new BorderLayout(2,2);
        center.setLayout(Bl);
        this.addLogo(center);
        this.addContent(center);
        this.addBtn(center);
        this.add(center,BorderLayout.CENTER);
    }    
    private void assignFooter(){
        JPanel footer = new JPanel();
      
        
        JLabel cop = new JLabel("Copryright 2018 BarberQ");
        
        cop.setForeground(Color.BLACK);
        cop.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,15));
        footer.add(cop);
        
        this.add(footer,BorderLayout.SOUTH);
    }
    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Begin ini  = new Begin();
            ini.setVisible(true);
        });
    }
}
