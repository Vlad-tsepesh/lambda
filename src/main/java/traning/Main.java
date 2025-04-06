package traning;

interface MyFunc<R, T> {
    R func(T v);
}



class MyClass<T> {
    T val;

    MyClass(T v) {val = v;}

    T getStr() {return val;}

}

class ConstructorReference {
    static <R, T> R myClassFactory (MyFunc<R, T> cons, T v) {
        return cons.func(v);
    }

    MyClass<String> myClass = myClassFactory(MyClass::new, "Hello");

    MyFunc<MyClass<String>, String> myFunc = MyClass::new;
    MyClass<String> myClass2 = myFunc.func("Hello");


    MyClass<String> myClass3 = new MyClass<>("Hello");

}


