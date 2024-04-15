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
                System.out.println("\n\n\n\n\t\t\t\t\t\t\t\t\t\tThis is Audio System");
                System.out.println("\n\n\n\nP = play , S = Stop , R = Reset , Q = Quit");
                System.out.print("\n\n\n\nEnter Your choice : ");

                response = sc.next().toUpperCase();

                switch (response) {
                    case "P":
                    System.out.println("\n\n\t\t\t\t\t\t\t\t\t\tMusic is Running... ");
                        clip.start();
                        break;
                    case "S":
                    System.out.println("\n\n\t\t\t\t\t\t\t\t\t\tMusic Stopped. . .");
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
