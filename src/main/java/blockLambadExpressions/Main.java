package blockLambadExpressions;

// A block lambda that computes the factorial of an int value.
interface NumericFunc {
    int func(int n);
}
class BlockLambdaDemo {
    public static void main(String args[]) {
        // This block lambda computes the factorial of an int value.
        NumericFunc factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++)
                result = i * result;
            return result;
        };
        System.out.println("The factoral of 3 is " + factorial.func(3));
        System.out.println("The factoral of 5 is " + factorial.func(5));
    }
}


// A block lambda that reverses the characters in a string.
interface StringFunc {
    String func(String n);
}
class BlockLambdaDemo2 {
    public static void main(String args[])
    {
        // This block lambda reverses the characters in a string.
        StringFunc reverse = (str) -> {
            String result = "";
            int i;
            for(i = str.length()-1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };
        System.out.println("Lambda reversed is " +
                reverse.func("Lambda"));
        System.out.println("Expression reversed is " +
                reverse.func("Expression"));
    }
}

// Use a generic functional interface with lambda expressions.
// A generic functional interface.
interface SomeFunc<T> {
    T func(T t);
}
class GenericFunctionalInterfaceDemo {
    public static void main(String args[])
    {
        // Use a String-based version of SomeFunc.
        SomeFunc<String> reverse = (str) -> {
            String result = "";
            int i;
            for(i = str.length()-1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };
        System.out.println("Lambda reversed is " +
                reverse.func("Lambda"));
        System.out.println("Expression reversed is " +
                reverse.func("Expression"));
        // Now, use an Integer-based version of SomeFunc.
        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for(int i=1; i <= n; i++)
                result = i * result;
            return result;
        };
        System.out.println("The factoral of 3 is " + factorial.func(3));
        System.out.println("The factoral of 5 is " + factorial.func(5));
    }
}