package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * sign up
     * */

    public long join(Member member) {
        // existed names
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(
                m -> {
                    throw new IllegalStateException("Already exists");
                }
        );
    }


    /**
     * view members
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
