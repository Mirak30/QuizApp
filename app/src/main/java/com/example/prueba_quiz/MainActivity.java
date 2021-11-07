package com.example.prueba_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.prueba_quiz.db.DbHelper;
import com.example.prueba_quiz.db.DbImageQuestion;
import com.example.prueba_quiz.db.DbTextQuestion;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<TextQuestions> listArrayQuestions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        listArrayQuestions = new ArrayList<>();

        try {
            DbTextQuestion db = new DbTextQuestion(this);

            db.insertEasyQuestionAnime("¿Cuál es el apellido de Edward en 'Fullmetal Alchemist'?", "Elmac",
                    "Elrond", "Elric", "Edmod", "Elric");
            db.insertEasyQuestionAnime("¿Cuál es el EVA que pilota Shinji en 'Neon Genesis Evangelion'?", "Unidad 02",
                    "Unidad 01", "Unidad 00", "Unidad 03", "Unidad 01");
            db.insertEasyQuestionAnime("¿Qué busca Inuyasha?", "Una espada", "Una persona", "Un libro",
                    "Una joya", "Una joya");
            db.insertEasyQuestionAnime("¿Cuál es el verdadero nombre de Kira en 'Death Note'?", "Light Yagami",
                    "Ryuk Yagami", "L", "N", "Light Yagami");
            db.insertEasyQuestionAnime("¿Cuál es el nombre japonés de Ash Ketchum?", "Yuji",
                    "Shinji", "Satoshi", "Yuki", "Satoshi");
            db.insertEasyQuestionAnime("¿Cuál es el apellido de Sakura en 'Sakura Card Captor'?", "Kinomoto",
                    "Sakamoto", "Lee", "Daidouji", "Kinomoto");
            db.insertEasyQuestionAnime("¿Cuál de estos no es un villano de 'Dragon Ball Z'?", "Cell",
                    "Krilin", "Freezer", "Majin Buu", "Krilin");
            db.insertEasyQuestionAnime("¿Cómo se llama el familiar de Rin de 'Ao no Exorcist'?", "Shiro",
                    "Black", "Kuro", "Leo", "Kuro");
            db.insertEasyQuestionAnime("¿Cómo se llama el dios del mundo de 'No game no Life'?", "Tet",
                    "Shiro", "Sora", "Stephanie", "Tet");
            db.insertEasyQuestionAnime("¿Cuánto tiempo pasa desde la muerte de Menma hasta su regreso?", "5 años",
                    "10 años", "11 años", "8 años", "10 años");

            db.insertDifficultQuestionAnime("¿Qué 'Akuma no mi' no existe en el mundo de 'One Piece'?", "Lolo Lolo no mi",
                    "Ato Ato no mi", "Buki Buki no mi", "Horu Horu no mi", "Lolo Lolo no mi");
            db.insertDifficultQuestionAnime("¿De qué raza es Shiki Natsumezaka de 'Dance with Devils'?", "Ángel Caído",
                    "Demonio", "Vampiro", "Exorcista", "Ángel Caído");
            db.insertDifficultQuestionAnime("En 'Hunter X Hunter', ¿cómo se llama el juego donde Meruem no consigue vencer a Komugi?",
                    "Go", "MahHong", "Shogi", "Gungi", "Gungi");
            db.insertDifficultQuestionAnime("De 'Mirai Nikki',¿quién es el primer Dueño de Diario en morir?", "La sexta, Tusbaki Kasugano",
                    "El undécimo, John Balks", "El tercero, Takao Hiyama", "La octava, Kamado Ueshita", "El tercero, Takao Hiyama");
            db.insertDifficultQuestionAnime("¿Cuántas transformaciones tiene Lagann de 'Tengen Toppa Gurren-Lagann'?", "7",
                    "3", "5", "8", "7");
            db.insertDifficultQuestionAnime("¿De cuántas formas distintas puede poner la cara Koro-sensei de 'Assassination Classroom'?",
                    "10", "9", "8", "6", "9");
            db.insertDifficultQuestionAnime("¿Qué clase de Diosa es Kofuku de 'Noragami'?", "Diosa de la Guerra",
                    "Diosa de la fortuna", "Diosa de la calamidad", "Diosa de la pobreza", "Diosa de la pobreza");
            db.insertDifficultQuestionAnime("En 'Death Parade', ¿por qué razón llegó Chiyuki a Quindecim?", "Tuvo un accidente",
                    "Se suicido", "En una operación", "En un incendio", "Se suicido");
            db.insertDifficultQuestionAnime("¿Cuántos Djinn tiene Sinbad de 'Magi'?", "8",
                    "7", "6", "9", "7");
            db.insertDifficultQuestionAnime("En 'Fairy Tail', ¿qué era Acnologia antes de ser un Dragón?", "Humano",
                    "Dragón", "Demonio", "Espíritu Celestial", "Humano");

            db.insertEasyQuestionCine("¿Cómo se llamaba el coche emblemático de 'Los Cazafantasmas'?", "Turbo-Buster 2000",
                    "Ecto-1", "No tiene nombre", "Cadillac 2000", "Ecto-1");
            db.insertEasyQuestionCine("¿A qué década viaja Marty McFly en 'Regreso al Futuro' la primera parte?", "Los 60",
                    "Los años 20", "Los 50", "Los 70", "Los 50");
            db.insertEasyQuestionCine("¿Cómo se llamaba el gato de 'Alien y el octavo pasajero'?", "Jonesy",
                    "Mause", "Mike", "minino", "Jonesy");
            db.insertEasyQuestionCine("¿De quién era la piedra Filosafal en 'Harry Potter'?", "Albus Dumbledore",
                    "Hagrid Rubius", "Harry Potter", "Nicolas Flamel", "Nicolas Flamel");
            db.insertEasyQuestionCine("¿Cuántos Oscars consiguió 'Titanic'?", "9",
                    "7", "11", "5", "11");
            db.insertEasyQuestionCine("¿En qué año se estreno 'Matrix'?", "1999",
                    "1997", "1996", "2002", "1999");
            db.insertEasyQuestionCine("¿Cuál es idioma original de 'El viaje de Chijiro'?", "Chino",
                    "Coreano", "Japonés", "Inglés", "Japonés");
            db.insertEasyQuestionCine("¿Quién protagonizó El Zorro?", "Mario Casas",
                    "Javier Bardem", "Ryan Reynolds", "Antonio Banderas", "Antonio Banderas");
            db.insertEasyQuestionCine("¿En qué años se estrenó 'Psicosis'?", "1950",
                    "1960", "1970", "1980", "1960");
            db.insertEasyQuestionCine("¿En qué año se estreño 'Harry Potter'?", "2001",
                    "2003", "2005", "2002", "2001");

            db.insertDifficultQuestionCine("Quién fue Gandalf en 'El Señor de los anillos'?", "Ian Mckellen",
                    "Alijah Wood", "Viggo Mortensen", "Mel Gibson", "Ian Mckellen");
            db.insertDifficultQuestionCine("¿Qué actor intepretó a IT?", "Alexander Skarsgård",
                    "Bill Skarsgård", "Gustaf Skarsgård", "Lars Skarsgård", "Bill Skarsgård");
            db.insertDifficultQuestionCine("¿Quién protagoniza La Semilla del diablo?", "Diane Keaton",
                    "Jane Fonda", "Mia Farrow", "Charlotte Rampling", "Mia Farrow");
            db.insertDifficultQuestionCine("¿Cuántas películas hay de Indiana Jones?", "3",
                    "4", "2", "5", "4");
            db.insertDifficultQuestionCine("¿Quién dirigió El Gran Lebowski?", "Hermanos Coen",
                    "Steven Spielberg", "George Lucas", "Sean Penn", "Hermanos Coen");
            db.insertDifficultQuestionCine("¿En qué año se estrenó Bailando con Lobos??", "1985",
                    "1987", "1996", "1990", "1990");
            db.insertDifficultQuestionCine("¿Quién dirigió el Sexto Sentido?", "Alfred Hitchcock",
                    "M. Night Shyamalan", "Darren Aronofski", "Tobe Hooper", "M. Night Shyamalan");
            db.insertDifficultQuestionCine("¿Cuántos oscars consiguió Braveheart?", "5",
                    "1", "10", "6", "5");
            db.insertDifficultQuestionCine("¿Quién protagoniza 'El Silencio de los corderos'?", "Jodie Foster",
                    "Nicole Kidman", "Carrie-Anne Moss", "Halle Berry", "Jodie Foster");
            db.insertDifficultQuestionCine("¿Quién dirigió Salvar al soldado Ryan?", "Martin Scorsese",
                    "George Lucas", "Stanley Kubrick", "Steven Spielberg", "Steven Spielberg");

            db.insertEasyQuestionHistory("¿En qué año se descubrió América?", "1942", "1492", "1592",
                    "1842", "1492");
            db.insertEasyQuestionHistory("¿En qué año empezó la Segunda Guerra?", "1917", "1945", "1939",
                    "1942", "1939");
            db.insertEasyQuestionHistory("¿Qué países se enfrantaron en la Guerra de los Cien Años?", "Francia y España",
                    "Francia e Italia", "Francia e Inglaterra", "Inglaterra e Italia", "Francia e Inglaterra");
            db.insertEasyQuestionHistory("¿En qué país comenzó la Revolución Industrial?", "Alemania", "Gran Bretaña",
                    "Francia", "India", "Gran Bretaña");
            db.insertEasyQuestionHistory("¿Cuál es el 'Siglo de las luces'?", "Siglo XIX", "Siglo XVIII",
                    "Siglo XV", "Siglo XX", "Siglo XVIII");
            db.insertEasyQuestionHistory("El periódo de tiempo en el que los humanos eran nómades, cazadores y recolectores.",
                    "Cretácico", "Neolítico", "Paleolítico", "Triásico", "Paleolítico");
            db.insertEasyQuestionHistory("¿Quién sucedió a Carlos I como rey de España?", "Carlos II", "Felipe II",
                    "Felipe I", "Carlos I", "Felipe II");
            db.insertEasyQuestionHistory("¿En qué años acabó la Primera Guerra Mundial?", "1918", "1914", "1910",
                    "1920", "1918");
            db.insertEasyQuestionHistory("¿Quién fue el primer emperador romano?", "César Augusto", "Julio César",
                    "Nerón", "Calígula", "César Augusto");
            db.insertEasyQuestionHistory("¿En qué año fue el ataque a las Torres Gemelas de Nueva York?", "2000", "2004",
                    "2001", "2002", "2001");

            db.insertDifficultQuestionHistory("¿Qué países se enfrentaron en la batalla de Lepanto?", "Francia e Inglaterra",
                    "Inglaterra y Turquía", "España y Turquía", "Francia y Tuquía", "España y Turquía");
            db.insertDifficultQuestionHistory("¿En qué año se derribó el Muro de Berlín?", "1984",
                    "1989", "1991", "1996", "1989");
            db.insertDifficultQuestionHistory("Lutero fue uno de los grandes precursores del Protestabtismo. ¿Cuál era su nacionalidad?",
                    "Estadounidense", "Española", "Italiana", "Alemana", "Alemana");
            db.insertDifficultQuestionHistory("La escritura más antigua conocida la inventaron:", "Los Griegos",
                    "Los Dorios", "Los Sumerios", "Los Hebreos", "Los Sumerios");
            db.insertDifficultQuestionHistory("¿En qué época los humanos comenzaron el sedentarismo y la agricultura?",
                    "Edad agropecuaria", "Edad antigua", "Neolítico", "Paleolítico", "Neolítico");
            db.insertDifficultQuestionHistory("El inicio de la Historia está marcado,¿por qué descubrimiento?", "El telégrafo",
                    "La rueda", "El fuego", "La escritura", "La escritura");
            db.insertDifficultQuestionHistory("Los creadores de la ciudadela Machu Picchu fueron:", "Los Mayas",
                    "Los Incas", "Los Aztecas", "Los Quimbayas", "Los Incas");
            db.insertDifficultQuestionHistory("Nombre del convenio que en 1839 de dió fin de la Primera Guerra Carlista",
                    "Convenio de Zamora", "Acuerdo de Toledo", "Abrazo de Vergara", "Paz de los Pirineos",
                    "Abrazo de Vergara");
            db.insertDifficultQuestionHistory("Isabel II ascendió al trono de España en 1833.¿Cuántos años tenía la reina?",
                    "35", "17", "2", "10", "2");
            db.insertDifficultQuestionHistory("¿De qué especie de Australopithecus era Lucy?", "Afarensis",
                    "Africanus", "Anamensis", "Bahrelghazali", "Afarensis");

            db.insertEasyQuestionVideogames("¿Cómo se llama la protagonista de la saga 'Tomb Raider'?", "Jill Valentine",
                    "Samus Aran", "Lara Croft", "Aloy", "Lara Croft");
            db.insertEasyQuestionVideogames("¿Con qué nombre se conoció a Mario Bros por primera vez?", "Plumber Man",
                    "Mario", "Jumpman", "Hero", "Jumpman");
            db.insertEasyQuestionVideogames("¿Quiénes crearon el famoso videojuego Tetris?", "Los americanos",
                    "Los chinos", "Los japoneses", "Los soviéticos", "Los soviéticos");
            db.insertEasyQuestionVideogames("¿Cuál es considerado el personaje más famoso de la historia de los videojuegos?",
                    "Sonic el erizo", "Pac-Man", "Mario Bros", "Megaman", "Mario Bros");
            db.insertEasyQuestionVideogames("¿A qué se le denomina 'lag' en un videojuego?", "Conexión baja",
                    "Bajadas de FPS", "Baja carga gráfica", "Caerse del servidor", "Conexión baja");
            db.insertEasyQuestionVideogames("¿Cuál es considerado por la mayoría como el peor juego creado?",
                    "Curiosity: What's inside the cube?", "Superman 64", "Link: The faces of evil",
                    "E.T. El extraterrestre", "E.T. El extraterrestre");
            db.insertEasyQuestionVideogames("¿Cuál es la serie de títulos de lucha que recoge a más personajes de compañias distintas?",
                    "Serie Super Smash Bros", "Serie Jump", "Serie Capcom vs", "Playstation All Stars Battle Royale",
                    "Serie Super Smash Bros");
            db.insertEasyQuestionVideogames("¿Cómo se llama el hermano de Mario Bros?", "Luigi",
                    "Mario Jr.", "Honguito", "Luis", "Luigi");
            db.insertEasyQuestionVideogames("¿Cuántas entradas para mandos tiene Nintendo 64?", "2",
                    "1", "4", "6", "4");
            db.insertEasyQuestionVideogames("¿Cuál es un vidojuego de autos de carrera?", "R-Type",
                    "Snake", "Frogger", "Top Gear", "Top Gear");

            db.insertDifficultQuestionVideogames("¿Qué edición de Final Fantasy se lanzó en PSX(Play Station 1) primero?", "Final Fantasy VI",
                    "Final Fantasy VII", "Final Fantasy VIII", "Final Fantasy V", "Final Fantasy VII");
            db.insertDifficultQuestionVideogames("¿Cuál es la primera videoconsola doméstica de la historia?", "Atari 2600",
                    "Atari Jaguar", "Magnavox Odyssey", "Colecovision", "Magnavox Odyssey");
            db.insertDifficultQuestionVideogames("¿Cuál es el juego que más se espera y que se dice que nunca saldrá?",
                    "Duke Nukem Forever", "Death Stranding", "El MMORPG de Pokemon", "Half life 3",
                    "Half life 3");
            db.insertDifficultQuestionVideogames("¿Cuantos luchadores hay en el 'Street Fighter II'?", "12",
                    "8", "4", "16", "12");
            db.insertDifficultQuestionVideogames("¿Cuál fue la última consola de SEGA?", "Sega Saturn",
                    "Dreamcast", "Sega Master System", "Sega CD Ultimate", "Dreamcast");
            db.insertDifficultQuestionVideogames("¿Cómo se llama el hijo adoptado de Heihachi de 'Tekken'?", "Liuhachi",
                    "Kazuya", "Kasumi", "Lars", "Kazuya");
            db.insertDifficultQuestionVideogames("¿De qué personaje busca venganza Kratos en 'God of War'?", "Atenea",
                    "Zeus", "Ares", "Poseidon", "Ares");
            db.insertDifficultQuestionVideogames("¿Cómo se llama la institución mental del videojuego Outlast?", "Hospital Severalls",
                    "Hospital de Filadelfia", "Mount Massive", "Hospital Whittingham", "Mount Massive");
            db.insertDifficultQuestionVideogames("¿Cómo se llama el protagonista de Halo?", "Jefe Maestro",
                    "John", "Comandante Total", "Soldado Maestro", "Jefe Maestro");
            db.insertDifficultQuestionVideogames("¿En que año fue lanzado Super Mario 64?", "1995",
                    "1996", "1998", "1999", "1996");


            DbImageQuestion dbIm = new DbImageQuestion(this);

            dbIm.insertQuestionEVideogamesImg("¿A qué saga de videojuegos pertenece este personaje?","Call of Duty","Dead Space","Halo","Destiny",
                    "Halo",R.drawable.vidfacil1);

            dbIm.insertQuestionEVideogamesImg("¿A qué saga de videojuegos pertenece este personaje?","Borderlands","GTA","Bioshock","Half-Life",
                    "Bioshock",R.drawable.vidfacil2);

            dbIm.insertQuestionEVideogamesImg("¿A qué saga de videojuegos pertenece este personaje?","Mass Effect","The Witcher","Cooking Mama","Final Fantasy",
                    "Final Fantasy",R.drawable.vidfacil4);

            dbIm.insertQuestionEVideogamesImg("¿A qué saga de videojuegos pertenece este personaje?","The Legend of Zelda","Final Fantasy","Dragon Age","Dragon Quest",
                    "The Legend of Zelda",R.drawable.vidfacil3);


            dbIm.insertQuestionDVideogamesImg("¿A qué saga de videojuegos pertenece este personaje?","Hitman","Max Payne","Deus Ex","Metal Gear",
                    "Deus Ex",R.drawable.viddif1);

            dbIm.insertQuestionDVideogamesImg("¿A qué saga de videojuegos pertenece este personaje?","Gears of War","Killzone","Wolfenstein","Battlefield",
                    "Gears of War",R.drawable.viddif2);

            dbIm.insertQuestionDVideogamesImg("¿A qué saga de videojuegos pertenece este personaje?","Crysis","Deus Ex","The Last of Us","Max Payne",
                    "Max Payne",R.drawable.viddif3);

            dbIm.insertQuestionDVideogamesImg("¿A qué saga de videojuegos pertenece este personaje?","Call of Duty","Dead Space","Halo","Titanfall",
                    "Dead Space",R.drawable.viddif4);



            dbIm.insertQuestionEAnimeImg("¿A qué serie de anime pertenece este personaje?","Fairy Tail","One Piece","Another","Jojo's Bizarre Adventure",
                    "One Piece",R.drawable.animefacil1);
            dbIm.insertQuestionEAnimeImg("¿A qué serie de anime pertenece este personaje?","Full Metal Alchemist","One Punch","Soul Eater","Sankarea",
                    "Full Metal Alchemist",R.drawable.animefacil2);
            dbIm.insertQuestionEAnimeImg("¿A qué serie de anime pertenece este personaje?","Naruto","Ao no Exorcist","Sankarea","Dragon Ball",
                    "Dragon Ball",R.drawable.animefacil3);
            dbIm.insertQuestionEAnimeImg("¿A qué serie de anime pertenece este personaje?","Dragon Ball","Jojo's Bizarre Adventure","Deadman Wonderland","Akame ga kill",
                    "Jojo's Bizarre Adventure",R.drawable.animefacil4);


            dbIm.insertQuestionDAnimeImg("¿A qué serie de anime pertenece este personaje?","Elfen Lied","Rokka no Yushaa","Death Note","Naruto",
                    "Rokka no Yushaa",R.drawable.animedif1);
            dbIm.insertQuestionDAnimeImg("¿A qué serie de anime pertenece este personaje?","One Piece","Ansatsu Kyoushitsu","Tasogare Otome x Amnesia","Omamori Himari",
                    "Tasogare Otome x Amnesia",R.drawable.animedif2);
            dbIm.insertQuestionDAnimeImg("¿A qué serie de anime pertenece este personaje?","Elfen Lied","Helsing","Highschool of the Dead","One Piece",
                    "Elfen Lied",R.drawable.animedif3);
            dbIm.insertQuestionDAnimeImg("¿A qué serie de anime pertenece este personaje?","Tokyo Ghoul","Akame ga kill","Death Parade","Kill la Kill",
                    "Kill la Kill",R.drawable.animedif4);


            dbIm.insertQuestionEHistoryImg("¿Qué diosa griega es?","Afrodita","Hestia","Atenea","Deméter",
                    "Atenea",R.drawable.histfacil1);
            dbIm.insertQuestionEHistoryImg("¿Qué dios es?","Shiva","Lakshmi","Rama","Ganesha",
                    "Ganesha",R.drawable.histfacil2);
            dbIm.insertQuestionEHistoryImg("¿Qué dios es?","Anubis","Seth","Ra","Horus",
                    "Anubis",R.drawable.histfacil3);
            dbIm.insertQuestionEHistoryImg("¿Qué nombre tiene este cuadro?","El Grito","La Mona Lisa","Salvator Mundi","El Guernica",
                    "La Mona Lisa",R.drawable.histfacil4);


            dbIm.insertQuestionDHistoryImg("¿Quién lo pintó?","Rubens","El Greco","Rembrandt","Velázquez",
                    "Rembrandt",R.drawable.histdif1);
            dbIm.insertQuestionDHistoryImg("Nombra esta escultura","Olympia","El beso","El mundo de Cristina","Venus de Milo",
                    "Venus de Milo",R.drawable.histdif2);
            dbIm.insertQuestionDHistoryImg("¿Qué dispositivo es?","Máquina de coser","Telégrafo","Transistor","Grabador",
                    "Rembrandt",R.drawable.histdif3);
            dbIm.insertQuestionDHistoryImg("Nombra este cuadro","El hijo del hombre","Salvator Mundi","David","El pensador",
                    "El hijo del hombre",R.drawable.histdif4);


            dbIm.insertQuestionECineImg("¿De qué película es la escena?","El conjuro","Annabelle","La monja","No respires",
                    "El conjuro",R.drawable.cinefacil1);
            dbIm.insertQuestionECineImg("¿De qué saga es el personaje?","Regreso al futuro","Pretty woman","Harry Potter","El orfanato",
                    "Harry Potter",R.drawable.cinefacil2);
            dbIm.insertQuestionECineImg("¿De qué película es este personaje?","Saw","IT","El sexto sentido","La llorona",
                    "IT",R.drawable.cinefacil3);
            dbIm.insertQuestionECineImg("¿De qué película es este personaje?","Rompe Ralph","En busca de la felicidad","Deadpool","Chappie",
                    "Chappie",R.drawable.cinefacil4);


            dbIm.insertQuestionDCineImg("¿De qué película es la escena?","El gran Lebowski","Saw II","El resplandor","El padrino",
                    "El padrino",R.drawable.cinedif1);
            dbIm.insertQuestionDCineImg("¿Quién es?","Johnny the Boy","Jim Goose","Mad Max","Crawford Montazano",
                    "Mad Max",R.drawable.cinedif2);
            dbIm.insertQuestionDCineImg("¿De qué película es la escena?","E.T.","Gremlins","Los Goonies","El resplandor",
                    "E.T.",R.drawable.cinedif3);
            dbIm.insertQuestionDCineImg("¿De qué película es la escena?","La chica del tren","Lost in Translation","Ghost in the Shell","El becario",
                    "Lost in Translation",R.drawable.cinedif4);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                   finish();
                   startActivity(new Intent(MainActivity.this, Menu.class));
                }
             }, 2000);

        }catch (Exception ex)
        {
            ex.toString();
        }

    }
}