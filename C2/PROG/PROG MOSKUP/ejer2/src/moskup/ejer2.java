package moskup;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class ejer2 {

    public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Tarea 11");
                NewJPanel panel = new NewJPanel();
                panel.setPreferredSize(new Dimension(777, 500));
                frame.getContentPane().add(panel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            });
    }   
}
