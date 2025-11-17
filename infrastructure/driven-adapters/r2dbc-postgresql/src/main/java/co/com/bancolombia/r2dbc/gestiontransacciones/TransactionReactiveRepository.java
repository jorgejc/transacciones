package co.com.bancolombia.r2dbc.gestiontransacciones;

import co.com.bancolombia.r2dbc.entity.TransaccionEntity;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

// TODO: This file is just an example, you should delete or modify it
public interface TransactionReactiveRepository extends
        ReactiveCrudRepository<TransaccionEntity, String>,
        ReactiveQueryByExampleExecutor<TransaccionEntity> {

    Flux<TransaccionEntity> findByUserId(String usuarioId);

    Flux<TransaccionEntity> findByStatus(String estado);
}
