//package view;
//
//import java.awt.BorderLayout;
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Vector;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTabbedPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//import javax.swing.table.DefaultTableModel;
//
//import connect.Connect;
//import model.Medicine;
//
//public class PharmacistPage extends JFrame implements ChangeListener {
//	JPanel northPanel, centerPanel, southPanel, insertPanel, updatePanel, deletePanel;
//	JLabel listLbl, idLbl, nameLbl, priceLbl, stockLbl;
//	JLabel idULbl, nameULbl, priceULbl, stockULbl;
//	JTextField idTxt, nameTxt, priceTxt, stockTxt;
//	JTextField idUTxt, nameUTxt, priceUTxt, stockUTxt;
//	JButton insertBtn, updateBtn, deleteBtn;
//	JTable table;
//	DefaultTableModel medicinedata;
//	JScrollPane scroll;
//	JTabbedPane tabs;
//
//	Vector<Medicine> listMedicine = new Vector<>();
//	//buat object dari connect
//	Connect con = Connect.getConnection();
//
//	public PharmacistPage() {
//		// TODO Auto-generated constructor stub
//		init();
//
//		setVisible(true);
//		setResizable(false);
//		setSize(new Dimension(1000, 700));
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setLocationRelativeTo(null);
//		
//		//select all data
//		GetAllMedicine();
//	}
//	
//	
//	public void init() {
//		northPanel = new JPanel();
//		centerPanel = new JPanel(new GridLayout(2, 1));
//		southPanel = new JPanel();
//		insertPanel = new JPanel(new GridLayout(3, 2));
//		updatePanel = new JPanel(new GridLayout(4, 2));
//		deletePanel = new JPanel(new GridLayout(1, 2));
//
//		listLbl = new JLabel("Medicine List");
//
//		// Delete
//		idLbl = new JLabel("Medicine ID");
//
//		// Insert
//		nameLbl = new JLabel("Medicine Name");
//		priceLbl = new JLabel("Medicine Price");
//		stockLbl = new JLabel("Medicine Stock");
//
//		// Update
//		idULbl = new JLabel("Medicine ID");
//		nameULbl = new JLabel("Medicine Name");
//		priceULbl = new JLabel("Medicine Price");
//		stockULbl = new JLabel("Medicine Stock");
//
//		// Delete
//		idTxt = new JTextField();
//
//		// Insert
//		nameTxt = new JTextField();
//		priceTxt = new JTextField();
//		stockTxt = new JTextField();
//
//		// Update
//		idUTxt = new JTextField();
//		nameUTxt = new JTextField();
//		priceUTxt = new JTextField();
//		stockUTxt = new JTextField();
//
//		insertBtn = new JButton("Insert");
//		updateBtn = new JButton("Update");
//		deleteBtn = new JButton("Delete");
//
//		tabs = new JTabbedPane();
//
//		Vector<Object> header = new Vector<>();
//		header.add("ID");
//		header.add("Name");
//		header.add("Price");
//		header.add("Stock");
//
//		medicinedata = new DefaultTableModel(header, 0);
//		table = new JTable(medicinedata) {
//			public boolean isCellEditable(int row, int column) {
//				return false;
//			};
//		};
//
//		addListener();
//
//		scroll = new JScrollPane(table);
//
//		northPanel.add(listLbl);
//
//		deletePanel.add(idLbl);
//		deletePanel.add(idTxt);
//
//		insertPanel.add(nameLbl);
//		insertPanel.add(nameTxt);
//		insertPanel.add(priceLbl);
//		insertPanel.add(priceTxt);
//		insertPanel.add(stockLbl);
//		insertPanel.add(stockTxt);
//
//		updatePanel.add(idULbl);
//		updatePanel.add(idUTxt);
//		updatePanel.add(nameULbl);
//		updatePanel.add(nameUTxt);
//		updatePanel.add(priceULbl);
//		updatePanel.add(priceUTxt);
//		updatePanel.add(stockULbl);
//		updatePanel.add(stockUTxt);
//
//		tabs.add("Insert Song", insertPanel);
//		tabs.add("Update Song", updatePanel);
//		tabs.add("Delete Song", deletePanel);
//
//		centerPanel.add(scroll);
//		centerPanel.add(tabs);
//
//		southPanel.add(insertBtn);
//		southPanel.add(updateBtn);
//		southPanel.add(deleteBtn);
//
//		add(northPanel, BorderLayout.NORTH);
//		add(centerPanel, BorderLayout.CENTER);
//		add(southPanel, BorderLayout.SOUTH);
//	}
//	
//	public void addListener() {
//		insertBtn.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String name = nameTxt.getText();
//				String price = priceTxt.getText();
//				String stock = stockTxt.getText();
//
//				if (name.isEmpty() || price.isEmpty() || stock.isEmpty()) {
//					JOptionPane.showMessageDialog(null, "Name, Price, and Stock fields must be filled");
//				} else {
//					int medicinePrice = Integer.parseInt(price);
//					
//					String query = "INSERT INTO medicine VALUES (NULL, ?, ?, ?)";
//					PreparedStatement ps = con.prepareStatement(query);
//					
//					ResultSet rs = null;
//					try {
//						ps.setString(1, name);
//						ps.setInt(2, medicinePrice);
//						ps.setString(3, stock);
//						ps.execute();
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					//refresh data agar data tidak berulang
//					medicinedata.setNumRows(0);
//					
//					//load data lagi agar ke update di tampilannya
//					loadSong(con.executeQuery("SELECT * FROM Song"));
//					
//					idTxt.setText("");
//					nameTxt.setText("");
//					priceTxt.setText("");
//					stockTxt.setText("");
//				}
//			}
//		});
//		
//		updateBtn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				String id = idUTxt.getText();
//				String title = titleUTxt.getText();
//				String artist = artistUTxt.getText();
//				String album = albumUTxt.getText();
//
//				if (id.isEmpty() || title.isEmpty() || artist.isEmpty() || album.isEmpty()) {
//					JOptionPane.showMessageDialog(null, "ID, Title, Artist, and Album fields must be filled");
//				} else {
//				int songId = Integer.parseInt(id);
//					
//					String query = "UPDATE song SET title = ?, artist = ?, album = ? WHERE id = ?";
//					PreparedStatement ps = con.prepareStatement(query);
//					
//					try {
//						ps.setString(1, title);
//						ps.setString(2, artist);
//						ps.setString(3, album);
//						ps.setInt(4, songId);
//						ps.execute();
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					idUTxt.setText("");
//					titleUTxt.setText("");
//					artistUTxt.setText("");
//					albumUTxt.setText("");
//					
//					data.setNumRows(0);
//					loadSong(con.executeQuery("SELECT * FROM song"));
//				}
//			}
//		});
//		
//		deleteBtn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String id = idTxt.getText();
//				if (id.isEmpty()) {
//					JOptionPane.showMessageDialog(null, "ID must be filled");
//				} else {
//					int songId = Integer.parseInt(id);
////					listSong.remove(songId - 1);
////
////					setData();
//					
//					String query = "DELETE FROM song WHERE id = ?";
//					
//					PreparedStatement ps = con.prepareStatement(query);
//					try {
//						ps.setInt(1, songId);
//						ps.execute();
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//					medicinedata.setNumRows(0);
//					loadSong(con.executeQuery("SELECT * FROM song"));
//
//					idTxt.setText("");
//				}
//				
//			}
//		});
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				int row = table.getSelectedRow();
//				int selectedTab = tabs.getSelectedIndex();
//				if (selectedTab == 0) {
//					titleTxt.setText(data.getValueAt(row, 1).toString());
//					artistTxt.setText(data.getValueAt(row, 2).toString());
//					albumTxt.setText(data.getValueAt(row, 3).toString());
//
//					idTxt.setText("");
//					idUTxt.setText("");
//					titleUTxt.setText("");
//					artistUTxt.setText("");
//					albumUTxt.setText("");
//				} else if (selectedTab == 1) {
//					idUTxt.setText(data.getValueAt(row, 0).toString());
//					titleUTxt.setText(data.getValueAt(row, 1).toString());
//					artistUTxt.setText(data.getValueAt(row, 2).toString());
//					albumUTxt.setText(data.getValueAt(row, 3).toString());
//
//					idTxt.setText("");
//					titleTxt.setText("");
//					artistTxt.setText("");
//					albumTxt.setText("");
//				} else {
//					idTxt.setText(data.getValueAt(row, 0).toString());
//
//					titleTxt.setText("");
//					artistTxt.setText("");
//					albumTxt.setText("");
//					idUTxt.setText("");
//					titleUTxt.setText("");
//					artistUTxt.setText("");
//					albumUTxt.setText("");
//				}
//			}
//		});
//
//		tabs.addChangeListener(this);
//	}
//	
//	// dari arraylist/vector
//	public void setData() {
//		medicinedata.setRowCount(0);
//
//		for (Song song : listSong) {
//			Vector<Object> rowData = new Vector<>();
//			rowData.add(song.getId());
//			rowData.add(song.getTitle());
//			rowData.add(song.getArtist());
//			rowData.add(song.getAlbum());
//			data.addRow(rowData);
//		}
//	}
//	
//	//load data dari database untuk ditampilkan di gui
//	private void loadSong(ResultSet rs) {
//		try {
//			while(rs.next()) {
//				//buat variable untuk nampung masing" data
//				int id = rs.getInt("id");
//				String title = rs.getString("title");
//				String artist = rs.getString("artist");
//				String album = rs.getString("album");
//				
//				//tampung data variable ke vector/arraylist
//				//karena gk tau object secara spesifik, jadi mengguankan datatype object
//				Vector<Object> rowData = new Vector<>();
//				
//				//add masing" atribut ny
//				rowData.add(id);
//				rowData.add(title);
//				rowData.add(artist);
//				rowData.add(album);
//				
//				//add row data ke dalam defaultTabelmodel kita untuk dapat tampil
//				data.addRow(rowData);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public void GetAllMedicine() {
//		Medicine medicine = new Medicine();
//		listMedicine = medicine.GetAllMedicine();  
//		for(int i = 0; i<listMedicine.size(); i++) {
//			Vector<Object> rows = new Vector<>();
//			rows.add(listMedicine.get(i).getMedicineID());
//			rows.add(listMedicine.get(i).getMName());
//			rows.add(listMedicine.get(i).getMPrice());
//			rows.add(listMedicine.get(i).getMStock());
//			medicinedata.addColumn(rows);
//			
//		}
//	}
//
//	@Override
//	public void stateChanged(ChangeEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
