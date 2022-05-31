package com.example.graphql.entity;

import com.example.graphql.dto.MemberDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "member")
@Entity
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_seq", nullable = false, precision = 15) // https://velog.io/@gillog/JPA-Column-Annotation
  private Long memberSeq;

  @Column(name = "member_id", nullable = false, length = 100)
  private String memberId;

  private String name;

  private int age;

  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Builder
  public Member(MemberDTO memberDTO) {
    this.memberId = memberDTO.getMemberId();
    this.name = memberDTO.getName();
    this.age = memberDTO.getAge();
    this.gender = Gender.valueOf(memberDTO.getGender());
  }

}
