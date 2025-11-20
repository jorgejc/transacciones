package co.com.bancolombia.api.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CrearTransaccionRequest(
    @NotBlank(message = "La cuenta de origen es requerida")
    @Size(min = 10, max = 20, message = "La cuenta de origen debe tener entre 10 y 20 caracteres")
    String cuentaOrigen,

    @NotBlank(message = "La cuenta de destino es requerida")
    @Size(min = 10, max = 20, message = "La cuenta de destino debe tener entre 10 y 20 caracteres")
    String cuentaDestino,

    @NotNull(message = "El monto es requerido")
    @DecimalMin(value = "1.00", message = "El monto deber mayor a cero")
    @DecimalMax(value = "10000000.00", message = "El monto no puede exceder los 10,000,000")
    BigDecimal monto,

    @NotBlank(message = "La moneda es requerida")
    @Pattern(regexp = "COP|USD|EUR", message = "La moneda debe ser COP, USD o EUR")
    String moneda,

    @Size(max = 255, message = "La descripción no puede exceder los 255 caracteres")
    String descripcion,

    @NotBlank(message = "El usuario es requerido")
    String idUsuario
) {
}
