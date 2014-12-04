/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Teté
 */
public class Proveedor_has_Producto {
    private int prooveedor_idproveedor;
    private String producto_idproducto;
    private int producto_empresa_idempresa;
    private int prodcuto_categoria_idcategoria;

    /**
     * @return the prooveedor_idproveedor
     */
    public int getProoveedor_idproveedor() {
        return prooveedor_idproveedor;
    }

    /**
     * @param prooveedor_idproveedor the prooveedor_idproveedor to set
     */
    public void setProoveedor_idproveedor(int prooveedor_idproveedor) {
        this.prooveedor_idproveedor = prooveedor_idproveedor;
    }

    /**
     * @return the producto_idproducto
     */
    public String getProducto_idproducto() {
        return producto_idproducto;
    }

    /**
     * @param producto_idproducto the producto_idproducto to set
     */
    public void setProducto_idproducto(String producto_idproducto) {
        this.producto_idproducto = producto_idproducto;
    }

    /**
     * @return the producto_empresa_idempresa
     */
    public int getProducto_empresa_idempresa() {
        return producto_empresa_idempresa;
    }

    /**
     * @param producto_empresa_idempresa the producto_empresa_idempresa to set
     */
    public void setProducto_empresa_idempresa(int producto_empresa_idempresa) {
        this.producto_empresa_idempresa = producto_empresa_idempresa;
    }

    /**
     * @return the prodcuto_categoria_idcategoria
     */
    public int getProdcuto_categoria_idcategoria() {
        return prodcuto_categoria_idcategoria;
    }

    /**
     * @param prodcuto_categoria_idcategoria the prodcuto_categoria_idcategoria to set
     */
    public void setProdcuto_categoria_idcategoria(int prodcuto_categoria_idcategoria) {
        this.prodcuto_categoria_idcategoria = prodcuto_categoria_idcategoria;
    }
}
