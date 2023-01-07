package GameServise.process;

import GameServise.files.LoggerFile;
import GameServise.user.CreateUser;
import GameServise.user.Player;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Engine {
    private ResourceBundle resourceBundle;


    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    public void runGame() throws IOException, URISyntaxException {
        LoggerFile log = new LoggerFile();
        Scanner sc = new Scanner(System.in);
        List<Locale> localeList = List.of(
                new Locale("de"),
                new Locale("en"),
                new Locale("uk"));
        Locale.setDefault(Locale.forLanguageTag("uk"));

        System.out.println("Choose language\nВиберіть мову\nSprache wählen");
        System.out.println("1-Deutsch 2-English 3-Українська");
        int language;
        do {
            language =sc.nextInt();
            if (!List.of(1, 2, 3).contains(language)) {
                log.warn("an invalid value was entered -> " + language);
            }
        }while (!List.of(1, 2, 3).contains(language));
        Locale locale = localeList.get(language-1);
        resourceBundle = ResourceBundle.getBundle("RPS", locale);
                    Player player = new CreateUser().createNewPlayer(resourceBundle);

                new GameProcess().startGame(player, resourceBundle);
//        statistic.endGame();

            }


        }
