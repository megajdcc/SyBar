
package Controller;

import View.Vuser;
import View.Vemployee;
import View.Vhaircut;
import View.Vservice;
import View.Vjobtitle;
import View.Vmeeting;
import View.Vworkposition;
//import View.Customers;
//import View.Vmeeting;
//import View.Vhaircut;
//import View.Income;
import View.Begin;
import View.Customers;
import View.Income;
import View.Vperson;
import View.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class ControllerPrincipal implements ActionListener, TreeExpansionListener, TreeSelectionListener {

	public Principal view;
	private Vuser users;
	private Vperson person;
	private Vjobtitle jobtitle;
	private Vworkposition vwork;
	private Vemployee employee;
	private Vservice service;
	private Vhaircut haircut;
	private Vmeeting meeting;
	private Customers customers;
	private Income income;

	public ControllerPrincipal(Principal vist) {
		view = vist;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if (event.equals(view.getExit())) {
			String question = "You want to leave BarberQ?";
			int getOut = JOptionPane.showConfirmDialog(view, question, "Get out", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (getOut == 0) {
				System.exit(0);
			} else {

			}

		} else if (event.equals(view.getClose())) {
			view.dispose();
			Begin start = new Begin();
			start.setVisible(true);
		}
	}

	public Principal getView() {
		return view;
	}


	@Override
    public void valueChanged(TreeSelectionEvent tse) {
          
       String select = view.getMenu().getLastSelectedPathComponent().toString();
       
        if(select.equalsIgnoreCase("Users")){
            
            users = new Vuser(view,true);
            
            users.setVisible(true);
           
            
        }else if(select.equalsIgnoreCase("Persons")){
            person = new Vperson(view,true);
            person.setControllerPerson(new ControllerPerson(person));
             
            person.setVisible(true);
             
        }else if(select.equalsIgnoreCase("Work Position")){
            vwork = new Vworkposition(view,true);
            vwork.setControllerWorkPosition(new ControllerWorkPosition(vwork));
            vwork.setVisible(true);
            
        }else if(select.equalsIgnoreCase("Job Title")){
        	jobtitle = new Vjobtitle(view,true);
            jobtitle.setControllerJobTittle(new ControllerJobTitle(jobtitle));
            jobtitle.setVisible(true);
            
        }else if(select.equalsIgnoreCase("employees")){
            employee = new Vemployee(view,true);
            employee.setControllerEmployee(new ControllerEmployee(employee));
            employee.setVisible(true);
            
        }else if(select.equalsIgnoreCase("Service")){
             service = new Vservice(view,true);
           service.setControllerService(new ControllerService(service));
            service.setVisible(true);
            
        }else if(select.equalsIgnoreCase("Haircut type")){
            haircut = new Vhaircut(view,true);
            haircut.setControllerHaircut(new ControllerHaircut(haircut));
            haircut.setVisible(true);
            
        }else if(select.equalsIgnoreCase("Clients")){
            person = new Vperson(view,true);
            ImageIcon iconp = new ImageIcon(getClass().getResource("/View/img/header/Client.png"));
            person.getHeader().setIcon(iconp);
            person.setTitle("Client");
            person.setController(new ControllerClient(person));
            person.setVisible(true);
            
        }
    else if(select.equalsIgnoreCase("Meetings"))

	{
		meeting = new Vmeeting(view, true);
		meeting.setVisible(true);
	}else if(select.equalsIgnoreCase("Customers service"))
	{
		customers = new Customers(view, false);
		customers.setVisible(true);
	}
	
	else if(select.equalsIgnoreCase("Incomes"))
	{
		income = new Income(view, false);
		income.setVisible(true);
	}
    
	} 

	@Override
    public void treeExpanded(TreeExpansionEvent tee) {
       
    }

	@Override
    public void treeCollapsed(TreeExpansionEvent tee) {
       
    }

}
