package methodReferencesWithGenerics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

// Demonstrate a method reference to a generic method
// declared inside a non-generic class.
// A functional interface that operates on an array
// and a value, and returns an int result.
interface MyFunc<T> {
    int func(T[] vals, T v);
}
// This class defines a method called countMatching() that
// returns the number of items in an array that are equal
// to a specified value. Notice that countMatching()
// is generic, but MyArrayOps is not.
class MyArrayOps {
    static <T> int countMatching(T[] vals, T v) {
        int count = 0;
        for(int i=0; i < vals.length; i++)
            if(vals[i] == v) count++;
        return count;
    }
}
class GenericMethodRefDemo {
    // This method has the MyFunc functional interface as the
    // type of its first parameter. The other two parameters
    // receive an array and a value, both of type T.
    static <T> int myOp(MyFunc<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }
    public static void main(String args[])
    {
        Integer[] vals = { 1, 2, 3, 4, 2, 3, 4, 4, 5 };
        String[] strs = { "One", "Two", "Three", "Two" };
        int count;
        count = myOp(MyArrayOps::<Integer>countMatching, vals, 4);
        System.out.println("vals contains " + count + " 4s");
        count = myOp(MyArrayOps::<String>countMatching, strs, "Two");
        System.out.println("strs contains " + count + " Twos");
    }
}

// Use a method reference to help find the maximum value in a collection.
class MyClass {
    private int val;
    MyClass(int v) { val = v; }
    int getVal() { return val; }
    @Override
    public String toString() {
        return "" + val;
    }
}
class UseMethodRef {
    // A compare() method compatible with the one defined by Comparator<T>.
    static int compareMC(MyClass a, MyClass b) {
        return a.getVal() - b.getVal();
    }
    public static void main(String args[])
    {
        ArrayList<MyClass> al = new ArrayList<>();
        al.add(new MyClass(1));
        al.add(new MyClass(4));
        al.add(new MyClass(2));
        al.add(new MyClass(9));
        al.add(new MyClass(3));
        al.add(new MyClass(7));
        // Find the maximum value in al using the compareMC() method.
        MyClass maxValObj = Collections.max(al, UseMethodRef::compareMC);
        System.out.println("Maximum value is: " + maxValObj.getVal());

        //the same using streamAPI
        al.stream()
                .max(Comparator.comparingInt(MyClass::getVal)).ifPresent(n -> System.out.println("Maximum value is: " + n));

        //using streamAPI to get the second max value
        al.stream()
                .sorted(Comparator.comparing(MyClass::getVal).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(n -> System.out.println("Second maximum value is: " + n));

    }
}