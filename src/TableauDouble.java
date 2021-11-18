public class TableauDouble {
    final static int LONGUEUR_DEFAUT = 5;
    final static double VALEUR_DEFAUT = 0;

    int longueur;
    double valeur;
    double [] tabE;
    double [] tabET;

    public TableauDouble(int pLongueur, double pValeur) {
        this.longueur = pLongueur;
        this.valeur = pValeur;

        tabE = new double[pLongueur];

        setAll(pValeur);
    }

    public TableauDouble(int a) {
        this(a, VALEUR_DEFAUT);
    }
    public TableauDouble() {
        this(LONGUEUR_DEFAUT, VALEUR_DEFAUT);
    }

    public void setAll(double valeur) {
        for (int x = 0; x < longueur; x++) {
            this.tabE[x] = valeur;
        }
    }

    public String toString() {
        String retour;

        retour = "longueur: " + this.longueur + " [";

        for (int x = 0; x < longueur; x++) {
            retour = retour + tabE[x];

            if (x < this.longueur - 1)
                retour = retour + ", ";
        }

        retour = retour + "]";

        return retour;
    }

    public int size() {
        int retour;

        retour = this.longueur;

        return retour;
    }

    public void set(int pIndice, double pValeur) {
        this.tabE[pIndice] = pValeur;
    }

    public void set(double[] pValeurs) {
        this.longueur = pValeurs.length;

        clear();

        for (int x = 0; x < pValeurs.length; x++)
            add(pValeurs[x]);
    }

    public double get(int pIndice) {
        return this.tabE[pIndice];
    }

    public void add(double pValeur) {
        this.longueur = this.tabE.length + 1;

        tabET = new double [this.longueur];

        for (int x = 0; x < this.tabE.length; x++)
            tabET[x] = this.tabE[x];

        tabET[this.longueur - 1] = pValeur;

        this.tabE = tabET;
    }

    public void clear() {
        this.longueur = 0;

        tabET = new double [this.longueur];

        this.tabE = tabET;
    }

    public void remove(int pIndice) {
        int indiceCourant;
        this.longueur = this.longueur - 1;

        tabET = new double [this.longueur];

        indiceCourant = 0;

        for (int x = 0; x < this.tabE.length; x++) {
            if (x != pIndice){
                tabET[indiceCourant] = this.tabE[x];
                indiceCourant++;
            }
        }

        this.tabE = tabET;
    }

    public double getSomme() {
        double somme;

        somme = 0;

        for (int x = 0; x < this.tabE.length; x++) {
            somme = somme + this.tabE[x];
        }

        return somme;
    }

    public boolean estPlusPetit(TableauDouble pTab) {
        if (getSomme() < pTab.getSomme())
            return true;

        return false;
    }

    public static boolean estPlusPetit(TableauDouble pTabA, TableauDouble pTabB) {
        if (pTabA.getSomme() < pTabB.getSomme())
            return true;

        return false;
    }

}
