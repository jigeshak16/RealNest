<!DOCTYPE html>
<html lang="en">
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Realnest Home</title>

<style>
    *{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial,sans-serif;
}

    body{
    background:#2f2f2f;
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

    .container{
    width:95%;
    min-height:95vh;
    display:flex;
    background:white;
    border-radius:12px;
    overflow:hidden;
    box-shadow:0 8px 20px rgba(0,0,0,0.3);
}

    .left{
    width:50%;
    background:url('https://images.unsplash.com/photo-1505693416388-ac5ce068fe85') center/cover no-repeat;
    position:relative;
    color:white;
}

    .logo{
    position:absolute;
    top:30px;
    left:30px;
    background:white;
    color:black;
    padding:12px 20px;
    border-radius:35px;
    font-size:32px;
    font-weight:bold;
}

    .overlay-text{
    position:absolute;
    bottom:50px;
    left:50px;
}

    .overlay-text h1{
    font-size:60px;
    margin-bottom:10px;
}

    .overlay-text p{
    font-size:22px;
}

    .right{
    width:50%;
    padding:80px;
    display:flex;
    flex-direction:column;
    justify-content:center;
}

    .right h1{
    font-size:70px;
    color:#16215c;
    margin-bottom:20px;
}

    .right p{
    color:gray;
    margin-bottom:40px;
    font-size:22px;
}

    button{
    width:100%;
    padding:18px;
    margin:15px 0;
    border:none;
    border-radius:10px;
    font-size:22px;
    cursor:pointer;
}

    .login-btn{
    background:black;
    color:white;
}

    .register-btn{
    background:#2563eb;
    color:white;
}
</style>
</head>
<body>

<div class="container">

    <div class="left">
        <div class="logo">🏠 Realnest</div>

        <div class="overlay-text">
            <h1>Find your sweet home</h1>
            <p>Schedule visits in just a few clicks</p>
        </div>
    </div>

    <div class="right">
        <h1>Welcome to Realnest!</h1>
        <p>Choose your option to continue</p>

        <button class="login-btn" onclick="window.location.href='login.html'">
            Login
        </button>

        <button class="register-btn" onclick="window.location.href='signup.html'">
            Register
        </button>
    </div>

</div>

</body>
</html>