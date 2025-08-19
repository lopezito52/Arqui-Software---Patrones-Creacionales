# Arqui-Software---Patrones-Creacionales
# Sistema Automatizado de Preparación de Pizzas 

Sistema que simula el control de un microcontrolador para la fabricación automática de pizzas, implementando el patrón Abstract Factory para manejar diferentes tipos de masa (delgada, gruesa e integral).

##  Características principales

- **Patrón Abstract Factory**: Implementación limpia para manejar diferentes variantes de pizza
- **Proceso completo**: Amasado, moldeado, aplicación de ingredientes y horneado
- **Tipos de pizza**:
  - Delgada (masa convencional)
  - Gruesa (masa de pan)
  - Integral (masa saludable)
- **Tamaños disponibles**: Pequeño y mediano
- **Logging detallado**: Mensajes claros del proceso de preparación
##  Ejecución del Proyecto

**Compila y ejecuta el proyecto con:**

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="edu.unisabana.pizzafactory.consoleview.PreparadorPizza"
```

## 📤 Salida Esperada

```text
=== INICIANDO SISTEMA DE PREPARACIÓN DE PIZZAS ===

>> PREPARANDO PIZZA DELGADA MEDIANA <<
--- INICIANDO PREPARACIÓN ---
Paso 1: Amasando...
   Amasando pizza delgada con masa convencional
Paso 2: Moldeando...
   Tamaño: Mediano
Paso 3: Aplicando ingredientes...
   Ingredientes:
     - queso (cantidad: 1)
     - jamon (cantidad: 2)
Paso 4: Horneando...
--- PIZZA LISTA ---

[... más pizzas ...]

=== TODAS LAS PIZZAS PREPARADAS CON ÉXITO ===
```



# SpaceWar 2D

Un juego 2D de naves espaciales desarrollado en Java, implementando patrones de diseño para una arquitectura limpia y extensible.

## Características Principales

- ✅ Dos estilos visuales intercambiables: Sprites y Gráficos Vectoriales
- ✅ Implementa el patrón Abstract Factory para la creación de objetos
- ✅ Principio de Inversión de Dependencias (DIP)
- ✅ Fácil adición de nuevos estilos visuales
- ✅ Sistema de balas y colisiones

## Patrones de Diseño Implementados

| Patrón          | Aplicación                          |
|-----------------|-------------------------------------|
| Abstract Factory| Creación de familias de objetos (Player, Bullet, Background) |
| DIP             | Depende de abstracciones, no de implementaciones concretas |


2. **Compilar y ejecutar**:
   ```bash
   mvn clean compile
   mvn exec:java -Dexec.mainClass="com.balitechy.spacewar.main.Game"
   ```

3. **Cambiar estilo visual**: Edita `src/main/resources/config.properties`:
   ```properties
   game.style=vector  # Opciones: "sprite" o "vector"
   ```

## Cómo Agregar un Nuevo Estilo Visual

1. Crea nuevas clases en `models/nuevo-estilo/` que implementen:
   - `IPlayer`
   - `IBullet`
   - `IBackground`

2. Crea una nueva fábrica en `factory/` que extienda `AGameFactory`

3. Actualiza el archivo de configuración para soportar el nuevo estilo





