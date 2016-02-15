function deleteList(listName) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "/?listName=" + listName, true);
    xhttp.send();
}

function setItemCompleted(todo, item, value, location) {
    var xhttp = new XMLHttpRequest();
    var isCompleted = false;
    if (value == 0) {
        isCompleted = true;
    };
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            location.reload();
        }
    };
    xhttp.open("PUT", "/items/" + todo + "?idItem=" + item + "&isCompleted=" + isCompleted, true);
    xhttp.send();
}

function deleteItem(todo, item) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "/items/" + todo + "/" + item, true);
    xhttp.send();
}

function clearCompleted(todo) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "/items/" + todo + "/clear", true);
    xhttp.send();
}