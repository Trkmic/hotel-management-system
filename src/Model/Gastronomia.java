package Model;

import java.time.LocalDate;

public class Gastronomia extends Servicio {

    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, LocalDate dia, String gastronomia, double precio, int diaSemDesc) {
        super(codServicio, porcentajeDescuento, enPromocion, dia);
        setGastronomia(gastronomia);
        setPrecio(precio);
        setDiaSemDesc(diaSemDesc);
    }

    public String getGastronomia() {
        return gastronomia;
    }

    public void setGastronomia(String gastronomia) {
        if (gastronomia == null || gastronomia.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la gastronomia no puede estar vacio.");
        }
        this.gastronomia = gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }

    public void setDiaSemDesc(int diaSemDesc) {
        if (diaSemDesc < 1 || diaSemDesc > 7) {
            throw new IllegalArgumentException("El dia de la semana de descuento debe estar entre 1 (Lunes) y 7 (Domingo).");
        }
        this.diaSemDesc = diaSemDesc;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = precio;

        if (isEnPromocion() && dia.getDayOfWeek().getValue() == this.diaSemDesc) {
            double descuento = porcentajeDescuento / 100;
            precioFinal = precioFinal * (1 - descuento);
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Gastronomia{" + "codServicio=" + codServicio + ", porcentajeDescuento=" + porcentajeDescuento + ", enPromocion=" + enPromocion + ", dia=" + dia + ", gastronomia=" + gastronomia + ", precio=" + precio + ", diaSemDesc=" + diaSemDesc + '}';
    }

}
