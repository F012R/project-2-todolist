
var btn_move = document.querySelectorAll(".btn-move");

/* post 방식으로 id과 type TodoTypeServlet에 전달 */
function xhr(id, type, callback) {
	var xhttp = new XMLHttpRequest();
	var params = "id="+id+"&type="+type;
	
	xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
			console.log(this.responseText);
        }
    };

    xhttp.open("post", 'todotype', true);
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 
    xhttp.send(params);
}


// todo와 doing type의 블럭에서 버튼이 눌리면 
function addEventListenerToButton(btn) {
    btn.addEventListener("click", function(evt){
		var article_node = evt.target.parentNode.parentNode;   // 버튼이 눌린 article
      	var now_type = article_node.getAttribute('data-type');

		// 블럭이 눌린 article의 복사본을 다음 section에 삽입하고, 원본은 현재 section에서 삭제 
      	var cloneNode = article_node.cloneNode(true);
      	var section;
      	if (now_type === "TODO") {  
	        cloneNode.setAttribute('data-type', 'DOING')
	        section = document.querySelector(".doing-section");
	    } else if (now_type === 'DOING') {
	        cloneNode.setAttribute('data-type', 'DONE')
	        cloneNode.querySelector("button").remove();
	        section = document.querySelector(".done-section");       
	    } 
        var first_article = section.firstChild.nextSibling.nextSibling;   
        var now_regdate = cloneNode.dataset.regdate;
        
        /* 버튼을 누른 article을 다음 section의 article 사이에 삽입: 등록 날짜 내림차순 기준 */
       	while (first_article !== null && first_article.tagName !== undefined && first_article.dataset.regdate > now_regdate) {
			first_article = first_article.nextSibling;
			if (first_article === null || first_article.tagName) {
				break;
			}
		}
        section.insertBefore(cloneNode, first_article);
        article_node.remove();
        
        // 새로 생성된 버튼에도 이벤트 리스너 등록
        var newBtn = cloneNode.querySelector(".btn-move");
        if (newBtn) {
            addEventListenerToButton(newBtn);
        }
      
        /* post로 TodoTypeServlet에 값 전달하기 */
        xhr(cloneNode.getAttribute('data-id'), now_type);
    });
  }
  
  document.querySelectorAll(".btn-move").forEach(addEventListenerToButton);



