package com.exam.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;


	

	@RestController
	@RequestMapping("/question")
	@CrossOrigin("*")
	public class QuestionController {

		@Autowired
		private QuestionService questionService;
		
		@Autowired
		private QuizService quizService;
		
		//add question
		@PostMapping("/")
		public ResponseEntity<Question> add(@RequestBody Question question){

			return ResponseEntity.ok(this.questionService.addQuestion(question));
		}
		
		//update question
				@PutMapping("/")
				public ResponseEntity<Question> update(@RequestBody Question question){

					return ResponseEntity.ok(this.questionService.updateQuestion(question));
				}
		
		//get all question of any quiz
			@GetMapping("/quiz/{qid}")
			public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") UUID qid){
//				Quiz quiz = new Quiz();
//				quiz.setqId(qid);
//				Set<Question> questionOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
//				return ResponseEntity.ok(questionOfQuiz);
				
				Quiz quiz = this.quizService.getQuiz(qid);
				Set<Question> questions = quiz.getQuestions();
				List<Question> list = new ArrayList(questions);
				
				if(list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
					list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
				}
				
				list.forEach((q)->{
					q.setAnswer("");
				});
				
				Collections.shuffle(list);
				return ResponseEntity.ok(list);
			}
			
			
			//getallQuestion
			@GetMapping("/quiz/all/{qid}")
			public ResponseEntity<?> getQuestionOfQuizAdmin(@PathVariable("qid") UUID qid){

				
				Quiz quiz = new Quiz();
			quiz.setqId(qid);
			Set<Question> questionOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
			return ResponseEntity.ok(questionOfQuiz);
//				return ResponseEntity.ok(list);
			}
			
		
			//getsingle question
			
			@GetMapping("/{quesId}")
			public Question get(@PathVariable("quesId") UUID quesId) {
				return this.questionService.getQuestion(quesId);
			}

			@DeleteMapping("/{quesId}")
			public void delete(@PathVariable("quesId") UUID quesId) {
				this.questionService.deleteQuestion(quesId);
			}
			
			//eval quiz marks
			
			@PostMapping("/eval-quiz")
			public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){
				
				int correctAnswer=0;
				int attempted = 0;
				double marksGot = 0;
				
				for(Question q: questions) {
					Question question = this.questionService.get(q.getQuesId());
					
					if(question.getAnswer().equals(q.getGivenAnswer())) {
						//correct
						
						correctAnswer++;
						
						double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
						
						marksGot += marksSingle;
					}
					
					if(q.getGivenAnswer() != null) {
						attempted++;
					}
				}
				
				Map<String,Object> map = Map.of("marksGot",marksGot,"correctAnswer",correctAnswer,"attempted",attempted);
				
				return ResponseEntity.ok(map);
			}
}
