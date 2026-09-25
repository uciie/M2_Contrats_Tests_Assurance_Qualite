**Question 2**
> Junit : C'est un framework qui sert à faire des tests unitaires en Java.
>  
> Hamcrest : C'est une bibliothèque de matchers pour des assertions lisibles
> 
> Mockito : Framework de création de doublures, isole les composants testés en simulant le comportement de leurs collaborateurs 
> 
> JaCoCo : Mesure la couverture du code. C'est le seul parmi les 4 à ne pas être une bibliothèque de test.


**Question 3**

- [x] 1- `Gav` : parser une chaîne "group:artifact:version" en ses trois composants
- [ ] 2- `Gav` : lever une exception si la chaîne est mal formée
- [ ] 3- `Artifact` : record { coordonnée Gav, ensemble des Gav dont il dépend directement }
- [ ] 4- `Project` : record { nom, ensemble des Gav des dépendances directes }
- [ ] 5- `BufferedLineReader` (`ILineReader`) : lire un flux ligne à ligne via BufferedReader
- [ ] 6- `InMemoryStorage` (`IStorage`) : put(gav, artifact) / get(gav) -> Optional
- [ ] 7- `StorageBasedRegistry` (`IRegistry`) : publish(artifact), avec refus si coordonnée déjà publiée
- [ ] 8- `StorageBasedRegistry` (`IRegistry`) : lookup(gav) -> Optional<Artifact>
- [ ] 9- `LineBasedPomParser` (`IPomParser`) : parser la ligne "project <nom>"
- [ ] 10- `LineBasedPomParser` : parser les lignes "dependency <gav>"
- [ ] 11- `LineBasedPomParser` : ignorer les lignes vides
- [ ] 12- `LineBasedPomParser` : lever une exception sur une ligne inconnue ou une coordonnée invalide
- [ ] 13- `AllVersionsResolver` (`IResolver`) : calculer la fermeture transitive à partir des dépendances directes, en interrogeant le registre
- [ ] 14- `AllVersionsResolver` : conserver toutes les versions en cas de conflit (pas de résolution)
- [ ] 15- `BuildTool` : enchaîner parse (`IPomParser`) puis resolve (`IResolver`)

**Question 5**
> La chaîne d'entrée "org.acme:lib-a:1.0.0" apparait dans le code et dans le test. Cependant la méthode doit fonctionner pour n'importe quelle chaine de coordonées et non en trichant. Il faut implémenter la logique du parsing.

**Question 7**
> "org.acme:lib-a:1.0.0" et "org.other:lib-c:3.0.0" appartiennent à la même classe car elles sont toutes les deux des chaînes valides.
> En ajoutant un second exemple avec des valeurs différentes mais dans la même classe, on élimine la possibilité de tricher