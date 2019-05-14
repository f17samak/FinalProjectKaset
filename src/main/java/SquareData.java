import java.util.ArrayList;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class SquareData  {


    //ArrayList that'll contain the colors
    ArrayList<Color> C =new ArrayList<Color>();
    int color; //2: snake , 1: food, 0:empty
    SquarePanel square;
    public SquareData(int col){

        //Lets add the color to the arrayList
        C.add(Color.darkGray);//0
        C.add(Color.BLUE);    //1
        C.add(Color.white);   //2
        color=col;
        square = new SquarePanel(C.get(color));
    }
    public void lightMeUp(int c){
        square.ChangeColor(C.get(c));
    }


}