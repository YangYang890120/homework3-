package controller;
import java.awt.Image;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import dao.impl.EmployeeDaoImpl;
import model.Employee;
import service.impl.EmployeeServiceImpl;
import util.cal;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ManageSystem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected ManageSystem pos_system;
	private EmployeeServiceImpl esi=new EmployeeServiceImpl();
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JPanel main_panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageSystem frame = new ManageSystem();
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
	public static void updateTime(JLabel time)
	{
		LocalDateTime localtime=LocalDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss a");
		String FDT=localtime.format(dtf);
		time.setText(FDT);					
	}
	public ManageSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1239, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1221, 550);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		main_panel = new JPanel();
		main_panel.setBackground(new Color(255, 255, 255));
		main_panel.setBounds(247, 60, 950, 462);
		panel.add(main_panel);
		main_panel.setLayout(null);
	
		main_panel.removeAll();
		main_panel.repaint();
		main_panel.revalidate();
		main_panel.setVisible(false);
		main_panel.repaint();
		main_panel.revalidate();
		
		Object o=cal.ReadObiect("Employee.txt");
		Employee m=(Employee)o;
		JLabel username = new JLabel("歡迎登入:"+m.getName()+"   職位:"+m.getPosition());
		username.setForeground(new Color(255, 255, 255));
		username.setFont(new Font("新細明體", Font.BOLD, 18));
		username.setBounds(60, 15, 315, 31);
		panel.add(username);
		
		JLabel lblNewLabel = new JLabel("OO倉儲管理系統");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 24));
		lblNewLabel.setBounds(553, 10, 208, 40);
		panel.add(lblNewLabel);
		
		JLabel time = new JLabel("");
		time.setForeground(new Color(255, 255, 255));
		time.setFont(new Font("新細明體", Font.PLAIN, 16));
		Timer timer=new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				pos_system.updateTime(time);
			}
		});
		timer.start();
		time.setBounds(997, 19, 200, 31);
		panel.add(time);
		
		btnNewButton = new JButton("員工管理");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(m.getPosition().equals("員工"))
				{
					
					JOptionPane.showMessageDialog(contentPane, "權限不足,只有經理及總經理才可修改", "錯誤", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_panel.setVisible(true);
				main_panel.removeAll();
		        main_panel.repaint();
		        main_panel.revalidate();
		        main_panel.add(new EmployeeUi().employeePane);
		        main_panel.repaint();
		        main_panel.revalidate();
			}
		});
		btnNewButton.setBounds(60, 60, 138, 31);
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 18));
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("會員管理");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(m.getPosition().equals("員工"))
				{
					
					JOptionPane.showMessageDialog(contentPane, "權限不足,只有經理及總經理才可修改", "錯誤", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_panel.setVisible(true);
				main_panel.removeAll();
		        main_panel.repaint();
		        main_panel.revalidate();
		        main_panel.add(new MemberUi().panel);
		        main_panel.repaint();
		        main_panel.revalidate();
			}
		});
		if(m.getPosition().equals("員工"))
		{
			btnNewButton.setEnabled(false);
			btnNewButton_1.setEnabled(false);
			//JOptionPane.showMessageDialog(this, "權限不足,只有經理及總經理才可修改", "錯誤", JOptionPane.ERROR_MESSAGE);
		}
		btnNewButton_1.setBounds(60, 120, 138, 31);
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 18));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("庫存資料");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_panel.setVisible(true);
				main_panel.removeAll();
		        main_panel.repaint();
		        main_panel.revalidate();
		        main_panel.add(new ProductUi().panel);
		        main_panel.repaint();
		        main_panel.revalidate();
			}
		});
		btnNewButton_2.setBounds(60, 180, 138, 31);
		btnNewButton_2.setFont(new Font("新細明體", Font.BOLD, 18));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("出貨資料");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_panel.setVisible(true);
				main_panel.removeAll();
		        main_panel.repaint();
		        main_panel.revalidate();
		        main_panel.add(new OrderUi().panel);
		        main_panel.repaint();
		        main_panel.revalidate();
			}
		});
		btnNewButton_3.setBounds(60, 240, 138, 31);
		btnNewButton_3.setFont(new Font("新細明體", Font.BOLD, 18));
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("進貨資料");
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_panel.setVisible(true);
				main_panel.removeAll();
		        main_panel.repaint();
		        main_panel.revalidate();
		        main_panel.add(new PurchaseUi().panel);
		        main_panel.repaint();
		        main_panel.revalidate();
			}
		});
		btnNewButton_4.setFont(new Font("新細明體", Font.BOLD, 18));
		btnNewButton_4.setBounds(60, 300, 138, 31);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("重新登入");
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUi lu=new LoginUi();
				lu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setFont(new Font("新細明體", Font.BOLD, 18));
		btnNewButton_5.setBounds(60, 491, 138, 31);
		panel.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/123.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 1221, 550);
		panel.add(lblNewLabel_1);

	}
}
 		
