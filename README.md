# TP 3 - PROJET DEMONSTRATION 

C'est un projet qui permet d'evaluer les connaissances acquises lors des TPs ...


## Dependencies (definitions)

Instructions on how to set up the project for development, including any dependencies that need to be installed.


Spring Web : Spring Web est un module du framework Spring qui fournit une prise en charge pour la construction d'applications web. Il inclut des fonctionnalités telles qu'un contexte d'application web, des options de configuration spécifiques au web et une prise en charge des technologies web courantes telles que HTTP et Servlets.

JPA : JPA signifie Java Persistence API. C'est une spécification Java pour accéder, persister et gérer les données entre les objets/classes Java et une base de données relationnelle. JPA est un standard pour la mappage objet-relationnel (ORM) et fournit un moyen de mapper des objets Java sur des tables de base de données relationnelles.

Hibernate : Hibernate est un framework ORM open-source qui met en œuvre la spécification JPA. Il fournit un moyen de mapper des objets Java sur des tables de base de données relationnelles et fournit un langage de requête pour interagir avec les données. Hibernate est un choix populaire pour ORM dans les applications Java.

H2 : H2 est un système de gestion de bases de données relationnelles open-source écrit en Java. Il est léger et peut être intégré dans des applications Java ou exécuté en tant que serveur autonome. H2 est couramment utilisé dans les environnements de développement et de test en raison de sa petite empreinte et de sa facilité d'utilisation.

DevTools : Spring Boot DevTools est un module du framework Spring Boot qui fournit des fonctionnalités amicales pour le développeur pour un développement rapide et un débogage. Il inclut des fonctionnalités telles que le redémarrage automatique de l'application, le rechargement en direct des ressources et la possibilité d'exécuter l'application dans un environnement de développement.

Thymeleaf : Thymeleaf est un moteur de template Java pour les applications web. Il est utilisé pour générer des pages HTML dynamiques sur la base de templates et de données. Thymeleaf est souvent utilisé pour générer des vues dans les applications web basées sur Spring.


## reponses de questions

 ###Etape 13 :
Nous avons le controlleur : 
@Controller
public class HelloWorldController {
@GetMapping("/greeting")
public String greeting(@RequestParam(name="nameGET", required=false, defaultValue="World") String
nameGET, Model model) {
model.addAttribute("nomTemplate", nameGET);
return "greeting";
}
}

1. Avec quelle partie du code avons-nous paramétré l'url d'appel /greeting ?
Avec l'annotation @GetMapping("/greeting") nous avons paramétré l'url d'appel /greeting pour la méthode greeting().

2. Avec quelle partie du code avons-nous choisi le fichier HTML à afficher ?
Avec la méthode "return "greeting";" nous avons choisi le fichier HTML à afficher.

3. Comment envoyons-nous le nom à qui nous disons bonjour avec le second lien ?

 en utilisant le paramètre @RequestParam de la méthode greeting(). Le paramètre "nameGET" est utilisé pour récupérer la valeur passée dans l'url sous forme de query parameter "name". Ensuite, cette valeur est ajoutée au modèle avec "model.addAttribute("nomTemplate", nameGET);" puis est passée à la vue pour être affichée.


 ###Etape 17 : (http://localhost:8080/h2-console/login.do?jsessionid=08cdc58b385b27514b97ff13fd675c11)
Relancez-votre application, retournez sur la console de H2 : http://localhost:8080/h2-console. Avez-vous remarqué une différence ? 

on trouve qu'une nouvelle table ADDRESS derivee de la class Address est ajoutée automatiquement

###Etape 18 :

Expliquez l'apparition de la nouvelle table en vous aidant de vos cours sur Hibernate, et de la dépendance Hibernate de Spring.

Hibernate est un outil ORM qui nous permet d'interagir avec une base de données en utilisant des objets Java. Voici le processus général de ce qui s'est passé :
La classe Adress avait l'annotation @Entity qui sera utilisée pour générer des tables avec. Cela indique à Hibernate que la classe doit être utilisée pour générer une table.
Les champs sont annotés par : @Id pour la clé primaire, @Column pour les colonnes, et @ManyToOne pour les relations.
 l'application et les tables seront créées automatiquement par Hibernate lors du démarrage.

###Etape 19 :
Faites une requête de type SELECT sur la table Adress. Voyez-vous tout le contenu de data.sql ?
oui, ça marche parfaitement !

###Etape 22 :
Pouvez-vous trouver à quoi sert l'annotation @Autowired du code précèdent sur internet ? 

L'annotation @Autowired est utilisée pour injecter des dépendances dans les classes de l' application. Il permet de demander à Spring de fournir une instance d'une classe dépendante (ou d'une interface) pour une classe qui en a besoin.
Spring va automatiquement créer une instance de l'objet nécessaire et l'injecter dans la variable donnee. Cela permet de supprimer la nécessité de créer manuellement les instances des objets nécessaires et de les assigner aux variables, ce qui facilite la gestion des dépendances et améliore la lisibilité du code.



###Etape 30
Expliquez la méthode que vous avez utilisé pour ajouter Bootstrap :

j'ai simplement ajouter les CDN et les scripts associés à bootstrap ci-dessous à la partie head de la page HTML :

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">	
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.11.5/datatables.min.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.11.5/datatables.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

## Auteur


BOUJAMZA Meriem 

