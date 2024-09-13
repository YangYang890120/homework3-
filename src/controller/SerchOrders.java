package controller;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import model.Employee;
import model.Orders;
import service.impl.OrderServiceImpl;
import util.cal;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;

public class SerchOrders extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JPanel panel;
	private JTable table;
	public JDateChooser dateChooser_2;
	public JDateChooser dateChooser_1;
	public OrderServiceImpl osi=new OrderServiceImpl();
	private JScrollPane scrollPane;
	private JTextField keyword;
	public JTextArea output;
	private JButton btnNewButton_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SerchOrders frame = new SerchOrders();
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
	public SerchOrders() {
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
	
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 10, 515, 242);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		loadDataToTable();
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy-MM-dd");
		dateChooser_1.setBounds(291, 262, 111, 21);
		panel.add(dateChooser_1);
		
		dateChooser_2 = new JDateChooser();
		dateChooser_2.setDateFormatString("yyyy-MM-dd");
		dateChooser_2.setBounds(424, 262, 111, 21);
		panel.add(dateChooser_2);
		
		keyword = new JTextField();
		keyword.setBounds(155, 262, 111, 21);
		panel.add(keyword);
		keyword.setColumns(10);
		
		JButton btnNewButton = new JButton("關鍵字搜尋");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findByKeyWord();
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton.setBounds(20, 260, 124, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("按日期區間搜尋");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectByDate();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_1.setBounds(20, 317, 153, 23);
		panel.add(btnNewButton_1);
		
		output = new JTextArea();
		output.setBounds(545, 11, 379, 441);
		panel.add(output);
		
		JButton btnNewButton_2 = new JButton("關鍵字及日期區間搜尋");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findByKeyWordAndDate();
			}
		});
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_2.setBounds(20, 378, 209, 23);
		panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("列印");
		btnNewButton_3.addActionListener(new ActionListener() {
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
		btnNewButton_3.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_3.setBounds(20, 429, 87, 23);
		panel.add(btnNewButton_3);
	}
	public void selectByDate()
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date Date_1= dateChooser_1.getDate();
		Date Date_2= dateChooser_2.getDate();
		String DateString1= sdf.format(Date_1);
		String DateString2= sdf.format(Date_2);
		List<Orders> l=osi.selectByDate(DateString1, DateString2);
		DefaultTableModel model = convertListToTableModel_2(l);
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
	public DefaultTableModel convertListToTableModel_2(List<Orders> OrdersList) {
		String[] columnNames = { /*"ID",*/ "出貨編號", "產品名稱", "員工姓名", "會員姓名", "數量", "日期"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		for (Orders o : OrdersList) {
			Object[] rowData = { /*o.getId(),*/ o.getOrderno(), o.getBarcode(), o.getEmployeeno(), o.getMemberno(), o.getOrderamount(),o.getDate()};
			model.addRow(rowData);
		}
		return model;
	}
	public void loadDataToTable() {
		//List<Orders> OrdersList = osi.selectFromView();
		List<Orders> OrdersList = osi.selectAll();
		DefaultTableModel model = convertListToTableModel_2(OrdersList);
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
			List<Orders> l = osi.selectByKeyWord(Keyword);
			DefaultTableModel model = convertListToTableModel_2(l);
			table.setModel(model);
			table.setDefaultEditor(Object.class, null);	
		}
	}
	public void findByKeyWordAndDate() {
		
		String Keyword=keyword.getText();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date Date_1= dateChooser_1.getDate();
		Date Date_2= dateChooser_2.getDate();
		String DateString1= sdf.format(Date_1);
		String DateString2= sdf.format(Date_2);
		
		if(Keyword.equals("關鍵字"))
		{
			loadDataToTable();
		}
		else
		{
			List<Orders> l = osi.selectByKeyWord(Keyword,DateString1,DateString2);
			DefaultTableModel model = convertListToTableModel_2(l);
			table.setModel(model);
			table.setDefaultEditor(Object.class, null);	
		}
	}
}
