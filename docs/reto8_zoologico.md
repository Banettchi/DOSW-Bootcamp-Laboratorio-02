# RETO 8: El Zoológico de los UML

## Objetivo
Diseñar un diagrama UML de clases para un sistema de gestión de zoológico aplicando SOLID y patrones de diseño.

## Requisitos del Sistema

### Animales
- **Tipos**: Mamíferos, Reptiles, Aves
- **Atributos**:
  - Nombre
  - Edad
  - Sonido característico
  - Dieta
  - Alimento preferido
  - Peso
  - Altura
  - Estado de salud (sano, enfermo, cuarentena)
  - Hábitat
  - Atributos dinámicos: color de pelaje, origen, rareza, historial médico

### Cuidadores
- **Atributos**:
  - Nombre
  - Edad
  - Especialidad (tipos de animales que pueden cuidar)
  - Asociaciones con uno o varios animales
- **Interacciones**:
  - Alimentar animales
  - Bañar animales
  - Limpiar hábitat

### Visitantes
- **Atributos**:
  - Nombre
  - Edad
  - Animales favoritos
- **Interacciones**:
  - Alimentar animales
  - Dar propinas a cuidadores
  - Subir fotografías de animales

## Elementos del Diagrama UML

- [ ] Herencia y polimorfismo
- [ ] Asociaciones entre cuidadores y animales
- [ ] Asociaciones entre visitantes y animales/cuidadores
- [ ] Métodos relevantes de interacción
- [ ] Atributos encapsulados con getters y setters
- [ ] Manejo de atributos dinámicos

## Principios SOLID Aplicados

### S - Single Responsibility Principle (SRP)
**Dónde se aplica:**
- TODO: Explicar

### O - Open/Closed Principle (OCP)
**Dónde se aplica:**
- TODO: Explicar

### L - Liskov Substitution Principle (LSP)
**Dónde se aplica:**
- TODO: Explicar

### I - Interface Segregation Principle (ISP)
**Dónde se aplica:**
- TODO: Explicar

### D - Dependency Inversion Principle (DIP)
**Dónde se aplica:**
- TODO: Explicar

## Patrones de Diseño Utilizados

### Patrón 1: [Nombre del patrón]
- **Categoría**: Creacional/Estructural/Comportamiento
- **Justificación**: TODO
- **Cómo se aplicó**: TODO

## Diagrama UML

![Diagrama UML del Zoológico](../uml/zoologico.png)

> **Nota**: El diagrama debe ser exportado en formato PNG o PDF y colocado en la carpeta `docs/uml/`
