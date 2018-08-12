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
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import Model.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class ControllerMeeting implements ActionListener,MouseListener,KeyListener,ChangeListener,ListSelectionListener{
    
    DefaultTableModel dm;
    private Time hrselected;
    private final Meeting model;
    private final Client modelclient;
    private Employee modelemployee;
    private Cut modelhaircut;
    private Vmeeting list =null;
    public Rmeeting meeting = null;
    private Vperson client = null;
    private Vemployee employee = null;
    private Reports report;
    private Vhaircut haircut = null;
    private Principal principal;
    public boolean updat = false;
    private completedMeeting completed = null;
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
        employee = new Vemployee(principal,true);
        employee.setController(this);
        meeting = new Rmeeting(principal,true);
        client = new Vperson(principal,true);
        haircut = new Vhaircut(principal,true);
        completed = new completedMeeting(principal,true);
        Tolist();
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
        
        Object event = ae.getSource();
        if(event.equals(list.getNewBtt())){  
            
            list.setVisible(false);
            list.close();
            model.setId(0);
            updat = false;
             meeting = new Rmeeting(principal,true);
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
            
          meeting.close();
            meeting.setVisible(false);
            
            updat = false;  
            
           
            Tolist();
           
            list.setVisible(true);
        }else if(event.equals(meeting.getSclient())){
            
            client.setController(this);
            TolistClient();
            client.setVisible(true);
        }else if(event.equals(meeting.getSemployee())){
         //   JOptionPane.showMessageDialog(principal, "In Construction", "Warning", JOptionPane.WARNING_MESSAGE);
             
            employee.getNewBtt().setEnabled(false);
            Calendar fech1 = meeting.getDateclient().getCalendar();
            String day = fech1.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
            TolistEmployee(day);
            employee.setVisible(true);
        }else if(event.equals(client.getNewPerson())){
            
            Rclient personclient = new Rclient(principal,true);
            personclient.setControllerClient(new ControllerClient(personclient,client));
       
            personclient.getDelete().setVisible(false);
            personclient.setVisible(true);
            TolistClient();
        }else if(event.equals(meeting.getDelete())){
            this.delete();
        }else if(event.equals(meeting.getGrabar())){
            this.record();
        }else if(event.equals(meeting.getUpdate())){
            this.update();
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
        }else if(event.equals(completed.getProcess())){
            this.completed();
        }
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
               
                list.setVisible(false);
                list.close();
                updat = true;
                meeting = new Rmeeting(principal,true);
                
                boolean encclient = modelclient.captureClient(model.getClient());
                if(encclient){
                    
                    meeting.getDniclient().setText(String.valueOf(modelclient.getPhone()));
                    meeting.getNameclient().setText(modelclient.getName());
                    meeting.getLastnameclient().setText(modelclient.getLastname());
                }
                meeting.getDateclient().setDate(java.sql.Date.valueOf(model.getDate()));
                hrselected = model.getHour();
                
                meeting.getBtntime().setText("Selected time: "+hrselected.toString());
               meeting.getBtntime().setBackground(Color.green);
                
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
                meeting.getDer().setEnabled(false);
                meeting.getIzq().setEnabled(false);

                
              
                //TolistServices();
                meeting.setVisible(true);
               }else{
               
                JOptionPane.showMessageDialog(new JFrame(),"Record not found","Meeting",JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(opc == 2){
            boolean found = modelclient.matchingModel(dni);
           if (found){
         
                client.setVisible(false);
                meeting.getDniclient().setText(String.valueOf(modelclient.getPhone()));
                meeting.getNameclient().setText(modelclient.getName());
                meeting.getLastnameclient().setText(modelclient.getLastname());
               
               }else{
               
                JOptionPane.showMessageDialog(new JFrame(),"Record not found","Meeting",JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(opc == 3){
          
           employee.setVisible(false);
          
           boolean capt = modelemployee.captureemployee(dni);// Captura empleado ... 
           if(capt){
              model.setEmployee(modelemployee.getIdemployee());
              
              Time entrytime = Time.valueOf(modelemployee.getEntrytime());
              Time departuretime = Time.valueOf(modelemployee.getDeparture());
              
              //Capturamos rank de horas seleccionadas . 
               Time timein = Time.valueOf(meeting.getTime().getTimeField().getText());
               Time timeend = Time.valueOf(meeting.getRanktime().getTimeField().getText());
               
               
               // hora de entrada del empleado
              Calendar entry = new GregorianCalendar();
              entry.setTimeInMillis(entrytime.getTime());
              
              //hora de salida del empleado
              Calendar depart = new GregorianCalendar();
              depart.setTimeInMillis(departuretime.getTime());
              
              //primera hora seleccionada en el rango
              Calendar selectin = new GregorianCalendar();
              selectin.setTimeInMillis(timein.getTime());
              
              
              // ultima hora seleccionada en el rango
              Calendar selectend = Calendar.getInstance();
              selectend.setTimeInMillis(timeend.getTime());
              
              //verificamos que las horas seleccionadas en el rango  esten dentro del horario de trabajo seleccionado... 
              if(selectin.before(entry)  && selectend.before(entry)
                      || selectin.after(depart)){
                  
                  String leyn = "You can not select a time outside of the employee's chosen work time";
                  meeting.getLeyenda().setText(leyn);
                  JOptionPane.showMessageDialog(principal,leyn);
                  meeting.getLeyenda().setForeground(Color.red);
                  meeting.getGrabar().setEnabled(false);
              }else{
                 
                  catchhoursrangeemployee(entry,depart,selectin,selectend);
               //   this.checkcol();
                 
              }
           }
          
        }
           
       }
    
    private void catchhoursrangeemployee(Calendar entry,Calendar depart,Calendar selectin,Calendar selectend){
        
     
      long hourentry = entry.getTimeInMillis();
      long hourdeparture = depart.getTimeInMillis();
      long selecin = selectin.getTimeInMillis();
      long selend = selectend.getTimeInMillis();
      long hour = 3600000; // una hora equivale a 3600 segundos 
      long mh = 900000; // cantidad en milisegundo el equivalente a un 1/4 de hora 
      long mht = (hourdeparture - hourentry) / mh; // medias horas de trabajo del empleado.
      long mhse =  (selend - selecin) / mh; // medias horas de seleccion en el rango
      
      // creamos un arreglo en donde enlistaremos todas los 1/4 de horas de trabajo del empleado.. 
      ArrayList listhoras = new ArrayList();
      listhoras.add(new Time(hourentry));
      long mhi = hourentry + mh;
      for(long i = hourentry; i < hourdeparture ; i++){
          if(i == mhi){
              listhoras.add( new Time(i));
              mhi += mh;
          }
          
      }
      //  System.out.println(listhoras.toString());

      // creamos en arreglo en donde enlistaremos todos los 1/4 de horas seleccionadas en el rango de seleccion... 
        ArrayList lisths = new ArrayList();
        long mhs= selecin + mh;
        lisths.add(new Time(selecin));
        
        for(long i = selecin; i < selend; i++){
            if(i == mhs){
                lisths.add(new Time(i));
                mhs += mh;
            }
        } 
    //    System.out.println(lisths.toString());
        
        
        // capturamos todas las horas que esten dentro de las horas de trabajo ... 
        ArrayList hdent = new ArrayList();
   
        for(int i = 0; i < lisths.size(); i++){
            if(listhoras.contains(lisths.get(i))){
                hdent.add(lisths.get(i));
            }
        }
     //   System.out.println(hdent.toString());
        
        // consultamos las horas ocupadas para el empleado en ese dia .. 
        
        ArrayList hoc = model.capturebusyhours(modelemployee.getIdemployee(),meeting.getDateclient().getDate());
        
        ArrayList ph = (ArrayList) hoc.get(0);// hora de entrada .
         ArrayList eh = (ArrayList) hoc.get(1); // hora de salida.
         
//        System.out.println("Horas ocupadas: "+hoc.toString());
        ArrayList horocupadas = new ArrayList();
        for(int i = 0 ; i < ph.size(); i++){
            
           long phentrada = Time.valueOf((String) ph.get(i)).getTime();
           long ehsalida = Time.valueOf((String) eh.get(i)).getTime();
           
           horocupadas.add(new Time(phentrada));
           long mhy = phentrada + mh;
           for(long u = phentrada; u < ehsalida; u++){
               if(u == mhy){
               horocupadas.add(new Time(u));
               mhy += mh;
            }
           }
//            if(hoc.contains(hdent.get(i).toString().trim())){
////                System.out.println("horas ocupadas: "+ hdent.get(i));
//            }else{
//                 horlib.add(hdent.get(i));
//            }
//     
        }
        
     //   System.out.println("Horas ocupadas: "+ horocupadas.toString());
        
        ArrayList horlib = new ArrayList();
        for(int i = 0; i < hdent.size(); i++){
            if(horocupadas.contains((Time) hdent.get(i))){
                 //  System.out.println("horas ocupadas: "+ hdent.get(i));
            }else{
                 horlib.add(hdent.get(i));
            }
        }
      //  System.out.println("horas libres: "+horlib.toString());
        this.checkcol(horlib);
       
    }
    
    private void checkcol( ArrayList horlib){
       // Check ver = new Check(Time.valueOf(meeting.getTime().getFormatedTime()),meeting.getDateclient().getCalendar());
        //verificamos que no este vacio el arreglo ;
        if(horlib.isEmpty()){
            String mesagge = "Excuse me all the hours are occupied for the selected employee.\n "
                    + "Please check changing the range or day";
            
            JOptionPane.showMessageDialog(principal, mesagge, "Check Available", JOptionPane.WARNING_MESSAGE);
        }else{
           this.hrselected = (Time) horlib.get(0); // capturamos la position cero para tomar siempre la primera hora libre...
            String mesagge = "Excellent if there is availability for the client. \n"
                    + " The assigned time is : "+ hrselected.toString();
             JOptionPane.showMessageDialog(principal, mesagge, "Check Available", JOptionPane.INFORMATION_MESSAGE);
             
             meeting.getBtntime().setText("Selected time: "+hrselected.toString());
             meeting.getBtntime().setBackground(Color.green);
             meeting.getEmployee().setText(modelemployee.getName());
             TolistServices();
             meeting.getDer().setEnabled(true);
             meeting.getIzq().setEnabled(true);
             employee.setVisible(false);
             
        }
        
       
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
    
    public void reloademployee(){
        if(!meeting.getEmployee().getText().isEmpty()){
                Calendar fech1 = meeting.getDateclient().getCalendar();
                String day = fech1.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
                TolistEmployee(day);
                meeting.getEmployee().setText("");
               
                if(updat){
               

                meeting.getDer().setEnabled(true);
                meeting.getIzq().setEnabled(true);
                }
                
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
                        
          
                           this.completed.setVisible(false);
                           
                           meeting.setVisible(false);
                           meeting.close();
                            list = new Vmeeting(principal,true);
                            list.setControllerMeeting(new ControllerMeeting(list));
                            Tolist();
                            list.setVisible(true);
                       }else{
                            
                           this.completed.dispose();
                           this.completed.setVisible(false);
                           
                           meeting.setVisible(false);
                           meeting.close();
                            list = new Vmeeting(principal,true);
                            list.setControllerMeeting(new ControllerMeeting(list));
                            Tolist();
                            list.setVisible(true);
                       }
        }
    }
    
    private void update(){
        if(model.getId()>0){
               
          if(meeting.getEmployee().getText().isEmpty()){
            String leyend = "You must select an employee";
            meeting.getLeyenda().setText(leyend);
        }else {
                   Date fech = meeting.getDateclient().getDate();
                     
                    SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
                    model.setHour(hrselected);  
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
                       register = model.updateMeeting(modelhaircut.getDuration());
                   } catch (SQLException ex) {
                       Logger.getLogger(ControllerMeeting.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   if(register){
                       String leyend = "Succesfully update the appointment";
                       meeting.getLeyenda().setText(leyend);
                        updat = false;    
                   }else{
                        String leyend = "Sorry there was an error while registering.";
                        meeting.getLeyenda().setText(leyend);
                   }
                   
               }
//               else if(!valide){
//                    Date fech = meeting.getDateclient().getDate();
//                    SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    String fomr = fecha.format(fech);
//                    model.setDate(fomr);
//                    
//                    boolean updatopc = model.updateopc();
//                    if(updatopc){
//                        String leyend = "The date of the appointment has been successfully ypdated!";
//                        meeting.getLeyenda().setText(leyend);
//                    }else{
//                        String leyend = "Sorry there was an error while updating.";
//                        meeting.getLeyenda().setText(leyend);
//                    }
//               }
//               else{
//                   String leyend = "Sorry it could not be processed.";
//                   meeting.getLeyenda().setText(leyend);
//               }
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
                    
                    
                   String fomr = fecha.format(fech);
                   model.setDate(fomr);
                   model.setHour(hrselected);
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
    
                        boolean resultt = model.insertMeeting(modelhaircut.getDuration());
                        if(resultt){
                        String leyend = "The appointment has been successfully registered";
                         meeting.dispose();
                        meeting.setVisible(false);
            
                       Tolist();
                       list.setControllerMeeting(this);
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
        System.out.println(meeting.getEmployee().getText().isEmpty());
        if(meeting.getEmployee().getText().isEmpty()){
            String leyend = "You must select an employee";
            meeting.getLeyenda().setText(leyend);
        }
        
        else{
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
//JOptionPane.showMessageDialog(principal, "In construction", "Warning", JOptionPane.WARNING_MESSAGE);
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
                   rankfech();
               }else if(opc == 1){
                   systemdecide();
               }
            }else{
               
                int listleng = verifi.size();
                
                boolean exist = verifi.contains(modelemployee.getIdemployee());
                
                if(exist){
                    meeting.getEmployee().setText(modelemployee.getName());
                    meeting.getLeyenda().setForeground(Color.black);
                    meeting.getGrabar().setEnabled(true);
                    
                    employee.setVisible(false);
                    
                    TolistServices();
                    meeting.getDer().setEnabled(true);
                    meeting.getIzq().setEnabled(true);
                }else{
                    String preg1 = "El empleado elegido no esta disponible.\n"
                            + "Existen otros empleados que puede atenderlo a la misma hora elegida.\n"
                            + "Desea aceptar al empleado disponible?";
                    int opc1  = JOptionPane.showOptionDialog(principal,preg1,"Other employee available.",JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,null,new Object[]{"Aceptar","Horas Disponibles","Cancelar"},"Aceptar");
                    if(opc1 < 1 ){
                           modelemployee.setIdemployee((Long)verifi.get(0));
                           ArrayList nombemp = (ArrayList) available.get(1);

                           meeting.getEmployee().setText((String)nombemp.get(0));
                           meeting.getLeyenda().setForeground(Color.black);
                           meeting.getGrabar().setEnabled(true);

                           employee.setVisible(false);

                           TolistServices();
                           meeting.getDer().setEnabled(true);
                           meeting.getIzq().setEnabled(true);
                     
                    }else if(opc1 == 1){
                        hoursavailable();
                    }
                }
            
        }
        }
    private void hoursavailable(){
            Prueba p = new Prueba();
            p.setVisible(true);
        }
    private boolean availab = false;
    
    private void systemdecide(){
            ArrayList availa = model.checkemploavailable(meeting.getDateclient().getDate());
            
            Long idemployee = modelemployee.getIdemployee();
             ArrayList idemploye   =(ArrayList) availa.get(0);
            ArrayList nameemplo   =(ArrayList) availa.get(1);
           
            ArrayList entra       =(ArrayList) availa.get(2);

            ArrayList hourentry = model.hourentry;
            ArrayList hourdeparture = model.hourdeparture;
            SimpleDateFormat hourforma = new SimpleDateFormat("HH:mm:ss");
            Time houravailable = Time.valueOf(meeting.getTime().getFormatedTime());
            Calendar n = Calendar.getInstance();
            int h3 = n.get(Calendar.HOUR_OF_DAY);
            int m1 = n.get(Calendar.MINUTE);
            int s1 = n.get(Calendar.SECOND);
            n.add(Calendar.HOUR_OF_DAY, -h3);
            n.add(Calendar.MINUTE, -m1);
            n.add(Calendar.SECOND, -s1);
            n.add(Calendar.HOUR_OF_DAY,23);
            
            System.out.println(n.get(Calendar.SECOND));
            for(long i =0; i < n.get(Calendar.HOUR_OF_DAY); i++){
                for (int j = 0; j < nameemplo.size(); j++) {
                    Calendar entr = Calendar.getInstance();
                    entr.setTimeInMillis(Time.valueOf((String)entra.get(j)).getTime());
                    
                    Calendar d1 = Calendar.getInstance();
                    d1.setTimeInMillis(Time.valueOf((String)hourentry.get(j)).getTime());
                    
                    Calendar d2 = Calendar.getInstance();
                    d2.setTimeInMillis(Time.valueOf((String)hourdeparture.get(j)).getTime());
                    
                    Calendar entr2 = Calendar.getInstance();
                    entr2.setTimeInMillis(entr.getTimeInMillis());
                    entr2.add(Calendar.HOUR_OF_DAY, -1);
                    
                    Calendar entr3 = Calendar.getInstance();
                    entr3.setTimeInMillis(entr.getTimeInMillis());
                    entr3.add(Calendar.HOUR_OF_DAY, 1);
                    
                    
                     if(i <= entr2.get(Calendar.HOUR_OF_DAY)
                        && i > entr3.get(Calendar.HOUR_OF_DAY)
                        || i > d1.get(Calendar.HOUR_OF_DAY)
                        || i <= d2.get(Calendar.HOUR_OF_DAY)){
                         houravailable.setTime(i);
//                         System.out.println("Hora disponible: "+ Calendar.getInstance().set +" "+ idemploye.get(j));
                     }

                }
               
            }
    }
    private void rankfech(){
            
    }
    class Prueba extends JDialog{
            Principal principal;
            java.sql.Time hor1;
        public Prueba(){
           
        super(new Frame(),true);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,200));
        setResizable(false);
        setTitle("Employee availability");
        setMaximumSize(getPreferredSize());
        setMinimumSize(getPreferredSize());
        setLayout(new BorderLayout(0, 2));
        setLocationRelativeTo(null);
        JPanel cent = new JPanel();
        cent.setBackground(Color.green);
        cent.setLayout(new BorderLayout());
        
        JLabel ley = new JLabel("Avaible");
        JLabel leyn1 = new JLabel("");
        leyn1.setPreferredSize(new Dimension(120,30));
        ley.setBackground(Color.red);
        ley.setForeground(Color.black);
       ley.setFont(new Font("Serif",Font.BOLD,36));
        JPanel norc = new JPanel();
        norc.setOpaque(false);
        norc.setPreferredSize(cent.getPreferredSize());
        ley.setSize(norc.getPreferredSize());
        ley.setLocation(norc.getPreferredSize().width, norc.getPreferredSize().height /2);
        norc.add(ley);
        
        cent.add(norc,BorderLayout.CENTER);
        JPanel footer = new JPanel();
        footer.setLayout(new BorderLayout());
        
        JPanel fo1 = new JPanel();
        JPanel fo2 = new JPanel();
        JPanel fo3 = new JPanel();
        JLabel leyendafooter = new JLabel("Scroll through the slider to see the range of available hours");
        JSlider hor = new JSlider(0, 86400,0);
        JButton set = new JButton("Set");
        JButton exit = new JButton("Exit");
        
        
        ArrayList listhour = model.capturehoursavailable(meeting.getDateclient().getDate());
        
        ArrayList hoursentry  =(ArrayList) listhour.get(0);
        ArrayList hoursexit  =(ArrayList) listhour.get(1);
        ArrayList turnemployee  =(ArrayList) listhour.get(2);

        Time entryemployee = Time.valueOf((String)turnemployee.get(0));
        Time departuretime = Time.valueOf((String) turnemployee.get(1));
        
        Calendar hourse = Calendar.getInstance();
        Calendar hora1 = Calendar.getInstance();
        Calendar hora2 = Calendar.getInstance();
        
        hora1.add(Calendar.HOUR_OF_DAY, -2);
        hora2.add(Calendar.HOUR_OF_DAY, -8);
        hora1.add(Calendar.MINUTE, 30);
        
        Long ln1 = hora1.getTimeInMillis();
        Calendar hora3 = Calendar.getInstance();
        
        
        hourse.add(Calendar.YEAR, hora1.get(Calendar.YEAR));
        hourse.add(Calendar.YEAR, -1);
        
        hora3.setTimeInMillis(ln1);
        hora3.add(Calendar.MINUTE,60);
        
       java.sql.Time hor2 = Time.valueOf(hora1.get(Calendar.HOUR_OF_DAY)+":"+hora1.get(Calendar.MINUTE)+":"+hora1.get(Calendar.SECOND));
     
       java.sql.Time hor3 = Time.valueOf(hora3.get(Calendar.HOUR_OF_DAY)+":"+hora3.get(Calendar.MINUTE)+":"+hora3.get(Calendar.SECOND));
       ListIterator it =hoursentry.listIterator();
         
        hor.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent ce) {
                int h1 =hor.getValue(); 
                 int h3 = hourse.get(Calendar.HOUR_OF_DAY);
        int m1 = hourse.get(Calendar.MINUTE);
        int s1 = hourse.get(Calendar.SECOND);
        hourse.add(Calendar.HOUR_OF_DAY,-h3);
        hourse.add(Calendar.MINUTE,-m1);
        hourse.add(Calendar.SECOND,-s1);
                hourse.add(Calendar.SECOND, +h1);
                hor1 = Time.valueOf(hourse.get(Calendar.HOUR_OF_DAY)+":"+hourse.get(Calendar.MINUTE)+":"+hourse.get(Calendar.SECOND));
               leyn1.setText("Time: "+hor1.toString());
               hora2.setTimeInMillis(hourse.getTimeInMillis());
               hora2.add(Calendar.MINUTE, 60);
            
               
                for(int i = 0; i < hoursentry.size() ; i++) { 
                    
                  //  System.out.println((String)hoursentry.get(i));
                
             
                if(hor1.getTime() > Time.valueOf((String)hoursentry.get(i)).getTime()-3505125 
                        && Time.valueOf((String)hoursentry.get(i)).getTime() <= Time.valueOf((String)hoursentry.get(i)).getTime()+3505125
                        || entryemployee.getTime() > hor1.getTime() || departuretime.getTime() < hor1.getTime()){
                    cent.setBackground(Color.red);
                    ley.setText("Not Available");
                    set.setEnabled(false);
                }else{
                    cent.setBackground(Color.green);
                    ley.setText("Available");
                    set.setEnabled(true);
                }
               
                }
   

            }
        
        });
        hor.setPaintTicks(true);
        hor.setMajorTickSpacing(3600);
        hor.setPreferredSize(new Dimension(350,30));
        
        fo1.add(hor);
        fo1.add(leyn1);
        fo3.add(leyendafooter);
        
        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               meeting.getTime().setTime(hor1);
               meeting.getEmployee().setText(modelemployee.getName());
                    meeting.getLeyenda().setForeground(Color.black);
                    meeting.getGrabar().setEnabled(true);
                    TolistServices();
                    meeting.getDer().setEnabled(true);
                    meeting.getIzq().setEnabled(true);
                setVisible(false);
               dispose();
            }
        });
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               setVisible(false);
               dispose();
            }
       
                });
        
        footer.setPreferredSize(new Dimension(getPreferredSize().width,getPreferredSize().height / 2));
        set.setPreferredSize(new Dimension(150,20));
        exit.setPreferredSize(new Dimension(150,20));
        set.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fo2.add(set);
        fo2.add(exit);
        footer.add(fo1,BorderLayout.NORTH);
        footer.add(fo2,BorderLayout.CENTER);
        footer.add(fo3,BorderLayout.SOUTH);
        
        add(cent,BorderLayout.CENTER);
        add(footer,BorderLayout.SOUTH);
         
    }
 
}  
        }
    }
    
