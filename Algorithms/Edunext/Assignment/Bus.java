package Algorithms.Edunext.Assignment;

public class Bus {
    protected String bcode;
    protected String bus_name;
    protected int seat;
    protected int booked;
    protected double depart_time;
    protected double arrival_time;

    public Bus(String bcode, String bus_name, int seat, int booked, double depart_time, double arrival_time) {
        this.bcode = bcode;
        this.bus_name = bus_name;
        this.seat = seat;
        this.booked = booked;
        this.depart_time = depart_time;
        this.arrival_time = arrival_time;
    }

    public Bus() {

    }

    public String getBcode() {
        return this.bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getBus_name() {
        return this.bus_name;
    }

    public void setBus_name(String bus_name) {
        this.bus_name = bus_name;
    }

    public int getSeat() {
        return this.seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return this.booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public double getDepart_time() {
        return this.depart_time;
    }

    public void setDepart_time(double depart_time) {
        this.depart_time = depart_time;
    }

    public double getArrival_time() {
        return this.arrival_time;
    }

    public void setArrival_time(double arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Bus bcode(String bcode) {
        setBcode(bcode);
        return this;
    }

    public Bus bus_name(String bus_name) {
        setBus_name(bus_name);
        return this;
    }

    public Bus seat(int seat) {
        setSeat(seat);
        return this;
    }

    public Bus booked(int booked) {
        setBooked(booked);
        return this;
    }

    public Bus depart_time(double depart_time) {
        setDepart_time(depart_time);
        return this;
    }

    public Bus arrival_time(double arrival_time) {
        setArrival_time(arrival_time);
        return this;
    }

    @Override
    public String toString() {
        return getBcode() + "\t|\t" +
                getBus_name() + "\t|\t" +
                getSeat() + "\t|\t" +
                getBooked() + "\t|\t" +
                getDepart_time() + "\t|\t" +
                getArrival_time();
    }

    /**
     * protected String bcode;
     * protected String bus_name;
     * protected int seat;
     * protected int booked;
     * protected double depart_time;
     * protected double arrival_time;
     */
}