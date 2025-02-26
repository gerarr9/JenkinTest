package extensions;

import api.dto.games.*;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

public class UserFabric {
    private static Faker faker = new Faker();

    public static User createDefaultUser() {
        return User.builder()
                .login("user" + faker.random().nextInt(10000))
                .pass("123321")
                .games(Collections.singletonList(createRandomGame()))
                .build();
    }

    public static Game createRandomGame() {

        SimilarDlc similarDlc = SimilarDlc.builder()
                .isFree(false)
                .dlcNameFromAnotherGame(faker.funnyName().name())
                .build();

        Dlc dlcsItem = Dlc.builder()
                .rating(faker.random().nextInt(10))
                .price(faker.random().nextInt(1, 500))
                .description(faker.funnyName().name())
                .dlcName(faker.dragonBall().character())
                .isDlcFree(false)
                .similarDlc(similarDlc).build();


        Requirements requirements = Requirements.builder()
                .ramGb(faker.random().nextInt(4, 16))
                .osName("Windows")
                .hardDrive(faker.random().nextInt(30, 70))
                .videoCard("NVIDEA")
                .build();


        return Game.builder()
                .requirements(requirements)
                .genre(faker.book().genre())
                .price(faker.random().nextInt(400))
                .description(faker.funnyName().name())
                .company(faker.company().name())
                .isFree(false)
                .title(faker.beer().name())
                .rating(faker.random().nextInt(10))
                .publishDate(LocalDateTime.now().toString())
                .requiredAge(faker.random().nextBoolean())
                .tags(Arrays.asList("shooter", "quests"))
                .dlcs(Collections.singletonList(dlcsItem))
                .build();
    }
}

