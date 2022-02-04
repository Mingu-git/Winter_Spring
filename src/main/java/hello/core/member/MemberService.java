package hello.core.member;

public interface MemberService {
    //회원 가입 , 조회

    void Join(Member member);

    Member findMember(Long memberID);
}
