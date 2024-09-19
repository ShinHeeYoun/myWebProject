package practice.practice_spring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.practice_spring.domain.Member;
import practice.practice_spring.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;


class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // test join
        // given (주어졌을 때)
        Member member = new Member();
        member.setName("kim");

        // when (실행됐을 때)
        Long saveId = memberService.join(member);

        // then (얘가 나와야 함)
        Member findMember = memberService.findOne(saveId).get();
        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    // given when then 문법 : 복잡한 함수 test 할 때 좋음
    // 테스트는 정상 플로우도 중요하지만 예외 플로우도 중요
    // ==> 중복 회원이 예외처리 되는지 봐야함

    @Test
    void 회원가입_중복예외처리() {
        //given
        Member member1 = new Member();
        member1.setName("Kim");

        Member member2 = new Member();
        member2.setName("Kim");

        // when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

//        try {
//            memberService.join(member2);
//            fail("메세지 불일치");
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("Fail - this client is already exist.");
//        }

        // then
    }

    @Test
    void findMembers() {
        // test findMembers

    }

    @Test
    void findOne() {
        // testfindOne

    }
}