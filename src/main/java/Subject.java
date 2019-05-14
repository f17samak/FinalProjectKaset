import java.util.ArrayList;

public interface Subject {

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(ArrayList<ArrayList<SquareData>> Grid);
}
