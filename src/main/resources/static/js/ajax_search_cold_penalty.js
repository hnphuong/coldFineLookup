const quantityViolate = "#quantityViolate#";
const infoViolate = "#infoViolate#";
const replaceLi = "#li#";
const responseHtml = "<div class=\"col-sm-6 pb-3\">\n" +
    "                <div class=\"card shadow-lg bg-body rounded\">\n" +
    "                    <div class=\"card-body\">\n" +
    "                        <div class=\"card-header\">\n" +
    "                            <h5 class=\"text-danger\"><i class=\"fa fa-frown-o\" aria-hidden=\"true\"></i> Lần: <span> " + quantityViolate + " </span>\n" +
    "                            </h5>\n" +
    "                        </div>\n" +
    "                        <ul class=\"list-group list-group-flush\">\n" +
    replaceLi +
    "                        </ul>\n" +
    "                    </div>\n" +
    "                </div>\n" +
    "            </div>";
const detailLi = "                            <li class=\"list-group-item\"><i class=\"fa fa-check\" aria-hidden=\"true\"></i> " + infoViolate + " </li>\n"
$("#search-cold-penalty").submit(function (event) {
    //stop submit the form event. Do this manually using ajax post function
    event.preventDefault();
    let searchColdPenalty = {}
    searchColdPenalty["licensePlates"] = $("#license-plates").val();
    searchColdPenalty["typeVehicle"] = $("#type-vehicle").val();
    $("#btn-search").prop("disabled", true);
    $("#loading").removeClass("d-none");
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/result",
        data: JSON.stringify(searchColdPenalty),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            let responseData = JSON.stringify(data, null, 4);
            let json = "<h4>Ajax Response</h4><pre>"
                + responseData + "</pre>";
            $('#feedback').html(json);
            console.log("SUCCESS : ", data);
            // end push html to web
            let responseObj = JSON.parse(responseData);
            let mapObj = new Map(Object.entries(responseObj.response));
            let resultRes = "";
            for (let i = 0; i < mapObj.size; i++) {
                let root = responseHtml.replace(quantityViolate, [i].toString());
                let liList = mapObj.get([i].toString()).entries();
                let aLi = "";
                for (let x of liList) {
                    let replace1 = detailLi.replace(infoViolate, x[1]);
                    aLi = aLi.concat(" ", replace1);
                }
                let replace0 = root.replace(replaceLi, aLi);
                resultRes = resultRes.concat(" ", replace0);
            }
            $('#feedback-response-search').html(resultRes);
            console.log("resultRes: " + resultRes);
            $("#btn-search").prop("disabled", false);
            $("#loading").addClass("d-none");
        },
        error: function (e) {
            let json = "<h4>Ajax Response Error</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);
            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);
        }
    });
});