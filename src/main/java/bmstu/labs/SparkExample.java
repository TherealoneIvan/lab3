package bmstu.labs;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

public class SparkExample {
    SparkConf conf = new SparkConf().setAppName("sample");
    JavaSparkContext sc = new JavaSparkContext(conf);
    JavaRDD<String> inputRDD = sc.textFile("hdfs://");
    JavaPairRDD<Tuple2<String , String> , String> resRDD = inputRDD.mapToPair()
}
