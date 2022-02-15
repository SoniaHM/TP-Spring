package fr.sorbonne.paris.nord.university.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PlayerDTO {
    private long id;

    @NotEmpty
    private String name;

    @Size(max=2)
    private String number;

    @Size(max = 100)
    private String position;

    @NotNull
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TeamDTO team;

}
