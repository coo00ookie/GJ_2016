package com.example.gj.gj2016;

/**
 * Created by Jee on 2016. 9. 24..
 */

enum result {
    win, draw, lose
}

public class getMatchInformation {

    static int result_Team_A;
    static int result_Team_B;
    static int todayDate;

    static public result getResult(String TeamA, String TeamB) {

        setConnect("http://www.koreabaseball.com/Schedule/GameList/General.aspx");
        // if TeamA win return True
        // if TeamB win return False



        parseData(TeamA, TeamB);

        if (result_Team_A > result_Team_B) {
            return result.win;
        }
        else if(result_Team_A == result_Team_B) {
            return result.draw;
        }
        else {
            return result.lose;
        }

    }

    static protected void parseData(int Date) {

    }

    static protected void parseData(String TeamA, String TeamB) {

        // result_Team_A =
        // result_Team_B =

    }

    static protected boolean setConnect(String _url) {



        return true;
    }
}
