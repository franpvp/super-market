package com.westmarket.busines;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSuperMarket {
    public static Producto producto = new Producto();
    public static Categoria categoria = new Categoria();
    public static ArrayList<Producto> listaProductos = new ArrayList<>();

    public static void main(String[] args) {

        //Mostrar menú principal
        while (true){
            if (!mostrarMenu()){
                System.out.println("Ha salido del sistema");
                break;
            }
        }
    }

    public static boolean mostrarMenu(){

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar){
            System.out.println("--- West Market ---");
            System.out.println("1. Registrar producto");
            System.out.println("2. Imprimir productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opción: ");
            int op = scanner.nextInt();
            if (op == 1){
                registrarProd();
            } else if (op == 2) {
                producto.imprimirListado(listaProductos);
            } else if (op == 3) {
                if (eliminarProd()){
                    System.out.println("El producto ha sido eliminado");
                } else {
                    System.out.println("El producto no existe");
                }
            } else if (op == 4) {
                continuar = false;
                break;
            } else {
                System.out.println("Ingreso inválido\n");
            }
        }
        return continuar;
    }
    //Métodos
    //Ingresar código del producto
    public static boolean registrarProd(){

        //Ingresar código
        boolean continuar = ingresarCod();
        //Ingresar descripción
        while (continuar){
            ingresarDesc();
            break;
        }
        //Ingresar precio
        while (continuar) {
            ingresarPrecio();
            break;
        }
        //Ingresar stock
        while (continuar){
            ingresarStock();
            break;
        }
        //Ingresar categoría del producto
        while (continuar){
            ingresarCategoria();
            break;
        }
        return continuar;
    }
    //Ingresar código del producto
    public static boolean ingresarCod(){

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        int intentosCod = 0;
        int numCod = 0;

        System.out.println("Ingrese código: ");
        String codProd = scanner.nextLine();
        while (true){
            if (codProd.isEmpty() && intentosCod != 3) {
                System.out.println("Debe ingresar un código: ");
                codProd = scanner.nextLine();
                intentosCod += 1;
                if (intentosCod == 3) {
                    System.out.println("Ha sobrepasado la cantidad maxima de intentos. ¡Adios!");
                    continuar = false;
                    break;
                }
            }
            if (isNumeric(codProd) == true && intentosCod != 3) {
                numCod = Integer.parseInt(codProd);
                producto.setCod(codProd);
                break;
            }
        }
        return continuar;
    }
    //Ingresar descripción del producto
    public static boolean ingresarDesc(){

        Scanner scanner = new Scanner(System.in);
        int intentosDesc = 0;

        System.out.println("Ingrese descripción: ");
        String desc = scanner.nextLine();
        while (true){
            if (desc.isEmpty() && intentosDesc != 3) {
                System.out.println("Debe ingresar una descripción: ");
                desc = scanner.nextLine();
                intentosDesc += 1;
                if (intentosDesc == 3) {
                    System.out.println("Ha sobrepasado la cantidad maxima de intentos. ¡Adios!");
                    return false;
                }
            } else {
                producto.setDesc(desc);
                break;
            }
        }
        return true;
    }
    //Ingresar precio del producto
    public static boolean ingresarPrecio(){

        Scanner scanner = new Scanner(System.in);
        int intentosPrecio = 0;
        int precioProd = 0;

        System.out.println("Ingrese precio: ");
        String precio = scanner.nextLine();
        while (true) {
            if (precio.isEmpty() && intentosPrecio != 3) {
                System.out.println("Debe ingresar un precio: ");
                precio = scanner.nextLine();
                intentosPrecio += 1;
                if (intentosPrecio == 3) {
                    System.out.println("Ha sobrepasado la cantidad máxima de intentos. ¡Adios!");
                    return false;
                }
            }
            if (isNumeric(precio) == true && intentosPrecio != 3) {
                precioProd = Integer.parseInt(precio);
                producto.setPrecio(precio);
                break;
            }
        }
        return true;
    }

    public static void ingresarCategoria(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Categorías");
        System.out.println("\t1. Bebidas");
        System.out.println("\t2. Congelados");
        System.out.println("\t3. Lácteos");
        System.out.println("\t4. Aseo");
        while (true){
            System.out.println("Asigne una categoría al producto: ");
            int opcion = scanner.nextInt();
            if (opcion == 1){
                categoria.setCodCat(1);
                categoria.setNombreCat("Bebidas");
            } else if (opcion == 2) {
                categoria.setCodCat(2);
                categoria.setNombreCat("Congelados");
            } else if (opcion == 3) {
                categoria.setCodCat(3);
                categoria.setNombreCat("Lácteos");
            } else if (opcion == 4) {
                categoria.setCodCat(4);
                categoria.setNombreCat("Aseo");
            } else {
                System.out.println("Ingreso inválido");
                continue;
            }
            producto.setCategoria(categoria);
            listaProductos.add(producto);
            producto.setListaProductos(producto.getListaProductos());
            producto = new Producto();
            System.out.println("El producto ha sido ingresado");
            mostrarMenu();
            break;
        }
    }
    //Ingresar cantidad de productos
    public static boolean ingresarStock(){

        Scanner scanner = new Scanner(System.in);
        int stockProd = 0;
        int intentosStock = 0;

        System.out.println("Ingrese stock: ");
        String stock = scanner.nextLine();
        while (true){
            if (stock.isEmpty() && intentosStock != 3) {
                System.out.println("Debe ingresar el stock: ");
                stock = scanner.nextLine();
                intentosStock += 1;
                if (intentosStock == 3) {
                    System.out.println("Ha sobrepasado la cantidad maxima de intentos. ¡Adios!");
                    return false;
                }
            }
            if (isNumeric(stock) == true) {
                stockProd = Integer.parseInt(stock);
                break;
            }
        }
        producto.setStock(stock);
        return true;
    }

    //Método para eliminar un producto de la listaProductos
    public static boolean eliminarProd(){

        Scanner scanner = new Scanner(System.in);
        boolean isDeleted = false;
        producto.imprimirListadoSimple(listaProductos);
        System.out.println("Ingrese el código del producto que desea eliminar: ");
        String codProd = scanner.nextLine();
        if (isNumeric(codProd)){
            for(int i = 0; i < listaProductos.size(); i++){
                if (listaProductos.get(i).getCod().equals(codProd)){
                    listaProductos.remove(i);
                    isDeleted = true;
                    System.out.println(listaProductos);
                }
            }
        } else {
            System.out.println("Debe ingresar numeros enteros");
        }

        return isDeleted;
    }

    //Método que valida ingreso numérico
    public static boolean isNumeric(String cod) {

        boolean res;

        try {
            Integer.parseInt(cod);
            res = true;
        } catch (NumberFormatException ex) {
            res = false;
        }
        return res;
    }
}
