package examples;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import io.conduit.flink.ConduitSink;
import io.conduit.flink.ConduitSource;
import io.conduit.opencdc.Record;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class PostgresToSnowflake {
    public static void main(String[] args) throws Exception {
        var env = StreamExecutionEnvironment.getExecutionEnvironment().enableCheckpointing(1000);
        // Used to correlate all the pipelines which are part of this app
        String appId = "conduit-flink-demo";

        KafkaSource<Record> source = new ConduitSource(
            appId,
            "builtin:postgres",
            Map.of(
                "url", "postgresql://meroxauser:meroxapass@localhost/meroxadb?sslmode=disable",
                "key", "id",
                "table", "employees",
                "snapshotMode", "never",
                "cdcMode", "logrepl"
            )
        ).buildKafkaSource();

        DataStream<Record> in = env.fromSource(
                source,
                WatermarkStrategy.forBoundedOutOfOrderness(Duration.ofSeconds(1)),
                "demo-postgres-source"
            ).map((MapFunction<Record, Record>) value -> {
                value.getMetadata().put("processed-by", "flink");
                value.getMetadata().put("another-key", "flink-value");
                return value;
            })
            .setParallelism(1);

        var conduitSink = new ConduitSink(
            appId,
            "snowflake",
            new HashMap<>() {{
                put("sdk.batch.size", "1");
                put("sdk.batch.delay", "1s");
                // todo fill out
                put("snowflake.username", "");
                // todo fill out
                put("snowflake.password", "");
                put("snowflake.table", "EMPLOYEES");
                // todo fill out
                put("snowflake.host", "");
                put("snowflake.port", "443");
                put("snowflake.database", "CONDUIT_TEST_DB");
                put("snowflake.schema", "STREAM_DATA");
                put("snowflake.warehouse", "COMPUTE_WH");
                put("snowflake.stage", "FLINK_APP_STAGE");
                put("snowflake.primaryKey", "id");
                put("snowflake.format", "csv");
            }}
        );

        in.sinkTo(conduitSink.buildKafkaSink()).setParallelism(1);

        env.execute("Flink Java API Skeleton");
    }
}