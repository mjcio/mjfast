<!DOCTYPE html>
<html lang="en">
<head>
    <title>Authentication Service</title>
</head>
<body>
<form method="POST" action="/login?redirect=${RequestParameters.redirect!}">
    <h2>Login</h2>
    <input name="username" type="text" placeholder="Username"
           autofocus="true"/>
    <input name="password" type="password" placeholder="Password"/>
    <div>(try username=admin and password=admin)</div>
    <div style="color: red">${error!}</div>
    <br/>
    <button type="submit">Login</button>
</form>
</body>
</html>