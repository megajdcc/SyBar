
package View;

import Controller.ControllerHaircut;
import Controller.ControllerMeeting;

//import Controller.ControllerMeeting;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import java.awt.Color;

public class Vhaircut extends javax.swing.JDialog {

	private ControllerHaircut controllerHaircut;
    private ControllerMeeting controller1;
    public void setController(ControllerMeeting controller){
        this.controller1 = controller;
        setListener(controller1);
    }
    public ControllerMeeting getController1(){
        return controller1;
    }
	
	public void setControllerHaircut(ControllerHaircut controllerHaircut) {
		this.controllerHaircut = controllerHaircut;
		setListener();
	}

	public ControllerHaircut getControllerHaircut() {
		return controllerHaircut;
	}
    private void setListener(ControllerMeeting controller){
    	newBtt.addActionListener(controller);
    	textSearch.addKeyListener(controller);
    	tableHairCut.addMouseListener(controller);
    }
	private void setListener() {
		newBtt.addActionListener(controllerHaircut);
		textSearch.addKeyListener(controllerHaircut);
		tableHairCut.addMouseListener(controllerHaircut);
	}

	public JTextField getTextSearch() {
		return textSearch;
	}

	public void setTextSearch(JTextField textSearch) {
		this.textSearch = textSearch;
	}

	public JTable getTableHairCut() {
		return tableHairCut;
	}

