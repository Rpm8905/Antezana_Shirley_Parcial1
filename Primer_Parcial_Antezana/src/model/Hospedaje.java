package model;

import java.time.LocalDate;

public class Hospedaje extends Servicio {

    private String hospedaje;
    private double precioPorNoche;

    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws IllegalArgumentException {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    public String getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(String hospedaje) {
        this.hospedaje = hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public String getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(String codServicio) {
        this.codServicio = codServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    public void setEnPromocion(boolean enPromocion) {
        this.enPromocion = enPromocion;
    }

    @Override
    public String toString() {
        return "Hospedaje{" + "hospedaje=" + hospedaje + ", precioPorNoche=" + precioPorNoche + '}';
    }

    // aplica descuento de lunes a viernes si esta en promocion
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = precioPorNoche;
        if (enPromocion && dia.getDayOfWeek().getValue() < 6) {
            precioFinal -= precioFinal * (porcentajeDescuento / 100);

        }

        return precioFinal;

    }

}
