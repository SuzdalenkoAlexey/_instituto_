/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package numero_primo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alexei
 */
public class Numero_primoTest {
    
    public Numero_primoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class Numero_primo.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Numero_primo.main(args);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of primo method, of class Numero_primo.
     */
    @Test
    public void testPrimo() {
        System.out.println("primo");
        int numero = 30;
        boolean expResult = false;
        boolean result = Numero_primo.primo(numero);
        assertEquals(expResult, result);
    }
    
}






































