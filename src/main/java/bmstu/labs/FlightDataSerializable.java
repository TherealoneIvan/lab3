package bmstu.labs;

import java.io.Serializable;

public class FlightDataSerializable implements Serializable {

    private double maxDelay;
    private int delayedCount;
    private int allFlightsCount;

    public FlightDataSerializable(double maxDelay, int delayedCount, int allFlightsCount) {
        this.maxDelay = maxDelay;
        this.delayedCount = delayedCount;
        this.allFlightsCount = allFlightsCount;
    }

    public void DelyedAdd(){
        delayedCount++;
        allFlightsCount++;
    }
    public void AllAdd(){
        allFlightsCount++;
    }

    public static FlightDataSerializable addValue(FlightDataSerializable a , AiroportDataSeriazable b){
        return new FlightDataSerializable(
                Math.max(a.getMaxDelay() ,b.getTimeDelay()),
                a.getDelayedCount() + 1,
                a.getAllFlightsCount() + 1
        );
    }

    public static FlightDataSerializable Add(FlightDataSerializable a , FlightDataSerializable b){
        return new FlightDataSerializable(
                Math.max(a.maxDelay , b.maxDelay),
                a.getDelayedCount() + b.getDelayedCount(),
                a.getAllFlightsCount() + b.getAllFlightsCount()
        );
    }
    public String ReturnProcent() {
        double res = 
    }
    public void MaxDelayCompare(double newDelay){
        maxDelay = Math.max(maxDelay , newDelay);
    }

    public double getMaxDelay() {
        return maxDelay;
    }

    public void setMaxDelay(double maxDelay) {
        this.maxDelay = maxDelay;
    }

    public int getDelayedCount() {
        return delayedCount;
    }

    public void setDelayedCount(int delayedCount) {
        this.delayedCount = delayedCount;
    }

    public int getAllFlightsCount() {
        return allFlightsCount;
    }

    public void setAllFlightsCount(int allFlightsCount) {
        this.allFlightsCount = allFlightsCount;
    }
}
