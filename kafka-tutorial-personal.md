# Iniciar Zookeeper
Kafka no trabaja solo, necesita de Zookeeper para coordinar los brokers del clúster.  

```sh bin/zookeeper-server-start.sh config/zookeeper.properties```

# Iniciar Kafka

```sh bin/kafka-server-start.sh config/server.properties```

# Crear un tópico llamado "test-topic" con 5 particiones y factor de replicación 1
Un **tópico** en Kafka es el “tema de conversación” donde los productores publican mensajes y los consumidores los leen.  

- **Particiones**: permiten dividir los mensajes de un tópico en múltiples segmentos. Esto mejora el rendimiento y permite que varios consumidores trabajen en paralelo.  
- **Factor de replicación**: indica cuántas copias de cada partición se guardan en distintos brokers. A mayor replicación, más tolerancia a fallos.  

```sh bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic test-topic --partitions 5 --replication-factor 1``` 
## Listar los topic
```
bin/kafka-topics.sh --list --bootstrap-server localhost:9092
```

# Describir el tópico "test-topic" para ver su configuración
```
bin/kafka-topics.sh --describe --topic test-topic --bootstrap-server localhost:9092  
```

# Consumidor de mensajes (lee mensajes del tópico "test-topic")
```
bin/kafka-console-consumer.sh --topic test-topic --bootstrap-server localhost:9092  
```

# Productor de mensajes (envía mensajes al tópico "test-topic")
```
bin/kafka-console-producer.sh --topic test-topic --bootstrap-server localhost:9092
```

# Consumidor de mensajes (lee TODOS los mensajes del tópico "test-topic")

```
bin/kafka-console-consumer.sh --topic test-topic --from-beginning --bootstrap-server localhost:9092
```

```
bin/kafka-console-consumer.sh --topic test-topic --from-beginning --bootstrap-server localhost:9092 --property print.key=true --property key.separator="-"
```

# Limpiar el ambiente de desarrollo para Kafka

Ese comando resetea tu entorno de desarrollo de Kafka y Zookeeper.
Cuando lo ejecutes, pierdes todos los datos (topics, mensajes, offsets, metadatos) y la próxima vez que arranques Kafka + Zookeeper, se iniciarán “limpios” como si fuera la primera vez

```
rm -rf /tmp/kafka-logs /tmp/zookeper
```

En Kafka, el parámetro acks (acknowledgments) define cuántos brokers deben confirmar la recepción de un mensaje antes de que el productor lo considere exitosamente enviado:

acks=0 → El productor no espera confirmación. Máxima velocidad, pero sin garantía de entrega.

acks=1 → El líder del partition confirma. Balance entre rendimiento y fiabilidad.

acks=all (o -1) → Todos los replicas deben confirmar. Máxima seguridad, menor rendimiento.