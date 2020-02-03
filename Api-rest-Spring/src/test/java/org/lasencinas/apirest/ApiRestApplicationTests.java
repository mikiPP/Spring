package org.lasencinas.apirest;

import com.sun.xml.internal.ws.api.pipe.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiRestApplicationTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void contextLoads() {
    }


    @Test
    public void testPeticionesGet() throws  Exception{
        mockMvc.perform(get("/topics/spring"))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                        .andExpect(content().json("{'id':'spring','name':'Spring Framework','description':'Spring Framework Description'}"));
    }


    @Test
    public void testFindAll() throws Exception{

        mockMvc.perform(get("/topics"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':'spring','name':'Spring Framework','description':'Spring Framework Description'}," +
                                                        "{'id':'java','name':'Core Java','description':'Core Java Description'},"+
                                                         "{'id':'javascript','name':'JavaScript','description':'JavaScript Description'}]"));
    }


    @Test
    public void testPostTopic() throws Exception{

        mockMvc.perform(post("/topics")
                 .content("{'id':'pruebaId','name':'TestName','description':'DescriptionTest'}")
                 .contentType("application/json"))
                .andExpect(status().isOk());

    }



    @Test
    public void testPutTopic() throws Exception{

        mockMvc.perform(put("/topics/spring")
                .content("{'id':'spring','name':'SpringUpdated','description':'DescriptionUpdated'}")
                .contentType("application/json"))
                .andExpect(status().isOk());

        mockMvc.perform(get("topics/spring"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id':'spring','name':'SpringUpdated','description':'DescriptionUpdated'}"));
    }


    @Test
    public void testDeleteTopic() throws Exception{
        mockMvc.perform(delete("/topics/javascript"))
                .andExpect(status().isOk());

        mockMvc.perform(get("topics/javascript"))
                .andExpect(status().is(404));
    }

}
