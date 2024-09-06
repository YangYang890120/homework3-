package controller;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Employee;
import service.impl.EmployeeServiceImpl;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Employee_panel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	public EmployeeServiceImpl esi=new EmployeeServiceImpl();
	private JLabel id;
	private JTextField password;
	private JTextField name;
	private JTextField phone;
	private JTextField employeeid;
	
	private JTextField address;
	private JLabel showEor;
	public JPanel employeePane;
	private JComboBox position;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_panel frame = new Employee_panel();
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
	public Employee_panel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		employeePane = new JPanel();
		employeePane.setBackground(new Color(0, 0, 0));
		employeePane.setBounds(0, 10, 684, 426);
		contentPane.add(employeePane);
		employeePane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("員工管理");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(25, 3, 112, 33);
		employeePane.add(lblNewLabel);
		
		
		String[] columnNames = {"ID","員工編號","姓名","身份證字號","密碼","聯絡電話","地址","職稱"};
		DefaultTableModel model=new DefaultTableModel(columnNames,0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 199, 648, 206);
		employeePane.add(scrollPane);
		table = new JTable(model);
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
                TableModel model = table.getModel();
                id.setText(model.getValueAt(selectedRow, 0).toString());
                name.setText(model.getValueAt(selectedRow, 2).toString());
                employeeid.setText(model.getValueAt(selectedRow, 3).toString());
                password.setText(model.getValueAt(selectedRow, 4).toString());
                phone.setText(model.getValueAt(selectedRow, 5).toString());
                address.setText(model.getValueAt(selectedRow, 6).toString());
                position.setSelectedItem(model.getValueAt(selectedRow, 7).toString());
            }
			}
		});
		
		id = new JLabel("");
		id.setForeground(new Color(0, 0, 0));
		id.setFont(new Font("宋体", Font.PLAIN, 5));
		id.setBounds(43, 56, 67, 15);
		employeePane.add(id);
		
		JLabel lblNewLabel_1 = new JLabel("密   碼");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(43, 95, 77, 26);
		employeePane.add(lblNewLabel_1);
		
		password = new JTextField();
		password.setBounds(116, 95, 78, 26);
		employeePane.add(password);
		password.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(116, 59, 78, 26);
		employeePane.add(name);
		
		JLabel lblNewLabel_2 = new JLabel("員工姓名");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(43, 59, 77, 26);
		employeePane.add(lblNewLabel_2);
		
		phone = new JTextField();
		phone.setColumns(10);
		//phone.setDocument(new NumericDocument());
		phone.setBounds(310, 95, 111, 26);
		employeePane.add(phone);
		
		JLabel lblNewLabel_3 = new JLabel("聯絡電話");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(217, 95, 77, 26);
		employeePane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("身分證字號");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(217, 59, 89, 26);
		employeePane.add(lblNewLabel_4);
		
		employeeid = new JTextField();
		employeeid.setColumns(10);
		employeeid.setBounds(310, 59, 111, 26);
		employeePane.add(employeeid);
		
		JLabel lblNewLabel_6 = new JLabel("職   稱");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(448, 56, 67, 26);
		employeePane.add(lblNewLabel_6);
		
		
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(502, 95, 111, 26);
		employeePane.add(address);
		
		JLabel lblNewLabel_5 = new JLabel("地   址");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(448, 92, 51, 26);
		employeePane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addEm();
				loadDataToTable();
				
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(42, 143, 100, 23);
		employeePane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查詢");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 loadDataToTable();
				 
	                
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(152, 143, 100, 23);
		employeePane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("修改");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				loadDataToTable();
			}
		});
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(263, 144, 100, 23);
		employeePane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("刪除");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				loadDataToTable();
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(377, 143, 100, 23);
		employeePane.add(btnNewButton_1_1);
		
		showEor = new JLabel("");
		showEor.setForeground(Color.WHITE);
		showEor.setFont(new Font("宋体", Font.BOLD, 12));
		showEor.setBounds(300, 146, 127, 26);
		employeePane.add(showEor);
		
		JButton cls = new JButton("清除");
		cls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		cls.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		cls.setBackground(Color.WHITE);
		cls.setBounds(492, 143, 100, 23);
		employeePane.add(cls);
		
		position = new JComboBox();
		position.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		position.setModel(new DefaultComboBoxModel(new String[] {"店經理", "店副理", "儲備店副理", "店襄理", "實習店襄理"}));
		position.setBounds(502, 58, 111, 26);
		employeePane.add(position);
		
		
        
	}
	public void addEm() {//新增動作
		String Name=name.getText();
		String Employeeid=employeeid.getText();
		String Password=password.getText();
		String Phone=phone.getText();
		String Address=address.getText();
		String Position=position.getSelectedItem().toString();
		 if (Name.isEmpty() || Employeeid.isEmpty() || Password.isEmpty() || Phone.isEmpty() || Address.isEmpty() || Position.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "資料不可空白，請填寫完整", "錯誤", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
		 else {
		Employee ee=new Employee("",Name,Employeeid,Password,Phone,Address,Position);
		esi.addEmployee(ee);
		/*name.setText("");
		employeeid.setText("");
		password.setText("");
		phone.setText("");
		address.setText("");
		position.setText("");*/
		}
	}
	public void update() {
		if(id.getText()!="") {
		int Id=Integer.parseInt(id.getText());
		String Name=name.getText();
		String Password=password.getText();
		String Phone=phone.getText();
		String Address=address.getText();
		String Position=position.getSelectedItem().toString();
		if (Name.isEmpty() ||  Password.isEmpty() || Phone.isEmpty() || Address.isEmpty() || Position.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "資料不可空白，請填寫完整", "錯誤", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
		else {
		
		//esi.(Id,Name,Password,Phone,Address,Position);
		
		 JOptionPane.showMessageDialog(null, "員工資料修改成功" );
		clear();
		 } 
		}else {
			JOptionPane.showMessageDialog(null, "請選擇要修改的資料" );
		}
	}
	
	public void delete() {
		if(id.getText()!="") {
			int reply = JOptionPane.showConfirmDialog(null,"確定刪除這筆資料?","刪除確認",JOptionPane.OK_CANCEL_OPTION);
			if(reply == JOptionPane.YES_OPTION) {
			int Id=Integer.parseInt(id.getText());
			esi.delete(null);
			JOptionPane.showMessageDialog(null, "員工資料刪除成功" );
			clear();}
		 }
		else{
			JOptionPane.showMessageDialog(null, "請選擇要刪除的資料" );
		}
	}
	public DefaultTableModel convertListToTableModel(List<Employee> employeeList) {
		String[] columnNames = {"ID","員工編號","姓名","身份證字號","密碼","聯絡電話","地址","職稱"};
		DefaultTableModel model=new DefaultTableModel(columnNames,0);
		for (Employee e : employeeList) {
            Object[] rowData = {
                e.getId(),
                e.getEmployeeno(),
                e.getName(),
                e.getAccount(),
                e.getPassword(),
                e.getPhone(),
                e.getAddress(),
                e.getPosition()
            };
            model.addRow(rowData);
        }

        return model;
		
	}
	public void loadDataToTable() {
		List<Employee> employeeList =esi.AllEmployee();
		DefaultTableModel model = convertListToTableModel(employeeList);
		table.setModel(model);
		table.setDefaultEditor(Object.class, null);
    }
	public void clear() {
		id.setText("");
		 name.setText("");
		 employeeid.setText("");
		 password.setText("");
		 phone.setText("");
		 address.setText("");
		 
	}

}
