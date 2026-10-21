#Le fichier Dockerfile que l'on rédige maintenant : c'est un simple fichier texte de configuration.
#C'est la « recette » ou  le plan de construction qui contient les instructions
# (quelle version de Java utiliser, quel fichier .jar copier,


#notre application spring bot a besoin d'un kit de developpement java (jdk 21)pour s'executer .
#plutot que obliger le serveur distant a installer java 21
#cette ligne telechagre et integre directement un environnement java officiel et propre a l'interier de mon caonteneru

FROM eclipse-temurin:21-jdk

#c'est une etiquette infroamtive , elle sert a documenter l'image en inscrivant le nom du createur /mainteneur
LABEL "org.opencontainers.image.authors"="yassine.com"
#Votre code source brut (Java) ne peut pas s'exécuter directement.
#Il faut d'abord compiler le projet en un fichier exécutable (le .jar via Maven).
# 3. Copier le .jar de grade depuis le dossier target vers le conteneur
COPY target/grade-microservices-0.0.1-SNAPSHOT.jar  grade-microservices-0.0.1-SNAPSHOT.jar

#Une fois que le conteneur démarre, il a besoin de savoir quoi faire.
#ici on definit la commande par default qui 'exécute automatiquement pour lance rmon app spring boot
#(java -jar ...), exactement comme si vous tapiez la commande dans votre propre termina
ENTRYPOINT ["java", "-jar", "grade-microservices-0.0.1-SNAPSHOT.jar"]

#L'Image Docker (Le modèle figé) :
#C'est l'archive, le fichier statique (comme un patron ou un fichier d'installation).
# Elle contient ton code compilé (.jar) et Java 21.
#elle est fabriquée après. Elle sera générée lorsque tu exécuteras la commande de construction (docker build)
 # en demandant à Docker de lire ton fichier Dockerfile pour créer l'image finale

#Le Conteneur (La boîte vivante) :
#
#C'est l'application qui tourne réellement en mémoire à un instant T  C'est la concrétisation de l'image.

# Quand tu lances le conteneur ton microservice démarre et commence à écouter sur un port (ex: 8080). On le crée avec docker run.



#-p [Port de ton PC] : [Port à l'intérieur du conteneur]
#docker run -d -p 9090:8081 yessine22/grade:v1
#L'option -d demande à Docker de lancer le conteneur en arrière-plan

#docker ps     pour voire qui tourne