package com.devops.dxc.devops.model;

import java.io.Serializable;

public class Dxc implements Serializable{

	/**
	 * Clase que toma los valores de usuario para generar cálculos
	 */
	private static final long serialVersionUID = -2988002029080131424L;

	private double retiro;
	private double saldo;
	private double impuesto;
	private double sueldo;
	private double ahorro;

	public Dxc(double ahorro, double sueldo){
		this.ahorro = ahorro;
		this.sueldo = sueldo;
	}

	public Dxc() {
	}

	public void calculaRetiro() {
		Util.calcula10(this);
	}

	public void setRetiro(double retiro) {
		this.retiro = retiro;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public double getAhorro() {
		return ahorro;
	}

	public void setAhorro(double ahorro) {
		this.ahorro = ahorro;
	}
}
