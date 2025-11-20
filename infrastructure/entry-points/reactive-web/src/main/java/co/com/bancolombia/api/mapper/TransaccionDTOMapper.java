/**
 * TransaccionDTOMapper.java
 */
package co.com.bancolombia.api.mapper;

import co.com.bancolombia.api.dto.request.CrearTransaccionRequest;
import co.com.bancolombia.api.dto.response.TransaccionResponse;
import co.com.bancolombia.model.transaccion.Transaccion;

public class TransaccionDTOMapper {

    /**
     * Método encargado de convertir CrearTransaccionRequest -> Transaccion (Dominio model)
     * <br>
     * <b>Actividad 1:</b>
     *
     * @return
     * @author Jorge Armando Julio Cruz <jjulio@heinsohn.com.co>
     */
    public Transaccion toModel(CrearTransaccionRequest request) {
        return Transaccion.builder()
                .cuentaOrigen(request.cuentaOrigen())
                .cuentaDestino(request.cuentaDestino())
                .monto(request.monto())
                .moneda(request.moneda())
                .descripcion(request.descripcion())
                .idUsuario(request.idUsuario())
                .build();
    }

    /**
     * Método encargado de convertir Transaccion (modelo Dominio) -> TransaccionResponse
     * <br>
     * <b>Actividad 1:</b>
     *
     * @param transaccion
     * @return
     * @author Jorge Armando Julio Cruz <jjulio@heinsohn.com.co>
     */
    public TransaccionResponse toResponse(Transaccion transaccion) {
        return new TransaccionResponse(
                transaccion.getId(),
                transaccion.getCuentaOrigen(),
                transaccion.getCuentaDestino(),
                transaccion.getMonto(),
                transaccion.getMoneda(),
                transaccion.getEstado() != null ? transaccion.getEstado().name() : null,
                transaccion.getDescripcion(),
                transaccion.getFechaCreacion(),
                transaccion.getFechaProcesamiento(),
                transaccion.getIdUsuario(),
                transaccion.getPuntajeFraude()
        );
    }
}
