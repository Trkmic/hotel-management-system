package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private List<Servicio> lstServicio = new ArrayList<>();

    public List<Servicio> getLstServicio() {
        return lstServicio;
    }

    public Servicio traerServicio(String codServicio) {
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equals(codServicio)) {
                return servicio;
            }
        }
        throw new ServicioNoEncontradoException("No existe un servicio con el codigo que proporciono: " + codServicio);
    }

    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> resultado = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                resultado.add(servicio);
            }
        }
        return resultado;
    }

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> resultado = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion && servicio.getDia().equals(dia)) {
                resultado.add(servicio);
            }
        }
        return resultado;
    }

    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento,
            boolean enPromocion, LocalDate dia, String gastronomia, double precio, int diaSemDesc) {
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equals(codServicio)) {
                throw new ServicioDuplicadoException("No pueden existir dos servicios con el mismo codigo: " + codServicio);
            }
        }
        Gastronomia nuevagastronomia = new Gastronomia(codServicio, porcentajeDescuento, enPromocion, dia, gastronomia, precio, diaSemDesc);
        lstServicio.add(nuevagastronomia);
        return true;
    }

    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento,
            boolean enPromocion, LocalDate dia, String hospedaje, double precioPorNoche, int diasDeHospedaje) {
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equals(codServicio)) {
                throw new ServicioDuplicadoException("No pueden existir dos servicios con el mismo codigo: " + codServicio);
            }
        }
        Hospedaje nuevohospedaje = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, dia, hospedaje, precioPorNoche, diasDeHospedaje);
        lstServicio.add(nuevohospedaje);
        return true;
    }

    @Override
    public String toString() {
        return "Sistema{" + "lstServicio=" + lstServicio + '}';
    }

}
