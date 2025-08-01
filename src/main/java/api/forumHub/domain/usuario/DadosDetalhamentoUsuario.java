package api.forumHub.domain.usuario;

public record DadosDetalhamentoUsuario(Long id, String email, String login) {

    public DadosDetalhamentoUsuario(Usuario autor) {
        this(autor.getId(), autor.getEmail(), autor.getLogin());
    }
}
