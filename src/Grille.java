import java.util.Random;

public class Grille {
	
	// NOMBRE DE LIGNES DE LA MATRICE
	private int ligne;
	// NOMBRE DE COLONNES DE LA MATRICE
	private int colonne;
	// MATRICE DE LA GRILLE
	private int[][] matrice;
	
	/***
	 * CONSTRUCTEUR GRILLE
	 * @param ligne
	 * @param colonne
	 */
	public Grille(int ligne, int colonne) 
	{
		this.ligne = ligne;
		this.colonne = colonne;
		matrice = new int[ligne][colonne];
	}
	
	/***
	 * GETTER DU NOMBRE DE LIGNES DE LA MATRICE
	 * @return LE NOMBRE DE LIGNES
	 */
	public int getLigne() 
	{
		return this.ligne;
	}

	/***
	 * SETTER DU NOMBRE DE LIGNES DE LA MATRICE
	 * @param value
	 */
	public void setLigne(int value) 
	{
		this.ligne = value;
	}
	
	/***
	 * GETTER DU NOMBRE DE COLONNES DE LA MATRICE
	 * @return LE NOMBRE DE COLONNES
	 */
	public int getColonne() 
	{
		return this.colonne;
	}
	
	/***
	 * SETTER DU NOMBRE DE COLONNES DE LA MATRICE
	 * @param value
	 */
	public void setColonne(int value) 
	{
		this.colonne = value;
	}
	
	/***
	 * GETTER DE LA MATRICE
	 * @return LA MATRICE
	 */
	public int[][] getMatrice() 
	{
		return this.matrice;
	}
	
	/***
	 * SETTER DE LA MATRICE
	 * @param matrice
	 */
	public void setMatrice (int[][] matrice) 
	{
		this.matrice = matrice;
	}
	
	/***
	 * FONCTION ESTVIDE : VERIFIE SI LA MATRICE EST VIDE
	 * @param matrice
	 * @return true SI LA MATRICE EST VIDE
	 * @return false SI LA MATRICE N'EST PAS VIDE
	 */
	public boolean estVide(int[][] matrice) 
	{
		for(int i = 0 ; i < this.ligne ; i++) {
			for(int j = 0 ; j < this.colonne ; j++) {
				if(matrice[i][j] == 0)
					return true;
			}
		}
		return false;
	}
	
	/***
	 * FONCTION AJOUTALEATOIRE : AJOUTE UN 2 ALEATOIREMENT DANS LA MATRICE
	 * @param matrice
	 */
	public void ajoutAleatoire(int[][] matrice) 
	{
		Random r = new Random();
		int ligne = r.nextInt(4);
		int colonne = r.nextInt(4);
		int ajoute = 1;
		while(ajoute > 0) {
			if(matrice[ligne][colonne] == 0) {
				matrice[ligne][colonne] = 128;
				ajoute = -1;
			}
			else {
				ligne = r.nextInt(4);
				colonne = r.nextInt(4);
				ajoute++;
			}
		}
	}
	
	/***
	 * FONCTION GAUCHE : DEPLACE LES CASES DE LA MATRICE VERS LA GAUCHE
	 * @param matrice
	 */
	public void gauche(int[][] matrice) 
	{
		for(int k = 0 ; k < this.colonne ; k++) {
			for(int i = 0 ; i < this.ligne ; i++) {
				for(int j = 0 ; j < this.colonne - 1 ; j++) {
					if(matrice[i][j] == matrice[i][j+1] && matrice[i][j] != 0) {
						matrice[i][j] = matrice[i][j] * 2;
						matrice[i][j+1] = 0;					
					}
					if(matrice[i][j] == 0) {
						matrice[i][j] = matrice[i][j+1];
						matrice[i][j+1] = 0;
					}
				}
			}
		}
	}

	/***
	 * FONCTION DROITE : DEPLACE LES CASES DE LA MATRICE VERS LA DROITE
	 * @param matrice
	 */
	public void droite(int[][] matrice) 
	{
		for(int k = 0 ; k < this.colonne ; k++) {
			for(int i = 0 ; i < this.ligne ; i++) {
				for(int j = this.colonne - 1 ; j > 0 ; j--) {
					if(matrice[i][j] == matrice[i][j-1] && matrice[i][j] != 0) {
						matrice[i][j] = matrice[i][j] * 2;
						matrice[i][j-1] = 0;					
					}
					if(matrice[i][j] == 0) {
						matrice[i][j] = matrice[i][j-1];
						matrice[i][j-1] = 0;
					}
				}
			}
		}
	}

	/***
	 * FONCTION BAS : DEPLACE LES CASES DE LA MATRICE VERS LE BAS
	 * @param matrice
	 */
	public void bas(int[][] matrice) 
	{
		for(int k = 0 ; k < this.ligne ; k++) {
			for(int i = this.ligne - 1 ; i > 0 ; i--) {
				for(int j = 0 ; j < this.colonne ; j++) {
					if(matrice[i][j] == matrice[i-1][j] && matrice[i][j] != 0) {
						matrice[i][j] = matrice[i][j] * 2;
						matrice[i-1][j] = 0;					
					}
					if(matrice[i][j] == 0) {
						matrice[i][j] = matrice[i-1][j];
						matrice[i-1][j] = 0;
					}
				}
			}
		}
	}

	/***
	 * FONCTION HAUT : DEPLACE LES CASES DE LA MATRICE VERS LE HAUT
	 * @param matrice
	 */
	public void haut(int[][] matrice) {
		for(int k = 0 ; k < this.ligne ; k++) {
			for(int i = 0 ; i < this.ligne - 1 ; i++) {
				for(int j = 0 ; j < this.colonne ; j++) {
					if(matrice[i][j] == matrice[i+1][j] && matrice[i][j] != 0) {
						matrice[i][j] = matrice[i][j] * 2;
						matrice[i+1][j] = 0;					
					}
					if(matrice[i][j] == 0) {
						matrice[i][j] = matrice[i+1][j];
						matrice[i+1][j] = 0;
					}
				}
			}
		}
	}
	
	/***
	 * FONCTION TOSTRING : AFFICHE LA GRILLE DE JEU
	 * @param matrice
	 * @return UNE CHAINE
	 */
	public String toString(int[][] matrice) 
	{
		String temp ="";
		for(int i = 0 ; i < this.ligne ; i++) {
			for(int j = 0 ; j < this.colonne ; j++) {
				if(matrice[i][j] == 0)
					temp += " | " + " ";
				if(matrice[i][j] != 0)
					temp += " | " + matrice[i][j];
			}
			temp += " | \n";
		}
		return temp;
	}
	
	/***
	 * FONCTION SCORE : CALCUL LE SCORE DU JOUEUR
	 * @param matrice
	 * @return UN ENTIER
	 */
	public int score(int[][] matrice) 
	{
		int somme = 0;
		for(int i = 0 ; i < this.ligne ; i++) {
			for(int j = 0 ; j < this.colonne ; j++)
				somme += matrice[i][j];
		}
		return somme;
	}
	
	/***
	 * FONCTION SUCCESS : VERIFIE SI 2048 A ETE ATTEINT
	 * @param matrice
	 * @return true SI 2048 A ETE ATTEINT
	 * @return false SI 2048 N'A PAS ETE ATTEINT
	 */
	public boolean success(int[][] matrice) 
	{
		for(int i = 0 ; i < this.ligne ; i++) {
			for(int j = 0 ; j < this.colonne ; j++) {
				if(matrice[i][j] == 2048)
					return true;
			}
		}
		return false;
	}
	
}
