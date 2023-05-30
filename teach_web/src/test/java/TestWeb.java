import com.boot.teach.web.TeachSystemApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

@SpringBootTest(classes = TeachSystemApplication.class)
public class TestWeb {
    @Test
    public void uuidTest(){
        System.out.println(UUID.randomUUID());
    }

    @Test
    public void addPass(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456!Qaz");
        System.out.println(encode);
    }
}
