/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Vuser;
import View.Vemployee;
import View.Vservice;
import View.Vjobtitle;
import View.Vworkposition;
import View.Customers;
import View.Vmeeting;
import View.Vhaircut;
import View.Income;
import View.Begin;
import View.Vperson;
import View.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

/**
 *
 * @author Jnatn'h
 */
public class ControllerPrincipal implements ActionListener, TreeExpansionListener,TreeSelectionListener{
    
    public Principal vista;
    private Vuser users;
    private Vperson person;
    private Vjobtitle jobtitle;
    private Vworkposition vwork;
    private Vemployee employee;
    private Vservice service;
    private Vhaircut haircut;
    private Vmeeting meeting;
    private Customers customers;
    private Income income;
    public ControllerPrincipal(Principal vist){
        vista = vist;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evento = ae.getSource();
        if (evento.equals(vista.getGetout())) {
          String pregunta = "You want to leave BarberQ?";
          int salir  = JOptionPane.showConfirmDialog(vista, pregunta, "Get out", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(salir == 0){
                System.exit(0);
            }else{
            
            }
         
        }else if(evento.equals(vista.getClose())){
            vista.dispose();
            Begin logi  = new Begin();
            logi.setVisible(true);            
        }
    }
    public Principal getVista(){
      return vista;
    }
    public void setObject(){
       
        
        
        
        
        
         
         
    }
    @Override
    public void valueChanged(TreeSelectionEvent tse) {
          
       String select = vista.getMenu().getLastSelectedPathComponent().toString();
       
        if(select.equalsIgnoreCase("Users")){
            
            users = new Vuser(vista,true);
            
            users.setVisible(true);
           
            
        }else if(select.equalsIgnoreCase("Person")){
            person = new Vperson(vista,true);
            ImageIcon iconp = new ImageIcon(getClass().getResource("/View/img/Vperson.jpg"));
            person.setController(new ControllerPerson(person));
             
            person.getHeader().setIcon(iconp);
            person.setVisible(true);
             
        }else if(select.equalsIgnoreCase("Work Position")){
            vwork = new Vworkposition(vista,true);
            vwork.setController(new ControllerWorkPosition(vwork));
            vwork.setVisible(true);
            
        }else if(select.equalsIgnoreCase("Job Title")){
          jobtitle = new Vjobtitle(vista,true);
            jobtitle.setController(new ControllerJobTitle(jobtitle));
            jobtitle.setVisible(true);
            
        }else if(select.equalsIgnoreCase("employee")){
            employee = new Vemployee(vista,true);
            employee.setController(new ControllerEmployee(employee));
            employee.setVisible(true);
        }else if(select.equalsIgnoreCase("Service")){
             service = new Vservice(vista,true);
           service.setController(new ControllerService(service));
            service.setVisible(true);
        }else if(select.equalsIgnoreCase("Haircut type")){
             haircut = new Vhaircut(vista,true);
            haircut.setController(new ControllerHaircut(haircut));
            haircut.setVisible(true);
        }else if(select.equalsIgnoreCase("Client")){
            person = new Vperson(vista,true);
            ImageIcon iconp = new ImageIcon(getClass().getResource("/View/img/header/Client.png"));
            person.getHeader().setIcon(iconp);
            person.setController(new ControllerClient(person));
            
            person.setVisible(true);
        }else if(select.equalsIgnoreCase("Meeting")){
            meeting = new Vmeeting(vista,true);
            meeting.setVisible(true);
        }else if(select.equalsIgnoreCase("Customers Served")){
           customers = new Customers(vista,false);
           customers.setVisible(true);
        }else if(select.equalsIgnoreCase("Income")){
           income = new Income(vista,false);
           income.setVisible(true);
        }
    }
    @Override
    public void treeExpanded(TreeExpansionEvent tee) {
       
    }

    @Override
    public void treeCollapsed(TreeExpansionEvent tee) {
       
    }
 
    
}
