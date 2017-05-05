package com.example.jsayler.ad340testapp;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

public class RecyclerViewActivity extends OptionsMenu {

    Context context;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    // make 2d array
    String[][] subjects = { {"NES Game Title","Date Published"},{"10-Yard Fight","10/1/1985"},
            {"Baseball","10/1/1985"}, {"Clu Clu Land","10/1/1985"},
            {"Donkey Kong Jr. Math","10/1/1985"}, {"Duck Hunt","10/1/1985"},
            {"Excitebike","10/1/1985"}, {"Golf","10/1/1985"},
            {"Gyromite","10/1/1985"}, {"Hogan's Alley","10/1/1985"},
            {"Ice Climber","10/1/1985"}, {"Kung Fu","10/1/1985"},
            {"Mach Rider","10/1/1985"}, {"Pinball","10/1/1985"},
            {"Stack-Up","10/1/1985"}, {"Super Mario Bros.","10/1/1985"},
            {"Tennis","10/1/1985"}, {"Wild Gunman","10/1/1985"},
            {"Wrecking Crew","10/1/1985"}, {"Balloon Fight","6/1/1986"},
            {"Donkey Kong","6/1/1986"}, {"Donkey Kong 3","6/1/1986"},
            {"Donkey Kong Jr.","6/1/1986"}, {"Gumshoe","6/1/1986"},
            {"Mario Bros.","6/1/1986"}, {"Popeye","6/1/1986"},
            {"Urban Champion","6/1/1986"}, {"Chubby Cherub","10/1/1986"},
            {"M.U.S.C.L.E.","10/1/1986"}, {"Ninja Kid","10/1/1986"},
            {"Tag Team Wrestling","10/1/1986"}, {"1942","11/1/1986"},
            {"Commando","11/1/1986"}, {"Karate Champ","11/1/1986"},
            {"Ghosts'n Goblins","11/1/1986"}, {"Gradius","12/1/1986"},
            {"Trojan","2/1/1987"}, {"Pro Wrestling","3/1/1987"},
            {"Soccer","3/1/1987"}, {"Volleyball","3/1/1987"},
            {"Rush'n Attack","4/1/1987"}, {"Track & Field","4/1/1987"},
            {"BurgerTime","5/1/1987"}, {"Castlevania","5/1/1987"},
            {"Ikari Warriors","5/1/1987"}, {"Side Pocket","6/1/1987"},
            {"Athletic World","7/1/1987"}, {"Kid Icarus","7/1/1987"},
            {"Mighty Bomb Jack","7/1/1987"}, {"Rygar","7/1/1987"},
            {"Section-Z","7/1/1987"}, {"Solomon's Key","7/1/1987"},
            {"Arkanoid","8/1/1987"}, {"Athena","8/1/1987"},
            {"Elevator Action","8/1/1987"}, {"Metroid","8/1/1987"},
            {"Slalom","8/1/1987"}, {"The Legend of Kage","8/1/1987"},
            {"The Legend of Zelda","8/1/1987"}, {"3-D WorldRunner","9/1/1987"},
            {"Deadly Towers","9/1/1987"}, {"Double Dribble","9/1/1987"},
            {"Lode Runner","9/1/1987"}, {"Raid on Bungeling Bay","9/1/1987"},
            {"Ring King","9/1/1987"}, {"Sky Kid","9/1/1987"},
            {"Spelunker","9/1/1987"}, {"Spy Hunter","9/1/1987"},
            {"Sqoon","9/1/1987"}, {"Stadium Events","9/1/1987"},
            {"Star Voyager","9/1/1987"}, {"Stinger","9/1/1987"},
            {"Tiger-Heli","9/1/1987"}, {"Winter Games","9/1/1987"},
            {"Alpha Mission","10/1/1987"}, {"Lunar Pool","10/1/1987"},
            {"Mike Tyson's Punch-Out!!","10/1/1987"}, {"Rad Racer","10/1/1987"},
            {"Zanac","10/1/1987"}, {"BreakThru","11/1/1987"},
            {"Gotcha! The Sport!","11/1/1987"}, {"Jaws","11/1/1987"},
            {"Kid Niki: Radical Ninja","11/1/1987"}, {"Star Force","11/1/1987"},
            {"Super Pitfall","11/1/1987"}, {"The Goonies II","11/1/1987"},
            {"The Karate Kid","11/1/1987"}, {"Top Gun","11/1/1987"},
            {"Mega Man","12/1/1987"}, {"Wizards & Warriors","12/1/1987"},
            {"Gauntlet (unlicensed)","6/9/1987"}, {"Pac-Man (unlicensed)","6/9/1987"},
            {"1943: The Battle of Midway","10/1/1988"}, {"Adventure Island","9/1/1988"},
            {"Anticipation","11/1/1988"}, {"Bases Loaded","7/1/1988"},
            {"Bionic Commando","12/1/1988"}, {"Blades of Steel","12/1/1988"},
            {"Blaster Master","11/1/1988"}, {"Bubble Bobble","11/1/1988"},
            {"Bump 'n' Jump","12/1/1988"}, {"Castlevania II: Simon's Quest","12/1/1988"},
            {"City Connection","5/1/1988"}, {"Cobra Command","11/1/1988"},
            {"Contra","2/1/1988"}, {"Defender II","7/1/1988"},
            {"Donkey Kong Classics","10/1/1988"}, {"Double Dragon","6/1/1988"},
            {"Dr. Chaos","11/1/1988"}, {"Dragon Power","3/1/1988"},
            {"Freedom Force","4/1/1988"}, {"Galaga: Demons of Death","9/1/1988"},
            {"Ghostbusters","10/1/1988"}, {"Golgo 13: Top Secret Episode","9/1/1988"},
            {"Gun.Smoke","2/1/1988"}, {"Ice Hockey","3/1/1988"},
            {"Ikari Warriors II: Victory Road","4/1/1988"}, {"Indiana Jones and the Temple of Doom","12/1/1988"},
            {"Iron Tank: The Invasion of Normandy","7/1/1988"}, {"Jackal","9/1/1988"},
            {"Jeopardy!","9/1/1988"}, {"Joust","10/1/1988"},
            {"Karnov","1/1/1988"}, {"Lee Trevino's Fighting Golf","9/1/1988"},
            {"Legendary Wings","7/1/1988"}, {"Life Force","8/1/1988"},
            {"Magmax","10/1/1988"}, {"Major League Baseball","4/1/1988"},
            {"Metal Gear","6/1/1988"}, {"Mickey Mousecapade","10/1/1988"},
            {"Millipede","10/1/1988"}, {"Milon's Secret Castle","9/1/1988"},
            {"Othello","12/1/1988"}, {"Paperboy","12/1/1988"},
            {"Platoon","12/1/1988"}, {"R.C. Pro-Am","2/1/1988"},
            {"Racket Attack","10/1/1988"}, {"Rambo","5/1/1988"},
            {"Rampage","12/1/1988"}, {"Renegade","1/1/1988"},
            {"Robo Warrior","12/1/1988"}, {"Seicross","10/1/1988"},
            {"Skate or Die","12/1/1988"}, {"Spy vs. Spy","10/1/1988"},
            {"Super Mario Bros. / Duck Hunt","11/1/1988"}, {"Super Mario Bros. 2","10/1/1988"},
            {"Super Team Games","11/1/1988"}, {"Superman","12/1/1988"},
            {"Town & Country Surf Designs: Wood & Water Rage","2/1/1988"}, {"Wheel of Fortune","9/1/1988"},
            {"Xenophobe","12/1/1988"}, {"Xevious","9/1/1988"},
            {"Zelda II: The Adventure of Link","12/1/1988"}, {"Alien Syndrome (unlicensed)","6/10/1988"},
            {"R.B.I. Baseball (unlicensed)","6/10/1988"}, {"Vindicators (unlicensed)","6/10/1988"},
            {"720°","11/1/1989"}, {"Adventures of Dino Riki","9/1/1989"},
            {"Adventures of Lolo","4/1/1989"}, {"Adventures of Tom Sawyer","8/1/1989"},
            {"After Burner","6/11/1989"}, {"Air Fortress","9/1/1989"},
            {"Airwolf","6/1/1989"}, {"All-Pro Basketball","12/1/1989"},
            {"Amagon","4/1/1989"}, {"Archon","12/1/1989"},
            {"Baby Boomer","6/11/1989"}, {"Back to the Future","9/1/1989"},
            {"Bad Street Brawler","9/1/1989"}, {"Bandai Golf: Challenge Pebble Beach","2/1/1989"},
            {"Baseball Stars","7/1/1989"}, {"Bomberman","1/1/1989"},
            {"California Games","6/1/1989"}, {"Captain Comic: The Adventure","6/11/1989"},
            {"Casino Kid","10/1/1989"}, {"Castlequest","9/1/1989"},
            {"Championship Bowling","12/1/1989"}, {"Cobra Triangle","7/1/1989"},
            {"Crystal Mines","6/11/1989"}, {"Cybernoid: The Fighting Machine","12/1/1989"},
            {"Dance Aerobics","3/1/1989"}, {"Defender of the Crown","7/1/1989"},
            {"Desert Commander","6/1/1989"}, {"Dig Dug II: Trouble in Paradise","12/1/1989"},
            {"Dr. Jekyll and Mr. Hyde","4/1/1989"}, {"Dragon Warrior","8/1/1989"},
            {"DuckTales","9/1/1989"}, {"Fantasy Zone","6/11/1989"},
            {"Faxanadu","8/1/1989"}, {"Fester's Quest","9/1/1989"},
            {"Fist of the North Star","4/1/1989"}, {"Flying Dragon: The Secret Scroll","8/1/1989"},
            {"Friday the 13th","2/1/1989"}, {"Goal!","10/1/1989"},
            {"Gauntlet","6/11/1989"}, {"Godzilla: Monster of Monsters!","10/1/1989"},
            {"Guerrilla War","6/1/1989"}, {"Gyruss","2/1/1989"},
            {"Hollywood Squares","9/1/1989"}, {"Hoops","6/1/1989"},
            {"Hydlide","6/1/1989"}, {"Ironsword: Wizards & Warriors II","12/1/1989"},
            {"Jeopardy! Junior Edition","10/1/1989"}, {"John Elway's Quarterback","3/1/1989"},
            {"Jordan vs. Bird: One on One","8/1/1989"}, {"King's Knight","9/1/1989"},
            {"Knight Rider","12/1/1989"}, {"Kung-Fu Heroes","3/1/1989"},
            {"Legacy of the Wizard","4/1/1989"}, {"Mappy-Land","4/1/1989"},
            {"Marble Madness","3/1/1989"}, {"Master Chu and the Drunkard Hu","6/11/1989"},
            {"Mega Man 2","6/1/1989"}, {"Metal Fighter","6/11/1989"},
            {"Monster Party","6/1/1989"}, {"Mystery Quest","4/1/1989"},
            {"NFL Football","9/1/1989"}, {"Ninja Gaiden","3/1/1989"},
            {"Nobunaga's Ambition","6/1/1989"}, {"Operation Wolf","5/1/1989"},
            {"P.O.W.: Prisoners of War","9/1/1989"}, {"Predator","4/1/1989"},
            {"Q*bert","2/1/1989"}, {"Raid 2020","6/11/1989"},
            {"Road Runner","6/11/1989"}, {"RoboCop","12/1/1989"},
            {"Robodemons","12/1/1989"}, {"Rolling Thunder","6/11/1989"},
            {"Romance of the Three Kingdoms","10/1/1989"}, {"Sesame Street: 123","1/1/1989"},
            {"Sesame Street: ABC","9/1/1989"}, {"Shadowgate","12/1/1989"},
            {"Shinobi","6/11/1989"}, {"Shooting Range","6/1/1989"},
            {"Short Order / Eggsplode","12/1/1989"}, {"Silent Service","12/1/1989"},
            {"Sky Shark","9/1/1989"}, {"Star Soldier","1/1/1989"},
            {"Stealth ATF","10/1/1989"}, {"Street Cop","6/1/1989"},
            {"Strider","7/1/1989"}, {"Super Dodge Ball","6/1/1989"},
            {"Taboo: The Sixth Sense","4/1/1989"}, {"Tagin' Dragon","6/11/1989"},
            {"Tecmo Baseball","1/1/1989"}, {"Tecmo Bowl","2/1/1989"},
            {"Teenage Mutant Ninja Turtles","6/1/1989"}, {"Tetris (Nintendo)","11/1/1989"},
            {"Tetris (Tengen)","6/11/1989"}, {"The Adventures of Bayou Billy","6/1/1989"},
            {"The Battle of Olympus","12/1/1989"}, {"The Black Bass","9/1/1989"},
            {"The Bugs Bunny Crazy Castle","8/1/1989"}, {"The Guardian Legend","4/1/1989"},
            {"The Magic of Scheherazade","12/1/1989"}, {"The Three Stooges","10/1/1989"},
            {"The Uncanny X-Men","12/1/1989"}, {"Thundercade","7/1/1989"},
            {"To the Earth","11/1/1989"}, {"Toobin'","6/11/1989"},
            {"Track & Field II","6/1/1989"}, {"Twin Eagle","10/1/1989"},
            {"Ultima: Exodus","2/1/1989"}, {"Wheel of Fortune: Junior Edition","10/1/1989"},
            {"Who Framed Roger Rabbit","9/1/1989"}, {"Willow","12/1/1989"},
            {"World Games","3/1/1989"}, {"WWF WrestleMania","1/1/1989"},
            {"8 Eyes","1/1/1990"}, {"A Boy and His Blob: Trouble on Blobolonia","1/1/1990"},
            {"A Nightmare on Elm Street","10/1/1990"}, {"Abadox: The Deadly Inner War","3/1/1990"},
            {"Adventures in the Magic Kingdom","6/1/1990"}, {"Adventures of Lolo 2","3/1/1990"},
            {"All Unser Jr. Turbo Racing","3/1/1990"}, {"Arch Rivals: A Basket Brawl!","11/1/1990"},
            {"Arkista's Ring","6/1/1990"}, {"Astyanax","3/1/1990"},
            {"Back to the Future Part II & III","9/1/1990"}, {"Bad Dudes","7/1/1990"},
            {"Bad News Baseball","6/1/1990"}, {"Bandit Kings of Ancient China","12/1/1990"},
            {"Barker Bill's Trick Shooting","8/1/1990"}, {"Baseball Simulator 1.000", "3/1/1990"},
            {"Bases Loaded II: Second Season","1/1/1990"}, {"Batman","2/1/1990"},
            {"Battle Chess","7/1/1990"}, {"Battle Tank","9/1/1990"},
            {"Bible Adventures","6/12/1990"}, {"Bigfoot","7/1/1990"},
            {"Boulder Dash","6/1/1990"}, {"Burai Fighter","3/1/1990"},
            {"Cabal","6/1/1990"}, {"Captain Skyhawk","6/1/1990"},
            {"Castle of Deceit","6/12/1990"}, {"Castle of Dragon","6/1/1990"},
            {"Castlevania III: Dracula's Curse","9/1/1990"}, {"Caveman Games","10/1/1990"},
            {"Challenge of the Dragon","6/12/1990"}, {"Chiller","6/12/1990"},
            {"Chip 'n Dale: Rescue Rangers","6/1/1990"}, {"Circus Caper","7/1/1990"},
            {"Clash at Demonhead","1/1/1990"}, {"Classic Concentration","9/1/1990"},
            {"Code Name: Viper","3/1/1990"}, {"Conflict","3/1/1990"},
            {"Conquest of the Crystal Palace","11/1/1990"}, {"Crystalis","7/1/1990"},
            {"Dash Galaxy in the Alien Asylum","2/1/1990"}, {"Days of Thunder","10/1/1990"},
            {"Deathbots","6/12/1990"}, {"Déjà Vu","12/1/1990"},
            {"Demon Sword","1/1/1990"}, {"Destination Earthstar","2/1/1990"},
            {"Destiny of an Emperor","9/1/1990"}, {"Dick Tracy","8/1/1990"},
            {"Digger T. Rock: The Legend of the Lost City","12/1/1990"}, {"Dirty Harry","12/1/1990"},
            {"Double Dare","4/1/1990"}, {"Double Dragon II: The Revenge","1/1/1990"},
            {"Double Strike","6/12/1990"}, {"Dr. Mario","10/1/1990"},
            {"Dragon Spirit: The New Legend","6/1/1990"}, {"Dragon Warrior II","9/1/1990"},
            {"Dragon's Lair","12/1/1990"}, {"Dudes With Attitude","6/12/1990"},
            {"Dungeon Magic: Sword of the Elements","7/1/1990"}, {"Dusty Diamond's All-Star Softball","7/1/1990"},
            {"Dynowarz: The Destruction of Spondylus","4/1/1990"}, {"Exodus: Journey to the Promised Land","6/12/1990"},
            {"F-15 City War","6/12/1990"}, {"Final Fantasy","5/1/1990"},
            {"Fisher Price: I Can Remember","3/1/1990"}, {"Fisher Price: Perfect Fit","3/1/1990"},
            {"Formula One: Built to Win","11/1/1990"}, {"Galactic Crusader","6/12/1990"},
            {"Gauntlet II","9/1/1990"}, {"Genghis Khan","1/1/1990"},
            {"Ghostbusters II","4/1/1990"}, {"Gremlins 2: The New Batch","10/1/1990"},
            {"Heavy Barrel","3/1/1990"}, {"Heavy Shreddin'","6/1/1990"},
            {"Image Fight","7/1/1990"}, {"Impossible Mission-II","6/12/1990"},
            {"Infiltrator","1/1/1990"}, {"Ivan Ironman Stewart's Super Off Road","4/1/1990"},
            {"Jack Nicklaus' Greatest 18 Holes of Major Championship Golf","3/1/1990"}, {"Jackie Chan's Action Kung Fu","12/1/1990"},
            {"Jeopardy! 25th Anniversary Edition","6/1/1990"}, {"Jim Henson's Muppet Adventure: Chaos at the Carnival","11/1/1990"},
            {"Journey to Silius","9/1/1990"}, {"Kickle Cubicle","9/1/1990"},
            {"Kid Kool and the Quest for the Seven Wonder Herbs","3/1/1990"}, {"King Neptune's Adventure","6/12/1990"},
            {"Kings of the Beach","1/1/1990"}, {"Klax","6/12/1990"},
            {"Krazy Kreatures","6/12/1990"}, {"Little League Baseball: Championship Series","7/1/1990"},
            {"Little Nemo: The Dream Master","9/1/1990"}, {"Little Ninja Brothers","12/1/1990"},
            {"Loopz","10/1/1990"}, {"Low G Man: The Low Gravity Man","9/1/1990"},
            {"M.U.L.E.","9/1/1990"}, {"Mad Max","7/1/1990"},
            {"Magic Johnson's Fast Break","3/1/1990"}, {"Maniac Mansion","9/1/1990"},
            {"Mechanized Attack","6/1/1990"}, {"Mega Man 3","11/1/1990"},
            {"Menace Beach","6/12/1990"}, {"Mendel Palace","10/1/1990"},
            {"Michael Andretti's World Grand Prix","6/1/1990"}, {"Mission Cobra","6/12/1990"},
            {"Mission: Impossible","9/1/1990"}, {"Moon Ranger","6/12/1990"},
            {"Ms. Pac-Man","6/12/1990"}, {"NARC","8/1/1990"},
            {"NES Play Action Football","9/1/1990"}, {"Ninja Crusaders","12/1/1990"},
            {"Ninja Gaiden II: The Dark Sword of Chaos","5/1/1990"}, {"Nintendo World Championships 1990", "6/12/1990"},
            {"Nintendo World Cup","12/1/1990"}, {"North and South","12/1/1990"},
            {"Orb 3D","10/1/1990"}, {"P'radikus Conflict","6/12/1990"},
            {"Palamedes","11/1/1990"}, {"Pesterminator: The Western Exterminator","6/12/1990"},
            {"Phantom Fighter","4/1/1990"}, {"Pictionary","7/1/1990"},
            {"Pinball Quest","6/1/1990"}, {"Pinbot","4/1/1990"},
            {"Pipe Dream","9/1/1990"}, {"Punch-Out!!","8/1/1990"},
            {"Puss 'N Boots: Pero's Great Adventure","6/1/1990"}, {"Puzzle","6/12/1990"},
            {"Puzzinc","11/1/1990"}, {"R.B.I. Baseball 2","6/12/1990"},
            {"Rad Racer II","6/1/1990"}, {"Rally Bike","9/1/1990"},
            {"Remote Control","5/1/1990"}, {"Rescue: The Embassy Mission","1/1/1990"},
            {"River City Ransom","1/1/1990"}, {"RoadBlasters","1/1/1990"},
            {"Rock 'n Ball","1/1/1990"}, {"Rocket Ranger","6/1/1990"},
            {"Rollerball","2/1/1990"}, {"Rollergames","9/1/1990"},
            {"Sesame Street: Big Bird's Hide & Speak","10/1/1990"}, {"Shadow of the Ninja","12/1/1990"},
            {"Shingen the Ruler","6/1/1990"}, {"Shockwave","6/12/1990"},
            {"Silent Assault","6/12/1990"}, {"Silkworm","6/1/1990"},
            {"Silver Surfer","11/1/1990"}, {"Skate Or Die 2: The Search for Double Trouble","9/1/1990"},
            {"Skull & Crossbones","6/12/1990"}, {"Snake Rattle 'n Roll","7/1/1990"},
            {"Snake's Revenge","4/1/1990"}, {"Snoopy's Silly Sports Spectacular!","4/1/1990"},
            {"Solar Jetman: Hunt for the Golden Warpship","9/1/1990"}, {"Solstice: The Quest for the Staff of Demnos","6/1/1990"},
            {"Spot: The Video Game","9/1/1990"}, {"Starship Hector","6/1/1990"},
            {"StarTropics","12/1/1990"}, {"Street Fighter 2010: The Final Fight","9/1/1990"},
            {"Super C","4/1/1990"}, {"Super Glove Ball","10/1/1990"},
            {"Super Mario Bros. / Duck Hunt / World Class Track Meet","12/1/1990"}, {"Super Mario Bros. 3","2/1/1990"},
            {"Super Spike V'Ball","2/1/1990"}, {"Super Spike V'Ball / Nintendo World Cup","12/1/1990"},
            {"Swords and Serpents","8/1/1990"}, {"Target: Renegade","3/1/1990"},
            {"Tecmo World Wrestling","4/1/1990"}, {"Teenage Mutant Ninja Turtles II: The Arcade Game","12/1/1990"},
            {"Terra Cresta","3/1/1990"}, {"The Adventures of Gilligan's Island","7/1/1990"},
            {"The Adventures of Rad Gravity","12/1/1990"}, {"The Bugs Bunny Birthday Blowout","9/1/1990"},
            {"The Chessmaster","1/1/1990"}, {"The Immortal","11/1/1990"},
            {"The Last Starfighter","6/1/1990"}, {"The Mafat Conspiracy","6/1/1990"},
            {"The Miracle Piano Teaching System","6/12/1990"}, {"The Punisher","11/1/1990"},
            {"The Ultimate Stuntman","6/12/1990"}, {"Thunder & Lightning","12/1/1990"},
            {"Thunderbirds","9/1/1990"}, {"Tiles of Fate","6/12/1990"},
            {"Time Lord","9/1/1990"}, {"Top Gun: The Second Mission","1/1/1990"},
            {"Top Players Tennis","1/1/1990"}, {"Total Recall","8/1/1990"},
            {"Twin Cobra","1/1/1990"}, {"Ultima: Quest of the Avatar","12/1/1990"},
            {"Ultimate Basketball","9/1/1990"}, {"Vegas Dream","3/1/1990"},
            {"Wall $treet Kid","6/1/1990"}, {"WCW World Championship Wrestling","4/1/1990"},
            {"Werewolf: The Last Warrior","11/1/1990"}, {"Wheel of Fortune: Family Edition","3/1/1990"},
            {"Win, Lose or Draw","3/1/1990"}, {"Wizardry: Proving Grounds of the Mad Overlord","7/1/1990"},
            {"Wrath of the Black Manta","4/1/1990"}, {"WWF Wrestlemania Challenge","11/1/1990"},
            {"Xexyz","4/1/1990"}, {"Yo! Noid","11/1/1990"},
            {"Action 52","6/13/1990"}, {"Advanced Dungeons & Dragons: Heroes of the Lance","1/1/1991"},
            {"Adventure Island II","2/1/1991"}, {"Adventures of Lolo 3","9/1/1991"},
            {"American Gladiators","10/1/1991"}, {"Barbie","12/1/1991"},
            {"Bases Loaded 3","9/1/1991"}, {"Batman: Return of the Joker","12/1/1991"},
            {"Battletoads","6/1/1991"}, {"Beetlejuice","5/1/1991"},
            {"Big Nose the Caveman","6/13/1991"}, {"Bill & Ted's Excellent Video Game Adventure","8/1/1991"},
            {"Bill Elliott's NASCAR Challenge","4/1/1991"}, {"Bo Jackson Baseball","10/1/1991"},
            {"Captain America and the Avengers","12/1/1991"}, {"Captain Planet and the Planeteers","9/1/1991"},
            {"Castelian","6/1/1991"}, {"Conan","2/1/1991"},
            {"Cyber Stadium Series: Base Wars","6/1/1991"}, {"Darkman","10/1/1991"},
            {"Death Race","6/13/1991"}, {"Disney's TaleSpin","12/1/1991"},
            {"Double Dragon III: The Sacred Stones","2/1/1991"}, {"Eliminator Boat Duel","11/1/1991"},
            {"Family Feud","5/1/1991"}, {"Faria: A World of Mystery & Danger!","6/1/1991"},
            {"Firehawk","6/13/1991"}, {"Flight of the Intruder","5/1/1991"},
            {"Flying Warriors","2/1/1991"}, {"Fox's Peter Pan & the Pirates: The Revenge of Captain Hook","1/1/1991"},
            {"Frankenstein: The Monster Returns","7/1/1991"}, {"Fun House","1/1/1991"},
            {"G.I. Joe: A Real American Hero","1/1/1991"}, {"Galaxy 5000: Racing in the 51st Century","2/1/1991"},
            {"Gold Grand Slam","12/1/1991"}, {"Gun Nac","9/1/1991"},
            {"Harlem Globetrotters","3/1/1991"}, {"High Speed","7/1/1991"},
            {"Home Alone","10/1/1991"}, {"Ikari III: The Rescue","2/1/1991"},
            {"Indiana Jones and the Last Crusade","3/1/1991"}, {"Isolated Warrior","2/1/1991"},
            {"Kabuki Quantum Fighter","1/1/1991"}, {"Kiwi Kraze","3/1/1991"},
            {"KlashBall","7/1/1991"}, {"L'Empereur","11/1/1991"},
            {"Laser Invasion","6/1/1991"}, {"Linus Spacehead's Cosmic Crusade","6/13/1991"},
            {"Magic Darts","9/1/1991"}, {"Magician","2/1/1991"},
            {"Mermaids of Atlantis: The Riddle of the Magic Bubble","6/13/1991"}, {"Metal Mech: Man & Machine","3/1/1991"},
            {"Metal Storm","2/1/1991"}, {"Micro Machines","6/13/1991"},
            {"Monopoly","5/1/1991"}, {"Monster Truck Rally","9/1/1991"},
            {"NES Open Tournament Golf","9/1/1991"}, {"Ninja Gaiden III: The Ancient Ship of Doom","8/1/1991"},
            {"Nobunaga's Ambition II","4/1/1991"}, {"Pac-Mania","6/13/1991"},
            {"Peek A Boo Poker","6/13/1991"}, {"Pirates!","10/1/1991"},
            {"Power Blade","3/1/1991"}, {"Princess Tomato in the Salad Kingdom","2/1/1991"},
            {"Qix","1/1/1991"}, {"Quattro Adventure","6/13/1991"},
            {"Quattro Sports","6/13/1991"}, {"R.B.I. Baseball 3","6/13/1991"},
            {"Rad Racket: Deluxe Tennis II","6/13/1991"}, {"Rainbow Islands","6/1/1991"},
            {"Robin Hood: Prince of Thieves","11/1/1991"}, {"RoboCop 2","4/1/1991"},
            {"Rockin' Kats","9/1/1991"}, {"Roger Clemens' MVP Baseball","10/1/1991"},
            {"Romance of the Three Kingdoms II","9/1/1991"}, {"S.C.A.T.: Special Cybernetic Attack Team","6/1/1991"},
            {"Secret Scout in the Temple of Demise","6/13/1991"}, {"Sesame Street: ABC & 123","11/1/1991"},
            {"Shatterhand","12/1/1991"}, {"Ski or Die","2/1/1991"},
            {"Smash T.V.","9/1/1991"}, {"Snow Brothers","11/1/1991"},
            {"Space Shuttle Project","11/1/1991"}, {"Star Wars","11/1/1991"},
            {"Super Cars","2/1/1991"}, {"Super Jeopardy!","9/1/1991"},
            {"Super Sprint","8/1/1991"}, {"Tecmo Super Bowl","12/1/1991"},
            {"The Bard's Tale","11/1/1991"}, {"The Flintstones: The Rescue of Dino & Hoppy","12/1/1991"},
            {"The Hunt for Red October","1/1/1991"}, {"The King of Kings: The Early Years","6/13/1991"},
            {"The Krion Conquest","1/1/1991"}, {"The Last Ninja","2/1/1991"},
            {"The Little Mermaid","7/1/1991"}, {"The Lone Ranger","8/1/1991"},
            {"The Rocketeer","5/1/1991"}, {"The Simpsons: Bart vs. the Space Mutants","2/1/1991"},
            {"The Simpsons: Bart vs. the World","12/1/1991"}, {"The Untouchables","1/1/1991"},
            {"Times of Lore","5/1/1991"}, {"Tiny Toon Adventures","12/1/1991"},
            {"Toki","12/1/1991"}, {"Tom & Jerry: The Ultimate Game of Cat and Mouse!","12/1/1991"},
            {"Tombs & Treasure","6/1/1991"}, {"Totally Rad","3/1/1991"},
            {"Touch Down Fever","2/1/1991"}, {"Treasure Master","12/1/1991"},
            {"Trog!","10/1/1991"}, {"Uncharted Waters","11/1/1991"},
            {"Uninvited","6/1/1991"}, {"Venice Beach Volleyball","6/13/1991"},
            {"Vice: Project Doom","11/1/1991"}, {"Videomation","6/1/1991"},
            {"Wayne Gretzky Hockey","1/1/1991"}, {"Where in Time is Carmen Sandiego?","10/1/1991"},
            {"Where's Waldo?","9/1/1991"}, {"Whomp 'Em","3/1/1991"},
            {"Wolverine","10/1/1991"}, {"World Champ","4/1/1991"},
            {"Wurm: Journey to the Center of the Earth","11/1/1991"}, {"Zombie Nation","9/1/1991"},
            {"6 in 1","6/14/1991"}, {"Advanced Dungeons & Dragons: DragonStrike","7/1/1992"},
            {"Advanced Dungeons & Dragons: Pool of Radiance","4/1/1992"}, {"Adventure Island 3","9/1/1992"},
            {"Attack of the Killer Tomatoes","1/1/1992"}, {"Baseball Stars II","7/1/1992"},
            {"Bee 52","6/14/1992"}, {"Best of the Best: Championship Karate","12/1/1992"},
            {"Big Nose Freaks Out","6/14/1992"}, {"Blackjack","6/14/1992"},
            {"Bucky O'Hare","1/1/1992"}, {"Caesars Palace","12/1/1992"},
            {"Capcom's Gold Medal Challenge '92","8/1/1992"}, {"Contra Force","9/1/1992"},
            {"Cowboy Kid","1/1/1992"}, {"Crash 'n the Boys: Street Challenge","10/1/1992"},
            {"Cyberball","6/14/1992"}, {"Danny Sullivan's Indy Heat","8/1/1992"},
            {"Darkwing Duck","6/1/1992"}, {"Day Dreamin' Davey","6/1/1992"},
            {"Defenders of Dynatron City","7/1/1992"}, {"Die Hard","1/1/1992"},
            {"Dragon Fighter","1/1/1992"}, {"Dragon Warrior III","3/1/1992"},
            {"Dragon Warrior IV","10/1/1992"}, {"F-117A Stealth Fighter","12/1/1992"},
            {"F-15 Strike Eagle","2/1/1992"}, {"Felix the Cat","10/1/1992"},
            {"Ferrari Grand Prix Challenge","6/1/1992"}, {"Fisher Price: Firehouse Rescue","3/1/1992"},
            {"G.I. Joe: The Atlantis Factor","3/1/1992"}, {"Gargoyle's Quest II","10/1/1992"},
            {"Gemfire","3/1/1992"}, {"George Foreman's KO Boxing","12/1/1992"},
            {"Ghost Lion","10/1/1992"}, {"Ghoul School","3/1/1992"},
            {"Goal! Two","11/1/1992"}, {"Godzilla 2: War of the Monsters","2/1/1992"},
            {"Greg Norman's Golf Power","7/1/1992"}, {"Hatris","4/1/1992"},
            {"Home Alone 2: Lost in New York","10/1/1992"}, {"Hook","4/1/1992"},
            {"Hudson Hawk","2/1/1992"}, {"James Bond Jr.","11/1/1992"},
            {"Joe & Mac","12/1/1992"}, {"Joshua & the Battle of Jericho","6/14/1992"},
            {"KickMaster","1/1/1992"}, {"King's Quest V","6/1/1992"},
            {"Krusty's Fun House","9/1/1992"}, {"Legends of the Diamond: The Baseball Championship Game","1/1/1992"},
            {"Lemmings","11/1/1992"}, {"Little Samson","11/1/1992"},
            {"M.C. Kids","2/1/1992"}, {"Maxi 15","6/14/1992"},
            {"Mega Man 4","1/1/1992"}, {"Mega Man 5","12/1/1992"},
            {"MiG 29 Soviet Fighter","6/14/1992"}, {"Might & Magic: Secret of the Inner Sanctum","8/1/1992"},
            {"Monster in My Pocket","1/1/1992"}, {"Motor City Patrol","1/1/1992"},
            {"Nightshade","1/1/1992"}, {"Operation: Secret Storm","6/14/1992"},
            {"Panic Restaurant","10/1/1992"}, {"Paperboy 2","4/1/1992"},
            {"Power Blade 2","10/1/1992"}, {"Power Punch II","6/1/1992"},
            {"Prince of Persia","11/1/1992"}, {"Pyramid","6/14/1992"},
            {"Quattro Arcade","6/14/1992"}, {"R.C. Pro-Am II","12/1/1992"},
            {"Race America","5/1/1992"}, {"Rampart","1/1/1992"},
            {"RoboCop 3","8/1/1992"}, {"Roundball 2-on-2 Challenge","5/1/1992"},
            {"Sesame Street: Countdown","2/1/1992"}, {"Solitaire","6/14/1992"},
            {"Spider-Man: Return of the Sinister Six","10/1/1992"}, {"Spiritual Warfare","6/14/1992"},
            {"Stanley: The Search for Dr. Livingston","10/1/1992"}, {"Star Trek: 25th Anniversary","2/1/1992"},
            {"Star Wars: The Empire Strikes Back","3/1/1992"}, {"Stunt Kids","6/14/1992"},
            {"Super Spy Hunter","2/1/1992"}, {"Swamp Thing","12/1/1992"},
            {"Sword Master","1/1/1992"}, {"T&C Surf Designs: Thrilla's Surfari","3/1/1992"},
            {"Tecmo Cup Soccer Game","9/1/1992"}, {"Tecmo NBA Basketball","11/1/1992"},
            {"Teenage Mutant Ninja Turtles III: The Manhattan Project","2/1/1992"}, {"Terminator 2: Judgment Day","2/1/1992"},
            {"The Addams Family","1/1/1992"}, {"The Adventures of Rocky and Bullwinkle and Friends","12/1/1992"},
            {"The Blue Marlin","7/1/1992"}, {"The Blues Brothers","9/1/1992"},
            {"The Great Waldo Search","12/1/1992"}, {"The Jetsons: Cogswell's Caper!","12/1/1992"},
            {"The Mutant Virus: Crisis in a Computer World","4/1/1992"}, {"The Simpsons: Bartman Meets Radioactive Man","12/1/1992"},
            {"The Terminator","12/1/1992"}, {"The Young Indiana Jones Chronicles","12/1/1992"},
            {"Tiny Toon Adventures: Cartoon Workshop","12/1/1992"}, {"Toxic Crusaders","4/1/1992"},
            {"Ultimate Air Combat","4/1/1992"}, {"Ultimate League Soccer","6/14/1992"},
            {"Wacky Races","5/1/1992"}, {"Wally Bear and the NO! Gang","6/14/1992"},
            {"Wheel of Fortune: Featuring Vanna White","1/1/1992"}, {"Widget","11/1/1992"},
            {"Wizardry: Knight of Diamonds - The Second Scenario","4/1/1992"}, {"Wizards & Warriors III: Kuros: Visions of Power","3/1/1992"},
            {"WWF WrestleMania: Steel Cage Challenge","9/1/1992"}, {"Yoshi","6/1/1992"},
            {"Advanced Dungeons & Dragons: Hillsfar","2/1/1993"}, {"Alien³","3/1/1993"},
            {"Bases Loaded 4","4/1/1993"}, {"Batman Returns","1/1/1993"},
            {"Battleship","9/1/1993"}, {"Battletoads & Double Dragon","6/1/1993"},
            {"Bible Buffet","6/15/1993"}, {"Bomberman II","2/1/1993"},
            {"Bram Stoker's Dracula","9/1/1993"}, {"Break Time: The National Pool Tour","1/1/1993"},
            {"Bubble Bobble Part 2","8/1/1993"}, {"Casino Kid II","4/1/1993"},
            {"Championship Pool","10/1/1993"}, {"Cheetahmen II","6/15/1993"},
            {"Cliffhanger","11/1/1993"}, {"Color a Dinosaur","7/1/1993"},
            {"Cool World","6/1/1993"}, {"Dizzy the Adventurer","6/15/1993"},
            {"DuckTales 2","6/1/1993"}, {"Fire 'N Ice","3/1/1993"},
            {"Indiana Jones and the Last Crusade","12/1/1993"}, {"Jimmy Connors Tennis","11/1/1993"},
            {"Jurassic Park","6/1/1993"}, {"Kid Klown in Night Mayor World","4/1/1993"},
            {"Kirby's Adventure","5/1/1993"}, {"Last Action Hero","10/1/1993"},
            {"Lethal Weapon","4/1/1993"}, {"Mario Is Missing!","7/1/1993"},
            {"Mickey's Safari in Letterland","3/1/1993"}, {"Mighty Final Fight","7/1/1993"},
            {"Ms. Pac-Man","11/1/1993"}, {"Nigel Mansell's World Championship Racing","10/1/1993"},
            {"Overlord","1/1/1993"}, {"Pac-Man","11/1/1993"},
            {"Pro Sport Hockey","11/1/1993"}, {"Rollerblade Racer","2/1/1993"},
            {"Star Trek: The Next Generation","9/1/1993"}, {"Tetris 2","10/1/1993"},
            {"The Addams Family: Pugsley's Scavenger Hunt","8/1/1993"}, {"The Fantastic Adventures of Dizzy","6/15/1993"},
            {"The Ren & Stimpy Show: Buckaroo$!","11/1/1993"}, {"Tiny Toon Adventures 2: Trouble in Wackyland","4/1/1993"},
            {"Ultima: Warriors of Destiny","1/1/1993"}, {"Wayne's World","11/1/1993"},
            {"WWF King of the Ring","11/1/1993"}, {"Yoshi's Cookie","4/1/1993"},
            {"Zen: Intergalactic Ninja","3/1/1993"}, {"Bonk's Adventure","1/1/1994"},
            {"Chip 'n Dale: Rescue Rangers 2","1/1/1994"}, {"Alfred Chicken","2/1/1994"},
            {"Teenage Mutant Ninja Turtles: Tournament Fighters","2/1/1994"}, {"Mega Man 6","3/1/1994"},
            {"Mickey's Adventure in Numberland","3/1/1994"}, {"Zoda's Revenge: StarTropics II","3/1/1994"},
            {"Mario's Time Machine","6/1/1994"}, {"The Jungle Book","8/1/1994"},
            {"The Flintstones: The Surprise at Dinosaur Peak!","8/1/1994"}, {"The Incredible Crash Dummies","8/1/1994"},
            {"Wario's Woods","12/1/1994"}, {"Trolls on Treasure Island (Unlicensed)","6/16/1994"},
            {"Sunday Funday: The Ride (unlicensed)","6/17/1994"} };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        context = getApplicationContext();

        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout1);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);

        recylerViewLayoutManager = new LinearLayoutManager(context);

        recyclerView.setLayoutManager(recylerViewLayoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(context, subjects);

        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
