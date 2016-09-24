package com.example.gj.gj2016;

import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.transform.Source;

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
    static Source source;
//    TextView textView;  // 제목을 표시해줄 텍스트뷰
    private static Thread thread = null;
    static String parsing_url;  // 파싱해오고자 하는 URL
    static String get_data;  // 파싱해서 가져온 데이터를 저장할 스트링 변수
//    ArrayList<String> array;  // get_data 변수의 값을 순차적으로 저장할 배열


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

        Matcher matcher = p.matcher(get_data);

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

//        URL = new URL(_url);
//        InputStream html = URL.openStream();
//        source = new Source(new InputStreamReader(html, "utf-8")); //소스를 UTF-8 인코딩으로 불러온다.
//        source.fullSequentialParse();

        return true;
    }
}
