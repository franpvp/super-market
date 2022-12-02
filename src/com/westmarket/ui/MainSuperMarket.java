package com.westmarket.ui;

import com.westmarket.busines.Categoria;
import com.westmarket.busines.Producto;

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
                System.out.println("\nHa salido del sistema");
                break;
            }
        }
    }

    public static boolean mostrarMenu(){

        Scanner scanner = new Scanner(System.in);
        boolean val = false;
        while (true){
            System.out.println("--- West Market ---");
            System.out.println("1. Registrar producto");
            System.out.println("2. Imprimir productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opción: ");
            int op = scanner.nextInt();
            if (op == 1){
                registrarProd();
                break;
            } else if (op == 2) {
                producto.imprimirListado(listaProductos);
            } else if (op == 3) {
                if (eliminarProd()){
                    System.out.println("El producto ha sido eliminado");
                } else {
                    System.out.println("El producto no existe");
                }
            } else if (op == 4) {
                System.out.println("Ha salido del sistema");
                break;
            } else {
                System.out.println("Ingreso inválido\n");
            }
        }
        return val;
    }
    //Métodos
    //Ingresar código del producto
    public static void registrarProd(){

        Scanner scanner = new Scanner(System.in);
        //Ingresar código
        boolean valCod = ingresarCod();
        //Ingresar descripción
        boolean valDesc = ingresarDesc();
        //Ingresar precio
        boolean valPrecio = ingresarPrecio();
        //Ingresar stock
        boolean valStock = ingresarStock();
        //Ingresar categoría del producto
        boolean valCat = ingresarCategoria();
        while (true){
            if (valCod && valDesc && valPrecio && valStock && valCat){
                System.out.println("¿Volver al menu? (si/no)");
                String opcion = scanner.nextLine();
                if (opcion.equals("si") || opcion.equals("SI")){
                    mostrarMenu();
                    break;
                } else if (opcion.equals("no") || opcion.equals("NO")){
                    break;
                } else {
                    System.out.println("Ingreso inválido");
                    mostrarMenu();
                }
            }
        }



    }
    //Ingresar código del producto
    public static boolean ingresarCod(){

        Scanner scanner = new Scanner(System.in);
        boolean val = true;
        int intentosCod = 0;

        System.out.println("Ingrese código: ");
        String codProd = scanner.nextLine();
        while (true){
            if (codProd.isEmpty() && intentosCod != 2) {
                System.out.println("Debe ingresar un código: ");
                codProd = scanner.nextLine();
                intentosCod += 1;
                if (intentosCod == 2) {
                    System.out.println("\nHa sobrepasado la cantidad maxima de intentos. ¡Adios!");
                    val = false;
                    break;
                }
            }
            if (isNumeric(codProd) && intentosCod != 2) {
                producto.setCod(codProd);
                break;
            }
        }
        return val;
    }
    //Ingresar descripción del producto
    public static boolean ingresarDesc(){

        Scanner scanner = new Scanner(System.in);
        boolean val = true;
        int intentosDesc = 0;

        System.out.println("Ingrese descripción: ");
        String desc = scanner.nextLine();
        while (true){
            if (desc.isEmpty() && intentosDesc != 2) {
                System.out.println("Debe ingresar una descripción: ");
                desc = scanner.nextLine();
                intentosDesc += 1;
                if (intentosDesc == 2) {
                    System.out.println("Ha sobrepasado la cantidad maxima de intentos. ¡Adios!");
                    val = false;
                    break;
                }
            } else {
                producto.setDesc(desc);
                break;
            }
        }
        return val;
    }
    //Ingresar precio del producto
    public static boolean ingresarPrecio(){

        Scanner scanner = new Scanner(System.in);
        boolean val = true;
        int intentosPrecio = 0;

        System.out.println("Ingrese precio: ");
        String precio = scanner.nextLine();
        while (true) {
            if (precio.isEmpty() && intentosPrecio != 2) {
                System.out.println("Debe ingresar un precio: ");
                precio = scanner.nextLine();
                intentosPrecio += 1;
                if (intentosPrecio == 2) {
                    System.out.println("\nHa sobrepasado la cantidad máxima de intentos. ¡Adios!");
                    val = false;
                    break;
                }
            }
            if (isNumeric(precio) == true && intentosPrecio != 2) {
                producto.setPrecio(precio);
                break;
            }
        }
        return val;
    }
    //Método para ingresar categoria
    public static boolean ingresarCategoria(){

        Scanner scanner = new Scanner(System.in);
        int intentosCat = 0;
        boolean val = true;
        System.out.println("Categorías");
        System.out.println("\t1. Bebidas");
        System.out.println("\t2. Congelados");
        System.out.println("\t3. Lácteos");
        System.out.println("\t4. Aseo");

        while (true){
            System.out.println("Asigne una categoría al producto: ");
            String opcion = scanner.nextLine();
            if (opcion.equals("1")){
                categoria.setCodCat(1);
                categoria.setNombreCat("Bebidas");
            } else if (opcion.equals("2")) {
                categoria.setCodCat(2);
                categoria.setNombreCat("Congelados");
            } else if (opcion.equals("3")) {
                categoria.setCodCat(3);
                categoria.setNombreCat("Lácteos");
            } else if (opcion.equals("4")) {
                categoria.setCodCat(4);
                categoria.setNombreCat("Aseo");
            } else {
                if (intentosCat != 2){
                    System.out.println("Debe ingresar una categoría: ");
                    opcion = scanner.nextLine();
                    intentosCat += 1;
                    if (intentosCat == 2) {
                        System.out.println("\nHa sobrepasado la cantidad máxima de intentos. ¡Adios!");
                        val = false;
                        break;
                    }
                }
                continue;
            }
            if (opcion.isEmpty() && intentosCat != 2) {
                System.out.println("Debe ingresar una categoría: ");
                opcion = scanner.nextLine();
                intentosCat += 1;
                if (intentosCat == 2) {
                    System.out.println("\nHa sobrepasado la cantidad máxima de intentos. ¡Adios!");
                    val = false;
                    break;
                }
            }
            if (isNumeric(opcion) && intentosCat != 2) {
                break;
            }
            producto.setCategoria(categoria);
            listaProductos.add(producto);
            producto.setListaProductos(producto.getListaProductos());
            //Vaciando objetos para crear nuevos
            categoria = new Categoria();
            producto = new Producto();
            System.out.println("\nEl producto ha sido ingresado");
            System.out.println(listaProductos);
            mostrarMenu();
            break;
        }
        return val;

    }
    //Método para ingresar stock del producto
    public static boolean ingresarStock(){

        Scanner scanner = new Scanner(System.in);
        boolean valido = true;
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
                    valido = false;
                }
            }
            if (isNumeric(stock) == true) {
                stockProd = Integer.parseInt(stock);
                break;
            }
        }
        producto.setStock(stock);
        return valido;
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
