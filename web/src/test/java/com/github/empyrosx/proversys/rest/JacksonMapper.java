package com.github.empyrosx.proversys.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jackson mapper with customized properties.
 */
public class JacksonMapper extends ObjectMapper {

    private static final ObjectMapper MAPPER = new JacksonMapper();

    /**
     * Returns jackson mapper.
     *
     * @return {@link ObjectMapper}
     */
    public static ObjectMapper getMapper() {
        return MAPPER;
    }

    /**
     * Private constructor.
     */
    private JacksonMapper() {
        // excluding null values
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * Serializes any Java object as a string.
     *
     * @param value any Java object
     * @return json value
     */
    public static String toJson(Object value) {
        try {
            return getMapper().writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Invalid toJson to JSON:\n'" + value + "'", e);
        }
    }
}
