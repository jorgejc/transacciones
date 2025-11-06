package co.com.bancolombia.usecase.procesopago;

import co.com.bancolombia.model.cuenta.gateways.CuentaRepository;
import co.com.bancolombia.model.estadotransaccion.EstadoTransaccion;
import co.com.bancolombia.model.exception.TransactionException;
import co.com.bancolombia.model.transaccion.Transaccion;
import co.com.bancolombia.model.transaccion.gateways.TransaccionRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class ProcesoPagoUseCase {

    private final TransaccionRepository transaccionRepository;
    private final CuentaRepository cuentaRepository;

    public Mono<Transaccion> procesarPago(String idTransaccion) {
        return transaccionRepository.buscarPorId(idTransaccion)
                .flatMap(this::ejecutarPago)
                .flatMap(transaccionRepository::actualizar)
                .doOnSuccess(t -> System.out.println("Pago procesado: " + t.getId()))
                .doOnError(e -> manejarErrorPago(idTransaccion, e));
    }

    private Mono<Transaccion> ejecutarPago(Transaccion transaccion) {
        if (transaccion.getEstado() != EstadoTransaccion.VALIDANDO) {
            return Mono.error(new TransactionException("La transacción debe estar en estado VALIDANDO para ser procesada"));
        }

        return actualizarSaldosCuenta(transaccion)
                .thenReturn(transaccion.toBuilder()
                        .estado(EstadoTransaccion.COMPLETADA)
                        .fechaProcesamiento(LocalDateTime.now())
                        .build());
    }

    private Mono<Void> actualizarSaldosCuenta(Transaccion transaccion) {
        Mono<Void> debitarOrigen = cuentaRepository
                .buscarPorNumeroCuenta(transaccion.getCuentaOrigen())
                .flatMap(cuenta -> cuentaRepository.actualizarSaldo(
                        cuenta.getNumeroCuenta(),
                        cuenta.getSaldo().subtract(transaccion.getMonto())
                ))
                .then();

        Mono<Void> acreditarDestino = cuentaRepository
                .buscarPorNumeroCuenta(transaccion.getCuentaDestino())
                .flatMap(cuenta -> cuentaRepository.actualizarSaldo(cuenta.getNumeroCuenta(),
                        cuenta.getSaldo().add(transaccion.getMonto())
                ))
                .then();

        return debitarOrigen.then(acreditarDestino);
    }

    private void manejarErrorPago(String idTransaccion, Throwable error) {
        System.err.println("Error procesando pago para la transacción: " + idTransaccion + ". Causa: " + error.getMessage());
    }
}
