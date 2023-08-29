
/**
 * Write a description of class CheckList here.
 *
 * @author (Daniel Perodin)
 * @version (5/9/2023)
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
public class CheckList
{
    
    private String [][] openings;
    
    public static final String [][] openingsDatabase = {
{"Sicilian Defense", "1. e4 c5", "https://www.youtube.com/watch?v=VxV8l3x7hOg"}, 
{"Sicilian Defense: Closed Variation", "1. e4 c5", "2. Nc3", "https://www.youtube.com/watch?v=VxV8l3x7hOg"},
{"Sicilian Defense: Open Variation", "1. e4 c5", "2. Nf3 d6", "3. d4 cxd4", "4. Nxd4", "https://www.youtube.com/watch?v=VxV8l3x7hOg"},
{"Sicilian Defense: Open Variation", "1. e4 c5",  "2. Nf3 Nc6", "3. d4", "https://www.youtube.com/watch?v=VxV8l3x7hOg"},
{"Sicilian Defense: Najdorf Variation", "1. e4 c5", "2. Nf3 d6", "3. d4 cxd4", "4. Nxd4 Nf6", "5. Nc3 a6", "https://www.youtube.com/watch?v=VxV8l3x7hOg"},
{"Sicilian Defense: Alapin Variation", "1. e4 c5", "2. c3", "https://www.youtube.com/watch?v=VxV8l3x7hOg"},
{"Sicilian Defense: Dragon Variation", "1. e4 c5", "2. Nf3 d6", "3. d4 cxd4", "4. Nxd4 Nf6", "5. Nc3 g6", "https://youtu.be/u1Jji8Z4YS0"},
{"Sicilian Defense: French Variation", "1. e4 c5", "2. Nf3 e6", "https://www.youtube.com/watch?v=VxV8l3x7hOg"},
{"King's Fianchetto Opening, also known as the Hungarian opening", "1. g3", "https://www.chess.com/openings/Kings-Fianchetto-Opening"},
{"Queen's Pawn Opening", "1. d4", "https://www.chess.com/openings/Queens-Pawn-Openin"},
{"Reti Opening", "1. Nf3", "https://youtu.be/7vvw7ImegGA"},
{"Reti Gambit", "1. Nf3 d5", "2. c4", "https://youtu.be/R1fFb-1QUX8"},
{"King's Indian Attack", "1. Nf3 d5", "2. g3", "https://youtu.be/Si5Ahz08Q8w"},
{"Bird’s Opening", "1. f4", "https://youtu.be/QYso2oqghpU"},
{"Bird’s Opening: Dutch Variation", "1. f4 d5", "https://youtu.be/p95balV5pGE"},
{"From’s Gambit", "1. f4 e5", "https://youtu.be/zZQz3xi79GE"},
{"Nimzowitsch-Larsen Attack", "1. b3", "https://www.youtube.com/watch?v=HhPxp4yyoDI"},
{"King’s Pawn Opening", "1. e4", "https://www.chess.com/openings/Kings-Pawn-Opening"},
{"English Opening", "1. c4", "https://youtu.be/N74FM5kG-PA"},
{"English Opening: Symmetrical Variation", "1. c4 c5", "https://youtu.be/N74FM5kG-PA"},
{"Alekhine's Defense", "1. e4 Nf6", "https://youtu.be/G0ctAe7bGzs"},
{"Caro-Kann Defense", "1. e4 c6", "https://youtu.be/ebfzL_GwiIE"},
{"Modern Defense with 1. d4", "1. d4 g6", "https://youtu.be/P0KL1FF2zOw"},
{"Scandinavian Defense","1. e4 d5", "https://youtu.be/A2J2OW99lGU"},
{"Dutch Defense", "1. d4 f5", "https://youtu.be/ogmGNIk6W7I"},
{"French Defense", "1. e4 e6", "https://youtu.be/5pec-u6PSvA"},
{"Pirc Defense", "1. e4 d6", "https://youtu.be/7z66hiJAqmo"},
{"Old Benoni Defense", "1. d4 c5", "https://youtu.be/VYKQbXLC3pQ"},
{"English Opening: King's English Variation", "1. c4 e5", "https://youtu.be/1lk9P2wNyTE"},
{"Trompowsky Attack", "1. d4 Nf6", "2. Bg5", "https://youtu.be/FIBmNk1DyLY"},
{"Vienna Game", "1. e4 e5", "2. Nc3", "https://youtu.be/JVxENCPcCjU"},
{"Queen's Gambit", "1. d4 d5", "2. c4", "https://youtu.be/mtsabsZ4wG4"},
{"King's Gambit", "1. e4 e5", "2. f4", "https://youtu.be/n5ImJ2row6E"},
{"Bishop's Opening", "1. e4 e5", "2. Bc4", "https://youtu.be/Qb3PWiIbIJs"},
{"Queen's Pawn Opening: Blackmar Gambit", "1. d4 d5", "2. e4", "https://youtu.be/mxtUxgupAHY"},
{"Sicilian Defense: Smith-Morra Gambit", "1. e4 c5", "2. d4", "https://youtu.be/AWE8nHXFR3U"},
{"Slav Defense", "1. d4 d5", "2. c4 c6", "https://youtu.be/cs54KXnGc-0"},
{"Budapest Gambit", "1. d4 Nf6", "2. c4 e5", "https://youtu.be/G8fAtO7-prw"},
{"King's Gambit Declined: Falkbeer Countergambit", "1. e4 e5", "2. f4 d5", "https://youtu.be/JJtNE_0xBXY"},
{"King's Gambit Declined: Classical Variation", "1. e4 e5", "2. f4 Bc5", "https://youtu.be/tCYNsrwyY-Q"},
{"King's Gambit Accepted", "1. e4 e5", "2. f4 exf4", "https://youtu.be/92XYzS-vUOc"},
{"Petrov's Defense", "1. e4 e5", "2. Nf3 Nf6", "https://youtu.be/DyDVQPwk6fY"},
{"King's Indian Defense", "1. d4 Nf6", "2. c4 g6", "https://youtu.be/kK0cq6UBt1Y"},
{"Queen's Gambit Accepted", "1. d4 d5", "2. c4 dxc4", "https://youtu.be/6a5p8flI5wc"},
{"Scandinavian Defense: Modern Variation", "1. e4 d5", "2. exd5 Nf6", "https://youtu.be/mEwzUYJV17E"},
{"Dutch Defense: Staunton Gambit Accepted", "1. d4 f5", "2. e4 fxe4", "https://youtu.be/zQPcTnwL-jA"},
{"Old Indian Defense", "1. d4 Nf6", "2. c4 d6", "https://youtube.com/shorts/4r_iSrRUd0Q?feature=share"},
{"Philidor Defense", "1. e4 e5", "2. Nf3 d6", "https://youtu.be/mAf-YuGPYMo"},
{"Queen's Gambit Declined: Albin Countergambit", "1. d4 d5", "2. c4 e5", "https://youtu.be/WU9ai7VYylk"},
{"Queen's Gambit Declined: Chigorin Defense", "1. d4 d5", "2. c4 Nc6", "https://www.youtube.com/watch?v=2OvqvVbATwE"},
{"Caro-Kann Defense: Exchange Variation", "1. e4 c6", "2. d4 d5", "3. exd5", "https://youtu.be/oif3zWWJm1k"},
{"Closed Sicilian Defense: Grand Prix Attack", "1. e4 c5", "2. Nc3 Nc6", "3. f4", "https://youtu.be/o3NPgdOSGck"},
{"London System", "1. d4 d5", "2. Nf3 Nf6", "3. Bf4", "https://youtu.be/49H728S_VjM"},
{"Queen's Pawn Opening: Torre Attack", "1. d4 d5", "2. Nf3 Nf6", "3. Bg5", "https://youtu.be/E1Vf3LPqt0k"},
{"Catalan Opening", "1. d4 Nf6", "2. c4 e6", "3. g3", "https://youtu.be/nMuvv1HksL4"},
{"French Defense: Advance Variation", "1. e4 e6", "2. d4 d5", "3. e5", "https://youtu.be/gs1AFfmt3To"},
{"Petrov's Defense: Steinitz Attack", "1. e4 e5", "2. Nf3 Nf6", "3. d4", "https://youtu.be/rYsvQ5eXo6A"},
{"Danish Gambit", "1. e4 e5", "2. d4 exd4", "3. c3", "https://youtu.be/Nd7ZiSvdwN8"},
{"Petrov's Defense: Three Knights Game", "1. e4 e5", "2. Nf3 Nf6", "3. Nc3", "https://youtu.be/hn_YqhNJc5o"},
{"French Defense: Exchange Variation", "1. e4 e6", "2. d4 d5", "3. exd5", "https://youtu.be/rKd5RrRTTo4"},
{"Ruy López Opening", "1. e4 e5", "2. Nf3 Nc6", "3. Bb5", "https://youtu.be/41rPFNY_CAY"}, 
{"Italian Game", "1. e4 e5", "2. Nf3 Nc6", "3. Bc4", "https://youtu.be/MhNs8GLo894"},
{"Scotch Game", "1. e4 e5", "2. Nf3 Nc6", "3. d4", "https://youtu.be/LdqbaqdHkPE"},
{"French Defense: Tarrasch Variation", "1. e4 e6", "2. d4 d5", "3. Nd2", "https://youtu.be/IGS68T5FmvM"},
{"King's Gambit Accepted: Bishop's Gambit", "1. e4 e5", "2. f4 exf4", "3. Bc4", "https://youtu.be/8S8IEH20E3I"},
{"Caro-Kann Defense: Advance Variation", "1. e4 c6", "2. d4 d5", "3. e5", "https://youtu.be/XMm2WRuCEMA"},
{"Richter-Veresov Attack", "1. d4 d5", "2. Nc3 Nf6", "3. Bg5", "https://youtu.be/fyr48g_lg3I"},
{"Grünfeld Defense", "1. d4 Nf6", "2. c4 g6", "3. Nc3 d5", "https://youtu.be/d7KGYXxg_zo"},
{"Queen's Indian Defense", "1. d4 Nf6", "2. c4 e6", "3. Nf3 b6", "https://youtu.be/0RlupWm5Iao"},
{"Modern Defense: Standard, Pterodactyl Defense", "1. e4 g6", "2. d4 Bg7", "3. Nc3 c5", "https://youtu.be/LKYiIIl6wIY"},
{"Four Knights Game", "1. e4 e5", "2. Nf3 Nc6", "3. Nc3 Nf6", "https://youtu.be/QqPVNolnOfw"},
{"King's Gambit Accepted: Modern Defense", "1. e4 e5", "2. f4 exf4", "3. Nf3 d5", "https://youtu.be/Iq_-7DJC-go"},
{"Benko Gambit", "1. d4 Nf6", "2. c4 c5", "3. d5 b5", "https://youtu.be/-qGlSDA4w6M"},
{"Ruy López Opening: Classical Defense", "1. e4 e5", "2. Nf3 Nc6", "3. Bb5 Bc5", "https://youtu.be/-QrOlj8jJBM"},
{"Nimzo-Indian Defense", "1. d4 Nf6", "2. c4 e6", "3. Nc3 Bb4", "https://youtu.be/pBpEFAz5Afw"},
{"French Defense: Classical Variation", "1. e4 e6", "2. d4 d5", "3. Nc3 Nf6", "https://youtu.be/bZEAzXT2Nq0"},
{"Benoni Defense: Modern Variation", "1. d4 Nf6", "2. c4 c5", "3. d5 e6", "https://youtu.be/R3sT1d_npnQ"},
{"Italian Game: Hungarian Defense", "1. e4 e5", "2. Nf3 Nc6", "3. Bc4 Be7", "https://youtu.be/oBRZp9yOPyQ"},
{"Giuoco Piano Game", "1. e4 e5", "2. Nf3 Nc6", "3. Bc4 Bc5", "https://youtu.be/sKTAYd-fQOA"},
{"French Defense: Rubinstein Variation", "1. e4 e6", "2. d4 d5", "3. Nc3 dxe4", "https://youtu.be/THkLmg9vmv0"},
{"Italian Game: Two Knights Defense", "1. e4 e5", "2. Nf3 Nc6", "3. Bc4 Nf6", "https://youtu.be/NKI-7UwuGTM"},
{"King's Indian Defense: Normal Variation", "1. d4 Nf6", "2. c4 g6", "3. Nc3 Bg7", "https://youtu.be/iGCSfVDYhh0"},
{"French Defense: Winawer Variation", "1. e4 e6", "2. d4 d5", "3. Nc3 Bb4", "https://youtu.be/C5ynsd_40L8"},
{"Ruy López Opening: Jaenisch Gambit", "1. e4 e5", "2. Nf3 Nc6", "3. Bb5 f5", "https://youtu.be/zgAez2dyarg"},
{"Queen's Gambit Declined: Pseudo-Tarrasch Defense", "1. d4 d5", "2. c4 e6", "3. Nf3 c5", "https://youtu.be/GABa2tg3q9A"},
{"Ruy López Opening: Berlin Defense", "1. e4 e5", "2. Nf3 Nc6", "3. Bb5 Nf6", "https://youtu.be/eM1yKnw2g2w"},
{"Ruy López Opening: Old Steinitz Defense", "1. e4 e5", "2. Nf3 Nc6", "3. Bb5 d6", "https://youtu.be/VDlfhOm4ltE"},
{"Bogo-Indian Defense", "1. d4 Nf6", "2. c4 e6", "3. Nf3 Bb4+", "https://youtu.be/bo8xD3y_NIA"},
{"Caro-Kann Defense: Panov Attack", "1. e4 c6", "2. d4 d5", "3. exd5 cxd5", "4. c4", "https://youtu.be/hWLTjQ8LMeE"},
{"Grünfeld Defense: Stockholm Variation", "1. d4 Nf6", "2. c4 g6", "3. Nc3 d5", "4. Bg5", "https://youtu.be/yJiffXJv2Sw"},
{"Grünfeld Defense: Three Knights Variation", "1. d4 Nf6", "2. c4 g6", "3. Nc3 d5", "4. Nf3", "https://youtu.be/kqf6lFXzFDI"},
{"Four Knights Game: Scotch Variation", "1. e4 e5", "2. Nf3 Nc6", "3. Nc3 Nf6", "4. d4", "https://youtu.be/jdsKTHv6Flc"},
{"Nimzo-Indian Defense: Classical Variation", "1. d4 Nf6", "2. c4 e6", "3. Nc3 Bb4", "4. Qc2", "https://youtu.be/GVNoH_GkMpo"},
{"Catalan Opening: Closed", "1. d4 Nf6", "2. c4 e6", "3. g3 d5", "4. Bg2", "https://youtu.be/dHkYfxme6Zc"},
{"Giuoco Piano Game: Evans Gambit", "1. e4 e5", "2. Nf3 Nc6", "3. Bc4 Bc5", "4. b4", "https://www.youtube.com/watch?v=fG52OQytDxc"},
{"Ruy López Opening: Morphy Defense, Exchange Variation", "1. e4 e5", "2. Nf3 Nc6", "3. Bb5 a6", "4. Bxc6", "https://www.youtube.com/watch?v=W72Vw-DxvA0"}, 
{"Grünfeld Defense: Brinckmann Attack", "1. d4 Nf6", "2. c4 g6", "3. Nc3 d5", "4. Bf4", "https://youtu.be/42dvuYG4AvE"},
{"Pirc Defense: Main Line, Austrian Attack", "1. e4 d6", "2. d4 Nf6", "3. Nc3 g6", "4. f4", "https://youtu.be/7W2dB74VcUQ"},
{"Pirc Defense: Classical Variation", "1. e4 d6", "2. d4 Nf6", "3. Nc3 g6", "4. Nf3", "https://youtu.be/woly7P6IS6c"},
{"Caro-Kann Defense: Classical Variation", "1. e4 c6", "2. d4 d5", "3. Nc3 dxe4", "4. Nxe4 Bf5", "https://youtu.be/86onnhhKHMg"},
{"Sicilian Defense: Kan Variation", "1. e4 c5", "2. Nf3 e6", "3. d4 cxd4", "4. Nxd4 a6", "https://youtu.be/w40R3zBk6x4"},
{"Nimzo-Indian Defense: Hübner Variation", "1. d4 Nf6", "2. c4 e6", "3. Nc3 Bb4", "4. e3 c5", "https://www.chess.com/openings/Nimzo-Indian-Defense-Hubner-Variation"},
{"Scotch Game: Classical Variation", "1. e4 e5", "2. Nf3 Nc6", "3. d4 exd4", "4. Nxd4 Bc5", "https://youtu.be/Og7gNI35GL4"},
{"French Defense: Classical, Burn Variation", "1. e4 e6", "2. d4 d5", "3. Nc3 Nf6", "4. Bg5 dxe4", "https://youtu.be/GZs8v1KJpgY"},
{"Scotch Game: Steinitz Variation", "1. e4 e5", "2. Nf3 Nc6", "3. d4 exd4", "4. Nxd4 Qh4", "https://youtu.be/YtzJtfLV48o"},
{"Sicilian Defense: Taimanov Variation", "1. e4 c5", "2. Nf3 e6", "3. d4 cxd4", "4. Nxd4 Nc6", "https://youtu.be/irB8uHftgqc"},
{"Semi-Slav Defense", "1. d4 d5", "2. c4 e6", "3. Nc3 Nf6", "4. Nf3 c6", "https://youtu.be/8LlvxBi58ac"},
{"Petrov's Defense: Classical, Stafford Gambit", "1. e4 e5", "2. Nf3 Nf6", "3. Nxe5 Nc6", "4. Nxc6 dxc6", "https://youtu.be/CcE_gqKJD6U"},
{"Queen's Gambit Declined: Three Knights, Semi-Tarrasch Defense", "1. d4 d5", "2. c4 e6", "3. Nc3 Nf6", "4. Nf3 c5", "https://youtu.be/KNg5A_XZGfY"},
{"Sicilian Defense: Old Sicilian, Open, Accelerated Dragon Variation", "1. e4 c5", "2. Nf3 Nc6", "3. d4 cxd4", "4. Nxd4 g6", "https://youtu.be/h11MkaA32Vo"},
{"Grünfeld Defense: Exchange Variation", "1. d4 Nf6", "2. c4 g6", "3. Nc3 d5", "4. cxd5 Nxd5", "https://youtu.be/C1EbPsdB4FM"},
{"Petrov's Defense: Classical Attack", "1. e4 e5", "2. Nf3 Nf6", "3. Nxe5 d6", "4. Nf3 Nxe4", "5. d4", "https://www.chess.com/openings/Petrovs-Defense-Classical-Attack"}, 
{"Nimzo-Indian Defense: Hübner, Rubinstein Variation", "1. d4 Nf6", "2. c4 e6", "3. Nc3 Bb4", "4. e3 c5", "5. Ne2", "https://www.chess.com/openings/Nimzo-Indian-Defense-Hubner-Rubinstein-Variation"},
{"Nimzo-Indian Defense: Sämisch Variation", "1. d4 Nf6", "2. c4 e6", "3. Nc3 Bb4", "4. a3 Bxc3+", "5. bxc3", "https://youtu.be/dPd01_uP90s"},
{"Dutch Defense: Leningrad, Main Line", "1. d4 f5", "2. c4 Nf6", "3. g3 g6", "4. Bg2 Bg7", "5. Nf3", "https://youtu.be/FE1dYi-c1kU"},
{"King's Indian Defense: Normal, Fianchetto Variation", "1. d4 Nf6", "2. c4 g6", "3. Nc3 Bg7", "4. Nf3 d6", "5. g3", "https://youtu.be/S6shy_j-5IA"},
{"King's Indian Defense: Four Pawns Attack", "1. d4 Nf6", "2. c4 g6", "3. Nc3 Bg7", "4. e4 d6", "5. f4", "https://youtu.be/Je1dRnNV6IQ"},
{"King's Indian Defense: Sämisch Variation", "1. d4 Nf6", "2. c4 g6", "3. Nc3 Bg7", "4. e4 d6", "5. f3", "https://youtu.be/tVuW0PvUh9c"},
{"Sicilian Defense: Open, Scheveningen Variation", "1. e4 c5", "2. Nf3 d6", "3. d4 cxd4", "4. Nxd4 Nf6", "5. Nc3 e6", "https://youtu.be/Kp5N_d3JS6Y"},
{"King's Indian Defense: Averbakh Variation", "1. d4 Nf6", "2. c4 g6", "3. Nc3 Bg7", "4. e4 d6", "5. Be2 O-O", "6. Bg5", "https://youtu.be/NqJkqqPMm8E"},
{"Scotch Game: Schmidt, Mieses Variation", "1. e4 e5", "2. Nf3 Nc6", "3. d4 exd4", "4. Nxd4 Nf6", "5. Nxc6 bxc6", "6. e5", "https://youtu.be/-3wnJxmUJZg"},
{"King's Indian Defense: Orthodox Variation", "1. d4 Nf6", "2. c4 g6", "3. Nc3 Bg7", "4. e4 d6", "5. Nf3 O-O", "6.Be2", "https://www.chess.com/openings/Kings-Indian-Defense-Orthodox-Variation"},
{"Sicilian Defense: Open, Classical, Richter-Rauzer Variation", "1. e4 c5", "2. Nf3 d6", "3. d4 cxd4", "4. Nxd4 Nf6", "5. Nc3 Nc6", "6. Bg5", "https://youtube.com/shorts/hwxgb-Sd1MQ?feature=share"},
{"Dutch Defense: Fianchetto, Ilyin-Zhenevsky, Stonewall Variation", "1. d4 f5", "2. c4 Nf6", "3. g3 e6", "4. Bg2 Be7", "5. Nf3 O-O", "6. O-O d5", "https://youtu.be/FYcvCPpovzA"},
{"Queen's Gambit Declined: Orthodox Defense", "1. d4 d5", "2. c4 e6", "3. Nc3 Nf6", "4. Bg5 Be7", "5. e3 O-O", "6. Nf3 Nbd7", "https://youtu.be/iTz-VYxkOpE"},
{"King's Indian Defense: Bayonet Attack", "1. d4 Nf6", "2. c4 g6", "3. Nc3 Bg7", "4. e4 d6", "5. Nf3 O-O", "6. Be2 e5", "7. O-O Nc6", "8. d5 Ne7", "9. b4", "https://youtu.be/Igbyr-ERmus"},
};
//end 2D array


    /**
     * Constructor for objects of class CheckList
     */
    public CheckList(String [][] theOpening)
    {
        // initialise instance variables
        openings = theOpening;
        
    }

    public static int findRowNum (String firstMove)
    {
       int counter = 0; 
     
for (int i = 0; i < openingsDatabase.length; i++) {
    if (openingsDatabase[i][1].indexOf(firstMove) != -1) 
    {
    counter++;
}
}
        
    return counter;
    }
    /**
     * traverse a 2D array of openings and a String containing a user's first move and compare that String to the first move in each of 
     * the openings in the 2D array of openings
     *
     * @param  y  a sample parameter for a method
     * @return    a 2D array of Strings including openings containing a first move which matches the game's first move 
     * (this will eliminate irrelivant openings and save time down the road) 
     */
    public static String [][] firstMoveCut(String firstMove, int counter)
    {
int rmRows = 0;
        String [][] reducedMatrix = new String[counter][11];

for (int x = 0; x < openingsDatabase.length; x++) {
    if (openingsDatabase[x][1].indexOf(firstMove) != -1) 
    {
    reducedMatrix[rmRows] = openingsDatabase[x];
    rmRows ++;
}
}

return reducedMatrix;
}
        
