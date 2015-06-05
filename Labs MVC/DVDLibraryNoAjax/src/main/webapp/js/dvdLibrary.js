$(document).ready(function () {
    loadDvds();
    
    $('#add-button').click(function (event) {
        event.preventDefault;
        //make Ajax call to server. HTTP verb=POST URL=contact
        $.ajax({
            type: 'POST',
            url: 'dvd',
            //build json object from data in the form
            data: JSON.stringify({
                title: $('#add-title').val(),
                mpaaRating: $('#add-rating').val(),
                director: $('#add-director').val(),
                releaseDate: $('#add-release-date').val(),
                studio: $('#add-studio').val(),
                note: $('#add-note').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
//if succeeds, clear form and reload summary table 
            $('#add-title').val(''),
                    $('#add-director').val(''),
                    $('#add-release-date').val(''),
                    $('#add-rating').val(''),
                    $('#add-studio').val(''),
                    $('#add-note').val(''),
                    loadDvds();
        });
    });
    $('#edit-button').click(function (event) {

//ajax call: method-put : url-dvd{id} : reload all dvds upon success
        $.ajax({
            type: 'PUT',
            url: 'dvd/' + $('#edit-dvd-id').text(),
            data: JSON.stringify({
                dvdId: $('#edit-dvd-id').val(),
                title: $('#edit-title').val(),
                director: $('#edit-director').val(),
                releaseDate: $('#edit-release-date').val(),
                mpaaRating: $('#edit-rating').val(),
                studio: $('#edit-studio').val(),
                note: $('#edit-note').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadDvds();
        });
    });
});
function loadDvds() {
    clearDvdTable();
    var cTable = $('#contentRows');

    $.ajax({
        url: 'dvds'
    }).success(function (data, status) {
        $.each(data, function (index, dvd) {
            cTable.append($('<tr>')
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                    'data-dvd-id': dvd.dvdId,
                                            'data-toggle': 'modal',
                                            'data-target': '#detailsModal'
                                    }).text(dvd.title)
                                    )
                            )
                    .append($('<td>').text(dvd.mpaaRating))
                    .append($('<td>')
                            .append($('<a>')
                            .attr({
                            'data-dvd-id': dvd.dvdId,
                                    'data-toggle': 'modal',
                                    'data-target': '#editModal'
                            }).text('Edit')
                                    ))

                    .append($('<td>')
                            .append($( '<a>' )
                                    .attr({
                                    'onClick':'deleteDvd(' + dvd.dvdId + ')'
                                }).text('Delete')
                                )
                        )
                );
    });
});
}

function clearDvdTable() {
    $('#contentRows').empty();
}

$('#detailsModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var dvdId = element.data('dvd-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'dvd/' + dvdId
    }).success(function (dvd) {

        modal.find('#dvd-id').text(dvd.dvdId);
        modal.find('#dvd-title').text(dvd.title);
        modal.find('#dvd-rating').text(dvd.mpaaRating);
        modal.find('#dvd-release-date').text(dvd.releaseDate);
        modal.find('#dvd-director').text(dvd.director);
        modal.find('#dvd-studio').text(dvd.studio);
        modal.find('#dvd-note').text(dvd.note);
    });
});
$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var dvdId = element.data('dvd-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'dvd/' + dvdId
    }).success(function (dvd) {

        modal.find('#edit-dvd-id').text(dvd.dvdId);
        modal.find('#edit-dvd-id').val(dvd.dvdId);
        modal.find('#edit-title').val(dvd.title);
        modal.find('#edit-rating').val(dvd.mpaaRating);
        modal.find('#edit-release-date').val(dvd.releaseDate);
        modal.find('#edit-director').val(dvd.director);
        modal.find('#edit-studio').val(dvd.studio);
        modal.find('#edit-note').val(dvd.note);
    });
});


function deleteDvd(id) {
    var answer = confirm("Do you really want to delete this dvd?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'dvd/' + id
        }).success(function () {
            loadDvds();
        });
    }
}

////////////TEST DATA ////////////////////

var testDvdData = [
    {
        dvdId: 1,
        title: "American Pie",
        director: "Paul Weitz",
        mpaaRating: "R",
        releaseDate: "1995",
        studio: "Universal Studio"
    },
    {
        dvdId: 2,
        title: "Jumanji",
        director: "joe",
        mpaaRating: "PG",
        releaseDate: "1995",
        studio: "TriStar",
        note: "meh"
    },
    {
        dvdId: 3,
        title: "The Shawshank Redemption",
        director: "Frank",
        mpaaRating: "R",
        releaseDate: "2000",
        studio: "Columbia",
        note: "great!"
    },
    {
        DvdId: 4,
        director: "Zee",
        title: "Jinn",
        releaseDate: "2000",
        mpaaRating: "PG",
        studio: "ZeeStar",
        note: "sure"
    }
];
var dummyDetailsDvd =
        {
            dvdId: 30,
            title: "Batman",
            releaseDate: "2000",
            director: "Bill",
            mpaaRating: "PG",
            studio: "MyLife",
            note: "Awesome!"
        };
