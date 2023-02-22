$("#search-cold-penalty").submit(function (event) {
    //stop submit the form event. Do this manually using ajax post function
    event.preventDefault();
    var searchColdPenalty = {}
    searchColdPenalty["licensePlates"] = $("#license-plates").val();
    searchColdPenalty["typeVehicle"] = $("#type-vehicle").val();
    $("#btn-search").prop("disabled", true);
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/result",
        data: JSON.stringify(searchColdPenalty),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            var response_data = JSON.stringify(data, null, 4);
            var json = "<h4>Ajax Response</h4><pre>"
                + response_data + "</pre>";
            $('#feedback').html(json);
            var jsonResponse = "<div class=\"col-sm-6 pb-3\">\n" +
                "                <div class=\"card shadow-lg bg-body rounded\">\n" +
                "                    <div class=\"card-body\">\n" +
                "                        <div class=\"card-header\">\n" +
                "                            <h5 class=\"text-danger\"><i class=\"fa fa-frown-o\" aria-hidden=\"true\"></i> Lần: <span> ##1 </span>\n" +
                "                            </h5>\n" +
                "                        </div>\n" +
                "                        <ul class=\"list-group list-group-flush\">\n" +
                "detailx" +
                "                        </ul>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>"
            var idetail = "                            <li class=\"list-group-item\"><i class=\"fa fa-check\" aria-hidden=\"true\"></i> ##2 </li>\n"
            console.log("SUCCESS : ", data);
            var obj = JSON.parse(response_data);
            var map_data = new Map(Object.entries(obj.response));
            var sum = "";
            var x = "";
            for (let i = 0; i < map_data.size; i++) {
                var root = jsonResponse.replace("##1", [i].toString());
                const f = map_data.get([i].toString()).entries();
                var y = "";
                for (let x of f) {
                    var replace1 = idetail.replace("##2", x[1]);
                    y = y.concat(" ", replace1);
                }
                //console.log("<<<<<<<<<<<<<<<<<<<<<<<:>>>>>>>>>>>>>>>>>>>>>>>");
                var replace0 = root.replace("detailx", y);
                //console.log("replace0: " + replace0);
                sum = sum.concat(" ", replace0);
            }
            //document.getElementById("demo19").innerHTML = "result: " + sum.toString();
            $('#feedback1').html(sum);
            console.log("sum: " + sum);
            $("#btn-search").prop("disabled", false);
        },
        error: function (e) {
            var json = "<h4>Ajax Response Error</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);
            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);
        }
    });
});