package api.forumHub.domain.topico;

import api.forumHub.domain.usuario.DadosDetalhamentoUsuario;

import java.time.LocalDateTime;

public record DadosListagemTopicos(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, DadosDetalhamentoUsuario autor) {

    public DadosListagemTopicos (Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(),
                new DadosDetalhamentoUsuario(topico.getAutor()));
    }
}
