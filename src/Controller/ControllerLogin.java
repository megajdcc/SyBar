/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Begin;
import View.Principal;
import Model.User;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;
/**
 *
 * @author Jnatn'h
 */
public class ControllerLogin implements ActionListener, KeyListener, FocusListener{
    
    public Begin view;
    private Principal principal;
    private final User mu;
    public ControllerLogin(Begin view){
        this.view = view;
       
        mu = new User();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
    Object origin = ae.getSource();
        if(origin.equals(view.getGetin())){
            view.setCursor(new Cursor(Cursor.WAIT_CURSOR));
             boolean validated = this.validate();
             if(validated){
                 principal = new Principal();
                 this.checkstart();
             }
        }else if (origin.equals(view.getGetout())){
            System.exit(0);
        }
    }
    public boolean validate(){
        boolean validated = false;
     
        if(view.getUsername().getText().length() == 0){
              
              view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
              view.getLeyend().setText(null);
                JOptionPane.showMessageDialog(new JFrame(), "You must fill in the user field", "warning",JOptionPane.WARNING_MESSAGE);
            }else if(view.getPassword().getPassword().length == 0)
            {
         
                view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                 view.getLeyend().setText(null);
                JOptionPane.showMessageDialog(new JFrame(), "You must fill in the password field", "warning",JOptionPane.WARNING_MESSAGE);
            }else{
                validated = true;
            }
        return validated;
    }
    public void checkstart(){
            char contra[] = view.getPassword().getPassword();
            String password = "";
            for(int i = 0; i<contra.length; i++){
              password += ""+contra[i];
            }
           password = DigestUtils.sha1Hex(password);
            String usuario = view.getUsername().getText();
            mu.setUser(usuario);
            mu.setPassword(password);
          
            boolean validate = mu.validateuser();  
            view.getLeyend().setText("Succesfully validated"+validate);
            if(validate){ 
                Principal.setIdUser((int) mu.getId());
                Principal.getController().setObject();
                boolean users  = mu.getUser().isEmpty();
                if (users == false){
                    principal.getUser().setText("User: "+mu.getUser());
//                    principal.getDni().setText("Dni: "+String.valueOf(mu.getDni()));
                boolean carg = mu.capturecarg();
                if(carg){
                     principal.getCarg().setText("Job Title: "+mu.getPosition());
                }else{
                      principal.getCarg().setText("Job Title: not definet");
                }
                   
                }else{
                    principal.getUser().setText("Not definet");
                    principal.getDni().setText("not define");
                    principal.getCarg().setText("not define");
                }
                principal.setVisible(true);
                view.dispose();
            }else{
            
                view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                view.getLeyend().setText(null);
                JOptionPane.showMessageDialog(new JFrame(),"Invalid user or password","warning",JOptionPane.INFORMATION_MESSAGE);
            }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
      Object event = ke.getSource();
      if(event.equals(view.getUsername())){
          if(view.getUsername().getText().length()>20){
                ke.consume();
            }
      }else if(event.equals(view.getPassword())){
          if(view.getPassword().getPassword().length>20){
                ke.consume();
            }
      }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
         Object event = ke.getSource();
         if(event.equals(view.getPassword())){
             if (ke.getKeyCode()==KeyEvent.VK_TAB){
            view.getPassword().requestFocus();   
            }
         }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
       
    }

    @Override
    public void focusGained(FocusEvent fe) {
        Object evn = fe.getSource();
        if(evn.equals(view.getUsername())){
            String leyend = "Yout must enter a username";
            view.getLeyend().setText(leyend);
            
        }else if(evn.equals(view.getPassword())){
             String leyend = "You must enter your password ";
               view.getLeyend().setText(leyend);
        }
    }
    @Override
    public void focusLost(FocusEvent fe) {
      
    }

   
    
}
