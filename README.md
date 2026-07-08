# Llanquihue Tour App - Sistema de Gestión (Semana 5)

## Descripción
Sistema de gestión para la agencia de turismo **Llanquihue Tour** que permite administrar tours, guías, proveedores y operadores. Desarrollado en Java con organización modular, herencia, validaciones y menú interactivo.

## Estructura del proyecto

src/ 

├── model/ → Tour, Persona, Guia, Proveedor, Operador

├── data/ → GestorDatos (lectura de archivos)

├── service/ → LlanquihueService (lógica de negocio)

├── util/ → Validador (validaciones)

└── ui/ → Main (menú interactivo)

resources/

├── tours.txt

├── guias.txt

├── proveedores.txt

└── operadores.txt


## Clases principales
| Clase | Función |
|-------|---------|
| `Persona` | Clase base con atributos comunes (rut, nombre, apellido, teléfono, email) |
| `Guia` | Hereda de Persona, añade especialidad y años de experiencia |
| `Proveedor` | Hereda de Persona, añade rubro y dirección |
| `Operador` | Hereda de Persona, añade tipo de operación y zona de trabajo |
| `Tour` | Representa un tour turístico (nombre, ubicación, precio, tipo) |
| `Validador` | Validaciones de RUT, email, teléfono y persona |
| `GestorDatos` | Lee archivos .txt y crea objetos |
| `LlanquihueService` | Lógica de negocio: filtros, búsquedas y gestión de colecciones |
| `Main` | Menú interactivo en consola con 11 opciones |

## Instrucciones para ejecutar
1. Abrir el proyecto en IntelliJ IDEA.
2. Ejecutar la clase `ui.Main`.
3. Navegar por el menú:
    - Opciones 1-7: Mostrar datos y búsquedas filtradas.
    - Opciones 8-11: Mostrar listas específicas.
    - Opción 0: Salir.

## Formato de archivos
- `tours.txt`: `nombre;ubicacion;precio;tipo`
- `guias.txt`: `rut;nombre;apellido;telefono;email;especialidad;anosExperiencia`
- `proveedores.txt`: `rut;nombre;apellido;telefono;email;rubro;direccion`
- `operadores.txt`: `rut;nombre;apellido;telefono;email;tipoOperacion;zonaTrabajo`

## Semana 6 - Jerarquía de clases con herencia

### Objetivo
Implementar una jerarquía de clases para representar diferentes tipos de servicios turísticos.

### Clases creadas
| Clase | Tipo | Atributos |
|-------|------|-----------|
| `ServicioTuristico` | Superclase | `nombre`, `duracionHoras` |
| `RutaGastronomica` | Subclase | + `numeroDeParadas` |
| `PaseoLacustre` | Subclase | + `tipoEmbarcacion` |
| `ExcursionCultural` | Subclase | + `lugarHistorico` |

### Nueva funcionalidad
- Opción 12 en el menú: "Mostrar servicios turísticos"
- Crea instancias de prueba de cada subclase y las muestra por consola

### Cómo probar
1. Ejecutar `ui.Main`
2. Seleccionar opción 12
3. Ver los 6 servicios turísticos creados con sus atributos específicos

## Semana 7 - Aplicando polimorfismo y colecciones genéricas

### Objetivo
Aplicar polimorfismo para recorrer una colección de servicios turísticos y mostrar su información específica usando métodos sobrescritos.

### Clases modificadas
| Clase | Cambio realizado |
|-------|------------------|
| `ServicioTuristico` | Agregado método `mostrarInformacion()` |
| `RutaGastronomica` | Sobrescrito `mostrarInformacion()` con información de paradas |
| `PaseoLacustre` | Sobrescrito `mostrarInformacion()` con tipo de embarcación |
| `ExcursionCultural` | Sobrescrito `mostrarInformacion()` con lugar histórico |
| `GestorServicios` | Nuevo método `mostrarServicios()` con recorrido polimórfico |

### Funcionamiento del polimorfismo
- Se crea una lista de tipo `List<ServicioTuristico>`
- Se almacenan objetos de diferentes subclases (RutaGastronomica, PaseoLacustre, ExcursionCultural)
- Al recorrer la lista con for-each, se llama a `mostrarInformacion()`
- Java ejecuta automáticamente la versión sobrescrita según el tipo real de cada objeto

### Nueva funcionalidad
- Opción **13** en el menú: "Mostrar servicios con polimorfismo"
- Demostración visual del polimorfismo con íconos y formato diferenciado

### Cómo probar
1. Ejecutar `ui.Main`
2. Seleccionar opción **13**
3. Observar cómo cada servicio muestra su información específica usando polimorfismo
## Autor

## Semana 8 - Interfaces, Polimorfismo y GUI

### Objetivo
Integrar una interfaz común, aplicar polimorfismo con `instanceof` y crear una interfaz gráfica básica para gestionar entidades del sistema.

### Nuevas clases e interfaz
| Archivo | Descripción |
|---------|-------------|
| `model/Registrable.java` | Interfaz con el método `mostrarResumen()` |
| `model/Vehiculo.java` | Clase que implementa `Registrable` |
| `model/ColaboradorExterno.java` | Subclase de `Persona` que sobrescribe `mostrarResumen()` |
| `data/GestorEntidades.java` | Colección `ArrayList<Registrable>` y uso de `instanceof` |
| `ui/VentanaGUI.java` | Interfaz gráfica (JFrame) para agregar y mostrar entidades |

### Funcionamiento
- Opción **14** en el menú principal: abre la ventana gráfica.
- La GUI permite:
    - Agregar **Guías** (con todos sus datos).
    - Agregar **Vehículos** (patente, modelo, capacidad, combustible).
    - **Mostrar Resúmenes**: lista todas las entidades, usando `instanceof` para mostrar el tipo y llamando al método polimórfico `mostrarResumen()`.

### Cómo probar
1. Ejecutar `ui.Main`
2. Seleccionar opción **14**
3. Usar los botones para agregar guías y vehículos.
4. Hacer clic en "Mostrar Resúmenes" para ver la lista con diferenciación de tipos.

### Evidencia de polimorfismo
- La colección es de tipo `List<Registrable>`.
- Al recorrerla con un bucle for-each, se invoca `r.mostrarResumen()`.
- El comportamiento varía según la clase real del objeto (polimorfismo).
- `instanceof` se usa para mostrar un prefijo visual (ícono) pero no para cambiar la lógica principal.


[Diego Molina] - Duoc UC - Desarrollo Orientado a Objetos I - Semana 5