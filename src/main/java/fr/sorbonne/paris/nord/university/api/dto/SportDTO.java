package fr.sorbonne.paris.nord.university.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
public class SportDTO {
    private long id;

    @NotEmpty
    private String name;

    @NotNull
    private List<TeamDTO> teams = new ArrayList<>();

}
