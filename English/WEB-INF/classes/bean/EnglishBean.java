package bean;

import java.io.*;
import java.util.*;

public class EnglishBean implements Serializable {
    private static int count;
    private static int count_max;// 現在何個まで出題したかを返す変数
    private static int max;// ファイルの最大値
    private static String word;// 単語をを示す
    private static Map<Integer, String> map;// key(integer)によって問題が表示
    private static Set<Integer> set;// 出題されていない問題番号を管理
    public static Random random = new Random();// ランダム

    public EnglishBean() {// インスタンス
        count = 0;
        count_max = 0;
        try {
            map = new HashMap<>();
            set = new HashSet<>();
            File file = new File("C:\\xampp\\tomcat\\webapps\\English\\word.txt");// 読み込む問題ファイル(絶対パス)
            FileReader filereader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(filereader);
            ///////////////////////////////// ファイルの内容を読み込む
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                if (!s.equals("")) {
                    map.put(count, s);// sはString
                    set.add(count);// vountはinteger
                    count++;
                }
            } // ファイルの 内容を格納
            max = count;
            try {
                File correctFile = new File("C:\\xampp\\tomcat\\webapps\\Correct.txt");// 正しい回答を保存するtxtファイル(絶対パス)
                File incorrectFile = new File("C:\\xampp\\tomcat\\webapps\\Incorrect.txt");// 正しくない解答を保存するtxtファイル(絶対パス)
                correctFile.createNewFile();
                incorrectFile.createNewFile();// createNewFile()でファイル作成
                FileWriter fw = new FileWriter(correctFile, false);// 上書き用にWriterを宣言
                PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
                pw.print("");// ファイルの上書き
                pw.close();// ファイルを閉じる
                FileWriter fw_i = new FileWriter(incorrectFile, false);// 上書き用にWriterを宣言(追記したいならfalseをtrueに)
                PrintWriter pw_i = new PrintWriter(new BufferedWriter(fw_i));
                pw.print("");// ファイルの上書き
                pw.close();// ファイルを閉じる

            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace(); // エラー出力
        }
    }

    public void Classify_Correct(String str) {// 正しい回答に分類
        try {
            FileWriter fw = new FileWriter("C:\\xampp\\tomcat\\webapps\\Correct.txt", true);// ファイルの追記をするためにfilewriterを宣言（true)
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
            pw.println(str);// 正しい回答に属する単語をファイルに追記
            pw.close();
        } catch (Exception e) {
        }
    }

    public void Classify_Incorrect(String str) {// 正しくない回答に分類
        try {
            FileWriter fw = new FileWriter("C:\\xampp\\tomcat\\webapps\\Incorrect.txt", true);// ファイルの追記をするためにfilewriterを宣言（true)
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
            pw.println(str);// 正しくない回答に属する単語をファイルに追記
            pw.close();
        } catch (Exception e) {
        }
    }

    public String WriteContent() {// ランダムで表示する単語を持ってくる
        String r;
        int rand = random.nextInt(count);// ランダムな値を生成
        while (!set.contains(rand)) {
            rand = random.nextInt(count);// 前に出題された問題と重複しないように重複しなくなるまでランダムな値を生成
        }
        set.remove(rand);// setから削除
        r = map.get(rand);// 問題を抽出
        map.remove(rand);// 問題として出したので削除
        return r;// 問題の元となる文を返す
    }

    public void Write_Content(String r) {// 現在の問題について、その内容を一端別のファイルに保存しておく
        try {
            File file = new File("C:\\xampp\\tomcat\\webapps\\Write_File.txt");// 保存するファイルを絶対パスで指定
            file.createNewFile();// ファイル作成
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
            pw.println(r);// 実際に書き込む
            pw.close(); // 入力を終了する。
            count_max++;// 現在扱っている問題の番号をインクリメント
        } catch (Exception e) {
        }
    }

    public boolean CheckMax() {// すべての問題を出題し終わったかを返す
        if (max == count_max) {// (set.isEmpty()でも良いかも)
            return true;// 出題し終わった
        }
        return false;// まだ余りあり
    }

    public int getCount() {// 問題の番号を返す
        return count_max;
    }

    public int getMax() {// 問題の数を返す
        return max;
    }

    public String getWord() {// 問題の単語を返す
        return word;
    }

    public void setWord(String word) {// 問題の単語を設定
        this.word = word;
    }

    public void setCount(int count_max) {// 現在の問題を設定
        this.count_max = count_max;
    }
}
