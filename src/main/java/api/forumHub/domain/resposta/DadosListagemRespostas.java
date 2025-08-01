package api.forumHub.domain.resposta;

import api.forumHub.domain.usuario.DadosDetalhamentoUsuario;

public record DadosListagemRespostas(Long id, DadosDetalhamentoUsuario autor, boolean solucao, String mensagem) {

    public DadosListagemRespostas(Resposta resposta) {
        this(resposta.getId(), new DadosDetalhamentoUsuario(resposta.getAutor()), resposta.isSolucao(), resposta.getMensagem());
    }
}
