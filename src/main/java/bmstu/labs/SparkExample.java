package bmstu.labs;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.nio.file.Path;

public class SparkExample {
    public static void main(String args[]) throws Exception {
        if (args.length != 3) {
            System.err.println("SparkApp exception");
            System.exit(1);
        }
        SparkConf conf = new SparkConf().setAppName("sample");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> inputAiroportRDD = sc.textFile(new Path(args[1]));
        JavaRDD<String> inputFlightRDD = sc.textFile();
        JavaPairRDD<Tuple2<Integer, Integer>, AiroportDataSeriazable> resRDD = inputRDD.mapToPair(

        )
    }
}
