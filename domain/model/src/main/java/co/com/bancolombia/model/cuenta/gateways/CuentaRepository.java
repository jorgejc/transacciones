package co.com.bancolombia.model.cuenta.gateways;

import co.com.bancolombia.model.cuenta.Cuenta;
import reactor.core.publisher.Mono;

public interface CuentaRepository {

    Mono<Cuenta> buscarPorNumeroCuenta(String numeroCuenta);
    Mono<Cuenta> actualizarSaldo(String numeroCuenta, java.math.BigDecimal nuevoSaldo);
}
