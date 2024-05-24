package suzdal;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class tarea {
    public static void main(String[] args) {
        String url      = "jdbc:mysql://192.168.1.131:3306";
        String user     = "usuario";
        String password = "Toshiba123";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
           
            stmt.executeUpdate("DROP DATABASE IF EXISTS magos_del_humor");
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS magos_del_humor");
            stmt.executeUpdate("USE magos_del_humor");
            String sql = "CREATE TABLE albumes (numAlbum INT PRIMARY KEY, nombAlbum VARCHAR(50), protagonistas VARCHAR(25))";
            stmt.executeUpdate(sql);
            stmt.executeUpdate("INSERT INTO albumes (numAlbum, protagonistas, nombAlbum) VALUES (1, 3, 'Safari callejero Mortadelo y Filemon')");
            stmt.executeUpdate("INSERT INTO albumes (numAlbum, protagonistas, nombAlbum) VALUES (2, 6, 'El caso del bacalao Mortadelo y Filemon')");
            stmt.executeUpdate("INSERT INTO albumes (numAlbum, protagonistas, nombAlbum) VALUES (3, 22, 'Los monstruos Mortadelo y Filemon')");
            stmt.executeUpdate("INSERT INTO albumes (numAlbum, protagonistas, nombAlbum) VALUES (4, 92, 'El estrellato Mortadelo y Filemon')");
            stmt.executeUpdate("INSERT INTO albumes (numAlbum, protagonistas, nombAlbum) VALUES (5, 101, 'Las montañas voladoras Superlopez')");
            stmt.executeUpdate("INSERT INTO albumes (numAlbum, protagonistas, nombAlbum) VALUES (6, 109, 'El kamikadze Reguez Mortadelo y Filemon')");
            stmt.executeUpdate("INSERT INTO albumes (numAlbum, protagonistas, nombAlbum) VALUES (7, 110, 'Mundial 2006 Mortadelo y Filemon')");
            stmt.executeUpdate("INSERT INTO albumes (numAlbum, protagonistas, nombAlbum) VALUES (8, 146, 'Jubilacion a los noventa Mortadelo y Filemon')");
            stmt.executeUpdate("INSERT INTO albumes (numAlbum, protagonistas, nombAlbum) VALUES (9, 157, '¡Broomm! Mortadelo y Filemon')");
            stmt.executeUpdate("INSERT INTO albumes (numAlbum, protagonistas, nombAlbum) VALUES (10, 158, 'El ladron del tiempo SuperLopez')");
           
            ResultSet rs = stmt.executeQuery("SELECT * FROM albumes");
            while (rs.next()) {
                String nombAlbum = rs.getString("nombAlbum");
                String protagonistas = rs.getString("protagonistas");
                System.out.println(protagonistas+" "+nombAlbum);
            }
            
            /* inicio la visualizacion del formulario */
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Tarea 11");
                NewJPanel panel = new NewJPanel(stmt);
                panel.setPreferredSize(new Dimension(1110, 500));
                frame.getContentPane().add(panel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            });
       } catch(ClassNotFoundException | SQLException ex){
           System.out.println("Error: "+ex.getMessage());
       }
       
    
    }
 
}



/*
    descargo el conector desde aqui
    https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.25
    y le añado como archivo JAR a la carpeta Library

*/