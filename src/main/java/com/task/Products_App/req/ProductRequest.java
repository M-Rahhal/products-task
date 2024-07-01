package com.task.Products_App.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import org.springframework.lang.NonNull;

public record ProductRequest(
        @JsonProperty(value = "name") @NonNull String name,
        @JsonProperty(value = "description") String description,
        @JsonProperty(value = "price") @NonNull Double price

) {
}
