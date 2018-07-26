package Model;

import Controller.ControllerPrincipal;
import View.Principal;
import java.awt.Dialog;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.print.JRPrinterAWT;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;


public class Reports {
    private final Conection connection;
    private Principal principal;
    private File rute; 
    private final String headerimg = "/View/Report/headerreport.png";
    private final String logo = "/View/Report/Logo1.png";
    private JasperReport report;
    public Reports(){
    connection = new Conection();
    }
    
    
    public void invoiceMeeting(long m, boolean print){
        try {
        
            URL url = getClass().getResource("/View/Report/invoiceM.jasper");
            URL employee = getClass().getResource("/View/Report/");
            report = (JasperReport) JRLoader.loadObject(url);
            Map param = new HashMap();
            param.clear();
            
            param.put("meeting", m);
            param.put("employee", this.getClass().getResourceAsStream("/View/Report/employee.jasper"));
            param.put("haircuts", this.getClass().getResourceAsStream("/View/Report/haircut.jasper"));
            param.put("service", this.getClass().getResourceAsStream("/View/Report/servicemeeting.jasper"));
            param.put("headerimg", this.getClass().getResourceAsStream(headerimg));
            param.put("logoimg", this.getClass().getResourceAsStream(logo));
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, param,connection.getConec());
            Locale local = new Locale("heb","ISR");
            JasperViewer jv = new JasperViewer(jasperPrint,false,local);
            jv.setAlwaysOnTop(true);
            jv.setAutoRequestFocus(true);
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setResizable(true);
            jv.setTitle("Invoice");
            if(print){
                boolean print2 = JRPrinterAWT.printPages(jasperPrint,0,jasperPrint.getPages().size()-1,true);
            }else{
             
              ControllerPrincipal controllerPrincipal = Principal.getControllerPrincipal();
             // control.getVista().toBack();
               jv.setVisible(true);
               
               jv.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
               jv.toFront();
            }           
        } catch (JRException | JRRuntimeException e) {
            JOptionPane.showMessageDialog(principal, "The report could not be opened:"+e);
        }
    }
    
    public void customersServiceMonth(int month,int year,boolean printt){
        try {
        
            URL url = getClass().getResource("/View/Report/report1.jasper");
            
            report = (JasperReport) JRLoader.loadObject(url);
            Map param = new HashMap();
            param.clear();
            
            System.out.println(month);
            System.out.println(year);
            month += 1;
            param.put("month", month);
            param.put("year", year);
            param.put("logo", this.getClass().getResourceAsStream(logo));
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, param,connection.getConec());
            Locale local = new Locale("heb","ISR");
            JasperViewer jv = new JasperViewer(jasperPrint,false,local);
            jv.setAlwaysOnTop(true);
            jv.setAutoRequestFocus(true);
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setResizable(true);
            jv.setTitle("Customers Service of month");

            if(printt){
                boolean print = JRPrinterAWT.printPages(jasperPrint,0,jasperPrint.getPages().size()-1,true);
            }else{
             
              ControllerPrincipal controlPrincipal = Principal.getControllerPrincipal();
             // control.getVista().toBack();
               jv.setVisible(true);
               
               jv.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
               jv.toFront();
            }           
        } catch (JRException | JRRuntimeException e) {
            JOptionPane.showMessageDialog(principal, "The report could not be opened:"+e);
        }
    }
    public void incomeMonth(int month,int year,boolean printt){
        try {
        
            URL url = getClass().getResource("/View/Report/incomemonth.jasper");
            
            report = (JasperReport) JRLoader.loadObject(url);
            Map param = new HashMap();
            param.clear();
            
            System.out.println(month);
            System.out.println(year);
            month += 1;
            param.put("month", month);
            param.put("year", year);
            param.put("logoimg", this.getClass().getResourceAsStream(logo));
            param.put("totalmonth", this.getClass().getResourceAsStream("/View/Report/totalmonth.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, param,connection.getConec());
            Locale local = new Locale("heb","ISR");
            JasperViewer jv = new JasperViewer(jasperPrint,false,local);
            jv.setAlwaysOnTop(true);
            jv.setAutoRequestFocus(true);
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setResizable(true);
            jv.setTitle("Income of month");

            if(printt){
                boolean print = JRPrinterAWT.printPages(jasperPrint,0,jasperPrint.getPages().size()-1,true);
            }else{
             
              ControllerPrincipal controllerPrincipal = Principal.getControllerPrincipal();
             // control.getVista().toBack();
               jv.setVisible(true);
               
               jv.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
               jv.toFront();
            }           
        } catch (JRException | JRRuntimeException e) {
            JOptionPane.showMessageDialog(principal, "The report could not be opened:"+e);
        }
    }
    public void customersServiceDaily(String date,boolean printt){
        try {
        	System.out.println(date);
            URL rut = getClass().getResource("/View/Report/reportdaily.jasper");
            
            report = (JasperReport) JRLoader.loadObject(rut);
            Map param = new HashMap();
            param.clear();
            
            
            param.put("date", date);
            
            param.put("logo", this.getClass().getResourceAsStream(logo));
            JasperPrint recipePrint = JasperFillManager.fillReport(report, param,connection.getConec());
            Locale local = new Locale("heb","ISR");
            JasperViewer jv = new JasperViewer(recipePrint,false,local);
            jv.setAlwaysOnTop(true);
            jv.setAutoRequestFocus(true);
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setResizable(true);
            jv.setTitle("Customers Service of daily"+ date);

            if(printt){
                boolean print = JRPrinterAWT.printPages(recipePrint,0,recipePrint.getPages().size()-1,true);
            }else{
             
              ControllerPrincipal controllerPrincipal = Principal.getControllerPrincipal();
             // control.getVista().toBack();
               jv.setVisible(true);
               
               jv.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
               jv.toFront();
            }           
        } catch (JRException | JRRuntimeException e) {
            JOptionPane.showMessageDialog(principal, "The report could not be opened:"+e);
        }
    }
    public void incomeDaily(String date,boolean printt){
        try {
        
        	
            URL url = getClass().getResource("/View/Report/income.jasper");
            
            report = (JasperReport) JRLoader.loadObject(url);
            Map param = new HashMap();
            param.clear();
            
            
            param.put("date", date);
            param.put("dailytotal", this.getClass().getResourceAsStream("/View/Report/incometotal.jasper"));
            param.put("logoimg", this.getClass().getResourceAsStream(logo));
            JasperPrint recipePrint = JasperFillManager.fillReport(report, param,connection.getConec());
            Locale local = new Locale("heb","ISR");
            JasperViewer jv = new JasperViewer(recipePrint,false,local);
            jv.setAlwaysOnTop(true);
            jv.setAutoRequestFocus(true);
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setResizable(true);
            jv.setTitle("Income Daily");

            if(printt){
                boolean print = JRPrinterAWT.printPages(recipePrint,0,recipePrint.getPages().size()-1,true);
            }else{
             
              ControllerPrincipal conrollerPrincipal = Principal.getControllerPrincipal();
             // control.getVista().toBack();
               jv.setVisible(true);
               
               jv.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
               jv.toFront();
            }           
        } catch (JRException | JRRuntimeException e) {
            JOptionPane.showMessageDialog(principal, "The report could not be opened:"+e);
        }
    }
    public void customersServiceRank(String dateStart, String dateEnd, boolean printt){
        try {
        
            URL url = getClass().getResource("/View/Report/reportrank.jasper");
            
            report = (JasperReport) JRLoader.loadObject(url);
            Map param = new HashMap();
            param.clear();
            
            
            param.put("date1", dateStart);
            param.put("date2", dateEnd);
            param.put("logo", this.getClass().getResourceAsStream(logo));
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, param,connection.getConec());
            Locale local = new Locale("heb","ISR");
            JasperViewer jv = new JasperViewer(jasperPrint,false,local);
            jv.setAlwaysOnTop(true);
            jv.setAutoRequestFocus(true);
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setResizable(true);
            jv.setTitle("Customers Service of rank date");

            if(printt){
                boolean print = JRPrinterAWT.printPages(jasperPrint,0,jasperPrint.getPages().size()-1,true);
            }else{
             
              ControllerPrincipal controllerPrincipal = Principal.getControllerPrincipal();
             // control.getVista().toBack();
               jv.setVisible(true);
               
               jv.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
               jv.toFront();
            }           
        } catch (JRException | JRRuntimeException e) {
            JOptionPane.showMessageDialog(principal, "The report could not be opened:"+e);
        }
    }
    public void incomeRank(String startDate, String endDate, boolean printt){
        try {
        
            URL url = getClass().getResource("/View/Report/incomerank.jasper");
            
            report = (JasperReport) JRLoader.loadObject(url);
            Map param = new HashMap();
            param.clear();
            
            
            param.put("date1", startDate);
            param.put("date2", endDate);
            param.put("logoimg", this.getClass().getResourceAsStream(logo));
            param.put("ranktotal", this.getClass().getResourceAsStream("/View/Report/ranktotal.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, param,connection.getConec());
            Locale local = new Locale("heb","ISR");
            JasperViewer jv = new JasperViewer(jasperPrint,false,local);
            jv.setAlwaysOnTop(true);
            jv.setAutoRequestFocus(true);
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setResizable(true);
            jv.setTitle("incomes rank of "+ startDate+ "on "+endDate);

            if(printt){
                boolean print = JRPrinterAWT.printPages(jasperPrint,0,jasperPrint.getPages().size()-1,true);
            }else{
             
              ControllerPrincipal conrollerPrincipal = Principal.getControllerPrincipal();
             // control.getVista().toBack();
               jv.setVisible(true);
               
               jv.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
               jv.toFront();
            }           
        } catch (JRException | JRRuntimeException e) {
            JOptionPane.showMessageDialog(principal, "The report could not be opened:"+e);
        }
    }
}
