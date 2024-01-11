package exam.servlet.basic.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

  MemberRepository memberRepository = MemberRepository.getInstance();


  /*
  * @AfterEach : 테스트가 끝나면 실행될 메서드 정의
  * */
  @AfterEach
  void afterEach() {
    memberRepository.clearStore();
  }

  @Test
  void save() {
    // given
    Member member = new Member("hello", 20);

    // when
    Member saveMember = memberRepository.save(member);

    // then
    Member findMember = memberRepository.findById(member.getId());
    assertThat(findMember).isEqualTo(saveMember);
  }

  @Test
  void findAll() {
    // given
    Member member1 = new Member("member1", 20);
    Member member2 = new Member("member2", 30);

    memberRepository.save(member1);
    memberRepository.save(member2);

    // when
    List<Member> result = memberRepository.findAll();

    // then
    assertThat(result.size()).isEqualTo(2); // result의 사이즈가 2가 맞는가 ?
    assertThat(result).contains(member1, member2);   // result의 안에 member1과 member2가 있는가?

  }
}