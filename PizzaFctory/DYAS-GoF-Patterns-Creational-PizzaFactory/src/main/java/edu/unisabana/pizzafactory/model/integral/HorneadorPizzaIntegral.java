package edu.unisabana.pizzafactory.model.integral;

import edu.unisabana.pizzafactory.model.interfaces.Horneador;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HorneadorPizzaIntegral implements Horneador {
    public void hornear() {
        
        Logger.getLogger(HorneadorPizzaIntegral.class.getName())
            .log(Level.INFO, "[~~] Horneando la pizza integral con masa saludable.");

        //CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
}