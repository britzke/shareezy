SET SCHEMA SHAREEZY
go

INSERT INTO BENUTZER(KURZNAME, EMAIL, KENNWORTHASH, VORNAME, NACHNAME, REGISTRATION, VALIDATIONHASH)
values('musterbenutzer','muster@gmail.com','cec87c7d4f786fa96f67ef161bad3754', 'Max', 'Musterman', '2011-03-17 15:52:25', 'ja was soll hier bitte rein?');
INSERT INTO TYPEN values (1,'Testtyp Ressource');

INSERT INTO RESSOURCEN (ID, NAME, BESCHREIBUNG, EINSTELLUNGSDATUM, STARTDATUM, ENDDATUM, BENUTZER_ID_EIGENTÜMER, TYPEN_ID)
 values(1, 'Rasenmäher', 'Das ist eine Rasenmäher', '2014-02-25', '2014-02-28', '2014-03-11', 1, 1);

INSERT INTO GRUPPEN values (1, '1234', 'testgruppe', 1);

INSERT INTO BENUTZERGRUPPEN values(1, 1, 1); 
INSERT INTO BUCHUNGEN values('2014-01-01', '2014-02-02', 1, 1);
INSERT INTO VERFÜGBARKEITEN values(1, 1);

select * from GRUPPEN;
select * from BENUTZERGRUPPEN;
select * from BUCHUNGEN;
select * from VERFÜGBARKEITEN;
select * from RESSOURCEN;
select * from TYPEN;
select * from BENUTZER;