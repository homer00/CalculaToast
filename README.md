# CalculaToast
A simple calculator (Java, Swing)

Calculette basique, 4 opérateurs, pas de parenthèses (les opérations sont traitées à partir d'un champ texte (JTextField), puis le calcul s'effectue de gauche à droite en respectant la précédence des opérateurs.

Il s'agit essentiellement d'un exercice visant à expérimenter les différents Layout de Java SWING, mais la partie algo (conversion d'une chaîne de caractères mêlant des valeurs numériques et des opérateurs, utilisation d'ArrayList et des méthodes associées, comme set(), add(), remove(),...) m'a donné pas mal de fil à retordre.

Quelques bogues, gestions d'erreurs à corriger.
Des améliorations sont aussi en projet, comme l'ajout d'un menu principal, l'utilisation de parenthèses, logo, traduction, etc...


Pour tester le programme :

Un exécutable jar est disponible : CalculaToast_261024.jar


Exécution sous linux :

user@machine:$ java -jar CalculaToast_261024.jar


Sous Windows, la commande est identique :

PS C:\Chemin_du_dossierJAR> java -jar CalculaToast_261024.jar 
