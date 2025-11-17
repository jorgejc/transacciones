package co.com.bancolombia.r2dbc.gestioncuentas;

import co.com.bancolombia.model.cuenta.Cuenta;
import co.com.bancolombia.model.cuenta.gateways.CuentaRepository;
import co.com.bancolombia.r2dbc.entity.TransaccionEntity;
import co.com.bancolombia.r2dbc.helper.ReactiveAdapterOperations;
import co.com.bancolombia.r2dbc.mapper.CuentaMapper;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Repository
public class CuentaReactiveRepositoryAdapter extends ReactiveAdapterOperations
        <Cuenta, TransaccionEntity, String,CuentaReactiveRepository> implements CuentaRepository {
    public CuentaReactiveRepositoryAdapter(CuentaReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Cuenta.CuentaBuilder.class).build());
    }

    @Override
    public Mono<Cuenta> buscarPorNumeroCuenta(String numeroCuenta) {
        return repository.findById(numeroCuenta).map(CuentaMapper::toModel);
    }

    @Override
    public Mono<Cuenta> actualizarSaldo(String numeroCuenta, BigDecimal nuevoSaldo) {
        return null;
    }
}
