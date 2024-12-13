package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {

	public Conexion() {

	}

	public static Connection conectar() {
		Connection cnn = null;
		try {
			cnn = DriverManager.getConnection("jdbc:sqlite:/home/diego/eclipse-workspace/crudswing/bd/productos.db");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnn;
	}

	public static void cerrar(Connection cnn, Statement stm, PreparedStatement pstm, ResultSet rst) {

		try {
			if (cnn != null) {
				cnn.close();
			}

			if (stm != null) {
				stm.close();
			}

			if (pstm != null) {
				pstm.close();
			}

			if (rst != null) {
				rst.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
