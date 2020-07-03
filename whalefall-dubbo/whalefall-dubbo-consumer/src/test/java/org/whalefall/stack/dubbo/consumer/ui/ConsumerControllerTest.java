package org.whalefall.stack.dubbo.consumer.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ConsumerControllerTest {
    @Autowired
    private ConsumerController consumerController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testNotNull() {
        Assertions.assertThat(consumerController).isNotNull();
    }

    @Test
    public void testGet() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/consumer/dubbo/demos/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello, spring"));
    }
}