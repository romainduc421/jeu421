package testIG.sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;

import java.util.ArrayList;
import java.util.Arrays;


public class ControllerButtonEcouteur implements EventHandler<ActionEvent>{

    private ArrayList<Label> lab = new ArrayList<>(5);
    private ArrayList<Button> boutons = new ArrayList<>(4);
    private final De[] des = new De[3];
    private Counter compteur = new Counter();
    private int nb_421 = 0;
    private boolean [] DesSelectionnes = new boolean[3];
    private Button selected_button;


    public ControllerButtonEcouteur(Counter compt,Button[] bouts ,Label... labs){
        lab.addAll(Arrays.asList(labs));
        boutons.addAll(Arrays.asList(bouts).subList(0, 4));
        setCompteur(compt);
        for(int k=0; k<=2; ++k) {
            des[k] = new De(1);
            DesSelectionnes[k] = false;
        }
    }


    @Override
    public void handle(ActionEvent evt) {

        selected_button = (Button) evt.getSource();
        if(selected_button != boutons.get(3)){
            SelectionneDes();
        }
        else {
            System.out.print("Bienvenue dans cette intro aux IG !  ");
            compteur.incrementation(1);
            System.out.println(compteur.getVal());
            rollDie();
        }
    }

    public void rollDie(){
        for (int k = 0; k <= 2; k++) {
            des[k] = new De(des[k].getValue());
            boutons.get(k).setGraphic(des[k].getApercu_dice());
            if(!DesSelectionnes[k]) {
                des[k] = new De();
                boutons.get(k).setGraphic(des[k].getApercu_dice());
            }
        }

        lab.get(3).setText("click n° : " + getCompteur().getVal().toString());
        if (check421(des[1], des[2])) {
            nb_421++;
            lab.get(4).setText("correct comb : " + nb_421);
        }

        for(int k=0; k<=2; k++)
            DesSelectionnes[k] = false;
    }


    public boolean check421(De de1, De de2){
        int prem_lance = des[0].getValue();
        if (prem_lance == 4)
            return check2derniersDes(de1, de2, 2,1);
        else if (prem_lance == 2)
            return check2derniersDes(de1, de2, 4,1);
        else if (prem_lance == 1)
            return check2derniersDes(de1, de2, 4,2);
        else
            return false;
    }

    public boolean check2derniersDes(De de1, De de2, int nb, int nb2){
        return (nb == de2.getValue() && nb2 == de1.getValue())
        || (nb == de1.getValue() && nb2 == de2.getValue());
    }

    public ArrayList<Label> getLab() {
        return lab;
    }

    public ArrayList<Button> getBoutons() {
        return boutons;
    }

    public De[] getDes() {
        return this.des;
    }

    public Counter getCompteur() {
        return compteur;
    }

    public void setCompteur(Counter compteur) {
        this.compteur = compteur;
    }


    public void SelectionneDes(){

        int idx = -1 ;
        ColorAdjust cadj = new ColorAdjust();
        cadj.setHue(0.36);
        if(selected_button == boutons.get(0)){
            boutons.get(0).setEffect(cadj);
            idx=0;
        }
        else if(selected_button == boutons.get(1)){
            boutons.get(1).setEffect(cadj);
            idx=1;
        }
        else if(selected_button == boutons.get(2)){
            boutons.get(2).setEffect(cadj);
            idx=2;
        }


        if(idx>=0)
            DesSelectionnes[idx] = true;
    }
}
