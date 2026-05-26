package com.microservicio.pagos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VentaRequest {
    private Pago pago;
    private Long productId;
    private Integer cantidad; // cantidad a restar; si es null se resta 1
}
