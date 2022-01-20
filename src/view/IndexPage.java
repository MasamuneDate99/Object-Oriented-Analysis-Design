package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import controller.BillController;
import controller.BillDetailController;
import controller.EmployeeController;
import controller.MedicineController;
import controller.PatientController;
import controller.PatientDetailController;
import controller.RoleController;
import model.Bill;

public class IndexPage extends JFrame implements ChangeListener {
	
	private BillController billController;
	private BillDetailController billDetailController;
	private EmployeeController employeeController;
	private MedicineController medicineController;
	private PatientController patientController;
	private PatientDetailController detailController;
	private RoleController roleController;

	JPanel northPanel, centerPanel, southPanel, insertPanel, updatePanel, deletePanel;
	JLabel listLbl, idLbl, titleLbl, artistLbl, albumLbl;
	JLabel idULbl, titleULbl, artistULbl, albumULbl;
	JTextField idTxt, titleTxt, artistTxt, albumTxt;
	JTextField idUTxt, titleUTxt, artistUTxt, albumUTxt;
	JButton insertBtn, updateBtn, deleteBtn;
	JTable table;
	DefaultTableModel data;
	JScrollPane scroll;
	JTabbedPane tabs;

	JLabel billIDAdminLbl, employeeAdminLbl, patientAdminLbl, dateTimeCreatedAdminLbl, paymentTypeAdminLbl,
			statusAdminLbl, billDetailIDAdminLbl, medicineAdminLbl, medicineQuantityAdminLbl;
	JTextField billAdminTxt, employeeAdminTxt, patientAdminTxt, dateTimeCreatedAdminTxt, paymentTypeAdminTxt,
			statusAdminTxt, billDetailIDAdminTxt, medicineAdminTxt, medicineQuantityAdminTxt;
	JButton insertAdminBtn;

	JLabel medicineIDPharmacistLbl, medicineNamePharmacistLbl, medicinePricePharmacistLbl, medicineStockPharmacistLbl;
	JTextField medicineIDPharmacistTxt, medicineNamePharmacistTxt, medicinePricePharmacistTxt,
			medicineStockPharmacistTxt;
	JButton insertPharmacistBtn, updatePharmacistBtn, deletePharmacistBtn;

	JLabel patientIDDoctorLbl, NameDoctorLbl, dobDoctorLbl, patientDetailIDDoctorLbl, patientDoctorLbl,
			employeeDoctorLbl, symptomDoctorLbl, checkDateDoctorLbl;
	JTextField patientIDDoctorTxt, NameDoctorTxt, dobDoctorTxt, patientDetailIDDoctorTxt, patientDoctorTxt,
			employeeDoctorTxt, symptomDoctorTxt, checkDateDoctorTxt;
	JButton insertDoctorBtn, updateDoctorBtn, deleteDoctorBtn;

	JLabel employeeIDHRLbl, employeeRoleHRLbl, employeeNameHRLbl, employeeUsernameHRLbl, employeePasswordHRLbl,
			employeeSalaryHRLbl, employeeStatusHRLbl;
	JTextField employeeIDHRTxt, employeeRoleHRTxt, employeeNameHRTxt, employeeUsernameHRTxt, employeePasswordHRTxt,
			employeeSalaryHRTxt, employeeStatusHRTxt;
	JButton insertHRBtn, updateHRBtn, deleteHRBtn;


	public void initHR() {
		employeeIDHRLbl = new JLabel("Employee ID");
		employeeRoleHRLbl = new JLabel("Employee Role");
		employeeNameHRLbl = new JLabel("Employee Name");
		employeeUsernameHRLbl = new JLabel("Employee Username");
		employeePasswordHRLbl = new JLabel("Employee Password");
		employeeSalaryHRLbl = new JLabel("Employee Salary");
		employeeStatusHRLbl = new JLabel("Employee Status");

		employeeIDHRTxt = new JTextField();
		employeeRoleHRTxt = new JTextField();
		employeeNameHRTxt = new JTextField();
		employeeUsernameHRTxt = new JTextField();
		employeePasswordHRTxt = new JTextField();
		employeeSalaryHRTxt = new JTextField();
		employeeStatusHRTxt = new JTextField();

		insertHRBtn = new JButton("Insert");
		updateHRBtn = new JButton("Update");
		deleteHRBtn = new JButton("Delete");

	}

