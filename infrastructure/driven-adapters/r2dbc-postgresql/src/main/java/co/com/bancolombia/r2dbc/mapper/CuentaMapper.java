/**
 * CuentaMapper.java
 */
package co.com.bancolombia.r2dbc.mapper;

import co.com.bancolombia.model.cuenta.Cuenta;
import co.com.bancolombia.r2dbc.entity.TransaccionEntity;

/**
 * <b>Descripción:</b> Clase que utiliza las utilidades para la conversión de modelos
 * <br>
 * <b>HU1:</b> Crear Transacción
 *
 * @author Jorge Armando Julio Cruz <jjulio@heinsohn.com.co>
 */
public class CuentaMapper {

    /**
     * Método encargado de convertir el modelo de Dominio (Transaccion) al modelo de persistencia (TransaccionEntity).
     * Esto ocurre cuando se guardan o actualizan datos en la BD (al actualizar un saldo)
     * <br>
     * <b>HU1:</b> Crear Transacción
     *
     * @param cuenta
     * @return
     * @author Jorge Armando Julio Cruz <jjulio@heinsohn.com.co>
     */
    public static TransaccionEntity toEntity(Cuenta cuenta) {
        if (cuenta == null) return null;

        return TransaccionEntity.builder()
                .numeroCuenta(cuenta.getNumeroCuenta())
                .idUsuario(cuenta.getIdUsuario())
                .tipoCuenta(cuenta.getTipoCuenta())
                .saldo(cuenta.getSaldo())
                .moneda(cuenta.getMoneda())
                .activa(cuenta.isActiva())
                .build();
    }

    /**
     * Método encargado de convertir el modelo de persistencia (TransaccionEntity) al modelo de dominio (Transaccion).
     * Esto ocurre cuando se recuperan datos de la BD
     * <br>
     * <b>HU1:</b> Crear Transacción
     *
     * @param entity
     * @return
     * @author Jorge Armando Julio Cruz <jjulio@heinsohn.com.co>
     */
    public static Cuenta toModel(TransaccionEntity entity) {
        if (entity == null) return null;

        return Cuenta.builder()
                .numeroCuenta(entity.getNumeroCuenta())
                .idUsuario(entity.getIdUsuario())
                .tipoCuenta(entity.getTipoCuenta())
                .saldo(entity.getSaldo())
                .moneda(entity.getMoneda())
                .activa(entity.isActiva())
                .build();
    }

}
