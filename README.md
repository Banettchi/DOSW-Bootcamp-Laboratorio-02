# DOSW Bootcamp - Laboratorio 02: Patrones de Diseño
## **Semestre:** 2026-1
---

## **Integrantes del Equipo**
| **Integrante** | **GitHub** | **Contacto** |
|------------|------------|-------------|
| **Maria Juliana Rodriguez Caicedo** | [@JuliRodC](https://github.com/JuliRodC) | [maria.rodriguez@mail.escuelaing.edu.co](mailto:maria.rodriguez@mail.escuelaing.edu.co) |
| **Kevyn Daniel Forero Gonzalez** | [@kevyn1005](https://github.com/kevyn1005) | [kevyn.forero@mail.escuelaing.edu.co](mailto:kevyn.forero@mail.escuelaing.edu.co) |
| **Diego Alejandro Montes Bonilla** | [@banettchi](https://github.com/banettchi) | [diego.montes@mail.escuelaing.edu.co](mailto:diego.montes@mail.escuelaing.edu.co) |

**Rama:** `feature/Forero_Montes_Rodriguez_2026-1`

---

## **Retos Completados**
| **Reto** | **Nombre** | **Patrón / Principio** | **Categoría** | **Estado** |
|----------|-----------|----------------------|--------------|-----------|
| Reto 1 | La Tienda de Don Pepe | SOLID | Principios SOLID | ✅ Completado |
| Reto 2 | El Chef de 5 Estrellas | Builder | Creacional | ✅ Completado |
| Reto 3 | El Reino de los Vehículos | Abstract Factory | Creacional | ✅ Completado |
| Reto 4 | La Casa de Cambio | Adapter | Estructural | ✅ Completado |
| Reto 5 | El Café Personalizado | Decorator | Estructural | ✅ Completado |
| Reto 6 | Soporte Técnico | Chain of Responsibility | Comportamiento | ✅ Completado |
| Reto 7 | Control Remoto Mágico | Command | Comportamiento | ✅ Completado |

---

## **Estructura del Proyecto**

```
DOSW-Bootcamp-Laboratorio-02/
├── docs/
│   └── README.md                          ← Preguntas teóricas iniciales
├── src/main/java/edu/dosw/lab/
│   ├── Application.java                   ← Punto de entrada principal
│   ├── creacionales/
│   │   ├── reto1/                         ← SOLID - Tienda Don Pepe
│   │   ├── reto2/                         ← Builder - Chef de 5 Estrellas
│   │   └── reto3/                         ← Abstract Factory - Reino de Vehículos
│   ├── estructurales/
│   │   ├── reto4/                         ← Adapter - Casa de Cambio
│   │   └── reto5/                         ← Decorator - Café Personalizado
│   └── comportamiento/
│       ├── reto6/                         ← Chain of Responsibility - Soporte
│       └── reto7/                         ← Command - Control Remoto
├── pom.xml
└── README.md
```

---

## **Compilación y Ejecución**

**Compilar:**
```bash
mvn clean compile
```

**Ejecutar:**
```bash
mvn exec:java -Dexec.mainClass=edu.dosw.lab.Application
```

---

## **Parte 1 – Preparación del Espacio de Trabajo**

| Tarea | Estado | Fecha |
|-------|--------|-------|
| Clonar repositorio | ✅ Completado | 2026-01-28 |
| Crear rama feature | ✅ Completado | 2026-01-28 |
| Estructura de paquetes | ✅ Completado | 2026-01-28 |
| Configurar pom.xml | ✅ Completado | 2026-01-28 |
| Responder preguntas teóricas | ✅ Completado | 2026-01-28 |

### Integrante 1 - Estructura
- Repositorio clonado
- Rama `feature/Forero_Montes_Rodriguez_2026-1` creada
- Proyecto Maven con Spring Boot 3.2.1 y Java 21
- Carpetas `creacionales`, `estructurales`, `comportamiento`, `solid`, `util`
- `Application.java` listo

### Integrante 2 - Maven
- `pom.xml` configurado (GroupId: `edu.dosw.bootcamp.lab`, ArtifactId: `DOSW-Bootcamp-Laboratorio-02`, Java 21, Spring Boot 3.2.1)
- README actualizado

### Integrante 3 - Preguntas
- Respuestas documentadas en `docs/README.md`

---

## **Parte 2: Hackathon Express – Detalle de cada Reto**

---

### 🏪 Reto 1: La Tienda de Don Pepe (SOLID)

**Ubicación:** `src/main/java/edu/dosw/lab/creacionales/reto1/`

#### ¿Cómo se aplica cada principio SOLID en la solución?

**1. SRP – Principio de Responsabilidad Única (Single Responsibility Principle)**

Cada clase tiene una única razón para cambiar, es decir, una sola responsabilidad bien definida:

- `Producto`: Solo almacena los datos de un producto (nombre y precio). Es una clase inmutable con campos `final`, no gestiona ni lógica de negocio ni presentación.
- `CarritoCompras`: Solo se encarga de gestionar la colección de productos y sus cantidades mediante un `Map<Producto, Integer>`. No calcula descuentos ni imprime nada.
- `Recibo`: Solo se encarga de calcular el total con descuento e imprimir el recibo de compra. Recibe los datos que necesita (Cliente + CarritoCompras) por constructor.
- `Cliente`: Solo define la abstracción de un cliente con su porcentaje de descuento. No conoce el carrito ni la tienda.
- `TiendaDonPepe`: Solo gestiona el catálogo de productos y coordina el flujo de compra. No calcula descuentos ni genera recibos directamente.

**2. OCP – Principio de Abierto/Cerrado (Open/Closed Principle)**

El sistema está abierto a extensión pero cerrado a modificación:

- Para agregar un nuevo tipo de cliente (por ejemplo `ClienteVIP` con 20% de descuento), solo se crea una nueva clase que extienda `Cliente` y se define el `porcentajeDescuento`. No es necesario modificar `TiendaDonPepe`, `Recibo`, ni ninguna otra clase existente.
- El método `calcularDescuento()` en `Cliente` funciona automáticamente con cualquier subclase porque usa el campo `porcentajeDescuento` que cada subclase define en su constructor.

**3. LSP – Principio de Sustitución de Liskov (Liskov Substitution Principle)**

Las subclases pueden reemplazar a la clase base sin alterar el comportamiento esperado:

- `ClienteFrecuente` y `ClienteNuevo` extienden `Cliente` y pueden usarse donde se espere un `Cliente` sin romper la lógica del programa.
- Ejemplo en el código: `Recibo` recibe un `Cliente` (tipo abstracto) en su constructor y llama a `cliente.calcularDescuento(subtotal)`. Funciona correctamente independientemente de si se pasa un `ClienteFrecuente` (10%) o un `ClienteNuevo` (5%).

**4. ISP – Principio de Segregación de Interfaces (Interface Segregation Principle)**

Las clases no dependen de métodos que no usan:

- `Producto` solo expone `getNombre()` y `getPrecio()`, que son exactamente los datos relevantes del producto.
- `Cliente` solo expone `getPorcentajeDescuento()`, `getTipo()` y `calcularDescuento()`, que son los métodos que las clases consumidoras necesitan.
- `CarritoCompras` expone `agregarProducto()`, `getProductos()` y `calcularSubtotal()`, sin mezclar responsabilidades de presentación o descuentos.

**5. DIP – Principio de Inversión de Dependencias (Dependency Inversion Principle)**

Los módulos de alto nivel dependen de abstracciones, no de implementaciones concretas:

- `Recibo` depende de `Cliente` (clase abstracta), no de `ClienteFrecuente` ni `ClienteNuevo`. Esto le permite funcionar con cualquier tipo de cliente presente o futuro.
- `TiendaDonPepe.procesarCompra()` recibe un `Cliente` (abstracción), no una implementación concreta. Esto desacopla la tienda de los tipos específicos de cliente.

#### ¿Cómo se aplica el polimorfismo en la solución?

El polimorfismo se aplica mediante la clase abstracta `Cliente` y sus subclases:

- **Definición de la abstracción:** La clase abstracta `Cliente` define el método `calcularDescuento(double subtotal)` que multiplica el subtotal por el `porcentajeDescuento`. Cada subclase establece su propio porcentaje en el constructor:
  - `ClienteNuevo`: `porcentajeDescuento = 0.05` (5% de descuento)
  - `ClienteFrecuente`: `porcentajeDescuento = 0.10` (10% de descuento)

- **Uso polimórfico:** En `TiendaDonPepe.ejecutar()`, se crea un cliente como `Cliente cliente = new ClienteFrecuente()`. Luego, `Recibo` llama a `cliente.calcularDescuento(subtotal)` sin saber el tipo concreto del cliente. Java resuelve en tiempo de ejecución cuál es el porcentaje correcto según la instancia real.

- **Beneficio directo:** Si mañana se necesita agregar un `ClienteVIP` con 20% de descuento, se crea la nueva clase sin tocar ningún código existente. El polimorfismo garantiza que `Recibo` y `TiendaDonPepe` funcionen automáticamente con el nuevo tipo de cliente.

#### Clases implementadas

| Clase | Rol | Descripción |
|-------|-----|-------------|
| `Producto` | Modelo | Clase inmutable (`final`) que almacena nombre y precio del producto |
| `Cliente` | Abstracción | Clase abstracta con porcentaje de descuento y tipo de cliente |
| `ClienteNuevo` | Implementación | Cliente nuevo con 5% de descuento |
| `ClienteFrecuente` | Implementación | Cliente frecuente con 10% de descuento |
| `CarritoCompras` | Servicio | Gestiona productos con `Map<Producto, Integer>`, calcula subtotal con Streams |
| `Recibo` | Servicio | Genera el recibo de compra con detalle, subtotal, descuento y total |
| `TiendaDonPepe` | Controlador | Orquesta la tienda: catálogo, bienvenida y procesamiento de compra |

#### Uso de Streams
- `calcularSubtotal()` en `CarritoCompras` usa `stream().mapToDouble().sum()` para sumar los precios de todos los productos del carrito
- `mostrarCatalogo()` usa `forEach` funcional para listar productos del catálogo

**Evidencias:**
- [x] Código implementado
- [ ] Captura de ejecución

---

### 🍔 Reto 2: El Chef de 5 Estrellas (Patrón Builder)

**Ubicación:** `src/main/java/edu/dosw/lab/creacionales/reto2/`

**Categoría del patrón:** Creacional  
**Patrón utilizado:** Builder

**Justificación:** El patrón Builder es ideal para construir hamburguesas personalizadas paso a paso. Permite que el cliente agregue ingredientes opcionales de forma flexible, separa la lógica de construcción de la representación final y produce objetos inmutables (la hamburguesa final no se puede modificar después de crearse).

**¿Cómo se aplicó?**

| Clase | Rol en el Patrón | Descripción |
|-------|------------------|-------------|
| `Ingrediente` | Componente | Encapsula nombre y precio de un ingrediente |
| `Hamburguesa` | Producto | Objeto inmutable resultado de la construcción. Contiene la lista de ingredientes |
| `HamburguesaBuilder` | Builder | Construye la hamburguesa paso a paso con `agregarIngrediente()`, valida mínimo 1 ingrediente |
| `Chef` / `Reto2` | Director/Client | Muestra el menú interactivo, lee la selección del usuario y coordina la construcción |

**Flujo de ejecución:**
1. Se muestra un menú con ingredientes predefinidos (Pan, Carne, Queso, Lechuga, Tomate, Salsa especial)
2. El usuario selecciona ingredientes por número separados por coma
3. Opción para agregar ingredientes personalizados con nombre y precio
4. El Builder construye la hamburguesa y se muestra el resultado con precio total

**Uso de Streams:**
- `calcularPrecioTotal()` usa `stream().mapToDouble(Ingrediente::getPrecio).sum()`
- `obtenerNombresIngredientes()` usa `stream().map().collect(Collectors.joining(", "))`

**Evidencias:**
- [x] Código implementado
- [ ] Captura de ejecución

---

### 🚗 Reto 3: El Reino de los Vehículos (Patrón Abstract Factory)

**Ubicación:** `src/main/java/edu/dosw/lab/creacionales/reto3/`

**Categoría del patrón:** Creacional  
**Patrón utilizado:** Abstract Factory

**Justificación:** El sistema requiere crear familias de vehículos (Tierra, Acuáticos, Aéreos) con diferentes categorías (Económico, Lujo, Usado). Abstract Factory permite que la creación de cada familia de vehículos sea independiente y extensible, sin que el código cliente conozca las clases concretas.

**¿Cómo se aplicó?**

| Clase / Interfaz | Rol en el Patrón | Descripción |
|------------------|------------------|-------------|
| `Vehiculo` | Producto abstracto | Interfaz base con `getTipo()`, `getModelo()`, `getCategoria()`, `getPrecio()`, `mostrarInfo()` |
| `VehiculoFactory` | Abstract Factory | Interfaz que define `crearVehiculo()` y `getModelosDisponibles()` |
| `TierraFactory` | Fábrica concreta | Crea vehículos terrestres: `Auto`, `Bicicleta`, `Moto` |
| `AcuaticoFactory` | Fábrica concreta | Crea vehículos acuáticos: `Lancha`, `JetSki` |
| `AereoFactory` | Fábrica concreta | Crea vehículos aéreos: `Avion`, `Avioneta`, `Helicoptero` |
| `Categoria` | Enum | Define categorías: ECONOMICO, LUJO, USADO |
| `Concesionaria` | Client | Menú interactivo, gestiona carrito de compra y muestra resumen |

**Vehículos disponibles:**

| Tipo | Modelos |
|------|---------|
| 🚗 Tierra | Auto, Bicicleta, Moto |
| 🚤 Acuático | Lancha, JetSki |
| ✈️ Aéreo | Avión, Avioneta, Helicóptero |

**Flujo de ejecución:**
1. Seleccionar tipo de vehículo (Tierra/Acuático/Aéreo)
2. Seleccionar categoría (Económico/Lujo/Usado)
3. Seleccionar modelo según el tipo elegido
4. La fábrica correspondiente crea el vehículo
5. Se puede agregar más vehículos al carrito
6. Se muestra resumen con total calculado por Streams

**Uso de Streams:**
- `carrito.stream().mapToDouble(Vehiculo::getPrecio).sum()` para calcular total

**Evidencias:**
- [x] Código implementado
- [ ] Captura de ejecución

---

### 💱 Reto 4: La Casa de Cambio (Patrón Adapter)

**Ubicación:** `src/main/java/edu/dosw/lab/estructurales/reto4/`

**Categoría del patrón:** Estructural  
**Patrón utilizado:** Adapter

**Justificación:** El sistema de cambio de monedas tiene un sistema legado ("del Gringo") que solo trabaja con USD como moneda base. Necesitamos que este sistema sea compatible con una nueva interfaz que permita convertir entre cualquier par de monedas. El Adapter traduce las llamadas de la nueva interfaz a las que entiende el sistema legado.

**¿Cómo se aplicó?**

| Clase / Interfaz | Rol en el Patrón | Descripción |
|------------------|------------------|-------------|
| `ConversorMoneda` | Target | Interfaz que define `convertir(monto, origen, destino)` |
| `SistemaLegadoUSD` | Adaptee | Sistema existente que solo convierte a/desde USD |
| `AdaptadorCasaCambio` | Adapter | Implementa `ConversorMoneda` usando internamente `SistemaLegadoUSD` |
| `Moneda` | Enum | Define monedas con tasas de cambio a USD (USD, EUR, JPY, COP, CNY) |
| `Transaccion` | Modelo | Almacena datos de una transacción de cambio |
| `CasaCambio` | Client | Menú interactivo, procesa N transacciones y muestra totales por moneda |

**Monedas soportadas:**

| Moneda | Nombre | Tasa a USD |
|--------|--------|------------|
| USD | Dólar Estadounidense | 1.0 |
| EUR | Euro | 1.10 |
| JPY | Yen Japonés | 0.006667 |
| COP | Peso Colombiano | 0.00025 |
| CNY | Yuan Chino | 0.14 |

**Flujo de ejecución:**
1. El usuario indica número de transacciones
2. Para cada transacción: monto, moneda origen y monedas destino (separadas por coma)
3. El Adapter convierte: primero a USD (sistema legado), luego de USD a la moneda destino
4. Se muestra cada conversión y los totales agrupados por moneda

**Uso de Streams:**
- `flatMap()` para aplanar las conversiones de todas las transacciones
- `forEach()` con `merge()` para acumular totales por moneda

**Evidencias:**
- [ ] Captura de ejecución

---

### ☕ Reto 5: El Café Personalizado (Patrón Decorator)

**Ubicación:** `src/main/java/edu/dosw/lab/estructurales/reto5/`

**Categoría del patrón:** Estructural  
**Patrón utilizado:** Decorator

**Justificación:** El sistema de cafetería necesita agregar toppings a un café base sin modificar la clase original. Decorator permite envolver el café con capas de toppings donde cada uno agrega su descripción y precio, cumpliendo con el principio Open/Closed.

**¿Cómo se aplicó?**

| Clase / Interfaz | Rol en el Patrón | Descripción |
|------------------|------------------|-------------|
| `Cafe` | Component | Interfaz base con `getDescripcion()` y `getPrecio()` |
| `CafeBase` | Concrete Component | Café base sin toppings |
| `ToppingDecorator` | Decorator abstracto | Clase abstracta que envuelve un `Cafe` y delega llamadas |
| `Leche`, `Chocolate`, `Caramelo`, `CremaBatida`, `Menta` | Concrete Decorators | Cada uno agrega su descripción y precio al café |
| `ToppingPersonalizado` | Concrete Decorator | Permite crear toppings con nombre y precio dinámicos |
| `Cafeteria` | Client | Menú interactivo, personaliza N cafés y muestra resumen |

**Toppings disponibles:**

| Opción | Topping | Precio |
|--------|---------|--------|
| 1 | Leche | $1,000 |
| 2 | Chocolate | $1,500 |
| 3 | Caramelo | $1,200 |
| 4 | Crema Batida | $2,000 |
| 5 | Menta | $1,300 |
| 6 | Personalizado | Precio a elección |

**Flujo de ejecución:**
1. Se muestra el menú de toppings disponibles
2. El usuario indica cuántos cafés desea personalizar
3. Para cada café, selecciona los toppings por número separados por coma
4. Cada topping "envuelve" al café anterior (patrón Decorator)
5. Se muestra el resumen con ingredientes y precio total por café
6. Se calcula el total general con Streams

**Uso de Streams:**
- `cafes.stream().mapToDouble(Cafe::getPrecio).sum()` para calcular total general

**Evidencias:**
- [x] Código implementado
- [ ] Captura de ejecución

---

### 🎫 Reto 6: Soporte Técnico (Patrón Chain of Responsibility)

**Ubicación:** `src/main/java/edu/dosw/lab/comportamiento/reto6/`

**Categoría del patrón:** Comportamiento (Behavioral)  
**Patrón utilizado:** Chain of Responsibility

**Justificación:** El sistema de soporte técnico requiere procesar tickets que pasan por diferentes niveles de técnicos sin que el emisor del ticket conozca quién lo resolverá. Chain of Responsibility permite desacoplar el emisor del receptor, ya que cada técnico decide si puede manejar el ticket o lo pasa al siguiente en la cadena. Esto facilita agregar o quitar técnicos dinámicamente sin modificar la lógica de procesamiento.

**¿Cómo se aplicó?**

| Clase | Rol en el Patrón | Descripción |
|-------|------------------|-------------|
| `ManejadorSoporte` | Handler abstracto | Define la interfaz de manejo con `manejar()`, verifica si el ticket coincide con la especialidad y prioridad máxima del técnico. Si no puede, lo pasa al siguiente |
| `SoporteNivel1` | Concrete Handler | Técnico Básico - maneja tickets de nivel BASICO y prioridad BAJA |
| `SoporteNivel2` | Concrete Handler | Técnico Intermedio - maneja tickets de nivel INTERMEDIO y prioridad MEDIA |
| `SoporteNivel3` | Concrete Handler | Técnico Avanzado - maneja tickets de nivel AVANZADO y prioridad ALTA |
| `Ticket` | Request | Contiene nivel (BASICO/INTERMEDIO/AVANZADO), prioridad (BAJA/MEDIA/ALTA) y descripción |
| `Reto6` | Client | Construye la cadena, recibe tickets por Scanner y genera estadísticas con Streams |

**Cadena de responsabilidad:**
```
Ticket → [Técnico Básico] → [Técnico Intermedio] → [Técnico Avanzado] → Pendiente
```

**Flujo de ejecución:**
1. Se construye la cadena: Nivel1 → Nivel2 → Nivel3
2. El usuario ingresa N tickets con nivel, prioridad y descripción
3. Cada ticket pasa por la cadena hasta encontrar un técnico que pueda resolverlo
4. Se muestran estadísticas: tickets por nivel, pendientes y promedio de prioridad

**Uso de Streams:**
- `groupingBy()` + `counting()` para contar tickets resueltos por técnico
- `filter()` + `count()` para contar tickets pendientes
- `mapToInt()` + `average()` para calcular el promedio de prioridad

**Evidencias:**
- [x] Código implementado
- [ ] Captura de ejecución

---

### 🎮 Reto 7: Control Remoto Mágico (Patrón Command)

**Ubicación:** `src/main/java/edu/dosw/lab/comportamiento/reto7/`

**Categoría del patrón:** Comportamiento (Behavioral)  
**Patrón utilizado:** Command

**Justificación:** El control remoto mágico necesita ejecutar acciones sobre varios dispositivos (luces, puertas, música, persianas), registrar quién ejecutó cada acción, y permitir deshacer cualquier acción. El patrón Command encapsula cada acción como un objeto, desacoplando al invocador (control remoto) de los receptores (dispositivos). Esto permite implementar undo fácilmente, mantener un historial completo y agregar nuevos dispositivos sin modificar el código existente.

**¿Cómo se aplicó?**

| Clase / Interfaz | Rol en el Patrón | Descripción |
|------------------|------------------|-------------|
| `Comando` | Command (interfaz) | Define `ejecutar()`, `deshacer()`, `getUsuario()`, `getDescripcion()` e `isDeshecho()` |
| `ComandoEncenderLuz` | Concrete Command | Encapsula la acción de encender/apagar la luz |
| `ComandoAbrirPuerta` | Concrete Command | Encapsula la acción de abrir/cerrar la puerta |
| `ComandoReproducirMusica` | Concrete Command | Encapsula la acción de reproducir/detener música |
| `ComandoAjustarVolumen` | Concrete Command | Encapsula la acción de ajustar volumen de persiana |
| `Luz`, `Puerta`, `Musica`, `Persiana` | Receivers | Dispositivos del hogar que ejecutan las acciones reales |
| `ControlRemoto` | Invoker | Ejecuta comandos, almacena historial y permite deshacer acciones |
| `Reto7` | Client | Entrada interactiva, muestra resultados e investiga desconfiguraciones |

**Dispositivos disponibles:**

| Opción | Dispositivo | Acción |
|--------|------------|--------|
| 1 | Luz | Encender / Apagar |
| 2 | Puerta | Abrir / Cerrar |
| 3 | Música | Reproducir / Detener |
| 4 | Persiana | Ajustar volumen (0-100) |

**Flujo de ejecución:**
1. El usuario indica N acciones a registrar
2. Para cada acción: usuario, dispositivo, y opción de deshacer inmediatamente
3. Se muestra el historial completo con estado de cada acción
4. Se investiga quién desconfiguró los electrodomésticos con Streams

**Uso de Streams:**
- `groupingBy()` + `counting()` para contar acciones ejecutadas por usuario
- `mapToLong()` + `max()` para identificar al usuario con más acciones
- `filter()` para separar acciones deshechas de las vigentes

**Evidencias:**
- [x] Código implementado
- [ ] Captura de ejecución

---

## **Evidencias de Ejecución**

### Reto 1 - La Tienda de Don Pepe
<!-- ![Evidencia Reto 1](docs/imagenes/reto1.png) -->

### Reto 2 - El Chef de 5 Estrellas
<!-- ![Evidencia Reto 2](docs/imagenes/reto2.png) -->

### Reto 3 - El Reino de los Vehículos
<!-- ![Evidencia Reto 3](docs/imagenes/reto3.png) -->

### Reto 4 - La Casa de Cambio
<!-- ![Evidencia Reto 4](docs/imagenes/reto4.png) -->

### Reto 5 - El Café Personalizado
<!-- ![Evidencia Reto 5](docs/imagenes/reto5.png) -->

### Reto 6 - Soporte Técnico
<!-- ![Evidencia Reto 6](docs/imagenes/reto6.png) -->

### Reto 7 - Control Remoto Mágico
<!-- ![Evidencia Reto 7](docs/imagenes/reto7.png) -->

---

## **Preguntas Teóricas Iniciales**

Las respuestas completas se encuentran en [`docs/README.md`](docs/README.md). A continuación un resumen:

### 1. ¿Qué ventaja ofrece el polimorfismo frente a múltiples condicionales?
El polimorfismo hace que el código sea más extensible y fácil de mantener. En vez de un `if-else` gigante, cada clase implementa su propio comportamiento mediante una interfaz común.

### 2. ¿Por qué una clase inmutable mejora la seguridad?
Una clase inmutable no puede cambiar su estado interno después de crearse, lo que garantiza que nadie modifique los datos maliciosamente y además es thread-safe.

### 3. Principio Abierto/Cerrado: ¿cómo añadir funcionalidad sin alterar código existente?
Extendiendo el comportamiento mediante herencia o implementación de interfaces, dependiendo de abstracciones y no de implementaciones concretas.

### 4. ¿Qué es el pom.xml?
Es el archivo fundamental de configuración de Maven donde se define la identidad del proyecto, dependencias, plugins y propiedades del entorno.

### 5. Diferencia entre mvn compile, mvn package y mvn install
- **`mvn compile`**: Compila el código fuente a `.class`
- **`mvn package`**: Compila, prueba y empaqueta en JAR/WAR
- **`mvn install`**: Ejecuta `package` y copia al repositorio local `.m2`

### 6. ¿Diferencia entre interfaz y clase abstracta?
- Se pueden implementar múltiples interfaces pero solo heredar de una clase abstracta
- Las clases abstractas pueden tener estado, las interfaces definen contratos de comportamiento
- Clase abstracta = "es un", Interfaz = "puede hacer"

---

## **Resumen de Patrones de Diseño Utilizados**

```
┌──────────────────────────────────────────────────────────────────────┐
│                    PATRONES DE DISEÑO - LAB 02                       │
├──────────────┬───────────────────────────────────────────────────────┤
│  CREACIONALES │  Reto 2: Builder (Hamburguesas)                      │
│              │  Reto 3: Abstract Factory (Vehículos)                │
├──────────────┼───────────────────────────────────────────────────────┤
│ ESTRUCTURALES │  Reto 4: Adapter (Casa de Cambio)                    │
│              │  Reto 5: Decorator (Café Personalizado)              │
├──────────────┼───────────────────────────────────────────────────────┤
│COMPORTAMIENTO │  Reto 6: Chain of Responsibility (Soporte Técnico)   │
│              │  Reto 7: Command (Control Remoto Mágico)             │
├──────────────┼───────────────────────────────────────────────────────┤
│    SOLID     │  Reto 1: SRP, OCP, LSP, ISP, DIP (Tienda Don Pepe)  │
└──────────────┴───────────────────────────────────────────────────────┘
```
