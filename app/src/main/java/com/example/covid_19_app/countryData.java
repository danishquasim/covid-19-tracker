package com.example.covid_19_app;

public class countryData {
    String countryName, countrycases,countrytoadaycases,countrdeaths,countrytodaydeaths,countryrecoverd,countrytodayrecovered ;

    public countryData(String countryName, String countrycases, String countrytoadaycases, String countrdeaths, String countrytodaydeaths, String countryrecoverd, String countrytodayrecovered) {
        this.countryName = countryName;
        this.countrycases = countrycases;
        this.countrytoadaycases = countrytoadaycases;
        this.countrdeaths = countrdeaths;
        this.countrytodaydeaths = countrytodaydeaths;
        this.countryrecoverd = countryrecoverd;
        this.countrytodayrecovered = countrytodayrecovered;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountrycases() {
        return countrycases;
    }

    public void setCountrycases(String countrycases) {
        this.countrycases = countrycases;
    }

    public String getCountrytoadaycases() {
        return countrytoadaycases;
    }

    public void setCountrytoadaycases(String countrytoadaycases) {
        this.countrytoadaycases = countrytoadaycases;
    }

    public String getCountrdeaths() {
        return countrdeaths;
    }

    public void setCountrdeaths(String countrdeaths) {
        this.countrdeaths = countrdeaths;
    }

    public String getCountrytodaydeaths() {
        return countrytodaydeaths;
    }

    public void setCountrytodaydeaths(String countrytodaydeaths) {
        this.countrytodaydeaths = countrytodaydeaths;
    }

    public String getCountryrecoverd() {
        return countryrecoverd;
    }

    public void setCountryrecoverd(String countryrecoverd) {
        this.countryrecoverd = countryrecoverd;
    }

    public String getCountrytodayrecovered() {
        return countrytodayrecovered;
    }

    public void setCountrytodayrecovered(String countrytodayrecovered) {
        this.countrytodayrecovered = countrytodayrecovered;
    }
}
