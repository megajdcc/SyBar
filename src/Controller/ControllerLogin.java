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

public class ControllerLogin implements ActionListener, KeyListener, FocusListener{
    
    public Begin vBegin;
    private Principal principal;
    private final User user;
    public ControllerLogin(Begin view){
        this.vBegin = view;
       
        user = new User();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
    Object origin = ae.getSource();
        if(origin.equals(vBegin.getSign())){

             boolean validate = this.validate();
             if(validate){
                 principal = new Principal();
                 this.checkStart();
             }
        }else if (origin.equals(vBegin.getExit())){
            System.exit(0);
        }
    }
    public boolean validate(){
        boolean validate = false;
     
        if(vBegin.getUserName().getText().length() == 0){
              
              vBegin.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
              vBegin.getRemark().setText(null);
              JOptionPane.showMessageDialog(new JFrame(), "You must fill in the user field", "warning",JOptionPane.WARNING_MESSAGE);
            }else if(vBegin.getPassword().getPassword().length == 0)
            {
         
                vBegin.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                vBegin.getRemark().setText(null);
                JOptionPane.showMessageDialog(new JFrame(), "You must fill in the password field", "warning",JOptionPane.WARNING_MESSAGE);
            }else{
                validate = true;
            }
        return validate;
    }
    public void checkStart(){
            char copyPass[] = vBegin.getPassword().getPassword();
            String password = "";
            for(int i = 0; i<copyPass.length; i++){
              password += ""+copyPass[i];
            }
           password = DigestUtils.shaHex(password);
           String userName = vBegin.getUserName().getText();
           user.setUser(userName);
           user.setPassword(password);
          
            boolean validate = user.validateUser();  
            vBegin.getRemark().setText("Succesfully validated"+validate);
            if(validate){ 
                Principal.setIdUser((int) user.getId());
                boolean users  = user.getUser().isEmpty();
                if (users == false){
                    principal.getUser().setText("User: "+user.getUser());
                    boolean position = user.capturePosition();
                    
                if(position){
                     principal.getJobTittle().setText("Job Title: "+user.getPosition());
                     
                }else{
                      principal.getJobTittle().setText("Job Title: not define");
                }
                   
                }else{
                    principal.getUser().setText("Not define");
                    principal.getId().setText("not define");
                    principal.getJobTittle().setText("not define");
                }
                principal.setVisible(true);
                vBegin.dispose();
            }else{
            
                vBegin.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                vBegin.getRemark().setText(null);
                JOptionPane.showMessageDialog(new JFrame(),"Invalid user or password","warning",JOptionPane.INFORMATION_MESSAGE);
            }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
      Object event = ke.getSource();
      if(event.equals(vBegin.getUserName())){
          if(vBegin.getUserName().getText().length()>20){
                ke.consume();
            }
      }else if(event.equals(vBegin.getPassword())){
          if(vBegin.getPassword().getPassword().length>20){
                ke.consume();
            }
      }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
         Object event = ke.getSource();
         if(event.equals(vBegin.getPassword())){
             if (ke.getKeyCode()==KeyEvent.VK_TAB){
            vBegin.getPassword().requestFocus();   
            }
         }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
       
    }

    @Override
    public void focusGained(FocusEvent fe) {
        Object event = fe.getSource();
        if(event.equals(vBegin.getUserName())){
            String err = "Yout must enter a username";
            vBegin.getRemark().setText(err);
            
        }else if(event.equals(vBegin.getPassword())){
             String err = "You must enter your password ";
               vBegin.getRemark().setText(err);
        }
    }
    @Override
    public void focusLost(FocusEvent fe) {
      
    }

   
    
}
