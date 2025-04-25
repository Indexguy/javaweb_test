package bean;

import java.io.*;
import java.util.*;

public class ViewBean implements Serializable {

    private static ArrayList<String> list = new ArrayList<>();// 一覧表示する単語を格納するリスト

    public ViewBean() {// インスタンス
    }

    public String getCorrectList() {// 正解の回答をリストに入れる＆正解の回答の単語リストを返す
        list.clear();// 一応リストをクリア
        try {
            FileReader filereader = new FileReader("C:\\xampp\\tomcat\\webapps\\Correct.txt");// 正解の単語が格納されているファイルのパスを絶対参照
            BufferedReader bufferedReader = new BufferedReader(filereader);// ファイルの内容を読み込む
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                list.add(s);// リストに正解の単語を格納
            }
        } catch (Exception e) {
        }
        String response = "";
        for (int i = 0; i < list.size(); i++) {
            response += list.get(i) + "\n";// responseに正解の単語を加えていく
        }
        return response;// 正解の単語一覧を返す
    }

    public String getIncorrectList() {// 不正解の回答をリストに入れる＆不正解の回答の単語リストを返す
        list.clear();// 念のためリストをクリア
        try {
            FileReader filereader = new FileReader("C:\\xampp\\tomcat\\webapps\\Incorrect.txt");// 不正解の単語が格納されているファイルのパスを絶対参照
            BufferedReader bufferedReader = new BufferedReader(filereader);// ファイルの内容を読み込む
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                list.add(s);// リスtに不正解の単語を格納
            }
        } catch (Exception e) {
        }
        String response = "";
        for (int i = 0; i < list.size(); i++) {
            response += "\n" + list.get(i) + "\n";// responseに不正解の単語を加えていく
        }
        return response;// 不正解の単語一覧を返す

    }

}