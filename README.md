# DOSW Bootcamp - Laboratorio 02
## Semestre 2026-1

---

## Team Members

| Member |
|--------|
| Kevyn Forero |
| Diego Montes |
| Juliana Rodriguez |

**Rama:** feature/Forero_Montes_Rodriguez_2026-1

---

## Estructura del Proyecto

```
DOSW-Bootcamp-Laboratorio-02/
├── docs/
│   ├── uml/
│   ├── imagenes/
│   └── README.md
├── src/main/java/edu/dosw/lab/
│   ├── creacionales/
│   ├── estructurales/
│   ├── comportamiento/
│   ├── solid/
│   └── util/
├── pom.xml
└── README.md
```

---

## Evidencias Parte 1

### Preparacion del Proyecto

| Tarea | Estado | Fecha |
|-------|--------|-------|
| Clonar repositorio | Completado | 2026-01-28 |
| Crear rama feature | Completado | 2026-01-28 |
| Estructura de paquetes | Completado | 2026-01-28 |
| Configurar pom.xml | Completado | 2026-01-28 |
| Responder preguntas teoricas | Completado | 2026-01-28 |

### Integrante 1 - Estructura
- Repositorio clonado
- Rama feature/Forero_Montes_Rodriguez_2026-1 creada
- Proyecto Maven con Spring Boot 3.2.1 y Java 21
- Carpetas creacionales estructurales comportamiento solid util
- Application.java listo
- Commit: feature: Preparación: Subir Estructura de Paquetes del Laboratorio 02

**Compilacion:**
```bash
mvn clean compile
```

**Ejecucion:**
```bash
mvn exec:java -Dexec.mainClass=edu.dosw.lab.Application
```

### Integrante 2 - Maven
- pom.xml configurado
  - GroupId: edu.dosw.bootcamp.lab
  - ArtifactId: DOSW-Bootcamp-Laboratorio-02
  - Java 21
  - Spring Boot 3.2.1
- README actualizado
- Commit: feature: Preparacion - Subir Readme del Laboratorio 02

### Integrante 3 - Preguntas
- Respuestas documentadas en `docs/README.md`
- Commit: feature: Preparación - Subir Respuestas preguntas iniciales

---

## Parte 2: Hackathon Express

### Reto 1: Tienda de Don Pepe (SOLID)
**Estado**: ⏳ Pendiente  
**Ubicación**: `src/main/java/edu/dosw/lab/solid/reto1/`

**Principios SOLID aplicados**:
- [ ] SRP - Responsabilidad Única
- [ ] OCP - Abierto/Cerrado
- [ ] LSP - Sustitución de Liskov
- [ ] ISP - Segregación de Interfaces
- [ ] DIP - Inversión de Dependencias

**Evidencias**:
- [ ] Código implementado
- [ ] Captura de ejecución
- [ ] Documentación de SOLID

---

### Reto 2: Chef de 5 Estrellas (Patrón Creacional)
**Estado**: ⏳ Pendiente  
**Ubicación**: `src/main/java/edu/dosw/lab/creacionales/reto2/`

**Patrón**: Builder  
**Categoría**: Creacional

**Evidencias**:
- [ ] Código implementado
- [ ] Captura de ejecución
- [ ] Documentación del patrón

---

### Reto 3: Reino de Vehículos (Patrón Creacional)
**Estado**: ⏳ Pendiente  
**Ubicación**: `src/main/java/edu/dosw/lab/creacionales/reto3/`

**Patrón**: Abstract Factory  
**Categoría**: Creacional

**Evidencias**:
- [ ] Código implementado
- [ ] Captura de ejecución
- [ ] Documentación del patrón

---

### Reto 4: Casa de Cambio (Patrón Estructural)
**Estado**: ⏳ Pendiente  
**Ubicación**: `src/main/java/edu/dosw/lab/estructurales/reto4/`

**Patrón**: Strategy  
**Categoría**: Comportamiento

**Evidencias**:
- [ ] Código implementado
- [ ] Captura de ejecución
- [ ] Documentación del patrón

---

