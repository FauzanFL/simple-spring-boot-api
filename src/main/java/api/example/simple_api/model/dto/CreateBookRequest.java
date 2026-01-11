package api.example.simple_api.model.dto;

public record CreateBookRequest(
    String title, 
    String author, 
    String description
) {}