function notNull(obj)
{
    if(obj.value == " ")
    {
        alert("시작은 공백으로 권장하지 않음.\n공백이 제거됩니다.");
        obj.focus();
        obj.value = obj.value.replace(' ','');  // 공백 제거
        return false;
    }
}

    $("#register").click(function () {
        if ($.trim($("#title").val()) == '') {
            alert("타이틀을 입력해주세요.");
            return false;
        }
        if ($.trim($("#content").val()) == '') {
            alert("내용을 입력해주세요.");
            return false;
        }
        $("#create_Form").submit();
    });

    $("#update").click(function () {
        if ($.trim($("#title").val()) == '') {
            alert("타이틀을 입력해주세요.");
            return false;
        }
        if ($.trim($("#content").val()) == '') {
            alert("내용을 입력해주세요.");
            return false;
        }
        $("#update_Form").submit();
    });

