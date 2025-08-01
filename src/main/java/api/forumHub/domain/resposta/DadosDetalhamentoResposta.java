package api.forumHub.domain.resposta;

import api.forumHub.domain.usuario.DadosDetalhamentoUsuario;

import java.time.LocalDateTime;

public record DadosDetalhamentoResposta(

        Long id,
        String mensagem,
        LocalDateTime dataCriacao,
        boolean solucao,
        DadosDetalhamentoUsuario autor
) {
    public DadosDetalhamentoResposta(Resposta resposta) {
        this(resposta.getId(), resposta.getMensagem(), resposta.getDataCriacao(), resposta.isSolucao(), new DadosDetalhamentoUsuario(resposta.getAutor()));
    }
}
