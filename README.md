# JP-Lab
Zadania na laboratoria z języków programowania. Projekty robione pod IntelliJ IDEA

### 17.10.16 / 5,0
Obliczenie liczby płaszczyzn powstałych poprzez przecięcia kół. Dane są środki okręgów i ich promień.

### 14.11.16 / 5,0
Program okienkowy wykonujący zamówienia na dostarczenie pizzy. Użytkownik ma definiować typ pizzy, liczbę sztuk, godzinę dostarczenia i adres docelowy.
Program realizuje dostarczenie zlecenia, na konkretny region przypada dany dostawca.
Program przydziela dostawcy zamówienie, oraz musi rozliczać (spóźnienie = 10% rabatu)
Silnikiem ma być klasa zawierająca bazę aktualnych zamówień
Mają powstawać statystyki dzienne

### 28.11.16 / 3,5
Stwórz grę, w której poruszający się chwytak ma zbierać leżące na dole okna piłeczki. Chwytak ma obracać wokoło punktu, po naciśnięciu przycisku wydłuża się i trafia/nie trafia piłeczkę. Dodatkowo, może być element losowości. Nie wolno używać elementów graficznych, bitmap, itd. Tylko grafika wektorowa. Bazowane na kodzie od Kubika.

### 12.12.16
Napisz wielowątkowy program, w którym na taśmie poruszanej przez wątek, pojawiają się elementy podawane przez wątki. W jednym czasie dostęp do jednego elementu może mieć tylko jeden wątek. 2 wątki mają dodawać elementy do listy, a 4 odbierać. Elementami mają być losowo generowane numery. Taśma ma mieć 7 miejsc na elementy, a każdy wątek konfigurowalny czas. 3 klasy wątków, z parametryzowanym konstruktorem.

	    x   y   y
	    ↓   ↑   ↑
    z → ooooooooo
    z → ooooooooo
        ↑   ↓   ↓
        x   y   y

    z - Napęd taśmy
    x - Wątki dodające
    y - wątki zbierające

### 09.01.17
W projekcie mają powstać 3 aplikacje (3 klasy Main()), jedno gniazdo serwerowe i dwa gniazda klienckie. Centrala ma przechowywać informacje o hoście i porcie bramek, może je zamykać, przesyła informacje o operacjach na bramce do monitora. Monitor tworzy gniazdka kliencie do bramek i sprawdza, ile odób przeszło przez bramkę. Bramka zawiera przycisk oznaczający przejście jednej osoby przez bramkę. Komunikacja ma się odbywać za pomocą socket'a. Przynajmniej dwie bramki w projekcie. Monitor zawiera wątek, sprawdzający liczniki wszystkich bramek. Konstrukcja sieci:
- Centrala - Host, dwa porty
- Bramka - Host, dwa porty
- Monitor - Port
