package hello.core.member;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository{
    // hashmap vs ConcurrentHashMap -> 동시성 이슈  찾아보기 !!
    private static Map<Long,Member> store = new ConcurrentHashMap<>();

    @Override
    // 저장
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberID) {
        return store.get(memberID) ;
    }
}
