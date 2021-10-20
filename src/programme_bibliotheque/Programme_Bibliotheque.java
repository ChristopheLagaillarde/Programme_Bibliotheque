/*/////////////////En tête////////////////////////////
 * Programme : Bibliothèque
 *
 * Description : Ce programme définit une représentation
 *               d'un objet livre. La classe associée aura
 *               pour attribut : le titre, le prénom et 
 *               le nom de l'auteur, la catégorie du livre,
 *               son ISBN, et son code alphanumérique.
 *               Elle aura pour méthode saisirLivre,
 *               afficherLivre, et calculerCode. 
 *
 * Auteur : Christophe LAGAILLARDE
 *
 * Date : 04/04/2021
 *        
 *///////////////////////////////////////////////////

// Déclaration des bibliotheques de fonctions...
package programme_bibliotheque;
import java.util.Scanner;

//////////////////Le Programme principal/////////////

//////////////////Début//////////////////////////////

/* Questions :
 * 
 * Lorsque tout marche changer les attributs titre, isbn
 * et code de Livre en privé.
 * Que ce passe t-il ? Modifier le code pour que cela marche en privé.
 * 
 * Réponses : 
 * 
 * - Lorsque l'on met les attributs titre, isbn et code de Livre en privé,
 * le programme ne marche plus, le programme indique "ne plus voir" les
 * attributs titre et isbn puisqu'ils ont été mit en privé. 
 * Il n'y a cependant pas de problème pour l'attribut "code" car le contenue
 * de celui-ci lui est attribué à travers la méthode calculerCode la classe Livre. 
 * 
 * - Pour remédier à ce problème nous avons trouvé 3 solutions :
 * 
 *  1) Ou bien nous mettons les saisies des attributs privés dans une méthode 
 *  appartenant à la classe livre ( nous profitons d'ailleurs de l'occassion
 *  pour mettre dans la-dite méthode les saisies des attributs publique de la
 *  classe Livre pour plus de clarté ).
 *  
 *  2) Ou bien, nous déplaçont la déclaration de la classe Livre pour la mettre en
 *  statique à l'interieur de la classe Programme_Bibliotheque avant ou après
 *  le main. 
 * 
 *  3) Ou bien, nous déplaçont la déclaration de la classe Livre pour la mettre à
 *    l'interieur du main, avant la création de l'objet livrePoche.
 * */
class Livre {

	// Attributs

	// Attributs publique
	public String prenomAuteur;    // Pour les besoins de l'exercice nous mettons explicitement certain attributs              
	public String nomAuteur;       // en publique bien que cela ne soit pas nécéssaire pour le programme
	public String categorie;

	// Attributs privé
	private String titre;                          
	private String isbn;
	private String code;           // Contient les 2 premières lettre du prénom et nom de l'auteur, et les deux derniers caractères de l'ISBN

	// Méthodes
	void saisirLivre() {                           // Permet la saisie des attributs de l'objet livre
		this.prenomAuteur = "";                    // Initialisation qui permet de rentrer dans la boucle while plus bas
		this.nomAuteur = "";
		this.isbn = "";
		Scanner saisieUtilisateur = new Scanner(System.in);
		System.out.println("Veillez entrer le titre du livre : ");
		this.titre = saisieUtilisateur.nextLine();
		while(this.prenomAuteur.length() < 2) {        // On empêche les saisies absurde ou problématique
			System.out.println("Veillez entrer le prénom de l'auteur(au moins 2 caractères)");
			this.prenomAuteur = saisieUtilisateur.nextLine();
		}
		while(this.nomAuteur.length() < 2) {          // On empêche les saisies absurde ou problématique
			System.out.println("Veillez entrer le nom de l'auteur (au moins 2 caractères)");
			this.nomAuteur = saisieUtilisateur.nextLine();
		}
		System.out.println("Veillez entrer la catégorie du livre");
		this.categorie = saisieUtilisateur.nextLine();
		while(this.isbn.length() < 10) { 
			System.out.println("Veillez entrer l'ISBN-10 du livre, il faut au moins 10 caractères (par exemple : 2-7654-1005-4) ");
			this.isbn = saisieUtilisateur.nextLine(); 
		}
		saisieUtilisateur.close();
		calculerCode();                          // Après la saisie on cacul le code pour donner audit livre un code
	}

	void afficherLivre() {                      // Permet l'affichage des attributs de l'objet livre
		System.out.println("Le titre du livre est : " + this.titre);
		System.out.println("L'auteur du livre est : " + this.prenomAuteur + " " + this.nomAuteur);
		System.out.println("La catégorie du livre est : " + this.categorie);
		System.out.println("L'ISBN du livre est : " + this.isbn);
		System.out.println("Le code du livre est : " + this.code);
	}

	void calculerCode() {
		String isbnSansTiretNiEspace = this.isbn.replace("-","");      // On enlève les tirets et espaces du ISBN pour éviter les erreur lors de la créaction du code alphanumérique
		isbnSansTiretNiEspace = isbnSansTiretNiEspace.replace(" ",""); // On le fait en les remplaçant par "" grâce à str.replace
		this.code = this.prenomAuteur.substring(0, 2) + this.nomAuteur.substring(0, 2) + isbnSansTiretNiEspace.substring(isbnSansTiretNiEspace.length() - 2, isbnSansTiretNiEspace.length());
	}   // Pour la concaténation des 2 derniers caractères de l'ISBN on utilise str.length pour faire la selection du substring depuis la fin de la chaine
}

public class Programme_Bibliotheque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {                                       // try permet de gérer les exceptions  
			Livre livrePoche = new Livre();

			// Code présent avant les modifications demandés par l'exercice

			/* Scanner saisieUtilisateur = new Scanner(System.in);
			System.out.println("Veillez entrer le titre du livre : ");
			livrePoche.titre = saisieUtilisateur.nextLine();
			System.out.println("Veillez entrer le prénom de l'auteur");
			livrePoche.prenomAuteur = saisieUtilisateur.nextLine();
			System.out.println("Veillez entrer le nom de l'auteur");
			livrePoche.nomAuteur = saisieUtilisateur.nextLine();
			System.out.println("Veillez entrer la catégorie du livre");
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