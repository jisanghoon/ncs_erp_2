package com.digit.ncs;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MDepPanel extends JPanel implements ActionListener {

	private JFrame mainFrame;

	private JTextField txtNum;
	private JTextField txtDName;
	private JTextField txtFloor;
	private JButton btnAdd;
	private JButton btnCancel;
	private JTable tbl;

	/**
	 * Create the panel.
	 */
	public MDepPanel(JFrame mainFrame) {
		this();
		setDefaultData();
		this.mainFrame = mainFrame;
	}

	public MDepPanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(4, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNum = new JLabel("번호");
		lblNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNum.setBounds(87, 14, 57, 15);
		panel_1.add(lblNum);

		txtNum = new JTextField();
		txtNum.setEditable(false);
		txtNum.setColumns(10);
		txtNum.setBounds(171, 6, 170, 30);
		panel_1.add(txtNum);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblDName = new JLabel("부서명");
		lblDName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDName.setBounds(87, 14, 57, 15);
		panel_2.add(lblDName);

		txtDName = new JTextField();
		txtDName.setColumns(10);
		txtDName.setBounds(171, 6, 170, 30);
		panel_2.add(txtDName);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblFloor = new JLabel("위치");
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFloor.setBounds(87, 14, 57, 15);
		panel_4.add(lblFloor);

		txtFloor = new JTextField();
		txtFloor.setColumns(10);
		txtFloor.setBounds(171, 6, 170, 30);
		panel_4.add(txtFloor);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(5, 0, 5, 0));
		panel.add(panel_3);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel_3.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_3.add(btnCancel);

		JPanel panel_5 = new JPanel();
		add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));

		tbl = new JTable();
		JScrollPane scrollPane = new JScrollPane(tbl);
		panel_5.add(scrollPane);

	}

	private void setDefaultData() {

		setTblDataLoad();
		setDefaultNum();
	}

	private void setDefaultNum() {
		String tmpValue = (String) tbl.getValueAt(tbl.getRowCount() - 1, 0);
		int lastNum = Integer.parseInt(tmpValue.substring(1));
		txtNum.setText(String.format("D%03d", lastNum + 1));
	}

	private void setTblDataLoad() {
		String columnNames[] = { "번호", "부서명", "위치" };
		Object rowData[][] = {
				{ "D001", "마케팅", "10" },
				{ "D002", "개발", "9" },
				{ "D003", "인사", "6" },
				{ "D004", "총무", "7" },
				{ "D005", "경영", "4" } };

		DefaultTableModel tblModel = new DefaultTableModel(rowData, columnNames);
		tbl.setModel(tblModel);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancel) {
			actionPerformedBtnCancel(arg0);
		}
		if (arg0.getSource() == btnAdd) {
			actionPerformedBtnAdd(arg0);
		}
		
	}

	protected void actionPerformedBtnAdd(ActionEvent arg0) {

	}

	protected void actionPerformedBtnCancel(ActionEvent arg0) {
		ControlPanel controlPanel = new ControlPanel(mainFrame);
		ERP_Application frame = (ERP_Application) mainFrame;
		frame.setTitle("대구아이티ERP");
		frame.setSize(360, 110);
		frame.setFrameRelocation();

		JPanel contentPane = (JPanel) getParent();
		contentPane.add(controlPanel);
		contentPane.remove(this);
		contentPane.invalidate();
	}
}
