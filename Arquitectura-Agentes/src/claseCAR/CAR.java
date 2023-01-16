package claseCAR;

import java.io.Serializable;

public class CAR implements Serializable {
    private int lands, cheap, format, nm_mdfc;
    private double average;
    private int my_mdfc, presen, wins, losses, month, year;

    public CAR(int lands, int cheap, int format, int nm_mdfc, double average, int my_mdfc, int presen, int wins, int losses, int month, int year) {
        this.lands = lands;
        this.cheap = cheap;
        this.format = format;
        this.nm_mdfc = nm_mdfc;
        this.average = average;
        this.my_mdfc = my_mdfc;
        this.presen = presen;
        this.wins = wins;
        this.losses = losses;
        this.month = month;
        this.year = year;
    }

    public int getLands() {
        return lands;
    }

    public void setLands(int lands) {
        this.lands = lands;
    }

    public int getCheap() {
        return cheap;
    }

    public void setCheap(int cheap) {
        this.cheap = cheap;
    }

    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }

    public int getNm_mdfc() {
        return nm_mdfc;
    }

    public void setNm_mdfc(int nm_mdfc) {
        this.nm_mdfc = nm_mdfc;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getMy_mdfc() {
        return my_mdfc;
    }

    public void setMy_mdfc(int my_mdfc) {
        this.my_mdfc = my_mdfc;
    }

    public int getPresen() {
        return presen;
    }

    public void setPresen(int presen) {
        this.presen = presen;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "CAR{" + "lands=" + lands + ", cheap=" + cheap + ", format=" + format + ", nm_mdfc=" + nm_mdfc + ", average=" + average + ", my_mdfc=" + my_mdfc + ", presen=" + presen + ", wins=" + wins + ", losses=" + losses + ", month=" + month + ", year=" + year + '}';
    }

    

    
}
