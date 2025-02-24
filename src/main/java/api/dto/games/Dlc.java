package api.dto.games;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dlc {
    private String description;
    private String dlcName;
    private boolean isDlcFree;
    private int price;
    private int rating;
    private SimilarDlc similarDlc;
}
