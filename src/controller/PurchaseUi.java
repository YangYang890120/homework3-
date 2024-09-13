package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import model.Employee;
import model.Member;
import model.Orders;
import model.Product;
import model.Purchase;
import service.PurchaseService;
import service.impl.ProductServiceImpl;
import service.impl.PurchaseServiceImpl;
import util.JTextFieldHintListener;
import util.cal;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class PurchaseUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pn;
	private JTextField barcode;
	private JTextField en;
	private JTextField pa;
	public JPanel panel;
	public JDateChooser date;
	public PurchaseServiceImpl pusi=new PurchaseServiceImpl();
	public JDateChooser date_1;
	public JDateChooser date_2;
	public JTextArea output;
	private JTable table;
	public ProductServiceImpl psi=new ProductServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseUi frame = new PurchaseUi();
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
	public PurchaseUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 950, 462);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("進貨管理");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 79, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("進貨編號");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 56, 79, 27);
		panel.add(lblNewLabel_1);
		
		pn = new JTextField();
		pn.setText("Pu000");
		pn.addFocusListener(new JTextFieldHintListener(pn,"Pu000"));
		pn.setColumns(10);
		pn.setBounds(109, 59, 99, 21);
		panel.add(pn);
		
		JLabel lblNewLabel_1_1 = new JLabel("商品條碼");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(20, 111, 79, 27);
		panel.add(lblNewLabel_1_1);
		
		barcode = new JTextField();
		barcode.setText("12345678");
		barcode.addFocusListener(new JTextFieldHintListener(barcode,"12345678"));
		barcode.setColumns(10);
		barcode.setBounds(109, 114, 99, 21);
		panel.add(barcode);
		
		JLabel lblNewLabel_1_2 = new JLabel("員工編號");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(20, 164, 79, 27);
		panel.add(lblNewLabel_1_2);
		
		en = new JTextField();
		en.setText("E000");
		en.addFocusListener(new JTextFieldHintListener(en,"E000"));
		en.setColumns(10);
		en.setBounds(109, 167, 99, 21);
		panel.add(en);
		
		JLabel lblNewLabel_1_4 = new JLabel("進貨數量");
		lblNewLabel_1_4.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(20, 212, 79, 27);
		panel.add(lblNewLabel_1_4);
		
		pa = new JTextField();
		pa.setColumns(10);
		pa.setBounds(109, 215, 99, 21);
		panel.add(pa);
		
		JLabel lblNewLabel_2 = new JLabel("日期");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(20, 263, 73, 27);
		panel.add(lblNewLabel_2);
		
		date = new JDateChooser();
		date.setDateFormatString("yyyy-MM-dd");
		date.setBounds(109, 269, 99, 21);
		panel.add(date);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPu();
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 18, 664, 192);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					TableModel model = table.getModel();
					pn.setText(model.getValueAt(selectedRow, 0).toString());
					barcode.setText(model.getValueAt(selectedRow, 1).toString());
					en.setText(model.getValueAt(selectedRow, 2).toString());
					pa.setText(model.getValueAt(selectedRow, 3).toString());
					//String Date=model.getValueAt(selectedRow, 4).toString();
					//date.setDateFormatString(Date);
					pn.setForeground(Color.BLACK);
					barcode.setForeground(Color.BLACK);
					en.setForeground(Color.BLACK);
					
				}
			}
		});
		loadDataToTable();
		
		JLabel lblNewLabel_3 = new JLabel("日期區間");
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(250, 218, 73, 27);
		panel.add(lblNewLabel_3);
		
		date_1 = new JDateChooser();
		date_1.setDateFormatString("yyyy-MM-dd");
		date_1.setBounds(333, 218, 99, 21);
		panel.add(date_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("日期區間");
		lblNewLabel_3_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(500, 218, 73, 27);
		panel.add(lblNewLabel_3_1);
		
		date_2 = new JDateChooser();
		date_2.setDateFormatString("yyyy-MM-dd");
		date_2.setBounds(583, 218, 99, 21);
		panel.add(date_2);
		
		JButton btnNewButton_5 = new JButton("新增進貨單");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectByDate();
				
			}
		});
		btnNewButton_5.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_5.setBounds(692, 218, 125, 23);
		panel.add(btnNewButton_5);
		
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(249, 249, 665, 192);
		panel.add(scrollPane_1);
		
		output = new JTextArea();
		scrollPane_1.setViewportView(output);
		
	}
	public void addPu()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String Purchaseno = pn.getText();
		String Barcode = barcode.getText();
		String Employee = en.getText();
		Integer PurchaseAmount = Integer.parseInt(pa.getText());
		Date Date= date.getDate();
		String DateString = sdf.format(Date);
		if (Purchaseno.isEmpty() ||Barcode.isEmpty() || Employee.isEmpty() ||PurchaseAmount.equals(0)
				|| DateString.isEmpty()) {
			JOptionPane.showMessageDialog(this, "資料不可空白，請填寫完整", "錯誤", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			if(psi.findBarcode(Barcode))
			{
				Purchase p = new Purchase(Purchaseno, Barcode, Employee, PurchaseAmount, DateString);
				pusi.addPurchase(p);
				addToProduct();
				JOptionPane.showMessageDialog(null, "進貨資料新增成功,已將進貨數量加入存貨");
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
		List<Purchase> l=pusi.selectByDate(DateString1, DateString2);
		DefaultTableModel model = convertListToTableModel_2(l);
		table.setModel(model);
		table.setDefaultEditor(Object.class, null);
		Object ob=cal.ReadObiect("Employee.txt");
		Employee m=(Employee)ob;
		Integer Sum=0;
		LocalDateTime localtime=LocalDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
		String FDT=localtime.format(dtf);
		String Purchase = m.getName()+" 出貨單                                                         列印日期:"+FDT+
			"\n==================================================================================================\n";
		for(Purchase o:l)
		{
			Purchase+=(
			"進貨編號:"+o.getPurchaseno()+" 員工姓名:"+o.getEmployeeno()+" 數量:"+o.getPurchaseAmount()+" 日期"+o.getDate()+"\t總額"+o.getSum()+"\n"+
			"---------------------------------------------------------------------------------------------------------------\n");
			Sum=Sum+o.getSum();
		}
		Purchase+=" -------------------------------------------------------------------------------------- 總金額:"+Sum;
		output.setText(Purchase);
	}
	public void addToProduct()
	{
		Integer PurchaseAmount =Integer.parseInt(pa.getText());
		System.out.println(PurchaseAmount);
		String Barcode=barcode.getText();
		Product p=psi.findByBarcode(Barcode);		
		psi.updateByOrderamount(Barcode,(p.getAmount()+PurchaseAmount));
		clear();
	}
	public void update(){
		if(pn.getText()!="")
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String Purchaseno=pn.getText();
			String Barcode=barcode.getText();
			String Employee=en.getText();
			Integer PurchaseAmount=Integer.parseInt(pa.getText());
			Date Date= date.getDate();
			String DateString = sdf.format(Date);
			//String Date=date.getDateFormatString();
			if (Purchaseno.isEmpty() ||Barcode.isEmpty() || Employee.isEmpty() || PurchaseAmount.equals(0)|| DateString.isEmpty()) {
				JOptionPane.showMessageDialog(this, "資料不可空白，請填寫完整", "錯誤", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				if(psi.findBarcode(Barcode))
				{
					JOptionPane.showMessageDialog(null, "進貨資料新增成功");
					pusi.update(Purchaseno,Barcode,Employee,PurchaseAmount,DateString);
					clear();
				}
				else
				{
					JOptionPane.showMessageDialog(this, "查無此商品條碼", "錯誤", JOptionPane.ERROR_MESSAGE);
		}}}}
	public void updateToProduct(){
		if(pn.getText()!="")
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String Purchaseno=pn.getText();
			String Barcode=barcode.getText();
			String Employee=en.getText();
			Integer PurchaseAmount=Integer.parseInt(pa.getText());
			Date Date= date.getDate();
			String DateString = sdf.format(Date);
			Purchase pu=pusi.selectByPurchaseno(Purchaseno);
			Product p=psi.findByBarcode(Barcode);
			if (Purchaseno.isEmpty() ||Barcode.isEmpty() || Employee.isEmpty() || PurchaseAmount.equals(0)|| DateString.isEmpty()) {
				JOptionPane.showMessageDialog(this, "資料不可空白，請填寫完整", "錯誤", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
			
				if(psi.findBarcode(Barcode))
				{
					JOptionPane.showMessageDialog(null, "進貨資料修改成功");
					psi.updateByOrderamount(Barcode, p.getAmount()+(PurchaseAmount-pu.getPurchaseAmount()));
					pusi.update(Purchaseno,Barcode,Employee,PurchaseAmount,DateString);
					clear();
				}
				else
				{
					JOptionPane.showMessageDialog(this, "查無此商品條碼", "錯誤", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	public void delete()
	{
		if (pn.getText() != "") {
			int reply = JOptionPane.showConfirmDialog(null, "確定刪除這筆資料?", "刪除確認", JOptionPane.OK_CANCEL_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				String Pn= pn.getText();
				pusi.delete(Pn);;
				JOptionPane.showMessageDialog(null, "進貨資料刪除成功");
				clear();
			}
		} else {
			JOptionPane.showMessageDialog(null, "請選擇要刪除的資料");
		}
	}
	public DefaultTableModel convertListToTableModel_2(List<Purchase> PurchaseList) {
		String[] columnNames = { /*"ID",*/ "進貨編號", "商品名稱", "員工姓名", "數量","總額", "日期"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		for (Purchase p : PurchaseList) {
			Object[] rowData = { /*o.getId(),*/ p.getPurchaseno(), p.getBarcode(), p.getEmployeeno(), p.getPurchaseAmount(),p.getSum(),p.getDate()};
			model.addRow(rowData);
		}
		return model;

	}
	public DefaultTableModel convertListToTableModel(List<Purchase> PurchaseList) {
		String[] columnNames = { /*"ID",*/ "進貨編號", "條碼", "員工編號", "數量", "日期"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		for (Purchase p : PurchaseList) {
			Object[] rowData = { /*o.getId(),*/ p.getPurchaseno(), p.getBarcode(), p.getEmployeeno(), p.getPurchaseAmount(),p.getDate()};
			model.addRow(rowData);
		}
		return model;

	}
	public void loadDataToTable() {
		List<Purchase> PurchaseList = pusi.selectPurchase();
		DefaultTableModel model = convertListToTableModel(PurchaseList);
		table.setModel(model);
		table.setDefaultEditor(Object.class, null);
	}
	public void clear()
	{
		pn.setText("");
		barcode.setText("");
		en.setText("");
		pa.setText("");
		date.setDateFormatString("");
	}
	}

