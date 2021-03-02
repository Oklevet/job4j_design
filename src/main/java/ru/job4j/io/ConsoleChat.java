package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private static final String ENTER = System.lineSeparator();
    private static boolean continueAnswer = true;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> answers = new ArrayList<>();
        List<String> dialog = new ArrayList<>();
        try (BufferedReader fileAns = new BufferedReader(new FileReader(botAnswers))) {
            String s;
            while ((s = fileAns.readLine()) != null) {
                answers.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       try (BufferedReader chat = new BufferedReader(new InputStreamReader(System.in))) {
            String str = chat.readLine();
            while (!str.equals(OUT)) {
                dialog.add(str + ENTER);
                switch (str) {
                    case STOP:
                        continueAnswer = false;
                        break;
                    case CONTINUE:
                        continueAnswer = true;
                        break;
                    default:
                        break;
                }
                if (continueAnswer) {
                    String answer = answers.get((int) (Math.random() * (answers.size() - 1)));
                    System.out.println(answer);
                    dialog.add(answer + ENTER);
                }
                str = chat.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       printDialogListToLog(dialog);
    }

    public void printDialogListToLog(List<String> dialog) {
         try (BufferedWriter log = new BufferedWriter(new FileWriter(path))) {
             for (String s : dialog) {
                 log.write(s);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./src/data/logChatBot.txt", "./src/data/answers.txt");
        cc.run();
    }
}