function createMarker(coordenadas, map) {

    if (typeof marker !== 'undefined') {
        marker.setMap(null);
    };

    marker = new google.maps.Marker({
        position: coordenadas,
        map: map
    });

    map.panTo(coordenadas);

    document.getElementById("lat").value = coordenadas.lat();
    document.getElementById("lng").value = coordenadas.lng();
};
