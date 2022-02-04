package hello.core.member;

public interface MemberRepository {
    // 저장
    void save(Member member);
    // 회원의 아이돌 찾는 기능
    Member findById(Long memberID);
}


