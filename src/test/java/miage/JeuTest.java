package miage;

import org.junit.Test;

import static org.junit.Assert.*;

public class JeuTest {

    // test validation de l'initialisation d'un jeu à sa création
    @Test
    public void testCreationJeuValide() throws Exception {
        // given: 2 valeurs de lancer dont la somme est comprise entre 0 et 10
        int nbQuillesLancer1 = 2;
        int nbQuillesLancer2 = 4;
        // Expected: un jeu peut être créé avec ses valeurs
        assertNotNull(new Jeu(nbQuillesLancer1, nbQuillesLancer2));
    }

    @Test(expected = Exception.class)
    public void testCreationJeuInvalideEchoue() throws Exception {
        // given: 2 valeurs de quilles tombees dont la somme est supérieure strictement à 10
        int nbQuillesLancer1 = 2;
        int nbQuillesLancer2 = 9;
        // When: on tente de créer un jeu avec ces valeurs
        new Jeu(nbQuillesLancer1,nbQuillesLancer2);
        // Then: une exception est levée
    }

    @Test
    public void testCreationJeuAvecNbQuillesNegatifsEchoue() throws Exception {
        // given: 2 valeurs de quilles tombees avec nbQuilles lancer 1 négatif
        int nbQuillesLancer1 = -1;
        int nbQuillesLancer2 = 9;
        // When: on tente de créer un jeu avec ces valeurs
        try {
            new Jeu(nbQuillesLancer1, nbQuillesLancer2);
            fail("Devrait lever une exeception !");         // Then: une exception est levée
        } catch(Exception e) {}

        // given: nb quilles lancer 2 est négatif et nb quilles lancer 1 positif
        nbQuillesLancer1 = 3;
        nbQuillesLancer2 = -6;
        // When: on tente de créer un jeu avec ces valeurs
        try {
            new Jeu(nbQuillesLancer1, nbQuillesLancer2);
            fail("Devrait lever une exeception !");         // Then: une exception est levée
        } catch(Exception e) {}

    }

   // test de isStrike
    @Test
    public void testIsStrike() throws Exception {
        // Given: un jeu dont le nb de quilles tombees au premier lancer est égal à 10
        Jeu jeu = new Jeu();
        // Expected: le jeu est un strike
        assertTrue(jeu.isStrike());

        // Given: un jeu dont le nb de quilles tombees au premier lancer est < 10
        jeu = new Jeu(2,4);
        // Expected: le jeu n'est pas un strike
        assertFalse(jeu.isStrike());
    }

    // test de isSpare
    @Test
    public void testIsSpare() throws Exception {
        // Given: un jeu dont la somme des quilles tombees est égal à 10
        Jeu jeu = new Jeu(8,2);
        // Expected: le jeu est un spare
        assertTrue(jeu.isSpare());

        // Given: un jeu dont la somme de quilles tombees est < 10
        jeu = new Jeu(2,4);
        // Expected: le jeu n'est pas un spare
        assertFalse(jeu.isSpare());

        // given: un strike
        jeu = new Jeu();
        // Expected: le jeu n'est pas un spare
        assertFalse(jeu.isSpare());

    }

}
