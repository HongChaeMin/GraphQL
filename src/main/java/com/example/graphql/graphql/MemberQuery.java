package com.example.graphql.graphql;

import com.example.graphql.dto.MemberDTO;
import com.example.graphql.entity.Member;
import com.example.graphql.repository.MemberRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Transactional
public class MemberQuery implements GraphQLQueryResolver {

  private final MemberRepository memberRepository;

  public MemberDTO getMember(Long id) {
    Member member = memberRepository.findById(id).orElse(null);
    return MemberDTO.of(member);
  }
}
