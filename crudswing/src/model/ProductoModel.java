package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoModel {

	private Connection cnn;

	public ProductoModel() {
		this.cnn = Conexion.conectar();
	}

	public void agregarProducto(Producto producto) {

		PreparedStatement pstm = null;

		try {
			String sql = "INSERT INTO productos (nombre, precio) VALUES (?, ?)";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, producto.getNombre());
			pstm.setDouble(2, producto.getPrecio());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, null);
		}
	}

	public ArrayList<Producto> obtenerProductos() {

		PreparedStatement pstm = null;
		ResultSet rst = null;

		ArrayList<Producto> productos = new ArrayList<Producto>();

		try {
			String sql = "SELECT * FROM productos";
			pstm = cnn.prepareStatement(sql);
			rst = pstm.executeQuery();
			while (rst.next()) {
				productos.add(new Producto(rst.getInt("id"), rst.getString("nombre"), rst.getDouble("precio")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, rst);
		}

		return productos;
	}

	public Producto obtenerProductoPorId(int id) {

		PreparedStatement pstm = null;
		ResultSet rst = null;

		Producto producto = null;

		try {

			String sql = "SELECT * FROM productos where id = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setInt(1, id);
			rst = pstm.executeQuery();

			while (rst.next()) {
				producto = new Producto(rst.getInt("id"), rst.getString("nombre"), rst.getDouble("precio"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, rst);
		}

		return producto;
	}

	public void actualizarProducto(Producto producto) {

		PreparedStatement pstm = null;

		try {
			String sql = "UPDATE productos SET nombre=?, precio=? WHERE id=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, producto.getNombre());
			pstm.setDouble(2, producto.getPrecio());
			pstm.setInt(3, producto.getId());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, null);
		}

	}

	public void eliminarProducto(int id) {

		PreparedStatement pstm = null;

		try {
			String sql = "DELETE FROM productos WHERE id=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, null);
		}

	}

}
