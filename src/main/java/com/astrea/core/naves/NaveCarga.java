package com.astrea.core.naves;

import com.astrea.core.base.NaveEspacial;
import com.astrea.core.exceptions.AstreaException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;

public class NaveCarga extends NaveEspacial {

    private double cargaActual;
    private double cargaMaxima;

    public NaveCarga(
        String matricula,
        String modelo,
        double combustibleInicial,
        double capacidadCombustible,
        double cargaMaxima
    ) throws AstreaException {

        super(
            matricula,
            modelo,
            combustibleInicial,
            capacidadCombustible
        );

        if (cargaMaxima <= 0) {
            throw new AstreaException(
                "La carga maxima debe ser mayor a 0"
            );
        }

        this.cargaActual = 0;
        this.cargaMaxima = cargaMaxima;
    }

    public void cargar(double cantidad) throws AstreaException {

        if (cantidad <= 0) {
            throw new AstreaException(
                "La carga no debe ser menor o igual a 0"
            );
        }

        if (cargaActual + cantidad > cargaMaxima) {
            throw new AstreaException(
                "La carga supera el limite"
            );
        }

        cargaActual += cantidad;
    }

    public double getCargaActual() {
        return this.cargaActual;
    }

    public double getCargaMaxima() {
        return this.cargaMaxima;
    }

    @Override
    public void viajar(double distanciaAniosLuz)
            throws CombustibleInsuficienteException, AstreaException {

        if (distanciaAniosLuz <= 0) {
            throw new AstreaException(
                "La distancia debe ser mayor a 0"
            );
        }

        double consumoPorAñoLuz;

        if (cargaActual <= cargaMaxima * 0.50) {
            consumoPorAñoLuz = 1.5;
        } else {
            consumoPorAñoLuz = 3.0;
        }

        double combustibleNecesario =
            distanciaAniosLuz * consumoPorAñoLuz;

        if (combustible < combustibleNecesario) {
            throw new CombustibleInsuficienteException(
                "Combustible insuficiente para el viaje"
            );
        }

        combustible -= combustibleNecesario;
    }
}