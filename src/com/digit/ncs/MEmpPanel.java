package com.digit.ncs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MEmpPanel extends JPanel implements ActionListener {

	private JFrame mainFrame;
	private JTextField txtNum;
	private JTextField txtName;
	private JTextField txtJoin;
	private JComboBox<String> comboTitle;
	private JSpinner spinSalary;
	private JRadioButton radioM;
	private JRadioButton radioW;
	private JComboBox<String> comboDep;
	private JTable tbl;
	private JButton btnCancel;
	private JButton btnAdd;

	/**
	 * Create the panel.
	 */
	public MEmpPanel(JFrame mainFrame) {
		// TODO Auto-generated constructor stub
		this();
		this.mainFrame = mainFrame;
	}

	public MEmpPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(15, 0, 0, 0));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel row1_1 = new JPanel();
		panel.add(row1_1);
		row1_1.setLayout(null);

		JLabel lblNum = new JLabel("번호");
		lblNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNum.setBounds(182, 13, 57, 15);
		row1_1.add(lblNum);

		txtNum = new JTextField();
		txtNum.setEditable(false);
		txtNum.setBounds(279, 6, 170, 30);
		row1_1.add(txtNum);
		txtNum.setColumns(10);

		JPanel row1_2 = new JPanel();
		panel.add(row1_2);
		row1_2.setLayout(null);

		JLabel lblName = new JLabel("사원명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(182, 14, 57, 15);
		row1_2.add(lblName);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(279, 6, 170, 30);
		row1_2.add(txtName);

		JPanel row1_3 = new JPanel();
		panel.add(row1_3);
		row1_3.setLayout(null);

		JLabel lblTitle = new JLabel("직책");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setBounds(182, 14, 57, 15);
		row1_3.add(lblTitle);

		comboTitle = new JComboBox<>();
		comboTitle.setBounds(279, 6, 170, 30);
		row1_3.add(comboTitle);

		JPanel row1_4 = new JPanel();
		panel.add(row1_4);
		row1_4.setLayout(null);

		JLabel lblSalary = new JLabel("급여");
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalary.setBounds(182, 14, 57, 15);
		row1_4.add(lblSalary);

		spinSalary = new JSpinner();
		spinSalary.setBounds(279, 6, 170, 30);
		row1_4.add(spinSalary);

		JPanel row1_5 = new JPanel();
		panel.add(row1_5);
		row1_5.setLayout(null);

		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setBounds(182, 14, 57, 15);
		row1_5.add(lblGender);

		ButtonGroup rgroup = new ButtonGroup();
		radioM = new JRadioButton("남");

		radioM.setBounds(307, 10, 44, 23);
		row1_5.add(radioM);

		radioW = new JRadioButton("여");
		radioW.setBounds(355, 10, 44, 23);
		row1_5.add(radioW);

		rgroup.add(radioM);
		rgroup.add(radioW);

		JPanel row1_6 = new JPanel();
		panel.add(row1_6);
		row1_6.setLayout(null);

		JLabel lblDep = new JLabel("부서");
		lblDep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDep.setBounds(182, 14, 57, 15);
		row1_6.add(lblDep);

		comboDep = new JComboBox<>();
		comboDep.setBounds(279, 6, 170, 30);
		row1_6.add(comboDep);

		JPanel row1_7 = new JPanel();
		panel.add(row1_7);
		row1_7.setLayout(null);

		JLabel lblJoin = new JLabel("입사일");
		lblJoin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJoin.setBounds(182, 14, 57, 15);
		row1_7.add(lblJoin);

		txtJoin = new JTextField();
		txtJoin.setColumns(10);
		txtJoin.setBounds(279, 6, 170, 30);
		row1_7.add(txtJoin);

		JPanel row2 = new JPanel();
		row2.setBorder(new EmptyBorder(5, 0, 5, 0));
		panel.add(row2);
		row2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		row2.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		row2.add(btnCancel);

		JPanel row3 = new JPanel();
		row3.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(row3);
		row3.setLayout(new BorderLayout(0, 0));
		tbl = new JTable();

		JScrollPane scrollPane = new JScrollPane(tbl);
		row3.add(scrollPane, BorderLayout.CENTER);

		setDefaultData();

	}

	private void setDefaultData() {

		SpinnerModel spinnerModel = new SpinnerNumberModel(1500000, 1000000, 5000000, 100000);
		spinSalary.setModel(spinnerModel);

		radioM.setSelected(true);

		txtJoin.setText(changeDateFormat(new Date()));

		setCmbTitleDataLoad();
		setCmbDepDataLoad();
		setTblDataLoad();
		setDefaultNum();
	}

	private void setDefaultNum() {
		String tmpValue = (String) tbl.getValueAt(tbl.getRowCount() - 1, 0);
		int lastNum = Integer.parseInt(tmpValue.substring(4));
		txtNum.setText(String.format("E017%04d", lastNum + 1));
	}

	private void setTblDataLoad() {
		String columnNames[] = { "번호", "사원명", "직책", "급여", "성별", "부서", "입사일" };
		Object rowData[][] = {

				{ "E017001", "나사장", "사장", "5000000", "남자", "경영(4층)", "2017-03-01" },
				{ "E017002", "나부장", "부장", "4000000", "남자", "마케팅(10층)", "2017-03-01" },
				{ "E017003", "너부장", "부장", "4000000", "여자", "개발(9층)", "2017-03-01" },
				{ "E017004", "나과장", "과장", "3500000", "남자", "마케팅(10층)", "2017-03-01" },
				{ "E017005", "너과장", "과장", "3500000", "여자", "개발(9층)", "2017-03-01" },
				{ "E017006", "나대리", "대리", "3000000", "남자", "마케팅(10층)", "2017-03-01" },
				{ "E017007", "너대리", "대리", "3000000", "여자", "개발(9층)", "2017-03-01" },
				{ "E017008", "나사원", "사원", "2500000", "남자", "마케팅(10층)", "2017-03-01" },
				{ "E017009", "너사원", "사원", "2500000", "여자", "개발(9층)", "2017-03-01" },
				{ "E017010", "니사원", "사원", "2500000", "남자", "마케팅(10층)", "2017-03-01" }

		};

		DefaultTableModel tblModel = new DefaultTableModel(rowData, columnNames);
		tbl.setModel(tblModel);

	}

	private void setCmbDepDataLoad() {
		comboDep.addItem("마케팅");
		comboDep.addItem("개발");
		comboDep.addItem("인사");
		comboDep.addItem("총무");
		comboDep.addItem("경영");

	}

	private void setCmbTitleDataLoad() {
		comboTitle.addItem("사장");
		comboTitle.addItem("부장");
		comboTitle.addItem("과장");
		comboTitle.addItem("대리");
		comboTitle.addItem("사원");

	}

	private String changeDateFormat(Date date) {
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dFormat.format(new Date());
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAdd) {
			actionPerformedBtnAdd(arg0);
		}
		if (arg0.getSource() == btnCancel) {
			actionPerformedBtnCancel(arg0);
		}

	}

	protected void actionPerformedBtnAdd(ActionEvent arg0) {
		System.out.println(getParent().getName());
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
