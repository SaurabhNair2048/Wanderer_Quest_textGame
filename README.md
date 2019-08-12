# Wanderer_Quest_textGame
A java console based text game.
============================================================================

The game was created for java jre1.8.0_221.
It was created in Eclipse Neon 3 IDE.

Its a simple game with the following steps on compiling and running the game:
A) First we create the character:
1.  Enter character name
2.  Enter character gender (Acceptable inputs: "male" or "female")
3.  Enter character class (Acceptable inputs: "warrior" or "mage")
4.  Enter character race (Acceptable inputs: "dwarves", "humans", "elves" or "orcs")

B) Once the character is created the game starts:
1.  Enter a command for the character (Acceptable inputs: "move to", "use coins" or "quit")
2.  "Move to" command is used to move to a location in x,y coordinates.
    a. After the "move to" command it asks for x and y values, which is the displacement or distance the character
      needs to move in the x and y direction
    b. On reaching the destination, if a monster spawns, you will be asked if you want to battle it.
    c. Inputs can be "yes" or "no"
    d. If entered "yes", based on the character stats and monster stats, auto battle takes place and result is displayed.
    e. On defeating monster exp is gained which raises character level and for each level you get coins.
    f. This coins can be used to improve the stats of the character.
    g. You can decide if you want to use coins now or later.
3.  "Use coins" command can be used if the user wants to use the coins later.
4.  "Quit" command can be used to quit the game.

NOTE:  All inputs are case insensitive
       Each character has a unique stat based on the male/female, race and warrior/mage.
       Also each character has a unique special attack which affects the monster differently.
