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

public class EliminarProductoView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtprecio;
	private JTextField txtnombre;

	/**
	 * Create the frame.
	 */
	public EliminarProductoView() {
		setTitle("Eliminar Item");
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
		txtprecio.setEditable(false);
		txtprecio.setBounds(165, 121, 114, 21);
		getContentPane().add(txtprecio);
		txtprecio.setColumns(10);

		txtnombre = new JTextField();
		txtnombre.setEditable(false);
		txtnombre.setBounds(165, 70, 114, 21);
		getContentPane().add(txtnombre);
		txtnombre.setColumns(10);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(104, 170, 105, 27);
		getContentPane().add(btnEliminar);

		// métodos

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {

				ProductoController productoController = new ProductoController();
				ArrayList<Producto> listaProductos = null;

				try {

					cbmitem.addItem("");

					listaProductos = productoController.listarProductos();
					for (Producto producto : listaProductos) {
						cbmitem.addItem(String.valueOf(producto.getId()));
					}

					// cbmitem.setSelectedIndex(0);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		cbmitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Producto producto = null;
				ProductoController productoController = new ProductoController();

				String itemSeleccionado = String.valueOf(cbmitem.getSelectedItem());

				try {

					if (itemSeleccionado == "") {

						producto = new Producto("", 0);

						// elementos desactivados
						txtnombre.setEditable(false);
						txtprecio.setEditable(false);
						btnEliminar.setEnabled(false);

					} else {

						// elementos activados
						btnEliminar.setEnabled(true);

						producto = productoController.listarProductoPorId(Integer.parseInt(itemSeleccionado));
					}

					txtnombre.setText(producto.getNombre());
					txtprecio.setText(String.valueOf(producto.getPrecio()));
				} catch (Exception e2) {
					e2.printStackTrace();
				}

				System.out.println(cbmitem.getItemCount() + " - " + itemSeleccionado + " - ");
			}
		});

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedIndex = cbmitem.getSelectedIndex();
				String id = String.valueOf(cbmitem.getSelectedItem());

				ProductoController productoController = new ProductoController();

				try {

					productoController.eliminarProducto(Integer.parseInt(id));

					cbmitem.removeItemAt(selectedIndex);
					cbmitem.setSelectedIndex(0);

					JOptionPane.showMessageDialog(EliminarProductoView.this, "Producto eliminado", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

	}
}
