<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <link rel="stylesheet" href="/static/style/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style/signin.css">
    <title>登陆-瑞华信通运营系统</title>
</head>
<body>
<div class="container">
    <form class="form-signin"
        <h2 class="form-signin-heading">登录运营系统</h2>
        <label for="inputEmail" class="sr-only"></label>
        <input type="email" id="inputEmail" name="email" class="form-control" placeholder="邮箱" required="" autofocus="">
        <label for="inputPassword"  class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required="">
        <div class="checkbox">
            <label>
                <input type="checkbox" name="remember" value="remember-me"> 记住账号
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登 录</button>
    </form>
</div>
</body>
</html>
