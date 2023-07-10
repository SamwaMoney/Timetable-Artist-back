package SamwaMoney.TimeTableArtist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TimeTableArtistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeTableArtistApplication.class, args);
	}

}
