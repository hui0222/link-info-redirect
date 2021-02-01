package kr.co.lir.repository;

import kr.co.lir.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {

    Board findByid(Long id);
    //void deleteById(Long id);
}
