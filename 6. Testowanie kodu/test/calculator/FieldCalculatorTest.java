package calculator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class FieldCalculatorTest {
    
    private FieldCalculator instance;
    
    @Before
    public void setUp() {
        instance = new FieldCalculator();
    }
    
    //CalculateSquare
    
    @Test
    public void testCalculateSquare() {
        double a = 2.0;
        double expResult = 4.0;
        double result = instance.calculateSquare(a);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testCalculateSquare2(){
        assertEquals(25.0,instance.calculateSquare(5.0),0.0);
    }
    
    @Test
    public void testCalculateSquare3(){
        assertEquals(36.0,instance.calculateSquare(6.0),0.0);
    }
    
    //CalculateSquare - Exception
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateSquareException() {
        double a = -2.0;
        instance.calculateSquare(a);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateSquareException2() {
        double a = -10.0;
        instance.calculateSquare(a);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateSquareException3() {
        double a = -15.5;
        instance.calculateSquare(a);
    }

    //CalculateCircle
    
    @Test
    public void testCalculateCircle() {
        double r = 3.0;
        double expResult = 28.0;
        double result = instance.calculateCircle(r);
        assertEquals(expResult, result, 0.5);
    }
    
    @Test
    public void testCalculateCircle2(){
        assertEquals(78.5,instance.calculateCircle(5.0),0.5);
    }
    
    @Test
    public void testCalculateCircle3(){
        assertEquals(314.0,instance.calculateCircle(10.0),0.5);
    }
    
    //CalculateCircle - Exception
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateCircleException() {
        double r = -3.0;
        instance.calculateCircle(r);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateCircleException2() {
        double r = -10.0;
        instance.calculateCircle(r);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateCircleException3() {
        double r = 0.0;
        instance.calculateCircle(r);
    }

    //CalculateTriangle
    
    @Test
    public void testCalculateTriangle() {
        double a = 5.0;
        double h = 6.0;
        double expResult = 15.0;
        double result = instance.calculateTriangle(a, h);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testCalculateTriangle2(){
        assertEquals(10.0,instance.calculateTriangle(4.0, 5.0),0.0);
    }
    
    @Test
    public void testCalculateTriangle3(){
        assertEquals(21.0,instance.calculateTriangle(7.0, 6.0),0.0);
    }
    
    //CalculateTriangle - ExceptionA
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateTriangleExceptionA() {
        double a = -5.0;
        double h = 6.0;
        instance.calculateTriangle(a, h);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateTriangleExceptionA2() {
        double a = -10.0;
        double h = 6.0;
        instance.calculateTriangle(a, h);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateTriangleExceptionA3() {
        double a = 0.0;
        double h = 6.0;
        instance.calculateTriangle(a, h);
    }
    
    //CalculateTriangle - ExceptionB
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateTriangleExceptionB() {
        double a = 5.0;
        double h = -6.0;
        instance.calculateTriangle(a, h);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateTriangleExceptionB2() {
        double a = 5.0;
        double h = -4.0;
        instance.calculateTriangle(a, h);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateTriangleExceptionB3() {
        double a = 5.0;
        double h = 0.0;
        instance.calculateTriangle(a, h);
    }

    //CalculateRectangle
    
    @Test
    public void testCalculateRectangle() {
        double a = 3.0;
        double b = 4.0;
        double expResult = 12.0;
        double result = instance.calculateRectangle(a, b);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testCalculateRectangle2(){
        assertEquals(42.0,instance.calculateRectangle(6.0, 7.0),0.0);
    }
    
    @Test
    public void testCalculateRectangle3(){
        assertEquals(30.0,instance.calculateRectangle(5.0, 6.0),0.0);
    }
    
    //CalculateRectangle - ExceptionB
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRectangleExceptionB() {
        double a = 3.0;
        double b = -4.0;
        instance.calculateRectangle(a, b);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRectangleExceptionB2() {
        double a = 3.0;
        double b = -7.0;
        instance.calculateRectangle(a, b);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRectangleExceptionB3() {
        double a = 3.0;
        double b = 0.0;
        instance.calculateRectangle(a, b);
    }
    
    //CalculateRectangle - ExceptionA
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRectangleExceptionA() {
        double a = -3.0;
        double b = 4.0;
        instance.calculateRectangle(a, b);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRectangleExceptionA2() {
        double a = -5.0;
        double b = 4.0;
        instance.calculateRectangle(a, b);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRectangleExceptionA3() {
        double a = 0.0;
        double b = 4.0;
        instance.calculateRectangle(a, b);
    }
    
}