	public void initDoctor() {
		patientIDDoctorLbl = new JLabel("Patient ID");
		NameDoctorLbl = new JLabel("Name");
		dobDoctorLbl = new JLabel("Date of Birth");
		patientDetailIDDoctorLbl = new JLabel("Patient Detail ID");
		patientDoctorLbl = new JLabel("Patient");
		employeeDoctorLbl = new JLabel("Employee");
		symptomDoctorLbl = new JLabel("Symptom");
		checkDateDoctorLbl = new JLabel("Check Date");

		patientIDDoctorTxt = new JTextField();
		NameDoctorTxt = new JTextField();
		dobDoctorTxt = new JTextField();
		patientDetailIDDoctorTxt = new JTextField();
		patientDoctorTxt = new JTextField();
		employeeDoctorTxt = new JTextField();
		symptomDoctorTxt = new JTextField();
		checkDateDoctorTxt = new JTextField();

		insertDoctorBtn = new JButton("Insert");
		updateDoctorBtn = new JButton("Update");
		deleteDoctorBtn = new JButton("Delete");

	}

	public void initPharmacist() {
		medicineIDPharmacistLbl = new JLabel("Medicine ID");
		medicineNamePharmacistLbl = new JLabel("Medicine Name");
		medicinePricePharmacistLbl = new JLabel("Medicine Price");
		medicineStockPharmacistLbl = new JLabel("Medicine Stock");

		medicineIDPharmacistTxt = new JTextField();
		medicineNamePharmacistTxt = new JTextField();
		medicinePricePharmacistTxt = new JTextField();
		medicineStockPharmacistTxt = new JTextField();

		insertPharmacistBtn = new JButton("Insert");
		updatePharmacistBtn = new JButton("Update");
		deletePharmacistBtn = new JButton("Delete");

	}

	public void initAdmin() {
		billIDAdminLbl = new JLabel("Bill ID");
		employeeAdminLbl = new JLabel("Employee");
		patientAdminLbl = new JLabel("Patient");
		dateTimeCreatedAdminLbl = new JLabel("Date Time Created");
		paymentTypeAdminLbl = new JLabel("Payment Type");
		statusAdminLbl = new JLabel("Status");
		billDetailIDAdminLbl = new JLabel("Bill Detail");
		medicineAdminLbl = new JLabel("Medicine");
		medicineQuantityAdminLbl = new JLabel("Medicine Quantitiy");

		billAdminTxt = new JTextField();
		employeeAdminTxt = new JTextField();
		patientAdminTxt = new JTextField();
		dateTimeCreatedAdminTxt = new JTextField();
		paymentTypeAdminTxt = new JTextField();
		statusAdminTxt = new JTextField();
		billDetailIDAdminTxt = new JTextField();
		medicineAdminTxt = new JTextField();
		medicineQuantityAdminTxt = new JTextField();

		insertAdminBtn = new JButton("Insert");
	}

