package dao;

import entity.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroMySQLFactoryDAO implements LibroDAO {

	 private Connection connection = null;
	 private Statement stmt = null;


	 public LibroMySQLFactoryDAO() {
	    this.connection = new util.Connection().getConnection();
	 }
	
	@Override
	public int insertarLibro(Libro libro) throws Exception {
		 PreparedStatement psp = null;
	        int last = 0;

	        try {
	            psp = this.connection.prepareStatement("INSERT INTO libro VALUES (?,?,?,?,?,?,?,?,?,?,?)"
	                    , Statement.RETURN_GENERATED_KEYS);

	            psp.setInt(1, libro.getCodigo_libro());
	            psp.setString(2, libro.getCodigoClasificacion());
	            psp.setString(3, libro.getTitulo());
	            psp.setString(4, libro.getFormato());
	            psp.setString(5, libro.getIsbn());
	            psp.setString(6, libro.getAutor());
	            psp.setString(7, libro.getPieImprenta());
	            psp.setInt(8, libro.getPaginas());
	            psp.setString(9, libro.getDescripcion());
	            psp.setString(10, libro.getIdioma());
	            psp.setInt(11, libro.getVistas());
	            psp.executeUpdate();

	            ResultSet rs = psp.getGeneratedKeys();
	            if (rs.next()) {
	                last = rs.getInt(1);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return last;
	}

	@Override
	public List<Libro> listarLibro() throws Exception {
		 Connection connection = null;
	        PreparedStatement psmt = null;
	        ArrayList<Libro> listado = new ArrayList<Libro>();


	        try {
	            connection = this.connection;
	            psmt = connection.prepareStatement("SELECT * FROM libro");
	            ResultSet rs = psmt.executeQuery();
	            while (rs.next()) {
	                Libro libro = new Libro();
	                libro.setCodigo_libro(rs.getInt(1));
	                libro.setCodigoClasificacion(rs.getString(2));
	                libro.setTitulo(rs.getString(3));
	                libro.setFormato(rs.getString(4));
	                libro.setIsbn(rs.getString(5));
	                libro.setAutor(rs.getString(6));
	                libro.setPieImprenta(rs.getString(7));
	                libro.setPaginas(rs.getInt(8));
	                libro.setDescripcion(rs.getString(9));
	                libro.setIdioma(rs.getString(10));
	                libro.setVistas(rs.getInt(11));
	                listado.add(libro);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                connection.close();

	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return listado;
	}

	@Override
	public int eliminarLibro(int id_libro) throws Exception {
		 PreparedStatement ps = null;
	        int valor;
	        try {
	            ps = this.connection.prepareStatement("DELETE FROM libro WHERE id_libro =?");
	            ps.setInt(1, id_libro);
	            valor = ps.executeUpdate();
	            return valor;

	        } catch (Exception e) {
	            e.printStackTrace();
	            return -1;
	        }
	}

	@Override
	public List<Libro> buscarLibro(String key) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		ArrayList<Libro> listado = new ArrayList<Libro>();

		try {
			connection = this.connection;
			pst = connection.prepareStatement("SELECT * FROM libro WHERE autor LIKE ? OR codigo_clasificacion LIKE ?" +
					" OR titulo LIKE ? OR formato LIKE ? OR ISBN LIKE ?" +
					" OR pie_imprenta LIKE ? OR descripcion LIKE ? OR idioma LIKE ?" );
			pst.setString(1,key);
			pst.setString(2,key);
			pst.setString(3,key);
			pst.setString(4,key);
			pst.setString(5,key);
			pst.setString(6,key);
			pst.setString(7,key);
			pst.setString(8,key);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Libro libro = new Libro();
				libro.setCodigo_libro(rs.getInt(1));
				libro.setCodigo_clasificacion(rs.getString(2));
				libro.setTitulo(rs.getString(3));
				libro.setFormato(rs.getString(4));
				libro.setISBN(rs.getString(5));
				libro.setAutor(rs.getString(6));
				libro.setPie_imprenta(rs.getString(7));
				libro.setPaginas(rs.getInt(8));
				libro.setDescripcion(rs.getString(9));
				libro.setIdioma(rs.getString(10));
				libro.setVistas(rs.getInt(11));
				listado.add(libro);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listado;

	}


}
