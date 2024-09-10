package controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Employee;
import model.Member;
import service.impl.MemberServiceImpl;
import util.JTextFieldHintListener;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class MemberUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	public JPanel panel;
	private JTextField id;
	private JTextField memberno;
	private JTextField name;
	private JTextField account;
	private JTextField address;
	private JTextField phone;
	private JTextField password;
	public MemberServiceImpl msi=new MemberServiceImpl();
	private JComboBox membership;
	private JScrollPane scrollPane;
	private JTextField keyword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberUi frame = new MemberUi();
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
	public MemberUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 950, 462);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員管理");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 73, 27);
		panel.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 194, 904, 247);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					TableModel model = table.getModel();
					id.setText(model.getValueAt(selectedRow, 0).toString());
					memberno.setText(model.getValueAt(selectedRow, 1).toString());
					name.setText(model.getValueAt(selectedRow, 2).toString());
					account.setText(model.getValueAt(selectedRow, 3).toString());
					password.setText(model.getValueAt(selectedRow, 4).toString());
					phone.setText(model.getValueAt(selectedRow, 5).toString());
					address.setText(model.getValueAt(selectedRow, 6).toString());
					membership.setSelectedItem(model.getValueAt(selectedRow, 7).toString());
					memberno.setForeground(Color.BLACK);
				}
			}
		});
		loadDataToTable();
		
		JLabel lblNewLabel_7 = new JLabel("ID");
		lblNewLabel_7.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(62, 47, 42, 20);
		panel.add(lblNewLabel_7);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(114, 47, 96, 21);
		panel.add(id);
		
		JLabel lblNewLabel_1 = new JLabel("編號");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(272, 47, 42, 20);
		panel.add(lblNewLabel_1);
		
		memberno = new JTextField();
		memberno.setText("M000");
		memberno.setColumns(10);
		memberno.addFocusListener(new JTextFieldHintListener(memberno,"M000"));
		memberno.setBounds(335, 47, 96, 21);
		panel.add(memberno);
		
		JLabel lblNewLabel_2 = new JLabel("姓名");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(481, 47, 42, 20);
		panel.add(lblNewLabel_2);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(555, 47, 96, 21);
		panel.add(name);
		
		JLabel lblNewLabel_5 = new JLabel("帳號");
		lblNewLabel_5.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(669, 47, 32, 20);
		panel.add(lblNewLabel_5);
		
		account = new JTextField();
		account.setColumns(10);
		account.setBounds(746, 47, 96, 21);
		panel.add(account);
		
		membership = new JComboBox();
		membership.setBounds(746, 113, 96, 20);
		membership.setModel(new DefaultComboBoxModel(new String[] { "白金會員", "金卡會員", "銀卡會員" }));
		panel.add(membership);
		
		JLabel lableposition = new JLabel("會員等級");
		lableposition.setFont(new Font("新細明體", Font.PLAIN, 16));
		lableposition.setBounds(669, 113, 67, 20);
		panel.add(lableposition);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(555, 114, 96, 21);
		panel.add(address);
		
		JLabel lblNewLabel_3 = new JLabel("地址");
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(481, 115, 42, 20);
		panel.add(lblNewLabel_3);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(335, 114, 96, 21);
		panel.add(phone);
		
		JLabel lblNewLabel_4 = new JLabel("電話");
		lblNewLabel_4.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(272, 114, 42, 20);
		panel.add(lblNewLabel_4);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(114, 114, 96, 21);
		panel.add(password);
		
		JLabel lblNewLabel_2_1 = new JLabel("密碼");
		lblNewLabel_2_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(62, 114, 42, 20);
		panel.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMe();
				loadDataToTable();
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton.setBounds(62, 157, 87, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("查詢");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDataToTable();
			}
		});
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_2.setBounds(248, 157, 87, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				loadDataToTable();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_1.setBounds(481, 156, 87, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("刪除");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				loadDataToTable();
			}
		});
		btnNewButton_3.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_3.setBounds(669, 157, 87, 23);
		panel.add(btnNewButton_3);
		
		keyword = new JTextField(15);
		keyword.setText("關鍵字");
		keyword.addFocusListener(new JTextFieldHintListener(keyword,"關鍵字"));
		keyword.setColumns(10);	
		keyword.setBounds(335, 158, 96, 21);
		panel.add(keyword);
	}
	public void addMe()//新增會員
	{
		String Memberno=memberno.getText();
		String Name=name.getText();
		String Account=account.getText();
		String Password=password.getText();
		String Phone=phone.getText();
		String Address=address.getText();
		String Membership=membership.getSelectedItem().toString();
		
		if (Memberno.isEmpty() || Name.isEmpty() || Account.isEmpty() || Password.isEmpty() || Phone.isEmpty()
				|| Address.isEmpty() || Membership.isEmpty()) {
			JOptionPane.showMessageDialog(this, "資料不可空白，請填寫完整", "錯誤", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			Member m=new Member(Memberno,Name,Account,Password,Phone,Address,Membership);
			msi.add(m);
			clear();
		}
	}
	
	public DefaultTableModel convertListToTableModel(List<Member> memberList) {
		String[] columnNames = { "ID", "員工編號", "姓名", "帳號", "密碼", "聯絡電話", "地址", "職稱" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		for (Member m : memberList) {
			Object[] rowData = { m.getId(), m.getMemberno(), m.getMembername(), m.getAccount(), m.getPassword(),
					m.getPhone(), m.getAddress(), m.getMembership() };
			model.addRow(rowData);
		}
		return model;
	}
	public void loadDataToTable() {
		List<Member> memberList = msi.showMember();
		DefaultTableModel model = convertListToTableModel(memberList);
		table.setModel(model);
		table.setDefaultEditor(Object.class, null);
	}
	public void update()//用account判斷帳號是否存在 並存取資料進行修改
	{
		if(account.getText()!="")
		{
			String Name=name.getText();
			String Account=account.getText();
			String Password=password.getText();
			String Phone=phone.getText();
			String Address=address.getText();
			String Membership=membership.getSelectedItem().toString();
			if (Name.isEmpty() || Password.isEmpty() || Phone.isEmpty() || Address.isEmpty() || Membership.isEmpty()) {
				JOptionPane.showMessageDialog(this, "資料不可空白，請填寫完整", "錯誤", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				JOptionPane.showMessageDialog(null, "員工資料修改成功");
				msi.update(Account, Name, Password, Phone, Address, Membership);
				clear();
			}
		} else {
			JOptionPane.showMessageDialog(null, "請選擇要修改的資料");
		}}

	public void delete()//刪除
	{if (id.getText() != "") {
		int reply = JOptionPane.showConfirmDialog(null, "確定刪除這筆資料?", "刪除確認", JOptionPane.OK_CANCEL_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			int Id = Integer.parseInt(id.getText());
			msi.delete(Id);
			JOptionPane.showMessageDialog(null, "員工資料刪除成功");
			clear();
		}
	} else {
		JOptionPane.showMessageDialog(null, "請選擇要刪除的資料");
	}}
	public void clear() {//清空欄位
		id.setText("");
		memberno.setText("");
		name.setText("");
		id.setText("");
		account.setText("");
		password.setText("");
		phone.setText("");
		address.setText("");
	}
}

