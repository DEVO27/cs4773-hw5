package application.states;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Button {
    private final List<Integer> buttonList;

    public Button() {
        this.buttonList = new ArrayList<>();
    }

    //Reads and populates array of buttons pushed
    public List<Integer> getButtons(String fileName) {
        try (BufferedReader fileIn = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = fileIn.readLine()) != null) {
                for (String buttonPressed : line.split(" ")) {
                    if (Integer.parseInt(buttonPressed) > 3 || Integer.parseInt(buttonPressed) < 1) continue;
                    buttonList.add(Integer.parseInt(buttonPressed));
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return buttonList;
    }
}
