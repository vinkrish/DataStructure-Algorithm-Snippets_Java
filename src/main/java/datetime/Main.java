package datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		Instant start = Instant.now();
		System.out.println(start);
		
		Instant end = Instant.now();
		System.out.println(end);
		
		Duration elapsed = Duration.between(start, end);
		System.out.println("Elapsed: " + elapsed.toMillis() + " milliseconds");
		
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		
		LocalDate specificDate = LocalDate.of(2014, 12, 25);
		System.out.println(specificDate);
		
		LocalTime currentTime = LocalTime.now();
		System.out.println(currentTime);
		
		LocalTime specificTime = LocalTime.of(14, 15, 16);
		System.out.println(specificTime);
		
		LocalDateTime currentDT = LocalDateTime.now();
		System.out.println(currentDT);
		
		LocalDateTime specificDT = LocalDateTime.of(specificDate, specificTime);
		System.out.println(specificDT);
	}

}
