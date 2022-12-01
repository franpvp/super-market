package com.westmarket.busines;

import java.util.ArrayList;

public class Producto {

    String cod;
    String desc;
    String precio;
    String stock;
    Categoria categoria;

    public Producto(){
    }

    public Producto(String codProd, String desc, String precio, String stock, Categoria categoria) {
        this.cod = codProd;
        this.desc = desc;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }
    public ArrayList<Producto> listaProductos = new ArrayList<>();

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    //Metodo que imprime el codigo, descripcion, precio, stock, categoria de los productos
    public void imprimirListado(ArrayList<Producto> listaProductos){

        System.out.println("--- Listado de productos ---");
        for (Producto prod : listaProductos){
            System.out.println("Código: " + prod.getCod());
            System.out.println("Descripción: " + prod.getDesc());
            System.out.println("Precio: " + prod.getPrecio());
            System.out.println("Categoría: " +  prod.getCategoria().getNombreCat() + " (Cod: " + prod.getCategoria().getCodCat() + ")");
            System.out.println("Stock: " + prod.getStock());
            System.out.println("----------------------------------\n");
        }
    }
    //Metodo que trae el codigo del producto y su descripcion
    public void imprimirListadoSimple(ArrayList<Producto> listaProductos){

        System.out.println("--- Productos ingresados ---");
        for (Producto prod : listaProductos){
            System.out.println("Código: " + prod.getCod());
            System.out.println("Descripción: " + prod.getDesc());
            System.out.println("----------------------------------\n");
        }
    }


    @Override
    public String toString() {
        return "Producto{" +
                "codProd='" + cod + '\'' +
                ", desc='" + desc + '\'' +
                ", precio='" + precio + '\'' +
                ", stock='" + stock + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
