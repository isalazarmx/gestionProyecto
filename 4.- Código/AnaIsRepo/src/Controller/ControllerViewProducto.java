package Controller;

import Model.ModelCategoria;
import Model.ModelCliente;
import Model.ModelProducto;
import Model.ModelProveedor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author Carolina
 */
public class ControllerViewProducto {

    JComboBox idProducto;
    JComboBox idCategoria;
    JComboBox idProveedor;
    JTextField ID;
    JTextField nombre;
    JTextField cantidad01;
    JTextField cantidad02;
    JComboBox tipoUnidad;
    JTextField unidadExistencia;
    JSpinner minStock;
    JSpinner maxStock;
    JTextField precioCompra01;
    JTextField precioCompra02;
    JSpinner incrementoVenta;
    JTextField precioVenta;
    JLabel imagen;
    JTextField gananciaIndividual;
    JTextField gananciaTotal;
    JTextField inversion;
    ControllerCuentas cuentas;
    List<ModelCategoria> listCategoria;
    List<ModelProveedor> listProveedor;
    List<ModelProducto> listProductos;

    public ControllerViewProducto(ArrayList components) {
        cuentas = new ControllerCuentas();
        this.idProducto = (JComboBox) components.get(0);
        this.idCategoria = (JComboBox) components.get(1);
        this.idProveedor = (JComboBox) components.get(2);
        this.ID = (JTextField) components.get(3);
        this.nombre = (JTextField) components.get(4);
        this.cantidad01 = (JTextField) components.get(5);
        this.cantidad02 = (JTextField) components.get(6);
        this.tipoUnidad = (JComboBox) components.get(7);
        this.unidadExistencia = (JTextField) components.get(8);
        this.minStock = (JSpinner) components.get(9);
        this.maxStock = (JSpinner) components.get(10);
        this.precioCompra01 = (JTextField) components.get(11);
        this.precioCompra02 = (JTextField) components.get(12);
        this.incrementoVenta = (JSpinner) components.get(13);
        this.precioVenta = (JTextField) components.get(14);
        this.imagen = (JLabel) components.get(15);
        this.gananciaIndividual = (JTextField) components.get(16);
        this.gananciaTotal = (JTextField) components.get(17);
        this.inversion = (JTextField) components.get(18);
    }

    private double incremento() {
        double temp2 = (Integer) incrementoVenta.getValue();
        double temp = temp2 / 100;
        return temp;
    }

    private double buscaValor(double parteEntera, double parteDecimal) {
        return parteEntera + (parteDecimal / 100);
    }

    private double precioCompra() {
        return buscaValor(
                Integer.parseInt(precioCompra01.getText()),
                Integer.parseInt(precioCompra02.getText())
        );
    }

    private double cantidadProductos() {
        return Integer.parseInt(unidadExistencia.getText());
    }

    public void despliegaCuentas() {
        double temp = cuentas.gananciaIndividual(precioCompra(), incremento());
        gananciaIndividual.setText(cuentas.formatoNumero("" + temp));
        gananciaTotal.setText("" + cuentas.formatoNumero("" + cuentas.gananciaTotal(temp, cantidadProductos())));
        precioVenta.setText("" + cuentas.formatoNumero("" + cuentas.precioVenta(precioCompra(), incremento())));
        inversion.setText("" + cuentas.formatoNumero("" + cuentas.cantidadInvertida(cantidadProductos(), precioCompra())));
    }

    public void validations() {
        ControllerValidation.limitarCaracteres(ID, 30);
        ControllerValidation.limitarCaracteres(nombre, 45);
        ControllerValidation.limitarCaracteres(cantidad01, 9);
        ControllerValidation.soloNumeros(cantidad01);
        ControllerValidation.limitarCaracteres(cantidad02, 2);
        ControllerValidation.soloNumeros(cantidad02);
        ControllerValidation.limitarCaracteres(unidadExistencia, 9);
        ControllerValidation.soloNumeros(unidadExistencia);
        ControllerValidation.limitarCaracteres(precioCompra01, 9);
        ControllerValidation.soloNumeros(precioCompra01);
        ControllerValidation.limitarCaracteres(precioCompra02, 2);
        ControllerValidation.soloNumeros(precioCompra02);
    }

