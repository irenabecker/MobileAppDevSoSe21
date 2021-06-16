# Mobile Applicatoin Development Semester Projekt Sommersemester 2021

## Datenmodell: Das Datenmodell für Todos soll es erlauben, die folgende Information zu repräsentieren:
- [x] den Namen des Todo
- [x] eine Beschreibung des Todo
- [x] die Information darüber, ob das Todo erledigt wurde oder nicht
- [x] die Information darüber, ob es sich um ein besonders wichtiges / ‘favourite’ Todo handelt oder nicht
- [x] das Fälligkeitsdatum des Todo und eine Uhrzeit
- [x] Alle Informationsbestandteile, inklusive des Namens, sollen nach Erstellung eines Todo änderbar sein.


## Speichern von Todos: Das Speichern von Todos soll sowohl mittels einer externen Webanwendung, als auch mittels eines lokalen Datenspeichers erfolgen. Die Webanwendung wird Ihnen als Java EE Web Application zur Verfügung gestellt, alternativ können Sie Google Firebase nutzen. In diesem Fall beziehen sich alle nachfolgend bezüglich der „Webanwendung“ formulierten Anforderungen auf Firebase.
- [x] Auf dem Endgerät sollen Todos in einer SQLite Datenbank gespeichert werden.
- [x] Wurde eine Schreiboperation auf der lokalen SQLite Datenbank erfolgreich ausgeführt, soll die betreffende Operation auf der Webanwendung aufgerufen werden. Die durch die SQLite Datenbank zugewiesenen IDs können durch die Webanwendung übernommen werden. Bei Verwendung von Firebase kann das Datenmodells z.B. um ein Attribut für die Firebase ID erweitert werden.
- [x] Ist beim Start der Anwendung kein Zugriff auf die Webanwendung möglich, soll eine Warnmeldung ausgegeben werden. In diesem Fall wird bis zum Ende der Anwendungsnutzung nur die lokale Datenbank verwendet.Die Fälle, dass eine initiale Verbindung während der App-Nutzung abbricht bzw.dass eine anfänglich nicht verfügbare Webanwendung während der Nutzung verfügbar wird, brauchen nicht berücksichtigt zu werden.
- [x] Ist die Webanwendung beim Start der Android Anwendung verfügbar, soll der folgende "Abgleich" implementiert werden:
- liegen lokale Todos vor, dann werden alle Todos auf Seiten der Web Applikation gelöscht und die lokalen Todos an die Web Applikation übertragen.
- liegen keine lokalen Todos vor, dann werden alle Todos von der Web Applikation auf die lokale Datenbank übertragen.
- [] Fügen Sie zur Erleichterung der Abnahme der vorherigen Anforderung zwei Aktionen zur nachfolgend beschriebenen Listenansicht hinzu, die das Löschen aller lokalen bzw. auf Seiten der Webanwendung befindlichen Todos erlauben. Fügen Sie außerdem eine Aktion hinzu, die die beschriebene Synchronisierung unabhängig vom Starten der Anwendung auslöst. Die drei Aktionen können Sie z.B. über das Optionsmenü der Listenansicht zugänglich machen.
   
   
## Anmeldung: Die Anmeldung soll durch Eingabe einer Email (s@bht.de) und eines Passworts erfolgen und durch Betätigung eines Login Buttons ausgelöst werden.
- [x] In das Eingabefeld für Email sollen nur Emailadressen eingegeben werden.
- [x] Wird keine Email-Adresse eingegeben, wird eine dauerhaft sichtbare Fehlermeldung ausgegeben (d.h. Toasts oder andere selbst ausblendende Anzeigeelemente sind nicht zulässig).
- [x] Die Fehlermeldung bezüglich der Mailadresse und alle anderen Fehlermeldungen sollen erst nach Abschluss der Eingabe der Adresse, aber unmittelbar nach Abschluss, angezeigt werden, nicht für jede einzelne Tastatureingabe oder erst bei Durchführung der Anmeldung. Die Validierung soll unabhängig von der Validierung der Anmeldedaten bzw. der Durchführung des Logins (siehe unten) erfolgen.
- [x] Wird die Eingabe des Email Feldes geändert, verschwindet die Fehlermeldung unmittelbar bei Eingabe/Löschen eines Zeichens.
- [x] Passwörter sollen numerisch und genau 6 Ziffern lang sein. 
- [x] Die Eingabe soll verschleiert (‘ausgepunktet’) werden. 
- [x] Die Betätigung des Login Buttons soll nur möglich sein, wenn Werte für Email und Passwort eingegeben wurden.
- [x] Nach Betätigung des Login Buttons sollen die eingegebenen Werte an die Webanwendung bzw. Firebase übermittelt und dort überprüft werden.
- [x] Die Überprüfung soll asynchron erfolgen.
-  Solange die Überprüfung läuft, soll ein ProgressDialog oder ein anderes vergleichbares Anzeigeelement eingeblendet werden. Fügen Sie zur besseren Überprüfbarkeit bei der Abnahme außerdem eine Verzögerung von 2s hinzu.
- [x] Schlägt die Überprüfung fehl, wird eine dauerhaft sichtbare Fehlermeldung ausgegeben.
- [x] Wird eines der beiden Felder geändert, verschwindet die Fehlermeldung unmittelbar bei Eingabe/Löschen eines Zeichens.
- [x] Bei erfolgreicher Überprüfung der eingegebenen Werte soll die Anzeige der Todos erfolgen.
- [x] Besteht beim Start der Android-Anwendung keine Verbindung zur Webanwendung, wird sofort die Todoliste angezeigt. Eine lokale Anmeldung ist nicht erforderlich. (Anm.: die Vergabe von Punkten für diese Anforderung erfolgt nur, wenn die Anmeldung unter Verwendung der Webanwendung grundsätzlich umgesetzt ist.)


