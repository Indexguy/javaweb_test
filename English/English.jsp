<%@page contentType="text/html;charset=utf-8" %>
<jsp:useBean id="eb" scope="session" class="bean.EnglishBean" />
<html>

    <head>
        <title>テスト</title>
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
                単語：<strong>
                    <%=eb.getWord() %>
                </strong>
                <br />
                <form action="/English/Answer" method="post">
                    あなたの回答：<textarea name="content"></textarea>
                    <br />
                    No.<%=eb.getCount() %>
                    <input type="submit" value="正解を見る" />
                </form>
            </div>
        </div>
    </body>

</html>