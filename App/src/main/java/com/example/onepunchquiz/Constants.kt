package com.example.onepunchquiz

object Constants {

    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1=Question(
            1,"Who is this character?",
            R.drawable.saitama,"Saitama","Hagemanto","Genos","One Punch",1
        )
        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "Who is this character?",
            R.drawable.bang,
            "Kamikaze", "Sliver Fang",
            "Bang", "King", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "Who is this character?",
            R.drawable.boros,
            "Sonic", "Alien",
            "Garous", "Boros", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "Who is this character?",
            R.drawable.fubuki,
            "Mosquito Girl", "Fubuki",
            "Blizzard", "Tatsumaki", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "Who is this character?",
            R.drawable.metalbat,
            "Butcher", "Needlestar",
            "Metal Bat", "Captain Mizuki", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "Who is this character?",
            R.drawable.mumen_rider,
            "Mumen Rider", "Captain Mizuki",
            "Nobody", "Pick", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "Who is this character?",
            R.drawable.watchdogman,
            "Metal Bat", "Zombie man",
            "Watchdog man", "Hagemanto", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "Who is this character?",
            R.drawable.tatsumaki,
            "Senritsu", "Blizzard",
            "Fubuki", "Tatsumaki", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "Who is this character?",
            R.drawable.zombieman,
            "Watchdog man", "Zombie man",
            "Fubuki", "Hagemanto", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "Who is this character?",
            R.drawable.garou,
            "Garou", "Bang",
            "Wolf", "Genos", 1
        )

        questionsList.add(que10)
        return questionsList
    }
}