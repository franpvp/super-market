package SuperMarket;

import jdk.nashorn.internal.objects.Global;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSuperMarket {

    //public static Producto producto;
    public static ArrayList<Producto> listaProductos = new ArrayList<>();


    public static void main(String[] args) {

        Producto producto = new Producto();
        //ArrayList<Producto> listaProducts = new ArrayList<>();
        int numCod = 0;
        int precioProd = 0;
        int cantProd = 0;

        //Ingresar Código
        boolean continuar = ingresarProd();
        //Ingreso Descripción
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
                listaProductos.add(producto);
                System.out.println(listaProductos);
                break;
            } else if (!addProd){
                System.out.println("Finalizando el programa");
                break;
            }
        }

    }

    //Métodos
    //Ingresar código del producto
    public static boolean ingresarProd(){

        Scanner scanner = new Scanner(System.in);
        Producto producto = new Producto();

        boolean continuar = true;
        int intentosCod = 0;
        int numCod = 0;

        System.out.println("Ingrese un codigo: ");
        String codProd = scanner.nextLine();
        producto.setCodProd(codProd);
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
        return continuar;
    }

    //Ingresar descripción del producto
    public static boolean ingresarDesc(){

        Scanner scanner = new Scanner(System.in);
        int intentosDesc = 0;

        while (res){
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
                        res = false;
                        break;
                    }
                }else {
                    res = true;
                    break;
                }
            }break;
        }
        return res;
    }

    //Ingresar precio del producto
    public static boolean ingresarPrecio(){

        Scanner scanner = new Scanner(System.in);
        Producto producto = new Producto();
        int intentosPrecio = 0;
        int precioProd = 0;
        boolean res = ingresarDesc();

        while (res) {
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
                        res = false;
                        break;
                    }
                }
                if (isNumeric(precio) == true) {
                    precioProd = Integer.parseInt(precio);
                    break;
                }
            }break;
        }
        return res;
    }

    public static boolean ingresarCant(){

        Scanner scanner = new Scanner(System.in);
        int cantProd = 0;
        int intentosCant = 0;
        boolean res = ingresarPrecio();

        System.out.println("Ingrese cantidad: ");
        String cant = scanner.nextLine();
        while (true){
            if (cant.isEmpty()) {
                System.out.println("Debe ingresar una cantidad: ");
                cant = scanner.nextLine();
                intentosCant += 1;
                if (intentosCant == 2) {
                    System.out.println("Ha sobrepasado la cantidad maxima de intentos. ¡Adios!");
                    res = false;
                    break;
                }
            }
            if (isNumeric(cant) == true) {
                cantProd = Integer.parseInt(cant);
                break;
            }
        }
        return res;
    }
    //Método que valida ingreso numérico


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
