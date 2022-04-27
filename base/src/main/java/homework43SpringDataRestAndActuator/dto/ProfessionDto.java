package homework43SpringDataRestAndActuator.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProfessionDto {
    @NotNull
    private Integer code;

    @NotNull
    @Size(min = 1, max = 120)
    private String name;

    public String getCodeForDeleteLink() {
        return String.format("prof_%s", code);
    }
}
