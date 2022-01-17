package testIG.sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;


public class De {

    private int value;
    private Image dice;
    private ImageView apercu_dice;
    private Random rand;

    private static final int borninf=1, bornsup=6;

    public De(){
        rand = new Random();
        value = rand.nextInt((bornsup-borninf) + 1) + borninf;
        dice = new Image(getClass().getResourceAsStream("/testIG/ressources/de" +value+".png"),70,70,true, true);
        apercu_dice = new ImageView(getDice());
    }

    public De(int value){
        setValue(value);
        dice = new Image(getClass().getResourceAsStream("/testIG/ressources/de" +value+".png"),70,70,true, true);
        apercu_dice = new ImageView(getDice());
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Image getDice() {
        return dice;
    }

    public void setDice(Image dice) {
        this.dice = dice;
    }

    public ImageView getApercu_dice() {
        return apercu_dice;
    }

    public void setApercu_dice(ImageView apercu_dice){
        this.apercu_dice = apercu_dice;
    }

    @Override
    public String toString(){
        return "" +getValue();
    }
}
