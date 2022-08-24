//package com.company;

public class Acts {
    public static String[] locations = {"Mudwood", "Mudwood", "Castlemouth"};
    public static String startingText = "Gatholla Kingdom, biggest continent of Planet Enukha...\n" +
            "Three different kinds live inside Gatholla: Humans, Orcs and Wizards.\n" +
            "Gathollans mainly used to live on three major cities: \n" +
            "Castlemouth; the glorious city of humans located in the middle of Gatholla: \n" +
            "Winddale; A large wizard community above the clouds, highest point of the Mountain Smiheim which is " +
            "located at the north of Gatholla,\n" + "And Mudwood, a mysterious town of orcs deep inside the " +
            "Forest Arnguay.\n" +
            "Everything was going well for Gathollans, until the corruption started.";

    public static String act1_a = "Knight Ademar... You won that title after joining to the expedition force of " +
            "Castlemouth.\nIt was all you dreamed about after all.\nBut now that you are actually a true knight\n" +
            "your journey begins...";

    public static String act1_b = "Sorcerer Adius... He was raised without parents because they died while protecting\n" +
            "the city from the ancient dragon Uldroar that lies deep inside the Mountain Smiheim. Their sacrifice\n" +
            "saved the Winddale and they became the heroes of wizard communtiy. Although Adius had no parents\n" +
            "growing up, the other wizards became his family. They helped him with anything he had troubled with\n" +
            "He was as skillful as his parents, which meant great hope for wizards...";

    public static String act1_c = "Tribe chief's son, Xruul. After proving yourself as a future chief to your tribe\n" +
            "countless times, it was inevitable that you'd become the chief in command one day. Your father,\n" +
            "Xago the Tribe" +
            "Chief, has ruled the tribe for 20 years now, and since you have been helping him the day you were born\n" +
            "you understand what being a true commander to your people means...";

    public static String act1(Player player) {
        String act1_1 = "You were at the training fields when everything started. While you were training,\n" +
                "you heard that people were yelling in panic in the distance.\n" +
                "You immediately rushed back to the city hall... Once you reached to\n" +
                "the crowd, you noticed a dead man lying down on a horse, with a piece of parchment attached to him.\n" +
                "While guards were trying to maintain the panic caused by this figure, You reached out to the\n" +
                "parchment and started reading: \"" + locations[player.tribeCount - 1] +
                " has been attacked by a horde of corrupted " +
                "creatures\n. Please send your finest warriors and help us\". And thus you started travelling to\n" +
                "your destination\n" +
                "After travelling through the dense woods of Arnguay Forest, you've finally reached your destination,\n"
                + locations[player.tribeCount - 1] + ". This is madness... Everyone... has been corrupted!\n" +
                "Their eyes were all dark purple. You and your mates started battling with them. You must reach to\n" +
                "the center of the city but there's one corrupted creature is standing in front of you, like it is\n" +
                "challenging you to a duel.";
        return act1_1;
    }
    public static String act2() {
        String act2_1 = "You've beaten the creature and move onwards... It faintly said \"Please help us\" before\n" +
                "passing away. This must be doomsday. You've reached to gates of the palace. Someone's guarding the\n" +
                "gates. You must battle with him";
        return act2_1;
    }

    public static String act3() {
        String act3_1 = "You have finally beaten the guardian of the gates. As you were about to enter the palace,\n" +
                "the guardian holds your leg. He whispers something, you can't quite hear so you get close to him.\n" +
                "He says that he's sorry, and there's a way to fix all of this." +
                "He then lets your leg go and collapses to the ground.\n" +
                "You rush inside of the palace. You see the Devil is sitting at King's throne. As you enter the door,\n" +
                "everything went dark. He talks about how he is about to rule Gatholla, now that he has corrupted\n" +
                "one tribe, it is easier to corrupt the other two. He complains about how easy and boring it was, so\n" +
                "he's giving you an option. A duel... If devil wins, he is going to corrupt everyone on Gatholla,\n" +
                "if you win, he's going to give you an artifact called Oblivion Amulet which cures all corruption\n" +
                "done to Gatholla... You have no choice but to fight the devil";
        return act3_1;
    }
    public static String finalAct() {
        String finalAct1 = "You've successfully beaten the devil. He looks at you in shock, he still can't believe\n" +
                "he lost to a mortal. He says that you've beaten him fair and square, so he will reward you with\n" +
                "Oblivion Amulet. He says that it is his choice to either save the Gatholla, or leave it be.\n" +
                "Which one do you choose?";
        return finalAct1;
    }

}