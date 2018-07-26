
package Controller;

import Model.JobTitle;
import Model.Position;
import View.Principal;
import View.Rjobtitle;
import View.Vjobtitle;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ControllerJobTitle implements ActionListener,KeyListener,MouseListener {

    DefaultTableModel dm;
    private Vjobtitle vjob;
    private Rjobtitle job_Title;
    private JobTitle model;
    private Position positionModel;
    private Principal principal;
    public ControllerJobTitle(Vjobtitle v){
        this.vjob = v;
        model = new JobTitle();
        positionModel = new Position();
        
        this.Tolist();
      
    }
    private void positionsList(DefaultComboBoxModel comboModel){
        boolean result= false;
        result = positionModel.listPosition(comboModel);
     
     }
      private void Tolist(){
        String[][] info =  model.resultList();
        vjob.getTabelJobTittle().setModel(new javax.swing.table.DefaultTableModel(
        info,
        new String [] {"Job Title","Position"}) {
        boolean[] canEdit = new boolean [] {
            false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    vjob.getTabelJobTittle().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    public void searchList(String query, JTable jTableSearch){
     
        dm = (DefaultTableModel) jTableSearch.getModel();
        TableRowSorter<DefaultTableModel> tr  = new TableRowSorter<>(dm);
        jTableSearch.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    public void captureData(String name){
     
           boolean found = model.matchingModel(name);
           if (found){
                vjob.dispose();
                vjob.setVisible(false);
                    job_Title = new Rjobtitle(principal, true);
                    job_Title.setControllerJobTittle(this);
                    DefaultComboBoxModel cb = (DefaultComboBoxModel) job_Title.getPosition().getModel();
                    this.positionsList(cb);
                    positionModel.checkName(model.getPositionId());
                    job_Title.getPosition().setSelectedItem(positionModel.getPosition());
                    job_Title.getJobTitle().setText(model.getJobName());
                
                    job_Title.getDelete().setEnabled(true);
                    job_Title.getDelete().setVisible(true);
                    job_Title.setControllerJobTittle(this);
                    job_Title.setVisible(true);
               
               }else{
               
                JOptionPane.showMessageDialog(new JFrame(),"Record not found","Job Title",JOptionPane.INFORMATION_MESSAGE);
            }
       }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object event = ae.getSource();
        if(event.equals(vjob.getNewBtt())){
            vjob.setVisible(false);
            vjob.dispose();
            job_Title = new Rjobtitle(principal, true);
            job_Title.setControllerJobTittle(this);
            DefaultComboBoxModel cm = (DefaultComboBoxModel) job_Title.getPosition().getModel();
            this.positionsList(cm);
            job_Title.getDelete().setVisible(false);
            job_Title.setVisible(true);
        	}else if(event.equals(job_Title.getExit())){
            job_Title.setVisible(false);
            job_Title.dispose();
            job_Title.getPosition().removeAllItems();
            
            
            vjob = new Vjobtitle(principal,true);
            vjob.setControllerJobTittle(this);
            this.Tolist();
            vjob.setVisible(true);
            
        }else if(event.equals(job_Title.getDelete())){
            this.delete();
        }else if(event.equals(job_Title.getRegister())){
            this.validate();
        }
    }
    private void validate(){
        String jobTitle = job_Title.getJobTitle().getText().toString();
        if(job_Title.getPosition().getSelectedItem().toString().equalsIgnoreCase("Select")){
                String err = "You must select a work position";
                job_Title.getComment().setText(err);
            }else if(jobTitle.length()<4){
                String err = "The job title must not be empty or less than 4 characters";
                job_Title.getComment().setText(err);
            }else{
                this.record();
            }
    }
    private void record(){
        if(model.getId() >0){
            model.setJobName(job_Title.getJobTitle().getText().trim());
            int positionId = positionModel.checkId(job_Title.getPosition().getSelectedItem().toString());
            if(positionId !=0){
                model.setPositionId(positionId);
                  boolean result = model.updateJob();
              if(result){
                  String success = "The job title has been modified successfully";
                  model.setId(0);
                  job_Title.getComment().setText(success);
                  job_Title.getPosition().setSelectedItem("Seleccione");
                  job_Title.getJobTitle().setText("");
                  job_Title.getDelete().setVisible(false);
              }  
              }else{
                  String err = "The job title has not been modified";
                  job_Title.getComment().setText(err);
                  job_Title.getComment().setForeground(Color.RED);
              }
        }else{
            model.setJobName(job_Title.getJobTitle().getText().trim());
            int positionId = positionModel.checkId(job_Title.getPosition().getSelectedItem().toString());
            if(positionId !=0){
                model.setPositionId(positionId);
                  boolean result = model.insertJob();
              if(result){
                  String success = "The job title has been succesfully registered";
                  
                  job_Title.getComment().setText(success);
                  job_Title.getPosition().setSelectedItem("Select");
                  job_Title.getJobTitle().setText("");
                  job_Title.getDelete().setVisible(false);
              }  
              }else{
                  String err = "The job title has not registered";
                  job_Title.getComment().setText(err);
                  job_Title.getComment().setForeground(Color.RED);
              }
        }
    }
    private void delete(){
          boolean result = model.deleteJob();
          if(result){
              job_Title.setVisible(false);
              job_Title.dispose();
              vjob.dispose();
              vjob = new Vjobtitle(principal,true);
              vjob.setControllerJobTittle(this);
              this.Tolist();
              vjob.setVisible(true);
          }else{
              String err = "Can not be deleted "+ job_Title.getJobTitle().getText() + ", is being used somewhere else";
          }
    }
    @Override
    public void keyTyped(KeyEvent ke) {
          Object keyEvent = ke.getSource();
        if(keyEvent.equals(vjob.getTabelJobTittle())){
            char b = ke.getKeyChar();
            if(vjob.getTextSearch().getText().length()>50){
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
        if(origin.equals(vjob.getTextSearch())){
            String search = vjob.getTextSearch().getText();
            searchList(search,vjob.getTabelJobTittle());
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
       Object mouseEvent = me.getSource();
        if(mouseEvent.equals(vjob.getTabelJobTittle())){
            if (me.getClickCount() == 2) {
            try{
                int row = vjob.getTabelJobTittle().getSelectedRow();
                int row1 = vjob.getTabelJobTittle().convertRowIndexToModel(row);
                DefaultTableModel tableModel=(DefaultTableModel) vjob.getTabelJobTittle().getModel();
                String capture = (String) tableModel.getValueAt(row1, 0);
                captureData(capture);
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
