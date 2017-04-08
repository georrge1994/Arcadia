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
var ui = new firebaseui.auth.AuthUI(firebase.auth());
// The start method will wait until the DOM is loaded.
ui.start('#firebaseui-auth-container', uiConfig);