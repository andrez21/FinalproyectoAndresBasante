package com.andresbasante.finalproyectoandresbasante.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Acer on 05/06/2017.
 */


public class Cine {

    @SerializedName("ciudad")
    @Expose
    private String ciudad;

    @SerializedName("departamento")
    @Expose
    private String departamento;

    @SerializedName("direccion_de_la_sala")
    @Expose
    private String direccionDeLaSala;

    @SerializedName("exhibidor")
    @Expose
    private String exhibidor;

    @SerializedName("nombre_del_complejo")
    @Expose
    private String nombreDelComplejo;

    @SerializedName("total_salas")
    @Expose
    private String totalSalas;

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDireccionDeLaSala() {
        return direccionDeLaSala;
    }

    public void setDireccionDeLaSala(String direccionDeLaSala) {
        this.direccionDeLaSala = direccionDeLaSala;
    }

    public String getExhibidor() {
        return exhibidor;
    }

    public void setExhibidor(String exhibidor) {
        this.exhibidor = exhibidor;
    }

    public String getNombreDelComplejo() {
        return nombreDelComplejo;
    }

    public void setNombreDelComplejo(String nombreDelComplejo) {
        this.nombreDelComplejo = nombreDelComplejo;
    }

    public String getTotalSalas() {
        return totalSalas;
    }

    public void setTotalSalas(String totalSalas) {
        this.totalSalas = totalSalas;
    }

}