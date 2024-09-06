package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Employee;
import model.Orders;
import service.impl.OrderServiceImpl;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class OrderUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField orderno;
	private JTextField barcode;
	private JTextField employeeno;
	private JTextField memberno;
	private JTextField orderamount;
	private JTable table;
	private JTextField textField_4;
	public JPanel panel;
	public OrderServiceImpl osi=new OrderServiceImpl();
	private JTextField date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderUi frame = new OrderUi();
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
	public OrderUi() {
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
		
		JLabel lblNewLabel = new JLabel("出貨管理");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 79, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("出貨編號");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 56, 79, 27);
		panel.add(lblNewLabel_1);
		
		orderno = new JTextField();
		orderno.setBounds(109, 59, 99, 21);
		panel.add(orderno);
		orderno.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("商品條碼");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(20, 111, 79, 27);
		panel.add(lblNewLabel_1_1);
		
		barcode = new JTextField();
		barcode.setColumns(10);
		barcode.setBounds(109, 114, 99, 21);
		panel.add(barcode);
		
		JLabel lblNewLabel_1_2 = new JLabel("員工編號");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(20, 164, 79, 27);
		panel.add(lblNewLabel_1_2);
		
		employeeno = new JTextField();
		employeeno.setColumns(10);
		employeeno.setBounds(109, 167, 99, 21);
		panel.add(employeeno);
		
		JLabel lblNewLabel_1_3 = new JLabel("會員編號");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(20, 216, 79, 27);
		panel.add(lblNewLabel_1_3);
		
		memberno = new JTextField();
		memberno.setColumns(10);
		memberno.setBounds(109, 219, 99, 21);
		panel.add(memberno);
		
		JLabel lblNewLabel_1_4 = new JLabel("出貨數量");
		lblNewLabel_1_4.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(20, 266, 79, 27);
		panel.add(lblNewLabel_1_4);
		
		orderamount = new JTextField();
		orderamount.setColumns(10);
		orderamount.setBounds(109, 269, 99, 21);
		panel.add(orderamount);
		
		JLabel lblNewLabel_2 = new JLabel("日期");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(20, 314, 73, 27);
		panel.add(lblNewLabel_2);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 22, 664, 200);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		loadDataToTable();
		textField_4 = new JTextField();
		textField_4.setText("列印出貨單");
		textField_4.setBounds(250, 245, 664, 196);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.setBounds(20, 351, 87, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查詢");
		btnNewButton_1.setBounds(121, 351, 87, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("修改");
		btnNewButton_2.setBounds(20, 418, 87, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("刪除");
		btnNewButton_3.setBounds(121, 418, 87, 23);
		panel.add(btnNewButton_3);
		
		date = new JTextField();
		date.setBounds(112, 317, 96, 21);
		panel.add(date);
		date.setColumns(10);
	}
	public void add()
	{
		String Orderno = orderno.getText();
		String Barcode = barcode.getText();
		String Employee = employeeno.getText();
		String member = memberno.getText();
		Integer orderAmount = Integer.parseInt(orderamount.getText());
		String Date= date.getText();
		if (Orderno.isEmpty() ||Barcode.isEmpty() || Employee.isEmpty() || member.isEmpty() || orderAmount.equals(0)
				|| Date.isEmpty()) {
			JOptionPane.showMessageDialog(this, "資料不可空白，請填寫完整", "錯誤", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			Orders o = new Orders(Orderno, Barcode, Employee, member, orderAmount, Date);
			osi.addOrder(o);
			//clear();
		}
		
	}
	public DefaultTableModel convertListToTableModel(List<Orders> OrdersList) {
		String[] columnNames = { "ID", "訂單編號", "條碼", "員工編號", "會員編號", "出貨數量", "日期"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		for (Orders o : OrdersList) {
			Object[] rowData = { o.getId(), o.getOrderno(), o.getBarcode(), o.getEmployeeno(), o.getMemberno(), o.getOrderamount(),o.getDate()};
			model.addRow(rowData);
		}
		return model;

	}
	public void loadDataToTable() {
		List<Orders> OrdersList = osi.selectAll();
		DefaultTableModel model = convertListToTableModel(OrdersList);
		table.setModel(model);
		table.setDefaultEditor(Object.class, null);
	}
}
