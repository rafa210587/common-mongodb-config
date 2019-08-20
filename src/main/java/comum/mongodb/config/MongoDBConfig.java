package comum.mongodb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

import lombok.RequiredArgsConstructor;

/**
 * Configuration to access the database
 * 
 * @author rafael.goncalves
 */
@Configuration
@ComponentScan
@RequiredArgsConstructor
public class MongoDBConfig /*extends AbstractMongoConfiguration */ {

	@Value("${mongodb.host}")
	private String host;

	@Value("${mongodb.port}")
	private Integer port;

	@Value("${mongodb.database}")
	private String dataBase;
	
	 @Bean
	    public MongoClient mongo() {
	        return new MongoClient(host);
	    }
	 
	    @Bean
	    public MongoTemplate mongoTemplate() throws Exception {
	        return new MongoTemplate(mongo(), dataBase);
	    }
	    
}