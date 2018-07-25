/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Position;
import View.Principal;
import View.Rworkposition;
import View.Vworkposition;
import java.awt.Color;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author Jnatn'h
 */
public class ControllerWorkPosition implements ActionListener,MouseListener,KeyListener{
    
    DefaultTableModel dm;
    private Vworkposition work;
    private Principal principal;
    private Rworkposition rwork;
    private Position model;
    public ControllerWorkPosition(Vworkposition work){
        this.work = work;
        model = new Position();
        rwork = new Rworkposition(principal,true);
        this.Tolist();
    }
    private void Tolist(){
        String[][] Information =  model.consultList();
        work.getCatwork().setModel(new javax.swing.table.DefaultTableModel(
        Information,
        new String [] {"Work Positión"}) {
        boolean[] canEdit = new boolean [] {
            false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    work.getCatwork().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    work.getCatwork().setAutoscrolls(true);
    }
    public void Searchlist(String consulta, JTable JTableBuscar){
        dm = (DefaultTableModel) JTableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr  = new TableRowSorter<>(dm);
        JTableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    public void Capturedata(String nombre){
          
           boolean found = model.consultModel(nombre);
           if (found){
                work.dispose();
                work.setVisible(false);
                rwork.getPosition().setText(model.getPosition());

                rwork.getDelete().setEnabled(true);
                rwork.getDelete().setVisible(true);
                rwork.getPrint().setVisible(false);
                rwork.setController(this);
                rwork.setVisible(true);
               
               }else{
               
                JOptionPane.showMessageDialog(new JFrame(),"Record not found","Work Position",JOptionPane.INFORMATION_MESSAGE);
            }
       }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evento = ae.getSource();
        if(evento.equals(work.getNuevo())){
            work.setVisible(false);
            work.dispose();
            
            rwork.setController(this);
            rwork.getPrint().setVisible(false);
            rwork.getDelete().setVisible(false);
            rwork.setVisible(true);
        }else if(evento.equals(rwork.getExit())){
            rwork.setVisible(false);
            rwork.dispose();
            work = new Vworkposition(principal,true);
            work.setController(this);
            this.Tolist();
            work.setVisible(true);
        }else if(evento.equals(rwork.getGrabar())){
            this.validate();
        }else if(evento.equals(rwork.getDelete())){
            boolean result = model.deletePosition();
            if(result){
                rwork.dispose();
                rwork.setVisible(false);
                work = new Vworkposition(principal,true);
                work.setController(this);
                Tolist();
                work.setVisible(true);
            }else{
                String leyend = "The job position has not been removed";
                rwork.getLeyenda().setText(leyend);
                rwork.getLeyenda().setForeground(Color.RED);
            }
        }
    }
    private void validate(){
         if (rwork.getPosition().getText().isEmpty()) {
               String leyend = "Can not register an empty position";
               rwork.getLeyenda().setText(leyend);
               rwork.getLeyenda().setForeground(Color.RED);
               rwork.getPosition().setFocusable(true);
         }else if(rwork.getPosition().getText().contains("  ") && rwork.getPosition().getText().length() < 3){
                 String leyend = "¡You can not register several blank spaces in the position and that it is not less than 3 characters";
                    rwork.getLeyenda().setText(leyend);
                    rwork.getLeyenda().setForeground(Color.ORANGE);
                    rwork.getPosition().setFocusable(true);
    }else{
             record();
         }
    }
    
 private void record(){
        if(model.getId()!=0){
            model.setPosition(rwork.getPosition().getText());
          Boolean Result = model.updatePosition();
          if(Result){
              String leyend = "You have succesfully modified the position "+rwork.getPosition().getText();
              rwork.getLeyenda().setText(leyend);
              rwork.getLeyenda().setForeground(Color.BLACK);
          }else{
              String leyend = "You have not succesfully modified the position, "+rwork.getPosition().getText()+" Check.";
              rwork.getLeyenda().setText(leyend);
              rwork.getLeyenda().setForeground(Color.RED);
          }
            
        }else{
            model.setPosition(rwork.getPosition().getText());
            boolean result = model.insertPosition();
            if(result){
                 String leyend = "You have succesfully registered the position "+rwork.getPosition().getText();
                rwork.getLeyenda().setText(leyend);
                rwork.getLeyenda().setForeground(Color.BLACK);
            }else{
                String leyend = "You have not succesfully registered the position, "+rwork.getPosition().getText()+" Check.";
                rwork.getLeyenda().setText(leyend);
                rwork.getLeyenda().setForeground(Color.RED);
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent me) {
         Object Mevent = me.getSource();
        if(Mevent.equals(work.getCatwork())){
            if (me.getClickCount() == 2) {
            try{
                int row = work.getCatwork().getSelectedRow();
                int row1 = work.getCatwork().convertRowIndexToModel(row);
                DefaultTableModel modelotabla=(DefaultTableModel) work.getCatwork().getModel();
                String captura = (String)modelotabla.getValueAt(row1, 0);
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
        if(kevent.equals(work.getCatwork())){
            char b = ke.getKeyChar();
            if(work.getTextbusqueda().getText().length()>50){
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
        if(origin.equals(work.getTextbusqueda())){
            String search = work.getTextbusqueda().getText();
            Searchlist(search,work.getCatwork());
        }
    }
    
}
