package com.example.gj.gj2016;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    static String sampleInput = "\n" +
            "\t\t\t    \n" +
            "\t\t            <tr class=\"\">\n" +
            "                        <td id=\"cphContainer_cphContents_rptGameList_tdGameDate_0\" class=\"day\" rowspan=\"5\"><a href=\"../ScoreBoard/ScoreBoard.aspx?gameDate=20160901\"><span id=\"cphContainer_cphContents_rptGameList_lblGameDate_0\">09.01(목)</span></a></td>\n" +
            "\t\n" +
            "                        <td class=\"time\">18:30</td>\n" +
            "                        \n" +
            "                        <td class=\"play\"><span>SK</span> <em><span class=\"lose\">2</span><span>vs</span><span class=\"win\">8</span></em> <span>넥센</span></td>\n" +
            "                        <td class=\"relay\">\n" +
            "                            <a href='../Game/BoxScore.aspx?leagueId=1&seriesId=0&gameId=20160901SKWO0&gyear=2016'><img src=\"http://image.koreabaseball.com/client/images/schedule/btn_record.jpg\" alt=\"경기기록\"></a>\n" +
            "\t\t\t            </td>\n" +
            "\t\t\t            <td class=\"tv\">KN-T</td>\n" +
            "\t\t\t            <td class=\"radio\"></td>\n" +
            "\t\t\t            <td class=\"ballpark\">고척</td>\n" +
            "\t\t\t            <td class=\"etc\">-</td>\n" +
            "\t\t            </tr>\n" +
            "                \n" +
            "\t\t            <tr class=\"\">\n" +
            "                        \n" +
            "                        <td class=\"time\">18:30</td>\n" +
            "                        \n" +
            "                        <td class=\"play\"><span>kt</span> <em><span class=\"lose\">0</span><span>vs</span><span class=\"win\">1</span></em> <span>두산</span></td>\n" +
            "                        <td class=\"relay\">\n" +
            "                            <a href='../Game/BoxScore.aspx?leagueId=1&seriesId=0&gameId=20160901KTOB0&gyear=2016'><img src=\"http://image.koreabaseball.com/client/images/schedule/btn_record.jpg\" alt=\"경기기록\"></a>\n" +
            "\t\t\t            </td>\n" +
            "\t\t\t            <td class=\"tv\">SPO-T</td>\n" +
            "\t\t\t            <td class=\"radio\"></td>\n" +
            "\t\t\t            <td class=\"ballpark\">잠실</td>\n" +
            "\t\t\t            <td class=\"etc\">-</td>\n" +
            "\t\t            </tr>\n" +
            "                \n" +
            "\t\t            <tr class=\"\">\n" +
            "                        \n" +
            "                        <td class=\"time\">18:30</td>\n" +
            "                        \n" +
            "                        <td class=\"play\"><span>LG</span> <em><span class=\"win\">7</span><span>vs</span><span class=\"lose\">2</span></em> <span>한화</span></td>\n" +
            "                        <td class=\"relay\">\n" +
            "                            <a href='../Game/BoxScore.aspx?leagueId=1&seriesId=0&gameId=20160901LGHH0&gyear=2016'><img src=\"http://image.koreabaseball.com/client/images/schedule/btn_record.jpg\" alt=\"경기기록\"></a>\n" +
            "\t\t\t            </td>\n" +
            "\t\t\t            <td class=\"tv\">SKY-T<br />D-CMB</td>\n" +
            "\t\t\t            <td class=\"radio\">TJ-R<br />TM-R<br />DK-R</td>\n" +
            "\t\t\t            <td class=\"ballpark\">대전</td>\n" +
            "\t\t\t            <td class=\"etc\">-</td>\n" +
            "\t\t            </tr>\n" +
            "                \n" +
            "\t\t            <tr class=\"\">\n" +
            "                        \n" +
            "                        <td class=\"time\">18:30</td>\n" +
            "                        \n" +
            "                        <td class=\"play\"><span>KIA</span> <em><span class=\"win\">16</span><span>vs</span><span class=\"lose\">8</span></em> <span>삼성</span></td>\n" +
            "                        <td class=\"relay\">\n" +
            "                            <a href='../Game/BoxScore.aspx?leagueId=1&seriesId=0&gameId=20160901HTSS0&gyear=2016'><img src=\"http://image.koreabaseball.com/client/images/schedule/btn_record.jpg\" alt=\"경기기록\"></a>\n" +
            "\t\t\t            </td>\n" +
            "\t\t\t            <td class=\"tv\">SS-T</td>\n" +
            "\t\t\t            <td class=\"radio\">T-R<br />DM-R</td>\n" +
            "\t\t\t            <td class=\"ballpark\">대구</td>\n" +
            "\t\t\t            <td class=\"etc\">-</td>\n" +
            "\t\t            </tr>\n" +
            "                \n" +
            "\t\t            <tr class=\"\">\n" +
            "                        \n" +
            "                        <td class=\"time\">18:30</td>\n" +
            "                        \n" +
            "                        <td class=\"play\"><span>NC</span> <em><span class=\"win\">4</span><span>vs</span><span class=\"lose\">2</span></em> <span>롯데</span></td>\n" +
            "                        <td class=\"relay\">\n" +
            "                            <a href='../Game/BoxScore.aspx?leagueId=1&seriesId=0&gameId=20160901NCLT0&gyear=2016'><img src=\"http://image.koreabaseball.com/client/images/schedule/btn_record.jpg\" alt=\"경기기록\"></a>\n" +
            "\t\t\t            </td>\n" +
            "\t\t\t            <td class=\"tv\">MS-T</td>\n" +
            "\t\t\t            <td class=\"radio\">KNN-R<br />PM-R</td>\n" +
            "\t\t\t            <td class=\"ballpark\">사직</td>\n" +
            "\t\t\t            <td class=\"etc\">-</td>\n" +
            "\t\t            </tr>\n" +
            "                \n" +
            "\t\t            <tr class=\"\">\n" +
            "                        <td id=\"cphContainer_cphContents_rptGameList_tdGameDate_5\" class=\"day\" rowspan=\"5\"><a href=\"../ScoreBoard/ScoreBoard.aspx?gameDate=20160902\"><span id=\"cphContainer_cphContents_rptGameList_lblGameDate_5\">09.02(금)</span></a></td>\n" +
            "\t\n" +
            "                        <td class=\"time\">18:30</td>\n" +
            "                        \n" +
            "                        <td class=\"play\"><span>SK</span> <em><span class=\"lose\">9</span><span>vs</span><span class=\"win\">10</span></em> <span>넥센</span></td>\n" +
            "                        <td class=\"relay\">\n" +
            "                            <a href='../Game/BoxScore.aspx?leagueId=1&seriesId=0&gameId=20160902SKWO0&gyear=2016'><img src=\"http://image.koreabaseball.com/client/images/schedule/btn_record.jpg\" alt=\"경기기록\"></a>\n" +
            "\t\t\t            </td>\n" +
            "\t\t\t            <td class=\"tv\">KN-T</td>\n" +
            "\t\t\t            <td class=\"radio\"></td>\n" +
            "\t\t\t            <td class=\"ballpark\">고척</td>\n" +
            "\t\t\t            <td class=\"etc\">-</td>\n" +
            "\t\t            </tr>\n" +
            "                \n" +
            "\t\t            <tr class=\"\">\n" +
            "                        \n" +
            "                        <td class=\"time\">18:30</td>\n" +
            "                        \n" +
            "                        <td class=\"play\"><span>kt</span> <em><span class=\"lose\">5</span><span>vs</span><span class=\"win\">6</span></em> <span>두산</span></td>\n" +
            "                        <td class=\"relay\">\n" +
            "                            <a href='../Game/BoxScore.aspx?leagueId=1&seriesId=0&gameId=20160902KTOB0&gyear=2016'><img src=\"http://image.koreabaseball.com/client/images/schedule/btn_record.jpg\" alt=\"경기기록\"></a>\n" +
            "\t\t\t            </td>\n" +
            "\t\t\t            <td class=\"tv\">SPO-T</td>\n" +
            "\t\t\t            <td class=\"radio\"></td>\n" +
            "\t\t\t            <td class=\"ballpark\">잠실</td>\n" +
            "\t\t\t            <td class=\"etc\">-</td>\n" +
            "\t\t            </tr>\n" +
            "                \n" +
            "\t\t            <tr class=\"\">\n" +
            "                        \n" +
            "                        <td class=\"time\">18:30</td>\n" +
            "                        \n" +
            "                        <td class=\"play\"><span>LG</span> <em><span class=\"lose\">6</span><span>vs</span><span class=\"win\">11</span></em> <span>한화</span></td>\n" +
            "                        <td class=\"relay\">\n" +
            "                            <a href='../Game/BoxScore.aspx?leagueId=1&seriesId=0&gameId=20160902LGHH0&gyear=2016'><img src=\"http://image.koreabaseball.com/client/images/schedule/btn_record.jpg\" alt=\"경기기록\"></a>\n" +
            "\t\t\t            </td>\n" +
            "\t\t\t            <td class=\"tv\">SKY-T<br />D-CMB</td>\n" +
            "\t\t\t            <td class=\"radio\">TJ-R<br />TM-R<br />DK-R</td>\n" +
            "\t\t\t            <td class=\"ballpark\">대전</td>\n" +
            "\t\t\t            <td class=\"etc\">-</td>\n" +
            "\t\t            </tr>\n" +
            "                \n" +
            "\t\t            <tr class=\"\">\n" +
            "                        \n" +
            "                        <td class=\"time\">18:30</td>\n" +
            "                        \n" +
            "                        <td class=\"play\"><span>KIA</span> <em><span>vs</span></em> <span>삼성</span></td>\n" +
            "                        <td class=\"relay\">\n";


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


        Pattern pattern;


    }

    static protected void parseData(String TeamA, String TeamB) {

        Pattern p = Pattern.compile("KIA<\\/span> <em><span class=\"(win)|(lose)\">[0-9]+<\\/span><span>vs<\\/span><span class=\"(.*)\">[0-9]+<\\/span><\\/em> <span>삼성<\\/span><\\/td>\n");

        //, Pattern.DOTALL);

        //Pattern p = Pattern.compile("(?s)<!\\[CDATA\\[(.*)\\]\\]>");

        Matcher matcher = p.matcher(sampleInput);

        if (matcher.find()) {
            Log.e("test", "match");
            Log.e("test", matcher.group(1));
        } else {
            Log.e("test", "not match");
        }
        // result_Team_A =
        // result_Team_B =

    }

    static protected boolean setConnect(String _url) {



        return true;
    }
}
