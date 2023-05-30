package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private JLabel lblId;
    private JLabel lblMarca;
    private JLabel lblModelo;
    private JLabel lblNucleosCpu;
    private JLabel lblSO;
    private JLabel lblImg;
    private JTextField txtlId;
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtNucleosCpu;
    private JTextField txtSO;
    private JTextField txtImg;
    private JButton btnAgregar;
    private JButton btnCargar;
    private JTable tabla;
    private JScrollPane scroll;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel lblFoto;
    private JButton btnBorrar;
    private JButton btnActualizar;
    private JButton btnGuardar;


    public Ventana(String title) throws HeadlessException {
        this.setVisible(true);
        this.setSize(1000, 800);
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);

        //----PANEL 1-----
        panel1 = new JPanel(new FlowLayout());
        this.getContentPane().add(panel1,0);
        panel1.setBackground(new Color(230, 255, 253, 255));

        lblId = new JLabel("ID");
        panel1.add(lblId);
        txtlId = new JTextField(2);
        txtlId.setEnabled(false);
        txtlId.setText("");
        panel1.add(txtlId);

        lblMarca= new JLabel("Marca");
        panel1.add(lblMarca);
        txtMarca = new JTextField(8);
        panel1.add(txtMarca);

        lblModelo = new JLabel("Modelo");
        panel1.add(lblModelo);
        txtModelo = new JTextField(8);
        panel1.add(txtModelo);

        lblNucleosCpu = new JLabel("Nucleos en CPU");
        panel1.add(lblNucleosCpu);
        txtNucleosCpu = new JTextField(2);
        panel1.add(txtNucleosCpu);

        lblSO = new JLabel("Sistema Operativo");
        panel1.add(lblSO);
        txtSO = new JTextField(6);
        panel1.add(txtSO);

        lblImg = new JLabel("URL");
        panel1.add(lblImg);
        txtImg = new JTextField(20);
        panel1.add(txtImg);

        btnAgregar = new JButton("Agregar");
        panel1.add(btnAgregar);

        //----PANEL 2-----
        panel2 = new JPanel(new FlowLayout());
        this.getContentPane().add(panel2,1);
        panel2.setBackground(new Color(174, 226, 255, 255));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tabla = new JTable();
        scroll = new JScrollPane(tabla,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setPreferredSize(new Dimension(480,780));
        panel2.add(scroll, BorderLayout.CENTER);


        //----PANEL 3-----
        panel3 = new JPanel(new FlowLayout());
        this.getContentPane().add(panel3,2);
        panel3.setBackground(new Color(172, 188, 255, 255));
        lblFoto = new JLabel("");
        panel3.add(lblFoto);


        //----PANEL 4-----
        panel4 = new JPanel(new FlowLayout());
        this.getContentPane().add(panel4,3);
        panel4.setBackground(new Color(183, 153, 255, 255));
        btnBorrar = new JButton("Borrar registro");
        panel4.add(btnBorrar);
        btnBorrar.setVisible(false);
        btnActualizar = new JButton("Actualizar registro");
        panel4.add(btnActualizar);
        btnActualizar.setVisible(false);
        btnGuardar= new JButton("Guardar");
        panel4.add(btnGuardar);
        btnGuardar.setVisible(false);




        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblMarca() {
        return lblMarca;
    }

    public void setLblMarca(JLabel lblMarca) {
        this.lblMarca = lblMarca;
    }

    public JLabel getLblModelo() {
        return lblModelo;
    }

    public void setLblModelo(JLabel lblModelo) {
        this.lblModelo = lblModelo;
    }

    public JLabel getLblNucleosCpu() {
        return lblNucleosCpu;
    }

    public void setLblNucleosCpu(JLabel lblNucleosCpu) {
        this.lblNucleosCpu = lblNucleosCpu;
    }

    public JLabel getLblSO() {
        return lblSO;
    }

    public void setLblSO(JLabel lblSO) {
        this.lblSO = lblSO;
    }

    public JLabel getLblImg() {
        return lblImg;
    }

    public void setLblImg(JLabel lblImg) {
        this.lblImg = lblImg;
    }

    public JTextField getTxtlId() {
        return txtlId;
    }

    public void setTxtlId(JTextField txtlId) {
        this.txtlId = txtlId;
    }

    public JTextField getTxtMarca() {
        return txtMarca;
    }

    public void setTxtMarca(JTextField txtMarca) {
        this.txtMarca = txtMarca;
    }

    public JTextField getTxtModelo() {
        return txtModelo;
    }

    public void setTxtModelo(JTextField txtModelo) {
        this.txtModelo = txtModelo;
    }

    public JTextField getTxtNucleosCpu() {
        return txtNucleosCpu;
    }

    public void setTxtNucleosCpu(JTextField txtNucleosCpu) {
        this.txtNucleosCpu = txtNucleosCpu;
    }

    public JTextField getTxtSO() {
        return txtSO;
    }

    public void setTxtSO(JTextField txtSO) {
        this.txtSO = txtSO;
    }

    public JTextField getTxtImg() {
        return txtImg;
    }

    public void setTxtImg(JTextField txtImg) {
        this.txtImg = txtImg;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getLblFoto() {
        return lblFoto;
    }

    public void setLblFoto(JLabel lblFoto) {
        this.lblFoto = lblFoto;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnBorrar(JButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public void limpiar(){
        txtMarca.setText("");
        txtModelo.setText("");
        txtNucleosCpu.setText("");
        txtSO.setText("");
        txtImg.setText("");
    }
}
