/**
 * TransaccionEntity.java
 */
package co.com.bancolombia.r2dbc.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table("cuentas")
public class CuentaEntity {

    @Id
    @Column("numero_cuenta")
    private String numeroCuenta;

    @Column("usuario_id")
    private String idUsuario;

    @Column("tipo_cuenta")
    private String tipoCuenta;

    private BigDecimal saldo;

    private String moneda;

    private boolean activa;
}
