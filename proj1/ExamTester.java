import java.util.Collections;
import java.util.Vector;
import java.util.Scanner;

class ExamTester {
  public static void main(String[]args){
      System.out.println("Name: Kevin Benitez");
      System.out.println("NetID: kbenit4");
      System.out.println("\n");


     String question = "Whats the Capital of Denmark?";
     Vector<String> answers = new Vector<String>(5);
            answers.add("CopenHagen");
            answers.add("not CopenHagen");
            answers.add("Chicago");
            answers.add("Not Chicago BUT definitely not CopenHagen");
     int rightAnswer = 1;
     Question question1 = createQuestion(question,answers,rightAnswer);


     question = "Would you go on a data with me?";
     answers = new Vector<String>(5);
            answers.add("ahhhhhh, thats cute, Ill see if im not busy this weekend and ill let you know");
            answers.add("lol nah, your like my little brother/sister...");
            answers.add("Im not looking for a relationship right now");
            answers.add("Yes(the only right answer)");

    rightAnswer = 4;
    Question question2 = createQuestion(question,answers,rightAnswer);
    question = "What would make the world a better place?";
    answers = new Vector<String>(5);
           answers.add("death");
           answers.add("more death");
           answers.add("money ");
           answers.add("love");

   rightAnswer = 3;
   Question question3 = createQuestion(question,answers,rightAnswer);
   question = "Whats your favorite programming language?";
   answers = new Vector<String>(5);
          answers.add("python");
          answers.add("not python");
          answers.add("i love debugging C/C++ code");
          answers.add("i hate being productive");

  rightAnswer = 1;
  Question   question4 = createQuestion(question,answers,rightAnswer);
  question = "Wheres your favorite place to cry?";
  answers = new Vector<String>(5);
         answers.add("in my head");
         answers.add("in the shower");
         answers.add("in public");
         answers.add("i dont cry man thats dumb");

 rightAnswer = 3;
 Question question5 = createQuestion(question,answers,rightAnswer);

Vector<Question> questions = new Vector<Question>(5);

question1.reorderAnswers();
question2.reorderAnswers();
question3.reorderAnswers();
question4.reorderAnswers();
question5.reorderAnswers();

questions.add(question1);
questions.add(question2);
questions.add(question3);
questions.add(question4);
questions.add(question5);

Exam exam = createExam("Personality Quiz: ", questions);
exam.reorderQuestions();
//exam.print();
takeExam(exam);

  }

  public static void takeExam(Exam exam){
    int possible_points = 0;
    int earned_points = 0;

    for (int i = 1; i <= 5; i++){
      possible_points++;
      Question question = exam.getQuestion(i);
      question.print(i);
      System.out.println("Choose an answer between 1 and 5");
      Scanner scan = new Scanner(System.in);
      question.selectAnswer(Integer.parseInt(scan.next())-1);
      earned_points += question.getValue();
      System.out.println("earned points: " + question.getValue());
  }

  System.out.print(earned_points + "/ ");
  System.out.print(possible_points + " ");
  System.out.println("Your Percentage: " + (earned_points / possible_points));
}

  public static Question createQuestion(String input, Vector<String> answers, int right_answer){
    Question question = new Question(input);
    int i = 0;
    for(String s : answers){
      Answer answer = new Answer(s);
      if(i == right_answer - 1){
        answer.setValue(1,0);
      }
      else{
        answer.setValue(0,0);
      }
      question.AddAnswer(answer);
      i++;
    }
      return question;
  }

  public static Exam createExam(String input, Vector<Question> questions){
      Exam exam = new Exam(input);
      for(Question q: questions)
      {
        exam.AddQuestion(q);
      }
      return exam;
  }


}
