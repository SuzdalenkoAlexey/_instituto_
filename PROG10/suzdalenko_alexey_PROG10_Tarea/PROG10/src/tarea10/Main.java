package tarea10;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class Main {
 
    public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tarea 10");
            frame.setTitle("Jframe");
        
            NewJPanel panel = new NewJPanel();
            TitledBorder titledBorder = BorderFactory.createTitledBorder("Tarea 10");
            panel.setBorder(titledBorder);
               
            panel.setPreferredSize(new Dimension(1110, 500));
            frame.getContentPane().add(panel);
            
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
         });
    }
}
