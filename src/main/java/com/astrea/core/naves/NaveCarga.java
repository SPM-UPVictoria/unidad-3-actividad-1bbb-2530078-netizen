package com.astrea.core.naves;

import com.astrea.core.base.NaveEspacial;
import com.astrea.core.exceptions.AstreaException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;

public class NaveCarga extends NaveEspacial {
    private double cargaActual;
    private double cargaMaxima;

    public NaveCarga(String matricula, String modelo, double combustibleInicial, double capacidadCombustible, double cargaMaxima) throws AstreaException {
        super(matricula, modelo, combustibleInicial, capacidadCombustible);
        // TODO: Implementar validación y asignación
    }

    public void cargar(double cantidad) throws AstreaException {
        // TODO: Implementar lógica
    }

    public double getCargaActual() {
        return 0.0; // TODO: Implementar
    }

    public double getCargaMaxima() {
        return 0.0; // TODO: Implementar
    }

    @Override
    public void viajar(double distanciaAniosLuz) throws CombustibleInsuficienteException {
        // TODO: Implementar lógica
    }
}
