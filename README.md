
# Rapport

Mycket tid och problem har gått åt genom att det blivit fel som verkat ligga lokalt i mina 
inställningar. Tillslut installerade jag om hela android studio för att se om problemen löstes.
Men då fick jag andra problem så som att gradlebuild inte fungerade, javafiler visades inte och kotlinfiler
i build fanns och när jag forkade prjektet så forkades projektet utan javafiler. Det var rätt mkt konsitga fel.

Så tillslut bestämde jag mig att jag gör ett nytt försök och testar att göra ett helt nytt projekt
med koden från https://github.com/LenaSYS/mobileapp-programming-networking användes för att ändå lösa 
uppgiften men i ett eget projekt. 

Först skapades en recycler view i `activity_main.xml` för att hämta in data från en json url. 
Därefter lades ytterligare en xml fil till med namnet itemrow.xml för att lista alla berg. 

Därefter skapades två javafiler, `JsonTask.java` och `JsonFile.java`. Jag valde dock att använda 
JsonTask och köra via url. 


Sedan skapades `Mountains.java` där valdes att bergens namn skulle inhämtas som variabel. Detta gjordes
med getter och setter. 

Därefter skapades `RecyclerViewItem.java`. I denna fil lades kod till för att hämta namnen på bergen 
till recycler view. 

I manifestet lades kod till för åtkomst till internet: 
```
<uses-permission android:name="android.permission.INTERNET" />

```

Efter det skapades `RecyclerViewAdapter.java` här inne skapades även en holder. 
Även arraylist Mountains skapades i `MainActivity.java` med variabeln mountains.


![](![Screenshot_20230819_194504.png](Screenshot_20230819_194504.png)