package com.ll.sbb_1;

import com.ll.sbb_1.answer.Answer;
import com.ll.sbb_1.answer.AnswerRepository;
import com.ll.sbb_1.question.Question;
import com.ll.sbb_1.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Sbb1ApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Transactional
	@Test
	void testJpa() {
		// 질문1 생성
//		Question q1 = Question.builder()
//				.subject("sbb가 무엇인가요?")
//				.content("sbb에 대해서 알고 싶습니다.")
//				.createDate(LocalDateTime.now())
//				.build();
//		this.questionRepository.save(q1);  // 첫번째 질문 저장
//
		// 질문2 생성
//		Question q2 = Question.builder()
//				.subject("스프링부트 모델 질문입니다.")
//				.content("id는 자동으로 생성되나요?")
//				.createDate(LocalDateTime.now())
//				.build();
//		this.questionRepository.save(q2);  // 두번째 질문 저장

		// 질문의 전체 갯수를 확인하고 그 중 0번 째의 제목이 일치하는지 확인
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size());
//
//		Question q = all.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());

		// id값 1번의 질문의 제목이 일치하는지 확인
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()) {
//			Question qq = oq.get();
//			assertEquals("sbb가 무엇인가요?", qq.getSubject());
//		}

		// 제목을 기준으로 질문 찾기
//		Question qqq = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//		assertEquals(1, qqq.getId());

		// 제목과 내용을 기준으로 질문 찾기
//		Question qqqq = this.questionRepository.findBySubjectAndContent(
//				"sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//		assertEquals(1, qqqq.getId());
//
		// 문자열을 기준으로 제목을 가진 질문 찾기
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//		Question qqqqq = qList.get(0);
//		assertEquals("sbb가 무엇인가요?", qqqqq.getSubject());

		// 제목 수정
//		Optional<Question> oq1 = this.questionRepository.findById(1);
//		assertTrue(oq1.isPresent());
//		Question qqqqqq = oq1.get();
//		qqqqqq.setSubject("수정된 제목");
//		this.questionRepository.save(qqqqqq);

		// 수정한 제목의 질문 삭제
//		assertEquals(2, this.questionRepository.count());
//		Optional<Question> oq2 = this.questionRepository.findById(1);
//		assertTrue(oq2.isPresent());
//		Question qqqqqqq = oq2.get();
//		this.questionRepository.delete(qqqqqqq);
//		assertEquals(1, this.questionRepository.count());

		// id값 2번의 질문에 답변 데이터 생성 후 저장
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question aq = oq.get();
//
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setQuestion(aq);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);

		// 답변 조회하기
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a1 = oa.get();
//		assertEquals(2, a1.getQuestion().getId());

		// 질문에 달린 답변 찾기 , 답변에 연결된 질문 찾기
		Optional<Question> oq3 = this.questionRepository.findById(2);
		assertTrue(oq3.isPresent());
		Question q3 = oq3.get();

		List<Answer> answerList = q3.getAnswerList();

		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}

}
