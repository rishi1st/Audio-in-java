import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class AudioInJava {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            File file = new File("One-love.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            String response = "";

            while (!response.equals("Q")) {
                System.out.println("P = play , S = Stop , R = Reset , Q = Quit");
                System.out.print("Enter Your choice : ");

                response = sc.next().toUpperCase();

                switch (response) {
                    case "P":
                        clip.start();
                        break;
                    case "S":
                        clip.stop();
                        break;
                    case "R":
                        clip.setMicrosecondPosition(0);
                        break;
                    case "Q":
                        clip.stop();
                        clip.close();
                        break;
                    default:
                        System.out.println("Not a valid response");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
