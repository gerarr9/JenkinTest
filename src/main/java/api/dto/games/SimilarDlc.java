package api.dto.games;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimilarDlc {
    private String dlcNameFromAnotherGame;
    private boolean isFree;
}
