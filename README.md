# 3b) heiskontroll
## Java Maven Project
### Helene H. Harmens 14.01.20

[LINK TO QUICK ELEVATOR SYSTEM UML](http://yuml.me/preview/df5718ca)

## Kvaliteter heissystemet må ta hensyn til:

Heisen trenger grunnleggende funksjoner som å bevege seg opp og ned, stoppe, åpne og lukke dører, og plukke opp passasjerer. Heisene må kunne operere automatisk og uavhengig, men samtidig bli styrt gjennom Heissystemet.

## Problemstillinger heissystemet må ta hensyn til:

Heisene må kunne ta imot nye forespørsler fra knappe-panelet på innsiden av hver heis, samt knappe-panelet på utsiden i hver etasje på en smart måte. 

## Mangler/gjenstår i koden:
* Gjøre mer modul-basert
* Flere klasser: Button, Door, Lights, ControlPanel (vise heissystem-status)...
* Controller-klasser: ElevatorController, ElevatorSystemController, ButtonController, DoorController, LightController
* Variabel for høyeste etasje (og en sjekk for dette)
* Åpne/lukke-dører
* Mulighet for å oppdatere ‘destinationFloors’ ettersom det kommer forespørsler innenfor og utenfor.
* Metode for å vise om heisen er på vei opp eller ned (Lights/Indicator)
* Heis går tilbake til ‘defaultFloor’ etter inaktivitet
* Hurtighet for heis mellom etasjene, med mulighet til å kjøre raskere/saktere (?)
* Fokus på sikkerhet
* Metode for å finne ledig heis
* ...

