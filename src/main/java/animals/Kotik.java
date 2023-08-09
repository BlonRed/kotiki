package animals;

import java.util.Random;

public class Kotik {
    private String name;
    private String voice;
    private int satiety;
    private int weight;
    private static int count = 0;
    private final int METHODS = 5;

    public Kotik() {
        count++;
    }

    public Kotik(String name, String voice, int satiety, int weight) {
        this.name = name;
        this.voice = voice;
        this.satiety = satiety;
        this.weight = weight;
        count++;
    }

    private boolean play() {
        return actionProcessed("играет");
    }

    private boolean sleep() {
        return actionProcessed("спит");
    }

    private boolean wash() {
        return actionProcessed("умывается");
    }

    private boolean walk() {
        return actionProcessed("гуляет");
    }

    private boolean hunt() {
        return actionProcessed("охотится");
    }

    private void eat(int value) {
        System.out.printf("%s кушает\n", this.name);
        satiety += value;
    }

    private void eat(int value, String food) {
        System.out.printf("%s кушает %s\n", this.name, food);
        satiety += value;
    }

    private void eat() {
        this.eat(3, "курица");
    }

    synchronized private boolean actionProcessed(String action) {
        if (satiety > 0) {
            System.out.printf("%s %s\n", this.name, action);
            satiety--;
            return true;
        }
        return false;
    }

    public String[] liveAnotherDay() {
        String[] arrayActions = new String[24];
        for (int hours = 0; hours < 24; hours++) {
            int numberOfMethod = new Random().nextInt(METHODS) + 1;
            String action = "";
            switch (numberOfMethod) {
                case 1:
                    if (this.play()){
                        action = "играл";
                    } else {
                        this.eat();
                        action = "ел";
                    }
                    break;
                case 2:
                    if (this.play()){
                        action = "спал";
                    } else {
                        this.eat();
                        action = "ел";
                    }
                    break;
                case 3:
                    if (this.play()){
                        action = "умывался";
                    } else {
                        this.eat();
                        action = "ел";
                    }
                    break;
                case 4:
                    if (this.play()){
                        action = "гулял";
                    } else {
                        this.eat();
                        action = "ел";
                    }
                    break;
                case 5:
                    if (this.play()){
                        action = "охотился";
                    } else {
                        this.eat();
                        action = "ел";
                    }
                    break;
            }
            arrayActions[hours] = String.format("%d - %s", hours, action);
        }
        return arrayActions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static int getCount() {
        return count;
    }
}
