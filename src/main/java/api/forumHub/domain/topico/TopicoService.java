package api.forumHub.domain.topico;

import api.forumHub.domain.curso.Curso;
import api.forumHub.domain.curso.CursoRepository;
import api.forumHub.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Topico criarTopico (DadosCadastroTopico dados, Usuario autor) {
        Curso curso = cursoRepository.findById(dados.cursoId()).get();
        Topico topico = Topico.builder()
                .titulo(dados.titulo())
                .mensagem(dados.mensagem())
                .curso(curso)
                .autor(autor)
                .ativo(true)
                .build();

        return topicoRepository.save(topico);
    }
}
