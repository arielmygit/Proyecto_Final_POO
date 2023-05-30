package org.example.controlador;

import org.example.modelo.ModeloTablaSmartphone;
import org.example.modelo.Smartphone;
import org.example.vista.Ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;

public class ControladorSmartphone extends MouseAdapter {
    private Ventana view;
    private ModeloTablaSmartphone modelo;

    public ControladorSmartphone(Ventana view) {
        this.view = view;
        modelo = new ModeloTablaSmartphone();
        this.view.getTabla().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTabla().addMouseListener(this);
        this.view.getBtnBorrar().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnGuardar().addMouseListener(this);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ImageIcon iconoPregunta = new ImageIcon("pregunta.png");
        ImageIcon iconoExito = new ImageIcon("exitoso.png");
        ImageIcon iconoError = new ImageIcon("error.png");
        ImageIcon iconoInfo = new ImageIcon("info.png");
        if (e.getSource() == this.view.getBtnCargar()) {
            modelo.cargarDatos();
            this.view.getTabla().setModel(modelo);
            view.getTabla().updateUI();


        }
        if (e.getSource() == this.view.getBtnAgregar()) {
            Smartphone smartphone = new Smartphone();
            smartphone.setId(0);
            smartphone.setModelo(this.view.getTxtModelo().getText());
            smartphone.setMarca(this.view.getTxtMarca().getText());
            smartphone.setNucleosCpu(Integer.parseInt(this.view.getTxtNucleosCpu().getText()));
            smartphone.setSistemOp(this.view.getTxtSO().getText());
            smartphone.setImagen(this.view.getTxtImg().getText());
            if (modelo.agregarSmartphone(smartphone)) {
                JOptionPane.showMessageDialog(view, "Se agrego correctamente",
                        "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE, iconoExito);
                this.view.getTabla().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos, revisa la conexion",
                        "Error al insertar", JOptionPane.ERROR_MESSAGE, iconoError);
            }
            this.view.limpiar();
            modelo.cargarDatos();
            this.view.getTabla().setModel(modelo);
            view.getTabla().updateUI();

        }

        if (e.getSource() == this.view.getTabla()) {
            System.out.println("Evento en tabla");
            int index = this.view.getTabla().getSelectedRow();
            System.out.println(index + 1);
            Smartphone tmp = modelo.getPhoneAtIndex(index);
            try {
                this.view.getLblFoto().setIcon(tmp.getFoto());
                this.view.getLblFoto().updateUI();
            } catch (MalformedURLException mlue) {
                System.out.println(e.toString());
            }

            this.view.getBtnBorrar().setVisible(true);
            this.view.getBtnActualizar().setVisible(true);


        }


        if (e.getSource() == this.view.getBtnBorrar()) {
            int index = this.view.getTabla().getSelectedRow();
            int respuesta = JOptionPane.showConfirmDialog(view,
                    "¿Estas seguro de borrar el registro?", "Borrar registro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, iconoPregunta);
            if (respuesta == JOptionPane.YES_NO_OPTION) {
                Smartphone smartphone = new Smartphone();
                smartphone.setId(0);
                smartphone.setModelo(" ");
                smartphone.setMarca(" ");
                smartphone.setNucleosCpu(0);
                smartphone.setSistemOp(" ");
                smartphone.setImagen(" ");
                 modelo.actualizarRegistro(index + 1, smartphone);
                    JOptionPane.showMessageDialog(view,
                            "Registro borrado correctamente",
                            "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE, iconoExito);


            }
            this.view.limpiar();
            modelo.cargarDatos();
            view.getTabla().updateUI();

        }   else {
            System.out.println("No se borro");

        }



        if (e.getSource() == this.view.getBtnActualizar()) {

            int respuesta = JOptionPane.showConfirmDialog(view,
                    "¿Estas seguro de que desea actualizar el registro?", "Actualizar registro",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, iconoPregunta);
            if (respuesta == JOptionPane.YES_NO_OPTION) {
                this.view.getBtnGuardar().setVisible(true);
                JOptionPane.showMessageDialog(view, "Llene los campos requeridos y presione el boton Guardar",
                        "Guardar cambios", JOptionPane.INFORMATION_MESSAGE, iconoInfo);


            }

        }

        if (e.getSource() == this.view.getBtnGuardar()) {
            int index = this.view.getTabla().getSelectedRow();
            Smartphone smartphone = new Smartphone();
            smartphone.setId(0);
            smartphone.setModelo(this.view.getTxtModelo().getText());
            smartphone.setMarca(this.view.getTxtMarca().getText());
            smartphone.setNucleosCpu(Integer.parseInt(this.view.getTxtNucleosCpu().getText()));
            smartphone.setSistemOp(this.view.getTxtSO().getText());
            smartphone.setImagen(this.view.getTxtImg().getText());
            modelo.actualizarRegistro(index + 1, smartphone);
                System.out.println("Enta JOP de exito guardado");
                JOptionPane.showMessageDialog(view, "Se guardo correctamente", "Operacion exitosa",
                        JOptionPane.INFORMATION_MESSAGE, iconoExito);

            this.view.limpiar();
            modelo.cargarDatos();
            view.getTabla().updateUI();

        }else {
            System.out.println("No se modifico nada");
        }



    }
}
