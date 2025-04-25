package bean;

import java.io.*;
import java.util.*;

public class AnswerBean implements Serializable {
    private static ArrayList<String> list = new ArrayList<>();//ファイルの内容を格納するリスト
    private static String YourAnswer;//ユーザの回答を格納
    private static String CorrectAnswer;//正しい回答を格納

    public AnswerBean() {
        try {
            File file = new File("C:\\xampp\\tomcat\\webapps\\Write_File.txt");//問題文を入れているファイルを指定
            FileReader filereader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(filereader);
            String s;
            if(!list.isEmpty()){
                list.clear();//念のためにリストをクリア
            }
            while ((s = bufferedReader.readLine()) != null) {
                list.add(s);
            }//リストに問題を入れる
            file.delete();//ファイルの削除
        } catch (Exception e) {
        }
    }

    public String getYourAnswer() {//ユーザの回答を獲得
        return YourAnswer;
    }

    public String getCorrectAnswer() {//正しい答えを獲得
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals("")) {
                CorrectAnswer = list.get(i);//正しい答えが格納されていたらそれをCorrectAnswerに格納
                break;
            }
        }
        return CorrectAnswer;
    }

    public String getWord() {//問題の単語を獲得
        String w = "";
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals("")) {
                w = list.get(i);//問題の文を獲得
                break;
            }
        }
        String word[] = w.split(" ");//" "で分ける
        return word[0];//単語を獲得
    }

    public void setYourAnswer(String YourAnswer) {//ユーザの回答を設定
        this.YourAnswer = YourAnswer;
    }

}