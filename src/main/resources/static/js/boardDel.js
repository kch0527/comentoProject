function deleteBoard(boardId){
    if(!confirm("삭제 하시겠습니까?")){
        return false;
    }else{
        const xhr1 = new XMLHttpRequest();
        xhr1.open("DELETE", `/boards/${boardId}`, true);
        xhr1.onload = function () {
            location.href = '/boards'
        }
        xhr1.send(null);
    }
}