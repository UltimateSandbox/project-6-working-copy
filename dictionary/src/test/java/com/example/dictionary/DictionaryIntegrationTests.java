package com.example.dictionary;

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
class DictionaryIntegrationTests {

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

        /*ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/hello/getMessage")
                                                                                 .accept(MediaType.APPLICATION_JSON))
                                                  .andDo(print())
                                                  .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String content = result.getResponse()
                               .getContentAsString();
        Entry messageObject = objectMapper.readValue(content, Entry.class);

        String expectedMessage = "Hello";
        String actualMessage = messageObject.getDefinition();

        log.info("Actual: [" + actualMessage + "]");
        assertEquals(expectedMessage, actualMessage);*/
    }

}
