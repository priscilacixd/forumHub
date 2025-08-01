package api.forumHub.domain.topico;

import api.forumHub.domain.curso.DadosCurso;
import api.forumHub.domain.resposta.DadosDetalhamentoResposta;
import api.forumHub.domain.usuario.DadosDetalhamentoUsuario;

import java.time.LocalDateTime;
import java.util.List;

public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem,
                                      LocalDateTime dataCriacao,
                                      Status status,
                                      DadosCurso curso,
                                      List<DadosDetalhamentoResposta> respostas,
                                      DadosDetalhamentoUsuario autor) {

    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(),
                new DadosCurso(topico.getCurso()),
                topico.getRespostas().stream()
                        .map(DadosDetalhamentoResposta::new)
                        .toList()
                ,new DadosDetalhamentoUsuario(topico.getAutor()));
    }

}
