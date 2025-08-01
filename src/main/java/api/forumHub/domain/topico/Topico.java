package api.forumHub.domain.topico;

import api.forumHub.domain.curso.Curso;
import api.forumHub.domain.resposta.Resposta;
import api.forumHub.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Spring Data JPA
@Entity(name = "Topico")
@Table(name = "topicos")

//Lombok
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;

    @Builder.Default
    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Status status = Status.SEM_RESPOSTA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @JsonIgnore
    @Builder.Default
    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas = new ArrayList<>();

    private boolean ativo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    public void atualizarInformacoes(@Valid DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.status() != null) {
            this.status = dados.status();
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
