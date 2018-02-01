import java.util.Collections;
import java.util.Vector;

class Exam {
  private Vector<Question> questions;
  private String ExamTitle = " ";

  public Exam(String input){
    super();
    this.ExamTitle = input;
    questions = new Vector<Question>(5);
  }
  public void AddQuestion(Question question){
    questions.add(question);
  }
  public void print(){
    int i = 1;
    System.out.println(this.ExamTitle);
    System.out.println("------------------");
    System.out.println("");
    System.out.println("");
    for(Question q : questions){
      q.print(i);
      i++;
    }
  }
  public Question getQuestion(int position){
    return questions.get(position-1);
  }
  public void reorderQuestions(){
    Collections.shuffle(questions);
  }
  public double getValue(){
    int sum = 0;

    for(Question q: questions){
      sum += q.getValue();
    }
    return sum;
  }
}
