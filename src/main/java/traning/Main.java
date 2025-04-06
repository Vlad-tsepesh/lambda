package traning;

interface MyFunc {
    MyClass func(String n);

}
class MyClass {
    String str;

    MyClass(String s) {str = s;}

    String getStr() {return str;}

}

class ConstructorReference {
//    static MyClass myClassFactory (MyFunc cons, String v) {
//        return cons.func(v);
//    }

//    MyFunc myClassCons = MyClass::new;

//    MyClass myClass = myClassFactory(myClassCons, "Hello");
    MyFunc myFunc = MyClass::new;
    MyClass myClass = myFunc.func("Hello");


    MyClass myClass2 = new MyClass("Hello");
}


