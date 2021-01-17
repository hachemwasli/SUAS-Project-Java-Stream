package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient_data {

    int id;
    String diagnosis;
    double radiusMean;
    double textureMean;
    double perimeterMean;
    double areaMean;
    double smoothnessMean;
    double compactnessMean;
    double concativityMean;
    double concavePointsMean;
    double symmetryMean;
    double radiusWorst;
    double textureWorst;
    double perimeterWorst;
    double areaWorst;
    double smoothnessWorst;
    double compactnessWorst;
    double concativityWorst;
    double concavePointsWorst;
    double symmetryWorst;
    double fractaldimensionsWorst;

    public Patient_data(){

    }

    public Patient_data(int id, String diagnosis, double radiusMean, double textureMean, double perimeterMean, double areaMean, double smoothnessMean, double compactnessMean, double concativityMean, double concavePointsMean, double symmetryMean, double radiusWorst, double textureWorst, double perimeterWorst, double areaWorst, double smoothnessWorst, double compactnessWorst, double concativityWorst, double concavePointsWorst, double symmetryWorst, double fractaldimensionsWorst) {
        this.id = id;
        this.diagnosis = diagnosis;
        this.radiusMean = radiusMean;
        this.textureMean = textureMean;
        this.perimeterMean = perimeterMean;
        this.areaMean = areaMean;
        this.smoothnessMean = smoothnessMean;
        this.compactnessMean = compactnessMean;
        this.concativityMean = concativityMean;
        this.concavePointsMean = concavePointsMean;
        this.symmetryMean = symmetryMean;
        this.radiusWorst = radiusWorst;
        this.textureWorst = textureWorst;
        this.perimeterWorst = perimeterWorst;
        this.areaWorst = areaWorst;
        this.smoothnessWorst = smoothnessWorst;
        this.compactnessWorst = compactnessWorst;
        this.concativityWorst = concativityWorst;
        this.concavePointsWorst = concavePointsWorst;
        this.symmetryWorst = symmetryWorst;
        this.fractaldimensionsWorst = fractaldimensionsWorst;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public double getRadiusMean() {
        return radiusMean;
    }

    public void setRadiusMean(double radiusMean) {
        this.radiusMean = radiusMean;
    }

    public double getTextureMean() {
        return textureMean;
    }

    public void setTextureMean(double textureMean) {
        this.textureMean = textureMean;
    }

    public double getPerimeterMean() {
        return perimeterMean;
    }

    public void setPerimeterMean(double perimeterMean) {
        this.perimeterMean = perimeterMean;
    }

    public double getAreaMean() {
        return areaMean;
    }

    public void setAreaMean(double areaMean) {
        this.areaMean = areaMean;
    }

    public double getSmoothnessMean() {
        return smoothnessMean;
    }

    public void setSmoothnessMean(double smoothnessMean) {
        this.smoothnessMean = smoothnessMean;
    }

    public double getCompactnessMean() {
        return compactnessMean;
    }

    public void setCompactnessMean(double compactnessMean) {
        this.compactnessMean = compactnessMean;
    }

    public double getConcativityMean() {
        return concativityMean;
    }

    public void setConcativityMean(double concativityMean) {
        this.concativityMean = concativityMean;
    }

    public double getConcavePointsMean() {
        return concavePointsMean;
    }

    public void setConcavePointsMean(double concavePointsMean) {
        this.concavePointsMean = concavePointsMean;
    }

    public double getSymmetryMean() {
        return symmetryMean;
    }

    public void setSymmetryMean(double symmetryMean) {
        this.symmetryMean = symmetryMean;
    }

    public double getRadiusWorst() {
        return radiusWorst;
    }

    public void setRadiusWorst(double radiusWorst) {
        this.radiusWorst = radiusWorst;
    }

    public double getTextureWorst() {
        return textureWorst;
    }

    public void setTextureWorst(double textureWorst) {
        this.textureWorst = textureWorst;
    }

    public double getPerimeterWorst() {
        return perimeterWorst;
    }

    public void setPerimeterWorst(double perimeterWorst) {
        this.perimeterWorst = perimeterWorst;
    }

    public double getAreaWorst() {
        return areaWorst;
    }

    public void setAreaWorst(double areaWorst) {
        this.areaWorst = areaWorst;
    }

    public double getSmoothnessWorst() {
        return smoothnessWorst;
    }

    public void setSmoothnessWorst(double smoothnessWorst) {
        this.smoothnessWorst = smoothnessWorst;
    }

    public double getCompactnessWorst() {
        return compactnessWorst;
    }

    public void setCompactnessWorst(double compactnessWorst) {
        this.compactnessWorst = compactnessWorst;
    }

    public double getConcativityWorst() {
        return concativityWorst;
    }

    public void setConcativityWorst(double concativityWorst) {
        this.concativityWorst = concativityWorst;
    }

    public double getConcavePointsWorst() {
        return concavePointsWorst;
    }

    public void setConcavePointsWorst(double concavePointsWorst) {
        this.concavePointsWorst = concavePointsWorst;
    }

    public double getSymmetryWorst() {
        return symmetryWorst;
    }

    public void setSymmetryWorst(double symmetryWorst) {
        this.symmetryWorst = symmetryWorst;
    }

    public double getFractaldimensionsWorst() {
        return fractaldimensionsWorst;
    }

    public void setFractaldimensionsWorst(double fractaldimensionsWorst) {
        this.fractaldimensionsWorst = fractaldimensionsWorst;
    }

    @Override
    public String toString() {
        return "Patient_data{" +
                "id=" + id +
                ", diagnosis=" + diagnosis +
                ", radiusMean=" + radiusMean +
                ", textureMean=" + textureMean +
                ", perimeterMean=" + perimeterMean +
                ", areaMean=" + areaMean +
                ", smoothnessMean=" + smoothnessMean +
                ", compactnessMean=" + compactnessMean +
                ", concativityMean=" + concativityMean +
                ", concavePointsMean=" + concavePointsMean +
                ", symmetryMean=" + symmetryMean +
                ", radiusWorst=" + radiusWorst +
                ", textureWorst=" + textureWorst +
                ", perimeterWorst=" + perimeterWorst +
                ", areaWorst=" + areaWorst +
                ", smoothnessWorst=" + smoothnessWorst +
                ", compactnessWorst=" + compactnessWorst +
                ", concativityWorst=" + concativityWorst +
                ", concavePointsWorst=" + concavePointsWorst +
                ", symmetryWorst=" + symmetryWorst +
                ", fractaldimensionsWorst=" + fractaldimensionsWorst +
                '}';
    }
}
