package api.forumHub.domain.resposta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RespostaRepository extends JpaRepository<Resposta, Long> {


    Page<Resposta> findAllByAtivoTrue(Pageable paginacao);
}
