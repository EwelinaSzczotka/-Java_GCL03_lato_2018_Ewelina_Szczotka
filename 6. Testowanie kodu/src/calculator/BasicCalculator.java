package calculator;


public class BasicCalculator {
    
    public double calculateSum(double a, double b){
        return a+b;
    }
    public double calculateDifference(double a, double b){
        return a-b;
    }
    public double calculateMultiplication(double a, double b){
        return a*b;
    }
    public double calculateDivision(double a, double b){
        if(b==0) throw new IllegalArgumentException("Nie mozna dzielic przez 0.");
        return a/b;
    }
    public double calculatePow(double a, double b){
        return Math.pow(a, b);
    }
    public double calculateSqr(double a){
        if(a<0) throw new IllegalArgumentException("Pierwiastek z liczby ujemnej.");
        return Math.sqrt(a);
    }

}
