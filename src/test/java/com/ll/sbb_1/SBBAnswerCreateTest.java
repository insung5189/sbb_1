package com.ll.sbb_1;

import com.ll.sbb_1.answer.AnswerService;
import com.ll.sbb_1.question.Question;
import com.ll.sbb_1.question.QuestionService;
import com.ll.sbb_1.user.SiteUser;
import com.ll.sbb_1.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SBBAnswerCreateTest {

    @Autowired
    private AnswerService answerService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;

    @Test
    void testJpa() {
        Question question = this.questionService.getQuestion(301);
        SiteUser siteUser = this.userService.getUser("황인성");
        for (int i = 1; i <= 30; i++) {
            String content = String.format("테스트 답변데이터입니다:[%03d]", i);
            this.answerService.create(question, content, siteUser);
        }
    }
}
