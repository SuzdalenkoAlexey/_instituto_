package com.mycompany.proyectopotencia;
import static org.junit.jupiter.api.Assertions.*;
public class ProyectoPotenciaTest {
    
    public ProyectoPotenciaTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    

    /**
     * Test of main method, of class ProyectoPotencia.
     */
    @org.junit.jupiter.api.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ProyectoPotencia.main(args);
    }

    /**
     * Test of potenciaIteractiva method, of class ProyectoPotencia.
     */
    @org.junit.jupiter.api.Test
    public void testPotenciaIteractiva() {
        System.out.println("potenciaIteractiva");
        int x = -2;
        int y = 4;
        double expResult = 1;
        double result = ProyectoPotencia.potenciaIteractiva(x, y);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of potenciaRecursiva method, of class ProyectoPotencia.
     */
    @org.junit.jupiter.api.Test
    public void testPotenciaRecursiva() {
        System.out.println("potenciaRecursiva");
        int x = 2;
        int y = 3;
        double result = ProyectoPotencia.potenciaRecursiva(x, y);
        assertNotNull(result);
    }
}
