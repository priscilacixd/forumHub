package api.forumHub.domain.topico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico (

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
        Long cursoId

){
}
