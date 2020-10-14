# HeartRateTrainingZones

Aplicação web para cálculo das zonas cardíacas de treino.

Construído usando [Kotlin](https://kotlinlang.org/) e [Javalin](https://javalin.io).

## Executando

Ao executar o projeto, um servidor será ligado na porta indicada pelo valor da variável de ambiente `PORT` 
ou na porta `9000`, caso nenhum valor seja fornecido.

### Em desenvolvimento
```shell script
$ mvn compile exec:java
```

### Em produção

```shell script
$ java -jar target/HeartRateTrainingZones-jar-with-dependencies.jar
```
