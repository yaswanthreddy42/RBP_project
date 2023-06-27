package com.movieApp.demo.Controller;

import org.apache.kafka.common.serialization.Serializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieApp.demo.Model.UserDTO;

public class UserDTOSerializer implements Serializer<UserDTO> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, UserDTO data) {
        try {
            return objectMapper.writeValueAsBytes(data.getUsername());
        } catch (Exception e) {
 
            throw new RuntimeException("Error serializing UserDTO: " + e.getMessage(), e);
        }
    }
}