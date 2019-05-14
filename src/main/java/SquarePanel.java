import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;

public class SquarePanel extends JPanel implements Observer {

    private static final long serialVersionUID = 1L;

    public SquarePanel(Color d){
        this.setBackground(d);
    }

    public void ChangeColor(Color d){
        this.setBackground(d);
        this.repaint();
    }


    public void update(ArrayList<ArrayList<SquareData>> Grid) {
        this.repaint();
    }

}
