package com.example.ecomm.dto;


import java.util.Map;

public record MessageDto(String message, Map<String, String> details, int statusCode) {
}
