package api.dto.games;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Requirements {
    private int hardDrive;
    private String osName;
    private int ramGb;
    private String videoCard;
}
