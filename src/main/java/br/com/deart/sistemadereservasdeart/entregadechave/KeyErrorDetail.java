package br.com.deart.sistemadereservasdeart.entregadechave;

import java.util.UUID;

public record KeyErrorDetail (
    UUID keyId,
    String message
) {}
