package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private CrearProductoView crearProductoView;
	private MostrarTodoView mostrarTodoView;
	private MostrarEspecificoView mostrarEspecificoView;
	private ActualizarProductoView actualizarProductoView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductoView frame = new ProductoView();
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
	public ProductoView() {
		setResizable(false);
		setBackground(Color.LIGHT_GRAY);
		setTitle("CRUD Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480); // x, y, witdh, height

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);

		JMenu mnCrear = new JMenu("Crear");
		mnCrear.setBackground(Color.WHITE);
		menuBar.add(mnCrear);

		JMenu mnMostrar = new JMenu("Mostrar");
		menuBar.add(mnMostrar);

		JMenuItem mntmMostrarTodo = new JMenuItem("Todo");
		mnMostrar.add(mntmMostrarTodo);

		JMenuItem mntmIndividual = new JMenuItem("Individual");
		mnMostrar.add(mntmIndividual);

		JMenu mnActualizar = new JMenu("Actualizar");
		menuBar.add(mnActualizar);

		JMenu mnEliminar = new JMenu("Eliminar");
		menuBar.add(mnEliminar);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 10, 620, 410); // x, y, witdh, height
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);

		// metodos

		mnCrear.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}

			public void menuDeselected(MenuEvent e) {
			}

			public void menuSelected(MenuEvent e) {
				crearProductoView = new CrearProductoView();

				Dimension baseSize = desktopPane.getSize();
				Dimension internoSize = crearProductoView.getSize();

				crearProductoView.setLocation((baseSize.width - internoSize.width) / 2,
						(baseSize.height - internoSize.height) / 2);

				desktopPane.add(crearProductoView);
				crearProductoView.setVisible(true);
			}
		});

		mntmMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarTodoView = new MostrarTodoView();

				Dimension baseSize = desktopPane.getSize();
				Dimension internoSize = mostrarTodoView.getSize();

				mostrarTodoView.setLocation((baseSize.width - internoSize.width) / 2,
						(baseSize.height - internoSize.height) / 2);

				desktopPane.add(mostrarTodoView);
				mostrarTodoView.setVisible(true);
			}
		});

		mntmIndividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarEspecificoView = new MostrarEspecificoView();

				Dimension baseSize = desktopPane.getSize();
				Dimension internoSize = mostrarEspecificoView.getSize();

				mostrarEspecificoView.setLocation((baseSize.width - internoSize.width) / 2,
						(baseSize.height - internoSize.height) / 2);

				desktopPane.add(mostrarEspecificoView);
				mostrarEspecificoView.setVisible(true);
			}
		});

		mnActualizar.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}

			public void menuDeselected(MenuEvent arg0) {
			}

			public void menuSelected(MenuEvent arg0) {
				actualizarProductoView = new ActualizarProductoView();

				Dimension baseSize = desktopPane.getSize();
				Dimension internoSize = actualizarProductoView.getSize();

				actualizarProductoView.setLocation((baseSize.width - internoSize.width) / 2,
						(baseSize.height - internoSize.height) / 2);

				desktopPane.add(actualizarProductoView);
				actualizarProductoView.setVisible(true);

			}
		});

		mnEliminar.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}

			public void menuDeselected(MenuEvent arg0) {
			}

			public void menuSelected(MenuEvent arg0) {
				EliminarProductoView eliminarProductoView = new EliminarProductoView();

				Dimension baseSize = desktopPane.getSize();
				Dimension internoSize = eliminarProductoView.getSize();

				eliminarProductoView.setLocation((baseSize.width - internoSize.width) / 2,
						(baseSize.height - internoSize.height) / 2);

				desktopPane.add(eliminarProductoView);
				eliminarProductoView.setVisible(true);
			}
		});

	}

}
