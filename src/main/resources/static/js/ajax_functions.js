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
const detailLi = "                            <li class=\"list-group-item\"><i class=\"fa fa-check\" aria-hidden=\"true\"></i> " + infoViolate + " </li>\n";
const notFound = "<div class=\"col-12 d-flex justify-content-center\">\n" +
    "                    <h4> Không tìm thấy kết quả !</h4>\n" +
    "                </div>";
$(document).ready(function() {
    // Validate license-plates
    $("#license-plates-check").hide();
    let licensePlatesError = true;
    $("#license-plates").keyup(function() {
        validateLicensePlates();
    });
    //func validate
    function validateLicensePlates() {
        let usernameValue = $("#license-plates").val();
        if (usernameValue.length === 0) {
            $("#license-plates-check").show();
            licensePlatesError = false;
            return false;
        } else if (usernameValue.length < 2 || usernameValue.length > 10) {
            $("#license-plates-check").show();
            $("#license-plates-check").html("Biển số xe có độ dài 2 đến 10 (*)");
            licensePlatesError = false;
            return false;
        } else {
            $("#license-plates-check").hide();
            licensePlatesError = true;
        }
    }

    // Submit button
    $("#search-cold-penalty").submit(function(event) {
        validateLicensePlates();
        console.log("Run >>>>>>>>>>>>> ");
        if (licensePlatesError === true) {
            //stop submit the form event. Do this manually using ajax post func
            event.preventDefault();
            let searchColdPenalty = {}
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
                beforeSend: function() {
                    console.log("<<< loading removeClass d-none >>>");
                    $('#loading').removeClass('d-none')
                    $('#feedback-response-search').addClass('d-none')
                },
                success: function(data) {
                    let responseData = JSON.stringify(data, null, 4);
                    //let json = "<h4>Ajax Response</h4><pre>"
                    //+ responseData + "</pre>";
                    //$('#feedback').html(json);
                    // end push html to web
                    let responseObj = JSON.parse(responseData);
                    let status = responseObj.status;
                    let resultRes = "";
                    if (status === 1) {
                        let mapObj = new Map(Object.entries(responseObj.response));
                        for (let i = 0; i < mapObj.size; i++) {
                            let root = responseHtml.replace(quantityViolate, (i + 1).toString());
                            let liList = mapObj.get([i].toString()).entries();
                            let aLi = "";
                            for (let x of liList) {
                                let replace1 = detailLi.replace(infoViolate, x[1]);
                                aLi = aLi.concat(" ", replace1);
                            }
                            let replace0 = root.replace(replaceLi, aLi);
                            resultRes = resultRes.concat(" ", replace0);
                        }
                    } else {
                        resultRes = notFound;
                    }
                    $('#feedback-response-search').removeClass('d-none').html(resultRes);
                    $("#btn-search").prop("disabled", false);
                },
                complete: function() {
                    console.log("<<< loading addClass d-none >>>");
                    $('#loading').addClass('d-none')
                },
                error: function(e) {
                    let json = "<h4>Response Error</h4><pre>" +
                        e.responseText + "</pre>";
                    $('#feedback').html(json);
                    console.log("ERROR : ", e);
                    $("#btn-search").prop("disabled", false);
                    $("#loading").addClass("d-none");
                }
            });
        } else {
            return false;
        }
    });
});