### Reto 5: Café Personalizado (Patrón Estructural)
**Estado**: ⏳ Pendiente  
**Ubicación**: `src/main/java/edu/dosw/lab/estructurales/reto5/`

**Patrón**: Decorator  
**Categoría**: Estructural

**Evidencias**:
- [ ] Código implementado
- [ ] Captura de ejecución
- [ ] Documentación del patrón

---

### Reto 6: Soporte Técnico (Patrón Comportamiento)
**Estado**: ✅ Completado  
**Ubicación**: `src/main/java/edu/dosw/lab/comportamiento/reto6/`

**Categoría del patrón de diseño**: Comportamiento (Behavioral)  
**Patrón Utilizado**: Chain of Responsibility  

**Justificación**: El sistema de soporte técnico requiere procesar tickets que pasan por diferentes niveles de técnicos sin que el emisor del ticket conozca quién lo resolverá. Chain of Responsibility permite desacoplar el emisor del receptor, ya que cada técnico decide si puede manejar el ticket o lo pasa al siguiente en la cadena. Esto facilita agregar o quitar técnicos dinámicamente sin modificar la lógica de procesamiento.

**¿Cómo lo aplicó?**:
- `ManejadorSoporte` (Handler abstracto): define la interfaz de manejo con `manejar()`, verifica si el ticket coincide con la especialidad y prioridad máxima del técnico. Si no puede, lo pasa al siguiente.
- `SoporteNivel1`, `SoporteNivel2`, `SoporteNivel3` (Concrete Handlers): técnicos Básico, Intermedio y Avanzado, cada uno con su nivel de especialidad y prioridad máxima.
- `Ticket` (Request): contiene nivel (BASICO/INTERMEDIO/AVANZADO), prioridad (BAJA/MEDIA/ALTA) y descripción.
- `Reto6` (Client): construye la cadena, recibe tickets por Scanner y usa Streams para estadísticas (conteo por nivel, pendientes, promedio de prioridad).

**Evidencias**:
- [x] Código implementado
- [ ] Captura de ejecución
- [x] Documentación del patrón

---

### Reto 7: Control Remoto Mágico (Patrón Comportamiento)
**Estado**: ✅ Completado  
**Ubicación**: `src/main/java/edu/dosw/lab/comportamiento/reto7/`

**Categoría del patrón de diseño**: Comportamiento (Behavioral)  
**Patrón Utilizado**: Command  

**Justificación**: El control remoto mágico necesita ejecutar acciones sobre varios dispositivos (luces, puertas, música, persianas), registrar quién ejecutó cada acción, y permitir deshacer cualquier acción individual. El patrón Command encapsula cada acción como un objeto, desacoplando al invocador (control remoto) de los receptores (dispositivos). Esto permite implementar undo fácilmente, mantener un historial completo y agregar nuevos dispositivos/acciones sin modificar el código existente.

**¿Cómo lo aplicó?**:
- `Comando` (Command interface): define `ejecutar()`, `deshacer()`, `getUsuario()`, `getDescripcion()` e `isDeshecho()`.
- `ComandoEncenderLuz`, `ComandoAbrirPuerta`, `ComandoReproducirMusica`, `ComandoAjustarVolumen` (Concrete Commands): encapsulan acciones sobre cada dispositivo con tracking del usuario que las ejecutó.
- `Luz`, `Puerta`, `Musica`, `Persiana` (Receivers): dispositivos del hogar que ejecutan las acciones reales.
- `ControlRemoto` (Invoker): ejecuta comandos, almacena historial y permite deshacer acciones individuales por índice.
- `Reto7` (Client): entrada interactiva con Scanner, muestra resultados, historial completo y usa Streams para investigar quién desconfiguró los electrodomésticos.

**Evidencias**:
- [x] Código implementado
- [ ] Captura de ejecución
- [x] Documentación del patrón

---

### Reto 8: Zoológico UML (Diseño)
**Estado**: ⏳ Pendiente  
**Ubicación**: `docs/reto8_zoologico.md`

**Evidencias**:
- [ ] Diagrama UML exportado (`docs/uml/zoologico.png`)
- [ ] Documentación de SOLID en el diseño
- [ ] Documentación de patrones utilizados

---

## Retos - Implementacion

