# ArtGallery

Fonctionnalitées développées pour le moment == inscription (visiteur et propriétaire) , connexion, updateProfil et afficher les oeuvres appartenant au propriétaire.

Le projet a était conçu selon le modèle MVC. Ainsi nous avons une partie view (les .jsp), une partie controller (les servlets) et enfin une partie modèle (la base de données).
Dans le projet, nous retrouvons plusieurs répertoires : 

- Répertoire DAO : Dans ce répertoire se trouvent des interfaces qui permettent de manipuler la base de donnée.
      
- Répertoire DAO/jdbc : Ces classes implémentent l'interface permettant de manipuler leur bdd. Elles font ainsi la connexion avec la base de donnée mysql.
Afin de faire la connexion à la base de données, nous avons créé une interface DAOContext dans laquelle se trouvent les paramétrages de la bdd qu'il faudra régler. Dans ce répertoire se trouve également le fichier .sql ainsi que les classes permettant de modifier la bdd et donc dans laquelle se trouve des requêtes sql.

- Répertoire DAO/repository : Ces classes implémentent l'interface qui permet de manipuler leur bdd. Des listes sont utilisés ici afin de stocker les données dans les classes.

- Répertoire Entity : Dans ce répertoire se trouve les objets de la base de données tel que les users (propriétaire, visiteur), les artistes, les reservations, les critiques , les exibition et enfin les oeuvres. 
Il existe different types de user, ainsi user est une classe abstraite. Un visiteur est un user qui peut acheter des oeuvres tandis qu'un propriétaire est un user qui peut en vendre. Un visiteur et un propriétaire se connectent de la meme manière mais leurs inscriptions sont différentes car dans la bdd, nous pouvons avoir une meme adresse email pour un visiteur et un propriétaire, ce qui correspond à deux comptes différents. En ce qui concerne la connexion, elle se fait de la même manière. Il faut seulement vérifier que l'adresse email n'a pas déjà été utilisé chez les visiteurs pour un visiteur et chez les propriétaires pour un propriétaire.
Il existe également différents types d'oeuvres, c'est pour cela que c'est une classe abstraite. 

- Répertoire Services : Dans ce répertoire se trouve la partie business, c'est-à-dire toutes les actions qui vont être effectué tels que l'inscription, la connexion, l'ajout de nouvelles oeuvres, la modification du profil.
L'inscription d'un user à l'autre se fait de manières différentes car ils n'ont pas tous forcément les mêmes attributs. Ainsi nous avons créé une interface Inscription implémentée par une classe InscriptionVisiteur et InscriptionPropriétaire.
La connexion et la modification du profil se fait de la meme manière pour tous les utilisateurs donc afin de se connecter ou modifier le profil d'un user il faut passer par une classe connexion et une classe update profile qui fera appel ensuite a une methode d'une des classe qui implémente UserDAO.
Plus tard on pourra mettre la classe connexion en interface si l'on se connecte de manière différente (ex: connexion avec google, facebook...) .



Modularité : Le système est découpé en composant indépendant avec des classes différentes pour les inscriptions, la connexion ainsi que la modification du profil et l'accès à la base de données.

Abstraction : Les détails inutiles sont masqués avec l'utilisation de nombreuses interfaces et classes abstraites.

Polymorphisme : Utilisation du polymorphisme avec les Ovverride et le principe de ségrégation des interfaces.

Injection de dépendance : On le retrouve beaucoup dans les classes représentant les serives tel que l'inscription qui possède un attribut UserDao qui est une interface.
C'est donc grace à cela que l'on peut choisir d'utiliser la base de données mysql ou bien l'utilisation des listes.

Encapsulation : Les attributs des classes sont tous privé et récupérés par des getter et modifiés par des setter.

Principes SOLID :

Principe de responsabilité unique : Chaque classe a une seul responsabilité dans notre code.

Principe de ouvert/fermé : Pour ajouter un nouveau type d'oeuvre ou un nouveau type de user, il suffit d'étendre la classe User avec une nouvelle classe qui va extend de user ou oeuvre. Donc pas besoin de modifier le code à l'intérieur des classes.

Principe de liskov : Les classes sont substituables car nous utilisons des abstractions dans les variables des méthodes et constructeurs afin d'avoir des objets substituables.

Principe de ségrégation des interfaces : Nous utilisons les abstractions les plus hautes afin d'utiliser toutes les fonctionnalités nécessaires.

Principe d'inversion de dépendance : On le retrouve beaucoup dans les classes représentants les serives tel que l'inscription qui possède un attribut UserDao qui est une interface.
C'est donc grace à cela que l'on peut choisir d'utiliser la base de données mysql ou bien la base de données avec les listes. Les classes inscriptions dépendent d'une abstraction de la bdd et non pas directement de la bdd.


![artUML](https://user-images.githubusercontent.com/113671198/226119423-aa860f0e-7f15-41a1-b2ce-dba9f7dbea05.jpg)
