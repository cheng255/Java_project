package Test03;


import java.util.Arrays;

/**
 * @author nuonuo
 * @create 2020-08-03 10:11
 */
class B {
    public int Func() {
        System.out.print("B");
        return 0;
    }
}
class D extends B {
    @Override
    public int Func() {
        System.out.print("D");
        return 0;
    }
}
class Test {
    public static void main(String[] args) {
        B a = new B();
        B b = new D();
        a.Func();
        b.Func();
    }
}
class X{
    Y y=new Y();
    public X(){
        System.out.print("X");
    }
}
class Y{
    public Y(){
        System.out.print("Y");
    }
}
class Z extends X{
    Y y=new Y();
    public Z(){
        System.out.print("Z");
    }
    public static void main1(String[] args) {
        new Z();
    }
}
class Student {
    String name;
    int age;
    double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
public class java01 {
    public static void main1(String[] args) {
        Student[] s = new Student[3];
        s[0] = new Student("张三", 10, 100.0);
        s[1] = new Student("李四", 30, 80.0);
        s[2] = new Student("王五", 20, 90.0);
        Arrays.sort(s, (o1, o2) -> o2.age - o1.age);
        System.out.println(Arrays.toString(s));
        int[] arr1 = new int[3];
        int[] arr2 = arr1.clone();
        arr2[0] = 1;
        System.out.println(arr1[0]);
    }

}
