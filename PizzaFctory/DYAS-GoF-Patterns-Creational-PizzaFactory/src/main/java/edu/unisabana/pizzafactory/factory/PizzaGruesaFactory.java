package edu.unisabana.pizzafactory.factory;

import edu.unisabana.pizzafactory.model.interfaces.Amasador;
import edu.unisabana.pizzafactory.model.interfaces.Horneador;
import edu.unisabana.pizzafactory.model.interfaces.Moldeador;
import edu.unisabana.pizzafactory.model.gruesa.AmasadorPizzaGruesa;
import edu.unisabana.pizzafactory.model.gruesa.HorneadorPizzaGruesa;
import edu.unisabana.pizzafactory.model.gruesa.MoldeadorPizzaGruesa;

public class PizzaGruesaFactory implements PizzaFactory {
    public Amasador crearAmasador() {
        return new AmasadorPizzaGruesa();
    }
    
    public Moldeador crearMoldeador() {
        return new MoldeadorPizzaGruesa();
    }
    
    public Horneador crearHorneador() {
        return new HorneadorPizzaGruesa();
    }
}