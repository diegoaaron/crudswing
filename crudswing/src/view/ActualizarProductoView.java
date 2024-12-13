package view;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ProductoController;
import model.Producto;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class ActualizarProductoView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtprecio;
	private JTextField txtnombre;

	/**
	 * Create the frame.
	 */
	public ActualizarProductoView() {
		setTitle("Actualizar Item");
		setClosable(true);
		setIconifiable(true);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 324, 257);
		getContentPane().setLayout(null);

		JComboBox<String> cbmitem = new JComboBox<String>();
		cbmitem.setBounds(136, 12, 143, 26);
		getContentPane().add(cbmitem);

		JLabel lblItem = new JLabel("Item ID");
		lblItem.setBounds(12, 21, 60, 17);
		getContentPane().add(lblItem);

		JLabel lblNombreProducto = new JLabel("Nombre Producto");
		lblNombreProducto.setBounds(12, 67, 119, 26);
		getContentPane().add(lblNombreProducto);

		JLabel lblPrecioProducto = new JLabel("Precio Producto");
		lblPrecioProducto.setBounds(12, 118, 119, 26);
		getContentPane().add(lblPrecioProducto);

		txtprecio = new JTextField();
		txtprecio.setBounds(165, 121, 114, 21);
		getContentPane().add(txtprecio);
		txtprecio.setColumns(10);

		txtnombre = new JTextField();
		txtnombre.setBounds(165, 70, 114, 21);
		getContentPane().add(txtnombre);
		txtnombre.setColumns(10);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(104, 170, 105, 27);
		getContentPane().add(btnActualizar);

		// métodos

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {

				ProductoController productoController = new ProductoController();
				ArrayList<Producto> listaProductos = null;

				cbmitem.addItem("");

				try {
					listaProductos = productoController.listarProductos();
					for (Producto producto : listaProductos) {
						cbmitem.addItem(String.valueOf(producto.getId()));
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		cbmitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String itemSeleccionado = String.valueOf(cbmitem.getSelectedItem());

				Producto producto = null;
				ProductoController productoController = new ProductoController();

				try {

					if (itemSeleccionado == "") {
						producto = new Producto("", 0);

						// elementos desactivados
						txtnombre.setEditable(false);
						txtprecio.setEditable(false);
						btnActualizar.setEnabled(false);

					} else {
						// elementos activados
						txtnombre.setEditable(true);
						txtprecio.setEditable(true);
						btnActualizar.setEnabled(true);

						producto = productoController.listarProductoPorId(Integer.parseInt(itemSeleccionado));
					}

					txtnombre.setText(producto.getNombre());
					txtprecio.setText(String.valueOf(producto.getPrecio()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombre = txtnombre.getText();
				double precio = Double.valueOf(txtprecio.getText() == "" ? "0" : txtprecio.getText());
				String id = String.valueOf(cbmitem.getSelectedItem());

				ProductoController productoController = new ProductoController();

				try {

					Producto producto = new Producto(Integer.parseInt(id), nombre, precio);
					productoController.actualizarProducto(producto);

					cbmitem.setSelectedIndex(0);

					JOptionPane.showMessageDialog(ActualizarProductoView.this, "Producto actualizado", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

	}
}
