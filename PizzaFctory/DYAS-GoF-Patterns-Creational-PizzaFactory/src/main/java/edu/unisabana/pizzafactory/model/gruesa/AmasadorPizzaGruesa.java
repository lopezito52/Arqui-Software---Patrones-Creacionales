package edu.unisabana.pizzafactory.model.gruesa;

import edu.unisabana.pizzafactory.model.interfaces.Amasador;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AmasadorPizzaGruesa implements Amasador {
    public void amasar() {
        Logger.getLogger(AmasadorPizzaGruesa.class.getName())
                .log(Level.INFO, "[@@] Amasando la pizza gruesa con masa de pan.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
}