package hello.core.member;

public class MemberServiceImpl implements MemberService {


    //구현 객체 설정 , 다형성  -> dip위반
    private  final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//appconfig를 생성자 주입 실현

    //new 안하고 선언만할시 -> null -> 터짐
    @Override
    public void Join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberID) {
        return memberRepository.findById((memberID));
    }
}
