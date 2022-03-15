<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="sources/styles.css" rel="stylesheet">
</head>
<body>
<img src="sources/DeltaGreenLogoTrans.png" class="centerImage">"
<br/>
    <form class='frmLogin' autocomplete='off' method='post' action='login'>
    <label for='username' class='lblLoginHeader'> Login </label>
    ${errorLogin}
    <label for='username' class='lblLogin'> Username: </label>
    <input name='username' type='text' class='inputLogin' value=${username}>
    ${errorUser}
    <label for='password' class='lblLogin'> Password: </label>
    <input name='password' type='password' class='inputLogin'/>
    ${errorPass}
    <input type='submit' name='submit' value='Submit' class='submitLogin buttonActivated' />
    <div class='frmLoginRow'>
        <div class='frmLoginColumn'><a href='register.jsp'>Register</a></div>
    </div>
</body>
</html>

