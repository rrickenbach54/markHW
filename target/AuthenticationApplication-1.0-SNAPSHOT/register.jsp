<%--
  Created by IntelliJ IDEA.
  User: Ryan
  Date: 3/13/2022
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href="sources/styles.css" rel="stylesheet">
</head>
<body>
<div class='wrapper'>
    <h2>Sign Up</h2>
    <p>Fill this form to create a user</p>
    <p>${register_err}</p>
    <form action="register" method="post">
        <div class="form-group">
        <label>Username</label>
        <input type="text" name="username" class="form-control" value=${username}>
        <span class='help-block'>${username_err}</span>
        </div>
    <div class="form-group">
        <label>First Name</label>
        <input type="text" name="fname" class="form-control" value=${fname}>
        <span class="help-block">${fname_err}</span>
    </div>
    <div class="form-group">
        <label>Last Name</label>
        <input type="text" name="lname" class="form-control" value=${lname}>
        <span class="help-block">${lname_err}</span>
    </div>
    <div class="form-group">
        <label>Email</label>
        <input type="text" name="email" class="form-control" value=${email}>
        <span class="help-block">${email_err}</span>
    </div>
    <div class="form-group">
        <label>Password</label>
        <input type="password" name="password" class="form-control" value=${password}>
        <span class="help-block">${password_err}</span>
    </div>
    <div class="form-group">
    <label>Confirm Password</label>
    <input type="password" name="confirm_password" class="form-control" value=${confirm_password}>
    <span class="help-block">${confirm_password_err}</span>
    </div>
    <div class="form-group">
        <button type="submit" class="buttonActivated" value="Submit">Submit</button>
        <button type="reset" class="buttonActivated" value="Reset">Reset</button>
    </div>
</form>
</div>
</body>
</html>
