package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Employee;
import service.impl.EmployeeServiceImpl;
import util.cal;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class LoginUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField account;
	private JPasswordField password;
	private EmployeeServiceImpl esi=new EmployeeServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUi frame = new LoginUi();
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
	public LoginUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 414, 241);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel.setBounds(88, 66, 85, 48);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(88, 124, 85, 48);
		panel.add(lblNewLabel_1);
		
		account = new JTextField();
		account.setBounds(163, 81, 96, 21);
		panel.add(account);
		account.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(163, 139, 96, 21);
		panel.add(password);
		
		JButton login = new JButton("登入");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				String Acc=account.getText();
				String Pas=password.getText();
				Employee e=esi.login(Acc, Pas);
				if(e!=null)//判斷會員資料是否存在 
				{
					Employee em=new EmployeeServiceImpl().login(Acc, Pas);
					cal.SaveObject(em,"Employee.txt");
					ManageSystem ms=new ManageSystem();//進入後臺管理系統
					ms.setVisible(true);
					dispose();
				}
				else {
					int response=JOptionPane.showConfirmDialog(login,"要重新登入?", "帳號或密碼錯誤",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(response==JOptionPane.YES_OPTION)
					{

					}
					else
					{

					}
				}
				
			}
		});
		login.setBounds(172, 197, 87, 23);
		panel.add(login);
		
		JButton btnNewButton_1 = new JButton("忘記密碼");
		btnNewButton_1.setBounds(317, 197, 87, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("後端管理系統");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(118, 10, 256, 48);
		panel.add(lblNewLabel_2);
	}
}
