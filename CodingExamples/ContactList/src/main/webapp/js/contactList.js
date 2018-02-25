$(document).ready(function () {
    loadContacts();

    $('#add-button').click(function (event) {
        event.preventDefault();
        //make Ajax call to server. HTTP verb=POST URL=contact
        $.ajax({
            type: 'POST',
            url: 'contact',
            //build JSON object  from data in the form
            data: JSON.stringify({
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                company: $('#add-company').val(),
                phone: $('#add-phone').val(),
                email: $('#add-email').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            //if call succeeds, clear form and reload summary table
            $('#add-first-name').val(''),
                    $('#add-last-name').val(''),
                    $('#add-company').val(''),
                    $('#add-phone').val(''),
                    $('#add-email').val(''),
                    loadContacts();
            $('#validationErrors').empty();
        }).error(function (data, status) {
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        
        });
    });
});

$('#edit-button').click(function (event) {
    event.preventDefault();

    //Ajax call: method - put : URL - contact/{id} : just reload all Contacts upon success
    $.ajax({
        type: 'PUT',
        url: 'contact/' + $('#edit-contact-id').text(),
        data: JSON.stringify({
            contactId: $('#edit-contact-id').val(),
            firstName: $('#edit-first-name').val(),
            lastName: $('#edit-last-name').val(),
            company: $('#edit-company').val(),
            phone: $('#edit-phone').val(),
               email: $('#edit-email').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function () {
        loadContacts();
    });

});
//clear all content rows from summary table
        function clearContactTable() {
            $('#contentRows').empty();
        }


function loadContacts() {

    clearContactTable();

    var cTable = $('#contentRows');

    $.ajax({
        url: 'contacts'
    }).success(function (data, status) {
        $.each(data, function (index, contact) {
            cTable.append($('<tr>')
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'data-contact-id': contact.contactId,
                                        'data-toggle': 'modal',
                                        'data-target': '#detailsModal'
                                    }).text(contact.firstName + ' ' + contact.lastName)
                                    )
                            )

                    .append($('<td>').text(contact.company))
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'data-contact-id': contact.contactId,
                                        'data-toggle': 'modal',
                                        'data-target': '#editModal'
                                    }).text('Edit')
                                    ))

                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'onClick': 'deleteContact(' + contact.contactId + ')'
                                    }).text('Delete')
                                    )
                            )
                    );
        });

    });


}



$('#detailsModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var contactId = element.data('contact-id');
    var modal = $(this);

    $.ajax({
        type: 'GET',
        url: 'contact/' + contactId
    }).success(function (contact) {
        modal.find('#contact-id').text(contact.contactId);
        modal.find('#contact-firstName').text(contact.firstName);
        modal.find('#contact-lastName').text(contact.lastName);
        modal.find('#contact-company').text(contact.company);
        modal.find('#contact-phone').text(contact.phone);
        modal.find('#contact-email').text(contact.email);

    });
});

$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var contactId = element.data('contact-id');
    var modal = $(this);

    $.ajax({
        type: 'GET',
        url: 'contact/' + contactId
    }).success(function (contact) {
        modal.find('#edit-contact-id').text(contact.contactId);
        modal.find('#edit-contact-id').val(contact.contactId);
        modal.find('#edit-first-name').val(contact.firstName);
        modal.find('#edit-last-name').val(contact.lastName);
        modal.find('#edit-company').val(contact.company);
        modal.find('#edit-phone').val(contact.phone);
        modal.find('#edit-email').val(contact.email);
    });
});



function deleteContact(id) {
    var answer = confirm("Do you really want to delete this contact?");

    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'contact/' + id
        }).success(function () {
            loadContacts();
        });
    }
}


////////////////////////////////////////////
///// TEST DATA ////// REMOVE WHEN DONE
//////////////////////////////////////////

var testContactData = [
    //follow same naming convention as dto so jacksonMapper is not confused

    {
        contactId: 1,
        firstName: 'Sustan',
        lastName: 'William',
        company: 'IBM',
        email: 'swill@ibm.com',
        phone: '232-2323'

    },
    {
        contactId: 2,
        firstName: 'George',
        lastName: 'Smith',
        company: 'EMC',
        email: 'smith@emc.com',
        phone: '555-2342'
    },
    {
        contactId: 3,
        firstName: 'Chuck',
        lastName: 'Knob',
        company: '3M',
        email: 'chuck@3m.com',
        phone: '232-2323'
    }
];

var dummyDetailsContact =
        {
            contactId: 42,
            firstName: "Kill",
            lastName: "Bill",
            company: "3M",
            email: "kent@3m.com",
            phone: "232-2323"
        };