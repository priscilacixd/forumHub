package api.forumHub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String login,
        @NotBlank
        String senha,
        @NotBlank
        Perfil perfil
) {
}
