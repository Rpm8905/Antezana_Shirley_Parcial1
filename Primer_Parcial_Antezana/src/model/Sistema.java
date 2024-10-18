package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private List<Servicio> lstServicio;

    public Sistema() {
        this.lstServicio = new ArrayList<>();
    }

    //
    public Servicio traerServicio(String codServicio) {
        Servicio servicio = null;

        if (!lstServicio.isEmpty()) {
            for (Servicio serv : lstServicio) {
                if (serv.getCodServicio().equals(codServicio)) {
                    servicio = serv;
                    break;
                }
            }
        }

        return servicio;
    }

    //
    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> serviciosFiltrados = new ArrayList<>();
        if (!lstServicio.isEmpty()) {
            for (Servicio serv : lstServicio) {
                if (serv.isEnPromocion() == enPromocion);
                serviciosFiltrados.add(serv);
            }
        }
        return serviciosFiltrados;
    }
    // 

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> serviciosFiltrados = new ArrayList<>();
        if (!lstServicio.isEmpty()) {
            for (Servicio serv : lstServicio) {
                if (serv.isEnPromocion() == enPromocion);
                serviciosFiltrados.add(serv);
            }
        }
        return serviciosFiltrados;
    }

    //
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) {
        for (Servicio serv : lstServicio) {
            if (serv instanceof Gastronomia && serv.getCodServicio().equals(codServicio)) {
                throw new IllegalArgumentException("Ya existe el servicio de Gastronomia.");
            }
        }
        lstServicio.add(new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc));
        return true;
    }

    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) {
        for (Servicio serv : lstServicio) {
            if (serv instanceof Hospedaje && serv.getCodServicio().equals(codServicio)) {
                throw new IllegalArgumentException("Ya existe el servicio de Hospedaje.");
            }
        }
        lstServicio.add(new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche));
        return true;
    }

}
