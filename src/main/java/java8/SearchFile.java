package java8;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchFile {

	public static void main(String[] args) {
		
		Path path = FileSystems.getDefault().getPath("src/main/resources", "hamlet.txt");
		
		try (Stream<String> lines = Files.lines(path)) {
			String data = lines.collect(Collectors.joining("\n"));
			System.out.println(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		String searchTerm = "To be, or not to be";
		try (Stream<String> lines = Files.lines(path)) {			
			Optional<String> line = lines.filter(l -> l.contains(searchTerm)).findFirst();
			if (line.isPresent()) {
				System.out.println("Found: " + line.get());
			} else {
				System.out.println("Not found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
