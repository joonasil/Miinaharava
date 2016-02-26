#Aihemäärittely

**Aihe:** Miinaharava. Klassinen yksin pelattava älypeli, jossa yritetään löytää miinoja ruudukosta. Pelaajalla on mahdollisuus  
valita kolmen eri vaikeusasteen välillä, tallentaa peli ja jatkaa tallennettua peliä. Jos aikaa riittää pelaaja voi myös itse valita
kentän koon ja minojen määrän. Pelaaja on rajaton aika, mutta pelistä otetaan aikaa ja parhaat ajat tallennetaan huipputuloksiin. Pelin
voi tallentaa ja jatkaa pelaamista myöhemmin.

**Käyttäjät:** Pelaaja

**Pelaajan Toiminnot:**  
- Pelaa miinaharavaa
 * Käännä ruutu
 * merkkaa ruutu
 * uusi peli
 * resetoi peli
- Lataa Peli
- Tallenna Peli
- Katso huipputuloksia

#### Luokkakaavio
###### versio 1
![Luokkakaavio](/dokumentointi/luokkakaavio.png)

###### versio 2 (05.02.2016)
![Luokkakaavio versio 2](/dokumentointi/luokkakaavio2.png)

###### versio 3 (12.02.2016)
![Luokkakaavio versio 3](/dokumentointi/luokkakaavio3.png)

#### Sekvenssikaaviot
![Sekvenssikaavio tapahtumasta pelaaja painaa avaamatonta ruutua vasemmalla hiiren painikkeella](/dokumentointi/sekvenssikaavio1.png)

![Sekvenssikaavio tapahtumasta pelaaja painaa avaamatonta ruutua oikealla hiiren painikkeella](/dokumentointi/sekvenssikaavio2.png)

#Rakenne
Ohjelman pääluokka kutsuu staattista luokkaa Minesweeper, joka luo oliot pelin logiikalle: Minefield, graafiselle käyttöliittymälle: GameScreen, asetuksille: GameSettings ja pelikellolle: Timer. Pelin eri osat käyttävät tätä staattista luokkaa kommunikoimiseen esim. käyttöliittymä hakee tietoa pelilogiikalta kutsumalla Minesweeper luokan metodia getBoard() kuten yllä sekvenssikaaviossa on kuvattu.

Pelilogiikan luokka Minefield luo peliruudun listana Square tyyppisiä oloita, jotka sisältävät tiedon ruudusta kuten onko ruutu miina, onko ruutua avattu ja kuinka monta miinaa ruuduissa on. Marker enumia käytetään pitämään kirjaa siitä onko ruutua painettu oikealla hiiren painikkeella.

Käyttöliittymän luokka GameScreen luo vastaavasti listan SquareGui tyyppisiä oliota, jotka vastaavat peliruutujen piirtämisestä ja peliruudun toimintojen hoitamisesta (vasen ja oikea hiiren painallus). GameScreen olion luomisen yhteydessä käytetään ImageLoader luokkaa lataamaan pelin tarvitsemat grafiikat resursseista.
