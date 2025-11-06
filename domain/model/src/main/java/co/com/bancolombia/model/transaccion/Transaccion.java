package co.com.bancolombia.model.transaccion;
import co.com.bancolombia.model.estadotransaccion.EstadoTransaccion;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Transaccion {

    private String id;
    private String cuentaOrigen;
    private String cuentaDestino;
    private BigDecimal monto;
    private String moneda;
    private EstadoTransaccion estado;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaProcesamiento;
    private String idUsuario;
    private Double puntajeFraude;
}
