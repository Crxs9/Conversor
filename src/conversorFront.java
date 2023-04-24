import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

public class conversorFront {
	private double factor= 0.05553;	
	private JFrame frame;
	private JTextField unitIn;
	private JTextField unitOut;
	ConversorBack cb = new ConversorBack();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conversorFront window = new conversorFront();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public conversorFront() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 361, 282);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Entrada");
		lblNewLabel.setBounds(191, 98, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Salida");
		lblNewLabel_1.setBounds(191, 137, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		unitIn = new JTextField();
		lblNewLabel.setLabelFor(unitIn);
		unitIn.setBounds(95, 95, 86, 20);
		frame.getContentPane().add(unitIn);
		unitIn.setColumns(10);
		
		unitOut = new JTextField();
		unitOut.setEnabled(false);
		lblNewLabel_1.setLabelFor(unitOut);
		unitOut.setBounds(95, 134, 86, 20);
		frame.getContentPane().add(unitOut);
		unitOut.setColumns(10);
		
		JButton btnNewButton = new JButton("Convertir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String valor = unitIn.getText();
					if (!valor.matches("^\\d+(\\.\\d+)?$")) {
					throw new NoEsNumeroValidoException();
					}

			     // ... El valor es un número válido...
				double cantidad = Double.parseDouble(unitIn.getText());
				unitOut.setText(cb.conversion(cantidad, factor)); 
					} catch (NoEsNumeroValidoException e1) {
					  // ... No es ...
						unitIn.setText("");
						unitOut.setText("");
						crearFrameError();
					
						//e1.printStackTrace();
					}
				
				
				
			}
		});
		btnNewButton.setBounds(49, 188, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Seleccione la divisa que desea convertir:");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lblNewLabel_2.setBounds(41, 0, 323, 45);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(73, 42, 186, 22);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Peso(MXN) a Dolar");
		comboBox.addItem("Peso(MXN) a Euros");
		comboBox.addItem("Peso(MXN) a Libras");
		comboBox.addItem("Peso(MXN) a Yen");
		comboBox.addItem("Peso(MXN) a Won");
		comboBox.addItem("Dolar a Peso(MXN)");
		comboBox.addItem("Euros a Peso(MXN)");
		comboBox.addItem("Libras a Peso(MXN)");
		comboBox.addItem("Yen a Peso(MXN)");
		comboBox.addItem("Won a Peso(MXN)");
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
			unitIn.setText("");
			unitOut.setText("");
			switch(comboBox.getSelectedIndex()) {
			case 0:
				lblNewLabel.setText("MXN");
				lblNewLabel_1.setText("USD");
				factor = cb.getvDolar();
				
			break;
			
			case 1:
				lblNewLabel.setText("MXN");
				lblNewLabel_1.setText("EUR");
				factor = cb.getvEuro();
			break;
			
			case 2:
				lblNewLabel.setText("MXN");
				lblNewLabel_1.setText("GBP");
				factor = cb.getvLibra();
			break;
			case 3:
				lblNewLabel.setText("MXN");
				lblNewLabel_1.setText("JPY");
				factor = cb.getvWon();
			break;
			case 4:
				lblNewLabel.setText("MXN");
				lblNewLabel_1.setText("KRW");
				factor = cb.getvWon();
			break;
			case 5:
				lblNewLabel.setText("USD");
				lblNewLabel_1.setText("MXN");
				factor = 1/cb.getvDolar();
			break;
			case 6:
				lblNewLabel.setText("EUR");
				lblNewLabel_1.setText("MXN");
				factor = 1/cb.getvEuro();
			break;
			case 7:
				lblNewLabel.setText("GBP");
				lblNewLabel_1.setText("MXN");
				factor = 1/cb.getvLibra();
			break;
			case 8:
				lblNewLabel.setText("JPY");
				lblNewLabel_1.setText("MXN");
				factor = 1/cb.getvYen();
			break;
			case 9:
				lblNewLabel.setText("KRW");
				lblNewLabel_1.setText("MXN");
				factor = 1/cb.getvWon();
			break;
				
			}
			
					
				
			}
		});
	}
	
	private void crearFrameError(){
		JFrame frameError = new JFrame("Error");
		  JLabel label = new JLabel("El valor ingresado no es un número válido.");
		  frameError.getContentPane().add(label);
		  label.setHorizontalAlignment(JLabel.CENTER); // Alinear el texto horizontalmente en el centro
		  label.setVerticalAlignment(JLabel.CENTER);
		  frameError.setSize(300, 100); //establece el tamaño default del frame.
		  frameError.setLocationRelativeTo(frame);
		  frameError.setVisible(true);
		
	}
}