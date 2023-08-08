package filmtracker.config

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration
import java.util.*


@Configuration
class MongoConfig : AbstractMongoClientConfiguration() {
    override fun getDatabaseName(): String {
        return "personal-projects"
    }

    override fun mongoClient(): MongoClient {
        val connectionString = ConnectionString("mongodb+srv://film-tracker-app:<password>@cluster0.vxa04.mongodb.net/?retryWrites=true&w=majority")
        val mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build()
        return MongoClients.create(mongoClientSettings)
    }
}