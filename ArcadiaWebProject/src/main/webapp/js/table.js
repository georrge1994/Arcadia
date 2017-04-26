/**
 * Created by Hellen_User on 26.04.2017.
 */
function openRep(evt,reportName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(reportName).style.display = "block";
    evt.currentTarget.className += " active";
}
document.getElementById("defaultOpen").click();