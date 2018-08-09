package Controller;

import View.Vhaircut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Model.*;
import View.Principal;
import View.Rhaircut;
import java.awt.HeadlessException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class ControllerHaircut implements ActionListener, KeyListener, MouseListener{

    
    DefaultTableModel dm;
    private Vhaircut vHairCut;
    private Rhaircut rHairCut;
    private Cut cut;
    private Principal principal;
    public ControllerHaircut(Vhaircut vHairCut){
        this.vHairCut = vHairCut;
        cut = new Cut();
       
        this.Tolist();
    }
    private void Tolist(){
        String[][] informacion =  cut.cutList();
        vHairCut.getTableHairCut().setModel(new javax.swing.table.DefaultTableModel(
        informacion,
        new String [] {"Style","Price","Gender","Duration"}) {
        boolean[] canEdit = new boolean [] {
            false,false,false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    vHairCut.getTableHairCut().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    public void ListingSearch(String consulta, JTable JTableBuscar){
     
        dm = (DefaultTableModel) JTableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr  = new TableRowSorter<>(dm);
        JTableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    public void Capturedata(String name){
     
           boolean found = cut.matchingModel(name);
           if (found){
               vHairCut.dispose();
               vHairCut.setVisible(false);
               rHairCut = new Rhaircut(principal,true);
               rHairCut.getStyle().setText(cut.getStyle());
               rHairCut.getPrice().setText(String.valueOf(cut.getPrice()));
                    Calendar du = Calendar.getInstance();

                   int hrs = du.get(Calendar.HOUR_OF_DAY);
                   int mins = du.get(Calendar.MINUTE);
                   int sec = du.get(Calendar.SECOND);
                   du.add(Calendar.HOUR_OF_DAY, -hrs);
                   du.add(Calendar.MINUTE, -mins);
                   du.add(Calendar.SECOND, -sec);
                   int can = (int) cut.getDuration();
                   du.add(Calendar.MILLISECOND,can);
                    Time dur = Time.valueOf(du.get(Calendar.HOUR_OF_DAY)+":"+du.get(Calendar.MINUTE)+":"+du.get(Calendar.SECOND));
               rHairCut.getMues().setText(dur.toString());
               rHairCut.setDuratio(cut.getDuration());
               char gender = cut.getGender();
               if(gender == 'F'){
                   rHairCut.getFemale().setSelected(true);
               }else{
                   rHairCut.getMale().setSelected(true);
               }
               rHairCut.setControllerHairCut(this);
               rHairCut.setVisible(true);
               
               }else{
               
                JOptionPane.showMessageDialog(principal,"Record not dound","Haircut",JOptionPane.INFORMATION_MESSAGE);
            }
       }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        
        if(obj.equals(vHairCut.getNewBtt())){
            vHairCut.dispose();
            vHairCut.setVisible(false);
            cut.setId(0);
             rHairCut = new Rhaircut(principal,true);
            rHairCut.setControllerHairCut(this);
            rHairCut.setVisible(true);
        }else if(obj.equals(rHairCut.getExit())){
            rHairCut.dispose();
            rHairCut.setVisible(false);
            
            vHairCut = new Vhaircut(principal,true);
            vHairCut.setControllerHaircut(this);
            Tolist();
            vHairCut.setVisible(true);
        }else if(obj.equals(rHairCut.getRegisterBtt())){
            this.record();
        }else if(obj.equals(rHairCut.getDelete())){
            this.delete();
        }
    }
    private void delete(){
        boolean result = cut.deleteCut();
        if(result){
          
            rHairCut.setVisible(false);
            
            vHairCut = new Vhaircut(principal,true);
            vHairCut.setControllerHaircut(this);
            Tolist();
            vHairCut.setVisible(true);
        }else{
             String text = "Type of Cut has not been successfully deleted";
             rHairCut.getComment().setText(text);
        }
    }
    private void record(){
        boolean result = validate();
        if(result && cut.getId() > 0){
            cut.setStyle(rHairCut.getStyle().getText());
            cut.setPrice(Double.parseDouble(rHairCut.getPrice().getText()));
            cut.setGender(capturegender(rHairCut.getGender()).charAt(0));
            cut.setDuration(rHairCut.getDuratio());
            boolean resultt = cut.updateCut();
            if(resultt){
                String text = "the type of cut was successfully modified";
                rHairCut.getComment().setText(text);
            }else{
                String text = "the type of cut was successfully not modified";
                rHairCut.getComment().setText(text);
            }
            
        }else if(result && cut.getId() < 1){
            cut.setStyle(rHairCut.getStyle().getText());
            cut.setPrice(Double.parseDouble(rHairCut.getPrice().getText()));
            cut.setGender(capturegender(rHairCut.getGender()).charAt(0));
            cut.setDuration(rHairCut.getDuratio());
           
            if(cut.validateStyle(rHairCut.getStyle().getText())){
             String leyend = "The style you are entering already exist verify";
             rHairCut.getComment().setText(leyend);
            }else{
                 boolean resulttt = cut.insertCut();
                if(resulttt){
                String leyend = "the type of cut has been succesfully registered";
                rHairCut.getComment().setText(leyend);
                }else{
                String leyend = "the type of cut has not been succesfully registered";
                rHairCut.getComment().setText(leyend);
                }
            } 
        }
    }
    private String capturegender(ButtonGroup gender){
         String genders = null;
         
          for (Enumeration<AbstractButton > buttons = gender.getElements(); buttons.hasMoreElements();)
            {
                   AbstractButton button = buttons.nextElement();
                  if(button.isSelected())
                    {
                       genders = button.getText();
                   }
             } 
          return genders;
     }
    private boolean validate(){
        boolean validate = false;
         if(rHairCut.getStyle().getText().contains("  ") || rHairCut.getStyle().getText().length() < 2){
                String text = "Remember that the style can not have less than 2 characters and or contain several blank spaces";
                rHairCut.getComment().setText(text);
         }else if(rHairCut.getPrice().getText().isEmpty()){
             String leyend = "The price can not be empty";
                rHairCut.getComment().setText(leyend);
         }else if(!rHairCut.getGender().isSelected(rHairCut.getFemale().getModel()) && !rHairCut.getGender().isSelected(rHairCut.getMale().getModel())){
             String leyend = "You must select a genre of style";
             rHairCut.getComment().setText(leyend);
         }else{
             validate = true;
         }
        
        return validate;
    }
    @Override
    public void keyTyped(KeyEvent ke) {
        Object kevent = ke.getSource();
        if(kevent.equals(vHairCut.getTableHairCut())){
            char b = ke.getKeyChar();
            if(vHairCut.getTextSearch().getText().length()>50){
                ke.consume();
            }
        }else if(kevent.equals(rHairCut.getPrice())){
            char b = ke.getKeyChar();
            if(!Character.isDigit(b) || rHairCut.getPrice().getText().length() > 10){
                ke.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
      
    }

    @Override
    public void keyReleased(KeyEvent ke) {
         Object origen = ke.getSource();
        if(origen.equals(vHairCut.getTextSearch())){
            String search = vHairCut.getTextSearch().getText();
            ListingSearch(search,vHairCut.getTableHairCut());
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
           Object Mevent = me.getSource();
        if(Mevent.equals(vHairCut.getTableHairCut())){
            if (me.getClickCount() == 2) {
            try{
                int row = vHairCut.getTableHairCut().getSelectedRow();
                int row1 = vHairCut.getTableHairCut().convertRowIndexToModel(row);
                DefaultTableModel modelotabla=(DefaultTableModel) vHairCut.getTableHairCut().getModel();
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
    
}
