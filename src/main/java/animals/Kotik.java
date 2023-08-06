package animals;

import java.util.Random;

public class Kotik {
    private String name;
    private String voice;
    private int satiety;
    private int weight;
    static int count = 0;
    final int METHOD = 5;

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

    public String[] liveAnotherDay() {
        String[] arrayActions = new String[24];
        for (int hours = 0; hours < 24; hours++) {
            int numberOfMethod = new Random().nextInt(METHOD) + 1;
            String action = "";
            switch (numberOfMethod) {
                case 1:
                    action = this.play() ? "играл" : "ел";
                    break;
                case 2:
                    action = this.sleep() ? "спал" : "ел";
                    break;
                case 3:
                    action = this.wash() ? "умывался" : "ел";
                    break;
                case 4:
                    action = this.walk() ? "гулял" : "ел";
                    break;
                case 5:
                    action = this.hunt() ? "охотился" : "ел";
                    break;
            }
            arrayActions[hours] = String.format("%d - %s", hours, action);
        }
        return arrayActions;
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
        } else if (satiety == 0) {
            this.eat();
        }
        return false;
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
