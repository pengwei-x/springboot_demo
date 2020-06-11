package schema.原型模式;

/**
 * @author pengwei
 * @date 2020/5/24
 */
public class Test extends Person {

    public void test() throws CloneNotSupportedException {
        getClone();
    }
    public static void main(String[] args) {
        Person person = new Person();
        try {
            Person clone = person.getClone();
            System.out.println(person==clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
