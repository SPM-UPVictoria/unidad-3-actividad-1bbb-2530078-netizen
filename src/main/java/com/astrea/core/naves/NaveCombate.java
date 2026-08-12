package com.astrea.core.naves;

import com.astrea.core.base.NaveEspacial;
import com.astrea.core.interfaces.Defendible;
import com.astrea.core.interfaces.Atacable;
import com.astrea.core.exceptions.AstreaException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;
import com.astrea.core.exceptions.EscudoCriticoException;

public class NaveCombate extends NaveEspacial implements Defendible, Atacable {
    private double integridadEscudo;
    private double potenciaArma;

        public NaveCombate(
        String matricula,
        String modelo,
        double combustibleInicial,
        double capacidadCombustible,
        double potenciaArma
    ) throws AstreaException {

        super(
            matricula,
            modelo,
            combustibleInicial,
            capacidadCombustible
        );

        if (potenciaArma <= 0) {
            throw new AstreaException(
                "La potencia del arma debe ser mayor a 0"
            );
        }

        this.integridadEscudo = 200.0;
        this.potenciaArma = potenciaArma;
    }

    public double getIntegridadEscudo() {
        return this.integridadEscudo;
    }

    public double getPotenciaArma() {
        return this.potenciaArma; 
    }

    @Override 
        public void viajar (double distanciaAñosluz)throws CombustibleInsuficienteException, AstreaException{
            if (distanciaAñosluz <=0){
                throw new AstreaException(
                    "la distancia debe ser mayor a 0"
                );
            }

            double consumoPorAñoLuz = 2.0;
            double combustibleNecesario = distanciaAñosluz * consumoPorAñoLuz;
            if (combustible < combustibleNecesario){
                throw new CombustibleInsuficienteException(
                    "Combustible insuficiente para el viaje"
                );
            }
            combustible -=  combustibleNecesario;
            
    }
        @Override
        public void recibirImpacto(double potenciaDano)
                throws EscudoCriticoException {

            if (integridadEscudo <= 0) {
                throw new EscudoCriticoException(
                    "El escudo está inhabilitado"
                );
            }

            if (potenciaDano < 0) {
                throw new EscudoCriticoException(
                    "La potencia del daño no puede ser negativa"
                );
            }

            integridadEscudo -= potenciaDano;

            if (integridadEscudo <= 0) {
                integridadEscudo = 0;

                throw new EscudoCriticoException(
                    "La integridad del escudo ha llegado a nivel crítico"
                );
            }
        }
        @Override
        public void atacar(Defendible objetivo) throws AstreaException {
        if (objetivo == null){
            throw new AstreaException(
                "El objetivo no puede ser nulo"
            );
        }
        if (potenciaArma <=0){
            throw new AstreaException(
                "El daño no puede ser negativo"
            );
        }
        double combustibleNecesario =15.00;
        if (combustible <= combustibleNecesario) {
            throw new CombustibleInsuficienteException(
                "No hay suficiente combustible para el ataque"
            );
            
        }

        combustible-=combustibleNecesario;
        objetivo.recibirImpacto(potenciaArma);

        }
}
