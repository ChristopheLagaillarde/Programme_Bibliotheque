/*/////////////////En t�te////////////////////////////
 * Programme : Biblioth�que
 *
 * Description : Ce programme d�finit une repr�sentation
 *               d'un objet livre. La classe associ�e aura
 *               pour attribut : le titre, le pr�nom et 
 *               le nom de l'auteur, la cat�gorie du livre,
 *               son ISBN, et son code alphanum�rique.
 *               Elle aura pour m�thode saisirLivre,
 *               afficherLivre, et calculerCode. 
 *
 * Auteur : Christophe LAGAILLARDE
 *
 * Date : 04/04/2021
 *        
 *///////////////////////////////////////////////////

// D�claration des bibliotheques de fonctions...
package programme_bibliotheque;
import java.util.Scanner;

//////////////////Le Programme principal/////////////

//////////////////D�but//////////////////////////////

/* Questions :
 * 
 * Lorsque tout marche changer les attributs titre, isbn
 * et code de Livre en priv�.
 * Que ce passe t-il ? Modifier le code pour que cela marche en priv�.
 * 
 * R�ponses : 
 * 
 * - Lorsque l'on met les attributs titre, isbn et code de Livre en priv�,
 * le programme ne marche plus, le programme indique "ne plus voir" les
 * attributs titre et isbn puisqu'ils ont �t� mit en priv�. 
 * Il n'y a cependant pas de probl�me pour l'attribut "code" car le contenue
 * de celui-ci lui est attribu� � travers la m�thode calculerCode la classe Livre. 
 * 
 * - Pour rem�dier � ce probl�me nous avons trouv� 3 solutions :
 * 
 *  1) Ou bien nous mettons les saisies des attributs priv�s dans une m�thode 
 *  appartenant � la classe livre ( nous profitons d'ailleurs de l'occassion
 *  pour mettre dans la-dite m�thode les saisies des attributs publique de la
 *  classe Livre pour plus de clart� ).
 *  
 *  2) Ou bien, nous d�pla�ont la d�claration de la classe Livre pour la mettre en
 *  statique � l'interieur de la classe Programme_Bibliotheque avant ou apr�s
 *  le main. 
 * 
 *  3) Ou bien, nous d�pla�ont la d�claration de la classe Livre pour la mettre �
 *    l'interieur du main, avant la cr�ation de l'objet livrePoche.
 * */
class Livre {

	// Attributs

	// Attributs publique
	public String prenomAuteur;    // Pour les besoins de l'exercice nous mettons explicitement certain attributs              
	public String nomAuteur;       // en publique bien que cela ne soit pas n�c�ssaire pour le programme
	public String categorie;

	// Attributs priv�
	private String titre;                          
	private String isbn;
	private String code;           // Contient les 2 premi�res lettre du pr�nom et nom de l'auteur, et les deux derniers caract�res de l'ISBN

	// M�thodes
	void saisirLivre() {                           // Permet la saisie des attributs de l'objet livre
		this.prenomAuteur = "";                    // Initialisation qui permet de rentrer dans la boucle while plus bas
		this.nomAuteur = "";
		this.isbn = "";
		Scanner saisieUtilisateur = new Scanner(System.in);
		System.out.println("Veillez entrer le titre du livre : ");
		this.titre = saisieUtilisateur.nextLine();
		while(this.prenomAuteur.length() < 2) {        // On emp�che les saisies absurde ou probl�matique
			System.out.println("Veillez entrer le pr�nom de l'auteur(au moins 2 caract�res)");
			this.prenomAuteur = saisieUtilisateur.nextLine();
		}
		while(this.nomAuteur.length() < 2) {          // On emp�che les saisies absurde ou probl�matique
			System.out.println("Veillez entrer le nom de l'auteur (au moins 2 caract�res)");
			this.nomAuteur = saisieUtilisateur.nextLine();
		}
		System.out.println("Veillez entrer la cat�gorie du livre");
		this.categorie = saisieUtilisateur.nextLine();
		while(this.isbn.length() < 10) { 
			System.out.println("Veillez entrer l'ISBN-10 du livre, il faut au moins 10 caract�res (par exemple : 2-7654-1005-4) ");
			this.isbn = saisieUtilisateur.nextLine(); 
		}
		saisieUtilisateur.close();
		calculerCode();                          // Apr�s la saisie on cacul le code pour donner audit livre un code
	}

	void afficherLivre() {                      // Permet l'affichage des attributs de l'objet livre
		System.out.println("Le titre du livre est : " + this.titre);
		System.out.println("L'auteur du livre est : " + this.prenomAuteur + " " + this.nomAuteur);
		System.out.println("La cat�gorie du livre est : " + this.categorie);
		System.out.println("L'ISBN du livre est : " + this.isbn);
		System.out.println("Le code du livre est : " + this.code);
	}

	void calculerCode() {
		String isbnSansTiretNiEspace = this.isbn.replace("-","");      // On enl�ve les tirets et espaces du ISBN pour �viter les erreur lors de la cr�action du code alphanum�rique
		isbnSansTiretNiEspace = isbnSansTiretNiEspace.replace(" ",""); // On le fait en les rempla�ant par "" gr�ce � str.replace
		this.code = this.prenomAuteur.substring(0, 2) + this.nomAuteur.substring(0, 2) + isbnSansTiretNiEspace.substring(isbnSansTiretNiEspace.length() - 2, isbnSansTiretNiEspace.length());
	}   // Pour la concat�nation des 2 derniers caract�res de l'ISBN on utilise str.length pour faire la selection du substring depuis la fin de la chaine
}

public class Programme_Bibliotheque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {                                       // try permet de g�rer les exceptions  
			Livre livrePoche = new Livre();

			// Code pr�sent avant les modifications demand�s par l'exercice

			/* Scanner saisieUtilisateur = new Scanner(System.in);
			System.out.println("Veillez entrer le titre du livre : ");
			livrePoche.titre = saisieUtilisateur.nextLine();
			System.out.println("Veillez entrer le pr�nom de l'auteur");
			livrePoche.prenomAuteur = saisieUtilisateur.nextLine();
			System.out.println("Veillez entrer le nom de l'auteur");
			livrePoche.nomAuteur = saisieUtilisateur.nextLine();
			System.out.println("Veillez entrer la cat�gorie du livre");
			livrePoche.categorie = saisieUtilisateur.nextLine();
			System.out.println("Veillez entrer l'ISBN-10 du livre (par exemple : 2-7654-1005-4) ");
			livrePoche.isbn = saisieUtilisateur.nextLine(); 
			saisieUtilisateur.close();
			livrePoche.calculerCode();      */

			livrePoche.saisirLivre();
			livrePoche.afficherLivre();
		}

		catch(Exception erreurDeSaisie) {         // catch affiche un message d'erreur en cas de saisie d'exception 
			System.err.println("Erreur de saisie");
		}
	}
}
//////////////////Fin//////////////////////////////