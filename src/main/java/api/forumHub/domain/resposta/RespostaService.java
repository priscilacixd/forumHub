package api.forumHub.domain.resposta;

import api.forumHub.domain.topico.Topico;
import api.forumHub.domain.topico.TopicoRepository;
import api.forumHub.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public Resposta criarResposta(DadosCadastroResposta dados, Usuario autor) {
        Topico topico = topicoRepository.findById(dados.topicoId()).get();
        Resposta resposta = Resposta.builder()
                .mensagem(dados.mensagem())
                .topico(topico)
                .autor(autor)
                .ativo(true)
                .build();

        return respostaRepository.save(resposta);
    }
}
