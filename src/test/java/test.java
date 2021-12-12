import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = SpringBootApplication.class)
public class test {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;



    @BeforeClass
    public static void testBeforeClass(){
        System.out.println("BeforeClass");
    }

    @Before
    public void testBefore(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        System.out.println("Before");
    }

    @Test
    public void webTest() throws Exception {
        mockMvc.perform(
                post("http://localhost:8080/test")
        )
                .andExpect(status().is4xxClientError())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void test(){
        System.out.println(1000);
    }
    @Test
    public void test2(){
        System.out.println(2000);
    }

    @After
    public void after(){
        System.out.println("After");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("AfterClass");
    }
}
