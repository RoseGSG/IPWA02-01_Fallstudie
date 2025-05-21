## Voraussetzungen

- Java 8+ (je nach Projektsetup)
- Maven oder Gradle (je nach Build-System)
- MySQL Server (lokal oder remote)
- MySQL Workbench (optional, zur Datenbankverwaltung)
- Ein moderner Browser (Chrome, Firefox, Edge)

---

## Einrichtung der MySQL-Datenbank

### 1. MySQL installieren und starten

Falls noch nicht geschehen, installiere MySQL auf deinem System und stelle sicher, dass der Server läuft.

### 2. Datenbank anlegen

Öffne ein Terminal oder die MySQL Workbench und lege eine neue Datenbank an, z. B.:

```sql
CREATE DATABASE require4testing;
3. Datenbankstruktur und Beispiel-Daten importieren
Importiere die mitgelieferte Datei IPWA02-01_Fallstudie_Datenbankstruktur_inkl_Beispieldaten.sql, die alle Tabellen und einige Beispiel-Datensätze enthält.

Über das Terminal:

bash
Code kopieren
mysql -u dein_benutzername -p reuqire4testing < IPWA02-01_Fallstudie_Datenbankstruktur_inkl_Beispieldaten.sql
Oder mit MySQL Workbench:

Gehe zu Server → Data Import.

Wähle Import from Self-Contained File und wähle IPWA02-01_Fallstudie_Datenbankstruktur_inkl_Beispieldaten.sql.

Wähle als Ziel-Datenbank require4testing.

Starte den Import.

4. Datenbankverbindung konfigurieren
Passe die Datenbank-Verbindungsdaten in deiner Anwendung an (z. B. in der Datei persistence.xml, application.properties oder einer anderen Konfigurationsdatei):

properties
Code kopieren
jdbc.url=jdbc:mysql://localhost:3306/require4testing
jdbc.username=dein_benutzername
jdbc.password=dein_passwort
Anwendung starten
Baue und starte die Webanwendung mit deinem bevorzugten Build-Tool (Maven, Gradle oder IDE).
Die Anwendung ist dann unter http://localhost:8080 (oder entsprechend konfiguriert) erreichbar.

Git Best Practices
Die Datei IPWA02-01_Fallstudie_Datenbankstruktur_inkl_Beispieldaten.sql enthält nur Struktur und Beispiel-Daten, keine produktiven Nutzerdaten.

Vermeide das Speichern von sensiblen Zugangsdaten in Git.

Kontakt / Support
Bei Fragen oder Problemen melde dich bitte bei:
Sarah Mußemann
E-Mail: sarah.mussemann@iu-study.org
