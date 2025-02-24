package Fabric;

import api.dto.games.*;

import java.time.LocalDateTime;
import java.util.Collections;

public class UserFabric {
    public static User createDefaultUser() {
        return User.builder()
                .login("gerarr99")
                .pass("123321")
                .games(Collections.singletonList(createDefaultGame()))
                .build();
    }

    public static Game createDefaultGame() {
        return Game.builder()
                .gameId(1)
                .title("Cyberpunk 2077")
                .company("CD Projekt Red")
                .description("Futuristic RPG")
                .genre("RPG")
                .isFree(false)
                .price(60)
                .rating(9)
                .requiredAge(true)
                .publishDate(LocalDateTime.now())
                .tags(Collections.singletonList("Sci-Fi"))
                .requirements(Requirements.builder()
                        .hardDrive(70)
                        .osName("Windows 10")
                        .ramGb(16)
                        .videoCard("RTX 3070")
                        .build())
                .dlcs(Collections.singletonList(Dlc.builder()
                        .dlcName("Phantom Liberty")
                        .description("Expansion pack")
                        .isDlcFree(false)
                        .price(30)
                        .rating(9)
                        .similarDlc(SimilarDlc.builder()
                                .dlcNameFromAnotherGame("Blood and Wine")
                                .isFree(false)
                                .build())
                        .build()))
                .build();
    }
}