    public void addProducto(JLabel labelStatus, ModelProducto producto) {
        if (!((String) idCategoria.getItemAt(idCategoria.getSelectedIndex())).equals("Selecciona categoría")) {
            if (!((String) idProveedor.getItemAt(idProveedor.getSelectedIndex())).equals("Selecciona proveedor")) {
                if (!ID.getText().equals("Código de barras") && !ID.getText().isEmpty()) {
                    if (!nombre.getText().equals("Nombre del producto") && !nombre.getText().isEmpty()) {
                        if (!cantidad01.getText().equals("0") && !cantidad01.getText().isEmpty()) {
                            if (!unidadExistencia.getText().equals("0") && !unidadExistencia.getText().isEmpty()) {
                                if (!precioCompra01.getText().equals("0") && !precioCompra01.getText().isEmpty()) {
    //                                if(DataBase.DataBaseCliente.addCliente(cliente)){
                                    //                                       labelStatus.setText("Cliente agregado con éxito");
                                    //                                       limpiaCampos();
                                    //                                }else
                                    //                                   labelStatus.setText("Error interno para almacenar la información");
                                } else {
                                    ControllerViewMsj.muestraMensajeGlobo("Indica el precio del producto", precioCompra01);
                                }
                            } else {
                                ControllerViewMsj.muestraMensajeGlobo("Indica la cantidad de productos que tienes", unidadExistencia);
                            }
                        } else {
                            ControllerViewMsj.muestraMensajeGlobo("Indica el peso del producto", cantidad01);
                        }
                    } else {
                        ControllerViewMsj.muestraMensajeGlobo("Identifica el producto con un nombre", nombre);
                    }
                } else {
                    ControllerViewMsj.muestraMensajeGlobo("El producto debe de tener un código de barras", ID);
                }
            } else {
                ControllerViewMsj.muestraMensajeGlobo("Agrega un proveedor para el producto", idProveedor);
            }
        } else {
            ControllerViewMsj.muestraMensajeGlobo("Agrega una categoría para el producto", idCategoria);
        }
    }

    public List cargarCombo(int tipoProducto, boolean seleccion) {
        List temp = null;
        switch (tipoProducto) {
            case 0:
                listCategoria = DataBase.DataBaseCategoria.buscaCategorias(seleccion);
                for (ModelCategoria list1 : listCategoria)
                    idCategoria.addItem(list1.getNombre());
                temp = listCategoria;
                break;
            case 1:
                listProveedor = DataBase.DataBaseProveedor.buscaProveedores();
                for (ModelProveedor list1 : listProveedor)
                    idProveedor.addItem(list1.getNombre() + " " + list1.getaPaterno());
                temp = listProveedor;
                break;
            case 2:
                listProductos = DataBase.DataBaseProducto.buscaCategorias(seleccion);
                for (ModelProducto list1 : listProductos)
                    idProducto.addItem(list1.getIdProducto()+" "+list1.getNombre());
                temp = listProveedor;
                break;
        }
        return temp;
    }

    //---------------------------------------------
    public boolean modificaCliente(JLabel labelStatus, ModelCliente cliente) {
        boolean flag = false;
        if (!Nombre.getText().equals("Nombre (*)") && !Nombre.getText().isEmpty()) {
            if (!acApellidoPaterno.getText().equals("Apellido Paterno (*)") && !acApellidoPaterno.getText().isEmpty()) {
                if (!acEmail.getText().equals("cliente@anais.com (*)") && !acEmail.getText().isEmpty()) {
                    if (!acTelCelular.getText().equals("xx-xxx-xxxxxxx (*)") && !acTelCelular.getText().isEmpty()) {
                        if (!acCP.getText().equals("xxxxx (*)") && !acCP.getText().isEmpty()) {
                            if (DataBase.DataBaseCliente.modifUser(cliente)) {
                                ControllerViewMsj.informacion(Nombre.getText() + " modificado con éxito", "Modificación de usuario");
                                flag = true;
                            } else {
                                labelStatus.setText("Error interno para almacenar la información");
                            }
                        } else {
                            ControllerViewMsj.muestraMensajeGlobo("Agrega un código postal", acCP);
                        }
                    } else {
                        ControllerViewMsj.muestraMensajeGlobo("Agrega un teléfono móvil", acTelCelular);
                    }
                } else {
                    ControllerViewMsj.muestraMensajeGlobo("Agrega un email", acEmail);
                }
            } else {
                ControllerViewMsj.muestraMensajeGlobo("Agrega un apellido paterno", acApellidoPaterno);
            }
        } else {
            ControllerViewMsj.muestraMensajeGlobo("Agrega un nombre para el cliente", Nombre);
        }
        return flag;
    }

