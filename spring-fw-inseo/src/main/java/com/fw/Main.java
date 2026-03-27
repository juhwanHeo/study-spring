import com.fw.week2.Person;
import com.fw.week3.Vegetable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("week3.xml");

        // 1. Person 먼저 호출
        Person person = context.getBean("inseo", Person.class);
        person.hello();

        System.out.println("-----");

        // 2. Vegetable 나중에 호출
        Vegetable veg = context.getBean("vegetable", Vegetable.class);
        veg.print();
    }
}