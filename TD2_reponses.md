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
- [x] 2- `Gav` : lever une exception si la chaîne est mal formée (null, vide, ne contient pas exactement trois segments non vides séparés par ':', ou contient des segments composés que d'espace)
- [x] 3- `Artifact` : record { coordonnée Gav, ensemble des Gav dont il dépend directement }
- [ ] 4- `Project` : record { nom, ensemble des Gav des dépendances directes }
- [ ] 5- `BufferedLineReader` (`ILineReader`) : lire un flux ligne à ligne via BufferedReader
- [x] 6- `InMemoryStorage` (`IStorage`) : put(gav, artifact) / get(gav) -> Optional
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

**Question 9**
||Classe d'équivalence invalide| Exemple|
|-|-|-|
|1| Chaîne null| null|
|2| Chaîne vide| ""|
|3| Pas assez de segments (aucun `:`)| "org.acme"|
|4| Pas assez de segments (un seul `:`)| "org.acme:lib-a"|
|5| Trop de segments (plus de deux `:`)| "org.acme:lib-a:1.0.0:extra"|
|6| Un segment vide (groupe, artefact ou version)| "org.acme::1.0.0", ":lib-a:1.0.0", "org.acme:lib-a:"|
|7| Chaîne composée uniquement d'espaces |" "|
|8| Un segment non vide mais uniquement composé d'espaces |" : : ", "org.acme:  :1.0.0"|

**Question 11**
> Ici, `BufferedLineReader` n'a aucune logique propre : c'est une simple délégation vers une classe déja approuvée.
> 
> TDD : il est surtout utile là où il y a une incertitude sur le comportement à spécifier.

**Question 12**
> demo_fail_assertEquals()
```
org.opentest4j.AssertionFailedError: The group should be org.acme ==> expected: <com.example> but was: <org.acme>
	at app//org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:151)
	at app//org.junit.jupiter.api.AssertionFailureBuilder.buildAndThrow(AssertionFailureBuilder.java:132)
	at app//org.junit.jupiter.api.AssertEquals.failNotEqual(AssertEquals.java:197)
	at app//org.junit.jupiter.api.AssertEquals.assertEquals(AssertEquals.java:182)
	at app//org.junit.jupiter.api.Assertions.assertEquals(Assertions.java:1156)
	at app//org.example.GavTest.demo_fail_assertEquals(GavTest.java:58)
	at java.base@21.0.12.1/java.lang.reflect.Method.invoke(Method.java:580)
	at java.base@21.0.12.1/java.util.ArrayList.forEach(ArrayList.java:1596)
	at java.base@21.0.12.1/java.util.ArrayList.forEach(ArrayList.java:1596)
```
> demo_fail_assertThat()
```
java.lang.AssertionError: The group should be org.acme
Expected: is "com.example"
     but: was "org.acme"
	at org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)
	at org.example.GavTest.demo_fail_assertThat(GavTest.java:69)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
```
> La structure des deux message est similaire. On sait ce qu'on devait attendre en sortie et ce qu'on mit en entrée.