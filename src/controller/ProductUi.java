package controller;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Orders;
import model.Product;
import model.Purchase;
import service.impl.ProductServiceImpl;
import util.JTextFieldHintListener;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
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
import java.awt.event.ActionEvent;

public class ProductUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField productno;
	private JTextField Pname;
	private JTextField barcode;
	private JTextField price;
	private JTextField amount;
	private JTable table;
	public ProductServiceImpl psi=new ProductServiceImpl();
	public JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductUi frame = new ProductUi();
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
	public ProductUi() {
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
		
		JLabel lblNewLabel = new JLabel("存貨資料");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 79, 28);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("商品編號");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 56, 79, 28);
		panel.add(lblNewLabel_1);
		
		productno = new JTextField();
		productno.setText("P000");
		productno.addFocusListener(new JTextFieldHintListener(productno,"P000"));
		productno.setBounds(109, 60, 96, 21);
		panel.add(productno);
		productno.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("商品名稱");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(20, 160, 64, 28);
		panel.add(lblNewLabel_1_1);
		
		Pname = new JTextField();
		Pname.setColumns(10);
		Pname.setBounds(109, 164, 96, 21);
		panel.add(Pname);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("商品條碼");
		lblNewLabel_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(20, 105, 64, 28);
		panel.add(lblNewLabel_1_1_1);
		
		barcode = new JTextField();
		barcode.setColumns(10);
		barcode.setBounds(109, 109, 96, 21);
		panel.add(barcode);
		
		JLabel label2 = new JLabel("商品價格");
		label2.setFont(new Font("新細明體", Font.PLAIN, 16));
		label2.setBounds(20, 219, 64, 28);
		panel.add(label2);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(109, 223, 96, 21);
		panel.add(price);
		
		JLabel label2_1 = new JLabel("商品數量");
		label2_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		label2_1.setBounds(20, 283, 64, 28);
		panel.add(label2_1);
		
		amount = new JTextField();
		amount.setColumns(10);
		amount.setBounds(109, 287, 96, 21);
		panel.add(amount);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(241, 22, 666, 403);
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
					productno.setText(model.getValueAt(selectedRow, 0).toString());
					barcode.setText(model.getValueAt(selectedRow, 1).toString());
					Pname.setText(model.getValueAt(selectedRow, 2).toString());
					price.setText(model.getValueAt(selectedRow, 3).toString());
					amount.setText(model.getValueAt(selectedRow, 4).toString());
					productno.setForeground(Color.BLACK);
				}
			}
		});
		loadDataToTable();
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addP();
				loadDataToTable();
				
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton.setBounds(20, 335, 87, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查詢");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDataToTable();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_1.setBounds(118, 335, 87, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("修改");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				loadDataToTable();
			}
		});
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_2.setBounds(20, 402, 87, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("刪除");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				loadDataToTable();
			}
		});
		btnNewButton_3.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_3.setBounds(118, 402, 87, 23);
		panel.add(btnNewButton_3);
	}
	public void addP() {
		
		String Productno = productno.getText();
		String Barcode = barcode.getText();
		String Productname = Pname.getText();
		Integer Price = Integer.parseInt(price.getText());
		Integer Amount = Integer.parseInt(amount.getText());
		boolean p=psi.findBarcode(Barcode);

		if (Productno.isEmpty() ||Barcode.isEmpty() || Productname.isEmpty() || Price.equals(0) || Amount<0) {
			JOptionPane.showMessageDialog(this, "資料不可空白，請填寫完整", "錯誤", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			
			if(p)
			{
				JOptionPane.showMessageDialog(this, "商品已存在,請確認條碼是否重複","錯誤", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
					Product p1 = new Product(Productno,Barcode,Productname,Price,Amount);	
					psi.addProduct(p1);	
					JOptionPane.showMessageDialog(null, "成功新增商品");
		}}}
	public void update(){
		if(productno.getText()!="")
		{
		
			String Productno = productno.getText();
			String Barcode = barcode.getText();
			String Productname = Pname.getText();
			Integer Price = Integer.parseInt(price.getText());
			Integer Amount = Integer.parseInt(amount.getText());

			if (Productno.isEmpty() ||Barcode.isEmpty() || Productname.isEmpty() || Price.equals(0) || Amount.equals(0)) {
				JOptionPane.showMessageDialog(this, "資料不可空白，請填寫完整", "錯誤", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				JOptionPane.showMessageDialog(null, "存貨資料修改成功");
				psi.update(Productno, Productname, Barcode, Price, Amount);
				//clear();
					
			}
		}
	}
	
	public DefaultTableModel convertListToTableModel(List<Product> ProductList) {
		String[] columnNames = { /*"ID",*/ "商品編號", "條碼", "商品名稱", "價格", "存貨"/*, "總額"*/};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		for (Product p : ProductList) {
			Object[] rowData = { /*o.getId(),*/ p.getProductno(), p.getBarcode(), p.getProductname(), p.getPrice(), p.getAmount()/*,p.getSum()*/};
			model.addRow(rowData);
		}
		return model;

	}
	public void loadDataToTable() {
		List<Product> ProductList = psi.selcetP();
		DefaultTableModel model = convertListToTableModel(ProductList);
		table.setModel(model);
		table.setDefaultEditor(Object.class, null);
	}
	public void delete()
	{
		if (productno.getText() != "") {
			int reply = JOptionPane.showConfirmDialog(null, "確定刪除這筆資料?", "刪除確認", JOptionPane.OK_CANCEL_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				String Productno= productno.getText();
				psi.delete(Productno);;
				JOptionPane.showMessageDialog(null, "商品資料刪除成功");
				clear();
			}
		} else {
			JOptionPane.showMessageDialog(null, "請選擇要刪除的資料");
		}
	}
	public void clear()
	{
		productno.setText("");
		barcode.setText("");
		Pname.setText("");
		price.setText("");
		amount.setText("");
	}
}
