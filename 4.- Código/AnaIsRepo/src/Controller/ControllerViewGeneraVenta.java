package Controller;

import Model.ModelCategoria;
import Model.ModelCliente;
import Model.ModelProducto;
import Model.ModelProveedor;
import Model.Proveedor_has_Producto;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carolina
 */
public class ControllerViewGeneraVenta {
    JTextField codigoBarras;
    JPanel panelImagen;
    JButton imagen;
    JComboBox idProductoTienda;
    JComboBox tipoVenta;
    JTextField existencia;
    JTextField precio;
    JSpinner cantidad;
    JButton agregar;
    JComboBox idCliente;
    JDateChooser fechaEntrega;
    JSpinner hora;
    JSpinner minutos;
    JTextArea descripcion;
    JTextField precioKilo;
    JSpinner kilos;
    JTextField abono01;
    JTextField abono02;
    JTextField resto;
    JTable tablaNuevaVenta;
    DefaultTableModel modelTableVenta;
    JTextField cantidadRecibida01;
    JTextField cantidadRecibida02;
    JTextField resta01;
    JTextField cambio;
    JTextField total;
    List<ModelProducto> listProductosVenta;
    List<ModelProducto> listProductosAlmacen;
    List<ModelCliente> listCliente;
    ModelProducto modTemp;
    JComboBox idProductoAlmacen;
    ControllerCuentas cuentas;
    ControllerTables controllerTableS;
    double precioTotal;
    double abonoPrecio;
    double restoPrecio;
    ///------------------------------------------------
    
    List<ModelCategoria> listCategoria;
    List<ModelProveedor> listProveedor;
    List<Proveedor_has_Producto> listRelations;
    boolean modifica;
    double precioCompra;
    double precioVenta;
    boolean tipoaAlmacen;

    public ControllerViewGeneraVenta(ArrayList components) {
        controllerTableS =  new ControllerTables();
        this.codigoBarras = (JTextField)components.get(0);
        this.idProductoTienda = (JComboBox)components.get(1);
        this.panelImagen = (JPanel)components.get(2);
        this.imagen = (JButton)components.get(3);
        this.tipoVenta= (JComboBox)components.get(4);
        this.existencia= (JTextField)components.get(5);
        this.precio= (JTextField)components.get(6);
        this.cantidad= (JSpinner)components.get(7);
        this.agregar= (JButton)components.get(8);
        this.idCliente= (JComboBox)components.get(9);
        this.fechaEntrega= (JDateChooser)components.get(10);
        this.hora= (JSpinner)components.get(11);
        this.minutos= (JSpinner)components.get(12);
        this.descripcion= (JTextArea)components.get(13);
        this.precioKilo= (JTextField)components.get(14);
        this.kilos= (JSpinner)components.get(15);
        this.abono01= (JTextField)components.get(16);
        this.abono02= (JTextField)components.get(17);
        this.resto= (JTextField)components.get(18);
        controllerTableS.setTabla((JTable)components.get(19));
        controllerTableS.setModelTable((DefaultTableModel)components.get(20));
        this.cantidadRecibida01= (JTextField)components.get(21);
        this.cantidadRecibida02= (JTextField)components.get(22);
        this.resta01= (JTextField)components.get(23);
        this.cambio= (JTextField)components.get(24);
        this.total= (JTextField)components.get(25);
        this.idProductoAlmacen = (JComboBox)components.get(26);
        cuentas = new ControllerCuentas();
        controllerTableS.getTabla().setModel(controllerTableS.getModelTable());
    }

    public void validations(){
        ControllerValidation.limitarCaracteres(codigoBarras,30);
        ControllerValidation.soloNumeros(abono01);
        ControllerValidation.limitarCaracteres(abono01,9);
        ControllerValidation.soloNumeros(abono02);
        ControllerValidation.limitarCaracteres(abono02,2);
        ControllerValidation.soloNumeros(cantidadRecibida01);
        ControllerValidation.limitarCaracteres(cantidadRecibida01,9);
        ControllerValidation.soloNumeros(cantidadRecibida02);
        ControllerValidation.limitarCaracteres(cantidadRecibida02,2);
        ControllerValidation.limitarCaracteres(descripcion,250);
        
    }
    
