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
    ) throws AstreaException {
        if (matricula == null || matricula.isBlank()) {
            throw new AstreaException(
                "La matricula no debe estar vacia "
            );
            
        }
        if (modelo == null || modelo.isBlank()){
            throw new AstreaException(
                "EL modelo no puede estar vacio"
            );

        }
        if (combustibleInicial <=0){
            throw new AstreaException(
                "El combustible inicial no puede ser negativo"
            );
       

        }
         if (combustibleInicial > capacidadCombustible){
            throw new AstreaException(
                "El combustible supera la capacidad"
            );
        }
        if (capacidadCombustible <= 0){
            throw new AstreaException(
                "La capacidad de combutible no puede ser negativa"
            );
        }
        this.matricula = matricula;
        this.capacidadCombustible = capacidadCombustible;
        this.modelo = modelo;
        this.combustible = combustibleInicial;

    }

    public void repostarCombustible(double cantidad) throws AstreaException {
        if (cantidad<= 0 ){
            throw new AstreaException(
                "La cantidad de combustible debe ser mayor a 0"
            );
        }
        if (combustible + cantidad  > capacidadCombustible){
            throw new AstreaException(
                "La cantidad excede el limite maximo"
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
