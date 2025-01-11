package org.example.logback.kafka;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.status.Status;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.errors.InterruptException;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.ProducerListener;

import java.util.HashMap;
import java.util.Map;

public class KafkaMessageImpl implements MessageSystem {
    private static final String LOGGER_SUFFIX = "_logs";
    private String kafka_bootstrapServers;
    private String kafka_acks;
    private String kafka_retries;
    private String kafka_buffer_memory;
    private String kafka_enable_idempotence;
    private String kafka_compression_type;
    private String kafka_batch_size;
    private String kafka_client_id;
    private String kafka_linger_ms;
    private String kafka_security_protocol;
    private String kafka_ssl_protocol;
    private String kafka_trust_store_location;
    private String kafka_trust_store_password;
    private String kafka_key_store_location;
    private String kafka_key_store_password;
    private String kafka_ssl_endpoint_identification_algorithm;
    private String kafka_security_enabled;
    private String kafka_max_request_size;
    private String kafka_retry_backoff_ms;
    private String kafka_reconnect_backoff_ms;
    private String kafka_reconnect_backoff_max_ms;
    private String kafka_request_timeout_ms;
    private String topic;
    private String kafka_connections_max_idle_ms;
    private String kafka_max_in_flight_requests_per_connection;
    private String kafka_metadata_max_age_ms;
    private String kafka_max_block_ms;

    private KafkaTemplate<String, Object> loggerkafkaTemplate;

    @Override
    public void initialize() {
        try {
            Map<String, Object> properties = new HashMap<>();
            properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka_bootstrapServers);
            properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            properties.put(ProducerConfig.ACKS_CONFIG, kafka_acks);
            properties.put(ProducerConfig.BATCH_SIZE_CONFIG, kafka_batch_size);
            properties.put(ProducerConfig.CLIENT_ID_CONFIG, kafka_client_id);
            properties.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, kafka_compression_type);
            properties.put(ProducerConfig.RETRIES_CONFIG, kafka_retries);
            properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, kafka_buffer_memory);
            properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, kafka_enable_idempotence);
            properties.put(ProducerConfig.LINGER_MS_CONFIG, kafka_linger_ms);
            properties.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, kafka_max_request_size);
            properties.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, kafka_retry_backoff_ms);
            properties.put(ProducerConfig.RECONNECT_BACKOFF_MS_CONFIG, kafka_reconnect_backoff_ms);
            properties.put(ProducerConfig.RECONNECT_BACKOFF_MAX_MS_CONFIG, kafka_reconnect_backoff_max_ms);
            properties.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, kafka_request_timeout_ms);
            properties.put(ProducerConfig.CONNECTIONS_MAX_IDLE_MS_CONFIG, kafka_connections_max_idle_ms);
            properties.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION,
                    kafka_max_in_flight_requests_per_connection);
            properties.put(ProducerConfig.METADATA_MAX_AGE_CONFIG, kafka_metadata_max_age_ms);
            properties.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, kafka_max_block_ms);

            if (kafka_security_enabled.trim().toLowerCase().equals("true")) {
//                properties.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, kafka_security_protocol);
//                properties.put(SslConfigs.SSL_PROTOCOL_CONFIG, kafka_ssl_protocol);
//                properties.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, kafka_trust_store_location);
//                properties.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, kafka_trust_store_password);
//                properties.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, kafka_key_store_location);
//                properties.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, kafka_key_store_password);
//                properties.put(SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG,
//                        kafka_ssl_endpoint_identification_algorithm);
            }

            if (loggerkafkaTemplate == null) {
                ProducerFactory<String, Object> producerFactory = new DefaultKafkaProducerFactory<>(properties);
                loggerkafkaTemplate = new KafkaTemplate<String, Object>(producerFactory);

                loggerkafkaTemplate.setProducerListener(new ProducerListener<String, Object>() {
                    @Override
                    public void onSuccess(ProducerRecord<String, Object> record, RecordMetadata recordMetadata) {
                    }
                    @Override
                    public void onError(ProducerRecord<String, Object> producerRecord, RecordMetadata recordMetadata,
                                        Exception exception) {
                        System.out.println("Kafkalogappender OnError ### Topic = " + producerRecord.topic() + " ; "
                                + " ### Exception = " + exception);
                    }

                });
            }
        } catch (Exception e) {
            System.out.println("Exception || kafkalogappender || initialize " + e);
        }
    }
    @Override
    public <T> void send(T log) {
        try {
            loggerkafkaTemplate.send(topic, log);
        } catch (InterruptException e) {
            System.out.println("InterruptException || kafkalogappender || Send");
        } catch (Exception e) {
            System.out.println("Exception || kafkalogappender || Send " + e);
        }
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public void setContext(Context context) {
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void addStatus(Status status) {
    }

    @Override
    public void addInfo(String s) {
    }

    @Override
    public void addInfo(String s, Throwable throwable) {
    }

    @Override
    public void addWarn(String s) {
    }

    @Override
    public void addWarn(String s, Throwable throwable) {
    }

    @Override
    public void addError(String s) {
    }

    @Override
    public void addError(String s, Throwable throwable) {
    }
}
