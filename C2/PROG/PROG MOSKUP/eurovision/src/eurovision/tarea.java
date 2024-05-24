package eurovision;
import java.sql.*;
public class tarea {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://192.168.1.131:3306";
            String user = "usuario";
            String password = "Toshiba123";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("DROP DATABASE IF EXISTS Eurovision");
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS Eurovision");
            stmt.executeUpdate("USE Eurovision");
            
            stmt.executeUpdate("CREATE TABLE Canciones (Id INT PRIMARY KEY, Titulo VARCHAR(50), Artista VARCHAR(50), Anio INT, Puntuacion DOUBLE(11,4) )");
            stmt.executeUpdate("INSERT INTO Canciones (Id, Titulo, Artista, Anio, Puntuacion) VALUES (1, 'My Lovely Song', 'Eva Singer', 2020, 1.1)");
            stmt.executeUpdate("INSERT INTO Canciones (Id, Titulo, Artista, Anio, Puntuacion) VALUES (2, 'Lost in Melody', 'The Harmonizers', 2018, 3.8)");
            stmt.executeUpdate("INSERT INTO Canciones (Id, Titulo, Artista, Anio, Puntuacion) VALUES (3, 'My Lovely Song', 'Eva Singer', 2017, 2.1)");
            stmt.executeUpdate("INSERT INTO Canciones (Id, Titulo, Artista, Anio, Puntuacion) VALUES (4, 'My Lovely Song', 'Eva Singer', 2019, 2.5)");
            stmt.executeUpdate("INSERT INTO Canciones (Id, Titulo, Artista, Anio, Puntuacion) VALUES (5, 'My Lovely Song', 'Eva Singer', 2019, 2.5)");
        
             ResultSet rs = stmt.executeQuery("SELECT * FROM Canciones ORDER BY Puntuacion ASC LIMIT 3");
            while (rs.next()) {
                String Titulo = rs.getString("Titulo");
                int id = rs.getInt("Id");
                double puntuacion = rs.getDouble("Puntuacion");
                System.out.println(id+" "+Titulo+" "+puntuacion);
            }
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }
    
}
/*
    descargo el conector desde aqui
    https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.25
    carpeta Library Add Jar/Folder

*/