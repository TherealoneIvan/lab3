package bmstu.labs;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

public class SparkExample {
    public static void main(String args[]) throws Exception {
        if (args.length != 3){

        }
        SparkConf conf = new SparkConf().setAppName("sample");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> inputAiroportRDD = sc.textFile("hdfs://");
        JavaRDD<String> inputFlightRDD = sc.textFile();
        JavaPairRDD<Tuple2<Integer, Integer>, AiroportDataSeriazable> resRDD = inputRDD.mapToPair(

        )
    }
}
