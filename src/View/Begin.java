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
import org.edisoncor.gui.panel.Panel.Gradiente;

public class Begin extends JFrame{
    
    private javax.swing.JButton sign, exit;
    private JTextField userName;
    private JPasswordField password;
    private org.edisoncor.gui.panel.Panel logoHome;
    private JLabel remark;
    private ControllerLogin controller;
    private void setController(ControllerLogin controller){
        this.controller = controller;
        this.setListener();
     }

    private void setListener(){
        userName.addFocusListener(controller);  
        password.addFocusListener(controller);  
        sign.addActionListener(controller);
        exit.addActionListener(controller);
    }
    public JButton getSign() {
        return sign;
    }

    public void setSign(JButton sign) {
        this.sign = sign;
    }

    public JButton getExit() {
        return exit;
    }

    public void setExit(JButton exit) {
        this.exit = exit;
    }

    public JTextField getUserName() {
        return userName;
    }

    public void setUserName(JTextField userName) {
        this.userName = userName;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public void setPassword(JPasswordField password) {
        this.password = password;
    }

    public JLabel getRemark() {
        return remark;
    }

    public void setRemark(JLabel remark) {
        this.remark = remark;
    }
       
    
    public Begin(){
        
        setSize(350,400);
        setResizable(false);
        setLocationRelativeTo(null);
        this.assignHeader();
        this.assignCenter();
        this.assignFooter();
        this.setController(new ControllerLogin(this));
        setVisible(true);
      
    }
 
    private void assignHeader(){
        JPanel header = new JPanel();
        header.setBackground(Color.BLACK);
        JLabel title = new JLabel("Login");
        title.setForeground(Color.white);
        title.setFont(new Font(Font.SERIF,Font.BOLD,24));
        header.add(title);
        getContentPane().add(header,BorderLayout.NORTH);
    }
    private void addLogo(JPanel center){
        JPanel logo = new JPanel();
        logo.setPreferredSize(new Dimension(200,80));
        FlowLayout fl = new FlowLayout();
        fl.setAlignOnBaseline(true);
        fl.setAlignment(FlowLayout.CENTER);
        logo.setLayout(fl);
        logoHome = new Panel();
        FlowLayout fl_logoHome = (FlowLayout) logoHome.getLayout();
        logoHome.setPreferredSize(new Dimension(200,80));
        ImageIcon icon = new ImageIcon(getClass().getResource("/View/img/Logo1.png"));   
        logoHome.setIcon(icon);
        logo.add(logoHome);
        center.add(logo,BorderLayout.NORTH);
    }
    private void addchoosing(JPanel panel){
        JPanel userPanel = new JPanel();
        userPanel.setPreferredSize(new Dimension(300,60));
        userPanel.setLayout(new GridLayout(2,1));
        
        JLabel user_label = new JLabel("User Name");
        userPanel.add(user_label);
        
        Panel inUser = new Panel();
        inUser.setLayout(new BorderLayout(0,0));
        JPanel iconPanel = new JPanel();
        iconPanel.setBackground(Color.WHITE);
        Panel iconUser = new Panel();
        iconUser.setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon(getClass().getResource("/View/img/Username.png"));

        iconUser.setPreferredSize(new Dimension(40,40));
        iconUser.setMaximumSize(new Dimension(40,40));
        iconUser.setIcon(icon);
        iconPanel.add(iconUser);
        inUser.add(iconPanel,BorderLayout.WEST);
        inUser.setBackground(new Color(484848));
        userName = new JTextField();
        userName.setPreferredSize(new Dimension(250,40));
        userName.setForeground(Color.BLACK);
        inUser.add(userName,BorderLayout.EAST);
        
        userPanel.add(inUser);
        
        JPanel passwordPanel = new JPanel();
        passwordPanel.setPreferredSize(new Dimension(300,60));
        passwordPanel.setLayout(new GridLayout(2,1));
        JLabel passwordLabel = new JLabel("Password");
        passwordPanel.add(passwordLabel);
        Panel inPassword = new Panel();
        inPassword.setLayout(new BorderLayout(0,0));
        JPanel iconPassPanel = new JPanel();
        iconPassPanel.setBackground(Color.WHITE);
        iconPassPanel.setPreferredSize(new Dimension(50,40));
        iconPassPanel.setMaximumSize(new Dimension(50,40));
        Panel iconpass = new Panel();
        ImageIcon iconp = new ImageIcon(getClass().getResource("/View/img/Password.png"));
        iconpass.setPreferredSize(new Dimension(50,40));
        iconpass.setMaximumSize(new Dimension(50,40));
        iconpass.setIcon(iconp);
        
        iconPassPanel.add(iconpass);
        inPassword.add(iconPassPanel,BorderLayout.WEST);
        inPassword.setBackground(new Color(484848));
        password = new JPasswordField();
        password.setPreferredSize(new Dimension(250,40));
        password.setForeground(Color.BLACK);
        inPassword.add(password,BorderLayout.EAST);
       
        passwordPanel.add(inPassword);
       
        panel.add(userPanel);
        panel.add(passwordPanel);
        
       remark = new JLabel();
       remark.setSize(new Dimension(250,40));
       remark.setForeground(Color.BLACK);
       remark.setFont(new Font(Font.SERIF,Font.ITALIC,12));
       
       panel.add(remark);
    }
    private void addContent(JPanel center){
        Color color = new Color(484848);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        this.addchoosing(centerPanel);
        
        center.add(centerPanel,BorderLayout.CENTER);
    }
    private void addBtn(JPanel center){
        JPanel btns = new JPanel();
        btns.setLayout(new FlowLayout(FlowLayout.CENTER));
       
        
        this.sign = new JButton("Sign in");
       
        sign.setFont(new Font(Font.SERIF,Font.BOLD,20));
        sign.setBackground(Color.BLACK);
        sign.setForeground(Color.WHITE);
        sign.setPreferredSize(new Dimension(150,40));
        sign.setBorderPainted(false);
        sign.setFocusPainted(false);
       
        btns.add(sign);
        
        exit = new JButton("Exit");
        exit.setFont(new Font(Font.SERIF,Font.BOLD,20));
        exit.setBackground(Color.BLACK);
        exit.setPreferredSize(new Dimension(150,40));
        exit.setBorderPainted(false);
        exit.setFocusPainted(false);
        btns.add(exit);
        center.add(btns,BorderLayout.SOUTH);
    }
    private void assignCenter(){
        JPanel center = new JPanel();
        BorderLayout Bl = new BorderLayout(2,2);
        center.setLayout(Bl);
        this.addLogo(center);
        this.addContent(center);
        this.addBtn(center);
        getContentPane().add(center,BorderLayout.CENTER);
    }    
    private void assignFooter(){
        JPanel footer = new JPanel();
        JLabel cop = new JLabel("Copryright 2018 BarberQ");
        cop.setForeground(Color.BLACK);
        cop.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,15));
        footer.add(cop);
        
        getContentPane().add(footer,BorderLayout.SOUTH);
    }
    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Begin begin  = new Begin();
            begin.setVisible(true);
        });
    }
}
