package co.com.bancolombia.r2dbc.gestioncuentas;

import co.com.bancolombia.r2dbc.entity.TransaccionEntity;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

// TODO: This file is just an example, you should delete or modify it
public interface CuentaReactiveRepository extends
        ReactiveCrudRepository<TransaccionEntity, String>,
        ReactiveQueryByExampleExecutor<TransaccionEntity> {

    Mono<TransaccionEntity> findById(String numeroCuenta);
}
