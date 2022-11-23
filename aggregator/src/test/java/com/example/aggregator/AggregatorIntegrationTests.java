package com.example.aggregator;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
class AggregatorIntegrationTests {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    @BeforeAll
    public void initialization() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                                      .build();
    }

    @Test
    void messageTest() throws Exception {

        /*Process hello = Runtime.getRuntime().exec("java -jar ../hello/target/hello-1.0.0.jar");
        log.info("Hello PID[" + hello.pid() + "]");
        InputStream helloErrors = hello.getErrorStream();

        ByteSource byteSource = new ByteSource() {
            @Override
            public InputStream openStream() throws IOException {
                return helloErrors;
            }
        };

        String text = byteSource.asCharSource(Charsets.UTF_8).read();
        System.out.println(text);

        Process world = Runtime.getRuntime().exec("java -jar world/target/world-1.0.0.jar");
        log.info("World PID[" + hello.pid() + "]");

        Thread.sleep(10000);

        ResultActions resultActions = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/getMessage")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String content = result.getResponse().getContentAsString();
        AggregatorMessage messageObject = objectMapper.readValue(content, AggregatorMessage.class);

        String expectedMessage = "Hello World!";
        String actualMessage = messageObject.getMessage();

        log.info("Actual: [" + actualMessage + "]");
        assertEquals(expectedMessage, actualMessage);*/


    }

}
