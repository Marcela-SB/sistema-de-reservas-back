package br.com.deart.sistemadereservasdeart.entregadechave;

import java.util.List;
import java.util.UUID;

public record KeyReturnBatchResponseDTO (
    List<UUID> successIds,
    List<KeyErrorDetail> errors) {
    
}
