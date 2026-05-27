package Model;

import java.time.LocalDate;

public abstract class Servicio {

    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;
    protected LocalDate dia;

    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion, LocalDate dia) {
        setCodServicio(codServicio);
        setPorcentajeDescuento(porcentajeDescuento);
        setDia(dia);
        this.enPromocion = enPromocion;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        if (dia == null) {
            throw new IllegalArgumentException("El dia no puede ser nulo.");
        }
        this.dia = dia;
    }

    public String getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(String codServicio) {
        if (codServicio == null || codServicio.length() != 6) {
            throw new CodigoInvalidoException("El codigo debe tener 6 caracteres unicos!");
        }
        this.codServicio = codServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException("El porcentaje de descuento debe estar entre 0 y 100.");
        }
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    public void setEnPromocion(boolean enPromocion) {
        this.enPromocion = enPromocion;
    }

    public abstract double calcularPrecioFinal(LocalDate dia);

    @Override
    public String toString() {
        return "Servicio{" + "codServicio=" + codServicio + ", porcentajeDescuento=" + porcentajeDescuento + ", enPromocion=" + enPromocion + ", dia=" + dia + '}';
    }

}
