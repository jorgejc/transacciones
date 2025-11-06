package co.com.bancolombia.model.cuenta;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Cuenta {

    private String numeroCuenta;
    private String idUsuario;
    private String tipoCuenta;
    private BigDecimal saldo;
    private String moneda;
    private boolean activa;
}
