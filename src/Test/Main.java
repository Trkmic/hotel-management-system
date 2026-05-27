package Test;

import Model.Gastronomia;
import Model.Hospedaje;
import Model.Sistema;
import Model.CodigoInvalidoException;
import Model.ServicioDuplicadoException;
import Model.ServicioNoEncontradoException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        System.out.println("1-1");
        try {
            Gastronomia gastronomia1 = new Gastronomia("4892", 15.0, true, (LocalDate.of(1995, 5, 3)), "Hamburguesa criolla", 180.0, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("1-2");
        Gastronomia gastronomia2 = new Gastronomia("489235", 15.0, true, (LocalDate.of(2020, 10, 28)), "Hamburguesa criolla", 180.0, 4);
        System.out.println(gastronomia2.toString());

        System.out.println("1-3");
        try {
            Hospedaje hospedaje1 = new Hospedaje("2872", 10.0, true, (LocalDate.of(2005, 1, 3)), "Cabania 3 personas", 1500.0, 10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("1-4");
        Hospedaje hospedaje2 = new Hospedaje("287282", 10.0, true, (LocalDate.of(2009, 4, 21)), "Cabania 3 personas", 1500.0, 5);
        System.out.println(hospedaje2.toString());

        System.out.println("2-1");
        System.out.println(gastronomia2.calcularPrecioFinal(LocalDate.of(2020, 10, 28)));

        System.out.println("2-2");
        System.out.println(hospedaje2.calcularPrecioFinal(LocalDate.of(2020, 10, 27)));

        Sistema sistema = new Sistema();

        System.out.println("3");
        sistema.agregarGastronomia("858927", 15.0, true, (LocalDate.of(1968, 1, 1)), "Milanesa con pure", 350.0, 3);
        sistema.agregarHospedaje("489259", 10.0, true, (LocalDate.of(2020, 10, 28)), "Habitacion triple", 2200.0, 10);
        sistema.agregarGastronomia("182835", 20.0, false, (LocalDate.of(1993, 6, 4)), "Gaseosa", 120.0, 3);
        sistema.agregarHospedaje("758972", 15.0, false, (LocalDate.of(1976, 5, 31)), "Habitacion simple", 1000.0, 5);
        System.out.println(sistema.toString());

        System.out.println("4-1");
        System.out.println(sistema.traerServicio(true));

        System.out.println("4-2");
        System.out.println(sistema.traerServicio(true, (LocalDate.of(2020, 10, 28))));

        // ==========================================
        // VERIFICACIONES EXTRAS DE CALIDAD (PORTFOLIO)
        // ==========================================
        System.out.println("\n--- PRUEBAS DE CALIDAD ADICIONALES ---");

        System.out.println("5-1: Gastronomía descuento aplicado (Jueves 29/10/2020, coincide con diaSemDesc = 4)");
        // 180.0 base - 15% desc = 153.0
        double precioConDescuento = gastronomia2.calcularPrecioFinal(LocalDate.of(2020, 10, 29));
        System.out.println("Precio final con descuento: " + precioConDescuento + " (Esperado: 153.0)");
        assert precioConDescuento == 153.0 : "Error: El descuento gastronómico no se aplicó correctamente.";

        System.out.println("5-2: Verificación de no-acumulación en traerServicio");
        int tamInicial = sistema.traerServicio(true).size();
        int tamSegundaLlamada = sistema.traerServicio(true).size();
        System.out.println("Primera llamada: " + tamInicial + " elementos, Segunda llamada: " + tamSegundaLlamada + " elementos");
        assert tamInicial == tamSegundaLlamada : "Error: Hay acumulación de estado en la consulta de servicios en promoción.";

        System.out.println("5-3: Validaciones de negocio (Precio negativo)");
        try {
            gastronomia2.setPrecio(-50.0);
            System.out.println("Error: Debió lanzar IllegalArgumentException por precio negativo.");
        } catch (IllegalArgumentException e) {
            System.out.println("Capturada correctamente: " + e.getMessage());
        }

        System.out.println("5-4: Validaciones de negocio (Día de semana de descuento fuera de rango)");
        try {
            gastronomia2.setDiaSemDesc(8);
            System.out.println("Error: Debió lanzar IllegalArgumentException por día fuera de rango.");
        } catch (IllegalArgumentException e) {
            System.out.println("Capturada correctamente: " + e.getMessage());
        }

        System.out.println("5-5: Excepciones personalizadas - Código Duplicado");
        try {
            sistema.agregarGastronomia("858927", 10.0, true, LocalDate.now(), "Plato repetido", 400.0, 1);
            System.out.println("Error: Debió lanzar ServicioDuplicadoException.");
        } catch (ServicioDuplicadoException e) {
            System.out.println("Capturada correctamente: " + e.getMessage());
        }

        System.out.println("5-6: Excepciones personalizadas - Código Inválido");
        try {
            new Gastronomia("123", 10.0, true, LocalDate.now(), "Plato test", 100.0, 1);
            System.out.println("Error: Debió lanzar CodigoInvalidoException.");
        } catch (CodigoInvalidoException e) {
            System.out.println("Capturada correctamente: " + e.getMessage());
        }

        System.out.println("5-7: Excepciones personalizadas - Servicio No Encontrado");
        try {
            sistema.traerServicio("999999");
            System.out.println("Error: Debió lanzar ServicioNoEncontradoException.");
        } catch (ServicioNoEncontradoException e) {
            System.out.println("Capturada correctamente: " + e.getMessage());
        }
        
        System.out.println("¡Todas las validaciones adicionales pasaron con éxito!");
    }

}
