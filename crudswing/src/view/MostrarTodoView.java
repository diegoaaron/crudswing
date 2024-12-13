package view;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ProductoController;
import model.Producto;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class MostrarTodoView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public MostrarTodoView() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);

		JLabel lblListaDeTodos = new JLabel("LISTA TOTAL DE PRODUCTOS");
		lblListaDeTodos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListaDeTodos.setForeground(Color.BLACK);
		lblListaDeTodos.setBounds(119, 12, 207, 32);
		getContentPane().add(lblListaDeTodos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 420, 200);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nombre", "Monto" }));
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		setTitle("Productos Totales");
		setIconifiable(true);
		setClosable(true);
		setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 450, 300);

		// métodos

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {

				ArrayList<Producto> listaProductos;
				ProductoController productoController = new ProductoController();
				DefaultTableModel datosTabla = (DefaultTableModel) table.getModel();

				// seteando la tabla en blanco
				datosTabla.setRowCount(0);

				try {
					listaProductos = productoController.listarProductos();

					for (Producto producto : listaProductos) {

						Object[] filaDatos = new Object[] { String.valueOf(producto.getId()), producto.getNombre(),
								String.valueOf(producto.getPrecio()) };

						datosTabla.addRow(filaDatos);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

	}
}
