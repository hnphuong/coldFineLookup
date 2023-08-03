const responseHtml = "<div class=\"col-12 d-flex justify-content-center\">\n" +
    "                    <h4> #RESULT#</h4>\n" +
    "                </div>";

const notFound = "<div class=\"col-12 d-flex justify-content-center\">\n" +
    "                    <h4> Không tìm thấy kết quả !</h4>\n" +
    "                </div>";
$(document).ready(function () {
    // Validate license-plates
    $("#question-chat-gpt-check").hide();
    let chatGptError = true;

    //func validate
    function validChatGpt() {
        let questionChatGpt = $("#question-chat-gpt").val();
        if (questionChatGpt.length === 0) {
            $("#question-chat-gpt-check").show();
            chatGptError = false;
            return false;
        } else {
            $("#question-chat-gpt-check").hide();
            chatGptError = true;
        }
    }

    // Submit button
    $("#chat-gpt").submit(function (event) {
        validChatGpt();
        console.log("Run >>>>>>>>>>>>> ");
        if (chatGptError === true) {
            //stop submit the form event. Do this manually using ajax post func
            event.preventDefault();
            let questionChatGPTRequest = {}
            questionChatGPTRequest["question"] = $("#question-chat-gpt").val();
            $("#btn-search").prop("disabled", true);
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/api/chat-completions",
                data: JSON.stringify(questionChatGPTRequest),
                dataType: 'json',
                cache: false,
                timeout: 600000,
                beforeSend: function () {
                    console.log("<<< loading removeClass d-none >>>");
                    $('#loading').removeClass('d-none')
                    $('#feedback-response-search').addClass('d-none')
                },
                success: function (data) {
                    let responseData = JSON.stringify(data, null, 4);
                    console.log("responseData:  " + responseData);
                    // end push html to web
                    let responseObj = JSON.parse(responseData);
                    let resultRes = "";
                    if (responseData) {
                        console.log("mapObj:  " + responseObj.content);
                        resultRes = responseHtml.replace("#RESULT#", responseObj.content)
                    } else {
                        resultRes = notFound;
                    }
                    $('#feedback-response-search').removeClass('d-none').html(resultRes);
                    $("#btn-search").prop("disabled", false);
                },
                complete: function () {
                    console.log("<<< loading addClass d-none >>>");
                    $('#loading').addClass('d-none')
                },
                error: function (e) {
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