package com.team_28.StackOverFlow.answer.service;

import com.team_28.StackOverFlow.answer.entity.Answer;
import com.team_28.StackOverFlow.answer.repository.AnswerRepository;
import com.team_28.StackOverFlow.exception.CustomLogicException;
import com.team_28.StackOverFlow.exception.ExceptionCode;
import com.team_28.StackOverFlow.jwt.entity.Member;
import com.team_28.StackOverFlow.jwt.repository.MemberRepository;
import com.team_28.StackOverFlow.question.entity.Question;
import com.team_28.StackOverFlow.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.team_28.StackOverFlow.exception.ExceptionCode.MEMBER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AnswerService {

    //답변이 생성되면 질문 객체 잧아서 답변 저장, 답변 여부 변경해주기!!!
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final MemberRepository memberRepository;


    public Answer createAnswer(Answer answer){
        //존재하는 답변 id 인지 확인
        //요청으로 들어온 답변객체에 있는 질문 아이디가 존재하는지 확인
        Member member = findMember(answer.getMember().getMemberid());
        System.out.println(member.getUserid()+" = createAnswer에서 멤버의 유저아이디");
        answer.getMember().setUserid(member.getUserid());
        saveAnswerInQuestion(answer);
        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer) {
        //받아온 작성자 이름과 바꿀 답변의 작성자 이름이 같은 지 확인
        //받아온 질문 아이디와 바꾼 질문의 아이디가 같은지 확인
        Answer findAnswer = findVerifiedAnswer(answer.getAnswerId());
        if (findAnswer.getMember().getMemberid() != answer.getMember().getMemberid()) {
                throw new CustomLogicException(ExceptionCode.MEMBER_NOT_FOUND);
            } else if (findAnswer.getQuestion().getQuestionId() != answer.getQuestion().getQuestionId()) {
                throw new CustomLogicException(ExceptionCode.QUESTION_NOT_FOUND);
            }
        findAnswer.setAnswerContent(answer.getAnswerContent());
        saveAnswerInQuestion(findAnswer);
        return answerRepository.save(findAnswer);
    }

    public void deleteAnswer(long answerId){
        Answer answer = findVerifiedAnswer(answerId);
        Member member = answer.getMember();
        Question question = answer.getQuestion();
        if(member == null) System.out.println("멤버 존재 X");
        if(question == null) System.out.println("질문 존재 X");
        member.getAnswers().removeIf(answer1 -> answer.getAnswerId().equals(answerId));
        question.getAnswers().removeIf(answer1 -> answer.getAnswerId().equals(answerId));
        answerRepository.delete(answer);
        System.out.println("삭제 완료");
        if(question.getAnswers().size() == 0) {
            System.out.println(question.getQuestionId()+" + 해당 질문에 답변 존재 X");
            answer.getQuestion().setAnswered(false);
        }
        if(answer != null)  System.out.println(answer.getAnswerId()+"번 답변 삭제 X");
    }

        private Question findQuestion(long questionId){
        System.out.println(questionId+" 에 해당하는 질문 확인");
        Optional<Question> question = questionRepository.findByQuestionId(questionId);
            Question findQuestion = question.orElseThrow(() -> new CustomLogicException(ExceptionCode.QUESTION_NOT_FOUND));
            return findQuestion;
    }
    private Answer findVerifiedAnswer(long answerId){
        Optional<Answer> answer = answerRepository.findByAnswerId(answerId);
        Answer findAnswer = answer.orElseThrow(()->new CustomLogicException(ExceptionCode.ANSWER_NOT_FOUND));
        return findAnswer;
    }
    private Member findMember(long memberId){
        System.out.println("memberId 로 멤버 찾기 : service method");
        Member member = memberRepository.findByMemberid(memberId);
        if(member == null) throw new CustomLogicException(MEMBER_NOT_FOUND);
        System.out.println(member.getMemberid()+" member 존재");
        return member;
    }
    private void saveAnswerInQuestion(Answer answer){
        Question question = findQuestion(answer.getQuestion().getQuestionId());
        System.out.println(question.getQuestionId()+" = createAnswer에서 질문의 질문 아이디");
        if(!question.isAnswered()){ question.setAnswered(true);}
        question.setAnswer(answer);
    }


}
