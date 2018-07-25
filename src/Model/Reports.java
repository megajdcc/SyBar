/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Jnatn'h
 */
public class Reports {
    private final Conection conexion;
    private Principal principal;
    private File ruta; 
    private final String headerimg = "/View/Report/headerreport.png";
    private final String logo = "/View/Report/Logo1.png";
    private JasperReport report;
    public Reports(){
    conexion = new Conection();
    }
    
    
    public void invoiceMeeting(long m, boolean impresion){
        try {
        
           // ruta = new File("src/View/Report/invoiceM.jasper");
            URL rut = getClass().getResource("/View/Report/invoiceM.jasper");
            URL employee = getClass().getResource("/View/Report/");
            report = (JasperReport) JRLoader.loadObject(rut);
            Map param = new HashMap();
            param.clear();
            
            param.put("meeting", m);
            param.put("employee", this.getClass().getResourceAsStream("/View/Report/employee.jasper"));
            param.put("haircuts", this.getClass().getResourceAsStream("/View/Report/haircut.jasper"));
            param.put("service", this.getClass().getResourceAsStream("/View/Report/servicemeeting.jasper"));
            param.put("headerimg", this.getClass().getResourceAsStream(headerimg));
            param.put("logoimg", this.getClass().getResourceAsStream(logo));
            JasperPrint recip = JasperFillManager.fillReport(report, param,conexion.getConec());
            Locale miregion = new Locale("heb","ISR");
            JasperViewer jv = new JasperViewer(recip,false,miregion);
            jv.setAlwaysOnTop(true);
            jv.setAutoRequestFocus(true);
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setResizable(true);
            jv.setTitle("Invoice");
            if(impresion){
                boolean imprimio = JRPrinterAWT.printPages(recip,0,0,true);
            }else{
             
              ControllerPrincipal control = Principal.getController();
             // control.getVista().toBack();
               jv.setVisible(true);
               
               jv.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
               jv.toFront();
            }           
        } catch (JRException | JRRuntimeException e) {
            JOptionPane.showMessageDialog(principal, "The report could not be opened:"+e);
        }
    }
    
