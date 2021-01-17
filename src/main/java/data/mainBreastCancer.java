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
import java.util.stream.IntStream;

import models.Patient_data;

public class mainBreastCancer {
    public static void main(String[] args) {
        List<Patient_data> patient_data = readPatientDataFromCsv("C:\\Users\\Firas\\IdeaProjects\\breast_cancer_clean.csv");

        long totalPatients = patient_data.stream().count();
        long totalBenignTumors = patient_data.stream().filter(v -> v.getDiagnosis().contains("B"))
                .count();
        long totalMalignantTumors = patient_data.stream().filter(v -> v.getDiagnosis().contains("M"))
                .count();
        System.out.println(" ==== Total number of cases : ".toUpperCase() + totalPatients);

        System.out.println("A benign tumor is not a malignant tumor, which is cancer. It does not invade nearby tissue or spread \n " +
                "to other parts of the body the way cancer can. In most cases, the outlook with benign \n  " +
                "tumors is very good. But benign tumors can be serious if they press on vital structures \n " +
                " such as blood vessels or nerves.");
        System.out.println(" ");

        System.out.print("==== Benign tumors : ".toUpperCase());

        System.out.println(totalBenignTumors + " | " + (float)(totalBenignTumors*100/totalPatients)+"% of total cases");

        System.out.print("==== Malignant tumors : ".toUpperCase());

        System.out.println(totalMalignantTumors + " | " + (float)(totalMalignantTumors*100/totalPatients)+"% of total cases");

        // Print Average Confirmed Cases For Each Country/Province // Output too long !! Limited !! Remove limit() To See Full Result
        System.out.println("**** Average Area Mean for each Diagnosis ****\n".toUpperCase());
//        patient_data.stream().collect(Collectors.groupingBy(Patient_data::getDiagnosis)).entrySet().stream()
//                .map(i -> i.getValue().stream().mapToDouble(x -> x.getAreaMean()).average().getAsDouble()).forEach(i -> {
//            patient_data.stream().collect(Collectors.groupingBy(Patient_data::getDiagnosis)).keySet()
//                    .stream().forEach(c -> System.out.println(c + "= " + i));
//        });

//        patient_data.stream().collect(Collectors.groupingBy(Patient_data::getDiagnosis)).entrySet().stream()
//                .map(i -> i.getValue().stream().mapToDouble(x -> x.getAreaMean()).average().getAsDouble()).forEach(i -> System.out.println( "= " + i));

        patient_data.stream()
                .filter(d -> d.getDiagnosis().equals("M"))
                .collect(Collectors.groupingBy(Patient_data::getDiagnosis)).entrySet().stream()
                .map(i -> i.getValue().stream().mapToDouble(x -> x.getAreaMean()).average().getAsDouble())
                .forEach(i -> {
            patient_data.stream().filter(d -> d.getDiagnosis().equals("M")).collect(Collectors.groupingBy(Patient_data::getDiagnosis)).keySet()
                    .stream().forEach(c -> System.out.println(c + "= " + i));
        });
        patient_data.stream()
                .filter(d -> d.getDiagnosis().equals("B"))
                .collect(Collectors.groupingBy(Patient_data::getDiagnosis)).entrySet().stream()
                .map(i -> i.getValue().stream().mapToDouble(x -> x.getAreaMean()).average().getAsDouble())
                .forEach(i -> {
                    patient_data.stream().filter(d -> d.getDiagnosis().equals("B")).collect(Collectors.groupingBy(Patient_data::getDiagnosis)).keySet()
                            .stream().forEach(c -> System.out.println(c + "= " + i));
                });


    }

    private static List<Patient_data> readPatientDataFromCsv(String fileName) {
        List<Patient_data> patient_data = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String line = br.readLine();
            line = br.readLine();
            int i = 0;
            while (line != null) {
                i++;
                String[] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                Patient_data patient = createPatientData(attributes);
                if (patient != null)
                    patient_data.add(patient);
                line = br.readLine();

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return patient_data;
    }

    public static double covariance(double[] xs, double[] ys) {
        double xmean = mean(xs);
        double ymean = mean(ys);
        return IntStream.range(0, Math.min(xs.length, ys.length))
                .parallel()
                .mapToDouble(i -> {
                    double numerator = (xs[i] - xmean) * (ys[i] - ymean);
                    double denominator = 2;
                    return numerator / denominator;
                })
                .sum();
    }

    public static double mean(double[] xs) {
        return Arrays.stream(xs).average().getAsDouble();
    }

    public void RadiusMean_AreaMean(List<Patient_data> patients){
        double[] radiusMean = new double[patients.size()];
        double[] areaMean = new double[patients.size()];
        int i = 0;
        System.out.println(patients);
        for (Patient_data patient : patients) {
            radiusMean[i] = patient.getRadiusMean();
            areaMean[i] = patient.getAreaMean();
            System.out.println("Covariance between radius mean and area mean: "+covariance(radiusMean,areaMean));

        }
    }

//    public void CDF(List<Patient_data> patients){
//        System.out.println("Cumulative distribution function is the probability that the variable takes a value less than or equal to x. P(X <= x)");
//        List<Patient_data> patient_data = new ArrayList<>();
//        patient_data = patients;
//
//        Collections.sort(patient_data, new Comparator<T>(){
//            public int compare(double patient_data.get, Transaction t2){
//                return t2.getValue().compareTo(t1.getValue());
//            }
//        });
//    }

    public static Patient_data createPatientData(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String diagnosis = metadata[1];
        double radiusMean = Double.parseDouble(metadata[2]);
        double textureMean = Double.parseDouble(metadata[3]);
        double perimeterMean = Double.parseDouble(metadata[4]);
        double areaMean = Double.parseDouble(metadata[5]);
        double smoothnessMean = Double.parseDouble(metadata[6]);
        double compactnessMean = Double.parseDouble(metadata[7]);
        double concativityMean = Double.parseDouble(metadata[8]);
        double concavePointsMean = Double.parseDouble(metadata[9]);
        double symmetryMean = Double.parseDouble(metadata[10]);
        double radiusWorst = Double.parseDouble(metadata[11]);
        double textureWorst = Double.parseDouble(metadata[12]);
        double perimeterWorst = Double.parseDouble(metadata[13]);
        double areaWorst = Double.parseDouble(metadata[14]);
        double smoothnessWorst = Double.parseDouble(metadata[15]);
        double compactnessWorst = Double.parseDouble(metadata[16]);
        double concativityWorst = Double.parseDouble(metadata[17]);
        double concavePointsWorst = Double.parseDouble(metadata[18]);
        double symmetryWorst = Double.parseDouble(metadata[19]);
        double fractaldimensionsWorst = Double.parseDouble(metadata[20]);

        return new Patient_data(id,  diagnosis,  radiusMean,  textureMean,  perimeterMean,  areaMean,  smoothnessMean,  compactnessMean,  concativityMean,  concavePointsMean,  symmetryMean,  radiusWorst,  textureWorst,  perimeterWorst,  areaWorst,  smoothnessWorst,  compactnessWorst,  concativityWorst,  concavePointsWorst,  symmetryWorst,  fractaldimensionsWorst);

    }
}