public static String [][] firstBlackMoveCut(String firstBlackMove, String [][] reducedOpenings)
    {
     int counter = 0; 
     int rmRows = 0;
for (int i = 0; i < reducedOpenings.length; i++) {
    if (firstBlackMove.equalsIgnoreCase(reducedOpenings[i][1])) 
    {
    counter++;
}
}

String [][] reducedMatrix2 = new String[counter][11];

for (int x = 0; x < reducedOpenings.length; x++) {
    if (firstBlackMove.equalsIgnoreCase(reducedOpenings[x][1])) 
    {
    reducedMatrix2[rmRows] = reducedOpenings[x];
    rmRows ++;
}
}

return reducedMatrix2;
}

public void setOpenings(String [][] x)//use this is the second round for white
    {
        openings = x;
    }

    public String [][] getOpenings()//use this is the second round for white
    {
        return openings;
    }

    
public String [][] cutOpenings(ArrayList<String> theMoves)
    {
     int counter = 0; 
     int rmRows = 0;
     int matches = 0;
     
for (int i = 0; i < openings.length; i++) {
    for (int a = 2; a < theMoves.size(); a++)
    {
    if (openings[i][a-1].indexOf(theMoves.get(a)) != -1) 
    {
    counter++;
}
}
if (counter == (theMoves.size() - 2))
{
matches++; 
}
counter = 0;
}

String [][] reducedMatrix2 = new String[matches][11];
if (matches == 0)
{
return reducedMatrix2;
}

for (int x = 0; x < openings.length; x++) {
  int a = theMoves.size() - 1;
    
    if (openings[x][a-1].indexOf(theMoves.get(a)) != -1) 
    {
    reducedMatrix2[rmRows] = openings[x];
    rmRows ++;
}

}

return reducedMatrix2;
}
    }