    public void muestraInfoPedido(JPanel panelPedido,JLabel labelPrecioKilo,JLabel labelKilos){
    if(!idProductoTienda.getSelectedItem().equals("Producto tienda")
            ||!idProductoAlmacen.getSelectedItem().equals("Producto almacen")
            ||precio.equals("0")){    
        if(tipoVenta.getSelectedItem().equals("Pedido")){
            limpiaCamposPedido();
            panelPedido.setVisible(true);
            if(modTemp.getTipoProducto()==3){
                labelPrecioKilo.setVisible(false);
                precioKilo.setVisible(false);
                labelKilos.setVisible(false);
                kilos.setVisible(false);
                String[] temp = convertirCantidades(precioTotal);
                precio.setText(temp[0]+"."+temp[1]);
                resto.setText(temp[0]+"."+temp[1]);
            }else{
                String[] temp = convertirCantidades(precioTotal);
                precio.setText(temp[0]+"."+temp[1]);
                resto.setText(temp[0]+"."+temp[1]);
                labelPrecioKilo.setVisible(true);
                precioKilo.setVisible(true);
                precioKilo.setText(""+modTemp.getPrecioKilo());
                labelKilos.setVisible(true);
                kilos.setVisible(true);
            }
        }else
            panelPedido.setVisible(false);
    }else{
        ControllerViewMsj.muestraMensajeGlobo("Seleciona un producto de la tienda", tipoVenta);
        tipoVenta.setSelectedIndex(0);
    }
    }
    
