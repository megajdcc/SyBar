/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import View.completedMeeting;
import View.Vemployee;
import View.Vhaircut;
import View.Vmeeting;
import View.Rclient;
import View.Principal;
import View.Vperson;
import View.Rmeeting;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import Model.*;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

public class ControllerMeeting implements ActionListener,MouseListener,KeyListener,ChangeListener,ListSelectionListener{
    
    DefaultTableModel dm;
    private final Meeting model;
    private final Client modelclient;
    private Employee modelemployee;
    private Cut modelhaircut;
    private Vmeeting list;
    private Rmeeting meeting;
    private Vperson client;
    private Vemployee employee;
    private Reports report;
    private Vhaircut haircut;
    private Principal principal;
    private completedMeeting completed;
    private Service modelservices;
    private double pricehaircut, pricetotal;
    private Array priceservice;
    
    public ControllerMeeting(Vmeeting list){
        this.list = list;
        model = new Meeting();
        modelemployee = new Employee();
        modelclient = new Client();
        modelhaircut = new Cut();
        report = new Reports();
        modelservices = new Service();
        haircut = new Vhaircut(principal,true);
        employee = new Vemployee(principal,true);
        meeting = new Rmeeting(principal,true);
        client = new Vperson(principal,true);
        completed = new completedMeeting(principal,true);
        Tolist();
    }
    
