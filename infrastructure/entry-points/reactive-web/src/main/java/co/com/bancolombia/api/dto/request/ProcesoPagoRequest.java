package co.com.bancolombia.api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ProcesoPagoRequest(
        @NotBlank(message = "El id de la transacción es requerido")
        String id
) {
}
