import java.util.Collections;
import java.util.Vector;

class Answer{
  private boolean selected;
  private String answer;
  private double points_if_selected;
  private double points_if_not_selected;



  public Answer(String input){
    this.selected = false;
    this.answer = input;
    this.points_if_selected = 0.0;
    this.points_if_not_selected = 0.0;

  }

  public void print(int position){
    System.out.print(position);
    System.out.print(") ");
    if(this.selected == true){
      System.out.print("[x] ");
    }
    else if(this.selected == false){
      System.out.print("[ ] ");
    }

    System.out.println("( " + this.answer + " )\n");


  }

  public void setSelected(boolean selection){
    this.selected = selection;
  }

  public void setValue(double points_if_selected,double points_if_not_selected){
    this.points_if_not_selected = points_if_not_selected;
    this.points_if_selected     = points_if_selected;
  }

  public double getValue(){
    if(selected){return this.points_if_selected;}
    else{return this.points_if_not_selected;}
  }

}
