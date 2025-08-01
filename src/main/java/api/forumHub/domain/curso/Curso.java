package api.forumHub.domain.curso;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

//Spring Data JPA
@Entity(name = "Curso")
@Table(name = "cursos")

//Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private boolean ativo;

    public Curso(DadosCadastroCurso dados) {
        this.nome = dados.nome();
        this.categoria = dados.categoria();
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoCurso dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.categoria() != null) {
            this.categoria = dados.categoria();
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
