package projeto.carrinhoCompra.exception.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiValidationError {

    private String campo;
    private Object valor;
    private String mensagem;
}
