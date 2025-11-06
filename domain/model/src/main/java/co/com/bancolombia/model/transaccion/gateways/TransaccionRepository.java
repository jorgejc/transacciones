package co.com.bancolombia.model.transaccion.gateways;

import co.com.bancolombia.model.transaccion.Transaccion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransaccionRepository {

    Mono<Transaccion> guardar(Transaccion transaccion);
    Mono<Transaccion> buscarPorId(String id);
    Flux<Transaccion> buscarPorIdUsuario(String idUsuario);
    Flux<Transaccion> buscarPorEstado(String estado);
    Mono<Transaccion> actualizar(Transaccion transaccion);
    Mono<Transaccion> eliminarPorId(String id);

}
