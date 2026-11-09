package br.com.deart.sistemadereservasdeart.entregadechave;

import java.util.List;
import java.util.UUID;


public record KeyReturnBatchRequestDTO(
    UUID keyReturnedById,
    String returnTime,
    List<UUID> keyIds
) {}