## Todoliste: Die Anzeige der Todoliste soll eine Übersicht über alle Todos darstellen und die Erstellung neuer Todos ermöglichen.
- [x] Sie soll für jedes Todo die folgende Information darstellen:
- den Namen
- das Fälligkeitsdatum
- das Erledigsein/Nicht-Erledigtsein
- die Wichtigkeit
- [x] Sie soll es dem Nutzer außerdem ermöglichen, sich für jedes Todo dessen Details anzeigen zu lassen.
- [x] Änderungen der Todoliste, die in der Detailansicht eines Todos getätigt werden können, sollen bei Rückkehr in der Übersicht angezeigt werden.
- [x] Die Information zum Erledigtsein/Nicht-Erledigtsein bzw. zur Wichtigkeit soll modifiziert werden können, ohne die Detailanzeige anzufordern.
- [x] Todos sollen immer nach Erledigt/Nichterledigt sortiert sein und wahlweise nach Wichtigkeit+Datum oder nach Datum+Wichtigkeit (d.h. es gibt insgesamt genau 2 Sortieralternativen). Nicht erledigte Todos sollen vor erledigten Todos angezeigt werden.
- [x] Dem Nutzer soll es möglich sein, die Anzeige nach Datum+Wichtigkeit vs. Wichtigkeit+Datum über ein Optionsmenü bzw. Action Bar Optionen auszuwählen.
- [x] Erledigte Todos sollen am Ende der Liste angezeigt werden. Falls der Sortiermodus Wichtigkeit+Datum gewählt ist, sollen wichtige Todos am Beginn der Liste dargestellt werden.
- [x] Neu erstellte Todos sollen nach Erstellung entsprechend dem gewählten Sortiermodus eingefügt werden, bei Aktualisierungen eines bestehenden Todo soll ebenfalls unmittelbar eine Neusortierung erfolgen.
- [x] Überfällige Todos – d.h. Todos mit abgelaufenem Fälligkeitsdatum – sollen visuell besonders hervorgehoben werden.
   
   
## Detailansicht: Die Detailansicht soll alle durch ein Todo repräsentierten Daten darstellen.
- [x] Sie soll außerdem die Änderung zumindest der folgenden Daten eines Todo ermöglichen:
   - Name
   - Beschreibung
   - Fälligkeitsdatum und Uhrzeit
   - Erledigtsein
- [x] Für die Einstellung von Datum und Uhrzeit sollen die für diesen Zweck durch Android bereitgestellten UI Bedienelemente verwendet werden.
- [x] Beim Öffnen der Bedienelemente für Datum und Uhrzeit sollen für existierende Todos die jeweils zugewiesenen Werte, für neue Todos der aktuelle Zeitpunkt angezeigt werden.
- [x] Das Löschen eines Todos soll ebenfalls über die Detailansicht ermöglicht und vor Durchführung rückbestätigt werden.
   
   
## Verknüpfung mit Kontakten: Erlauben Sie auf Ebene des Datenmodells die Assoziation eines Todo mit einer Menge von Kontakten. Nutzen Sie hierfür die IDs der Kontakte.
- [x] Erlauben Sie dem Nutzer, auf Ebene der Detailansicht Todos optional mit einer Liste von Kontakten zu verknüpfen.
- [x] Die Auswahl der Kontakte soll auf Grundlage einer Darstellung aller verfügbaren Kontakte erfolgen.
- [x] Zeigen Sie die Namen der verknüpften Kontakte in der Detailansicht für Todos an.
- [x] Ermöglichen Sie das Entfernen von Kontakten aus der Liste der verknüpften Kontakte eines Todo.
- [x] Ermöglichen Sie außerdem, dass dem Nutzer für jeden Kontakt die Möglichkeit der Kontaktaufnahme per Mail und SMS gegeben wird, falls eine Mailadresse bzw. Mobilfunknummer vorhanden sind.
- [x] Bei Kontaktaufnahme sollen die Mailadresse/Mobilfunknummer, der Titel und die Beschreibung des Todos der jeweils verwendeten Android App übermittelt werden.