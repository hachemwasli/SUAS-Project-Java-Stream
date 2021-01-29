/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import models.Conflict;
import models.Country;

/**
 *
 * @author psn
 */
public class mainConflicts {
    
    private final String[] event_types = {"battles","riots","explosions/remote violence"}; 

    public mainConflicts() {
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println("***********PROGRAM START*************");
        System.out.println("*************************************");
        System.out.println("***********PROGRAM START*************");
        System.out.println("*************************************");
        
        
        //Loading dataset into List
        System.out.println("Loading dataset..");
        String filePath = System.getProperty("user.dir") + "/conflicts.csv";
        
        List<Conflict> datasetList = Files.readAllLines(Paths.get(filePath))
                                         .stream()
                                         .skip(1)
                                         .map(line -> {
                                             String[] attributes = line
                                                     .split(",");
                                             return new Conflict(attributes);
                                          })
                                         .collect(Collectors.toList());
        datasetList.stream()
                .limit(5)
                .forEach(System.out::println);
        
        //Getting a list of all countries in the dataset mapped as Name, ISO
        List<Country> countryList = datasetList.stream()
                .filter(distinctByKey(p -> p.getCountry()))
                .map( a -> {
                  return new Country(a.getCountry(),a.getIso());
                })
                .collect(Collectors.toList());
        
        //Getting a list of all regions in the dataset
        List<String> regionList = datasetList.stream()
                .filter(distinctByKey(p -> p.getCountry()))
                .map( a -> {
                  return a.getRegion();
                })
                .distinct()
                .collect(Collectors.toList());
      
        regionList.stream().forEach(System.out::println);
        
        System.out.println("*************************************");
        System.out.println("*************************************\n");
        // Query 1 start
        System.out.println("How many violent events by country ? \nBattles/Riots/Explosions/Remote violence\n");
        countryList.forEach(c -> {
            System.out.println(c.getName() + " : " + AllViolentEventsByCountry(datasetList, c.getName()).stream()
                    .count()
            );
        });
        
        //Query 2 start
        System.out.println("\n*************************************\n");
        System.out.println("How many violent events by region ? \n");
        regionList.forEach(c -> {
            System.out.println(c + " : " + AllViolentEventsByRegion(datasetList, c).stream()
                    .count()
            );
        });
        
        //Query 3 start
        System.out.println("\n*************************************\n");
        System.out.println("Most Violent Actors by country (Algeria) \n");
        Stream
                .of(
                        MostViolentActor1ByCountry(datasetList, "Algeria"),
                        MostViolentActor2ByCountry(datasetList, "Algeria")
                )
                .flatMap(map -> map.entrySet().stream())
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingLong(Map.Entry::getValue)))
                .forEach((k, v) -> System.out.println( k + " : " + v));
        
        //Query 4 start
//        System.out.println("\n*************************************\n");
//        System.out.println("Political Militia presence in Africa every year \n");
//        PoliticalMilitiaPresence(datasetList)
//                .forEach((k, v) -> System.out.println( k + " : " + v));
        
        //Query 4 start
        System.out.println("\n*************************************\n");
        System.out.println("Violence against civilians by month \n");
        ViolanceCiviliansByMonth(datasetList)
                .forEach((k, v) -> System.out.println( k + " : " + v));
    }
    
    
    
    // How many  violent events by country?
    public static List<Conflict> AllViolentEventsByCountry(List<Conflict> list, String country){
        return list
                .stream()
                .filter( e -> e.getCountry().equalsIgnoreCase(country))
                .filter( e -> e.isViolent())
                .collect(Collectors.toList());
    }
    
    // How many violent events by region?
    public static List<Conflict> AllViolentEventsByRegion(List<Conflict> list, String region){
        return list
                .stream()
                .filter( e -> e.getRegion().equalsIgnoreCase(region))
                .filter( e -> e.isViolent())
                .collect(Collectors.toList());
    }
    
    // Whats the most participating actors in violent events by countries?
    public static Map<String, Long> MostViolentActor1ByCountry(List<Conflict> list, String country){
        return list
                .stream()
                .filter( e -> e.getCountry().equalsIgnoreCase(country))
                .filter( e -> e.isViolent())
                .collect(Collectors.groupingBy(Conflict::getActor1, Collectors.counting()))
                    ;
    }
    public static Map<String, Long> MostViolentActor2ByCountry(List<Conflict> list, String country){
        return list
                .stream()
                .filter( e -> !e.getActor2().isEmpty())
                .filter( e -> e.getCountry().equalsIgnoreCase(country))
                .filter( e -> e.isViolent())
                .collect(Collectors.groupingBy(Conflict::getActor2, Collectors.counting()))
                    ;
    }
    
    // Political Militia presence by year
    public static Map<String, Long> PoliticalMilitiaPresence(List<Conflict> list){
        return list
                .stream()
                .map((t) -> {
                    t.setEvent_date(t.getEvent_date().substring(0, 4));
                    return t;
                })
                .filter( e -> e.getInteraction().contains("3"))
                .collect(Collectors.groupingBy(Conflict::getEvent_date, Collectors.counting()))
                    ;
    }
    
    // Violance against civilians
    public static Map<String, Long> ViolanceCiviliansByMonth(List<Conflict> list){
        return list
                .stream()
                .map((t) -> {
                    LocalDate date = LocalDate.parse(t.getEvent_date(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    t.setEvent_date(date.format(DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH)));
                    return t;
                })
                .filter( e -> e.getInteraction().contains("2"))
                .collect(Collectors.groupingBy(Conflict::getEvent_date, Collectors.counting()))
                    ;
    }
    
    
    //How many peaceful protests by country?
    public List<Conflict> AllPeacefulProtestsByCountry(List<Conflict> list, String country){
        return null;
    }
    
    
    // How many fataliries by year in country?
    public List<Conflict> CountFatalitiesByYearAndCountry(List<Conflict> list, String country){
        return null;
    }
    
    // Where were the most fatalties so far?
    
    // Who is the most active group in participating in violent events?
    
    // Most fatalties event by country XX?
    
    // Top sources by country
    
    // Number of battles in Africa and top countries
    
    //List of all countries
    public static List<Country> getAllCountries(List<Conflict> list){
        return list.stream()
                .filter(distinctByKey(p -> p.getCountry()))
                .map( a -> {
                  return new Country(a.getCountry(),a.getIso());
                })
                .collect(Collectors.toList());
    }
    
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
    
}
