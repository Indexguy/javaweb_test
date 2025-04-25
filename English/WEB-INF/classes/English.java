import bean.EnglishBean;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//beanのところは任意のbeanファイルの名前を

@WebServlet("/English") // 受け取り方を指定

public class English extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");// ここまで大体が決まり文句
        HttpSession session = req.getSession(true);
        @SuppressWarnings("unchecked") // セッションにおける決まり文句
        EnglishBean eb = (EnglishBean) session.getAttribute("eb");// セッションでインスタンス変数を作成
        if (eb == null || req.getParameter("result") == null) {
            eb = new EnglishBean();// インスタンス変数がnullもしくは最初の送信からの最初の画面から遷移した場合にインスタンス変数の宣言
        } else {
            String result = req.getParameter("result");// resultは回答が正しいか正しくないかが入る
            String word = eb.getWord();// 問題の元となる一文を得る
            if (result.equals("Yes")) {// 正解の場合
                eb.Classify_Correct(word);// 正解のファイルに追記
            } else {
                eb.Classify_Incorrect(word);// 不正解のファイルに追記
            }
        }
        if (eb.CheckMax()) {// 問題がすべて出題された時
            req.setAttribute("eb", eb);// Attributeを設定
            RequestDispatcher rd = req.getRequestDispatcher("/result.jsp");
            rd.forward(req, res);// result.jspにフォワードする
        } else {
            String word = eb.WriteContent();// 問題の文を得る
            eb.Write_Content(word);// 一端ファイルに問題を書き込み
            String word_str[] = word.split(" ");// 問題文を分割
            eb.setWord(word_str[0]);// 問題となる単語を設定
            req.setAttribute("eb", eb);// Attributeに設定
            RequestDispatcher rd = req.getRequestDispatcher("/English.jsp");
            rd.forward(req, res);// English.jspにフォワード
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        doPost(req, res);
    }// GEt送信の場合（決まり文句）
}
