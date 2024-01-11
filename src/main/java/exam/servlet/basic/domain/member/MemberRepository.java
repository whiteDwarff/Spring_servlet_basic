package exam.servlet.basic.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

  // MemberRepository가 많아도 하나만 생성되는 데이터
  private static Map<Long, Member> store = new HashMap<>();
  private static Long sequence = 0L;
  /*
  * 싱글톤 객체로 생성
  * private으로 선언하여 생성자로 선언하는것을 제어
  *   -> new MemberRepository(); X
  * */
  private static final MemberRepository instance = new MemberRepository();

  /*
  * MemberRepository 객체를 사용하려면 해당 메서드를 통해 instance로 사용 가능
  * */
  public static MemberRepository getInstance() {
    return instance;
  }

  private MemberRepository() { }

  /*
  * 회원 정보를 저장하는 메서드
  * @param  : Member member
  * @return : Member member
  * */
  public Member save(Member member) {
    member.setId(++sequence);
    store.put(member.getId(), member);
    return member;
  }

  /*
  * 회원 id를 통해 회원정보를 찾는 메서드
  * @param  : Long id
  * @return : Map
  * */
  public Member findById(Long id) {
    return store.get(id);
  }

  /*
  * 모든 회원정보를 조회
  * @return : ArrayList<>()
  * */
  public List<Member> findAll() {
    return new ArrayList<>(store.values());
  }

  /*
  * store 변수 초기화
  * */
  public void clearStore() {
    store.clear();
  }


}
