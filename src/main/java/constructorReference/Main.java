package constructorReference;

// Demonstrate a Constructor reference.
// MyFunc is a functional interface whose method returns
// a MyClass reference.
interface MyFunc {
    MyClass func(int a);
}
class MyClass {
    private int val;
    // This constructor takes an argument.
    MyClass(int v) {
        val = v;
        System.out.println("Constructor with one param");
    }
    // This is the default constructor.
    MyClass() {
        val = 0;
        System.out.println("Default constructor");
    }

    int getVal() { return val; };
}
class ConstructorRefDemo {
    public static void main(String args[])
    {
        // Create a reference to the MyClass constructor.
        // Because func() in MyFunc takes an argument, new
        // refers to the parameterized constructor in MyClass,
        // not the default constructor.
        MyFunc myClassCons = MyClass::new;
        // Create an instance of MyClass via that constructor reference.
        MyClass mc = myClassCons.func(10);
        // Use the instance of MyClass just created.
        System.out.println("val in mc is " + mc.getVal( ));
    }
}

