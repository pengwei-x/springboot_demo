package schema.原型模式;

/**
 * @author pengwei
 * @date 2020/5/24
 */
public class Person implements Cloneable {
    private  String  name;

    public Person(){

    }
    public Person(String name) {
        this.name = name;
    }

    public Person getClone() throws CloneNotSupportedException {
      return (Person) super.clone();
    }
}
