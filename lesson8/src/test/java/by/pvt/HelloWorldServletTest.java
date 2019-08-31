package by.pvt;

import by.pvt.dto.SystemUsers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class HelloWorldServletTest {

    @Test
    public void testMapper() {
        SystemUsers systemUsers = new SystemUsers();
        systemUsers.setUsername("TestUser");
        systemUsers.setId(1001);
        systemUsers.setActive(true);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;

        try {
            json = objectMapper.writeValueAsString(systemUsers);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        assertNotNull(json);

        String jsonInput = "{\"id\":1002," +
                "\"username\":\"TestUser2\"," +
                "\"active\":false}";

        try {
            SystemUsers users =
                    objectMapper.readValue(jsonInput, SystemUsers.class);
            assertEquals(1002, users.getId(),0);
            System.out.println(users);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}