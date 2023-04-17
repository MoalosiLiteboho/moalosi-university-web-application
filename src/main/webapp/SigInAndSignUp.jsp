<%@ page contentType="text/html;charset=UTF-8" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>login and registration</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styleSheet/SignInAndSignUp.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styleSheet/InputFields.css">
        <script defer src="javaScript/SignInAndSignUp.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="BlueBackground">
                <div class="box signIn">
                    <h2>Already have an account</h2>
                    <button class="signInButton" style="color: #ffffff; border: 2px #ffffff solid;">sing in</button>
                </div>
                <div class="box signup">
                    <h2>don't have an account</h2>
                    <button class="signUpButton" style="color: #ffffff; border: 2px #ffffff solid;">sing up</button>
                </div>
            </div>
            <div class="Form_Box">
                <form class="Form SignInForm" action="login" method="post">
                    <h3>sign in</h3>
                    <div class="input-container">
                        <input type="text" name="username" id="usernameId" autocomplete="off" placeholder=" " autocapitalize="off">
                        <label for="usernameId">Username</label>
                    </div>
                    <div class="input-container">
                        <input type="password" name="password" id="passwordId" placeholder=" " autocapitalize="off">
                        <label for="passwordId">Password</label>
                    </div>
                    <div class="button-container">
                        <input type="submit" value="logIn">
                    </div>
                    <div class="forget-password-container">
                        <p>Forget password? </p>
                        <a href="#">Click Here</a>
                    </div>
                </form>
                <form class="Form SignUpForm" action="registration" method="post">
                    <h3>sign up</h3>
                    <div class="input-container">
                        <input type="text" name="name" id="nameId" autocomplete="off" placeholder=" ">
                        <label for="nameId">Name</label>
                    </div>
                    <div class="input-container">
                        <input type="text" name="surname" id="surnameId" autocomplete="off" placeholder=" ">
                        <label for="surnameId">Surname</label>
                    </div>
                    <div class="input-container">
                        <input type="date" name="dateOfBirth" id="dateOfBirthId" placeholder=" ">
                        <label for="dateOfBirthId">Date Of Birth</label>
                    </div>
                    <div class="selection-container">
                        <select class="custom-select" name="districtCode" id="districtsId">
                            <option value="100">Maseru</option>
                            <option value="200">Berea</option>
                            <option value="300">Leribe</option>
                            <option value="400">Butha-Buthe</option>
                            <option value="500">Mokhotlong</option>
                            <option value="550">Thaba-Tseka</option>
                            <option value="600">Qacha's Nek</option>
                            <option value="700">Quthing</option>
                            <option value="800">Mohale's Hoek</option>
                            <option value="900">Mafeteng</option>
                        </select>
                        <label for="districtsId">District</label>
                    </div>
                    <div class="radio-container">
                        <h3>Gender</h3>
                        <input type="radio" name="gender" value="Male" id="maleId" checked>
                        <label for="maleId">Male</label>
                        <input type="radio" name="gender" value="Female" id="femaleId">
                        <label for="femaleId">Female</label>
                        <input type="radio" name="gender" value="Others" id="othersId">
                        <label for="othersId">Others</label>
                    </div>
                    <div class="button-container">
                        <input type="submit" value="register">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>

