
package Controller;

import View.Vemployee;
import View.Vjobtitle;
import View.Remployee;
import View.Vperson;
import View.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Model.*;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ControllerEmployee implements ActionListener, MouseListener, KeyListener {

	DefaultTableModel dm;
	private Vemployee emp;
	private Employee model;
	private Remployee employee;
	private Principal principal;
	private JobTitle modelJob;
	private Vperson person;
	private Vjobtitle job;
	private Person modelPerson;

	public ControllerEmployee(Vemployee v) {
		this.emp = v;
		model = new Employee();
		modelPerson = new Person();
		modelJob = new JobTitle();
		person = new Vperson(principal, true);
		job = new Vjobtitle(principal, true);
		employee = new Remployee(principal, true);

		this.Tolist(1);
	}

	private void Tolist(int list) {
		if (list == 1) {
			String[][] info = model.resultList();
			emp.getEmployeeTable().setModel(
					new javax.swing.table.DefaultTableModel(info, new String[] { "Phone", "Name", "Last Name" }) {
						boolean[] canEdit = new boolean[] { false, false, false };

						@Override
						public boolean isCellEditable(int rowIndex, int columnIndex) {
							return canEdit[columnIndex];
						}
					});
			emp.getEmployeeTable().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		} else if (list == 2) {

			String[][] info = modelPerson.resultList();
			person.getTablePerson().setModel(
					new javax.swing.table.DefaultTableModel(info, new String[] { "Phone", "Name", "Last Name" }) {
						boolean[] canEdit = new boolean[] { false, false, false };

						@Override
						public boolean isCellEditable(int rowIndex, int columnIndex) {
							return canEdit[columnIndex];
						}
					});
			person.getTablePerson().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		} else {
			String[][] info = modelJob.resultList();
			job.getTabelJobTittle()
					.setModel(new javax.swing.table.DefaultTableModel(info, new String[] { "Job Title", "Position" }) {
						boolean[] canEdit = new boolean[] { false, false };

						@Override
						public boolean isCellEditable(int rowIndex, int columnIndex) {
							return canEdit[columnIndex];
						}
					});
			job.getTabelJobTittle().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		}

	}

	public void searchList(String query, JTable jTableSearch) {

		dm = (DefaultTableModel) jTableSearch.getModel();
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
		jTableSearch.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(query));
	}

	public void captureData(long phoneEmployee, String check) {

		if (check.equalsIgnoreCase("Employee")) {
			boolean found = model.matchingModel(phoneEmployee);
			if (found) {
				emp.setVisible(false);
				emp.dispose();
				employee.getId().setText(String.valueOf(model.getId()));
				employee.getNamePerson().setText(model.getName());
				employee.getLastname().setText(model.getLastname());
				employee.getPhone().setText(String.valueOf(model.getPhone()));

				char gender = model.getGender();
				if (gender == 'M') {
					employee.getMale().setSelected(true);
				} else if (gender == 'F') {
					employee.getFemale().setSelected(true);
				}
				int jobId = model.getJobId();
				modelJob = new JobTitle();
				String jobName = modelJob.checkName(jobId);

				employee.getJobtitle().setText(jobName);
				employee.getDelete().setVisible(true);
				employee.getSearchJob().setEnabled(true);
				employee.setControllerEmployee(this);

				employee.setVisible(true);

			} else {

				JOptionPane.showMessageDialog(principal, "Record not found", "Employee",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

	public void captureData(String name) {

		boolean found = modelJob.matchingModel(name);
		if (found) {
			job.dispose();
			job.setVisible(false);

			employee.getJobtitle().setText(modelJob.getJobName());

		} else {

			JOptionPane.showMessageDialog(new JFrame(), "Record not found", "Employee",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();

		if (event.equals(employee.getExit())) {

			employee.dispose();
			employee.setVisible(false);
			emp = new Vemployee(principal, true);
			emp.setControllerEmployee(this);
			Tolist(1);
			emp.setVisible(true);
		} else if (event.equals(employee.getDelete())) {

			this.delete();
		} else if (event.equals(employee.getRegister())) {
			this.validate();
		} else if (event.equals(emp.getNewBtt())) {
			emp.dispose();
			emp.setVisible(false);

			employee = new Remployee(principal, true);
			employee.setControllerEmployee(this);
			model.setId(0);
			employee.getDelete().setVisible(false);

			employee.setVisible(true);
		} else if (event.equals(employee.getSearchJob())) {
			job.setController(this);
			this.Tolist(3);
			job.getNewBtt().setEnabled(false);
			job.setVisible(true);
		}
	}

	private void validate() {
		if (employee.getNamePerson().getText().length() < 2) {
			String err = "Verify that the name is not empty and that it contains no less than  2 characters";
			employee.getComment().setText(err);
			employee.getComment().setForeground(Color.RED);
		} else if (employee.getLastname().getText().length() < 2) {
			String err = "Verify that the surname is not empty and that it does not contain less than 2 characters";
			employee.getComment().setText(err);
			employee.getComment().setForeground(Color.RED);
			employee.getLastname().setFocusable(true);
		} else if (!employee.getGender().isSelected(employee.getMale().getModel())
				&& !employee.getGender().isSelected(employee.getFemale().getModel())) {
			String err = "You must select a gender";
			employee.getComment().setText(err);
			employee.getMale().setFocusable(true);
		} else if (employee.getPhone().getText().trim().length() < 7) {
			String err = "Verify the phone number";
			employee.getComment().setText(err);
			employee.getComment().setForeground(Color.RED);

		} else if (employee.getJobtitle().getText().isEmpty()) {
			String err = "Must select a profession to the employee";
			employee.getComment().setText(err);
		} else {
			record();
		}
	}

	private void record() {
		long dn = model.getId();

		if (dn > 0) {

			model.setName(employee.getNamePerson().getText());
			model.setLastname(employee.getLastname().getText());
			model.setPhone(Long.parseLong(employee.getPhone().getText()));
			char gend = this.captureGender(employee.getGender()).charAt(0);
			System.out.println(gend);
			model.setGender(gend);
			int idjob = modelJob.checkId(employee.getJobtitle().getText());
			model.setJobId(idjob);
			boolean result = model.updateEmployee();
			if (result) {
				String success = "The employee has been successfully modified " + model.getName() + " "
						+ model.getLastname();
				employee.getComment().setText(success);
			}
		} else if (model.getId() < 1) {
			if (model.verify(Long.parseLong(employee.getPhone().getText()))) {
				String err = "Can not register an employee who is already employed";
				employee.getComment().setText(err);
			} else {
				model.setName(employee.getNamePerson().getText());
				model.setLastname(employee.getLastname().getText());
				model.setPhone(Long.parseLong(employee.getPhone().getText()));
				char gend = this.captureGender(employee.getGender()).charAt(0);

				model.setGender(gend);
				int jobId = modelJob.checkId(employee.getJobtitle().getText());

				model.setJobId(jobId);

				boolean result = model.insertEmployee();
				if (result) {
					String success = "The employee has been successfully  registered " + model.getName() + " "
							+ model.getLastname();
					employee.getComment().setText(success);
				}
			}

		} else {
			String err = "The employee hasn't registered";
			employee.getComment().setText(err);
		}

	}

	private String captureGender(ButtonGroup btn) {
		String gender = null;

		for (Enumeration<AbstractButton> buttons = btn.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				gender = button.getText();

			}
		}
		return gender;
	}

	private void delete() {
		boolean result = model.delete();
		if (result) {
			employee.setVisible(false);
			employee.dispose();
			emp = new Vemployee(principal, true);
			Tolist(1);
			emp.setControllerEmployee(this);
			emp.setVisible(true);

		} else {
			String err = "The employee could not be deleted ";
			employee.getComment().setText(err);
		}
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		Object mouseEvent = me.getSource();
		if (mouseEvent.equals(emp.getEmployeeTable())) {
			if (me.getClickCount() == 2) {
				try {
					int row = emp.getEmployeeTable().getSelectedRow();
					int row1 = emp.getEmployeeTable().convertRowIndexToModel(row);
					DefaultTableModel tableModel = (DefaultTableModel) emp.getEmployeeTable().getModel();
					long capture = Long.parseLong((String) tableModel.getValueAt(row1, 0));
					captureData(capture, "employee");
				} catch (HeadlessException ex) {
					System.out.println("Error: " + ex);
				}
			}
		} else if (mouseEvent.equals(person.getTablePerson())) {
			if (me.getClickCount() == 2) {
				try {
					int fila = person.getTablePerson().getSelectedRow();
					int fila1 = person.getTablePerson().convertRowIndexToModel(fila);
					DefaultTableModel modelotabla = (DefaultTableModel) person.getTablePerson().getModel();
					Long captura = Long.parseLong((String) modelotabla.getValueAt(fila1, 0));
					captureData(captura, "person");
				} catch (HeadlessException ex) {
					System.out.println("Error: " + ex);
				}
			}
		} else if (mouseEvent.equals(job.getTabelJobTittle())) {
			if (me.getClickCount() == 2) {
				try {
					int row = job.getTabelJobTittle().getSelectedRow();
					int row1 = job.getTabelJobTittle().convertRowIndexToModel(row);
					DefaultTableModel tableModel = (DefaultTableModel) job.getTabelJobTittle().getModel();
					String capture = (String) tableModel.getValueAt(row1, 0);
					captureData(capture);
				} catch (HeadlessException ex) {
					System.out.println("Error: " + ex);
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
		Object keyEvent = ke.getSource();
		if (keyEvent.equals(emp.getTextSearch())) {
			if (emp.getTextSearch().getText().length() > 50) {
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
		if (origin.equals(emp.getTextSearch())) {
			String search = emp.getTextSearch().getText();
			searchList(search, emp.getEmployeeTable());
		} else if (origin.equals(person.getTextSearch())) {
			String busqueda = person.getTextSearch().getText();
			searchList(busqueda, person.getTablePerson());
		} else if (origin.equals(job.getTextSearch())) {
			String busqueda = job.getTextSearch().getText();
			searchList(busqueda, job.getTabelJobTittle());
		}
	}

}
