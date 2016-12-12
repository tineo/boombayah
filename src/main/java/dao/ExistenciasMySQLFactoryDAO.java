package dao;

import entity.Existencias;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExistenciasMySQLFactoryDAO implements ExistenciasDAO{
    private Connection connection = null;
    private Statement stmt = null;


    public ExistenciasMySQLFactoryDAO() {
        this.connection = new util.Connection().getConnection();
    }

    @Override
    public int insertarExistencias(Existencias existencias) throws Exception {
        PreparedStatement psp = null;
        int last = 0;

        try {
            psp = this.connection.prepareStatement("INSERT INTO existencias VALUES (NULL, ?,?,?,?)"
                    , Statement.RETURN_GENERATED_KEYS);

            psp.setString(1, existencias.getCodigoLibro());
          //  psp.setString(2, existencias.getCodigo_existencia());
            psp.setString(2, existencias.getUbicacion());
            psp.setString(3, existencias.getEstado());
            psp.setString(4, existencias.getTipoPrestamo());
            psp.executeUpdate();

            ResultSet rs = psp.getGeneratedKeys();
            if (rs.next()) {
                last = rs.getInt(0);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return last;
    }



    @Override
    public List<Existencias> listarExistencias(Existencias existencias) throws Exception {
        Connection connection = null;
        PreparedStatement psmt = null;
        ArrayList<Existencias> listado = new ArrayList<Existencias>();


        try {
            connection = this.connection;
            psmt = connection.prepareStatement("SELECT * FROM existencia");
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                Existencias existencia = new Existencias();
                existencia.setId_Existencias(rs.getInt(1));
                existencia.setCodigoLibro(rs.getString(2));
                existencia.setUbicacion(rs.getString(3));
                existencia.setEstado(rs.getString(4));
                existencia.setTipoPrestamo(rs.getString(5));
                listado.add(existencia);
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
    public int eliminarExistencias(int id_existencia) throws Exception {
        PreparedStatement ps = null;
        int valor;
        try {
            ps = this.connection.prepareStatement("DELETE FROM existencia WHERE id_existencia=?");
            ps.setInt(1, id_existencia);
            valor = ps.executeUpdate();
            return valor;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }



}
