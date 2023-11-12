package projeto.carrinhoCompra.exception.error;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ApiError {
    private Integer codigoErro;
    private HttpStatus statusErro;
    private String mensagem;
    private List<ApiValidationError> subErros = new ArrayList<>();


    private LocalDateTime timestamp;

    public void addSubErrors(ApiValidationError error) {
        this.subErros.add(error);
    }
}
