<%@page contentType="text/html;charset=utf-8" %>
    <jsp:useBean id="ab" scope="request" class="bean.AnswerBean" />
    <html>

    <head>
        <title>解答</title>
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
                あなたの回答：<strong>
                    <%= ab.getYourAnswer() %>
                </strong><br />
                解答：<strong>
                    <%= ab.getCorrectAnswer() %>
                </strong><br />
                <form action="/English/English">
                    <input type="radio" name="result" value="Yes" />正解<br />
                    <input type="radio" name="result" value="No" />不正解<br />
                    <input type="submit" value="送信">
                </form>
            </div>
        </div>
    </body>

    </html>