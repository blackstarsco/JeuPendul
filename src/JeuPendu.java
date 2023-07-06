public class JeuPendu {

    public static void main(String... args){
        //Appel de la methode initMots()
        Mots.initMots();


        String mot =  Mots.tirerUnMot(4);
        System.out.println("mot = " + mot);

    }
}