    public void identificaInfo(ModelCliente model) {
        if (!model.getNombre().equals("")) {
            Nombre.setForeground(Color.black);
            Nombre.setText(model.getNombre());
        }
        if (!model.getaPaterno().equals("")) {
            acApellidoPaterno.setText(model.getaPaterno());
            acApellidoPaterno.setForeground(Color.black);
        }
        if (!model.getaMaterno().equals("")) {
            acApellidoMaterno.setText(model.getaMaterno());
            acApellidoMaterno.setForeground(Color.black);
        }
        if (!model.getRFC().equals("")) {
            acRFC.setText(model.getRFC());
            acRFC.setForeground(Color.black);
        }
        if (!model.getTelFijo().equals("")) {
            acTelefono.setForeground(Color.black);
            acTelefono.setText("" + model.getTelFijo());
        }
        if (!model.getTelCel().equals("")) {
            acTelCelular.setForeground(Color.black);
            acTelCelular.setText("" + model.getTelCel());
        }
        if (!model.geteMail().equals("")) {
            acEmail.setForeground(Color.black);
            acEmail.setText("" + model.geteMail());
        }
        if (!model.getCalle().equals("")) {
            acCalle.setForeground(Color.black);
            acCalle.setText("" + model.getCalle());
        }
        if (!model.getCiudad().equals("")) {
            acCiudad.setForeground(Color.black);
            acCiudad.setText("" + model.getCalle());
        }
        if (!model.getColonia().equals("")) {
            acColonia.setForeground(Color.black);
            acColonia.setText("" + model.getCalle());
        }
        if (!model.getEstado().equals("")) {
            for (int i = 0; i < acEstados.getModel().getSize(); i++) {
                String est = (String) acEstados.getItemAt(i);
                if (est.equals(model.getEstado())) {
                    acEstados.setSelectedIndex(i);
                    break;
                }
            }
        }
        if (model.getCodigoPostal() != 0) {
            acCP.setForeground(Color.black);
            acCP.setText("" + model.getCodigoPostal());
        }
        if (model.getNumExt() != 0) {
            acNoExt.setForeground(Color.black);
            acNoExt.setText("" + model.getNumExt());
        }
        if (model.getNumInt() != 0) {
            acNoInt.setForeground(Color.black);
            acNoInt.setText("" + model.getNumInt());
        }
    }

    public ModelCliente creaModelo(ModelCliente model) {
        model.setNombre(reviewInfo(Nombre, "Nombre (*)", true));
        model.setaPaterno(reviewInfo(acApellidoPaterno, "Apellido Paterno (*)", true));
        model.setaMaterno(reviewInfo(acApellidoMaterno, "Apellido Materno", true));
        model.setRFC(reviewInfo(acRFC, "R.F.C.", true));
        model.setTelFijo(reviewInfo(acTelefono, "xx-xxx-xxxxxxx", true));
        model.setTelCel(reviewInfo(acTelCelular, "xx-xxx-xxxxxxx (*)", true));
        model.seteMail(reviewInfo(acEmail, "cliente@anais.com (*)", true));
        model.setCalle(reviewInfo(acCalle, "Calle", true));
        model.setCiudad(reviewInfo(acCiudad, "Ciudad", true));
        model.setColonia(reviewInfo(acColonia, "Colonia", true));
        model.setEstado((String) acEstados.getItemAt(acEstados.getSelectedIndex()));
        model.setCodigoPostal(Integer.parseInt(reviewInfo(acCP, "xxxxx (*)", false)));
        model.setNumExt(Integer.parseInt(reviewInfo(acNoExt, "No.Ext.", false)));
        model.setNumInt(Integer.parseInt(reviewInfo(acNoInt, "No.Int.", false)));
        return model;
    }

    private String reviewInfo(JTextField box, String value, boolean flag) {
        if (flag) {
            if (box.getText().equals(value) || box.getText().equals("")) {
                return "";
            } else {
                return box.getText();
            }
        } else {
            if (box.getText().equals(value) || box.getText().equals("")) {
                return "0";
            } else {
                return box.getText();
            }
        }
    }

    public void limpiaCampos() {
        limpiaJtextField(Nombre, "Nombre (*)");
        limpiaJtextField(acApellidoPaterno, "Apellido Paterno (*)");
        limpiaJtextField(acApellidoMaterno, "Apellido Materno");
        limpiaJtextField(acRFC, "R.F.C.");
        limpiaJtextField(acTelefono, "xx-xxx-xxxxxxx");
        limpiaJtextField(acEmail, "cliente@anais.com (*)");
        limpiaJtextField(acTelCelular, "xx-xxx-xxxxxxx (*)");
        limpiaJtextField(acCalle, "Calle");
        limpiaJtextField(acNoExt, "No.Ext.");
        limpiaJtextField(acNoInt, "No.Int.");
        limpiaJtextField(acCP, "xxxxx (*)");
        limpiaJtextField(acColonia, "Colonia");
        limpiaJtextField(acCiudad, "Ciudad");
        acEstados.setSelectedIndex(0);
    }

    private void limpiaJtextField(JTextField box, String msj) {
        box.setForeground(new Color(180, 180, 180));
        box.setText(msj);
    }
}
