package com.rubypaper.board.persistence;

import com.rubypaper.board.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {

}
