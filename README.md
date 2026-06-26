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
## Autor
[Diego Molina] - Duoc UC - Desarrollo Orientado a Objetos I - Semana 5