package Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
        public static void main(String[] args) {
            ApplicationContext context = new FileSystemXmlApplicationContext("//Users/dmp001j/IdeaProjects/spring4-restful-example/src/main/java/Spring/Beans.xml");
            TextEditor te = (TextEditor) context.getBean("textEditor");
            te.spellCheck();
        }
    }
