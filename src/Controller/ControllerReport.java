/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Customers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.*;
import com.sun.glass.ui.Cursor;
import datechooser.model.multiple.MultyModelBehavior;
import datechooser.model.multiple.PeriodSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 *
 * @author Jnatn'h
 */
public class ControllerReport implements ActionListener{
    
    
    private Customers customers;
    private Reports report;
//    private final Principal principal;
    
    public ControllerReport(Customers customer){
        this.customers = customer;
        report = new Reports();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evento = ae.getSource();
        
        if(evento.equals(customers.getRank())){
            customers.getCalendarRank().setEnabled(true);
            customers.getSemonth().setEnabled(false);
            customers.getYear().setEnabled(false);
            customers.getProcess().setEnabled(true);
             customers.getCalendarRank().setBehavior(MultyModelBehavior.SELECT_PERIOD);
            customers.getPrint().setEnabled(true);
            String leyend = "Select the date range in the calendar panel";
            customers.getLeyenda().setText(leyend);
            
        }else if(evento.equals(customers.getDay())){
            customers.getCalendarRank().setEnabled(true);
            customers.getCalendarRank().setBehavior(MultyModelBehavior.SELECT_SINGLE);
            customers.getSemonth().setEnabled(false);
            customers.getYear().setEnabled(false);
            customers.getProcess().setEnabled(true);
            customers.getPrint().setEnabled(true);
            
            
            String leyend = "Select a single date in the calendar";
            customers.getLeyenda().setText(leyend);
        }else if(evento.equals(customers.getMonth())){
            customers.getCalendarRank().setEnabled(false);
            customers.getSemonth().setEnabled(true);
            customers.getProcess().setEnabled(true);
            customers.getPrint().setEnabled(true);
            customers.getYear().setEnabled(true);
            
            
            String leyend = "Select one month and one year, corresponding to your request";
            customers.getLeyenda().setText(leyend);
            
        }else if(evento.equals(customers.getProcess())){
            customers.setCursor(Cursor.CURSOR_WAIT);
            process(false);
        }else if(evento.equals(customers.getPrint())){
            customers.setCursor(Cursor.CURSOR_WAIT);
            process(true);
        }
    }

    private void process(boolean opc){
        
        if(false == opc){
            if(customers.getDay().isSelected()){
                 Date fech = customers.getCalendarRank().getSelectedDate().getTime();
                 DateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
                 String dat = formatdate.format(fech);
                report.customerserved(dat,false);
                this.clear();
            }else if(customers.getMonth().isSelected()){
                int month = customers.getSemonth().getMonth();
                int year = customers.getYear().getYear();
                report.customerserved(month,year,false);
                this.clear();
            }else if(customers.getRank().isSelected()){
                if(customers.getCalendarRank().getSelectedPeriodSet().isSingleDate()){
                    String leyend = "Select a period of dates by dragging when clicking on the calendar";
                    customers.getLeyenda().setText(leyend);
                    customers.cursordafault();
                }else{
                    PeriodSet per = customers.getCalendarRank().getSelectedPeriodSet();
                    
                    ArrayList<Calendar> it = (ArrayList<Calendar>) per.getDates();
                    int tm = it.size();
                    Date fech1  = it.get(0).getTime();
                    Date fech2 = it.get(tm -1).getTime();
                    DateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
                    String dat1 = formatdate.format(fech1);
                    String dat2 = formatdate.format(fech2);
                    
                    
                    report.customerserved(dat1,dat2, false);
                    this.clear();
                }
               
            }
        }else{
            if(customers.getDay().isSelected()){
             Date fech = customers.getCalendarRank().getSelectedDate().getTime();
                 DateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
                 String dat = formatdate.format(fech);
                 report.customerserved(dat,true);
                 this.clear();
            }else if(customers.getMonth().isSelected()){
                int month = customers.getSemonth().getMonth();
                int year = customers.getYear().getYear();
                report.customerserved(month,year,true);
                this.clear();
            }else if(customers.getRank().isSelected()){
                if(customers.getCalendarRank().getSelectedPeriodSet().isSingleDate()){
                    String leyend = "Select a period of dates by dragging when clicking on the calendar";
                    customers.getLeyenda().setText(leyend);
                }else{
                    PeriodSet per = customers.getCalendarRank().getSelectedPeriodSet();
                    
                    ArrayList<Calendar> it = (ArrayList<Calendar>) per.getDates();
                    int tm = it.size();
                    Date fech1  = it.get(0).getTime();
                    Date fech2 = it.get(tm -1).getTime();
                    DateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
                    String dat1 = formatdate.format(fech1);
                    String dat2 = formatdate.format(fech2);
                    
                    
                    report.customerserved(dat1,dat2, true);
                    this.clear();
                }
               
            }
        }
        
    }
    private void clear(){
//        customers.getMonth().setSelected(false);
        customers.getProcess().setEnabled(false);
        customers.getPrint().setEnabled(false);
//        customers.getDay().setSelected(false);
        customers.getFilter().clearSelection();
//        customers.getRank().setSelected(false);
        customers.getCalendarRank().setSelectedDate(new GregorianCalendar());
        customers.getCalendarRank().setEnabled(false);
        customers.cursordafault();
        
        
    }
}