    public void buscaInfoProducto(boolean tipoProducto){
        boolean agregarInfo = false;
        if(tipoProducto){
            int selected = idProductoAlmacen.getSelectedIndex()-1;
            if(selected==-1)
                limpiaCamposVenta();
            else{
                modTemp = listProductosAlmacen.get(selected);
                agregarInfo=true;
            }
        }else{
            int selected = idProductoTienda.getSelectedIndex()-1;
            if(selected==-1)
                limpiaCamposVenta();
            else{
                modTemp = listProductosVenta.get(selected);
                agregarInfo=true;
            }
        }
        if(agregarInfo){
            new ControllerImagenes().cargaImagen(modTemp.getImagen(), panelImagen, imagen);
            existencia.setText(""+modTemp.getUnidadExistencia());
            precio.setText(""+modTemp.getPrecioVenta());
            String[] temp = convertirCantidades(modTemp.getPrecioVenta());
            precioTotal = buscaValor(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
            precioKilo.setText(""+modTemp.getPrecioKilo());
            cantidad.setModel(new SpinnerNumberModel(1,1,modTemp.getUnidadExistencia(),1));
            panelImagen.updateUI();
        }
    }
    
    public void calcularPrecioVentaGeneral(boolean tipoCampo){
        if(modTemp != null){
            if(tipoCampo){
                double val1 = (Integer)cantidad.getValue();
                double val2 = modTemp.getPrecioVenta();
                precioTotal = cuentas.gananciaIndividual(val2,val1);
            }else{
                double val1 = (Integer)kilos.getValue();
                double val2 = modTemp.getPrecioKilo();
                precioTotal = cuentas.gananciaIndividual(val2,val1);
                restoPrecio = precioTotal;
            }
            String[] temp = convertirCantidades(precioTotal);
            precio.setText(temp[0]+"."+temp[1]);
            resto.setText(temp[0]+"."+temp[1]);
        }
        
    }
    
    private String[] convertirCantidades(Double valor){
        String aux = ""+valor;
        int posDot = aux.indexOf(".");
        String valor1 = aux.substring(0,posDot);
        int posDotTemp = posDot+1;
        int posDotTemp2 = posDot+3;
        if(aux.length()<posDotTemp2)
            posDotTemp2=posDotTemp2-1;
        String valor2 = aux.substring(posDotTemp,posDotTemp2);
        if(valor2.length()==1)
            valor2 = valor2+"0";
        String[] temp = new String[]{valor1,valor2};
        return temp;
    }
        
//    private double incremento() {
//        double temp2 = (Integer) incrementoVenta.getValue();
//        double temp = temp2 / 100;
//        return temp;
//    }
//
    private double buscaValor(double parteEntera, double parteDecimal) {
        return parteEntera + (parteDecimal / 100);
    }
//
//    private double precioCompra() {
//        return buscaValor(
//                Integer.parseInt(precioCompra01.getText()),
//                Integer.parseInt(precioCompra02.getText())
//        );
//    }
//    
//    private double precioKilo() {
//        return buscaValor(
//                Integer.parseInt(precioKilo01.getText()),
//                Integer.parseInt(precioKilo02.getText())
//        );
//    }
//
//    private double cantidadProductos() {
//        return Integer.parseInt(unidadExistencia.getText());
//    }
//
//    public void despliegaCuentas() {
//        precioCompra = precioCompra();
//        precioVenta = cuentas.precioVenta(precioCompra, incremento());
//        double temp = cuentas.gananciaIndividual(precioCompra, incremento());
//        gananciaIndividual.setText(cuentas.formatoNumero("" + temp));
//        gananciaTotal.setText("" + cuentas.formatoNumero("" + cuentas.gananciaTotal(temp, cantidadProductos())));
//        precioVenta01.setText("" + cuentas.formatoNumero("" + precioVenta));
//        inversion.setText("" + cuentas.formatoNumero("" + cuentas.cantidadInvertida(cantidadProductos(), precioCompra)));
//    }
//
    public List cargarCombo(int tipoProducto) {
        List temp = null;
        switch (tipoProducto) {
            case 0:
                int cant00 = idProductoTienda.getItemCount()-1;
                for (int i = cant00; i > 0; i--) {
                    idProductoTienda.removeItemAt(i);
                }
                listProductosVenta = DataBase.DataBaseProducto.buscaProductos(false);
                for (ModelProducto list1 : listProductosVenta)
                    idProductoTienda.addItem(list1.getNombre());
                temp = listProductosVenta;
                break;
            case 1:
                int cant01 = idProductoAlmacen.getItemCount()-1;
                for (int i = cant01; i > 0; i--) {
                    idProductoAlmacen.removeItemAt(i);
                }
                listProductosAlmacen = DataBase.DataBaseProducto.buscaProductos(true);
                for (ModelProducto list1 : listProductosAlmacen)
                    idProductoAlmacen.addItem(list1.getNombre());
                temp = listProductosAlmacen;
                break;
            case 2:
                int cant02 = idCliente.getItemCount()-1;
                for (int i = cant02; i > 0; i--) {
                    idCliente.removeItemAt(i);
                }
                listCliente = DataBase.DataBaseCliente.buscaCliente("","",true);
                for (ModelCliente list1 : listCliente)
                    idCliente.addItem(list1.getNombre() + " " + list1.getaPaterno());
                temp = listCliente;
                break;
        }
        return temp;
    }
//
//    public void agregaModificaProducto(){
//        if(validaCampos()){
//            if(!modifica){
//                    ModelProducto categoria = creaModelProducto(new ModelProducto(), tipoaAlmacen);
//                if (DataBase.DataBaseProducto.addProducto(categoria)) {
//                    Proveedor_has_Producto relation = creaModelRelation(new Proveedor_has_Producto());
//                    if(DataBase.DataBaseProveedor_has_Producto.addRegister(relation)){
//                        limpiaCampos();
//                        labelStatus.setText("Categoría agregada con éxito");
//                    }else {
//                        JOptionPane.showMessageDialog(null, "Error interno para almacenar la información");
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(null, "Error interno para almacenar la información");
//                }
//            }else{
//                ModelProducto categoria = creaModelProducto(new ModelProducto(), tipoaAlmacen);
//                if (DataBase.DataBaseProducto.modificaProducto(categoria)){
//                    Proveedor_has_Producto relation = creaModelRelation(new Proveedor_has_Producto());
//                     if(DataBase.DataBaseProveedor_has_Producto.modificaRegister(relation)){
//                        limpiaCampos();
//                        labelStatus.setText("Categoría agregada con éxito");
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Error interno para almacenar la información");
//                    }
//                }else {
//                    JOptionPane.showMessageDialog(null, "Error interno para almacenar la información");
//                }
//            }
//        }
//    }
//    
//    private Proveedor_has_Producto creaModelRelation(Proveedor_has_Producto model){
//        model.setProoveedor_idproveedor(buscaIdProveedor());
//        model.setProducto_idproducto(ID.getText());
//        model.setProducto_empresa_idempresa(1);
//        model.setProdcuto_categoria_idcategoria(buscaIdCategoria());
//        return model;
//    }
//    
//    public boolean validaCampos() {
//        boolean flag = false;
//        if (!((String) idCategoria.getItemAt(idCategoria.getSelectedIndex())).equals("Selecciona categoría")) {
//            if (!((String) idProveedor.getItemAt(idProveedor.getSelectedIndex())).equals("Selecciona proveedor")) {
//                if (!ID.getText().equals("Código de barras") && !ID.getText().isEmpty()) {
//                    if(!DataBase.DataBaseProducto.checkExistProducto(ID.getText()) || modifica){
//                        if (!nombre.getText().equals("Nombre del producto") && !nombre.getText().isEmpty()) {
//                            if (!precioKilo01.getText().equals("0") && !precioCompra01.getText().isEmpty() || tipoaAlmacen) {
//                                if (!cantidad01.getText().equals("0") && !cantidad01.getText().isEmpty()) {
//                                    if (!unidadExistencia.getText().equals("0") && !unidadExistencia.getText().isEmpty()) {
//                                        if (!precioCompra01.getText().equals("0") && !precioCompra01.getText().isEmpty()) {
//                                           flag = true;
//                                        } else {
//                                            ControllerViewMsj.muestraMensajeGlobo("Indica el precio del producto", precioCompra01);
//                                        }
//                                    } else {
//                                        ControllerViewMsj.muestraMensajeGlobo("Indica el precio del producto", unidadExistencia);
//                                    }
//                                } else {
//                                    ControllerViewMsj.muestraMensajeGlobo("Indica la cantidad de productos que tienes", cantidad01);
//                                }
//                            } else {
//                                ControllerViewMsj.muestraMensajeGlobo("Indica el peso del producto", precioKilo01);
//                            }
//                        } else {
//                            ControllerViewMsj.muestraMensajeGlobo("Identifica el producto con un nombre", nombre);
//                        }
//                    }else{
//                        ControllerViewMsj.muestraMensajeGlobo("El producto ya existe", ID);
//                    }
//                } else {
//                    ControllerViewMsj.muestraMensajeGlobo("El producto debe de tener un código de barras", ID);
//                }
//            } else {
//                ControllerViewMsj.muestraMensajeGlobo("Agrega un proveedor para el producto", idProveedor);
//            }
//        } else {
//            ControllerViewMsj.muestraMensajeGlobo("Agrega una categoría para el producto", idCategoria);
//        }
//        return flag;
//    }
//    
//    public ModelProducto creaModelProducto(ModelProducto model, boolean tipoProducto) {
//        model.setIdProducto(ID.getText());
//        model.setNombre(nombre.getText());
//        model.setCantidad(obtenerCantidad());
//        model.setTipoUnidad((String)tipoUnidad.getSelectedItem());
//        model.setUnidadExistencia(Integer.parseInt(unidadExistencia.getText()));
//        model.setMinStock((Integer)minStock.getValue());
//        model.setMaxStock((Integer)maxStock.getValue());
//        model.setPrecioVenta(precioVenta);
//        model.setIncrementoVenta((Integer)incrementoVenta.getValue());
//        model.setPrecioCompra(precioCompra);
//        if(rutaImagen!=null)
//            model.setRutaImagen(rutaImagen);
//        else
//            model.setImagen(modelTemp.getImagen());
//        if(tipoProducto)
//            model.setTipoProducto(3);
//        else
//            model.setTipoProducto(2);
//        if(!tipoaAlmacen)
//            model.setPrecioKilo(precioKilo());
//        model.setEmprsa_idempresa(1);
//        model.setCategoria_idcategoria(buscaIdCategoria());
//        return model;
//    }
//    
//    private int buscaIdCategoria(){
//        for (int i = 0; i < listCategoria.size(); i++) {
//            ModelCategoria modTemp = listCategoria.get(i);
//            if(modTemp.getNombre().equals((String)idCategoria.getSelectedItem()))
//               return modTemp.getIdCategoria();
//        }
//        return 0;
//    }
//    
//    private int buscaIdProveedor(){
//        for (int i = 0; i < listProveedor.size(); i++) {
//            ModelProveedor modTemp = listProveedor.get(i);
//            if((modTemp.getNombre()+" "+modTemp.getaPaterno()).equals((String)idProveedor.getSelectedItem()))
//               return modTemp.getIdProveedor();
//        }
//        return 0;
//    }
//    
//    private double obtenerCantidad(){
//        return Integer.parseInt(cantidad01.getText()) + (Integer.parseInt(cantidad02.getText())/100);
//    }
//    
//    public void identificaInfo(JPanel panelImage) {
//        int pos = idProductoTienda.getSelectedIndex()-1;
//        if (pos != -1){
//            modelTemp = listProductosVenta.get(pos);
//            Model.Proveedor_has_Producto relations = buscaRelations(modelTemp.getIdProducto());
//            idCategoria.setEnabled(false);
//            idCategoria.setSelectedIndex(identificaInfoCom(relations.getProdcuto_categoria_idcategoria(),true));
//            idProveedor.setSelectedIndex(identificaInfoCom(relations.getProoveedor_idproveedor(),false));
//            ID.setForeground(Color.BLACK);
//            ID.setEditable(false);
//            ID.setText(modelTemp.getIdProducto());
//            nombre.setForeground(Color.BLACK);
//            nombre.setText(modelTemp.getNombre());
//            String[] temp;
//            temp = convertirCantidades(modelTemp.getCantidad());
//            cantidad01.setForeground(Color.BLACK);
//            cantidad01.setText(temp[0]);
//            cantidad02.setForeground(Color.BLACK);
//            cantidad02.setText(temp[1]);
//            tipoUnidad.setSelectedIndex(buscatipoUnidad(modelTemp.getTipoUnidad()));
//            unidadExistencia.setForeground(Color.BLACK);
//            unidadExistencia.setText(""+modelTemp.getUnidadExistencia());
//            minStock.setValue(modelTemp.getMinStock());
//            maxStock.setValue(modelTemp.getMaxStock());
//            temp = convertirCantidades(modelTemp.getPrecioCompra());
//            precioCompra01.setForeground(Color.BLACK);
//            precioCompra01.setText(temp[0]);
//            precioCompra02.setForeground(Color.BLACK);
//            precioCompra02.setText(temp[1]);
//            if(!tipoaAlmacen){
//                temp = convertirCantidades(modelTemp.getPrecioKilo());
//                precioKilo01.setForeground(Color.BLACK);
//                precioKilo01.setText(temp[0]);
//                precioKilo02.setForeground(Color.BLACK);
//                precioKilo02.setText(temp[1]);
//            }
//            temp = convertirCantidades(modelTemp.getIncrementoVenta());
//            incrementoVenta.setValue(Integer.parseInt(temp[0]));
//            despliegaCuentas();
//            new ControllerImagenes().cargaImagen(modelTemp.getImagen(), panelImage, imagen);
//            modifica = true;
//            labelStatus02.setText("Modifica campos para producto");
//            eliminar.setVisible(true);
//        }else
//            limpiaCampos();
//    }
//    
//    private int buscatipoUnidad(String unidadPeso){
//        for (int i = 0; i < tipoUnidad.getItemCount(); i++) {
//            String value = (String)tipoUnidad.getItemAt(i);
//            if(value.equals(unidadPeso))
//                return i;
//        }
//        return 0;
//    }
//    
//    private String[] convertirCantidades(Double valor){
//        String aux = ""+valor;
//        int posDot = aux.indexOf(".");
//        String valor1 = aux.substring(0,posDot);
//        int posDotTemp = posDot+1;
//        String valor2 = aux.substring(posDotTemp,aux.length());
//        if(valor2.length()==1)
//            valor2 = valor2+"0";
//        String[] temp = new String[]{valor1,valor2};
//        return temp;
//    }
//    
//    private int identificaInfoCom(int id,boolean opc){
//        if(opc){
//            for (int i = 0; i < listCategoria.size(); i++) {
//                ModelCategoria model = listCategoria.get(i);
//                if (model.getIdCategoria()==id){
//                    i++;
//                    return i;
//                }
//            }
//        }else{
//            for (int i = 0; i < listProveedor.size(); i++) {
//                ModelProveedor model = listProveedor.get(i);
//                if (model.getIdProveedor()==id){
//                    i++;
//                    return i;
//                }
//            }        
//        }
//        return 0;
//    }
//    
//    private Model.Proveedor_has_Producto buscaRelations(String idProductoTienda){
//        for (int i = 0; i < listRelations.size(); i++) {
//            Model.Proveedor_has_Producto model = listRelations.get(i);
//            if(model.getProducto_idproducto().equals(idProductoTienda))
//                return model;
//        }
//        return new Proveedor_has_Producto();
//    }
//    
    public void limpiaCamposVenta() {
        codigoBarras.setForeground(new Color(180,180,180));
        codigoBarras.setText("Código de barras");
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/buscaImagen.png")));
        idProductoTienda.setSelectedIndex(0);
        idProductoAlmacen.setSelectedIndex(0);
        tipoVenta.setSelectedIndex(0);
        existencia.setText("0");
        precio.setText("0");
        cantidad.setValue(1);
        limpiaCamposPedido();
//        cantidadRecibida01.setForeground(new Color(180,180,180));
//        cantidadRecibida01.setText("0");
//        cantidadRecibida02.setForeground(new Color(180,180,180));
//        cantidadRecibida02.setText("00");
//        resta01.setText("0");
//        cambio.setText("0");
//        total.setText("0");
    }
    
    public void limpiaCamposPedido(){
        idCliente.setSelectedIndex(0);
        fechaEntrega.cleanup();
        hora.setValue(12);
        minutos.setValue(30);
        descripcion.setForeground(new Color(180,180,180));
        descripcion.setText("Agrega una descripción");
        precioKilo.setText("0");
        kilos.setValue(1);
        abono01.setForeground(new Color(180,180,180));
        abono01.setText("0");
        abono02.setForeground(new Color(180,180,180));
        abono02.setText("00");
        resto.setText("0");
    }
//
//    public void cargaCombos(){
//        for (int i = 0; i < 4; i++)
//        cargarCombo(i,tipoaAlmacen);
//    }
//    
//    private void limpiaJtextField(JTextField box, String msj) {
//        box.setForeground(new Color(180, 180, 180));
//        box.setText(msj);
//    }
//
//    public void eliminaCategoria(JLabel status){
//            String[] dat = new String[2];
//            dat[0]="Si";
//            dat[1]="No";
//            if(ControllerViewMsj.pregunta("Estás seguro de quere eliminar esta categoría?", dat,idProveedor)==0){
//                DataBase.DataBaseProducto.eliminaProducto(ID.getText());
//                limpiaCampos();
//                status.setText("Categoría eliminada con éxito");
//                cargaCombos();
//            }else
//                labelStatus02.setText("Eliminación de usuario cancelada");
//    }
//    
//    /**
//     * @return the rutaImagen
//     */
//    public File getRutaImagen() {
//        return rutaImagen;
//    }
//
//    /**
//     * @param rutaImagen the rutaImagen to set
//     */
//    public void setRutaImagen(File rutaImagen) {
//        this.rutaImagen = rutaImagen;
//    }
}
