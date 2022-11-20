package SuperMarket;

import java.util.ArrayList;

public class Producto {

    String codProd;
    String desc;
    String precio;

    public Producto(){
    }

    public Producto(String codProd, String desc, String precio) {
        this.codProd = codProd;
        this.desc = desc;
        this.precio = precio;
    }

    public String getCodProd() {
        return codProd;
    }

    public void setCodProd(String codProd) {
        this.codProd = codProd;
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

    @Override
    public String toString() {
        return "Productos: " +
                "{" +
                "codProd='" + codProd + '\'' +
                ", desc='" + desc + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}
