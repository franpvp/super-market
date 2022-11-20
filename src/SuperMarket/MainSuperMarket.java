package SuperMarket;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSuperMarket {

    public static void main(String[] args) {
        Producto producto = new Producto();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> listaProducts = new ArrayList<>();
        int numCod = 0;
        int precioProd = 0;
        int cantProd = 0;
        int intentosCod = 0;
        int intentosDesc = 0;
        int intentosPrecio = 0;
        int intentosCant = 0;

        //Ingresar Código
        boolean continuar = true;
        System.out.println("Ingrese un codigo: ");
        String codProd = scanner.nextLine();
        producto.setCodProd(codProd);
        while (true){
            if (codProd.isEmpty()) {
                System.out.println("Debe ingresar un codigo: ");
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
        //Ingreso Descripción
        while (continuar){
            System.out.println("Ingrese descripcion: ");
            String desc = scanner.nextLine();
            producto.setDesc(desc);
            while (true){
                if (desc.isEmpty()) {
                    System.out.println("Debe ingresar una descripcion: ");
                    desc = scanner.nextLine();
                    intentosDesc += 1;
                    if (intentosDesc == 2) {
                        System.out.println("Ha sobrepasado la cantidad maxima de intentos. ¡Adios!");
                        continuar = false;
                        break;
                    }
                }else {
                    continuar = true;
                    break;
                }
            }break;
        }
        //Ingrese Precio
        while (continuar) {
            System.out.println("Ingrese precio: ");
            String precio = scanner.nextLine();
            producto.setPrecio(precio);
            while (true) {
                if (precio.isEmpty()) {
                    System.out.println("Debe ingresar un precio: ");
                    precio = scanner.nextLine();
                    intentosPrecio += 1;
                    if (intentosPrecio == 2) {
                        System.out.println("Ha sobrepasado la cantidad máxima de intentos. ¡Adios!");
                        continuar = false;
                        break;
                    }
                }
                if (isNumeric(precio) == true) {
                    precioProd = Integer.parseInt(precio);
                    break;
                }
            }break;
        }
        //Ingrese cantidad
        while (continuar){
            System.out.println("Ingrese cantidad: ");
            String cant = scanner.nextLine();
            while (true){
                if (cant.isEmpty()) {
                    System.out.println("Debe ingresar una cantidad: ");
                    cant = scanner.nextLine();
                    intentosCant += 1;
                    if (intentosCant == 2) {
                        System.out.println("Ha sobrepasado la cantidad maxima de intentos. ¡Adios!");
                        continuar = false;
                        break;
                    }
                }
                if (isNumeric(cant) == true) {
                    cantProd = Integer.parseInt(cant);
                    break;
                }
            }break;
        }
        while (continuar){
            System.out.println("--- Datos del producto ---");
            System.out.println("Codigo: " + numCod);
            System.out.println("Descripcion: " + producto.getDesc());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Cantidad: " + cantProd);
            System.out.println("Total a pagar: " + cantProd*precioProd);
            break;
        }
        while (true){
            boolean addProd = addProducto();
            if (addProd){
                System.out.println("Agregando nuevo producto");
                listaProducts.add(producto);
                System.out.println(listaProducts);
                break;
            } else if (!addProd){
                System.out.println("Finalizando el programa");
                break;
            }
        }

    }

    //Ingresar codigo del producto
    public static String ingresarCodigo(){

        Scanner scanner = new Scanner(System.in);
        Producto producto = new Producto();
        int intentosCod = 0;
        int numCod = 0;

        System.out.println("Ingrese un codigo: ");
        String codProd = scanner.nextLine();
        producto.setCodProd(codProd);
        while (true){
            if (codProd.isEmpty()) {
                System.out.println("Debe ingresar un codigo: ");
                codProd = scanner.nextLine();
                intentosCod += 1;
                if (intentosCod == 2) {
                    System.out.println("Ha sobrepasado la cantidad maxima de intentos. ¡Adios!");
                    break;
                }
            }
            if (isNumeric(codProd) == true) {
                numCod = Integer.parseInt(codProd);
                break;
            }
        }
        return codProd;
    }

    //Ingresar descripcion del producto
    public static String ingresarDesc(){

        Scanner scanner = new Scanner(System.in);
        Producto producto = new Producto();
        int intentosDesc = 0;

        while (continuar){
            System.out.println("Ingrese descripcion: ");
            String desc = scanner.nextLine();
            producto.setDesc(desc);
            while (true){
                if (desc.isEmpty()) {
                    System.out.println("Debe ingresar una descripcion: ");
                    desc = scanner.nextLine();
                    intentosDesc += 1;
                    if (intentosDesc == 2) {
                        System.out.println("Ha sobrepasado la cantidad maxima de intentos. ¡Adios!");
                        continuar = false;
                        break;
                    }
                }else {
                    continuar = true;
                    break;
                }
            }break;
        }

    }


    //Ingresar precio del producto
    public static boolean ingresarPrecio(){

        Scanner scanner = new Scanner(System.in);
        Producto producto = new Producto();
        int intentosPrecio = 0;
        int precioProd = 0;

        while (continuar) {
            System.out.println("Ingrese precio: ");
            String precio = scanner.nextLine();
            producto.setPrecio(precio);
            while (true) {
                if (precio.isEmpty()) {
                    System.out.println("Debe ingresar un precio: ");
                    precio = scanner.nextLine();
                    intentosPrecio += 1;
                    if (intentosPrecio == 2) {
                        System.out.println("Ha sobrepasado la cantidad máxima de intentos. ¡Adios!");
                        continuar = false;
                        break;
                    }
                }
                if (isNumeric(precio) == true) {
                    precioProd = Integer.parseInt(precio);
                    break;
                }
            }break;
        }

    }

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
               break;
            }
            else if (consult.isEmpty()){
                System.out.println("Debe ingresar lo solicitado");
                continue;
            }
        }return res;

    }
}
