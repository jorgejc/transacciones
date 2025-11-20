package co.com.bancolombia.api.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransaccionResponse(
        String id,
        String cuentaOrigen,
        String cuentaDestino,
        BigDecimal monto,
        String moneda,
        String estado,
        String descripcion,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaProcesamiento,
        String idUsuario,
        Double puntajeFraude
) {}
