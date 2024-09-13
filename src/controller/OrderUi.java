package controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Employee;
import model.Orders;
import model.Product;
import service.impl.OrderServiceImpl;
import service.impl.ProductServiceImpl;
import util.JTextFieldHintListener;
import util.cal;

import java.awt.GridLayout;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;

public class OrderUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField orderno;
	private JTextField barcode;
	private JTextField employeeno;
	private JTextField memberno;
	private JTextField orderamount;
	private JTable table;
	public JPanel panel;
	public OrderServiceImpl osi=new OrderServiceImpl();
	public JDateChooser date;
	public JDateChooser date_1;
	public JDateChooser date_2;
	public ProductServiceImpl psi=new ProductServiceImpl();
	public JTextArea output;

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
		orderno.setText("O000");
		orderno.setBounds(109, 59, 99, 21);
		orderno.addFocusListener(new JTextFieldHintListener(orderno,"O000"));
		panel.add(orderno);
		orderno.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("商品條碼");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(20, 111, 79, 27);
		panel.add(lblNewLabel_1_1);
		
		barcode = new JTextField();
		barcode.setText("12345678");
		barcode.setColumns(10);
		barcode.addFocusListener(new JTextFieldHintListener(barcode,"12345678"));
		barcode.setBounds(109, 114, 99, 21);
		panel.add(barcode);
		
		JLabel lblNewLabel_1_2 = new JLabel("員工編號");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(20, 164, 79, 27);
		panel.add(lblNewLabel_1_2);
		
		employeeno = new JTextField();
		employeeno.setText("E000");
		employeeno.addFocusListener(new JTextFieldHintListener(employeeno,"E000"));
		employeeno.setColumns(10);
		employeeno.setBounds(109, 167, 99, 21);
		panel.add(employeeno);
		
		JLabel lblNewLabel_1_3 = new JLabel("會員編號");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(20, 216, 79, 27);
		panel.add(lblNewLabel_1_3);
		
		memberno = new JTextField();
		memberno.setText("M000");
		memberno.addFocusListener(new JTextFieldHintListener(memberno,"M000"));
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
		scrollPane.setBounds(250, 18, 664, 192);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					TableModel model = table.getModel();
					orderno.setText(model.getValueAt(selectedRow, 0).toString());
					barcode.setText(model.getValueAt(selectedRow, 1).toString());
					employeeno.setText(model.getValueAt(selectedRow, 2).toString());
					memberno.setText(model.getValueAt(selectedRow, 3).toString());
					orderamount.setText(model.getValueAt(selectedRow, 4).toString());
					orderno.setForeground(Color.BLACK);
					barcode.setForeground(Color.BLACK);
					employeeno.setForeground(Color.BLACK);
					memberno.setForeground(Color.BLACK);
				}
			}
		});
		loadDataToTable();
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addOr();
//				updateToProduct();
				loadDataToTable();
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton.setBounds(20, 351, 87, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查詢");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDataToTable();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_1.setBounds(121, 351, 87, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("修改");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateToProduct();
				loadDataToTable();
			}
		});
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_2.setBounds(20, 418, 87, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("刪除");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				loadDataToTable();
			}
		});
		btnNewButton_3.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_3.setBounds(121, 418, 87, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("列印");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					output.print();
				}
				catch(PrinterException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_4.setBounds(827, 218, 87, 23);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel_3 = new JLabel("日期區間");
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(250, 218, 73, 27);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("日期區間");
		lblNewLabel_3_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(500, 218, 73, 27);
		panel.add(lblNewLabel_3_1);
		
		date = new JDateChooser();
		date.setBounds(109, 320, 99, 21);
		panel.add(date);
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date.setDateFormatString("yyyy-MM-dd");
        
        date_1 = new JDateChooser();
        date_1.setDateFormatString("yyyy-MM-dd");
        date_1.setBounds(333, 218, 99, 21);
        panel.add(date_1);
        
        date_2 = new JDateChooser();
        date_2.setDateFormatString("yyyy-MM-dd");
        date_2.setBounds(583, 218, 99, 21);
        panel.add(date_2);
        
        JButton btnNewButton_5 = new JButton("新增出貨單");
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		selectByDate();
        		
        	}
        });
        btnNewButton_5.setFont(new Font("新細明體", Font.PLAIN, 16));
        btnNewButton_5.setBounds(692, 218, 125, 23);
        panel.add(btnNewButton_5);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(249, 249, 665, 192);
        panel.add(scrollPane_1);
        
        output = new JTextArea();
        scrollPane_1.setViewportView(output);
	}
	public void addOr()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String Orderno = orderno.getText();
		String Barcode = barcode.getText();
		String Employee = employeeno.getText();
		String member = memberno.getText();
		Integer orderAmount = Integer.parseInt(orderamount.getText());
		Date Date= date.getDate();
		String DateString = sdf.format(Date);
		if (Orderno.isEmpty() ||Barcode.isEmpty() || Employee.isEmpty() || member.isEmpty() || orderAmount.equals(0)
				|| DateString.isEmpty()) {
			JOptionPane.showMessageDialog(this, "資料不可空白，請填寫完整", "錯誤", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			Orders o = new Orders(Orderno, Barcode, Employee, member, orderAmount, DateString);
			if(psi.findBarcode(Barcode))
			{
				
				osi.addOrder(o);
				addToProduct();
				JOptionPane.showMessageDialog(null, "出貨資料新增成功,已將出貨數量從存貨扣除");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "查無此商品條碼", "錯誤", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public void selectByDate()
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date Date_1= date_1.getDate();
		Date Date_2= date_2.getDate();
		String DateString1= sdf.format(Date_1);
		String DateString2= sdf.format(Date_2);
		List<Orders> l=osi.selectByDate(DateString1, DateString2);
		DefaultTableModel model = convertListToTableModel(l);
		table.setModel(model);
		table.setDefaultEditor(Object.class, null);
		Object ob=cal.ReadObiect("Employee.txt");
		Employee m=(Employee)ob;
		Integer Sum=0;
		LocalDateTime localtime=LocalDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
		String FDT=localtime.format(dtf);
		String orders = m.getName()+" 出貨單                                                          列印日期:"+FDT+
						"\n=====================================================================================\n";
		for(Orders o:l)
		{
			orders+=(
			"出貨編號:"+o.getOrderno()+" 員工姓名:"+o.getEmployeeno()+" 會員姓名:"+o.getMemberno()+" 數量:"+o.getOrderamount()+" 日期"+o.getDate()+"總額"+o.getSum()+"\n"+
			"----------------------------------------------------------------------------------------------------------------------------------\n");
			Sum=Sum+o.getSum();
		}
		orders+=" ------------------------------------------------------------------------------------------- 總金額:"+Sum;
		output.setText(orders);
	}
	public void addToProduct()
	{
		Integer Orderamount =Integer.parseInt(orderamount.getText());
		String Barcode=barcode.getText();
		Product p=psi.findByBarcode(Barcode);
		//p.getAmount()+=Orderamount;
		if((p.getAmount()-Orderamount)<0)
		{
			JOptionPane.showMessageDialog(this, "出貨數量不可大於存貨", "錯誤", JOptionPane.ERROR_MESSAGE);
		}
		else {
			psi.updateByOrderamount(Barcode,(p.getAmount()-Orderamount));
			clear();
		}		
	}
	public void updateToProduct()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Integer Orderamount =Integer.parseInt(orderamount.getText());
		String Barcode=barcode.getText();
		String Orderno=orderno.getText();
		String Employee=employeeno.getText();
		String Memberno=memberno.getText();
		Date Date= date.getDate();
		String DateString = sdf.format(Date);
		Product p=psi.findByBarcode(Barcode);
		Orders o=osi.selectByOrderno(Orderno);
		if (Orderno.isEmpty() ||Barcode.isEmpty() || Employee.isEmpty() || Memberno.isEmpty() || Orderamount.equals(0)
				|| DateString.isEmpty()) {
			JOptionPane.showMessageDialog(this, "資料不可空白，請填寫完整", "錯誤", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			
		}
		if((p.getAmount()-(Orderamount-o.getOrderamount()))<0)
		{
			JOptionPane.showMessageDialog(this, "修改後出貨數量不可大於存貨", "錯誤", JOptionPane.ERROR_MESSAGE);
			
		}
		else {
			if(psi.findBarcode(Barcode))
			{
				psi.updateByOrderamount(Barcode,(p.getAmount()-(Orderamount-o.getOrderamount())));
				osi.update(Orderno,Barcode,Employee,Memberno,Orderamount,DateString);
				JOptionPane.showMessageDialog(null, "出貨資料修改成功,已將修改後數量與存貨同步更新");
				clear();
			}
			else
			{
				JOptionPane.showMessageDialog(this, "查無此商品條碼", "錯誤", JOptionPane.ERROR_MESSAGE);
			}
			
		}		
	}
	
	public void update(){
		if(orderno.getText()!="")
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String Orderno=orderno.getText();
			String Barcode=barcode.getText();
			String Employee=employeeno.getText();
			String Memberno=memberno.getText();
			Integer OrderAmount=Integer.parseInt(orderamount.getText());
			Date Date= date.getDate();
			String DateString = sdf.format(Date);
			//String Date=date.getDateFormatString();
			if (Orderno.isEmpty() ||Barcode.isEmpty() || Employee.isEmpty() || Memberno.isEmpty() || OrderAmount.equals(0)
					|| DateString.isEmpty()) {
				JOptionPane.showMessageDialog(this, "資料不可空白，請填寫完整", "錯誤", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				if(psi.findBarcode(Barcode))
				{
					
					
					updateToProduct();
					
					osi.update(Orderno,Barcode,Employee,Memberno,OrderAmount,DateString);
					JOptionPane.showMessageDialog(null, "出貨資料修改成功,已將修改後數量與存貨同步更新");
					clear();
				}
				else
				{
					JOptionPane.showMessageDialog(this, "查無此商品條碼", "錯誤", JOptionPane.ERROR_MESSAGE);
		}}}}
	public void delete()
	{
		if (orderno.getText() != "") {
			int reply = JOptionPane.showConfirmDialog(null, "確定刪除這筆資料?", "刪除確認", JOptionPane.OK_CANCEL_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				String Orderno= orderno.getText();
				osi.delete(Orderno);;
				JOptionPane.showMessageDialog(null, "出貨資料刪除成功");
				clear();
			}
		} else {
			JOptionPane.showMessageDialog(null, "請選擇要刪除的資料");
		}
	}
	public DefaultTableModel convertListToTableModel_2(List<Orders> OrdersList) {
		String[] columnNames = { /*"ID",*/ "出貨編號", "產品名稱", "員工姓名", "會員姓名", "數量", "日期"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		for (Orders o : OrdersList) {
			Object[] rowData = { /*o.getId(),*/ o.getOrderno(), o.getBarcode(), o.getEmployeeno(), o.getMemberno(), o.getOrderamount(),o.getDate()};
			model.addRow(rowData);
		}
		return model;

	}
	public DefaultTableModel convertListToTableModel(List<Orders> OrdersList) {
		String[] columnNames = { /*"ID",*/ "出貨編號", "條碼", "員工編號", "會員編號", "數量", "日期"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		for (Orders o : OrdersList) {
			Object[] rowData = { /*o.getId(),*/ o.getOrderno(), o.getBarcode(), o.getEmployeeno(), o.getMemberno(), o.getOrderamount(),o.getDate()};
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
	public void clear()
	{
		orderno.setText("");
		barcode.setText("");
		employeeno.setText("");
		memberno.setText("");
		orderamount.setText("");
		date.setDateFormatString("");
	}
	public static void updateTime(JLabel time)
	{
		LocalDateTime localtime=LocalDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss a");
		String FDT=localtime.format(dtf);
		time.setText(FDT);					
	}
}
