package traning;

interface MyFunc<R, T> {
    R func(T n);

}
class MyClass {
    String str;

    MyClass(String s) {str = s;}

    String getStr() {return str;}

}

class ConstructorReference {
    static <R, T> R myClassFactory (MyFunc<R, T> cons, T v) {
        return cons.func(v);
    }

    MyFunc<MyClass, String> myClassCons = MyClass :: new;

    MyClass myClass = myClassFactory(myClassCons, "Hello");
}


