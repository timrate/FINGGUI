package Fing_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GUI2 extends JFrame {

  /**
	 * 
	 */
	private static final long serialVersionUID = 5053901955983548408L;
	private JPanel contentPane;
	private JTextField sessionNameField;
	private JTextField pathField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 frame = new GUI2();
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
	public GUI2() {
		setTitle("Fing GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIpAddress = new JLabel("Ip Address");
		lblIpAddress.setBounds(10, 27, 86, 14);
		contentPane.add(lblIpAddress);

		final String[] addy = getIPaddresses.GiveInetAddressArray();
		final JComboBox addressBox = new JComboBox(addy);
		addressBox.setBounds(208, 24, 95, 20);
		contentPane.add(addressBox);

		JLabel lblLength = new JLabel("Length");
		lblLength.setBounds(10, 52, 86, 14);
		contentPane.add(lblLength);

		final String[] len = new String[2];
		len[0] = "/24";
		len[1] = "/32";
		final JComboBox lenBox = new JComboBox(len);
		lenBox.setBounds(208, 49, 95, 20);
		contentPane.add(lenBox);

		JLabel lblRounds = new JLabel("Rounds");
		lblRounds.setBounds(10, 77, 86, 14);
		contentPane.add(lblRounds);

		SpinnerModel model = new SpinnerNumberModel(1,1,100,1);
		final JSpinner roundsSpinner = new JSpinner(model);
		roundsSpinner.setBounds(208, 77, 29, 20);
		contentPane.add(roundsSpinner);

		JLabel lblGetDomainNames = new JLabel("Get Domain Names");
		lblGetDomainNames.setBounds(93, 98, 120, 14);
		contentPane.add(lblGetDomainNames);

		JRadioButton getDomainNamesButton = new JRadioButton("Yes");
		getDomainNamesButton.setBounds(44, 119, 52, 23);
		contentPane.add(getDomainNamesButton);

		final JRadioButton dontGetDomainNamesButton = new JRadioButton("No");
		dontGetDomainNamesButton.setBounds(208, 119, 65, 23);
		contentPane.add(dontGetDomainNamesButton);

		ButtonGroup domaingroup = new ButtonGroup();
		domaingroup.add(getDomainNamesButton);
		domaingroup.add(dontGetDomainNamesButton);

		JLabel lblSaveSession = new JLabel("Save Session");
		lblSaveSession.setBounds(10, 152, 86, 14);
		contentPane.add(lblSaveSession);
		
		ItemListener checkListener = new ItemListener()
        {
            public void itemStateChanged(ItemEvent ie)
            {
                sessionNameField.setEditable(ie.getStateChange() == ItemEvent.SELECTED);
            }
        };
		final JCheckBox saveSessionCheck = new JCheckBox("Yes");
		saveSessionCheck.setBounds(208, 148, 65, 23);
		saveSessionCheck.addItemListener(checkListener);
		contentPane.add(saveSessionCheck);

		sessionNameField = new JTextField();
		sessionNameField.setText("Enter Session Name ");
		sessionNameField.setBounds(70, 177, 137, 20);
		contentPane.add(sessionNameField);
		sessionNameField.setColumns(10);


		JLabel lblFormat = new JLabel("Format");
		lblFormat.setBounds(10, 293, 46, 14);
		contentPane.add(lblFormat);
		 
		final ArrayList<String> formatList = new ArrayList<String>();
		
		

      
	
		final JComboBox<String> formatBox = new JComboBox<String>();
		for (int i = 0; i < formatList.size(); i++) 
		    formatBox.addItem(formatList.get(i));

		formatBox.setBounds(208, 290, 84, 20);
		contentPane.add(formatBox);
		ItemListener radioListener = new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
			 if (e.getStateChange() == ItemEvent.SELECTED) {
				 	formatList.clear();
				 	
					formatList.add("html");
					formatList.add("stext");
					formatList.add("xml");
					formatList.add("json");
					formatList.add("text");
					formatList.add("csv");
				 	
					for (int i = 0; i < formatList.size(); i++) 
					    formatBox.addItem(formatList.get(i));
					repaint();
			 }
            }
        };
            ItemListener logListener = new ItemListener()
            {
            public void itemStateChanged(ItemEvent x)
            {
            	if (x.getStateChange() == ItemEvent.SELECTED) {
            		 formatList.clear();
    				 formatList.add("text");
    				 formatList.add("csv");
    				 for (int i = 0; i < formatList.size(); i++) 
    					formatBox.addItem(formatList.get(i));
    					repaint();
            	
             }
            }
       };
        
            
		
		JLabel lblNewLabel = new JLabel("File Path");
		lblNewLabel.setBounds(10, 350, 86, 14);
		contentPane.add(lblNewLabel);

		pathField = new JTextField();
		pathField.setBounds(208, 347, 86, 20);
		contentPane.add(pathField);
		pathField.setColumns(10);
	
		JLabel lblLogOrTable = new JLabel("Log or Table");
		lblLogOrTable.setBounds(112, 224, 120, 14);
		contentPane.add(lblLogOrTable);

		final JRadioButton logRadioButton = new JRadioButton("Log");
		
		logRadioButton.setBounds(44, 245, 52, 23);
		contentPane.add(logRadioButton);
		logRadioButton.addItemListener(logListener);

		JRadioButton tableRadioButton = new JRadioButton("Table");
		tableRadioButton.setBounds(208, 245, 65, 23);
		contentPane.add(tableRadioButton);
		tableRadioButton.addItemListener(radioListener);

		ButtonGroup logOrTablegroup = new ButtonGroup();
		logOrTablegroup.add(logRadioButton);
		logOrTablegroup.add(tableRadioButton);
	

		JButton generateButton = new JButton("Generate!");
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ipIndex = addressBox.getSelectedIndex();
				String ipString = addy[ipIndex];

				int lenIndex = lenBox.getSelectedIndex();
				String lenString = len[lenIndex];

				Integer roundsInt = (Integer) roundsSpinner.getValue();
				String roundsString = roundsInt.toString();
				String getDomainNamesString = new String();
				if (dontGetDomainNamesButton.isSelected()) {
					getDomainNamesString = "-d" + " " + "false";
				} else {
					getDomainNamesString = "";
				}
				String logorTableString = new String();
				if (logRadioButton.isSelected()) {
					logorTableString = "log";
				} else {
					logorTableString = "table";
				}
				String savePath = new String();
				if (saveSessionCheck.isSelected()) {
					savePath = sessionNameField.getText();
					savePath = " --session " + savePath + " ";
				} else {
					savePath = "";
				}

				int formatIndex = formatBox.getSelectedIndex();
				String formatString = formatList.get(formatIndex);

				String filePath = pathField.getText();

				String fingCommand = "fing -n " + ipString + lenString + " -r "
						+ roundsString + savePath + getDomainNamesString
						+ " -o " + logorTableString + "," + formatString + ","
						+ filePath;

				FileOutput.makeBatch(fingCommand);
			}
		});
		generateButton.setBounds(93, 397, 90, 23);
		contentPane.add(generateButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(-2, 0, 305, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		ItemListener pathListener = new ItemListener()
        {
            public void itemStateChanged(ItemEvent ie)
            {
            	String path = JOptionPane.showInputDialog(null, "Enter file location for fing:", 
            			"c:\\Program Files (x86)\\overlook fing 2.1\\bin", 1);
            }
        };
		JMenuItem pathMenuOption = new JMenuItem("Change Path");
		
		mnNewMenu.add(pathMenuOption);
		pathMenuOption.addItemListener(pathListener);

	}
}
