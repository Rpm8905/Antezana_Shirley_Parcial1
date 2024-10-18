package test;

import java.time.LocalDate;
import java.util.List;
import model.*;

public class Main {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();

// Pruebas de Creación de Objetos
        System.out.println("1-1");
        try {
            Gastronomia gastronomia1= new Gastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            System.out.println("Gastronomia creada: " + gastronomia1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear Gastronomia: " + e.getMessage());
        }

        System.out.println("1-2");
        Gastronomia gastronomia2= new Gastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
        System.out.println("Gastronomia creada: " + gastronomia2);

        System.out.println("1-3");
        try {
            Hospedaje hospedaje1 = new Hospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
             System.out.println("Hospedaje creado: " + hospedaje1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear Hospedaje: " + e.getMessage());
        }

        System.out.println("1-4");
        Hospedaje hospedaje2 = new Hospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
        System.out.println("Hospedaje creado: " + hospedaje2);

        // Cálculo de Precios Finales
        System.out.println("2-1");
        double precioFinalGastronomia = gastronomia2.calcularPrecioFinal(LocalDate.of(2020, 10, 28));
        System.out.println("Precio final de Gastronomia: " + precioFinalGastronomia);

        System.out.println("2-2");
        double precioFinalHospedaje = hospedaje2.calcularPrecioFinal(LocalDate.of(2020, 10, 27));
        System.out.println("Precio final de Hospedaje: " + precioFinalHospedaje);

         // Agregar Servicios
        System.out.println("3");
        sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
        sistema.agregarHospedaje("489259", 10.0, true, "Habitación triple", 2200.0);
        sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
        sistema.agregarHospedaje("758972", 15.0, false, "Habitación simple", 1000.0);
    

        // Consultas de Servicios
        System.out.println("4-1");
        List<Servicio> enPromocion = sistema.traerServicio(true);
        System.out.println("Servicios en promoción:");
        for (Servicio servicio : enPromocion) {
            System.out.println(servicio);
        }

        System.out.println("4-2");
        List<Servicio> serviciosParaFecha = sistema.traerServicio(true, LocalDate.of(2020, 10, 28));
        System.out.println("Servicios en promoción para el día 2020-10-28:");
        for (Servicio servicio : serviciosParaFecha) {
            System.out.println(servicio);
        }
    }
}
