package by.pvt.start;

import by.pvt.i_face.Lyricist;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "ApplicationContext.xml");
        /*Lyricist lyr1 = context.getBean("Pushkin", Lyricist.class);
        System.out.println(lyr1.generate());
        */Lyricist lyr2 = context.getBean("Chukovskiy", Lyricist.class);
        System.out.println("\n" + lyr2.generate());
        context.close();
    }
}
