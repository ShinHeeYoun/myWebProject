package practice.practice_spring.service;

import practice.practice_spring.domain.Member;
import practice.practice_spring.repository.MeberRepository;
import practice.practice_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    // 서비스를 만드려면 레포지토리 필요
    private final MeberRepository memberRepository = new MemoryMemberRepository();

    // 회원가입
    public Long join(Member member) {
        // 같은 이름이 있는 중복회원이 있으면 안된다면?
        // Optional<Member> result = memberRepository.findByName(member.getName()); // 옵셔널 바로 반환은 권장 X
        ValidateExtract(member);

        memberRepository.save(member);
        return member.getId();
        
        //memberRepository.findByName(member.getName()); 에서 ctrl + alt + v 누르면 옵셔널로 전환됨
    }

    private void ValidateExtract(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("Fail - this client is alreadt exist.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
