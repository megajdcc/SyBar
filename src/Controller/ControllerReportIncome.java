/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Income;
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
public class ControllerReportIncome implements ActionListener{
    
    
    private Income income;
    private final Reports report;
//    private final Principal principal;
    
    public ControllerReportIncome(Income income){
       this.income = income;
        report = new Reports();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evento = ae.getSource();
        
        if(evento.equals(income.getRank())){
            income.getCalendarRank().setEnabled(true);
            income.getSemonth().setEnabled(false);
            income.getYear().setEnabled(false);
            income.getProcess().setEnabled(true);
             income.getCalendarRank().setBehavior(MultyModelBehavior.SELECT_PERIOD);
            income.getPrint().setEnabled(true);
            String leyend = "Select the date range in the calendar panel";
            income.getLeyenda().setText(leyend);
            
        }else if(evento.equals(income.getDay())){
            income.getCalendarRank().setEnabled(true);
            income.getCalendarRank().setBehavior(MultyModelBehavior.SELECT_SINGLE);
            income.getSemonth().setEnabled(false);
            income.getYear().setEnabled(false);
            income.getProcess().setEnabled(true);
            income.getPrint().setEnabled(true);
            
            
            String leyend = "Select a single date in the calendar";
            income.getLeyenda().setText(leyend);
        }else if(evento.equals(income.getMonth())){
            income.getCalendarRank().setEnabled(false);
            income.getSemonth().setEnabled(true);
            income.getProcess().setEnabled(true);
            income.getPrint().setEnabled(true);
            income.getYear().setEnabled(true);
            
            
            String leyend = "Select one month and one year, corresponding to your request";
            income.getLeyenda().setText(leyend);
            
        }else if(evento.equals(income.getProcess())){
//            income.setCursor(Cursor.CURSOR_WAIT);
            process(false);
        }else if(evento.equals(income.getPrint())){
//            income.setCursor(Cursor.CURSOR_WAIT);
            process(true);
        }
    }

    private void process(boolean opc){
        
        if(false == opc){
            if(income.getDay().isSelected()){
                 Date fech = income.getCalendarRank().getSelectedDate().getTime();
                 DateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
                 String dat = formatdate.format(fech);
               report.incomeDaily(dat,false);
                this.clear();
            }else if(income.getMonth().isSelected()){
                int month = income.getSemonth().getMonth();
                int year = income.getYear().getYear();
                report.incomeMonth(month,year,false);
                this.clear();
            }else if(income.getRank().isSelected()){
                if(income.getCalendarRank().getSelectedPeriodSet().isSingleDate()){
                    String leyend = "Select a period of dates by dragging when clicking on the calendar";
                    income.getLeyenda().setText(leyend);
//                    income.cursordafault();
                }else{
                    PeriodSet per = income.getCalendarRank().getSelectedPeriodSet();
                    
                    ArrayList<Calendar> it = (ArrayList<Calendar>) per.getDates();
                    int tm = it.size();
                    Date fech1  = it.get(0).getTime();
                    Date fech2 = it.get(tm -1).getTime();
                    DateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
                    String dat1 = formatdate.format(fech1);
                    String dat2 = formatdate.format(fech2);
                    
                    
                    report.incomeRank(dat1,dat2, false);
                    this.clear();
                }
               
            }
        }else{
            if(income.getDay().isSelected()){
             Date fech = income.getCalendarRank().getSelectedDate().getTime();
                 DateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
                 String dat = formatdate.format(fech);
                 report.incomeDaily(dat,true);
                 this.clear();
            }else if(income.getMonth().isSelected()){
                 int month = income.getSemonth().getMonth();
                int year = income.getYear().getYear();
                report.incomeMonth(month,year,true);
                this.clear();
            }else if(income.getRank().isSelected()){
                if(income.getCalendarRank().getSelectedPeriodSet().isSingleDate()){
                    String leyend = "Select a period of dates by dragging when clicking on the calendar";
                    income.getLeyenda().setText(leyend);
                }else{
                    PeriodSet per = income.getCalendarRank().getSelectedPeriodSet();
                    
                    ArrayList<Calendar> it = (ArrayList<Calendar>) per.getDates();
                    int tm = it.size();
                    Date fech1  = it.get(0).getTime();
                    Date fech2 = it.get(tm -1).getTime();
                    DateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
                    String dat1 = formatdate.format(fech1);
                    String dat2 = formatdate.format(fech2);
                    
                    
                    report.incomeRank(dat1,dat2, true);
                    this.clear();
                }
               
            }
        }
        
    }
  
    private void clear(){
//        income.getMonth().setSelected(false);
        income.getProcess().setEnabled(false);
        income.getPrint().setEnabled(false);
//        income.getDay().setSelected(false);
        income.getFilter().clearSelection();
//        income.getRank().setSelected(false);
        income.getCalendarRank().setSelectedDate(new GregorianCalendar());
        income.getCalendarRank().setEnabled(false);
//        income.cursordafault();
        
        
    }
}
