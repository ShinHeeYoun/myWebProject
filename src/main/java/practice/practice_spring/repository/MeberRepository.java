package practice.practice_spring.repository;

import practice.practice_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MeberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
/*
* Optional이란? Null을 반환할 가능성 때문에 감싸서 반환 받는 방법
* */