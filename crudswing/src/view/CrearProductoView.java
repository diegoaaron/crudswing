package view;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.ProductoController;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearProductoView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtnombre;
	private JTextField txtmonto;

	/**
	 * Create the frame.
	 */
	public CrearProductoView() {
		setClosable(true);
		setBackground(Color.LIGHT_GRAY);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("Crear producto");
		setIconifiable(true);
		setBounds(100, 100, 356, 176);
		getContentPane().setLayout(null);

		JLabel lblNombre = new JLabel("Nombre Producto");
		lblNombre.setBounds(12, 25, 125, 22);
		getContentPane().add(lblNombre);

		JLabel lblCostoProducto = new JLabel("Costo Producto");
		lblCostoProducto.setBounds(12, 59, 109, 22);
		getContentPane().add(lblCostoProducto);

		JButton btnguardar = new JButton("Guardar");
		btnguardar.setBounds(123, 97, 105, 27);
		getContentPane().add(btnguardar);

		txtnombre = new JTextField();
		txtnombre.setBounds(162, 26, 159, 21);
		getContentPane().add(txtnombre);
		txtnombre.setColumns(10);

		txtmonto = new JTextField();
		txtmonto.setBounds(162, 60, 159, 21);
		getContentPane().add(txtmonto);
		txtmonto.setColumns(10);

		// métodos

		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombre = txtnombre.getText();
				double monto = Double.valueOf(txtmonto.getText());

				ProductoController productoController = new ProductoController();

				try {
					productoController.registrarProducto(nombre, monto);

					JOptionPane.showMessageDialog(CrearProductoView.this, "Producto agregado", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					e2.printStackTrace();
				} finally {
					txtnombre.setText("");
					txtmonto.setText("");
					txtnombre.requestFocusInWindow();
				}

			}
		});

	}

}
