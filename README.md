![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
<br/>
![Static Badge](https://img.shields.io/badge/17-JAVA_version-orange)
![Static Badge](https://img.shields.io/badge/3.3.4-Spring_Boot_version-gree)

# 🚙 Projet 3 - Développez le back-end en utilisant Java et Spring

Ce projet est centré sur le développement d'un serveur Back-end avec Spring Boot. Plusieurs critères étaient demandés, systèmes d'authentification, séparation des rôles dans la structure, gestion d'upload d'image et une documentation Swagger.

## 📖 Sommaire

- [Projet](#-projet)
    - [Prérequis](#prérequis)
    - [Importer la base de données MySQL](#importer-la-base-de-donnée-mysql)
    - [Variables d'environnement](#variable-denvironnement)
    - [Build le projet](#build-the-project)
    - [Build l'artifact](#build-lartifact)
- [Etape de conception](#-etape-de-conception)
- [Documentation](#-documentation)
    - [Dépendances](#dépendances)
    - [Strucuture](#structure)
    - [MySQL](#mysql)
    - [Swagger](#swagger)

## 📁 Projet

### Prérequis

1. Fork ou cloner ce projet
2. Installer [MySQL 8 command Line](https://openclassrooms.com/fr/courses/6971126-implementez-vos-bases-de-donnees-relationnelles-avec-sql/7152681-installez-le-sgbd-mysql) ou avec [Docker](https://spring.io/guides/gs/accessing-data-mysql)(méthode non réalisée)
3. [Importer la BDD MySQL](#importer-la-base-de-donnée-mysql)
4. Installer les [Variables d'environnement](#variable-denvironnement)

### Importer la base de donnée MySQL

Dans le fichier `resources` à la racine du projet puis dans `mysql` vous trouverez un `script.sql` à importer dans votre MySQL une fois installé

Si vous n'êtes pas connecté :

`mysql -u root -p nom_de_la_base_de_donnees < mon/chemin/resources/mysql/script.sql;`

Si vous êtes connecté :

`source mon/chemin/resources/mysql/script.sql;`

### Variable d'environnement

Configurer les variables d'environnement directement sur Intellij: 

`Run` > `Edit Configuration` > `Modify options` > cocher `Variable environment` > 
Dans le champ `Environment variables` cliquer sur `$`

Liste des variables d'environnement :

```
DATABASE_URL -> url_bdd_mysql
DATABASE_USERNAME -> identifiant_mysql
DATABASE_PASSWORD -> mdp_mysql
JWT_SECRET_KEY -> générer_avec_openssl

```
> [!TIPS]
> Vous pouvez générer votre JWT_SECRET_KEY avec la commande:
> `openssl rand -base64 32`

### Build le projet

1. Cliquer sur le bouton **play** `Run 'P3ChatopApplication'` dans la barre en haut d'**IntelliJ**.
2. Soit, vous faites des requêtes depuis postman `resources/postman` ou cloner et démarrer le [front-end](https://github.com/OpenClassrooms-Student-Center/Developpez-le-back-end-en-utilisant-Java-et-Spring).

### Build l'artifact

1. Accéder à la Configuration des Artifacts :
- Allez dans le menu File (Fichier) > Project Structure (Structure du Projet).
- Dans la fenêtre qui s'ouvre, sélectionnez Artifacts dans la colonne de gauche.
2. Ajouter un Nouvel Artifact :
- Cliquez sur le bouton + dans le coin supérieur gauche.
- Sélectionnez JAR > From modules with dependencies.
3. Configurer l'Artifact :
- Dans la fenêtre qui s'ouvre, choisissez le module principal de votre application (c'est généralement celui qui contient la classe avec la méthode main).
- Vous pouvez également spécifier le Main Class en sélectionnant votre classe principale. Cela permet à l'artefact de s'exécuter correctement.
4. Configurer le Chemin de Sortie :
- Dans la section Output directory (Répertoire de sortie), choisissez un répertoire où vous souhaitez que le fichier JAR soit généré. Par défaut, cela pourrait être quelque chose comme out/artifacts/<nom_de_votre_artifact>.
5. Valider les Paramètres :
- Cliquez sur OK pour enregistrer votre configuration d'artifact.
6. Construire l'Artifact :
- Allez dans le menu Build (Construire) en haut de l'écran.
- Cliquez sur Build Artifacts....
- Sélectionnez l'artifact que vous venez de créer et cliquez sur Build.

## ⚙️ Etape de conception

### [STEP 1 - Initialisation du projet](https://github.com/Tom-DevWeb/OC-DA_Angular_Java-P3_ChaTop/pull/1)

Configuration de Spring Boot et connexion MySQL

### [STEP 2 - Authentification JWT](https://github.com/Tom-DevWeb/OC-DA_Angular_Java-P3_ChaTop/pull/2)

Implémentation de l'authentification JWT

### [STEP 3 - Implémentation une route](https://github.com/Tom-DevWeb/OC-DA_Angular_Java-P3_ChaTop/pull/3)

Implémentation de la route `/auth/*`

### [STEP 4 - Implémentation Swagger](https://github.com/Tom-DevWeb/OC-DA_Angular_Java-P3_ChaTop/pull/4)

Ajout de la dépendance `org.springdoc` et documentation de la route `/auth/**`

### [STEP 5 - Implémentation des routes](https://github.com/Tom-DevWeb/OC-DA_Angular_Java-P3_ChaTop/pull/5)

Implémentation des routes `/rentals/**`, `/message` et `/user/**`

### [STEP 6 - Documentation Swagger](https://github.com/Tom-DevWeb/OC-DA_Angular_Java-P3_ChaTop/pull/6)

Rédaction de la documentation Swagger et test endpoints.

### [STEP 7 - Nettoyer le code](https://github.com/Tom-DevWeb/OC-DA_Angular_Java-P3_ChaTop/pull/7)

Nettoyage du code et rédaction de la documentation README

## 📄 Documentation

### Dépendances

- spring-boot-starter-validation - 3.3.4
- spring-boot-starter-data-jpa - 3.3.4
- spring-boot-starter-oauth2-resource-server - 3.3.4
- spring-boot-starter-security - 3.3.4
- spring-boot-starter-web - 3.3.4
- mysql-connector-j
- lombok - 1.18.34
- spring-boot-starter-test - 3.3.4
- spring-security-test
- mapstruct - 1.6.2
- jjwt-api - 0.11.5
- jjwt-impl - 0.11.5
- jjwt-jackson - 0.11.5
- springdoc-openapi-starter-webmvc-ui - 2.5.0

### Structure

`configurations` **/** Contient les classes de configuration de l'application, comme la configuration de la sécurité, des bases de données, et des dépendances.

`controllers` **/** Réceptionne les requêtes et fournit les réponses, en orchestrant les appels aux services appropriés.

`services` **/** Exécute les traitements métiers, encapsulant la logique d'application et coordonnant les opérations entre les contrôleurs et les repositories.

`repositories` **/** Communique avec la source de données, en utilisant JPA pour effectuer des opérations CRUD.

`entities` **/** Contient les objets métiers, représentant les tables de la base de données et les relations entre elles.

`dto` **/** Contient les objets de transfert de données, utilisés pour transférer des données entre les différentes couches de l'application sans exposer les entités directement.

`mappers` **/** Contient les classes ou interfaces responsables de la transformation des données entre les DTOs et les entités, utilisant MapStruct.

`exceptions` **/** Contient les classes d'exception personnalisées et les gestionnaires d'exceptions pour gérer les erreurs de manière cohérente dans l'application.



### MySQL
Liste des tables:
- users
- rentals
- messages

### Swagger

Démarrer l'application et entrer le lien suivant:
http://localhost:8080/api/swagger-ui/index.html


