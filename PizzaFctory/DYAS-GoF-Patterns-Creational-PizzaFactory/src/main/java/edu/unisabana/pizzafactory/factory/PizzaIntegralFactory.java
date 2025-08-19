package edu.unisabana.pizzafactory.factory;

import edu.unisabana.pizzafactory.model.interfaces.Amasador;
import edu.unisabana.pizzafactory.model.interfaces.Horneador;
import edu.unisabana.pizzafactory.model.interfaces.Moldeador;
import edu.unisabana.pizzafactory.model.integral.AmasadorPizzaIntegral;
import edu.unisabana.pizzafactory.model.integral.HorneadorPizzaIntegral;
import edu.unisabana.pizzafactory.model.integral.MoldeadorPizzaIntegral;

public class PizzaIntegralFactory implements PizzaFactory {
    public Amasador crearAmasador() {
        return new AmasadorPizzaIntegral();
    }
    
    public Moldeador crearMoldeador() {
        return new MoldeadorPizzaIntegral();
    }
    
    public Horneador crearHorneador() {
        return new HorneadorPizzaIntegral();
    }
}