package co.com.bancolombia.r2dbc.gestiontransacciones;

import co.com.bancolombia.model.transaccion.Transaccion;
import co.com.bancolombia.model.transaccion.gateways.TransaccionRepository;
import co.com.bancolombia.r2dbc.entity.TransaccionEntity;
import co.com.bancolombia.r2dbc.helper.ReactiveAdapterOperations;
import co.com.bancolombia.r2dbc.mapper.TransaccionMapper;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class TransactionReactiveRepositoryAdapter extends ReactiveAdapterOperations
        <Transaccion, TransaccionEntity, String, TransactionReactiveRepository > implements TransaccionRepository {
    public TransactionReactiveRepositoryAdapter(TransactionReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Transaccion.TransaccionBuilder.class).build());
    }

    @Override
    public Mono<Transaccion> guardar(Transaccion transaccion) {
        return super.save(transaccion);
    }

    @Override
    public Mono<Transaccion> buscarPorId(String id) {
        return repository.findById(id)
                .map(TransaccionMapper::toModel);
    }

    @Override
    public Flux<Transaccion> buscarPorIdUsuario(String idUsuario) {
        return repository.findByUserId(idUsuario)
                .map(TransaccionMapper::toModel);
    }

    @Override
    public Flux<Transaccion> buscarPorEstado(String estado) {
        return repository.findByStatus(estado)
                .map(TransaccionMapper::toModel);
    }

    @Override
    public Mono<Transaccion> actualizar(Transaccion transaccion) {
        return super.save(transaccion);
    }

    @Override
    public Mono<Void> eliminarPorId(String id) {
        return repository.deleteById(id);
    }
}
