import java.util.Collections;
import java.util.Vector;

class Question {
  private int N = 5;
  private String question;
  private Vector<Answer> answers;

public Question(String input){
  super();
  question = input;
  answers = new Vector<Answer>(N);
}
public void AddAnswer(Answer answer){
  answers.add(answer);
}
public void print(int position){
System.out.print(position);
System.out.print("] ");
System.out.println(question);
System.out.println("========");
int i = 1;
  for(Answer a : answers){
    a.print(i);
    i++;
  }
}
public void selectAnswer(int position){
  int ans = position;
  for(int i = 0; i < answers.size(); i++){
    if(i == ans){
      answers.get(i).setSelected(true);
    }
    else{
      unselectAnswer(i+1);
    }
  }
}

public void unselectAnswer(int position){
  answers.get(position-1).setSelected(false);
}

public void reorderAnswers(){
  Collections.shuffle(answers);
}

public double getValue(){
  double sum = 0;
  for(Answer a : answers){
    sum += a.getValue();
  }
  return sum;
}

}
