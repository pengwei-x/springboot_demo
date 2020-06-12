import com.peng.spring.entiy.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.peng.spring.service.PersonService;

/**
 * @author pengwei
 * @date 2020/6/11
 */

public class ApplicationTest {

    @Test
    public void getBen(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("person", Person.class);
        Person person1 = context.getBean("person", Person.class);
        Person person2 = context.getBean("person2", Person.class);
        System.out.println(person==person1);
        System.out.println(person==person2);
        System.out.println(person);
        System.out.println(person2);
    }


    @Test
    public void test2(){
     ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService personService = (PersonService) applicationContext.getBean("personService");
        System.out.println(personService.toString());
    }


    @Test
    public void test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = applicationContext.getBean("person",Person.class);
        System.out.println(person);
    }
}
