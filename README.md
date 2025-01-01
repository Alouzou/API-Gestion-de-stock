
# Gestion de Stock

## Description
Ce projet de **gestion de stock** a été conçu pour faciliter la gestion des produits, des stocks et des mouvements dans un environnement de vente. Il permet aux utilisateurs de suivre l'inventaire, d'ajouter ou de retirer des produits, ainsi que de générer des rapports sur les stocks.

Le projet utilise **Spring Boot** pour le backend et **Docker** pour la containerisation. Le stockage des données est effectué à l'aide de **MySQL**, et le projet est déployé dans un environnement Docker pour une meilleure portabilité et gestion des services.

## Technologies utilisées
- **Spring Boot** : Framework Java pour le développement du backend
- **Docker** : Pour la containerisation de l'application
- **MySQL** : Base de données relationnelle pour le stockage des informations de stock
- **Docker Compose** : Outil permettant de définir et gérer des applications multi-conteneurs
- **JPA/Hibernate** : Pour l'interaction avec la base de données

## Sécurité :
- **JWT** L'application utilise des tokens JWT pour l'authentification,
- **Routes public** Les routes comme /auth/** et celles liées à Swagger (documentation API) sont accessibles sans authentification.
- **Sécurisation des routes** Toutes les autres routes nécessitent une authentification via un token JWT valide.
- **BCryptPasswordEncoder** pour encoder les mots de passes dans la base de données.


## Prérequis
- **Docker** : Assurez-vous que Docker est installé sur votre machine.
- **Docker Compose** : Outil pour gérer les conteneurs multi-services.
- **Java8** : Pour la partie backend Spring Boot.
- **Maven** : Pour la gestion des dépendances du projet Spring Boot.

## Installation

### 1. Clonez le repository
Commencez par cloner le projet depuis GitHub :

```bash
git clone https://github.com/Alouzou/gestion-de-stock.git
cd gestion-de-stock
```

### 2. Configurez le fichier `.env`
Le fichier `.env` contient des variables d'environnement essentielles pour la configuration de l'application. Assurez-vous que ce fichier est correctement configuré pour votre environnement local.

```ini
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/NomDeBaseDonnés
SPRING_DATASOURCE_USERNAME=VotreUsername
SPRING_DATASOURCE_PASSWORD=VotreMotDePasse
SPRING_JPA_HIBERNATE_DDL_AUTO=update

MYSQL_ROOT_PASSWORD=VotreMotDePasse
MYSQL_DATABASE=NomDeBaseDonnés
```

### 3. Exécutez l'application avec Docker Compose
Pour démarrer l'application avec **Docker Compose**, utilisez la commande suivante :

```bash
docker-compose up --build
```

Cela va :
- Construire les images Docker à partir du `Dockerfile`
- Démarrer les conteneurs pour l'application et la base de données MySQL

L'application sera alors accessible sur `http://localhost:8080`.

### 4. Accédez à l'application
L'application sera accessible via le port `8080` sur votre machine locale. Vous pouvez utiliser votre navigateur ou un outil comme **Postman** pour interagir avec l'API.

## Fonctionnalités

- **Gestion des produits** : Ajouter, supprimer, modifier les produits dans le stock.
- **Gestion des Utilisateurs, clients et fournisseurs** : Ajouter, supprimer, modifier.
- **Suivi des quantités** : Voir l'état des stocks en temps réel.
- **Rapports** : Générer des rapports sur les stocks disponibles et les mouvements.
- **Sécurité** : Authentification et autorisation de base.

## Architecture du projet

L'architecture du projet est divisée en plusieurs modules :

1. **Backend Spring Boot** : Fournit les API RESTful.
2. **Base de données MySQL** : Stocke les informations sur les produits, les utilisateurs et les mouvements de stock.
3. **Docker** : Permet de containeriser les services backend et MySQL.

## Configuration Docker

Le projet utilise **Docker Compose** pour configurer et gérer les services dans des conteneurs. Voici une description des services définis dans `docker-compose.yml` :

- **App (gestiondestock-app)** : L'application backend Spring Boot.
- **MySQL (mysql-db)** : Conteneur pour la base de données MySQL utilisée pour stocker les informations.

## À améliorer :
- **Une application FrontEnd Angular/React**
- **Un peu de logique métier**
- **Les tests unitaires**
- **Un pipeline CI/CD**

Merci d'avoir consulté ce projet de gestion de stock !
