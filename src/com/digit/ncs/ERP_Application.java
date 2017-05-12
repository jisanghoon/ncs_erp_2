package com.digit.ncs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ERP_Application extends JFrame {

	private JPanel contentPane;

	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ERP_Application frame = new ERP_Application();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ERP_Application() {
		// ----> Begin --> Frame Basic Setting
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// ----> Finish --> Frame Basic Setting

		// ----> Begin --> Panel ControlPanel (Default)
		ControlPanel controlPanel = new ControlPanel(ERP_Application.this);
		contentPane.add(controlPanel);

		// ----> Finish --> Panel ControlPanel
		setTitle("대구아이티ERP");
		setSize(360, 110);
		 setResizable(false);
		setFrameRelocation();
	}

	public void setFrameRelocation() {

		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - getSize().width) / 2, (windowSize.height - getSize().height) / 2);
	}

}
