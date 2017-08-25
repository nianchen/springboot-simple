package org.jy.base.util.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmailsenderApplicationTests {
      @Autowired
    private EmailSender emailSender;

        @Test
        public void sender() {
            String to = "454255310@qq.com";
            String subject = "Test subject";
            String content = "Hello Spring boot Email.";

            boolean result = emailSender.sender(to, subject, content);
            System.out.println("-------------======---------------"+result);
        }

}
