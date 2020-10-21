package bmstu.labs;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import scala.Tuple2;


public class SparkExample {

    public static final String flightRegex = ",";
    public static final int originAiroportID = 11;
    public static final int originDestID = 14;
    public static final int originDelayID = 18;
    public static final int originCanceldID = 19;

    public static void main(String args[]) throws Exception {
        if (args.length != 3) {
            System.err.println("SparkApp exception");
            System.exit(1);
        }
        String airoportPath = args[0];
        String flightPath = args[1];
        SparkConf conf = new SparkConf().setAppName("sample");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> inputAiroportRDD = sc.textFile(airoportPath);
        JavaRDD<String> inputFlightRDD = sc.textFile(flightPath);
        JavaPairRDD<Tuple2<Integer, Integer>, AiroportDataSeriazable> resRDD = inputFlightRDD
                .mapToPair(  line->{
                    String[] items = line.split(flightRegex);
                    if (items[originCanceldID] == 1)
                }
                );
}
