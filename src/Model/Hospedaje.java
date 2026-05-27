package Model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Hospedaje extends Servicio {

    private String hospedaje;
    private double precioPorNoche;
    private int diasDeHospedaje;

    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, LocalDate dia, String hospedaje, double precioPorNoche, int diasDeHospedaje) {
        super(codServicio, porcentajeDescuento, enPromocion, dia);
        setHospedaje(hospedaje);
        setPrecioPorNoche(precioPorNoche);
        setDiasDeHospedaje(diasDeHospedaje);
    }

    public String getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(String hospedaje) {
        if (hospedaje == null || hospedaje.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del hospedaje no puede estar vacio.");
        }
        this.hospedaje = hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        if (precioPorNoche < 0) {
            throw new IllegalArgumentException("El precio por noche no puede ser negativo.");
        }
        this.precioPorNoche = precioPorNoche;
    }

    public int getDiasDeHospedaje() {
        return diasDeHospedaje;
    }

    public void setDiasDeHospedaje(int diasDeHospedaje) {
        if (diasDeHospedaje < 1) {
            throw new IllegalArgumentException("La cantidad de dias de hospedaje debe ser al menos 1.");
        }
        this.diasDeHospedaje = diasDeHospedaje;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = precioPorNoche * diasDeHospedaje;
        DayOfWeek diaDeSemana = dia.getDayOfWeek();

        if (isEnPromocion()) {
            if (diaDeSemana != DayOfWeek.SATURDAY && diaDeSemana != DayOfWeek.SUNDAY) {
                double descuento = porcentajeDescuento / 100;
                precioFinal *= (1 - descuento);
            }
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Hospedaje{" + "codServicio=" + codServicio + ", porcentajeDescuento=" + porcentajeDescuento + ", enPromocion=" + enPromocion + ", dia=" + dia + ", hospedaje=" + hospedaje + ", precioPorNoche=" + precioPorNoche + ", diasDeHospedaje=" + diasDeHospedaje + '}';
    }

}
