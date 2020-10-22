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

    public void Add(FlightDataSerializable a , FlightDataSerializable b){
        
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
