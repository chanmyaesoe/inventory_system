package net.javaguides.springboot.springboothelloworldtutorial.schedulingtasks;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Product;
import net.javaguides.springboot.springboothelloworldtutorial.service.impl.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class ScheduledTasks {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private ProductService productService;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Scheduled(cron="0 0 8 * * ?")
    public void reportCurrentTime() {
        List<Product> products = productService.selectProductByCount();

        if(products != null) { // check if there is any items which is going to be out of stock
            String text = "Dear Admin, \n\nThese items are going to be out stock. Please refill soon. \n\n";
            String product_name = "";
            for (Product name : products) {
                product_name = product_name + name.getProduct_name() + ", ";
            }
            product_name = product_name.substring(0, product_name.length() -1);
            String message = text + product_name;

            //send email
            SimpleMailMessage emailInfo = new SimpleMailMessage();
            emailInfo.setFrom("chanmyaesoe0@gmail.com");
            emailInfo.setTo("myomyosbo123@gmail.com");
            emailInfo.setSubject("Items are going to be out of stock");
            emailInfo.setText(message);
            emailSender.send(emailInfo);
            log.info( "send email successfully!");
        }

    }
}
