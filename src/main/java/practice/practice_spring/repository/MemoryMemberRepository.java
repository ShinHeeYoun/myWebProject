package practice.practice_spring.repository;

import practice.practice_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MeberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 0, 1, 2 같이 순서대로 올라가는

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // Optional.ofNullable --> null 반환 가능
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        // 루프를 돌면서 map에서 하나 일치하는 것 찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
