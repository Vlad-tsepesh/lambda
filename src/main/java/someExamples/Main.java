package someExamples;

// Demonstrate a simple lambda expression.
// A functional interface.
interface MyNumber {
    double getValue();
}
class LambdaDemo {
    public static void main(String args[])
    {
        MyNumber myNum; // declare an interface reference
        // Here, the lambda expression is simply a constant expression.
        // When it is assigned to myNum, a class instance is
        // constructed in which the lambda expression implements
        // the getValue() method in MyNumber.
        myNum = () -> 123.45;
        // Call getValue(), which is provided by the previously assigned
        // lambda expression.
        System.out.println("A fixed value: " + myNum.getValue());
        // Here, a more complex expression is used.
        myNum = () -> Math.random() * 100;
        // These call the lambda expression in the previous line.
        System.out.println("A random value: " + myNum.getValue());
        System.out.println("Another random value: " + myNum.getValue());
        // A lambda expression must be compatible with the method
        // defined by the functional interface. Therefore, this won't work:
// myNum = () -> "123.03"; // Error!
    }
}

// Demonstrate a lambda expression that takes a parameter.
// Another functional interface.
interface NumericTest {
    boolean test(int n);
}
class LambdaDemo2 {
    public static void main(String args[])
    {
        // A lambda expression that tests if a number is even.
        NumericTest isEven = (n) -> (n % 2)==0;
        if(isEven.test(10)) System.out.println("10 is even");
        if(!isEven.test(9)) System.out.println("9 is not even");
        // Now, use a lambda expression that tests if a number
        // is non-negative.
        NumericTest isNonNeg = (n) -> n >= 0;
        if(isNonNeg.test(1)) System.out.println("1 is non-negative");
        if(!isNonNeg.test(-1)) System.out.println("-1 is negative");
    }
}


// Demonstrate a lambda expression that takes two parameters.
interface NumericTest2 {
    boolean test(int n, int d);
}
class LambdaDemo3 {
    public static void main(String args[])
    {
        // This lambda expression determines if one number is
        // a factor of another.
        NumericTest2 isFactor = (n, d) -> (n % d) == 0;
        if(isFactor.test(10, 2))
            System.out.println("2 is a factor of 10");
        if(!isFactor.test(10, 3))
            System.out.println("3 is not a factor of 10");
    }
}
