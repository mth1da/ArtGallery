# ArtGallery

Le projet a était conçu en MVC. C'est à dire nous avons une partie view (les .jsp) une partie controller (les servlets) et enfin une partie modèle (la base de données).
Dans le projet on retrouve plusieurs répertoire : 

- répertoire DAO : Dans ce répertoire se trouve des interfaces qui permettent de manipuler la base de donnée
      
- répertoire DAO/jdbc : ses classes implémentent l'interface qui permet de manipuler leur bdd. Elles font la connexion avec la base de donnée mysql.
Afin de faire la connexion à la base de données nous avons crées une interface DAOContext dans leqeul se trouve les paramétrages 
de la bdd qu'il faudra régler. Dans ce répertoire se trouve également le fichier .sql ainsi que les classes
qui qui permette de modifier la bdd et donc dans lequel se trouve des requêtes sql.

- répertoire DAO/repository : ses classes implémentent l'interface qui permet de manipuler leur bdd. Des listes sont utilisés ici afin de stocker les données dans les classes.


- répertoire Entity : Dans ce répertoire se trouve les objets de la base de données tel que les users (propriétaire, visiteur) , les artistes, les reservations ,       les critiques , les exibition et enfin les oeuvres. 
Il existe different types de user. Donc user est une classe abstraite. Un visiteur est un user qui peut acheter des oeuvres tandis que un propriétaire est un visiteur qui également vendre des oeuvres en plus des les achter. Un visiteur et un user se connecte de la meme maniere mais leur inscriptions sont différente car dans la bdd 
on peut avoir une meme @mail pour un visiteur et un propriétaire ce qui correspond à 2 comptes différents. Mais la connexion se fait de la meme manière mis à part le fait qu'il faut verifier que l'@ mail n'a pas deja etait utiliser chez les visiteurs pour un visiteur et chez les propriétaires pour un propriétaire.
Il existe également différents type d'oeuvre c'est pour cela que c'est une classe abstraite.



- répertoire Services : Dans ce répertoire se trouve la partie business c'est à dire toutes les actions qui vont être effectuer tel que l'inscription, la connexion,
l'ajout de nouvelles oeuvres, la modification de profil.
L'inscription d'un user à l'autre se fait de manière différente car ils n'ont pas tous forcément les memes attributs. Donc on a crée une interface inscription implémenter par une classe InscriptionVisiteur et InscriptionPropriétaire.


modularité : le système est découper en composant indépendant avec des classes différentes pour les inscriptions la connexion ainsi que la modification du profil et l'accés à la bdd.


abstraction : Les détails inutiles sont masquée car utilisation de nombreuse interface et classe abstraite


polymorphisme : Utilisation du polymorphisme avec les ovverride et le principe de ségrégation des interfaces.


injection de dépendance : On le retrouve beaucoup dans les classes représentant les serives tq l'inscription qui possède un attribut UserDao qui est une interface.
C'est donc grace à cela qu'on peut choisir d'utiliser la bdd mysql ou bien la bdd avec les listes.


encapsulation : les attributs des classes sont tous privé et récupérer par des getter et modifier par des setter.



SOLID :

principe de responsabilité unique :    chaque classe a une seul responsabilité dans notre code


principe de ouvert fermé :  pour ajouter un nouveau type d'oeuvre ou un nouveau type de user il suffit d'étendre la classe user avec une nouvelle classe qui va extend de user ou oeuvre. Donc pas besoin de modifier le code à  l'intérieur des classes.


principe de liskov : Les classes sont substituable car nous utilisons des abstractions dans les variables des méthodes et constructeur afin d'avoir des objets substituables.


principe de ségrégation des interfaces : Nous utilisons les abstractions les plus hautes afin d'utiliser toutes les fonctionnalité nécessaire.


principe de inversion de dépendance : On le retrouve beaucoup dans les classes représentant les serives tq l'inscription qui possède un attribut UserDao qui est une interface.
C'est donc grace à cela qu'on peut choisir d'utiliser la bdd mysql ou bien la bdd avec les listes. Les classes inscriptions dépendent d'une abstraction de la bdd et non pas directement de la bdd.










![artUML](https://user-images.githubusercontent.com/113671198/226119423-aa860f0e-7f15-41a1-b2ce-dba9f7dbea05.jpg)