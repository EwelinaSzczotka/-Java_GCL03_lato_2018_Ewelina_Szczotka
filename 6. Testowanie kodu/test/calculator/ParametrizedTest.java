
package calculator;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParametrizedTest {
 
    private BasicCalculator instance;
    
    private double firstNum;
    private double secondNum;
    private double result;
    
    public ParametrizedTest(double first, double second, double res){
        firstNum=first;
        secondNum=second;
        result=res;
    }
    
    @Parameterized.Parameters
    public static Collection input(){
        return Arrays.asList(new Object[][]{{1,2,3},{5,7,12},{23,33,56},{2,5,7}});
    }
    
    @Before
    public void setUp() {
        instance = new BasicCalculator();
    }
    
    @Test
    public void testParameterizedSum(){
        assertEquals(result,instance.calculateSum(firstNum, secondNum),0.0);
    }
    
}
