package api.dto.games;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game {
    private String company;
    private String description;
    private List<Dlc> dlcs;
    private int gameId;
    private String genre;
    private boolean isFree;
    private int price;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private LocalDateTime publishDate;
    private int rating;
    private boolean requiredAge;
    private Requirements requirements;
    private List<String> tags;
    private String title;
}
