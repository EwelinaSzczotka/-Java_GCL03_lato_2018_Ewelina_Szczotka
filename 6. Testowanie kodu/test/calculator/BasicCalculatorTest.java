package calculator;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


public class BasicCalculatorTest {
    
    private BasicCalculator instance;
    
    @Before
    public void setUp() {
        instance = new BasicCalculator();
    }
    
    //CalculateSum
    
    @Test
    public void testCalculateSum() {
        double a = 2.0;
        double b = 3.0;
        double expResult = 5.0;
        double result = instance.calculateSum(a, b);
        assertEquals(expResult, result, 0.0);  
    }
    
    @Test
    public void testCalaculateSum2(){
        assertEquals(10.0,instance.calculateSum(2.0,8.0),0.0);
    }
    
    @Test
    public void testCalaculateSum3(){
        assertEquals(-5.0,instance.calculateSum(2.0,-7.0),0.0);
    }
    
    //CalculateDifference

    @Test
    public void testCaclulateDifference() {
        double a = 2.0;
        double b = 3.0;
        double expResult = -1.0;
        double result = instance.calculateDifference(a, b);
        assertEquals(expResult, result, 0.0);   
    }
    
    @Test
    public void testCalculateDifference2(){
        assertEquals(3.0,instance.calculateDifference(10.0,7.0),0.0);
    }
    
    @Test
    public void testCalculateDifference3(){
        assertEquals(9.0,instance.calculateDifference(2.0,-7.0),0.0);
    }

    //CalculateMultiplication
    
    @Test
    public void testCalculateMultiplication() {
        double a = 2.0;
        double b = 3.0;
        double expResult = 6.0;
        double result = instance.calculateMultiplication(a, b);
        assertEquals(expResult, result, 0.0);    
    }
    
    @Test
    public void testCalaculateMultiplication2(){
        assertEquals(9.0,instance.calculateMultiplication(3.0,3.0),0.0);
    }
    
    @Test
    public void testCalaculateMultiplication3(){
        assertEquals(-6.0,instance.calculateMultiplication(2.0,-3.0),0.0);
    }

    //CalculateDivision
    
    @Test
    public void testCalculateDivision() {
        double a = 2.0;
        double b = 1.0;
        double expResult = 2.0;
        double result = instance.calculateDivision(a, b);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testCalculateDivision2(){
        assertEquals(5.0,instance.calculateDivision(10.0, 2.0),0.0);
    }
    
    @Test
    public void testCalculateDivision3(){
        assertEquals(-5.0,instance.calculateDivision(20.0, -4.0),0.0);
    }
    
    //CalculateDivision - Exception
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateDivisionException() {
        double a = 2.0;
        double b = 0.0;
        instance.calculateDivision(a, b);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateDivisionException2() {
        instance.calculateDivision(3.0, 0.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateDivisionException3() {
        instance.calculateDivision(-5.0, 0.0);
    }
    
    //CalculatePow

    @Test
    public void testCalculatePow() {
        double a = 2.0;
        double b = 2.0;
        double expResult = 4.0;
        double result = instance.calculatePow(a, b);
        assertEquals(expResult, result, 0.0);   
    }
    
    @Test
    public void testCalculatePow2(){
        assertEquals(9.0,instance.calculatePow(3.0, 2.0),0.0);
    }
    
    @Test
    public void testCalculatePow3(){
        assertEquals(25.0,instance.calculatePow(5.0, 2.0),0.0);
    }

    //CalculateSqrt
    
    @Test
    public void testCalculateSqr() {
        double a = 4.0;
        double expResult = 2.0;
        double result = instance.calculateSqr(a);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testCalculateSqr2() {
        assertEquals(9.0,instance.calculateSqr(81),0.0);
    }
    
    @Test
    public void testCalculateSqr3() {
        assertEquals(3.0,instance.calculateSqr(9),0.0);
    }
    
    //CalculateSqrt - Exception
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateSqrException() {
        double a = -1.0;
        instance.calculateSqr(a);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateSqrException2() {
        instance.calculateSqr(-5.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateSqrException3() {
        instance.calculateSqr(-55.0);
    }
}
