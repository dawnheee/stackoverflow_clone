package com.team_28.StackOverFlow.question.dto;

import com.team_28.StackOverFlow.jwt.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class QuestionRequestDto {
    private long questionId;
    @NotBlank
    private String questionTitle;

    @NotBlank
    private String questionContent;

    private long memberId;

    private String createdAt;
    private String modifiedAt;
    private boolean isAnswered;

    public Member getMember(){
        Member member = new Member();
        member.setMemberid(memberId);
        return member;
    }
}
