var ajaxUrl = 'clientProjects/';
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, function (data) {
        updateTableByData(data);
    });
}

$(function () {
    datatableApi = $('#datatable').DataTable({
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": ""
        },
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "id"
            },
            {
                "data": "client.name"
            },
            {
                "data": "project.name"
            },
            {
                "orderable": false,
                "sDefaultContent": "",
                "render": renderEditBtn
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderDeleteBtn
            }
        ],
        "order": [
            [
                0,
                "asc"
            ]
        ],
        "createdRow": function (row, data, dataIndex) {
        },
        "initComplete": makeEditable
    });

    $.getJSON("/clients", function (j) {
        var options = '';
        for (var i = 0; i < j.length; i++) {
            options += '<option value="' + j[i].id + '">' + j[i].name + '</option>';
        }
        $("select#client").html(options);
    })

    $.getJSON("/projects", function (j) {
        var options = '';
        for (var i = 0; i < j.length; i++) {
            options += '<option value="' + j[i].id + '">' + j[i].name + '</option>';
        }
        $("select#project").html(options);
    })

});