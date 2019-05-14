import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;


class Window extends JFrame implements Subject {
    private static final long serialVersionUID = -2542001418764869760L;
    public static ArrayList<ArrayList<SquareData>> Grid;
    public static int width = 20;
    public static int height = 20;


    //Used for singleton
    private static Window instance;



    //This is so only one instance of the game can run!
    public static synchronized Window getInstance(){
        if(instance == null){
            instance = new Window();

        }
        return instance;
    }

    private List<Observer> observers;

    public Window(){



        // Creates the arraylist that'll contain the threads
        Grid = new ArrayList<ArrayList<SquareData>>();
        ArrayList<SquareData> data;



        // Creates Threads and its data and adds it to the arrayList
        for(int i=0;i<width;i++){
            data= new ArrayList<SquareData>();
            for(int j=0;j<height;j++){
                SquareData c = new SquareData(2);
                data.add(c);
            }
            Grid.add(data);
        }

        // Setting up the layout of the panel
        getContentPane().setLayout(new GridLayout(20,20,0,0));

        // Start & pauses all threads, then adds every square of each thread to the panel
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                getContentPane().add(Grid.get(i).get(j).square);
            }
        }

        // initial position of the snake
        Tuple position = new Tuple(10,10);
        ThreadsController c = new ThreadsController(position);
        // passing this value to the controller
         //c = new ThreadsController(position);
        //Let's start the game now..
        c.start();

        // Links the window to the keyboardlistenner.
        this.addKeyListener((KeyListener) new KeyboardListener());

        //To do : handle multiplayers .. The above works, test it and see what happens

        //Tuple position2 = new Tuple(13,13);
        //ControlleurThreads c2 = new ControlleurThreads(position2);
        //c2.start();
        observers = new ArrayList<Observer>();

        notifyObservers(Grid);

    }

    public void notifyObservers(ArrayList<ArrayList<SquareData>> Grid) {
        for (Observer observer : observers)
            observer.update(Grid);
    }


    public void registerObserver(Observer o) {
        observers.add(o);
    }


    public void removeObserver(Observer o) {
        observers.remove(o);
    }



}
