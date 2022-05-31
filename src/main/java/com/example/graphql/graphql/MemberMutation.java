package com.example.graphql.graphql;

import com.example.graphql.dto.MemberDTO;
import com.example.graphql.entity.Member;
import com.example.graphql.repository.MemberRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Transactional
public class MemberMutation implements GraphQLMutationResolver {

  private final MemberRepository memberRepository;

  public MemberDTO createMember(MemberDTO memberDto) {
    Member member = memberRepository.save(Member.builder().memberDTO(memberDto).build());
    return MemberDTO.of(member);
  }

  public Boolean deleteMember(Long id){
    Optional<Member> optionalMember = memberRepository.findById(id);
    optionalMember.ifPresent(memberRepository::delete);
    return true;
  }
}
