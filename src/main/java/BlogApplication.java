import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/28 23:43
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.hpl.blog"})
@MapperScan("com.hpl.blog.mapper")
public class BlogApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(BlogApplication.class, args);
    }
}
