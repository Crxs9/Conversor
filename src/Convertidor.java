import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Convertidor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Convertidor window = new Convertidor();
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
	public Convertidor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 449, 208);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido, seleccione el tipo de convertidor que desea usar.");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel.setBounds(59, 20, 340, 42);
		frame.getContentPane().add(lblNewLabel);
		
		String[] opciones = {"","Conversor divisas","Conversor temperatura"};
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem(opciones[0]);
		comboBox.addItem(opciones[1]);
		comboBox.addItem(opciones[2]);
		comboBox.setBounds(104, 73, 227, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalir.setBounds(242, 117, 89, 23);
		frame.getContentPane().add(btnSalir);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(104, 117, 89, 23);
		frame.getContentPane().add(btnAceptar);
	}

}