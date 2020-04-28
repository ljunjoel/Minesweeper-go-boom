# Käyttöohje

Peli tukee tällä hetkellä vain vakio 40x40 -ruutua peliä neljälläkymmenellä pommilla. Kun peli käynnistetään pääsee pelaamaan
painamalla "Play!"-nappia. Tämä generoi pelilaudan automaattisesti ja avaa sen oikean kokoisena.

Peliä pelataan hiirellä. Hiiren ykköspainikkeella avataan ruutuja ja hiiren kakkospainikkeella voidaan "liputtaa" ruutu.
Tällöin kyseinen ruutu on merkitty mahdolliseksi pommiksi. Lippuja on käytössä saman verran kuin pommeja. Liputuksen voi
poistaa kummalla tahansa hiiren painikkeella. Peli voitetaan liputtamalla jokainen pommi. 

Kun ruutuja avataan, paljastuu niiden takaa numeroita. Tämä numero kertoo, kuinka monta pommia on kulmittain kyseisen ruudun
kanssa. Tämä tarkoittaa sitä, että maksimi tälle luvulle on kahdeksan ja minimi on nolla. Mikäli luku on nolla, avaa peli
lisää ruutuja, kunnes se ei enää avaa nolla-ruutua vaan jonkin nollasta poikkeavan arvon omaavan ruudun.

Mikäli osut pommiin, peli päättyy.
