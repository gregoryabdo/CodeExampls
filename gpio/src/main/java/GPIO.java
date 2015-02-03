import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GPIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path file = Paths.get("/sys/devices/virtual/misc/gpio/pin/gpio0");
		try {
			System.out.println(Files.readAllLines(file).get(0));
			//System.out.println(Arrays.toString(Files.readAllBytes(file)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}