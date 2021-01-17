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

import models.Patient_data;

public class mainBreastCancer {
    public static void main(String[] args) {
        List<Patient_data> patient_data = readPatientDataFromCsv("C:\\Users\\Firas\\IdeaProjects\\breast_cancer_clean.csv");

        System.out.println(" ==== Total number of cases : ".toUpperCase() + patient_data.stream().count());

        System.out.println("A benign tumor is not a malignant tumor, which is cancer. It does not invade nearby tissue or spread \n " +
                "to other parts of the body the way cancer can. In most cases, the outlook with benign \n  " +
                "tumors is very good. But benign tumors can be serious if they press on vital structures \n " +
                " such as blood vessels or nerves.");
        System.out.println(" ");

        System.out.print("==== Total number of benign tumors :".toUpperCase());

        System.out.println(patient_data.stream().filter(v -> v.getDiagnosis().contains("B"))
                .count());

        System.out.print("==== Total number of malignant tumors :".toUpperCase());

        System.out.println(patient_data.stream().filter(v -> v.getDiagnosis().contains("M"))
                .count());
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