    private void Tolist(){
        String[][] information =  model.consultList();
        list.gettableMeeting().setModel(new javax.swing.table.DefaultTableModel(
        information,
        new String [] {"Phone","Name","Last Name","Date","Time"}) {
        boolean[] canEdit = new boolean [] {
            false,false,false,false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    list.gettableMeeting().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    public void SearchList(String consulta, JTable JTableBuscar){
     
        dm = (DefaultTableModel) JTableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr  = new TableRowSorter<>(dm);
        JTableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    public void Capturedata(long dni,int opc){
     
        if(opc ==1){
           boolean found = model.consultModel(dni);
           if (found){
                list.dispose();
                list.setVisible(false);
                
                boolean encclient = modelclient.captureClient(model.getClient());
                if(encclient){
                    
                    meeting.getDniclient().setText(String.valueOf(modelclient.getPhone()));
                    meeting.getNameclient().setText(modelclient.getName());
                    meeting.getLastnameclient().setText(modelclient.getLastname());
                }
                meeting.getDateclient().setDate(java.sql.Date.valueOf(model.getDate()));
                meeting.getTime().setTime(model.getHour());
                
                boolean enhaircut = modelhaircut.matchingIdModel(model.getHaircut());
                boolean enemployee = modelemployee.consultModel(model.getEmployee(),"meeting");
                if(enhaircut && enemployee){
                    meeting.getHaircut().setText(modelhaircut.getStyle());
                    meeting.getEmployee().setText(modelemployee.getName());
                }
                TolistServices();
                ArrayList listt = model.MeeServ();
      
                for (int i = 0; i < listt.size(); i++) {
                    meeting.getServices().setSelectedValue(listt.get(i), true);
                    this.moveselection(meeting.getServices(), meeting.getSelectservi());
               }
                
                meeting.setController(this);
                meeting.getUpdate().setVisible(true);
                meeting.getSclient().setEnabled(false);
                meeting.getSemployee().setEnabled(true);
                meeting.getShaircut().setEnabled(true);
                meeting.getDer().setEnabled(true);
                meeting.getIzq().setEnabled(true);

                
              
                //TolistServices();
                meeting.setVisible(true);
               }else{
               
                JOptionPane.showMessageDialog(new JFrame(),"Record not found","Meeting",JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(opc == 2){
            boolean found = modelclient.matchingModel(dni);
           if (found){
                client.dispose();
                client.setVisible(false);
                meeting.getDniclient().setText(String.valueOf(modelclient.getPhone()));
                meeting.getNameclient().setText(modelclient.getName());
                meeting.getLastnameclient().setText(modelclient.getLastname());
               
               }else{
               
                JOptionPane.showMessageDialog(new JFrame(),"Record not found","Meeting",JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(opc == 3){
           employee.dispose();
          
           boolean capt = modelemployee.captureemployee(dni);
           if(capt){
            
              Time entrytime = Time.valueOf(modelemployee.getEntrytime());
              Time departuretime = Time.valueOf(modelemployee.getDeparture());
              
              Time selectime = Time.valueOf(meeting.getTime().getTimeField().getText());
              Calendar entry = new GregorianCalendar();
              entry.setTimeInMillis(entrytime.getTime());
              
              Calendar depart = new GregorianCalendar();
              depart.setTimeInMillis(departuretime.getTime());
              
              Calendar seletime = new GregorianCalendar();
              seletime.setTimeInMillis(selectime.getTime());
              
              
              if(seletime.before(entry) || seletime.after(depart)){
                  
                  String leyn = "No puedes seleccionar una hora fuera del tiempo de trabajo del empleado elegido";
                  meeting.getLeyenda().setText(leyn);
                  JOptionPane.showMessageDialog(new Frame(),leyn);
                  meeting.getLeyenda().setForeground(Color.red);
                  meeting.getGrabar().setEnabled(false);
              }else{
                 boolean verfi = checkcol(Time.valueOf(meeting.getTime().getFormatedTime()),meeting.getDateclient().getCalendar());
                  if(verfi){
                        meeting.getEmployee().setText(modelemployee.getName());
                        meeting.getLeyenda().setForeground(Color.black);
                        meeting.getGrabar().setEnabled(true);
                        availab = false;
                  }else{
                       System.out.println("Empleado no disponible en la hora seleccionada... ");
                  }
                 
              }
           }
           employee.setVisible(false);
           TolistServices();
            
           meeting.getDer().setEnabled(true);
           meeting.getIzq().setEnabled(true);
        }
           
       }
    private boolean checkcol(Time hour, Calendar date){
        boolean verfi = false;
        Check ver = new Check(hour,date);
        verfi = this.availab;
        return verfi;
    }
    private void TolistServices(){
        JList list  = meeting.getServices();
        modelservices.listServices(list);
    }
    private void Capturedata(String style){
         boolean found = modelhaircut.matchingModel(style);
           if (found){
               haircut.dispose();
               haircut.setVisible(false);
               
               meeting.getHaircut().setText(modelhaircut.getStyle());
               pricehaircut = modelhaircut.capturePrice();
//               meeting.getDiscount().setEnabled(true);
               this.pricetotal();
               }else{
               
                JOptionPane.showMessageDialog(principal,"Record not found","Meeting",JOptionPane.INFORMATION_MESSAGE);
            }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Object event = ae.getSource();
        if(event.equals(list.getNewBtt())){
            list.dispose();
            list.setVisible(false);
            
            meeting.setController(this);
            meeting.getUpdate().setVisible(false);
            meeting.getDelete().setVisible(false);
            
            meeting.getSemployee().setEnabled(true);
            meeting.getShaircut().setEnabled(true);
            
            meeting.getDer().setEnabled(false);
            meeting.getIzq().setEnabled(false);
            
            
//            meeting.getDiscount().setEnabled(false);
            
            meeting.setVisible(true);
        }else if(event.equals(meeting.getExit())){
            
            meeting.dispose();
            meeting.setVisible(false);
            
            list = new Vmeeting(principal,true);
            list.setVisible(true);
        }else if(event.equals(meeting.getSclient())){
            
            client.setController(this);
            TolistClient();
            client.setVisible(true);
        }else if(event.equals(client.getNewPerson())){
            
            Rclient personclient = new Rclient(principal,true);
            personclient.setControllerClient(new ControllerClient(personclient,client));
       
            personclient.getDelete().setVisible(false);
            personclient.setVisible(true);
            TolistClient();
        }else if(event.equals(meeting.getGrabar())){
            this.record();
        }else if(event.equals(meeting.getUpdate())){
            this.update();
        }else if(event.equals(meeting.getSemployee())){
            employee.setController(this);
            employee.getNewBtt().setEnabled(false);
            Calendar fech1 = meeting.getDateclient().getCalendar();
            String day = fech1.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
            TolistEmployee(day);
            employee.setVisible(true);
        }else if(event.equals(meeting.getShaircut())){
            
            haircut.setController(this);
            haircut.getNewBtt().setEnabled(false);
            TolistHaircut();
            haircut.setVisible(true);
        }else if(event.equals(meeting.getDer())){
            moveselection(meeting.getServices(), meeting.getSelectservi());
              ListModel<String> modelselect = (ListModel<String>)meeting.getSelectservi().getModel();
            try {
                modelservices.chackPrice(modelselect);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMeeting.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.pricetotal();
        }else if(event.equals(meeting.getIzq())){
            moveselection(meeting.getSelectservi(), meeting.getServices());
            ListModel<String> modelselect = (ListModel<String>)meeting.getSelectservi().getModel();
            try {
                modelservices.chackPrice(modelselect);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMeeting.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.pricetotal();
        }else if(event.equals(meeting.getDelete())){
            this.delete();
        }else if(event.equals(completed.getProcess())){
            this.completed();
        }
    }
    public void reloademployee(){
        if(!meeting.getEmployee().getText().isEmpty()){
                Calendar fech1 = meeting.getDateclient().getCalendar();
                String day = fech1.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
                TolistEmployee(day);
                meeting.getEmployee().setText("");
            }
    }
    private void completed(){
        model.setDiscount(completed.getDiscount().getValue());
        model.setTotalprice(Double.parseDouble(completed.getLtotal().getText()));
         boolean complete = false;
         try {
            complete = model.completedMeeting();
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
        
        if(complete){
            String leyend = "Succesfully processed the appoinment.\n do you want to print invoice?";
                                   
                int opcimp = JOptionPane.showConfirmDialog(principal, leyend, "Invoice",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(opcimp == 0){
                       report.invoiceMeeting(model.getId(),true);
                        
                       this.completed.dispose();
                           this.completed.setVisible(false);
                           meeting.dispose();
                           meeting.setVisible(false);
                           
                            list = new Vmeeting(principal,true);
                            list.setVisible(true);
                       }else{
                            
                           this.completed.dispose();
                           this.completed.setVisible(false);
                           meeting.dispose();
                           meeting.setVisible(false);
                           
                            list = new Vmeeting(principal,true);
                            list.setVisible(true);
                       }
        }
    }
    private void update(){
        if(model.getId()>0){
               boolean valide = validecompleted();

               if(valide){
                   Date fech = meeting.getDateclient().getDate();
                     
                    SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
                    model.setHour(Time.valueOf(meeting.getTime().getTimeField().getText()));  
                    String fomr = fecha.format(fech);
                    model.setDate(fomr);
                   
                   model.setEmployee(modelemployee.getIdemployee());
                   model.setUser(Principal.getIduser());
                   model.setCompletedwork(0);
                   model.setHaircut(modelhaircut.getId());
//                   model.setTotalprice(Double.parseDouble(meeting.getLtotal().getText()));
//                   model.setDiscount(meeting.getDiscount().getValue());
                   
                   ListModel<String> listser =  meeting.getSelectservi().getModel();
                   ArrayList<String> milist = new ArrayList();
                    for (int i = 0; i < listser.getSize(); i++) {
                       milist.add(listser.getElementAt(i));
                   }
                    model.setMeetserv(milist);
                   boolean register = false;
                   try {
                       register = model.updateMeeting();
                   } catch (SQLException ex) {
                       Logger.getLogger(ControllerMeeting.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   if(register){
                       String leyend = "Succesfully update the appointment";
                       meeting.getLeyenda().setText(leyend);

                   }else{
                        String leyend = "Sorry there was an error while registering.";
                        meeting.getLeyenda().setText(leyend);
                   }
               }else if(!valide){
                    Date fech = meeting.getDateclient().getDate();
                    SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String fomr = fecha.format(fech);
                    model.setDate(fomr);
                    
                    boolean updatopc = model.updateopc();
                    if(updatopc){
                        String leyend = "The date of the appointment has been successfully ypdated!";
                        meeting.getLeyenda().setText(leyend);
                    }else{
                        String leyend = "Sorry there was an error while updating.";
                        meeting.getLeyenda().setText(leyend);
                    }
               }else{
                   String leyend = "Sorry it could not be processed.";
                   meeting.getLeyenda().setText(leyend);
               }
           }
    }
    private void delete(){ 
        int opcdelete = JOptionPane.showConfirmDialog(principal,"Do you really want to cancel this appointment","Delete Meeting", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(opcdelete < 1 ){
            boolean result = model.delete();
            if(result){
                JOptionPane.showMessageDialog(principal, "You have successfully deleted the appointment!");
                meeting.dispose();
                meeting.setVisible(false);
                Tolist();
                list.setControllerMeeting(this);
                list.setVisible(true);   
            }
        }
    }
    private void pricetotal(){
        ArrayList<Double> priceservic = modelservices.getPrices();
        double sumaprice = 0;
        double pricehaircut = modelhaircut.getPrice();
        if(priceservic == null){
            pricetotal = pricehaircut;
//            meeting.getLtotal().setText(String.valueOf(pricetotal));
        }else{
            Object priceser[] = priceservic.toArray();
            for (int i = 0; i < priceser.length; i++) {
                sumaprice = sumaprice + (Double)priceser[i];
            } 
            this.pricetotal = sumaprice + pricehaircut;
//            meeting.getLtotal().setText(String.valueOf(this.pricetotal));
        }  
    }
    private void TolistHaircut(){
        String[][] information =  modelhaircut.cutList();
        haircut.getTableHairCut().setModel(new javax.swing.table.DefaultTableModel(
        information,
        new String [] {"Style","Price","Gender"}) {
        boolean[] canEdit = new boolean [] {
            false,false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    haircut.getTableHairCut().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    private void TolistEmployee(String nameday){
        String[][] information =  modelemployee.resultList(nameday);
            employee.getEmployeeTable().setModel(new javax.swing.table.DefaultTableModel(
            information,
            new String [] {"Phone","Name","Last Name"}) {
            boolean[] canEdit = new boolean [] {
                false,false,false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
    });
        employee.getEmployeeTable().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    private void record(){
       
           if(model.getId() < 1 ){
                boolean result = validarRegisternew();
                if(result){
                        Date fech = meeting.getDateclient().getDate();
                     
                    SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
                    Time hour = Time.valueOf(meeting.getTime().getTimeField().getText());
                    
                    String fomr = fecha.format(fech);
                    model.setDate(fomr);
                    model.setHour(hour);
                    model.setUser(Principal.getIdUser());
                    model.setCompletedwork(0);
                   model.setHaircut(modelhaircut.getId());
//                   model.setTotalprice(Double.parseDouble(meeting.getLtotal().getText()));
//                   model.setDiscount(meeting.getDiscount().getValue());
                   model.setClient(modelclient.getId());
                   model.setEmployee(modelemployee.getIdemployee());
                   ListModel<String> listser =  meeting.getSelectservi().getModel();
                   ArrayList<String> milist = new ArrayList();
                    for (int i = 0; i < listser.getSize(); i++) {
                       milist.add(listser.getElementAt(i));
                   }
                    model.setMeetserv(milist);
                    boolean verifyposes = model.verify();
                    if(verifyposes){
                        String leyend = "This customer already has an appointmennt,delete the previous one that has not been processed to register a new one";
                         
                        meeting.getLeyenda().setText(leyend);
                    }else{
    
                        boolean resultt = model.insertMeeting();
                        if(resultt){
                        String leyend = "The appointment has been successfully registered";
                         meeting.dispose();
                        meeting.setVisible(false);
            
                        list = new Vmeeting(principal,true);
                        list.getCommend().setText(leyend);
                        list.setVisible(true);
//                        meeting.getLeyenda().setText(leyend);
//                        meeting.getDniclient().setText("");
//                        meeting.getNameclient().setText("");
//                        meeting.getLastnameclient().setText("");
//                        meeting.getEmployee().setText("");
//                        meeting.getHaircut().setText("");
//                        meeting.getSelectservi().removeAll();
//                        meeting.getDer().setEnabled(false);
//                        meeting.getIzq().setEnabled(false);
//                        this.TolistServices();
//                        
//                        meeting.getDateclient().setDate(new Date());
                        }else{
                         String leyend = "The appointment has not been successfully registered";
                        meeting.getLeyenda().setText(leyend);
                        } 
                    }
                    
                }
           }else if (model.getId()>0){
               String leyend1 = "Do you want to confirm the process?";
               int opc = JOptionPane.showConfirmDialog(principal,leyend1 , "Confirmation",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
               
               if(opc == 0){
                    ListModel<String> modelselect = (ListModel<String>)meeting.getSelectservi().getModel();
            try {
                modelservices.chackPrice(modelselect);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMeeting.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.pricetotal();
                   this.update();
                   completed.setControllerMeeting(this);
                   this.TolistCompletedServices();
                   this.TolistCompletedHaircut();
                   completed.getLinvoice().setText(String.valueOf(model.getId()));
                   completed.getClient().setText(modelclient.getName()+" "+modelclient.getLastname());
                   this.pricetotal();
                   completed.getLtotal().setText(String.valueOf(pricetotal));
                   
//                   SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                      
//                    String fomr = fecha.format(model.getDate());
                    completed.getLdate().setText(model.getDate()+ " "+ model.getHour());
                    completed.setVisible(true);
               }else{
                   
               }
           }
          
    }
    private boolean validecompleted(){
        boolean valide = false;
        if(meeting.getEmployee().getText().isEmpty()){
            String leyend = "You must select an employee";
            meeting.getLeyenda().setText(leyend);
        }else if(meeting.getHaircut().getText().isEmpty() && meeting.getSelectservi().getModel().getSize()<1){
            String leyend = "Select a type of cut or select a service, otherwise it will not be processed";
            meeting.getLeyenda().setText(leyend);
        }else{
            valide = true;
        }
        return valide;
    }
    private boolean validarRegisternew(){
        boolean validado = false;
       
        if(meeting.getDniclient().getText().isEmpty()){
            String leyend = "You must select a client";
            meeting.getLeyenda().setText(leyend);
        }else if(meeting.getEmployee().getText().isEmpty()){
            String leyend = "You must select an employee";
            meeting.getLeyenda().setText(leyend);
        }else if(meeting.getHaircut().getText().isEmpty() && meeting.getSelectservi().getModel().getSize()<1){
            String leyend = "Select a type of cut or select a service, otherwise it will not be processed";
            meeting.getLeyenda().setText(leyend);
        }else {
           validado = true;
        }
    return validado;
    }
    private void TolistClient(){
        String[][] information =  modelclient.resultList();
        client.getTablePerson().setModel(new javax.swing.table.DefaultTableModel(
        information,
        new String [] {"Phone","Name","Last Name"}) {
        boolean[] canEdit = new boolean [] {
            false,false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    client.getTablePerson().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    private void TolistCompletedServices(){
        String[][] information =  modelservices.list2Services(model.getId());
        completed.getServicesobt().setModel(new javax.swing.table.DefaultTableModel(
        information,
        new String [] {"Service","Price"}) {
        boolean[] canEdit = new boolean [] {
            false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    completed.getServicesobt().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    private void TolistCompletedHaircut(){
        String[][] information =  modelhaircut.listHairCut(model.getId());
        completed.getHairCutTable().setModel(new javax.swing.table.DefaultTableModel(
        information,
        new String [] {"Style","Price"}) {
        boolean[] canEdit = new boolean [] {
            false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    completed.getHairCutTable().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    private void moveselection(JList origin, JList destino){



        DefaultListModel listaorigin = (DefaultListModel) origin.getModel();
        DefaultListModel listadestino = (DefaultListModel) destino.getModel();
 
        int[] indice = origin.getSelectedIndices();
     
      List selec = origin.getSelectedValuesList();
       byte i = 0;
       
       for(Object selecc: selec) {
         listadestino.addElement(selecc);
         i++;
       }
            if( indice.length > 0){

               listaorigin.removeRange(indice[0], indice[i - 1]);
            }else{}

//               JOptionPane.showMessageDialog(principal, "Select an item from the list", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
    int contador  = 0;
    ListModel cont = meeting.getSelectservi().getModel();
    contador = cont.getSize();
    if(contador != 0){
        Color micolor = new Color(247,0,24,80);
        meeting.getDer().setBackground(micolor);
        meeting.getDer().setForeground(Color.white);
        meeting.getDer().setText( contador + "Selected services");
    }else{
        meeting.getDer().setText("Assign services");
        meeting.getDer().setForeground(Color.black);
        meeting.getDer().setBackground(Color.white);

    }
       
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        Object Mevent = me.getSource();
        if(Mevent.equals(list.gettableMeeting())){
            if (me.getClickCount() == 2) {
            try{
                int row = list.gettableMeeting().getSelectedRow();
                int row1 = list.gettableMeeting().convertRowIndexToModel(row);
                DefaultTableModel modelotabla=(DefaultTableModel) list.gettableMeeting().getModel();
                Long captura = Long.parseLong((String)modelotabla.getValueAt(row1, 0));
                Capturedata(captura,1);
            }catch(HeadlessException ex){
                System.out.println("Error: "+ex);
            }
            }
        }else if(Mevent.equals(client.getTablePerson())){
             if (me.getClickCount() == 2) {
            try{
                int row = client.getTablePerson().getSelectedRow();
                int row1 = client.getTablePerson().convertRowIndexToModel(row);
                DefaultTableModel modelotabla=(DefaultTableModel) client.getTablePerson().getModel();
                Long captura = Long.parseLong((String)modelotabla.getValueAt(row1, 0));
                Capturedata(captura,2);
            }catch(HeadlessException ex){
                System.out.println("Error: "+ex);
            }
            }
        }else if(Mevent.equals(employee.getEmployeeTable())){
                 if (me.getClickCount() == 2) {
            try{
                int row = employee.getEmployeeTable().getSelectedRow();
                int row1 =employee.getEmployeeTable().convertRowIndexToModel(row);
                DefaultTableModel modelotabla=(DefaultTableModel) employee.getEmployeeTable().getModel();
                long captura = Long.parseLong((String)modelotabla.getValueAt(row1, 0));
                Capturedata(captura,3);
            }catch(HeadlessException ex){
                System.out.println("Error: "+ex);
            }
            }
        }else if(Mevent.equals(haircut.getTableHairCut())){
                 if (me.getClickCount() == 2) {
            try{
                int row = haircut.getTableHairCut().getSelectedRow();
                int row1 =haircut.getTableHairCut().convertRowIndexToModel(row);
                DefaultTableModel modelotabla=(DefaultTableModel) haircut.getTableHairCut().getModel();
                String captura = (String) modelotabla.getValueAt(row1, 0);
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
        if(kevent.equals(list.getTextSearch())){
            char b = ke.getKeyChar();
            if(list.getTextSearch().getText().length()>50){
                ke.consume();
            }
        }else if(kevent.equals(client.getTextSearch())){
             char b = ke.getKeyChar();
            if(client.getTextSearch().getText().length()>50){
                ke.consume();
            }
        }else if(kevent.equals(employee.getTextSearch())){
              char b = ke.getKeyChar();
            if(employee.getTextSearch().getText().length()>50){
                ke.consume();
            }
        }else if(kevent.equals(haircut.getTextSearch())){
              char b = ke.getKeyChar();
            if(haircut.getTextSearch().getText().length()>50){
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
        if(origin.equals(list.getTextSearch())){
            String search = list.getTextSearch().getText();
            SearchList(search,list.gettableMeeting());
        }else if(origin.equals(client.getTextSearch())){
            String search = client.getTextSearch().getText();
            SearchList(search,client.getTablePerson());
        }else if(origin.equals(employee.getTextSearch())){
            String search = employee.getTextSearch().getText();
            SearchList(search,employee.getEmployeeTable());
        }else if(origin.equals(haircut.getTextSearch())){
            String search = haircut.getTextSearch().getText();
            SearchList(search,haircut.getTableHairCut());
        }
    }
    @Override
    public void stateChanged(ChangeEvent ce) {
            Object evn = ce.getSource();
        if(evn.equals(completed.getDiscount())){
            completed.getLdiscount().setText(completed.getDiscount().getValue()+" %");
            int discount = completed.getDiscount().getValue();

            double total = (pricetotal * discount) / 100;
            double rtotal = pricetotal - total;
            
            completed.getLtotal().setText(String.valueOf(rtotal));
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent lse) {
     
    }

    
    
    /**
     * 
     */
    private class Check{
        Time hour, hourmax;
        Calendar date;
        
        Check(Time hour,Calendar date){
            
            
            this.hour = hour;
            this.date = date;
            SimpleDateFormat hourform = new SimpleDateFormat("HH:mm:ss");
            
            Calendar date2 = Calendar.getInstance();
        
           
            date2.setTimeInMillis(hour.getTime());
            date2.add(Calendar.MINUTE, 60);
            
            this.hourmax = Time.valueOf(date2.get(Calendar.HOUR_OF_DAY)+":"+date2.get(Calendar.MINUTE)+":"+date2.get(Calendar.SECOND));
            String maxhour = hourform.format(hourmax);
            
            SimpleDateFormat forma = new SimpleDateFormat("yyyy-MM-dd");
     
            String date1 = forma.format(date.getTime());

            String fech1 = date1 + ' '+hour.toString();
            String fech2 = date1 + ' '+maxhour;
  
            ArrayList available = model.checkEmpAvailable(fech1, fech2);
           ArrayList verifi = (ArrayList) available.get(0);
            if(verifi.isEmpty()){
                String preg = "Dear user, there is no employee available for the selected time.\n"
                        + "Do you want to review the available hours range box? , otherwise choose the other options.";
               int opc = JOptionPane.showOptionDialog(principal,preg, "Rank Time necesary",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[]{"Yes","System decides","I will try another"},"Yes");
               if(opc < 1){
                   
               }else if(opc == 1){
                   
               }else{
                   
               }
            }else{
                ArrayList idempl = (ArrayList) available.get(0);
                int listleng = idempl.size();
                
                boolean exist = idempl.contains(modelemployee.getIdemployee());
                
                if(exist){
                    availab = true;
                }
            
        }
        }
    }
    private boolean availab = false;
}
