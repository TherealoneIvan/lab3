package bmstu.labs;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import scala.Tuple2;

import javax.validation.constraints.Max;


public class SparkExample {

    public static final String flightRegex = ",";
    public static final int originAiroportID = 11;
    public static final int originDestID = 14;
    public static final int originDelayID = 18;
    public static final int originCanceldID = 19;
    public static final String REGEX_BACKSLASH = "\"";

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
        JavaPairRDD<Integer , String> airoportNames = inputAiroportRDD
                .mapToPair( line -> {
                            String[] airportsNames = line.split(flightRegex);
                            String airport = "";
                            for (int i = 1; i < airportsNames.length; i++)
                                airport += airportsNames[i];
                            int airaceID = Integer.parseInt(airportsNames[0]
                                    .replace(REGEX_BACKSLASH, ""));
                            return new Tuple2<>(airaceID , airport);
                        }
                );
        JavaPairRDD<Tuple2<Integer, Integer>, AiroportDataSeriazable> resRDD = inputFlightRDD
                .mapToPair(line -> {
                            String[] items = line.split(flightRegex);
                            if (items[originCanceldID].equals("1")) {
                                return new Tuple2<>(new Tuple2<>(Integer.parseInt(items[originAiroportID])
                                        , Integer.parseInt(items[originDestID])),
                                        new AiroportDataSeriazable(
                                                Integer.parseInt(items[originAiroportID]),
                                                Integer.parseInt(items[originDestID]),
                                                0,
                                                true));
                            } else {
                                return new Tuple2<>(new Tuple2<>(Integer.parseInt(items[originAiroportID])
                                        , Integer.parseInt(items[originDestID])),
                                        new AiroportDataSeriazable(
                                                Integer.parseInt(items[originAiroportID]),
                                                Integer.parseInt(items[originDestID]),
                                                Double.parseDouble(items[originDelayID]),
                                                false));
                            }
                        }
                );

        JavaPairRDD<Tuple2<Integer, Integer>, FlightDataSerializable> reducedRes = resRDD
                .combineByKey(
                    p -> new FlightDataSerializable(p.getTimeDelay() , 1 , 1),
                    (flightDataSerializable  , p) -> FlightDataSerializable.addValue(
                                                            flightDataSerializable,
                                                            p
                        ),
                    FlightDataSerializable::Add
                );
        Map<String , >
        final Broadcast<Map<String, AirportData>> airportsBroadcasted =
                sc.broadcast(stringAirportDataMap);
    }
}
