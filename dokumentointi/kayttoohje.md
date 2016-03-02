# Käyttöohjeet
Pelin tarkoituksena on avata ruutuja pelilaudalla ja löytää kaikki miinat käyttäen apuna ruuduista paljastuvia numeroita. Pelin voittaa
avaamalla kaikki ruudut, joissa ei ole miinaa. 

#### Kontrollit
- hiiren vasen painike: avaa painetun ruudun seuraavalla tavalla:
  - Jos ruudun ympärillä ei ole miinoja, avautuu kaikki ruutuun liittyvät tyhjät ruudut ja niiden viereiset numero ruudut.
  - Jos avatun ruudun ympärillä on yksi tai useampi miina, avautuu vain kyseinen ruutu.
  - Jos avattu ruutu on miina, peli päättyy.
  - Ensimmäinen avattu ruutu ei voi olla miina.
- hiiren oikea painike: merkitsee tyhjän avaamattoman ruudun lipuksi tai lipun kysymysmerkiksi. 
  - Lipulla pelaaja voi merkitä, että kyseinen ruutu on miina ja näin ollen jäljellä olevien miinojen määrä vähentyy. 
  - Kysymysmerkiksi merkityt ruudut eivät vähennä jäljellä olevien miinojen määrää, eli pelaaja voi merkitä ruutuja, 
  joista ei ole varma onko kyseinen ruutu miina vai ei. 
  - Jos ruutu on merkattu lipuksi tai kysymysmerkiksi ei sitä voida avata hiiren vasemmalla painikkeella, vaan täytyy merkintä ensin poistaa, mikä tapahtuu painamalla
kysymysmerkkiä hiiren oikealla painikkeella.

#### Valikot
Valikkoja käytetään vasemmalla hiiren painikkeella.
- Game
  - New Game: Aloittaa uuden pelin valitulla vaikeusasteella.
  - Quit Game: Sammuttaa sovelluksen.
- Difficulty
  - Easy: Asettaa pelin vaikeusasteeksi helpon vaikeusasteen. 9x9 ruudukko 10 miinalla.
  - Medium: Asettaa pelin vaikeusasteeksi keskiverron vaikeusasteen. 16x16 ruudukko 40 miinalla.
  - Hard: Asettaa pelin vaikeusasteeksi vaikean vaikeusasteen. 30x16 ruudukko 99 miinalla.
- High Scores
  - Easy: Avaa helpon vaikeusasteen huipputulokset
  - Medium: Avaa keskivaikean vaikeusasteen huipputulokset
  - Hard: Avaa vaikean vaikeusasteen huipputulokset
