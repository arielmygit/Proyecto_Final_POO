package org.example.modelo;

import org.example.persistencia.SmartphoneDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaSmartphone implements TableModel {
    public static final int COLS = 6;
    private ArrayList<Smartphone> datos;
    private SmartphoneDAO dao;

    public ModeloTablaSmartphone() {
        dao = new SmartphoneDAO();
        datos = new ArrayList<>();

    }

    public ModeloTablaSmartphone(ArrayList<Smartphone> datos) {
        this.datos = datos;
        dao = new SmartphoneDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLS;
    }

    @Override
    public String getColumnName(int rowIndex) {
        switch (rowIndex) {
            case 0:
                return "Id";
            case 1:
                return "Marca";
            case 2:
                return "Modelo";
            case 3:
                return "Nucleos en CPU";
            case 4:
                return "Sistema Operativo";
            case 5:
                return "URL";
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch (rowIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columIndex) {
        Smartphone tmp = datos.get(rowIndex);
        switch (columIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getMarca();
            case 2:
                return tmp.getModelo();
            case 3:
                return tmp.getNucleosCpu();
            case 4:
                return tmp.getSistemOp();
            case 5:
                return tmp.getImagen();
        }

        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int colIndex) {
        switch (colIndex) {
            case 0:
                //datos.get(rowIndex).setId((Integer)o);
                break;
            case 1:
                datos.get(rowIndex).setMarca((String) o);
                break;
            case 2:
                datos.get(rowIndex).setModelo((String) o);
                break;
            case 3:
                datos.get(rowIndex).setNucleosCpu((Integer) o);
                break;
            case 4:
                datos.get(rowIndex).setSistemOp((String) o);
                break;
            case 5:
                datos.get(rowIndex).setImagen((String) o);
                break;
        }

    }

    @Override
    public void addTableModelListener(TableModelListener tableModelListener) {

    }

    @Override
    public void removeTableModelListener(TableModelListener tableModelListener) {

    }

    public void cargarDatos() {
        try {
            datos = dao.obtenerTodo();

        } catch (SQLException slqle) {
            System.out.println(slqle.getMessage());
        }
    }

    public boolean agregarSmartphone(Smartphone smartphone) {
        boolean res = false;
        try {
            if (dao.insertar(smartphone)) {
                datos.add(smartphone);
                res = true;
            } else {
                res = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return res;
    }

    public Smartphone getPhoneAtIndex(int idx) {
        return datos.get(idx);
    }

    public boolean borrarPhone(String idx) {
        boolean x = false;
        try {
            if (dao.delete(idx)) {

                datos.remove(idx);
                x = true;
            } else {
                x = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return x;
    }

public boolean actualizarRegistro(int x, Smartphone smartphone){
    boolean resultado = false;
    try {
        if (x>datos.size()){
            datos.set(datos.size(),smartphone);
            resultado = true;
        }else {
            dao.update(x, smartphone);
            resultado = true;
        }
        resultado = false;

    } catch (SQLException sqle) {
        System.out.println(sqle.getMessage());
    }
    return resultado;

}




}
