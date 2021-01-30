package com.devops.dxc.devops.model;

import java.util.Objects;

public class RespuestaServicioRetiroDTO {

    private String retiro;
    private String saldo;
    private String impuesto;
    private String sueldo;
    private String ahorro;

    public RespuestaServicioRetiroDTO() {
    }

    public RespuestaServicioRetiroDTO(String retiro, String saldo, String impuesto, String sueldo, String ahorro) {
        this.retiro = retiro;
        this.saldo = saldo;
        this.impuesto = impuesto;
        this.sueldo = sueldo;
        this.ahorro = ahorro;
    }

    public String getRetiro() {
        return retiro;
    }

    public void setRetiro(String retiro) {
        this.retiro = retiro;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public String getAhorro() {
        return ahorro;
    }

    public void setAhorro(String ahorro) {
        this.ahorro = ahorro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespuestaServicioRetiroDTO that = (RespuestaServicioRetiroDTO) o;
        return Objects.equals(retiro, that.retiro) && Objects.equals(saldo, that.saldo) && Objects.equals(impuesto, that.impuesto) && Objects.equals(sueldo, that.sueldo) && Objects.equals(ahorro, that.ahorro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(retiro, saldo, impuesto, sueldo, ahorro);
    }

    @Override
    public String toString() {
        return "RespuestaServicioRetiroDTO{" +
                "retiro='" + retiro + '\'' +
                ", saldo='" + saldo + '\'' +
                ", impuesto='" + impuesto + '\'' +
                ", sueldo='" + sueldo + '\'' +
                ", ahorro='" + ahorro + '\'' +
                '}';
    }
}
