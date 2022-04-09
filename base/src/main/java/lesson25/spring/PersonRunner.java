package lesson25.spring;

import lesson25.spring.service.PersonService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonRunner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("/spring-context.xml");
        PersonService personService = (PersonService) classPathXmlApplicationContext.getBean("personService");
        PersonService newPersonService = (PersonService) classPathXmlApplicationContext.getBean("newPersonService");
//        PersonService personService = classPathXmlApplicationContext.getBean(PersonService.class);  // вызов контекста по имени класса/интерфейса, не работает если у интерфейса несколько импементаций
        personService.print();
        newPersonService.print();
    }
}
