package com.astrea.core.naves;

import com.astrea.core.base.NaveEspacial;
import com.astrea.core.exceptions.AstreaException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;

public class NaveCarga extends NaveEspacial {
    private double cargaActual;
    private double cargaMaxima;

    public NaveCarga(String matricula, String modelo, double combustibleInicial, double capacidadCombustible, double cargaMaxima) throws AstreaException {
        super(matricula, modelo, combustibleInicial, capacidadCombustible);
		if (cargaMaxima <=0){
            throw new AstreaException(
                "La carga maxima debe ser mayor a 0"
            );
        }
        if (cargaActual<0){
            throw new AstreaException(
                "La carga actual debe ser mayor a 0"
            );
        }
        if (cargaActual > cargaMaxima){
            throw new AstreaException(
                    "La carga no debe superar a la carga maxima"
            );
        }
        this.cargaActual = cargaActual;
        this.cargaMaxima = cargaMaxima;
        // TODO: Implementar validación y asignación
    }

    public void cargar(double cantidad) throws AstreaException {
        // TODO: Implementar lógica
    }
	public double getCargaActual (){
        return this.cargaActual =cargaActual;
    }
    public double getCargaMaxima (){
        return this.cargaMaxima;
    }

    @Override
    public void viajar(double distanciaAniosLuz) throws CombustibleInsuficienteException {
        // TODO: Implementar lógica
    }
}
