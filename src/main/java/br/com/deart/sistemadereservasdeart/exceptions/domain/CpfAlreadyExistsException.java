package br.com.deart.sistemadereservasdeart.exceptions.domain;

import br.com.deart.sistemadereservasdeart.exceptions.base.ConflictException;

public class CpfAlreadyExistsException extends ConflictException {
    
    public CpfAlreadyExistsException() {
        super("CPF já cadastrado em outro usuário.");
    }

    public CpfAlreadyExistsException(String cpf) {
        super("CPF '" + cpf + "' já cadastrado em outro usuário.");
    }
    
}
