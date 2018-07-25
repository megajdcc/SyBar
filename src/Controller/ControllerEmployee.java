/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Vemployee;
import View.Vjobtitle;
import View.Remployee;
import View.Vperson;
import View.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Model.*;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author Jnatn'h
 */
public class ControllerEmployee implements ActionListener, MouseListener, KeyListener{
    
    
    DefaultTableModel dm;
    private Vemployee lemployee;
    private Employee model;
    private Remployee employee;
    private Principal principal;
    private JobTitle modeljob;
    private Vperson person;
    private Vjobtitle job;
    private Person modelperson;
    
    public ControllerEmployee(Vemployee v){
                this.lemployee = v;
                model = new Employee();
                modelperson = new Person();
                modeljob = new JobTitle();
                person = new Vperson(principal,true);
                job = new Vjobtitle(principal,true);
                employee = new Remployee(principal,true);
                
                this.Tolist(1);
    } 
    private void Tolist(int list){
        if(list == 1 ){
            String[][] informacion =  model.consultList();
            lemployee.getCatemployee().setModel(new javax.swing.table.DefaultTableModel(
            informacion,
            new String [] {"Phone","Name","Last Name"}) {
            boolean[] canEdit = new boolean [] {
                false,false,false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
    });
        lemployee.getCatemployee().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }else if(list == 2){
        
        String[][] informacion =  modelperson.consultList();
        person.getCatperson().setModel(new javax.swing.table.DefaultTableModel(
        informacion,
        new String [] {"Dni","Name","Last Name"}) {
        boolean[] canEdit = new boolean [] {
            false,false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    person.getCatperson().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }else{
              String[][] informacion =  modeljob.consultList();
        job.getCatjobtitle().setModel(new javax.swing.table.DefaultTableModel(
        informacion,
        new String [] {"Job Title","Position"}) {
        boolean[] canEdit = new boolean [] {
            false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
        job.getCatjobtitle().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
        
    }
    public void ListadoBusqueda(String consulta, JTable JTableBuscar){
     
        dm = (DefaultTableModel) JTableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr  = new TableRowSorter<>(dm);
        JTableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    public void Capturedata(long phonemployee,String comes){
        
        if(comes.equalsIgnoreCase("Employee")){
           boolean found = model.consultModel(phonemployee);
           if (found){
               lemployee.setVisible(false);
               lemployee.dispose();
               
               employee.getDniperson().setText(String.valueOf(model.getId()));
               employee.getNameperson().setText(model.getName());
               employee.getLastname().setText(model.getLastname());
               employee.getPhone().setText(String.valueOf(model.getPhone()));
               
               char gender = model.getGender();
                if(gender == 'M'){
                    employee.getMale().setSelected(true);
                }else if(gender == 'F'){
                    employee.getFemale().setSelected(true);
                }
               int idjob = model.getIdjob();
               modeljob = new JobTitle();
               String namejob = modeljob.capturarName(idjob);

               employee.getJobtitle().setText(namejob);
               employee.getDelete().setVisible(true);
               employee.getSjob().setEnabled(true);
               employee.getPrint().setVisible(false);
               employee.setController(this);
               
               employee.setVisible(true);
               
               }else{
               
                JOptionPane.showMessageDialog(principal,"Record not found","Employee",JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
//             boolean found = modelperson.consultModel(idemp);
//             if(found){
//                 person.setVisible(false);
//                 person.dispose();
//                 
//                 employee.getDniperson().setText(String.valueOf(modelperson.getId()));
//                 employee.getNameperson().setText(modelperson.getName());
//                 employee.getLastname().setText(modelperson.getLastname());
//             }
        }
           
       }
    public void Capturedata(String name){
     
           boolean found = modeljob.consultModel(name);
           if (found){
                job.dispose();
                job.setVisible(false);
                    
                    employee.getJobtitle().setText(modeljob.getJobName());
                
               }else{
               
                JOptionPane.showMessageDialog(new JFrame(),"Record not found","Employee",JOptionPane.INFORMATION_MESSAGE);
            }
       }
    @Override
    public void actionPerformed(ActionEvent ae) {
            Object evento = ae.getSource();
            
            if(evento.equals(employee.getExit())){
                
                employee.dispose();
                employee.setVisible(false);
                lemployee = new Vemployee(principal,true);
                lemployee.setController(this);
                Tolist(1);
                lemployee.setVisible(true);
            }else if(evento.equals(employee.getDelete())){
                
                this.delete();
            }else if(evento.equals(employee.getGrabar())){
                this.validate();
            }else if(evento.equals(lemployee.getNuevo())){
                lemployee.dispose();
                lemployee.setVisible(false);
                
                employee = new Remployee(principal,true);
                employee.setController(this);
                model.setId(0);
                employee.getPrint().setVisible(false);
                employee.getDelete().setVisible(false);
                
                employee.setVisible(true);
            }else if(evento.equals(employee.getSjob())){
                job.setController(this);
                this.Tolist(3);
                job.getNuevo().setEnabled(false);
                job.setVisible(true);
            }
    }
    private void validate(){
            if(employee.getNameperson().getText().length() < 2){
                    String leyenda = "Verify that the name is not empty and that it contains no less than  2 characters";
                    employee.getLeyenda().setText(leyenda);
                    employee.getLeyenda().setForeground(Color.RED);
            }else if(employee.getLastname().getText().length() < 2){
                    String leyenda = "Verify that the surname is not empty and that it does not contain less than 2 characters";
                    employee.getLeyenda().setText(leyenda);
                    employee.getLeyenda().setForeground(Color.RED);
                    employee.getLastname().setFocusable(true);
            }else if(!employee.getGender().isSelected(employee.getMale().getModel()) && !employee.getGender().isSelected(employee.getFemale().getModel())){
                String leyenda = "You must select a gender";
                employee.getLeyenda().setText(leyenda);
                employee.getMale().setFocusable(true);
            }else if(employee.getPhone().getText().trim().length() < 7){
                    String leyenda = "Verify the phone number";
                    employee.getLeyenda().setText(leyenda);
                    employee.getLeyenda().setForeground(Color.RED);
                   
            }else if(employee.getJobtitle().getText().isEmpty()){
                String leyend = "Must select a profession to the employee";
                employee.getLeyenda().setText(leyend);
            }else{
                record();
            }
    }
    private void record(){
           long dn = model.getId();
          
            if(dn > 0){
//              model.setIdentification(Long.parseLong(employee.getIndemployee().getText()));
                model.setName(employee.getNameperson().getText());
                model.setLastname(employee.getLastname().getText());
                model.setPhone(Long.parseLong(employee.getPhone().getText()));
                char gend =this.capturegender(employee.getGender()).charAt(0);
                System.out.println(gend);
                model.setGender(gend);
               int idjob = modeljob.capturarId(employee.getJobtitle().getText());
               model.setIdjob(idjob);
               boolean resultt = model.updateEmployee();
               if(resultt){
                   String leyend = "The employee has been successfully modified "+model.getName()+" "+model.getLastname();
                   employee.getLeyenda().setText(leyend);
               }
           }else if(model.getId() < 1){
               if(model.verify(Long.parseLong(employee.getPhone().getText()))){
                String leyend = "Can not register an employee who is already employed";
                employee.getLeyenda().setText(leyend); 
            }else{
                    model.setName(employee.getNameperson().getText());
                    model.setLastname(employee.getLastname().getText());
                    model.setPhone(Long.parseLong(employee.getPhone().getText()));
                    char gend =this.capturegender(employee.getGender()).charAt(0);
                   
                    model.setGender(gend);
                    int idjob = modeljob.capturarId(employee.getJobtitle().getText());

                    model.setIdjob(idjob);

                    boolean resultado = model.insertEmployee();
                    if(resultado){
                        String leyend = "The employee has been successfully  registered "+model.getName()+" "+model.getLastname();
                        employee.getLeyenda().setText(leyend);
                    }  
               }
               
           }else{
                String leyend = "The employee has not been successfully registered";
                employee.getLeyenda().setText(leyend);
           } 
        
           
    }
    private String capturegender(ButtonGroup butn ){
         String sexo = null;
         
          for (Enumeration<AbstractButton > buttons = butn.getElements(); buttons.hasMoreElements();)
            {
                   AbstractButton button = buttons.nextElement();
                  if(button.isSelected())
                    {
                       sexo = button.getText();

                   }
             } 
          return sexo;
     }
    private void delete(){
        boolean result = model.delete();
        if(result){
             employee.setVisible(false);
             employee.dispose();
             lemployee = new Vemployee(principal,true);
             Tolist(1);
             lemployee.setController(this);
             lemployee.setVisible(true);
             
        }else{
            String leyend = "The employee could not be deleted ";
            employee.getLeyenda().setText(leyend);
        }
    }
    @Override
    public void mouseClicked(MouseEvent me) {
         Object Mevent = me.getSource();
        if(Mevent.equals(lemployee.getCatemployee())){
            if (me.getClickCount() == 2) {
            try{
                int fila = lemployee.getCatemployee().getSelectedRow();
                int fila1 = lemployee.getCatemployee().convertRowIndexToModel(fila);
                DefaultTableModel modelotabla=(DefaultTableModel) lemployee.getCatemployee().getModel();
                long captura = Long.parseLong((String) modelotabla.getValueAt(fila1, 0));
                Capturedata(captura,"employee");
            }catch(HeadlessException ex){
                System.out.println("Error: "+ex);
            }
            }
        }else if(Mevent.equals(person.getCatperson())){
            if (me.getClickCount() == 2) {
            try{
                int fila = person.getCatperson().getSelectedRow();
                int fila1 = person.getCatperson().convertRowIndexToModel(fila);
                DefaultTableModel modelotabla=(DefaultTableModel) person.getCatperson().getModel();
                Long captura = Long.parseLong((String)modelotabla.getValueAt(fila1, 0));
                Capturedata(captura,"person");
            }catch(HeadlessException ex){
                System.out.println("Error: "+ex);
            }
            }
        }else if(Mevent.equals(job.getCatjobtitle())){
               if (me.getClickCount() == 2) {
            try{
                int fila = job.getCatjobtitle().getSelectedRow();
                int fila1 = job.getCatjobtitle().convertRowIndexToModel(fila);
                DefaultTableModel modelotabla=(DefaultTableModel) job.getCatjobtitle().getModel();
                String captura = (String) modelotabla.getValueAt(fila1, 0);
                Capturedata(captura);
            }catch(HeadlessException ex){
                System.out.println("Error: "+ex);
            }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
       
    }

    @Override
    public void mouseReleased(MouseEvent me) {
      
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       
    }

    @Override
    public void mouseExited(MouseEvent me) {
     
    }

    @Override
    public void keyTyped(KeyEvent ke) {
          Object kevent = ke.getSource();
          if(kevent.equals(lemployee.getTextbusqueda())){
              if(lemployee.getTextbusqueda().getText().length()>50){
                ke.consume();
            }
          }
        }
    
    @Override
    public void keyPressed(KeyEvent ke) {
       
    }

    @Override
    public void keyReleased(KeyEvent ke) {
         Object origin = ke.getSource();
        if(origin.equals(lemployee.getTextbusqueda())){
            String busqueda = lemployee.getTextbusqueda().getText();
            ListadoBusqueda(busqueda,lemployee.getCatemployee());
        }else if(origin.equals(person.getTextsearch())){
            String busqueda = person.getTextsearch().getText();
            ListadoBusqueda(busqueda,person.getCatperson());
        }else if(origin.equals(job.getTextbusqueda())){
            String busqueda = job.getTextbusqueda().getText();
            ListadoBusqueda(busqueda,job.getCatjobtitle());
        }
    }
    
}
