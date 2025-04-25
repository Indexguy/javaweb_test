<%@page contentType="text/html;charset=utf-8" %>
    <jsp:useBean id="eb" scope="session" class="bean.EnglishBean" />
    <html>

    <head>
        <title>おわり</title>
        <link rel="stylesheet" href="English.css">
    </head>

    <body>
        <center>
            <h3><span class="title">学習</span></h3>
        </center>
        <div class="division">
            <div class="div1">
                <center>
                    <h4>操作</h4><br />
                </center>
                <center><a href="./English.html">ホーム</a></center>
            </div>
            <div class="div2">

                <form action="/English/English">
                    <input type="radio" name="result" value="result_Yes" />正解の問題をやり直す<br />
                    <input type="radio" name="result" value="result_No" />不正解の問題をやり直す<br />
                    <input type="submit" value="やり直し">
                </form>
                <form action="/English/View">
                    <input type="radio" name="result" value="result_Yes" />正解の問題をみる<br />
                    <input type="radio" name="result" value="result_No" />不正解の問題をみる<br />
                    <input type="submit" value="閲覧">
                </form>
            </div>
        </div>
    </body>

    </html>