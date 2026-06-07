package br.com.deart.sistemadereservasdeart.exceptions;

import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.deart.sistemadereservasdeart.exceptions.base.HttpException;

/**
 * Centralizador de exceções da aplicação.
 * Captura exceções lançadas nos Services e as transforma em respostas JSON padronizadas.
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * Trata exceções personalizadas da aplicação que estendem HttpException.
     * @param ex A instância da exceção capturada.
     * @return Resposta HTTP com o status e a mensagem definidos na exceção.
     */
    @ExceptionHandler(HttpException.class)
    public ResponseEntity<Map<String, Object>> handleHttpException(HttpException ex) {
        return buildResponse(ex.getStatus(), ex.getMessage());
    }

    /**
     * Trata exceções genéricas e inesperadas (erros de runtime).
     * Evita a exposição de detalhes internos do servidor ao usuário final.
     * @param ex A exceção capturada.
     * @return Resposta HTTP 500 com uma mensagem genérica.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralErrors(Exception ex) {
        // ex.printStackTrace();    // para testes

        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro interno no servidor.");
    }


    /**
     * Constrói o corpo da resposta em formato JSON.
     * @param status O status HTTP desejado.
     * @param message A mensagem explicativa do erro.
     * @return Um ResponseEntity contendo o mapa de detalhes do erro.
     */
    private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", OffsetDateTime.now().toString());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", message);
        
        return ResponseEntity.status(status).body(body);
    }
}
