<%@page contentType="text/html;charset=utf-8" %>
    <jsp:useBean id="vb" scope="request" class="bean.ViewBean" />
    <html>

    <head>
        <title>一覧</title>
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
                <%=vb.getIncorrectList() %>
            </div>
        </div>
    </body>

    </html>