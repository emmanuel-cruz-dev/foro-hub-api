package foro.hub.api.topic;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataRegisterTopic(
        @NotNull @JsonProperty("idAutor") Long idAuthor,
        @NotBlank @JsonProperty("mensaje") String message,
        @NotBlank @JsonProperty("nombreCurso") String nameCourse,
        @NotBlank @JsonProperty("titulo") String title
) {
}
