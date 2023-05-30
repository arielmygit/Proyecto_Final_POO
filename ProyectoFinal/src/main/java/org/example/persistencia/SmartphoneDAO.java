package org.example.persistencia;

import org.example.modelo.Smartphone;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SmartphoneDAO implements InterfazDAO{
    public SmartphoneDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String queryInsert = "INSERT INTO Smartphones(Marca,Modelo,NucleosCPU,SistemaOperativo,URL) VALUES (?,?,?,?,?);";
        int rowCount=0;
        PreparedStatement pstm = ConexionSingleton.getInstance("Smartphones.db").getConnection().prepareStatement(queryInsert);
        pstm.setString(1,((Smartphone)obj).getMarca());
        pstm.setString(2,((Smartphone)obj).getModelo());
        pstm.setInt(3,((Smartphone)obj).getNucleosCpu());
        pstm.setString(4,((Smartphone)obj).getSistemOp());
        pstm.setString(5,((Smartphone)obj).getImagen());
        rowCount = pstm.executeUpdate();
        System.out.println("Se insertaron "+rowCount+" registros");
        return rowCount>0;
    }

    @Override
    public boolean update(int index, Object obj) throws SQLException {
        String queryUpdate = "UPDATE Smartphones SET Marca= ?, Modelo= ?,NucleosCPU= ?, SistemaOperativo= ?, URL = ?  WHERE ID= ? ;";
        int rowCount= 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("Smartphones.db").getConnection().prepareStatement(queryUpdate);
        pstm.setString(1,((Smartphone)obj).getMarca());
        pstm.setString(2,((Smartphone)obj).getModelo());
        pstm.setInt(3,((Smartphone)obj).getNucleosCpu());
        pstm.setString(4,((Smartphone)obj).getSistemOp());
        pstm.setString(5,((Smartphone)obj).getImagen());
        pstm.setInt(6,index);
        rowCount = pstm.executeUpdate();
        System.out.println("Se actualizaron "+rowCount+" registros");
        return rowCount>0;

    }

    @Override
    public boolean delete(String id) throws SQLException {
        String queryDelete = "DELETE FROM Smartphones WHERE ID = ?;";
        int rowCount=0;
        PreparedStatement pstm = ConexionSingleton.getInstance("Smartphones.db").getConnection().prepareStatement(queryDelete);
        pstm.setInt(1,Integer.parseInt(id));
        rowCount = pstm.executeUpdate();
        return rowCount>0;

    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String queryObtTod= "SELECT * FROM Smartphones;";
        ArrayList<Smartphone> resultado = new ArrayList<>();
        Statement stm = ConexionSingleton.getInstance("Smartphones.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(queryObtTod);
        while (rst.next()){
            resultado.add(new Smartphone(rst.getInt(1),rst.getString(2),
                    rst.getString(3),rst.getInt(4),
                    rst.getString(5),rst.getString(6)));
        }
        return resultado;
    }

}
