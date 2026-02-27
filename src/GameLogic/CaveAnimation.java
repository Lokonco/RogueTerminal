
package GameLogic;
import java.util.Random;

public class CaveAnimation {

    public static void play() {
        int width = 70;
        int pauseAmount = 50;
        int leftWidth = 20;
        int gapWidth = 10;

        long start = System.currentTimeMillis();
        int totalTime = 3000;

        Random random = new Random();

        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        while (System.currentTimeMillis() - start < totalTime) {
            int rightWidth = width - gapWidth - leftWidth;

            System.out.println(
                    "#".repeat(leftWidth) +
                            " ".repeat(gapWidth) +
                            "#".repeat(rightWidth)
            );

            try {
                Thread.sleep(pauseAmount);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }

            int diceRoll = random.nextInt(6) + 1;

            if (diceRoll == 1 && leftWidth > 1)
                leftWidth--;
            else if (diceRoll == 2 && leftWidth + gapWidth < width - 1)
                leftWidth++;

            diceRoll = random.nextInt(6) + 1;

            if (diceRoll == 1 && gapWidth > 1)
                gapWidth--;
            else if (diceRoll == 2 && leftWidth + gapWidth < width - 1)
                gapWidth++;
        }
    }
}
