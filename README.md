# ArtGallery

Le projet a était conçu en MVC. C'est à dire nous avons une partie view (les .jsp) une partie controller (les servlets) et enfin une partie modèle (la base de données).
Dans le projet on retrouve plusieurs répertoire : 



      - répertoire DAO : Dans ce répertoire se trouve des interfaces qui permettent de manipuler la base de donnée
      
      
                - répertoire jdbc : ses classes implémentent l'interface qui permet de manipuler leur bdd. Elles font la connexion avec la base de donnée mysql.
                           Afin de faire la connexion à la base de données nous avons crées une interface DAOContext dans leqeul se trouve les paramétrages 
                           de la bdd qu'il faudra régler ainsi que le fichier. Dans ce répertoire se trouve également le fichier .sql ainsi que les classes
                           qui qui permette de modifier la bdd et donc dans lequel se trouve des requêtes sql.
                - répertoire dao : ses classes implémentent l'interface qui permet de manipuler leur bdd. Des listes sont utilisés ici afin de stocker les données                                        dans les classes.
      - répertoire Entity : Dans ce répertoire se trouve les objets de la base de données tel que les users (propriétaire, visiteur) , les artistes, les reservations ,           les critiques et enfin les oeuvres. 
                       - classe user est abstraite car il existe différent type de user tq 
      - répertoi Services : Dans ce répertoire se trouve la partie business c'est à dire toutes les actions qui vont être effectuer tel que l'inscription, la connexion,
      l'ajout de nouvelles oeuvres, la modification de profil ...


modularité : \n
abstraction :
polymorphisme :
injection de dépendance :

SOLID :

principe de responsabilité unique :
principe de ouvert fermé :
principe de 
principe de ségrégation des interfaces
principe de inversion de dépendance




![UMLaoo](https://user-images.githubusercontent.com/113671198/226066795-c3cefa06-a409-4890-98d0-2208b4396696.PNG)
