$(function() {
	//当键盘键被松开时发送Ajax获取数据
	$('#textinput').keyup(function() {
		var keywords = $(this).val();
		if(keywords == '') {
			$('#wordtable').hide();
			return
		};
		
		$.ajax({
		 	type: "POST",
		  	url: "returnTips.do",
			data : {keyword : keywords},
			dataType : "json",
			success: function(data) {
			
				$('#wordtable').empty().show();
				if(data[0] == '') {
					$('#wordtable').append('<div class="error">Not find  "' + keywords + '"</div>');
				}
				$.each(data, function() {
					$('#wordtable').append('<div class="click_work">' + this + '</div>');
				})
			}
		});
	})
	
	//点击搜索数据复制给搜索框
	$(document).on('click', '.click_work', function() {
		var word = $(this).text();
		$('#textinput').val(word);
		$('#wordtable').hide();
		//$('#textinput').trigger('click');触发搜索事件
	})
	
})