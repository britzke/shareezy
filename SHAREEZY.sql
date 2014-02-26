INSERT INTO "shareezy"."BENUTZER" (ID, KURZNAME, EMAIL, KENNWORT, VORNAME, NACHNAME, REGISTRATION, HASH) values(1,'musterbenutzer','muster@gmail.com','muster123', 'Max', 'Musterman', '2011-03-17 15:52:25', 'ja was soll hier bitte rein?');
INSERT INTO "shareezy"."TYPEN" values (1,'Test typ Ressource');
INSERT INTO "shareezy"."RESSOURCEN" (ID, NAME, BESCHREIBUNG, EINSTELLUNGSDATUM, ENDDATUM, STARTDATUM, BENUTZER_ID_EIGENTÜMER, TYPEN_ID) values(
		1
	,	'TestRessource'
	,	'Ein CLOB ist also nur ein Text, der sehr lang ist und nur auf einen Speicherplatz und nicht auf eine Anzahl von Zeichen beschränkt ist.'
	,	'2013-05-03'
	,	'2013-05-03'
	,	'2013-12-04'
	,	1
	,	1
);
INSERT INTO "shareezy"."GRUPPEN" values (1, '1234', 'testgruppe', 1);
INSERT INTO "shareezy"."BENUTZERGRUPPEN" values(1, 1, 1); 
INSERT INTO "shareezy"."BUCHUNGEN" values('2014-01-01', '2014-02-02', 1, 1);
INSERT INTO "shareezy"."VERFÜGBARKEITEN" values(1, 1);