/**
 * TransaccionEntity.java
 */
package co.com.bancolombia.r2dbc.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table("transacciones")
public class TransaccionEntity {

    @Id
    private String id;

    @Column("cuenta_origen")
    private String cuentaOrigen;

    @Column("cuenta_destino")
    private String cuentaDestino;

    private BigDecimal monto;

    private String moneda;

    private String estado;

    private String descripcion;

    @Column("fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column("fecha_procesamiento")
    private LocalDateTime fechaProcesamiento;

    @Column("usuario_id")
    private String idUsuario;

    @Column("puntaje_fraude")
    private Double puntajeFraude;
}