    public void customerserved(int month,int year,boolean impr){
        try {
        
           // ruta = new File("src/View/Report/invoiceM.jasper");
            URL rut = getClass().getResource("/View/Report/report1.jasper");
            
            report = (JasperReport) JRLoader.loadObject(rut);
            Map param = new HashMap();
            param.clear();
            
            System.out.println(month);
            System.out.println(year);
            month += 1;
            param.put("month", month);
            param.put("year", year);
            param.put("logo", this.getClass().getResourceAsStream(logo));
            JasperPrint recip = JasperFillManager.fillReport(report, param,conexion.getConec());
            Locale miregion = new Locale("heb","ISR");
            JasperViewer jv = new JasperViewer(recip,false,miregion);
            jv.setAlwaysOnTop(true);
            jv.setAutoRequestFocus(true);
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setResizable(true);
            jv.setTitle("Customers Served of month");

            if(impr){
                boolean imprimio = JRPrinterAWT.printPages(recip,0,0,true);
            }else{
             
              ControllerPrincipal control = Principal.getController();
             // control.getVista().toBack();
               jv.setVisible(true);
               
               jv.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
               jv.toFront();
            }           
        } catch (JRException | JRRuntimeException e) {
            JOptionPane.showMessageDialog(principal, "The report could not be opened:"+e);
        }
    }
    public void income(int month,int year,boolean impr){
        try {
        
           // ruta = new File("src/View/Report/invoiceM.jasper");
            URL rut = getClass().getResource("/View/Report/incomemonth.jasper");
            
            report = (JasperReport) JRLoader.loadObject(rut);
            Map param = new HashMap();
            param.clear();
            
            System.out.println(month);
            System.out.println(year);
            month += 1;
            param.put("month", month);
            param.put("year", year);
            param.put("logoimg", this.getClass().getResourceAsStream(logo));
            param.put("totalmonth", this.getClass().getResourceAsStream("/View/Report/totalmonth.jasper"));
            JasperPrint recip = JasperFillManager.fillReport(report, param,conexion.getConec());
            Locale miregion = new Locale("heb","ISR");
            JasperViewer jv = new JasperViewer(recip,false,miregion);
            jv.setAlwaysOnTop(true);
            jv.setAutoRequestFocus(true);
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setResizable(true);
            jv.setTitle("Income of month");

            if(impr){
                boolean imprimio = JRPrinterAWT.printPages(recip,0,0,true);
            }else{
             
              ControllerPrincipal control = Principal.getController();
             // control.getVista().toBack();
               jv.setVisible(true);
               
               jv.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
               jv.toFront();
            }           
        } catch (JRException | JRRuntimeException e) {
            JOptionPane.showMessageDialog(principal, "The report could not be opened:"+e);
        }
    }
    public void customerserved(String fech,boolean impr){
        try {
        
           // ruta = new File("src/View/Report/invoiceM.jasper");
            URL rut = getClass().getResource("/View/Report/reportdaily.jasper");
            
            report = (JasperReport) JRLoader.loadObject(rut);
            Map param = new HashMap();
            param.clear();
            
            
            param.put("fech", fech);
            
            param.put("logo", this.getClass().getResourceAsStream(logo));
            JasperPrint recip = JasperFillManager.fillReport(report, param,conexion.getConec());
            Locale miregion = new Locale("heb","ISR");
            JasperViewer jv = new JasperViewer(recip,false,miregion);
            jv.setAlwaysOnTop(true);
            jv.setAutoRequestFocus(true);
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setResizable(true);
            jv.setTitle("Customers Served of month");

            if(impr){
                boolean imprimio = JRPrinterAWT.printPages(recip,0,0,true);
            }else{
             
              ControllerPrincipal control = Principal.getController();
             // control.getVista().toBack();
               jv.setVisible(true);
               
               jv.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
               jv.toFront();
            }           
        } catch (JRException | JRRuntimeException e) {
            JOptionPane.showMessageDialog(principal, "The report could not be opened:"+e);
        }
    }
    public void incomeDaily(String fech,boolean impr){
        try {
        
           // ruta = new File("src/View/Report/invoiceM.jasper");
            URL rut = getClass().getResource("/View/Report/income.jasper");
            
            report = (JasperReport) JRLoader.loadObject(rut);
            Map param = new HashMap();
            param.clear();
            
            
            param.put("fech", fech);
            param.put("dailytotal", this.getClass().getResourceAsStream("/View/Report/incometotal.jasper"));
            param.put("logoimg", this.getClass().getResourceAsStream(logo));
            JasperPrint recip = JasperFillManager.fillReport(report, param,conexion.getConec());
            Locale miregion = new Locale("heb","ISR");
            JasperViewer jv = new JasperViewer(recip,false,miregion);
            jv.setAlwaysOnTop(true);
            jv.setAutoRequestFocus(true);
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setResizable(true);
            jv.setTitle("Income Daily");

            if(impr){
                boolean imprimio = JRPrinterAWT.printPages(recip,0,0,true);
            }else{
             
              ControllerPrincipal control = Principal.getController();
             // control.getVista().toBack();
               jv.setVisible(true);
               
               jv.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
               jv.toFront();
            }           
        } catch (JRException | JRRuntimeException e) {
            JOptionPane.showMessageDialog(principal, "The report could not be opened:"+e);
        }
    }
    public void customerserved(String pr1, String pr2, boolean impr){
        try {
        
           // ruta = new File("src/View/Report/invoiceM.jasper");
            URL rut = getClass().getResource("/View/Report/reportrank.jasper");
            
            report = (JasperReport) JRLoader.loadObject(rut);
            Map param = new HashMap();
            param.clear();
            
            
            param.put("fech1", pr1);
            param.put("fech2", pr2);
            param.put("logo", this.getClass().getResourceAsStream(logo));
            JasperPrint recip = JasperFillManager.fillReport(report, param,conexion.getConec());
            Locale miregion = new Locale("heb","ISR");
            JasperViewer jv = new JasperViewer(recip,false,miregion);
            jv.setAlwaysOnTop(true);
            jv.setAutoRequestFocus(true);
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setResizable(true);
            jv.setTitle("Customers Served of month");

            if(impr){
                boolean imprimio = JRPrinterAWT.printPages(recip,0,0,true);
            }else{
             
              ControllerPrincipal control = Principal.getController();
             // control.getVista().toBack();
               jv.setVisible(true);
               
               jv.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
               jv.toFront();
            }           
        } catch (JRException | JRRuntimeException e) {
            JOptionPane.showMessageDialog(principal, "The report could not be opened:"+e);
        }
    }
    public void income(String pr1, String pr2, boolean impr){
        try {
        
           // ruta = new File("src/View/Report/invoiceM.jasper");
            URL rut = getClass().getResource("/View/Report/incomerank.jasper");
            
            report = (JasperReport) JRLoader.loadObject(rut);
            Map param = new HashMap();
            param.clear();
            
            
            param.put("fech1", pr1);
            param.put("fech2", pr2);
            param.put("logoimg", this.getClass().getResourceAsStream(logo));
            param.put("ranktotal", this.getClass().getResourceAsStream("/View/Report/ranktotal.jasper"));
            JasperPrint recip = JasperFillManager.fillReport(report, param,conexion.getConec());
            Locale miregion = new Locale("heb","ISR");
            JasperViewer jv = new JasperViewer(recip,false,miregion);
            jv.setAlwaysOnTop(true);
            jv.setAutoRequestFocus(true);
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setResizable(true);
            jv.setTitle("Custom date report");

            if(impr){
                boolean imprimio = JRPrinterAWT.printPages(recip,0,0,true);
            }else{
             
              ControllerPrincipal control = Principal.getController();
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
