package edu.unisabana.pizzafactory.factory;

import edu.unisabana.pizzafactory.model.interfaces.Amasador;
import edu.unisabana.pizzafactory.model.interfaces.Horneador;
import edu.unisabana.pizzafactory.model.interfaces.Moldeador;
import edu.unisabana.pizzafactory.model.delgada.AmasadorPizzaDelgada;
import edu.unisabana.pizzafactory.model.delgada.HorneadorPizzaDelgada;
import edu.unisabana.pizzafactory.model.delgada.MoldeadorPizzaDelgada;

public class PizzaDelgadaFactory implements PizzaFactory {
    public Amasador crearAmasador() {
        return new AmasadorPizzaDelgada();
    }
    
    public Moldeador crearMoldeador() {
        return new MoldeadorPizzaDelgada();
    }
    
    public Horneador crearHorneador() {
        return new HorneadorPizzaDelgada();
    }
}