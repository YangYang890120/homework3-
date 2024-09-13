package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Employee;
import model.Member;
import service.impl.EmployeeServiceImpl;
import util.JTextFieldHintListener;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Choice;
import java.awt.Color;

import javax.swing.JTable;
import java.awt.Button;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Dimension;

public class EmployeeUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JPanel employeePane;
	private JTextField employeeno;
	private JTextField employeename;
	private JLabel lblNewLabel_2;
	private JTextField password;
	private JLabel lblNewLabel_3;
	private JTextField address;
	private JLabel lblNewLabel_4;
	private JTextField phone;
	private JLabel lableposition;
	private JLabel lblNewLabel_6;
	private JTable table;
	private JLabel lblNewLabel_7;
	private JTextField id;
	public EmployeeServiceImpl esi = new EmployeeServiceImpl();
	private JTextField account;
	private JLabel lblNewLabel_5;
	private JComboBox position;
	private JTextField keyword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeUi frame = new EmployeeUi();
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
	public EmployeeUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		String[] columnNames = { "ID", "員工編號", "姓名", "帳號", "密碼", "聯絡電話", "地址", "職稱" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		contentPane.setLayout(null);

		employeePane = new JPanel();
		employeePane.setBounds(0, 0, 960, 462);
		employeePane.setLayout(null);
		contentPane.add(employeePane);

		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(481, 47, 42, 20);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
		employeePane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("編號");
		lblNewLabel_1.setBounds(272, 47, 42, 20);
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		employeePane.add(lblNewLabel_1);

		employeeno = new JTextField();
		employeeno.setColumns(10);
		employeeno.setText("E000");
		employeeno.setBounds(335, 47, 96, 21);
		employeeno.addFocusListener(new JTextFieldHintListener(employeeno,"E000"));
		employeePane.add(employeeno);

		employeename = new JTextField();
		employeename.setBounds(555, 47, 96, 21);
		employeePane.add(employeename);
		employeename.setColumns(10);

		lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setBounds(62, 114, 42, 20);
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		employeePane.add(lblNewLabel_2);

		password = new JTextField();
		password.setBounds(114, 114, 96, 21);
		employeePane.add(password);
		password.setColumns(10);

		lblNewLabel_3 = new JLabel("地址");
		lblNewLabel_3.setBounds(481, 114, 42, 20);
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 16));
		employeePane.add(lblNewLabel_3);

		address = new JTextField();
		address.setBounds(555, 114, 96, 21);
		employeePane.add(address);
		address.setColumns(10);

		lblNewLabel_4 = new JLabel("電話");
		lblNewLabel_4.setBounds(272, 114, 42, 20);
		lblNewLabel_4.setFont(new Font("新細明體", Font.PLAIN, 16));
		employeePane.add(lblNewLabel_4);

		phone = new JTextField();
		phone.setBounds(335, 114, 96, 21);
		employeePane.add(phone);
		phone.setColumns(10);

		lableposition = new JLabel("職位");
		lableposition.setBounds(669, 114, 53, 20);
		lableposition.setFont(new Font("新細明體", Font.PLAIN, 16));
		employeePane.add(lableposition);

		lblNewLabel_6 = new JLabel("員工管理");
		lblNewLabel_6.setBounds(10, 10, 73, 27);
		lblNewLabel_6.setFont(new Font("新細明體", Font.PLAIN, 18));
		employeePane.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("ID");
		lblNewLabel_7.setBounds(62, 47, 42, 20);
		lblNewLabel_7.setFont(new Font("新細明體", Font.PLAIN, 16));
		employeePane.add(lblNewLabel_7);

		id = new JTextField();
		id.setBounds(114, 47, 96, 21);
		employeePane.add(id);
		id.setColumns(10);

		account = new JTextField();
		account.setBounds(746, 47, 96, 21);
		employeePane.add(account);
		account.setColumns(10);

		lblNewLabel_5 = new JLabel("帳號");
		lblNewLabel_5.setBounds(669, 47, 42, 20);
		lblNewLabel_5.setFont(new Font("新細明體", Font.PLAIN, 16));
		employeePane.add(lblNewLabel_5);

		position = new JComboBox();
		position.setBounds(746, 114, 96, 20);
		position.setModel(new DefaultComboBoxModel(new String[] { "總經理", "經理", "員工" }));
		employeePane.add(position);

		JButton btnNewButton = new JButton("新增");
		btnNewButton.setBounds(62, 157, 87, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addEm();
				loadDataToTable();
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 16));
		employeePane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.setBounds(555, 157, 87, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateEm();
				loadDataToTable();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		employeePane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("查詢");
		btnNewButton_2.setBounds(246, 157, 87, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findByKeyWord();
			}
		});
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		employeePane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("刪除");
		btnNewButton_3.setBounds(746, 157, 87, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteEm();
				loadDataToTable();
			}
		});
		btnNewButton_3.setFont(new Font("新細明體", Font.PLAIN, 16));
		employeePane.add(btnNewButton_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 194, 904, 247);
		//contentPane.add(scrollPane);
		employeePane.add(scrollPane);

		table = new JTable(model);
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		keyword = new JTextField();
		keyword.setText("關鍵字");
		keyword.setBounds(335, 158, 96, 21);
		keyword.addFocusListener(new JTextFieldHintListener(keyword,"關鍵字"));
		employeePane.add(keyword);
		keyword.setColumns(10);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					TableModel model = table.getModel();
					id.setText(model.getValueAt(selectedRow, 0).toString());
					employeeno.setText(model.getValueAt(selectedRow, 1).toString());
					employeename.setText(model.getValueAt(selectedRow, 2).toString());
					account.setText(model.getValueAt(selectedRow, 3).toString());
					password.setText(model.getValueAt(selectedRow, 4).toString());
					phone.setText(model.getValueAt(selectedRow, 5).toString());
					address.setText(model.getValueAt(selectedRow, 6).toString());
					position.setSelectedItem(model.getValueAt(selectedRow, 7).toString());
					employeeno.setForeground(Color.BLACK);
				}
			}
		});
		loadDataToTable();

	}

	public void addEm() {// 新增動作
		String Employeeno = employeeno.getText();
		String Name = employeename.getText();
		String Account = account.getText();
		String Password = password.getText();
		String Phone = phone.getText();
		String Address = address.getText();
		String Position = position.getSelectedItem().toString();
		if (Employeeno.isEmpty() || Name.isEmpty() || Account.isEmpty() || Password.isEmpty() || Phone.isEmpty()
				|| Address.isEmpty() || Position.isEmpty()) {
			JOptionPane.showMessageDialog(this, "資料不可空白，請填寫完整", "錯誤", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			Employee ee = new Employee(Employeeno, Name, Account, Password, Phone, Address, Position);
			esi.addEmployee(ee);
			clear();
		}
	}

	public void updateEm() {
		if (id.getText() != "") {
			int Id = Integer.parseInt(id.getText());
			String Name = employeename.getText();
			String Password = password.getText();
			String Phone = phone.getText();
			String Address = address.getText();
			String Position = position.getSelectedItem().toString();
			if (Name.isEmpty() || Password.isEmpty() || Phone.isEmpty() || Address.isEmpty() || Position.isEmpty()) {
				JOptionPane.showMessageDialog(this, "資料不可空白，請填寫完整", "錯誤", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				JOptionPane.showMessageDialog(null, "員工資料修改成功");

				esi.update(Id, Name, Password, Phone, Address, Position);
				clear();
			}
		} else {
			JOptionPane.showMessageDialog(null, "請選擇要修改的資料");
		}
	}

	public void deleteEm() {
		if (id.getText() != "") {
			int reply = JOptionPane.showConfirmDialog(null, "確定刪除這筆資料?", "刪除確認", JOptionPane.OK_CANCEL_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				int Id = Integer.parseInt(id.getText());
				esi.delete(Id);
				JOptionPane.showMessageDialog(null, "員工資料刪除成功");
				clear();
			}
		} else {
			JOptionPane.showMessageDialog(null, "請選擇要刪除的資料");
		}
	}
	public DefaultTableModel convertListToTableModel(List<Employee> employeeList) {
		String[] columnNames = { "ID", "會員編號", "姓名", "帳號", "密碼", "聯絡電話", "地址", "等級" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		for (Employee e : employeeList) {
			Object[] rowData = { e.getId(), e.getEmployeeno(), e.getName(), e.getAccount(), e.getPassword(),
					e.getPhone(), e.getAddress(), e.getPosition() };
			model.addRow(rowData);
		}
		return model;

	}
	public void loadDataToTable() {
		List<Employee> employeeList = esi.AllEmployee();
		DefaultTableModel model = convertListToTableModel(employeeList);
		table.setModel(model);
		table.setDefaultEditor(Object.class, null);
	}
	public void findByKeyWord() {
		
		String Keyword=keyword.getText();
		if(Keyword.equals("關鍵字"))
		{
			loadDataToTable();
		}
		else
		{
			List<Employee> employeeList = esi.findByKeyWord(Keyword);
			DefaultTableModel model = convertListToTableModel(employeeList);
			table.setModel(model);
			table.setDefaultEditor(Object.class, null);	
		}
	}
	public void clear() {

		id.setText("");
		employeeno.setText("");
		employeename.setText("");
		account.setText("");
		password.setText("");
		phone.setText("");
		address.setText("");

	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
