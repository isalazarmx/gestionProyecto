package Controller;

import Model.ModelCategoria;
import Model.ModelProducto;
import Model.ModelProveedor;
import Model.Proveedor_has_Producto;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    JTextField precioVenta01;
    JButton imagen;
    JTextField gananciaIndividual;
    JTextField gananciaTotal;
    JTextField inversion;
    JLabel labelStatus;
    JLabel labelStatus02;
    JButton eliminar;
    ControllerCuentas cuentas;
    List<ModelCategoria> listCategoria;
    List<ModelProveedor> listProveedor;
    List<ModelProducto> listProductos;
    List<Proveedor_has_Producto> listRelations;
    boolean modifica;
    double precioCompra;
    double precioVenta;
    private File rutaImagen;
    ModelProducto modelTemp;

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
        this.precioVenta01 = (JTextField) components.get(14);
        this.imagen = (JButton) components.get(15);
        this.gananciaIndividual = (JTextField) components.get(16);
        this.gananciaTotal = (JTextField) components.get(17);
        this.inversion = (JTextField) components.get(18);
        this.labelStatus = (JLabel) components.get(19);
        this.labelStatus02 = (JLabel) components.get(20);
        this.eliminar = (JButton) components.get(21);
        modifica = false;
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
        precioCompra = precioCompra();
        precioVenta = cuentas.precioVenta(precioCompra, incremento());
        double temp = cuentas.gananciaIndividual(precioCompra, incremento());
        gananciaIndividual.setText(cuentas.formatoNumero("" + temp));
        gananciaTotal.setText("" + cuentas.formatoNumero("" + cuentas.gananciaTotal(temp, cantidadProductos())));
        precioVenta01.setText("" + cuentas.formatoNumero("" + precioVenta));
        inversion.setText("" + cuentas.formatoNumero("" + cuentas.cantidadInvertida(cantidadProductos(), precioCompra)));
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

    public List cargarCombo(int tipoProducto, boolean seleccion) {
        List temp = null;
        switch (tipoProducto) {
            case 0:
                int cant00 = idCategoria.getItemCount()-1;
                for (int i = cant00; i > 0; i--) {
                    idCategoria.removeItemAt(i);
                }
                listCategoria = DataBase.DataBaseCategoria.buscaCategorias(seleccion);
                for (ModelCategoria list1 : listCategoria)
                    idCategoria.addItem(list1.getNombre());
                temp = listCategoria;
                break;
            case 1:
                int cant01 = idProveedor.getItemCount()-1;
                for (int i = cant01; i > 0; i--) {
                    idProveedor.removeItemAt(i);
                }
                listProveedor = DataBase.DataBaseProveedor.buscaProveedores();
                for (ModelProveedor list1 : listProveedor)
                    idProveedor.addItem(list1.getNombre() + " " + list1.getaPaterno());
                temp = listProveedor;
                break;
            case 2:
                int cant02 = idProducto.getItemCount()-1;
                for (int i = cant02; i > 0; i--) {
                    idProducto.removeItemAt(i);
                }
                listProductos = DataBase.DataBaseProducto.buscaProductos(seleccion);
                for (ModelProducto list1 : listProductos)
                    idProducto.addItem(list1.getNombre());
                temp = listProductos;
                break;
            case 3:
                listRelations = DataBase.DataBaseProveedor_has_Producto.buscaRelations();
                break;
        }
        return temp;
    }

    public void agregaModificaProducto(){
        if(validaCampos()){
            if(!modifica){
                    ModelProducto categoria = creaModelProducto(new ModelProducto(), false);
                if (DataBase.DataBaseProducto.addProducto(categoria)) {
                    Proveedor_has_Producto relation = creaModelRelation(new Proveedor_has_Producto());
                    if(DataBase.DataBaseProveedor_has_Producto.addRegister(relation)){
                        limpiaCampos();
                        labelStatus.setText("Categoría agregada con éxito");
                    }else {
                        JOptionPane.showMessageDialog(null, "Error interno para almacenar la información");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error interno para almacenar la información");
                }
            }else{
                ModelProducto categoria = creaModelProducto(new ModelProducto(), false);
                if (DataBase.DataBaseProducto.modificaProducto(categoria)){
                    Proveedor_has_Producto relation = creaModelRelation(new Proveedor_has_Producto());
                     if(DataBase.DataBaseProveedor_has_Producto.modificaRegister(relation)){
                        limpiaCampos();
                        labelStatus.setText("Categoría agregada con éxito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error interno para almacenar la información");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Error interno para almacenar la información");
                }
            }
        }
    }
    
    private Proveedor_has_Producto creaModelRelation(Proveedor_has_Producto model){
        model.setProoveedor_idproveedor(buscaIdProveedor());
        model.setProducto_idproducto(ID.getText());
        model.setProducto_empresa_idempresa(1);
        model.setProdcuto_categoria_idcategoria(buscaIdCategoria());
        return model;
    }
    
    public boolean validaCampos() {
        boolean flag = false;
        if (!((String) idCategoria.getItemAt(idCategoria.getSelectedIndex())).equals("Selecciona categoría")) {
            if (!((String) idProveedor.getItemAt(idProveedor.getSelectedIndex())).equals("Selecciona proveedor")) {
                if (!ID.getText().equals("Código de barras") && !ID.getText().isEmpty()) {
                    if(!DataBase.DataBaseProducto.checkExistProducto(ID.getText()) || modifica){
                        if (!nombre.getText().equals("Nombre del producto") && !nombre.getText().isEmpty()) {
                            if (!cantidad01.getText().equals("0") && !cantidad01.getText().isEmpty()) {
                                if (!unidadExistencia.getText().equals("0") && !unidadExistencia.getText().isEmpty()) {
                                    if (!precioCompra01.getText().equals("0") && !precioCompra01.getText().isEmpty()) {
                                        flag = true;
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
                    }else{
                        ControllerViewMsj.muestraMensajeGlobo("El producto ya existe", ID);
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
        return flag;
    }
    
    public ModelProducto creaModelProducto(ModelProducto model, boolean tipoProducto) {
        model.setIdProducto(ID.getText());
        model.setNombre(nombre.getText());
        model.setCantidad(obtenerCantidad());
        model.setTipoUnidad((String)tipoUnidad.getSelectedItem());
        model.setUnidadExistencia(Integer.parseInt(unidadExistencia.getText()));
        model.setMinStock((Integer)minStock.getValue());
        model.setMaxStock((Integer)maxStock.getValue());
        model.setPrecioVenta(precioVenta);
        model.setIncrementoVenta((Integer)incrementoVenta.getValue());
        model.setPrecioCompra(precioCompra);
        if(rutaImagen!=null)
            model.setRutaImagen(rutaImagen);
        else
            model.setImagen(modelTemp.getImagen());
        if(!tipoProducto)
            model.setTipoProducto(3);
        else
            model.setTipoProducto(2);
        model.setEmprsa_idempresa(1);
        model.setCategoria_idcategoria(buscaIdCategoria());
        return model;
    }
    
    private int buscaIdCategoria(){
        for (int i = 0; i < listCategoria.size(); i++) {
            ModelCategoria modTemp = listCategoria.get(i);
            if(modTemp.getNombre().equals((String)idCategoria.getSelectedItem()))
               return modTemp.getIdCategoria();
        }
        return 0;
    }
    
    private int buscaIdProveedor(){
        for (int i = 0; i < listProveedor.size(); i++) {
            ModelProveedor modTemp = listProveedor.get(i);
            if((modTemp.getNombre()+" "+modTemp.getaPaterno()).equals((String)idProveedor.getSelectedItem()))
               return modTemp.getIdProveedor();
        }
        return 0;
    }
    
    private double obtenerCantidad(){
        return Integer.parseInt(cantidad01.getText()) + (Integer.parseInt(cantidad02.getText())/100);
    }
    
    public void identificaInfo(JPanel panelImage) {
        int pos = idProducto.getSelectedIndex()-1;
        if (pos != -1){
            modelTemp = listProductos.get(pos);
            Model.Proveedor_has_Producto relations = buscaRelations(modelTemp.getIdProducto());
            idCategoria.setEnabled(false);
            idCategoria.setSelectedIndex(identificaInfoCom(relations.getProdcuto_categoria_idcategoria(),true));
            idProveedor.setSelectedIndex(identificaInfoCom(relations.getProoveedor_idproveedor(),false));
            ID.setForeground(Color.BLACK);
            ID.setEditable(false);
            ID.setText(modelTemp.getIdProducto());
            nombre.setForeground(Color.BLACK);
            nombre.setText(modelTemp.getNombre());
            String[] temp;
            temp = convertirCantidades(modelTemp.getCantidad());
            cantidad01.setForeground(Color.BLACK);
            cantidad01.setText(temp[0]);
            cantidad02.setForeground(Color.BLACK);
            cantidad02.setText(temp[1]);
            tipoUnidad.setSelectedIndex(buscatipoUnidad(modelTemp.getTipoUnidad()));
            unidadExistencia.setForeground(Color.BLACK);
            unidadExistencia.setText(""+modelTemp.getUnidadExistencia());
            minStock.setValue(modelTemp.getMinStock());
            maxStock.setValue(modelTemp.getMaxStock());
            temp = convertirCantidades(modelTemp.getPrecioCompra());
            precioCompra01.setForeground(Color.BLACK);
            precioCompra01.setText(temp[0]);
            precioCompra02.setForeground(Color.BLACK);
            precioCompra02.setText(temp[1]);
            temp = convertirCantidades(modelTemp.getIncrementoVenta());
            incrementoVenta.setValue(Integer.parseInt(temp[0]));
            despliegaCuentas();
            new ControllerImagenes().cargaImagen(modelTemp.getImagen(), panelImage, imagen);
            modifica = true;
            labelStatus02.setText("Modifica campos para producto");
            eliminar.setVisible(true);
        }else
            limpiaCampos();
    }
    
    private int buscatipoUnidad(String unidadPeso){
        for (int i = 0; i < tipoUnidad.getItemCount(); i++) {
            String value = (String)tipoUnidad.getItemAt(i);
            if(value.equals(unidadPeso))
                return i;
        }
        return 0;
    }
    
    private String[] convertirCantidades(Double valor){
        String aux = ""+valor;
        int posDot = aux.indexOf(".");
        String valor1 = aux.substring(0,posDot);
        int posDotTemp = posDot+1;
        String valor2 = aux.substring(posDotTemp,aux.length());
        String[] temp = new String[]{valor1,valor2};
        return temp;
    }
    
    private int identificaInfoCom(int id,boolean opc){
        if(opc){
            for (int i = 0; i < listCategoria.size(); i++) {
                ModelCategoria model = listCategoria.get(i);
                if (model.getIdCategoria()==id){
                    i++;
                    return i;
                }
            }
        }else{
            for (int i = 0; i < listProveedor.size(); i++) {
                ModelProveedor model = listProveedor.get(i);
                if (model.getIdProveedor()==id){
                    i++;
                    return i;
                }
            }        
        }
        return 0;
    }
    
    private Model.Proveedor_has_Producto buscaRelations(String idProducto){
        for (int i = 0; i < listRelations.size(); i++) {
            Model.Proveedor_has_Producto model = listRelations.get(i);
            if(model.getProducto_idproducto().equals(idProducto))
                return model;
        }
        return new Proveedor_has_Producto();
    }
    
    public void limpiaCampos() {
        idProducto.setSelectedIndex(0);
        idCategoria.setEnabled(true);
        idCategoria.setSelectedIndex(0);
        idProveedor.setSelectedIndex(0);
        ID.setEditable(true);
        limpiaJtextField(ID,"Código de barras");
        limpiaJtextField(nombre,"Nombre del producto");
        limpiaJtextField(cantidad01,"0");
        limpiaJtextField(cantidad02,"00");
        limpiaJtextField(unidadExistencia,"0");
        minStock.setValue(5);
        maxStock.setValue(10);
        limpiaJtextField(precioCompra01,"0");
        limpiaJtextField(precioCompra02,"00");
        incrementoVenta.setValue(0);
        limpiaJtextField(gananciaIndividual,"0");
        limpiaJtextField(gananciaTotal,"0");
        limpiaJtextField(inversion,"0");
        limpiaJtextField(precioVenta01,"0");
        gananciaIndividual.setForeground(Color.BLACK);
        gananciaTotal.setForeground(Color.BLACK);
        inversion.setForeground(Color.BLACK);
        precioVenta01.setForeground(Color.BLACK);
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/buscaImagen.png")));
        cargaCombos();
        modifica=false;
        labelStatus02.setText("");
        eliminar.setVisible(false);
    }

    public void cargaCombos(){
        for (int i = 0; i < 4; i++)
        cargarCombo(i,true);
    }
    
    private void limpiaJtextField(JTextField box, String msj) {
        box.setForeground(new Color(180, 180, 180));
        box.setText(msj);
    }

    public void eliminaCategoria(JLabel status){
            String[] dat = new String[2];
            dat[0]="Si";
            dat[1]="No";
            if(ControllerViewMsj.pregunta("Estás seguro de quere eliminar esta categoría?", dat,idProveedor)==0){
                DataBase.DataBaseProducto.eliminaProducto(ID.getText());
                limpiaCampos();
                status.setText("Categoría eliminada con éxito");
                cargaCombos();
            }else
                labelStatus02.setText("Eliminación de usuario cancelada");
    }
    
    /**
     * @return the rutaImagen
     */
    public File getRutaImagen() {
        return rutaImagen;
    }

    /**
     * @param rutaImagen the rutaImagen to set
     */
    public void setRutaImagen(File rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
