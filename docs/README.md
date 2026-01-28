# Preguntas Iniciales - Laboratorio 02

## Equipo: Forero, Montes, Rodriguez

---

## 1. ¿Qué ventaja ofrece el polimorfismo en el diseño de clases frente al uso de múltiples condicionales para determinar el comportamiento de un objeto?

El polimorfismo hace que el código sea más extensible y fácil de mantener. En vez de tener un if-else gigante que hay que modificar cada vez que agregas algo nuevo, puedes tratar objetos diferentes de manera uniforme con una interfaz común. Cada clase implementa su propio comportamiento y al agregar una nueva no tocas el código que ya existe.

---

## 2. ¿Por qué una clase inmutable puede mejorar la seguridad?

Una clase inmutable no puede cambiar su estado interno después de crearse. Esto mejora la seguridad porque garantiza que nadie puede modificar los datos maliciosamente o por error, y además es thread-safe (o sea, segura en ambientes concurrentes) porque no hay riesgo de condiciones de carrera al leer datos compartidos.

---

## 3. Según el principio de Abierto/Cerrado, ¿cómo deberíamos modificar el sistema si queremos añadir una nueva funcionalidad sin alterar el código existente?

Deberíamos extender el comportamiento del sistema mediante herencia o implementación de interfaces, creando nuevas clases que encapsulen la nueva funcionalidad. El código original debe depender de abstracciones (como interfaces o clases abstractas) y no de implementaciones concretas, así puedes inyectar las nuevas implementaciones sin reescribir la lógica base.

---

## 4. ¿Qué es y por qué usamos el pom.xml?

El `pom.xml` es el archivo fundamental de configuración en Maven. Lo usamos para definir la identidad del proyecto (como GroupId, ArtifactId, Version), sus dependencias (o sea, bibliotecas externas como Spring Boot), plugins de compilación y propiedades del entorno (como versión de Java). Facilita la gestión de dependencias y la estandarización del ciclo de vida de construcción.

---

## 5. ¿Qué diferencia hay entre mvn compile, mvn package y mvn install?

- **`mvn compile`**: Traduce el código fuente `.java` a código binario `.class` en la carpeta `target/classes`.

- **`mvn package`**: Ejecuta `compile`, luego las pruebas (`test`) y finalmente empaqueta el código compilado en un formato distribuible como JAR o WAR en la carpeta `target`.

- **`mvn install`**: Ejecuta `package` y luego copia el JAR generado al repositorio local de Maven (`.m2`), haciéndolo disponible para ser usado como dependencia por otros proyectos en la misma máquina.

---

## 6. ¿Qué diferencia existe entre una interfaz y una clase abstracta?

- Una clase puede **implementar múltiples interfaces** pero solo **heredar de una clase abstracta**.

- Las **clases abstractas** pueden tener atributos con estado (o sea, campos no estáticos ni finales), mientras que las **interfaces** antes de Java 8 solo tenían constantes. Ahora pueden tener métodos `default` pero no guardan estado de instancia.

- Las **clases abstractas** se usan para definir una base común y reutilizar código entre clases relacionadas ("es un"), mientras que las **interfaces** definen un contrato de comportamiento ("puede hacer") que puede ser adoptado por clases no relacionadas.
