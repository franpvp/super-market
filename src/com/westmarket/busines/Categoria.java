package com.westmarket.busines;

public class Categoria {

    int codCat;
    String nomCat;

    public Categoria() {
    }

    public Categoria(int codCat, String nomCateg) {
        this.codCat = codCat;
        this.nomCat = nomCateg;
    }

    public int getCodCat() {
        return codCat;
    }

    public void setCodCat(int codCat) {
        this.codCat = codCat;
    }

    public String getNombreCat() {
        return nomCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nomCat = nombreCat;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "codCat=" + codCat +
                ", nombreCat='" + nomCat + '\'' +
                '}';
    }
}
