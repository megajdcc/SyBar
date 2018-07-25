/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Service;
import View.Principal;
import View.Rservice;
import View.Vservice;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jnatn'h
 */
public class ControllerService implements ActionListener,KeyListener,MouseListener{

    DefaultTableModel dm;
    private Vservice servi;
    private Service model;
    private Principal principal;
    private Rservice service;
    public ControllerService(Vservice servi){
        this.servi = servi;
        model = new Service();
        
        this.Tolist();
    }
    
    private void Tolist(){
        String[][] information =  model.consultList();
        servi.getCatservice().setModel(new javax.swing.table.DefaultTableModel(
        information,
        new String [] {"Services","Price"}) {
        boolean[] canEdit = new boolean [] {
            false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    servi.getCatservice().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    public void SearchList(String consulta, JTable JTableBuscar){
     
        dm = (DefaultTableModel) JTableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr  = new TableRowSorter<>(dm);
        JTableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    public void Capturedata(String name){
     
           boolean found = model.consultModel(name);
           if (found){
               servi.dispose();
               servi.setVisible(false);
               service = new Rservice(principal,true);
               service.getService().setText(model.getService());
               service.getPrice().setText(String.valueOf(model.getPrice()));
               service.getPrint2().setVisible(false);
               service.setController(this);
               service.setVisible(true);
               
               }else{
               
                JOptionPane.showMessageDialog(principal,"Record no found ","Service",JOptionPane.INFORMATION_MESSAGE);
            }
       }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evento = ae.getSource();
        
        if(evento.equals(servi.getNuevo())){
            servi.dispose();
            servi.setVisible(false);
            service = new Rservice(principal,true);   
            service.getDelete().setVisible(false);
            service.getPrint2().setVisible(false);
            service.setController(this);
            service.setVisible(true);
               
        }else if(evento.equals(service.getExit())){
            service.dispose();
            service.setVisible(false);
            servi = new Vservice(principal,true);
            servi.setController(this);
            Tolist();
            servi.setVisible(true);
        }else if(evento.equals(service.getGrabar())){
            this.record();
        }else if(evento.equals(service.getDelete())){
            this.delete();
        }
        
    }
    private void delete(){
        boolean result = model.deleteService();
        if(result){
            service.dispose();
            service.setVisible(false);
            
            servi = new Vservice(principal,true);
            servi.setController(this);
            Tolist();
            servi.setVisible(true);
            servi.getLeyenda().setText("The service has been succesfully eliminated");
        }else{
             String leyend = "The service has not been succesfully eliminated";
             service.getLeyenda().setText(leyend);
        }
    }
    private void record(){
//        boolean result = this.validate();
         if(service.getService().getText().length() < 4 || service.getService().getText().contains("  ")){
                String leyend = "You can not register a service that is empty or that contains less than 4 characters or that contains multiple blancks";
                service.getLeyenda().setText(leyend);
            }else if(service.getPrice().getText().isEmpty()){
                  String leyend = "You can not register a service without price";
                service.getLeyenda().setText(leyend);
            }else{
                if(model.getId() > 0){
            model.setService(service.getService().getText());
            model.setPrice(Double.parseDouble(service.getPrice().getText()));
            boolean resultt = model.updateService();
            if(resultt){
                String leyend = "The service has been succesfully modified";
                service.getLeyenda().setText(leyend);
                
            }else{
                String leyend = "The service has not been succesfully modified";
                service.getLeyenda().setText(leyend);
            }
            
            }else if(model.getId() < 1){
            model.setService(service.getService().getText());
            model.setPrice(Double.parseDouble(service.getPrice().getText()));
              boolean resulttt = model.insertService();
            if(resulttt){
                String leyend = "The service has been succesfully registered";
                service.getLeyenda().setText(leyend);
                
            }else{
                String leyend = "The service has not been succesfully registered";
                service.getLeyenda().setText(leyend);
            }
            }
            }
        
        
    }

    private boolean validate(){
        boolean validated = false;
            if(service.getService().getText().length() < 4 || service.getService().getText().contains("  ")){
                String leyend = "You can not register a service that is empty or that contains less than 4 characters or that contains multiple blancks";
                service.getLeyenda().setText(leyend);
            }else if(service.getPrice().getText().isEmpty()){
                  String leyend = "You can not register a service without price";
                service.getLeyenda().setText(leyend);
            }else{
                validated = true;
            }
        return validated;
    }
   
    @Override
    public void keyTyped(KeyEvent ke) {
        Object kevent = ke.getSource();
        if(kevent.equals(servi.getCatservice())){
            char b = ke.getKeyChar();
            if(servi.getTextbusqueda().getText().length()>50){
                ke.consume();
            }
        }else if(kevent.equals(service.getPrice())){
            char b = ke.getKeyChar();
            if(!Character.isDigit(b) || service.getPrice().getText().length() > 10){
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
        if(origin.equals(servi.getTextbusqueda())){
            String busqueda = servi.getTextbusqueda().getText();
            SearchList(busqueda,servi.getCatservice());
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
          Object Mevent = me.getSource();
        if(Mevent.equals(servi.getCatservice())){
            if (me.getClickCount() == 2) {
            try{
                int fila = servi.getCatservice().getSelectedRow();
                int fila1 = servi.getCatservice().convertRowIndexToModel(fila);
                DefaultTableModel modelotabla=(DefaultTableModel) servi.getCatservice().getModel();
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
    
}
