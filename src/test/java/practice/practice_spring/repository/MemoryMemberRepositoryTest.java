package practice.practice_spring.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import practice.practice_spring.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    // test 가 끝날 때마다 초기화 시켜주는 코드
    // @AfterEach로 하나의 테스트가 끝날 때마다 테스트 하는 Java 파일에 있는 clearStore을 호출하여
    // 그 클래스 내부의 store.clear()로 초기화 시킴

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        // 저장한거랑 꺼낸거랑 똑같으면 참
        //System.out.println("result = " + (result==member));
        //Assertions.assertEquals(member, result);
        // 같으면 초록불, 틀리면 에러남
        // 실패시 expected와 Actual을 보여줘서 디버깅이 쉽다
        assertThat(member).isEqualTo(result);
        // 이건 org.assertj.core.api 을 import
        // Assertions 드래그 하고 Alt+Enter 하고 static import 하면
        // assertThat(member).isEqualTo(result); 으로 줄일 수 있음
    }

    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //when
        Member result = repository.findByName("spring1").get();
        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo((2));
    }
}
// get() : optional에서 값 꺼내기
// *tip == soutv 치면 System.out.println 출력됨

// 오류 이유
/*
* findAll이 먼저 실행되면서 spring1 spring2 가 저장돼있어서
* --> 테스트 끝날 때마다
* data clear 필요
*
* */
