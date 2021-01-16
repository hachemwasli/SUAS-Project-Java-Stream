package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import models.Covid;

public class mainCovid {
    public static void main(String[] args) {
        List<Covid> covid = readCovidFromCsv("covid19.csv");
        //print total data rows
        System.out.println(" **** Total data rows= ****\n".toUpperCase() + covid.stream().count());
        //Print Top  Province With The Most Confirmed Cases
        System.out.println("**** Top Province With The Most Confirmed Cases In 2020 ****\n".toUpperCase());
        covid.stream().sorted(Comparator.comparing(Covid::getConfirmed, (a, b) -> {
            if (a - b < 0)
                return 1;
            if (a - b > 0)
                return -1;
            else
                return 0;
        })).limit(1)
                .forEach(i -> System.out.println(i.getProvince() + "," + i.getCountry() + ": " + i.getConfirmed()));
        // Print Top Province With The Most Confirmed Cases In January 2020
        System.out.println(" **** Top Province With The Most Confirmed Cases  In January 2020 ****\n".toUpperCase());
        covid.stream().filter(i -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(i.getObservationDate());
            return calendar.get(Calendar.MONTH) == 1;
        })
                .sorted(Comparator.comparing(Covid::getConfirmed, (a, b) -> {
                    if (a - b < 0)
                        return 1;
                    if (a - b > 0)
                        return -1;
                    else
                        return 0;
                })).limit(1)
                .forEach(i -> System.out.println(i.getProvince() + "," + i.getCountry() + ": " + i.getConfirmed()));

        // Print Top Province With The Most Confirmed Cases In November 2020
        System.out.println("**** Top Province With The Most Confirmed Cases In November 2020 ****\n".toUpperCase());
        covid.stream().filter(i -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(i.getObservationDate());
            return calendar.get(Calendar.MONTH) == 11;
        })
                .sorted(Comparator.comparing(Covid::getConfirmed, (a, b) -> {
                    if (a - b < 0)
                        return 1;
                    if (a - b > 0)
                        return -1;
                    else
                        return 0;
                })).limit(1)
                .forEach(i -> System.out.println(i.getProvince() + "," + i.getCountry() + ": " + i.getConfirmed()));
        // Print Top Province With The Most Recovered  Cases In 2020
        System.out.println("**** Top Province With The Most Recovered Cases In 2020 ****\n".toUpperCase());
        covid.stream().filter(i -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(i.getObservationDate());
            return calendar.get(Calendar.MONTH) == 11;
        })
                .sorted(Comparator.comparing(Covid::getRecovered, (a, b) -> {
                    if (a - b < 0)
                        return 1;
                    if (a - b > 0)
                        return -1;
                    else
                        return 0;
                })).limit(1)
                .forEach(i -> System.out.println(i.getProvince() + "," + i.getCountry() + ": " + i.getRecovered()));
        // Print Top Province With The Most Deaths In 2020
        System.out.println("**** Top Province With The Most Deaths In 2020 ****\n".toUpperCase());
        covid.stream().filter(i -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(i.getObservationDate());
            return calendar.get(Calendar.MONTH) == 11;
        })
                .sorted(Comparator.comparing(Covid::getDeaths, (a, b) -> {
                    if (a - b < 0)
                        return 1;
                    if (a - b > 0)
                        return -1;
                    else
                        return 0;
                })).limit(1)
                .forEach(i -> System.out.println(i.getProvince() + "," + i.getCountry() + ": " + i.getDeaths()));
        // Print Top Province With The Most Active Case In 2020
        System.out.println("**** Top Province With The Most Active Case In 2020 ****\n".toUpperCase());
        covid.stream().filter(i -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(i.getObservationDate());
            return calendar.get(Calendar.MONTH) == 11;
        })
                .sorted(Comparator.comparing(Covid::getActive_case, (a, b) -> {
                    if (a - b < 0)
                        return 1;
                    if (a - b > 0)
                        return -1;
                    else
                        return 0;
                })).limit(1)
                .forEach(i -> System.out.println(i.getProvince() + "," + i.getCountry() + ": " + i.getActive_case()));
        // Print Covid19 Cases In China Grouped by Observation Date In 2020 !! Limited !! Remove limit() To See Full Result
        System.out.println("**** Covid19 Cases In China Grouped by ObservationDate In 2020 ****\n".toUpperCase());
        Map<Date, List<Covid>> myMap = covid.stream().filter(i -> i.getCountry().equals("China")).limit(10)
                .collect(Collectors.groupingBy(Covid::getObservationDate));

        for (Map.Entry<Date, List<Covid>> entry : myMap.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().stream().forEach(i -> System.out.println(i));
        }

        // Print Average Confirmed Cases For Each Country/Province // Output too long !! Limited !! Remove limit() To See Full Result
        System.out.println("**** Average Confirmed Cases for each Country/Province ****\n".toUpperCase());
        covid.stream().collect(Collectors.groupingBy(Covid::getProvince)).entrySet().stream()
                .map(i -> i.getValue().stream().mapToDouble(x -> x.getConfirmed()).average().getAsDouble()).forEach(i -> {
            covid.stream().limit(10).collect(Collectors.groupingBy(Covid::getProvince)).keySet()
                    .stream().forEach(c -> System.out.println(c + "= " + i));
        });
        //Print Provinces - Countries Where Deaths > 50 Thousand
        System.out.println("\n**** Provinces - Countries Where Deaths > 50 Thousand ****\n".toUpperCase());
        covid.stream().filter(v -> v.getDeaths() > (float) 50000)
                .forEach(v -> System.out.println(v.getProvince() + "," + v.getCountry() + ": " + v.getDeaths()));
        //Print Provinces - Countries Where Confirmed Cases > 2 Million
        System.out.println("\n**** Provinces - Countries Where Confirmed Cases > 2 Million ****\n".toUpperCase());
        covid.stream().filter(v -> v.getConfirmed() > (float) 2000000)
                .forEach(v -> System.out.println(v.getProvince() + "," + v.getCountry() + ": " + v.getConfirmed()));
    }
    private static List<Covid> readCovidFromCsv(String fileName) {
        List<Covid> covid = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String line = br.readLine();
            line = br.readLine();
            int i = 0;
            while (line != null) {
                i++;
              //  System.out.println("Line Number" + i + "" + line);
                String[] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                Covid covid19 = createCovid(attributes);
                if (covid19 != null)
                    covid.add(covid19);
                line = br.readLine();

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return covid;
    }

    public static Covid createCovid(String[] metadata) {
        String SNo = metadata[0];
        Date ObservationDate = new Date();
        try {
            ObservationDate = new SimpleDateFormat("MM/dd/yyyy").parse(metadata[1]);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String Province = metadata[2];
        String Country = metadata[3];
        float Confirmed = Float.parseFloat(metadata[4]);
        float Deaths = Float.parseFloat(metadata[5]);
        float Recovered = Float.parseFloat(metadata[6]);
        float Active_case = Float.parseFloat(metadata[7]);
        return new Covid(SNo, ObservationDate, Province, Country, Confirmed, Deaths, Recovered, Active_case);
    }
}