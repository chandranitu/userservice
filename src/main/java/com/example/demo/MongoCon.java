//package com.example.demo;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
//import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//
//@Configuration
//@EnableTransactionManagement
//@EnableReactiveMongoRepositories
//public class MongoCon extends AbstractReactiveMongoConfiguration {
//
//	@Value("${spring.data.mongodb.database}")
//	private String database;
//
//	@Bean
//	public MongoClient mongoClient() {
//		return MongoClients.create("mongodb://admin:admin@123@localhost:27017/demo_db");
//	}
//
////    @Bean
////    public ReactiveMongoDatabaseFactory reactiveMongoDatabaseFactory() {
////        return new SimpleReactiveMongoDatabaseFactory(MongoClients.create("mongodb://exampleapp:example@localhost:27017/exampledb"), database);
////    }
//
//	@Override
//    protected String getDatabaseName() {
//        return database;
//    }
//}