package com.springboot.study.springbootstudy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SpringBootStudyApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.webApplicationContext).build();
    }

    /*@Test
    public void contextLoads() {
    }*/

    @Test
    public void test1() throws Exception {
        mockMvc.perform(post("/test/test1").param("name", "abc").param("age", "12"))
                .andExpect(view().name("test")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void test2() throws Exception {
        String json = "{\"userName\":\"haha\",\"nickName\":\"heihei\"}";
        mockMvc.perform(post("/test/test2").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(view().name("test2")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void test3() throws Exception {
        String json = "{\"userName\":\"haha\",\"nickName\":\"heihei\"}";
        String retJson = mockMvc.perform(post("/test/test3").contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println(retJson);
    }
}
