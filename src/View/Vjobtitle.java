package View;

import Controller.ControllerEmployee;
import Controller.ControllerJobTitle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class Vjobtitle extends javax.swing.JDialog {

	private ControllerJobTitle controllerJobTittle;
	private ControllerEmployee controllerEmployee;

	public void setControllerJobTittle(ControllerJobTitle controllerJobTittle) {
		this.controllerJobTittle = controllerJobTittle;
		setListener(controllerJobTittle);
	}

	public ControllerJobTitle getControllerJobTittle() {
		return controllerJobTittle;
	}

	private void setListener(ControllerJobTitle controllerJobTittle) {
		newBtt.addActionListener(controllerJobTittle);
		exitBtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
				setVisible(false);
			}
		});
		tabelJobTittle.addMouseListener(controllerJobTittle);
		getTextSearch().addKeyListener(controllerJobTittle);
	}

	private void setListener(ControllerEmployee controllerEmployee) {
		newBtt.addActionListener(controllerEmployee);
		exitBtt.addActionListener(controllerEmployee);

		tabelJobTittle.addMouseListener(controllerEmployee);
		getTextSearch().addKeyListener(controllerEmployee);
	}

	public void setController(ControllerEmployee controllerEmployee) {
		this.controllerEmployee = controllerEmployee;
		setListener(controllerEmployee);
	}

	public ControllerEmployee getControllerEmployee() {
		return controllerEmployee;
	}

	public JTextField getTextSearch() {
		return textSearch;
	}

	public void setTextSearch(JTextField textSearch) {
		this.textSearch = textSearch;
	}

	public JTable getTabelJobTittle() {
		return tabelJobTittle;
	}

	public void setTabelJobTittle(JTable tabelJobTittle) {
		this.tabelJobTittle = tabelJobTittle;
	}

	public JButton getExitBtt() {
		return exitBtt;
	}

	public void setExitBtt(JButton exitBtt) {
		this.exitBtt = exitBtt;
	}

	public JLabel getComment() {
		return comment;
	}

	public void setComment(JLabel comment) {
		this.comment = comment;
	}

	public JButton getNewBtt() {
		return newBtt;
	}

	public void setNewBtt(JButton newBtt) {
		this.newBtt = newBtt;
	}

	/**
	 * Creates new form Vjobtitle
	 * 
	 * @param parent
	 * @param model
	 */
	public Vjobtitle(java.awt.Frame parent, boolean model) {
		super(parent, model);
		variablesForm();
		setTitle("Job Title");
		setResizable(false);
		setLocationRelativeTo(null);


	}


	private void variablesForm() {

		jobTittlePanel = new org.edisoncor.gui.panel.Panel();
		jobTittlePanel.setColorSecundario(Color.WHITE);
		jobTittlePanel.setForeground(Color.WHITE);
		header = new org.edisoncor.gui.panel.Panel();
		header.setColorSecundario(Color.WHITE);
		header.setForeground(Color.WHITE);
		footer = new javax.swing.JPanel();
		comment = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new java.awt.CardLayout());

	
		jobTittlePanel.setMaximumSize(new java.awt.Dimension(440, 451));
		jobTittlePanel.setPreferredSize(new java.awt.Dimension(440, 451));
		jobTittlePanel.setLayout(new java.awt.BorderLayout());

		header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/Job_Title.jpg"))); 
		header.setMaximumSize(new java.awt.Dimension(464, 75));
		header.setOpaque(false);
		header.setPreferredSize(new java.awt.Dimension(464, 75));

		javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
		header.setLayout(headerLayout);
		headerLayout.setHorizontalGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 440, Short.MAX_VALUE));
		headerLayout.setVerticalGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 75, Short.MAX_VALUE));

		jobTittlePanel.add(header, java.awt.BorderLayout.NORTH);
		center = new javax.swing.JPanel();
		jPanelSearch = new javax.swing.JPanel();
		textSearch = new javax.swing.JTextField();
		jPanelTabel = new javax.swing.JPanel();
		jScrollPanetTabel = new javax.swing.JScrollPane();
		tabelJobTittle = new javax.swing.JTable();
		jPanelCoosing = new javax.swing.JPanel();


		center.setOpaque(false);
		center.setLayout(new java.awt.BorderLayout(0, 10));

		jPanelSearch.setForeground(new java.awt.Color(0, 0, 0));
		jPanelSearch.setOpaque(false);
		jPanelSearch.setPreferredSize(new java.awt.Dimension(442, 40));
		jPanelSearch.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 2));

		textSearch.setForeground(new java.awt.Color(0, 0, 0));
		textSearch.setPreferredSize(new java.awt.Dimension(400, 37));
		textSearch.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				TextGetCommentFocusGained(evt);
			}
		});
		textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				TextGetCommentKeyTyped(evt);
			}
		});
		jPanelSearch.add(textSearch);

		center.add(jPanelSearch, java.awt.BorderLayout.NORTH);

		jPanelTabel.setOpaque(false);
		jPanelTabel.setLayout(new java.awt.BorderLayout());

		jScrollPanetTabel.setOpaque(false);
		jScrollPanetTabel.setPreferredSize(new java.awt.Dimension(400, 403));

		tabelJobTittle.setFont(new java.awt.Font("Times New Roman", 0, 18)); 
		tabelJobTittle.setForeground(new java.awt.Color(0, 0, 0));
		tabelJobTittle.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null } },
				new String[] { "Name", "Position" }) {
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tabelJobTittle.setToolTipText("Users");
		tabelJobTittle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		tabelJobTittle.setOpaque(false);
		tabelJobTittle.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				tabelJobTittleKeyReleased(evt);
			}

			public void keyTyped(java.awt.event.KeyEvent evt) {
				tabelJobTittleKeyTyped(evt);
			}
		});
		newBtt = new javax.swing.JButton();
		exitBtt = new javax.swing.JButton();

		jPanelCoosing.setOpaque(false);
		jPanelCoosing.setPreferredSize(new java.awt.Dimension(448, 30));
		jPanelCoosing.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

		newBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/new.png"))); 
		newBtt.setBorderPainted(false);
		newBtt.setContentAreaFilled(false);
		newBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		newBtt.setFocusPainted(false);
		newBtt.setMaximumSize(new java.awt.Dimension(150, 30));
		newBtt.setMinimumSize(new java.awt.Dimension(150, 30));
		newBtt.setPreferredSize(new java.awt.Dimension(150, 30));
		newBtt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				NewBttActionPerformed(evt);
			}
		});
		jPanelCoosing.add(newBtt);

		exitBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/exit.png"))); 
		exitBtt.setBorderPainted(false);
		exitBtt.setContentAreaFilled(false);
		exitBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		exitBtt.setFocusPainted(false);
		exitBtt.setMaximumSize(new java.awt.Dimension(150, 30));
		exitBtt.setMinimumSize(new java.awt.Dimension(150, 30));
		exitBtt.setPreferredSize(new java.awt.Dimension(150, 30));
		exitBtt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitActionPerformed(evt);
			}
		});
		jPanelCoosing.add(exitBtt);

		center.add(jPanelCoosing, java.awt.BorderLayout.SOUTH);
		jScrollPanetTabel.setViewportView(tabelJobTittle);

		jPanelTabel.add(jScrollPanetTabel, java.awt.BorderLayout.CENTER);

		center.add(jPanelTabel, java.awt.BorderLayout.CENTER);

		jobTittlePanel.add(center, java.awt.BorderLayout.CENTER);

		footer.setBackground(new java.awt.Color(0, 102, 255));
		footer.setOpaque(false);
		footer.setPreferredSize(new java.awt.Dimension(0, 30));
		footer.setLayout(new java.awt.BorderLayout());

		comment.setFont(new Font("Serif", Font.ITALIC, 16)); 
		comment.setForeground(new java.awt.Color(0, 0, 0));
		footer.add(comment, java.awt.BorderLayout.CENTER);

		jobTittlePanel.add(footer, java.awt.BorderLayout.SOUTH);

		getContentPane().add(jobTittlePanel, "card2");

		pack();
	}

	private void TextGetCommentFocusGained(java.awt.event.FocusEvent evt) {
		String text = "Search job Tittle window";
		getComment().setText(text);
	}

	private void TextGetCommentKeyTyped(java.awt.event.KeyEvent evt) {
		
	}


	private void NewBttActionPerformed(java.awt.event.ActionEvent evt) {
		
	}

	private void exitActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	private void tabelJobTittleKeyReleased(java.awt.event.KeyEvent evt) {
		
	}

	private void tabelJobTittleKeyTyped(java.awt.event.KeyEvent evt) {
		
	}

	private javax.swing.JTextField textSearch;
	private org.edisoncor.gui.panel.Panel jobTittlePanel;
	private javax.swing.JTable tabelJobTittle;
	private javax.swing.JPanel jPanelTabel;
	private javax.swing.JPanel center;
	private javax.swing.JButton exitBtt;
	private javax.swing.JPanel footer;
	private org.edisoncor.gui.panel.Panel header;
	private javax.swing.JPanel jPanelCoosing;
	private javax.swing.JPanel jPanelSearch;
	private javax.swing.JScrollPane jScrollPanetTabel;
	private javax.swing.JLabel comment;
	private javax.swing.JButton newBtt;

}
