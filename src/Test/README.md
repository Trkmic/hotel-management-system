# 🏨 Sistema de Servicios de Hospedaje y Gastronomía

---

## Alumno
**Nombre del alumno**: Ignacio Trkmic Torres

## 📄 Descripción del Proyecto

Este proyecto es un sistema de gestión diseñado para servicios de hospedaje y gastronomía, implementando conceptos de Programación Orientada a Objetos (POO) en Java. El objetivo es crear una aplicación que permita gestionar estos servicios, calcular precios finales con promociones, y validar atributos mediante excepciones cuando sea necesario.

### Objetivos
- Implementar un modelo orientado a objetos que refleje la gestión de servicios de hospedaje y gastronomía.
- Aplicar promociones y descuentos de forma dinámica.
- Validar la integridad de los datos utilizando excepciones adecuadas.

## 🛠️ Funcionalidades del Sistema

El sistema ofrece las siguientes funcionalidades:

### 1. Gestión de Hospedaje
- **Tipos de Habitaciones**: Administración de habitaciones estándar y deluxe.
- **Servicios Adicionales**: Opción de agregar servicios de limpieza y desayuno.
- **Aplicación de Descuentos**: Descuentos aplicables según la duración de la estadía.

### 2. Gestión de Gastronomía
- **Menús**: Posibilidad de agregar diferentes tipos de menús para los servicios de alimentación.
- **Cálculo de Precios**: Precios ajustables con descuentos según el tipo de comida y el día de la semana.

### 3. Promociones y Descuentos
- Implementación de promociones para estadías prolongadas.
- Penalizaciones por no cumplir con los requisitos establecidos, como el número mínimo de noches.

### 4. Validaciones
- Manejo de excepciones para situaciones como códigos duplicados, valores inválidos, y violaciones de las restricciones de negocio.

### 5. Cálculo de Precio Final
- Método para calcular el precio final del servicio, que incluye todas las promociones y servicios adicionales seleccionados.

## 📦 Estructura del Proyecto

El proyecto está compuesto por las siguientes clases y subclases:

### 1. **Servicio** (Clase Abstracta)
- **Atributos**:
   - `codigo`: Código del servicio.
   - `nombre`: Nombre del servicio.
   - `precioBase`: Precio base del servicio.
   - `*NUEVO(AGREGADO POR EL ALUMNO)*` dia: LocalDate, indica que dia se adquirio el servicio.

- **Métodos Abstractos**:
   - `calcularPrecioFinal()`: Método que debe ser implementado en las subclases para calcular el precio final del servicio.

### 2. **Hospedaje** (Subclase de Servicio)
- **Atributos Específicos**:
   - `numeroNoches`: Número de noches reservadas.
   - `servicioLimpieza`: Indica si se incluye el servicio de limpieza.
   - `desayuno`: Indica si se incluye el desayuno.
   - `tarifaExtra`: Tarifa adicional por servicios extras.
   - `promociones`: Lista de promociones aplicables.
   - `*NUEVO(AGREGADO POR EL ALUMNO)*` diasDeHospedaje: Entero el cual indica el dia total que se hospedo el individuo.
- **Métodos**:
   - `calcularPrecioTotal()`: Calcula el precio total basado en el número de noches, promociones y servicios adicionales.

### 3. **Gastronomía** (Subclase de Servicio)
- **Atributos Específicos**:
   - `tipoMenu`: Tipo de menú seleccionado (desayuno, almuerzo, cena).
   - `diaSemana`: Día de la semana en que se solicita el servicio.
   - `aplicaDescuento`: Indica si se aplica un descuento.
- **Métodos**:
   - `calcularPrecioFinal()`: Calcula el precio final de acuerdo con el menú y las promociones disponibles.
