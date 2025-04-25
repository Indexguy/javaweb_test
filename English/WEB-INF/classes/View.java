import bean.ViewBean;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//beanのところは任意のbeanファイルの名前を

@WebServlet("/View") // 受け取り方を指定

public class View extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");// ここまで決まり文句
        ViewBean vb = new ViewBean();// インスタンス変数の宣言
        req.setAttribute("vb", vb);// Attributeに設定
        if (req.getParameter("result").equals("result_Yes")) {// 正解の回答を表示するとき
            RequestDispatcher rd = req.getRequestDispatcher("/View_Correct.jsp");
            rd.forward(req, res);// View_Correct.jspにフォワード
        } else {// 不正解の回答を表示するとき
            RequestDispatcher rd = req.getRequestDispatcher("/View_Incorrect.jsp");
            rd.forward(req, res);// View_Incorrect.jspにフォワード

        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        doPost(req, res);
    }// Getのとき（決まり文句）
}