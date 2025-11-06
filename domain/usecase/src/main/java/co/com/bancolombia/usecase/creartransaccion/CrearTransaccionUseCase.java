package co.com.bancolombia.usecase.creartransaccion;

import co.com.bancolombia.model.estadotransaccion.EstadoTransaccion;
import co.com.bancolombia.model.transaccion.Transaccion;
import co.com.bancolombia.model.transaccion.gateways.TransaccionRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
public class CrearTransaccionUseCase {

    private final TransaccionRepository transaccionRepository;

    public Mono<Transaccion> crearTransaccion(Transaccion transaccion) {
        return Mono.just(transaccion)
                .map(this::enriquecerTransaccion)
                .flatMap(transaccionRepository::guardar)
                .doOnSuccess(t ->System.out.println("Transacción creada: " + t.getId()))
                .doOnError(e -> System.err.println("Error cuando la transacción: " + e.getMessage()));
    }

    public Mono<Transaccion> obtenerPorId(String id) {
        return transaccionRepository.buscarPorId(id);
    }

    public Flux<Transaccion> obtenerPorEstado(String estado) {
        return transaccionRepository.buscarPorEstado(estado);
    }

    private Transaccion enriquecerTransaccion(Transaccion transaccion) {
        return transaccion.toBuilder()
                .id(UUID.randomUUID().toString())
                .estado(EstadoTransaccion.PENDIENTE)
                .fechaCreacion(LocalDateTime.now())
                .build();
    }
}
