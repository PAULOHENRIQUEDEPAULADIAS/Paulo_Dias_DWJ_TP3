package org.example.dtos;

public record Items(
        String type,
        String isbn13,
        double price,
        int numberinstock
) {
    public Items {
    }
}
