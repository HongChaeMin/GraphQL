package com.example.graphql.dto;

import com.example.graphql.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

  private String memberId;
  private String name;
  private int age;
  private String gender;

  public static MemberDTO of(Member member) {
    return new MemberDTO(member.getMemberId(), member.getName(), member.getAge(), member.getGender().toString());
  }

}
