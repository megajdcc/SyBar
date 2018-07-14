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


public class ControllerService implements ActionListener,KeyListener,MouseListener{

    DefaultTableModel dm;
    private Vservice vService;
    private Service serviceModel;
    private Principal principal;
    private Rservice rService;
    public ControllerService(Vservice vService){
        this.vService = vService;
        serviceModel = new Service();
        this.Tolist();
    }
    
    private void Tolist(){
        String[][] information =  serviceModel.serviceList();
        vService.getServiceTable().setModel(new javax.swing.table.DefaultTableModel(
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
    vService.getServiceTable().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    public void SearchList(String query, JTable jTableSearch){
     
        dm = (DefaultTableModel) jTableSearch.getModel();
        TableRowSorter<DefaultTableModel> tr  = new TableRowSorter<>(dm);
        jTableSearch.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    public void Capturedata(String name){
     
           boolean found = serviceModel.matchingModel(name);
           if (found){
               vService.dispose();
               vService.setVisible(false);
               rService = new Rservice(principal,true);
               rService.getService().setText(serviceModel.getService());
               rService.getPrice().setText(String.valueOf(serviceModel.getPrice()));
               rService.setControllerService(this);
               rService.setVisible(true);
               
               }else{
               
                JOptionPane.showMessageDialog(principal,"service no found ","Service",JOptionPane.INFORMATION_MESSAGE);
            }
       }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object obj = actionEvent.getSource();
        
        if(obj.equals(vService.getNewBtt())){
            vService.dispose();
            vService.setVisible(false);
            rService = new Rservice(principal,true);   
            rService.getDeleteBtt().setVisible(false);
            rService.setControllerService(this);
            rService.setVisible(true);
               
        }else if(obj.equals(rService.getExitBtt())){
            rService.dispose();
            rService.setVisible(false);
            vService = new Vservice(principal,true);
            vService.setControllerService(this);
            Tolist();
            vService.setVisible(true);
        }else if(obj.equals(rService.getRgisterBtt())){
            this.record();
        }else if(obj.equals(rService.getDeleteBtt())){
            this.delete();
        }
        
    }
    private void delete(){
        boolean result = serviceModel.deleteService();
        if(result){
            rService.dispose();
            rService.setVisible(false);
            
            vService = new Vservice(principal,true);
            vService.setControllerService(this);
            Tolist();
            vService.setVisible(true);
            vService.getCommand().setText("The Service has been succesfully deleted");
        }else{
             String txt = "The Service has not been succesfully deleted";
             rService.getCommand().setText(txt);
        }
    }
    private void record(){

         if(rService.getService().getText().length() < 2 || rService.getService().getText().contains("  ")){
                String txt = "You can not register a Service that is empty or that contains less than 2 characters or that contains multiple blancks";
                rService.getCommand().setText(txt);
            }else if(rService.getPrice().getText().isEmpty()){
                  String txt = "You can not register a Service without price";
                rService.getCommand().setText(txt);
            }else{
                if(serviceModel.getId() > 0){
            serviceModel.setService(rService.getService().getText());
            serviceModel.setPrice(Double.parseDouble(rService.getPrice().getText()));
            boolean resultt = serviceModel.updateService();
            if(resultt){
                String txt = "The Service has been succesfully modified";
                rService.getCommand().setText(txt);
                
            }else{
                String txt = "The Service has not been succesfully modified";
                rService.getCommand().setText(txt);
            }
            
            }else if(serviceModel.getId() < 1){
            serviceModel.setService(rService.getService().getText());
            serviceModel.setPrice(Double.parseDouble(rService.getPrice().getText()));
              boolean resulttt = serviceModel.insertService();
            if(resulttt){
                String txt = "The Service has been succesfully registered";
                rService.getCommand().setText(txt);
                
            }else{
                String leyend = "The rService has not been succesfully registered";
                rService.getCommand().setText(leyend);
            }
            }
            }
        
        
    }

    private boolean validate(){
        boolean validated = false;
            if(rService.getService().getText().length() < 4 || rService.getService().getText().contains("  ")){
                String txt = "You can not register a rService that is empty or that contains less than 4 characters or that contains multiple blancks";
                rService.getCommand().setText(txt);
            }else if(rService.getPrice().getText().isEmpty()){
                  String txt = "You can not register a Service without price";
                rService.getCommand().setText(txt);
            }else{
                validated = true;
            }
        return validated;
    }
   
    @Override
    public void keyTyped(KeyEvent ke) {
        Object obj = ke.getSource();
        if(obj.equals(vService.getServiceTable())){
            char b = ke.getKeyChar();
            if(vService.getTextSearch().getText().length()>50){
                ke.consume();
            }
        }else if(obj.equals(rService.getPrice())){
            char b = ke.getKeyChar();
            if(!Character.isDigit(b) || rService.getPrice().getText().length() > 10){
                ke.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
         Object obj = ke.getSource();
        if(obj.equals(vService.getTextSearch())){
            String search = vService.getTextSearch().getText();
            SearchList(search,vService.getServiceTable());
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
          Object obj = me.getSource();
        if(obj.equals(vService.getServiceTable())){
            if (me.getClickCount() == 2) {
            try{
                int row = vService.getServiceTable().getSelectedRow();
                int row1 = vService.getServiceTable().convertRowIndexToModel(row);
                DefaultTableModel tableModel=(DefaultTableModel) vService.getServiceTable().getModel();
                String captura = (String) tableModel.getValueAt(row1, 0);
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
