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
- Respuestas documentadas abajo
- Commit: feature: Preparación - Subir Respuestas preguntas iniciales

---

## Preguntas Teoricas

### 1. Que ventaja ofrece el polimorfismo en el diseño de clases frente al uso de multiples condicionales para determinar el comportamiento de un objeto?

el polimorfismo hace que el codigo sea mas extensible y facil de mantener, en vez de tener un if-else gigante que hay que modificar cada vez que agregas algo nuevo puedes tratar objetos diferentes de manera uniforme con una interfaz comun, cada clase implementa su propio comportamiento y al agregar una nueva no tocas el codigo que ya existe

### 2. Por que una clase inmutable puede mejorar la seguridad?

una clase inmutable no puede cambiar su estado interno despues de crearse, esto mejora la seguridad porque garantiza que nadie puede modificar los datos maliciosamente o por error y ademas es thread-safe o sea segura en ambientes concurrentes porque no hay riesgo de condiciones de carrera al leer datos compartidos

### 3. Segun el principio de Abierto/Cerrado como deberiamos modificar el sistema si queremos añadir una nueva funcionalidad sin alterar el codigo existente?

deberiamos extender el comportamiento del sistema mediante herencia o implementacion de interfaces, creando nuevas clases que encapsulen la nueva funcionalidad, el codigo original debe depender de abstracciones como interfaces o clases abstractas y no de implementaciones concretas asi puedes inyectar las nuevas implementaciones sin reescribir la logica base

### 4. Que es y por que usamos el pom.xml?

el pom.xml es el archivo fundamental de configuracion en Maven, lo usamos para definir la identidad del proyecto como GroupId ArtifactId Version, sus dependencias o sea bibliotecas externas como Spring Boot, plugins de compilacion y propiedades del entorno como version de Java, facilita la gestion de dependencias y la estandarizacion del ciclo de vida de construccion

### 5. Que diferencia hay entre mvn compile mvn package y mvn install?

mvn compile traduce el codigo fuente .java a codigo binario .class en la carpeta target/classes

mvn package ejecuta compile luego las pruebas test y finalmente empaqueta el codigo compilado en un formato distribuible como JAR o WAR en la carpeta target

mvn install ejecuta package y luego copia el JAR generado al repositorio local de Maven .m2 haciendolo disponible para ser usado como dependencia por otros proyectos en la misma maquina

### 6. Que diferencia existe entre una interfaz y una clase abstracta?

una clase puede implementar multiples interfaces pero solo heredar de una clase abstracta

las clases abstractas pueden tener atributos con estado o sea campos no estaticos ni finales mientras que las interfaces antes de Java 8 solo tenian constantes, ahora pueden tener metodos default pero no guardan estado de instancia

las clases abstractas se usan para definir una base comun y reutilizar codigo entre clases relacionadas es un mientras que las interfaces definen un contrato de comportamiento puede hacer que puede ser adoptado por clases no relacionadas

---

## Retos - Implementacion

