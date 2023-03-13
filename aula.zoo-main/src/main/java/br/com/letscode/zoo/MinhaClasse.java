package br.com.letscode.zoo;

public class MinhaClasse {

    private static MinhaClasse minhaClasse;

    private MinhaClasse() {
        System.out.println("Minha Classe Iniciou!");
    }

    public static MinhaClasse getInstance() {
        if (minhaClasse == null) {
            minhaClasse = new MinhaClasse();
        }
        return minhaClasse;
    }
}
