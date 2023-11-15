package com.ll.sbb_1.answer;

import com.ll.sbb_1.DataNotFoundException;
import com.ll.sbb_1.question.Question;
import com.ll.sbb_1.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Answer create(Question question, String content, SiteUser author) {
        Answer answer = Answer.builder()
                .content(content)
                .createDate(LocalDateTime.now())
                .question(question)
                .author(author)
                .build();
        this.answerRepository.save(answer);
        return answer;
    }
    public Answer getAnswer(Integer id) {
        Optional<Answer> answer = this.answerRepository.findById(id);
        if (answer.isPresent()) {
            return answer.get();
        } else {
            throw new DataNotFoundException("answer not found");
        }
    }

    public void modify(Answer answer, String content) {
        Answer manswer = answer.toBuilder()
                .content(content)
                .modifyDate(LocalDateTime.now())
                .build();
        this.answerRepository.save(manswer);
    }
    public void delete(Answer answer) {
        this.answerRepository.delete(answer);
    }
    public void vote(Answer answer, SiteUser siteUser) {
        answer.getVoter().add(siteUser);
        this.answerRepository.save(answer);
    }
}
