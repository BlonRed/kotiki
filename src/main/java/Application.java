import animals.Kotik;

public class Application {
    public static void main(String[] args) {
        Kotik nala = new Kotik("Нала", "Мяу", 3, 4);
        Kotik barsik = new Kotik();
        barsik.setName("Барсик");
        barsik.setVoice("Миау");
        barsik.setSatiety(2);
        barsik.setWeight(5);

        for (String text: barsik.liveAnotherDay()) {
            System.out.println(text);
        }
        System.out.println();

        System.out.printf("Имя: %s\nВес: %s\n", barsik.getName(), barsik.getWeight());
        System.out.println();

        System.out.printf("%s и %s разговаривают одинаково: %b\n",
                nala.getName(), barsik.getName(), compareVoice(nala, barsik));
        System.out.println();

        System.out.println("Котиков создано: " + Kotik.getCount());
    }

    static public boolean compareVoice(Kotik kotik1, Kotik kotik2) {
        return kotik1.getVoice().equals(kotik2.getVoice());
    }
}
