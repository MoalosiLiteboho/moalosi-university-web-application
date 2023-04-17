package com.moalosi.model;

public record Material(
        int id,
        int courseId,
        String name,
        String filePath
) {
}
