package miage;

public class Jeu {

    private int nbQuillesTombeesLancer1;
    private int nbQuillesTombeesLancer2;

    public Jeu(int nbQuillesLancer1, int nbQuillesLancer2) throws Exception {
        if (nbQuillesLancer1 + nbQuillesLancer2 > 10 ||
            nbQuillesLancer1 < 0 || nbQuillesLancer2 < 0
        ) {
            throw new Exception("Jeu invalide");
        }
        this.nbQuillesTombeesLancer1 = nbQuillesLancer1;
        this.nbQuillesTombeesLancer2 = nbQuillesLancer2;
    }


    public boolean isSpare() {
        return true;
    }

    public boolean isStrike() {
        return true;
    }

}
