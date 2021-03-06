package miage;

public class Jeu {

    private Integer nbQuillesTombeesLancer1;
    private Integer nbQuillesTombeesLancer2;

    public Jeu() {
        this.nbQuillesTombeesLancer1 = 10 ;
    }

    public Jeu(int nbQuillesLancer1, int nbQuillesLancer2) throws Exception {
        if (nbQuillesLancer1 + nbQuillesLancer2 > 10 ||
            nbQuillesLancer1 < 0 || nbQuillesLancer2 < 0 ||
                nbQuillesLancer1 == 10
        ) {
            throw new Exception("Jeu invalide");
        }
        this.nbQuillesTombeesLancer1 = nbQuillesLancer1;
        this.nbQuillesTombeesLancer2 = nbQuillesLancer2;
    }


    public boolean isSpare() {
        if (isStrike()) return false;
        return nbQuillesTombeesLancer1 + nbQuillesTombeesLancer2 == 10;
    }

    public boolean isStrike() {
        return nbQuillesTombeesLancer1 == 10 ;
    }

}
