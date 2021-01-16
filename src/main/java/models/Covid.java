package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Covid {

    String SNo;
    Date ObservationDate;
    String Province;
    String Country;
    float Confirmed;
    float Deaths;
    float Recovered;
    float Active_case;

    public Covid(String SNo, Date observationDate, String province, String country, float confirmed, float deaths, float recovered, float active_case) {
        this.SNo = SNo;
        ObservationDate = observationDate;
        Province = province;
        Country = country;
        Confirmed = confirmed;
        Deaths = deaths;
        Recovered = recovered;
        Active_case = active_case;
    }

    public String getSNo() {
        return SNo;
    }

    public void setSNo(String SNo) {
        this.SNo = SNo;
    }

    public Date getObservationDate() {
        return ObservationDate;
    }

    public void setObservationDate(Date observationDate) {
        ObservationDate = observationDate;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public float getConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(float confirmed) {
        Confirmed = confirmed;
    }

    public float getDeaths() {
        return Deaths;
    }

    public void setDeaths(float deaths) {
        Deaths = deaths;
    }

    public float getRecovered() {
        return Recovered;
    }

    public void setRecovered(float recovered) {
        Recovered = recovered;
    }

    public float getActive_case() {
        return Active_case;
    }

    public void setActive_case(float active_case) {
        Active_case = active_case;
    }

    public int customStringParser() {
        String toParse = this.Country;

        char[] charArray = toParse.toCharArray();
        List<Character> myList = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            myList.add(charArray[i]);
        }
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i) == ",".toCharArray()[0] || myList.get(i) == "+".toCharArray()[0]) {
                myList.remove(i);
            }
        }
        char[] toReturn = new char[50];
        for (int i = 0; i < myList.size(); i++) {
            toReturn[i] = myList.get(i);
        }

        String finalString = new String(toReturn);
        return (int) Float.parseFloat(finalString);
    }

    @Override
    public String toString() {
        return "Covid{" +
                "SNo='" + SNo + '\'' +
                ", ObservationDate=" + ObservationDate +
                ", Province='" + Province + '\'' +
                ", Country='" + Country + '\'' +
                ", Confirmed=" + Confirmed +
                ", Deaths=" + Deaths +
                ", Recovered=" + Recovered +
                ", Active_case=" + Active_case +
                '}';
    }
}

