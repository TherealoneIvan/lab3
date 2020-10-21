package bmstu.labs;

import java.io.Serializable;

public class FlightDataSerializable implements Serializable {

    private double maxDelay;
    private int delayedCount;
    private int allFlightsCount;


    public void DelyedAdd(){
        delayedCount++;
        allFlightsCount++;
    }
    public void AllAdd(){
        allFlightsCount++;
    }
    public void MaxDelayCompare(double newDelay){
        maxDelay = Math.max(maxDelay , newDelay);
    }

    public int getAiroportID() {
        return airoportID;
    }

    public void setAiroportID(int airoportID) {
        this.airoportID = airoportID;
    }

    public int getDestId() {
        return destId;
    }

    public void setDestId(int destId) {
        this.destId = destId;
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
