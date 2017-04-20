<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
    <link type="text/css" rel="stylesheet" href="https://cdn.firebase.com/libs/firebaseui/1.0.0/firebaseui.css" />
</head>

<body>
    <div id="firebaseui-auth-container"></div>
</body>
</html>

<script src="https://www.gstatic.com/firebasejs/3.6.10/firebase.js"></script>
<script src="https://cdn.firebase.com/libs/firebaseui/1.0.0/firebaseui.js"></script>
<script>
    var config = {
        apiKey: "AIzaSyBC9eQmvpcEuOIWEhnKOcNvxm3G60mWOpA",
        authDomain: "coopcopy-5dc9f.firebaseapp.com",
        databaseURL: "https://coopcopy-5dc9f.firebaseio.com",
        storageBucket: "coopcopy-5dc9f.appspot.com",
        messagingSenderId: "348681530274"
    };

    firebase.initializeApp(config);

    // FirebaseUI config.
    var uiConfig = {
        signInSuccessUrl: "http://localhost:8080/report_designer",
        signInOptions: [
            // Leave the lines as is for the providers you want to offer your users.
            firebase.auth.GoogleAuthProvider.PROVIDER_ID,
            firebase.auth.FacebookAuthProvider.PROVIDER_ID,
            firebase.auth.TwitterAuthProvider.PROVIDER_ID,
            firebase.auth.GithubAuthProvider.PROVIDER_ID,
            firebase.auth.EmailAuthProvider.PROVIDER_ID
        ],
        // Terms of service url.
        tosUrl: "http://localhost:8080/report_designer"
    };

    // Initialize the FirebaseUI Widget using Firebase.
    var obj = firebase.auth();
    var ui = new firebaseui.auth.AuthUI(obj);
    // The start method will wait until the DOM is loaded.
    ui.start('#firebaseui-auth-container', uiConfig);

    firebase.auth().onAuthStateChanged(function(user){
        if(user){
            console.log(user.email);
            console.log(user.displayName);
            console.log(uiConfig);
            uiConfig.signInSuccessUrl = "http://localhost:8080/report_designer?displayName=" + user.displayName + "&email=" + user.email;}
        else{
            console.log("pain");
        }
    });
</script>