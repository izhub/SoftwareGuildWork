$(document).ready(function () {
    loadAddresses();

    $('#add-button').click(function (event) {
        event.preventDefault();

        $.ajax({//make ajax call to server; HTTP verb:POST; URL:contact
            type: 'POST',
            url: 'address',
            data: JSON.stringify({
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                street: $('#add-street').val(),
                city: $('#add-city').val(),
                state: $('#add-state').val(),
                zip: $('#add-zip').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {   //if call success, clear form & reload table
            $('#add-first-name').val(''),
                    $('#add-last-name').val(''),
                    $('#add-street').val(''),
                    $('#add-city').val(''),
                    $('#add-state').val(''),
                    $('#add-zip').val(''),
                    loadAddresses();
        });
    });

    $('#edit-button').click(function(event){
        event.preventDefault();
        
        $.ajax({
            type: 'PUT',
            url: 'address/'+ $('#edit-address-id').text(),
            data: JSON.stringify({
                id: $('#edit-address-id').val(),
                firstName: $('#edit-first-name').val(),
                lastName: $('#edit-last-name').val(),
                street: $('#edit-street').val(),
                city: $('#edit-city').val(),
                state: $('#edit-state').val(),
                zip: $('#edit-zip').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function(){
            loadAddresses();
        });
    });
});

function clearAddressTable() {
    $('#contentRows').empty();
}

function loadAddresses() {
    clearAddressTable();

    var aTable = $('#contentRows');

    $.ajax({
        url: 'addresses'
    }).success(function (data, status) {
        $.each(data, function (index, address) {
            aTable.append($('<tr>')
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'data-address-id': address.id,
                                        'data-toggle': 'modal',
                                        'data-target': '#detailsModal'
                                    }).text(address.firstName + ' ' + address.lastName)
                                    )
                            )
                    .append($('<td>').text(address.state))
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'data-address-id': address.id,
                                        'data-toggle': 'modal',
                                        'data-target': '#editModal'
                                    }).text('Edit')
                                    ))
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'onClick': 'deleteAddress(' + address.id + ')'
                                    }).text('Delete')
                                    )
                            )
                    );
        });
    });
}

$('#detailsModal').on('show.bs.modal',function(event){
    var element = $(event.relatedTarget);
    var addressId = element.data('address-id');
    var modal = $(this);
    
    $.ajax({
        type:'GET',
        url: 'address/' + addressId
    }).success(function(address){
        modal.find('#address-id').text(address.id);
        modal.find('#address-firstName').text(address.firstName);
        modal.find('#address-lastName').text(address.lastName);
        modal.find('#address-street').text(address.street);
        modal.find('#address-city').text(address.city);
        modal.find('#address-state').text(address.state);
    });
});

$('#editModal').on('show.bs.modal', function(event){
    var element = $(event.relatedTarget);
    var addressId = element.data('address-id');
    var modal=$(this);
    
    $.ajax({
        type: 'GET',
        url: 'address/'+addressId
    }).success(function(address){
        modal.find('#edit-address-id').text(address.id);
        modal.find('#edit-address-id').val(address.id);
        modal.find('#edit-first-name').val(address.firstName);
        modal.find('#edit-last-name').val(address.lastName);
        modal.find('#edit-street').val(address.street);
        modal.find('#edit-city').val(address.city);
        modal.find('#edit-state').val(address.state);
        modal.find('#edit-zip').val(address.zip);
    });
    
});

function deleteAddress(id){
    var answer = confirm("Are you sure you want delete this entery?");
    
    if (answer === true){
        $.ajax({
            type: 'DELETE',
            url: 'address/' + id
        }).success(function(){
            loadAddresses();
        });
    }
}