	public void setTableHairCut(JTable tableHairCut) {
		this.tableHairCut = tableHairCut;
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
	 * Creates new form Vhaircut
	 * 
	 * @param parent
	 * @param model
	 */
	public Vhaircut(java.awt.Frame parent, boolean model) {
		super(parent, model);
		variablesForm();
		setTitle("Haircut types");
		setResizable(false);
		setLocationRelativeTo(null);
	}


	private void variablesForm() {

		hairCutPanel = new org.edisoncor.gui.panel.Panel();
		hairCutPanel.setColorSecundario(Color.WHITE);
		hairCutPanel.setForeground(Color.WHITE);
		header = new org.edisoncor.gui.panel.Panel();
		center = new javax.swing.JPanel();
		jPanelSearch = new javax.swing.JPanel();
		textSearch = new javax.swing.JTextField();
		jPanelChoosing = new javax.swing.JPanel();
		newBtt = new javax.swing.JButton();
		tableHairCutPanel = new javax.swing.JPanel();
		jScrollPanetableHairCut = new javax.swing.JScrollPane();
		tableHairCut = new javax.swing.JTable();
		footer = new javax.swing.JPanel();
		comment = new javax.swing.JLabel();
		getContentPane().setLayout(new java.awt.CardLayout());

		hairCutPanel.setMaximumSize(new java.awt.Dimension(440, 451));
		hairCutPanel.setPreferredSize(new java.awt.Dimension(440, 451));
		hairCutPanel.setLayout(new java.awt.BorderLayout());

		header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/Haircut_Type.jpg"))); 
		header.setMaximumSize(new java.awt.Dimension(464, 75));
		header.setOpaque(false);
		header.setPreferredSize(new java.awt.Dimension(464, 75));

		javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
		header.setLayout(headerLayout);
		headerLayout.setHorizontalGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 440, Short.MAX_VALUE));
		headerLayout.setVerticalGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));

		hairCutPanel.add(header, java.awt.BorderLayout.NORTH);

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
				textSearchFocusGained(evt);
			}
		});
		textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				textSearchKeyTyped(evt);
			}
		});
		jPanelSearch.add(textSearch);

		center.add(jPanelSearch, java.awt.BorderLayout.NORTH);

		jPanelChoosing.setOpaque(false);
		jPanelChoosing.setPreferredSize(new java.awt.Dimension(448, 30));
		jPanelChoosing.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

		newBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/new.png"))); 
		newBtt.setBorderPainted(false);
		newBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		newBtt.setDefaultCapable(false);
		newBtt.setFocusPainted(false);
		newBtt.setMaximumSize(new java.awt.Dimension(150, 30));
		newBtt.setMinimumSize(new java.awt.Dimension(150, 30));
		newBtt.setOpaque(false);
		newBtt.setPreferredSize(new java.awt.Dimension(150, 30));
		newBtt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newBttActionPerformed(evt);
			}
		});
		jPanelChoosing.add(newBtt);

		center.add(jPanelChoosing, java.awt.BorderLayout.SOUTH);
		exitBtt = new javax.swing.JButton();

		exitBtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/exit.png"))); 
		exitBtt.setBorderPainted(false);
		exitBtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		exitBtt.setDefaultCapable(false);
		exitBtt.setFocusPainted(false);
		exitBtt.setMaximumSize(new java.awt.Dimension(150, 30));
		exitBtt.setMinimumSize(new java.awt.Dimension(150, 30));
		exitBtt.setOpaque(false);
		exitBtt.setPreferredSize(new java.awt.Dimension(150, 30));
		exitBtt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitBttActionPerformed(evt);
			}
		});
		jPanelChoosing.add(exitBtt);

		tableHairCutPanel.setOpaque(false);
		tableHairCutPanel.setLayout(new java.awt.BorderLayout());

		jScrollPanetableHairCut.setOpaque(false);
		jScrollPanetableHairCut.setPreferredSize(new java.awt.Dimension(400, 403));

		tableHairCut.setFont(new java.awt.Font("Times New Roman", 0, 18)); 
		tableHairCut.setForeground(new java.awt.Color(0, 0, 0));
		tableHairCut
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null } },
						new String[] { "Style", "Price", "Gender" }) {
					boolean[] canEdit = new boolean[] { false, false, false };

					public boolean isCellEditable(int rowIndex, int columnIndex) {
						return canEdit[columnIndex];
					}
				});
		tableHairCut.setToolTipText("Users");
		tableHairCut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		tableHairCut.setOpaque(false);
		tableHairCut.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				tableHairCutKeyReleased(evt);
			}

			public void keyTyped(java.awt.event.KeyEvent evt) {
				tableHairCutKeyTyped(evt);
			}
		});
		jScrollPanetableHairCut.setViewportView(tableHairCut);

		tableHairCutPanel.add(jScrollPanetableHairCut, java.awt.BorderLayout.CENTER);

		center.add(tableHairCutPanel, java.awt.BorderLayout.CENTER);

		hairCutPanel.add(center, java.awt.BorderLayout.CENTER);

		footer.setBackground(new java.awt.Color(0, 102, 255));
		footer.setOpaque(false);
		footer.setPreferredSize(new java.awt.Dimension(0, 30));
		footer.setLayout(new java.awt.BorderLayout());

		comment.setFont(new java.awt.Font("Serif", 2, 14)); 
		comment.setForeground(new java.awt.Color(0, 0, 0));
		footer.add(comment, java.awt.BorderLayout.CENTER);

		hairCutPanel.add(footer, java.awt.BorderLayout.SOUTH);

		getContentPane().add(hairCutPanel, "card2");

		pack();
	}

	private void textSearchFocusGained(java.awt.event.FocusEvent evt) {
		String text = "Find the type of cut you want";
		getComment().setText(text);
	}

	private void textSearchKeyTyped(java.awt.event.KeyEvent evt) {
		
	}
		

	private void newBttActionPerformed(java.awt.event.ActionEvent evt) {
		
	}

	private void exitBttActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	private void tableHairCutKeyReleased(java.awt.event.KeyEvent evt) {
		
	}

	private void tableHairCutKeyTyped(java.awt.event.KeyEvent evt) {
		
	}
	
	private javax.swing.JTextField textSearch;
	private org.edisoncor.gui.panel.Panel hairCutPanel;
	private javax.swing.JTable tableHairCut;
	private javax.swing.JPanel tableHairCutPanel;
	private javax.swing.JPanel center;
	private javax.swing.JButton exitBtt;
	private javax.swing.JPanel footer;
	private org.edisoncor.gui.panel.Panel header;
	private javax.swing.JPanel jPanelChoosing;
	private javax.swing.JPanel jPanelSearch;
	private javax.swing.JScrollPane jScrollPanetableHairCut;
	private javax.swing.JLabel comment;
	private javax.swing.JButton newBtt;
	

}
