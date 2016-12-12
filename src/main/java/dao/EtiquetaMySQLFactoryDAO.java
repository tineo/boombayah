package dao;

import entity.Etiqueta;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class EtiquetaMySQLFactoryDAO implements EtiquetaDAO {
    private Connection connection = null;
    @Override
    public int insertarEtiqueta(Etiqueta etiqueta) throws Exception {
        PreparedStatement ps = null;
        int last = 0;

        try {
            ps = this.connection.prepareStatement("INSERT INTO etiqueta VALUES (NULL,?,?)"
                    , Statement.RETURN_GENERATED_KEYS);

            ps.setString(2, etiqueta.getNombre());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                last = rs.getInt(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return last;
    }


    @Override
    public List<Etiqueta> listarEtiquetas() throws Exception {

        Connection connection = null;
        PreparedStatement psmt = null;

        ArrayList<Etiqueta> listado = new ArrayList<Etiqueta>();

        try {
            connection = this.connection;
            psmt = connection.prepareStatement("SELECT * FROM etiqueta ");
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {

                Etiqueta etiqueta = new Etiqueta();
                etiqueta.getId_etiqueta();

                etiqueta.setNombre(rs.getString("nombre"));

                listado.add(etiqueta);

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
    public int eliminar(int id) throws Exception {
        return 0;
    }

    @Override
    public List<Etiqueta> buscar(Etiqueta etiqueta) throws Exception {
        return null;
    }
}