	public IndexPage() {
		init();

		setVisible(true);
		setResizable(false);
		setSize(new Dimension(1000, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void addListener() {
		insertAdminBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String billID = billAdminTxt.getText();
				String employee = employeeAdminTxt.getText();
				String patient = patientAdminTxt.getText();
				String dateCreated = dateTimeCreatedAdminTxt.getText();
				String paymentType = paymentTypeAdminTxt.getText();
				String status = statusAdminTxt.getText();
				String billDetailID = billDetailIDAdminTxt.getText();
				String medicine = medicineAdminTxt.getText();
				String medicineQty = medicineQuantityAdminTxt.getText();
				
				if(billID.isEmpty() || employee.isEmpty() || patient.isEmpty() || dateCreated.isEmpty() || billDetailID.isEmpty() || medicine.isEmpty() || medicineQty.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bill ID, Employee, Patient, Date Time Created, Bill Detail ID, Medicine, Medicine Qty must be filled");
				}else {
					int billId = billController.index().size() + 1;
					Bill bill = new Bill();
					bill.setBill_ID(billId);
					bill.setStatus(status);
					bill.setPatientID(Integer.parseInt(patient));	
					bill.setEmployeeID(Integer.parseInt(employee));
					bill.setPaymentType(paymentType);
					
					
					billController.create(bill);
				}
				
				
			}
		});
		
		insertBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String medicineID = medicineIDPharmacistTxt.getText();
				String medicineName = medicineNamePharmacistTxt.getText();
				String medicinePrice = medicinePricePharmacistTxt.getText();
				String medicineStock = medicineStockPharmacistTxt.getText();
				
				if(medicineID.isEmpty() || medicineName.isEmpty() || medicinePrice.isEmpty()){
					JOptionPane.showMessageDialog(null, "Medicine ID, Medicine Name, Medicine Price");
				}else {
					
				}
			}
		});
		
		insertBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String patientID = patientIDDoctorTxt.getText();
				String name = NameDoctorTxt.getText();
				String dob = dobDoctorTxt.getText();
				String patientDetailID = patientDetailIDDoctorTxt.getText();
				String patient = patientDoctorTxt.getText();
				String employee = employeeDoctorTxt.getText();
				String symptom = symptomDoctorTxt.getText();
				String checkDate = checkDateDoctorTxt.getText();
				
				if(patientID.isEmpty() || name.isEmpty() || dob.isEmpty() || patient.isEmpty() || employee.isEmpty() || symptom.isEmpty() || checkDate.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Patient ID, Name, Date of Birth, Patient Detail ID, Patient, Employee(Doctor), Symtpom, Check Date must be filled");
				}else {
					
				}
			}
		});
		
		insertBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String employeeID = employeeIDHRTxt.getText();
				String employeeRole = employeeRoleHRTxt.getText();
				String employeeName = employeeNameHRTxt.getText();
				String employeeUsername = employeeUsernameHRTxt.getText();
				String employeePassword = employeePasswordHRTxt.getText();
				String employeeSalary = employeeSalaryHRTxt.getText();
				String employeeStatus = employeeStatusHRTxt.getText();
				
				if(employeeID.isEmpty() || employeeRole.isEmpty() || employeeName.isEmpty() || employeeUsername.isEmpty() || employeePassword.isEmpty() || employeeSalary.isEmpty() || employeeStatus.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Employee ID, Employee Role, Employee Name, Employee Username, Employee Password, Employee Salary, Employee Status must be filled")
				}
				
			}
		});
	}

	public void init() {
		northPanel = new JPanel();
		centerPanel = new JPanel(new GridLayout(2, 1));
		southPanel = new JPanel();
		insertPanel = new JPanel(new GridLayout(3, 2));
		updatePanel = new JPanel(new GridLayout(4, 2));
		deletePanel = new JPanel(new GridLayout(1, 2));

		listLbl = new JLabel("Mo Ware Hospital");

		// Delete
		idLbl = new JLabel("Song ID");

		// Insert
		titleLbl = new JLabel("Bill ID");
		artistLbl = new JLabel("");
		albumLbl = new JLabel("Song Album");

		// Update
		idULbl = new JLabel("Song ID");
		titleULbl = new JLabel("Song Title");
		artistULbl = new JLabel("Song Artist");
		albumULbl = new JLabel("Song Album");

		// Delete
		idTxt = new JTextField();

		// Insert
		titleTxt = new JTextField();
		albumTxt = new JTextField();
		artistTxt = new JTextField();

		// Update
		idUTxt = new JTextField();
		titleUTxt = new JTextField();
		albumUTxt = new JTextField();
		artistUTxt = new JTextField();

		insertBtn = new JButton("Insert");
		updateBtn = new JButton("Update");
		deleteBtn = new JButton("Delete");

		tabs = new JTabbedPane();

		Vector<Object> header = new Vector<>();
		header.add("ID");
		header.add("Title");
		header.add("Artist");
		header.add("Album");

		data = new DefaultTableModel(header, 0);
		table = new JTable(data) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};

		addListener();

		scroll = new JScrollPane(table);

		northPanel.add(listLbl);

		deletePanel.add(idLbl);
		deletePanel.add(idTxt);

		insertPanel.add(titleLbl);
		insertPanel.add(titleTxt);
		insertPanel.add(artistLbl);
		insertPanel.add(artistTxt);
		insertPanel.add(albumLbl);
		insertPanel.add(albumTxt);

		updatePanel.add(idULbl);
		updatePanel.add(idUTxt);
		updatePanel.add(titleULbl);
		updatePanel.add(titleUTxt);
		updatePanel.add(artistULbl);
		updatePanel.add(artistUTxt);
		updatePanel.add(albumULbl);
		updatePanel.add(albumUTxt);

		tabs.add("Insert Song", insertPanel);
		tabs.add("Update Song", updatePanel);
		tabs.add("Delete Song", deletePanel);

		centerPanel.add(scroll);
		centerPanel.add(tabs);

		southPanel.add(insertBtn);
		southPanel.add(updateBtn);
		southPanel.add(deleteBtn);

		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
	}

	public void addListener() {
		insertBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String title = titleTxt.getText();
				String artist = artistTxt.getText();
				String album = albumTxt.getText();

			}
		});

		updateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = idUTxt.getText();
				String title = titleUTxt.getText();
				String artist = artistUTxt.getText();
				String album = albumUTxt.getText();

				if (id.isEmpty() || title.isEmpty() || artist.isEmpty() || album.isEmpty()) {
					JOptionPane.showMessageDialog(null, "ID, Title, Artist, and Album fields must be filled");
				} else {
					int songId = Integer.parseInt(id);
//					listSong.set(songId - 1, new Song(songId, title, artist, album));

					setData();

					idUTxt.setText("");
					titleUTxt.setText("");
					artistUTxt.setText("");
					albumUTxt.setText("");
				}
			}
		});

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idTxt.getText();
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int selectedTab = tabs.getSelectedIndex();
				if (selectedTab == 0) {
					titleTxt.setText(data.getValueAt(row, 1).toString());
					artistTxt.setText(data.getValueAt(row, 2).toString());
					albumTxt.setText(data.getValueAt(row, 3).toString());

					idTxt.setText("");
					idUTxt.setText("");
					titleUTxt.setText("");
					artistUTxt.setText("");
					albumUTxt.setText("");
				} else if (selectedTab == 1) {
					idUTxt.setText(data.getValueAt(row, 0).toString());
					titleUTxt.setText(data.getValueAt(row, 1).toString());
					artistUTxt.setText(data.getValueAt(row, 2).toString());
					albumUTxt.setText(data.getValueAt(row, 3).toString());

					idTxt.setText("");
					titleTxt.setText("");
					artistTxt.setText("");
					albumTxt.setText("");
				} else {
					idTxt.setText(data.getValueAt(row, 0).toString());

					titleTxt.setText("");
					artistTxt.setText("");
					albumTxt.setText("");
					idUTxt.setText("");
					titleUTxt.setText("");
					artistUTxt.setText("");
					albumUTxt.setText("");
				}
			}
		});

		tabs.addChangeListener(this);
	}

	public void setData() {
		data.setRowCount(0);

//		for (Song song : listSong) {
//			Vector<Object> rowData = new Vector<>();
//			rowData.add(song.getId());
//			rowData.add(song.getTitle());
//			rowData.add(song.getArtist());
//			rowData.add(song.getAlbum());
//			data.addRow(rowData);
//		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		tabs = (JTabbedPane) e.getSource();
		int selectedTab = tabs.getSelectedIndex();

		if (selectedTab == 0) {
			insertBtn.setEnabled(true);
			deleteBtn.setEnabled(false);
			updateBtn.setEnabled(false);
		} else if (selectedTab == 1) {
			deleteBtn.setEnabled(false);
			insertBtn.setEnabled(false);
			updateBtn.setEnabled(true);
		} else {
			deleteBtn.setEnabled(true);
			insertBtn.setEnabled(false);
			updateBtn.setEnabled(false);
		}
	}

}
