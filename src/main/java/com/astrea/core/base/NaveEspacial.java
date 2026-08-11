package com.astrea.core.base;

import com.astrea.core.exceptions.AstreaException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;

public abstract class NaveEspacial {
    protected String matricula;
    protected String modelo;
    protected double combustible;
    protected double capacidadCombustible;

    public NaveEspacial(
	String matricula, 
	String modelo, 
	double combustibleInicial, 
	double capacidadCombustible
	) 
	throws AstreaException {
		if (matricula == null || matricula.isBlank()) {
            throw new AstreaException(
                    "La matricula no debe estar vacia");
        }

        if (modelo == null || modelo.isBlank()) {
            throw new AstreaException(
                    "El modelo no debe ser nulo o vacio");
        }

        if (combustibleInicial <= 0) {
            throw new AstreaException(
                    "El combustible inicial debe ser mayor a 0");
        }

        if (capacidadCombustible <= 0) {
            throw new AstreaException(
                    "La capacidad de combustible debe ser mayor a 0");
        }

        if (combustibleInicial > capacidadCombustible) {
            throw new AstreaException(
                    "El combustible inicial no debe ser mayor a la capacidad");
        }
		this.matricula = matricula;
        this.modelo = modelo;
        this.combustible = combustibleInicial;
        this.capacidadCombustible = capacidadCombustible;


    }

    public void repostarCombustible(double cantidad)throws AstreaException{
        if (cantidad <=0){
            throw new AstreaException(
                "La cantidad a repostar debe ser mayor a 0"
            );
        }
        if (cantidad + capacidadCombustible  > capacidadCombustible){
            throw new AstreaException(
                "La cantidad supera a la capacidad de la nave"
            );
        }
    combustible += cantidad;
    }


    
    public String getMatricula() {
        return this.matricula;
    }

    public String getModelo() {
        return this.modelo;
    }

    public double getCombustible() {
        return this.combustible;
    }

    public double getCapacidadCombustible() {
        return this.capacidadCombustible;
    }

 


    public abstract void viajar(double distanciaAniosLuz) throws CombustibleInsuficienteException, AstreaException;
}
