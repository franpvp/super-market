package SuperMarket;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSuperMarket {
    public static ArrayList<Producto> listaProductos = new ArrayList<>();
    public static Producto producto = new Producto();

    public static void main(String[] args) {

        //Ingresar datos del producto
        ingresarProd();
    }

    //Métodos
    //Ingresar código del producto
    public static boolean ingresarProd(){

        Scanner scanner = new Scanner(System.in);

        //Ingresar código
        boolean continuar = ingresarCod();

        //Ingrese descripción
        while (continuar){
            ingresarDesc();
            break;
        }
        //Ingrese Precio
        while (continuar) {
            ingresarPrecio();
            break;
        }
        //Ingrese cantidad
        while (continuar){
            ingresarCant();
            break;
        }
        //Agregar otro producto
        while (continuar){
            if (addProducto() == true){
                System.out.println("Agregando nuevo producto");
                ingresarProd();
                System.out.println("Mostrando datos del producto agregado");
                listaProductos.add(producto);
                System.out.println(listaProductos);
                addProducto();
            } else {
                System.out.println("Finalizando el programa");
                System.out.println("--- Datos del producto ---");
                System.out.println("Codigo: " + producto.getCodProd());
                System.out.println("Descripcion: " + producto.getDesc());
                System.out.println("Precio: " + producto.getPrecio());
                //System.out.println("Cantidad: " + );
                //System.out.println("Total a pagar: " + cantProd*precioProd);
            }
        }
        return continuar;
    }


    //Ingresar codigo del producto
    public static boolean ingresarCod(){

        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        int intentosCod = 0;
        int numCod = 0;

        System.out.println("Ingrese un código: ");
        String codProd = scanner.nextLine();
        while (true){
            if (codProd.isEmpty() && intentosCod != 2) {
                System.out.println("Debe ingresar un código: ");
                codProd = scanner.nextLine();
                intentosCod += 1;
                if (intentosCod == 2) {
                    System.out.println("Ha sobrepasado la cantidad maxima de intentos. ¡Adios!");
                    continuar = false;
                    break;
                }
            }
            if (isNumeric(codProd) == true) {
                numCod = Integer.parseInt(codProd);
                break;
            }
        }
        producto.setCodProd(codProd);
        return continuar;
    }

    //Ingresar descripción del producto
    public static boolean ingresarDesc(){

        Scanner scanner = new Scanner(System.in);
        int intentosDesc = 0;

        System.out.println("Ingrese descripción: ");
        String desc = scanner.nextLine();
        while (true){
            if (desc.isEmpty()) {
                System.out.println("Debe ingresar una descripción: ");
                desc = scanner.nextLine();
                intentosDesc += 1;
                if (intentosDesc == 2) {
                    System.out.println("Ha sobrepasado la cantidad maxima de intentos. ¡Adios!");
                    return false;
                }
            }break;
        }
        producto.setDesc(desc);
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
            if (precio.isEmpty()) {
                System.out.println("Debe ingresar un precio: ");
                precio = scanner.nextLine();
                intentosPrecio += 1;
                if (intentosPrecio == 2) {
                    System.out.println("Ha sobrepasado la cantidad máxima de intentos. ¡Adios!");
                    return false;
                }
            }
            if (isNumeric(precio) == true) {
                precioProd = Integer.parseInt(precio);
                break;
            }
        }
        producto.setPrecio(precio);
        return true;
    }
    //Ingresar cantidad de productos
    public static boolean ingresarCant(){

        Scanner scanner = new Scanner(System.in);
        int cantProd = 0;
        int intentosCant = 0;

        System.out.println("Ingrese cantidad: ");
        String cant = scanner.nextLine();
        while (true){
            if (cant.isEmpty()) {
                System.out.println("Debe ingresar una cantidad: ");
                cant = scanner.nextLine();
                intentosCant += 1;
                if (intentosCant == 2) {
                    System.out.println("Ha sobrepasado la cantidad maxima de intentos. ¡Adios!");
                    return false;
                }
            }
            if (isNumeric(cant) == true) {
                cantProd = Integer.parseInt(cant);
                break;
            }
        }
        return true;
    }

    public static boolean addProducto(){

        Scanner scanner = new Scanner(System.in);
        boolean res;

        while (true){
            System.out.println("¿Desea agregar otro producto?");
            String consult = scanner.nextLine();
            if (consult.equals("si") || consult.equals("SI")){
                res = true;
                break;
            } else if (consult.equals("no") || consult.equals("NO")){
               res = false;
               //te amoo cafesito
               break;
            }
            else if (consult.isEmpty()){
                System.out.println("Debe ingresar lo solicitado");
                continue;
            }
        }return res;

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
