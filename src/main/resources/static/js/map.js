
let map, polygon;

$(document).ready(function() {
    $('#btn-save').on('click', savePaths);
});

function initMap() {
    map = new google.maps.Map(document.getElementById("map"), {
        center: googleMap.center,
        zoom: 8,
    });
    polygon = new google.maps.Polygon({
        paths: googleMap.paths,
        strokeColor: '#FF0000',
        strokeOpacity: 0.8,
        strokeWeight: 2,
        fillColor: '#FF0000',
        fillOpacity: 0.35,
        editable: true
    });
    polygon.setMap(map);
    map.addListener('center_changed', drawCenter);
    drawCenter();
    google.maps.event.addListener(polygon.getPath(), 'set_at', drawPaths);
    google.maps.event.addListener(polygon.getPath(), 'insert_at', drawPaths);
    google.maps.event.addListener(polygon.getPath(), 'remove_at', drawPaths);
    drawPaths();
}

function drawCenter() {
    $('#center').empty().append('<div>' + map.getCenter().lat() + ' ' + map.getCenter().lng() + '</div>');
}

function drawPaths() {
    $('#paths').empty();
    polygon.getPath().getArray().forEach(function(p) {
        $('#paths').append('<div>' + p.lat() + ' ' + p.lng() + '</div>');
    });
}

function savePaths() {
    let paramUrl = "/api/map/";
    let paramCenter = toGooglePoint(map.getCenter());
    let paramPaths = polygon.getPath().getArray().map(toGooglePoint);
    let paramData = {
        id: googleMap.id,
        center: paramCenter,
        paths: paramPaths
    };
    $.ajax({
        url: paramUrl,                  /* Куда пойдет запрос */
        method: 'put',                  /* Метод передачи (post или get) */
        dataType: 'json',               /* Тип данных в ответе (xml, json, script, html). */
        contentType: "application/json",
        data: JSON.stringify(paramData) /* Параметры передаваемые в запросе. */
    })
    .done(function(a, b) {
        console.log("success");
        console.log(a);
        console.log(b);
    })
    .fail(function(resp, b) {
        console.log(resp.responseJSON);
    })
}

function toGooglePoint(e) {
    return {lat: e.lat(), lng: e.lng()};
}
