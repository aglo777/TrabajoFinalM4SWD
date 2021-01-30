package com.devops.dxc.devops.model;

import java.util.Arrays;
import java.util.Objects;

/**
 * Clase que se parsea desde Json API mindicador para UF
 * @author angelocossio
 */
public class RespuestaUfDTO {

    private String version;
    private String autor;
    private String codigo;
    private String nombre;
    private String unidad_medida;
    private SerieDTO[] serie;

    public RespuestaUfDTO() {
    }

    public RespuestaUfDTO(String version, String autor, String codigo, String nombre, String unidad_medida, SerieDTO[] serie) {
        this.version = version;
        this.autor = autor;
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidad_medida = unidad_medida;
        this.serie = serie;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public SerieDTO[] getSerie() {
        return serie;
    }

    public void setSerie(SerieDTO[] serie) {
        this.serie = serie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespuestaUfDTO that = (RespuestaUfDTO) o;
        return Objects.equals(version, that.version) && Objects.equals(autor, that.autor) && Objects.equals(codigo, that.codigo) && Objects.equals(nombre, that.nombre) && Objects.equals(unidad_medida, that.unidad_medida) && Arrays.equals(serie, that.serie);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(version, autor, codigo, nombre, unidad_medida);
        result = 31 * result + Arrays.hashCode(serie);
        return result;
    }

    @Override
    public String toString() {
        return "RespuestaUfDTO{" +
                "version='" + version + '\'' +
                ", autor='" + autor + '\'' +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", unidad_medida='" + unidad_medida + '\'' +
                ", serie=" + Arrays.toString(serie) +
                '}';
    }
}
