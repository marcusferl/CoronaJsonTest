package de.codingbaker;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONException;

public class App implements Fix {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
             JsonParser parse = new JsonParser();
                try {
                    System.out.println("Tode = " + parse.readJsonFormUrl("https://api.corona-zahlen.org/germany").get(deaths));
                    System.out.println("Infizierte = " + parse.readJsonFormUrl("https://api.corona-zahlen.org/germany").get(cases));
                    System.out.println("Infiziert pro Woche = " + parse.readJsonFormUrl("https://api.corona-zahlen.org/germany").get(casesPerWeek));
                    System.out.println("Genesen = " + parse.readJsonFormUrl("https://api.corona-zahlen.org/germany").get(recovered));
                    System.out.println("Wochen Inzidenz = " + parse.readJsonFormUrl("https://api.corona-zahlen.org/germany").get(weekIncidence));
                } catch (JSONException e) {
                   
                    e.getMessage();
                } catch (MalformedURLException e) {
                   
                    e.getMessage();
                } catch (IOException e) {
                    e.getMessage();
                }

            }

        },10000,20000);

    }
}
