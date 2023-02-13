import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
@ComponentScan(basePackages = "com.example.spanner_db")
public class AppConfig {
    @Value("${google.spanner.credentials.path}")
    private String credentialsPath;

    @Bean
    public Spanner spanner() throws IOException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(Files.newInputStream(Paths.get(credentialsPath)));

        SpannerOptions options = SpannerOptions.newBuilder().setCredentials(credentials).build();
        return options.getService();
    }
}
