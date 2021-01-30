package com.devops.dxc.devops.model;

import java.util.Objects;

/**
 * @author angelocossio
 */
public class SerieDTO {
    private String fecha;
    private double valor;

    public SerieDTO() {
    }

    public SerieDTO(String fecha, double valor) {
        this.fecha = fecha;
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerieDTO serieDTO = (SerieDTO) o;
        return Double.compare(serieDTO.valor, valor) == 0 && Objects.equals(fecha, serieDTO.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, valor);
    }

    @Override
    public String toString() {
        return "SerieDTO{" +
                "fecha='" + fecha + '\'' +
                ", valor=" + valor +
                '}';
    }
}
