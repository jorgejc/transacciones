/**
 * TransaccionMapper.java
 */
package co.com.bancolombia.r2dbc.mapper;

import co.com.bancolombia.model.estadotransaccion.EstadoTransaccion;
import co.com.bancolombia.model.transaccion.Transaccion;
import co.com.bancolombia.r2dbc.entity.TransaccionEntity;

public class TransaccionMapper {

    /**
     * Método encargado de convertir el modelo de Dominio (Transacción) al modelo de persistencia (TransaccionEntity).
     * Esto ocurre cuando la aplicación necesita guardar datos en la BD
     * <br>
     * <b>HU1:</b> Crear Transacción
     *
     * @param transaccion
     * @return
     * @author Jorge Armando Julio Cruz <jjulio@heinsohn.com.co>
     */
    public static TransaccionEntity toEntity(Transaccion transaccion) {
        if (transaccion == null) return null;

        return TransaccionEntity.builder()
                .id(transaccion.getId())
                .cuentaOrigen(transaccion.getCuentaOrigen())
                .cuentaDestino(transaccion.getCuentaDestino())
                .monto(transaccion.getMonto())
                .moneda(transaccion.getMoneda())
                .estado(transaccion.getEstado() != null ? transaccion.getEstado().name() : null)
                .descripcion(transaccion.getDescripcion())
                .fechaCreacion(transaccion.getFechaCreacion())
                .fechaProcesamiento(transaccion.getFechaProcesamiento())
                .idUsuario(transaccion.getIdUsuario())
                .puntajeFraude(transaccion.getPuntajeFraude())
                .build();
    }

    public static Transaccion toModel(TransaccionEntity entity) {
        if (entity == null) return null;

        return Transaccion.builder()
                .id(entity.getId())
                .cuentaOrigen(entity.getCuentaOrigen())
                .cuentaDestino(entity.getCuentaDestino())
                .monto(entity.getMonto())
                .moneda(entity.getMoneda())
                .estado(entity.getEstado() != null ? EstadoTransaccion.valueOf(entity.getEstado()) : null)
                .descripcion(entity.getDescripcion())
                .fechaCreacion(entity.getFechaCreacion())
                .fechaProcesamiento(entity.getFechaProcesamiento())
                .idUsuario(entity.getIdUsuario())
                .puntajeFraude(entity.getPuntajeFraude())
                .build();
    }

}
