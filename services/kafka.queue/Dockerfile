FROM openjdk:8
COPY ./kafka.tgz /root
WORKDIR /root
RUN tar -xzf kafka.tgz
WORKDIR /root/kafka_2.12-2.4.0
CMD bin/zookeeper-server-start.sh -daemon config/zookeeper.properties && sleep 10 && bin/kafka-server-start.sh -daemon config/server.properties && sleep 10 && bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic mytopic && tail -f