package model;

import java.time.LocalDate;

public class Gastronomia extends Servicio {

    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws IllegalArgumentException {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

    public String getGastronomia() {
        return gastronomia;
    }

    public void setGastronomia(String gastronomia) {
        this.gastronomia = gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }

    public void setDiaSemDesc(int diaSemDesc) {
        this.diaSemDesc = diaSemDesc;
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
        return "Gastronomia{" + "gastronomia=" + gastronomia + ", precio=" + precio + ", diaSemDesc=" + diaSemDesc + '}';
    }

    // aplica el porcentaje de descuento si esta en promocion
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = precio;
        if (enPromocion && dia.getDayOfWeek().getValue() == diaSemDesc) {
            precioFinal -= precioFinal * (porcentajeDescuento / 100);
            
        }

        return precioFinal;

    }

}
