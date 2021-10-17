package pl.sda.eventsagregator.dev.mockdata;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class EventMockData {

    static final List<String> TITLES = List.of("Run Forest run", "Dance Dance Dance", "Rock simulator", "Ride or Die", "Egzorcysta");
    static final List<LocalDateTime> START_DATES = generateRandomDates(10);
    static final List<String> DESCRIPTIONS = List.of("Run all day, all night", "Awesome", "You gonna love it", "Stupid game", "I hate that shit but I'm gonna do this");

    static final Integer TITLES_COUNT = TITLES.size();
    static final Integer START_DATES_COUNT = START_DATES.size();
    static final Integer DESCRIPTIONS_COUNT = DESCRIPTIONS.size();

    private static List<LocalDateTime> generateRandomDates(int count) {
        final Random random = new Random();
        List<LocalDateTime> dates = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            long randomSeconds = random.nextInt(1608336000);
            LocalDateTime eventTime = LocalDateTime.ofEpochSecond(randomSeconds, 0, ZoneOffset.UTC).truncatedTo(ChronoUnit.MINUTES);
            dates.add(eventTime);
        }
        return dates;
    }
}
