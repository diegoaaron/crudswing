package controller;

import java.util.ArrayList;

import model.Producto;
import model.ProductoModel;

public class ProductoController {

	public ProductoController() {

	}

	public void registrarProducto(String nombre, double monto) {

		ProductoModel productoModel = new ProductoModel();
		Producto producto = new Producto(nombre, monto);

		try {
			productoModel.agregarProducto(producto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Producto> listarProductos() {

		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		ProductoModel productoModel = new ProductoModel();

		try {
			listaProductos = productoModel.obtenerProductos();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaProductos;
	}

	public Producto listarProductoPorId(int id) {

		ProductoModel productoModel = new ProductoModel();
		Producto producto = null;

		try {
			producto = productoModel.obtenerProductoPorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return producto;
	}

	public void actualizarProducto(Producto producto) {

		ProductoModel productoModel = new ProductoModel();

		try {
			productoModel.actualizarProducto(producto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminarProducto(int id) {

		ProductoModel productoModel = new ProductoModel();

		try {
			productoModel.eliminarProducto(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
