package api.forumHub.controller;

import api.forumHub.domain.resposta.*;
import api.forumHub.domain.usuario.Usuario;
import api.forumHub.domain.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("respostas")
public class RespostaController {

    @Autowired
    private RespostaRepository repository;

    @Autowired
    private RespostaService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarResposta(@RequestBody @Valid DadosCadastroResposta dados, UriComponentsBuilder uriBuilder, @AuthenticationPrincipal Usuario autor) {
        var resposta = service.criarResposta(dados, autor);
        var uri = uriBuilder.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoResposta(resposta));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemRespostas>> listarRespostas(@PageableDefault(size=10, sort={"solucao"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemRespostas ::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarResposta(@RequestBody @Valid DadosAtualizacaoResposta dados) {
        var resposta = repository.getReferenceById(dados.id());
        resposta.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoResposta(resposta));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirResposta (@PathVariable Long id) {
        var resposta = repository.getReferenceById(id);
        resposta.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@PathVariable Long id) {
        //depois que arrumar a autenticação tem que deixar somente admins (Exemplo) visualizar os topicos inativos
        var resposta = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoResposta(resposta));
    }

}
