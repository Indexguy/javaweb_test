import bean.AnswerBean;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//beanのところは任意のbeanファイルの名前を

@WebServlet("/Answer")

public class Answer extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");// ここまで決まり文句
        // contentとsubmit
        String content = req.getParameter("content");// ここでjspから受け取るcontentはユーザから受け取る回答
        AnswerBean ab = new AnswerBean();// インスタンス変数の宣言
        String word = ab.getWord();// 単語の取得
        ab.setYourAnswer(word + " " + content);// 答えのフォーマットを問題文のフォーマットに合わせる
        req.setAttribute("ab", ab);// Attributeに設定
        RequestDispatcher rd = req.getRequestDispatcher("/Answer.jsp");
        rd.forward(req, res);// Answer.jspにフォワード
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        doPost(req, res);
    }//Getの場合（決まり文句）
}
