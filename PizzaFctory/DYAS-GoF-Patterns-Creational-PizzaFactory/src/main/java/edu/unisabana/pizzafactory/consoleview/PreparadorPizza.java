package edu.unisabana.pizzafactory.consoleview;

import edu.unisabana.pizzafactory.factory.PizzaFactory;
import edu.unisabana.pizzafactory.factory.PizzaDelgadaFactory;
import edu.unisabana.pizzafactory.factory.PizzaGruesaFactory;
import edu.unisabana.pizzafactory.factory.PizzaIntegralFactory;
import edu.unisabana.pizzafactory.model.interfaces.Amasador;
import edu.unisabana.pizzafactory.model.interfaces.Horneador;
import edu.unisabana.pizzafactory.model.interfaces.Moldeador;
import edu.unisabana.pizzafactory.model.Ingrediente;
import edu.unisabana.pizzafactory.model.Tamano;
import edu.unisabana.pizzafactory.model.ExcepcionParametrosInvalidos;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesarvefe
 */
public class PreparadorPizza {
    
    private static final Logger logger = Logger.getLogger(PreparadorPizza.class.getName());

    public static void main(String args[]){
        try {
            System.out.println("=== INICIANDO SISTEMA DE PREPARACIÓN DE PIZZAS ===");
            
            Ingrediente[] ingredientes = new Ingrediente[]{
                new Ingrediente("queso",1),
                new Ingrediente("jamon",2)
            };            
            
            PreparadorPizza pp = new PreparadorPizza();            
            
            // Ejemplo con pizza delgada
            System.out.println("\nPREPARANDO PIZZA DELGADA MEDIANA");
            pp.prepararPizza(ingredientes, Tamano.MEDIANO, new PizzaDelgadaFactory());
            
            // Ejemplo con pizza gruesa
            System.out.println("\nPREPARANDO PIZZA GRUESA PEQUEÑA");
            pp.prepararPizza(ingredientes, Tamano.PEQUENO, new PizzaGruesaFactory());
            
            // Ejemplo con pizza integral
            System.out.println("\nPREPARANDO PIZZA INTEGRAL MEDIANA");
            pp.prepararPizza(ingredientes, Tamano.MEDIANO, new PizzaIntegralFactory());
            
            System.out.println("\n=== TODAS LAS PIZZAS PREPARADAS CON ÉXITO ===");
            
        } catch (ExcepcionParametrosInvalidos ex) {
            System.err.println("ERROR: " + ex.getMessage());
            logger.log(Level.SEVERE, "Problema en la preparación de la Pizza", ex);
        }                
    }
    
    public void prepararPizza(Ingrediente[] ingredientes, Tamano tam, PizzaFactory factory)
            throws ExcepcionParametrosInvalidos {
        System.out.println("\nIniciando preparación...");
        
        Amasador am = factory.crearAmasador();
        Horneador hpd = factory.crearHorneador();
        Moldeador mp = factory.crearMoldeador();
        
        System.out.println("1. Amasando la pizza...");
        am.amasar();
        
        System.out.println("2. Moldeando la pizza...");
        if (tam == Tamano.PEQUENO) {
            mp.moldearPizzaPequena();
            System.out.println("   - Tamaño seleccionado: Pequeño");
        } else if (tam == Tamano.MEDIANO) {
            mp.moldearPizzaMediana();
            System.out.println("   - Tamaño seleccionado: Mediano");
        } else {
            throw new ExcepcionParametrosInvalidos("Tamaño de pizza inválido:" + tam);
        }
        
        System.out.println("3. Aplicando ingredientes...");
        aplicarIngredientes(ingredientes);
        
        System.out.println("4. Horneando la pizza...");
        hpd.hornear();
        
        System.out.println("¡Pizza lista!\n");
    }

    private void aplicarIngredientes(Ingrediente[] ingredientes) {
        System.out.println("   - Ingredientes aplicados:");
        for (Ingrediente ingrediente : ingredientes) {
            System.out.println("     * " + ingrediente.getNombre() + " (cantidad: " + ingrediente.getCantidad() + ")");
        }
    }
}