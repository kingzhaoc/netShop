$().ready(function() {
	function changePrice() {
		var num = $("#pro_num_detail").val();
		number = parseFloat(num)
		var unit = $("#pro_unitprice").val();
		price = parseFloat(unit);
		var total = number * price;
		$("#pro_totalPrice").val(total.toFixed(2));
	}
	changePrice();
	$("#decbtn").click(function() {
		if ($("#pro_num_detail").val() == 1) {
			$(this).attr("disabled", true);
		} else {
			var word = $("#pro_num_detail").val();
			Number = parseInt(word);
			$("#pro_num_detail").val(Number - 1);
			changePrice();
		}
	});
	$("#addbtn").click(function() {
		$("#decbtn").attr("disabled", false);
		var word = $("#pro_num_detail").val();
		Number = parseInt(word);
		$("#pro_num_detail").val(Number + 1);
		changePrice();
	});
	$("#pro_num_detail").keyup(function() {
		$("#decbtn").attr("disabled", false);
		var word = $(this).val();
		if (word == "") {
			return;
		}
		changePrice();
	});
	$("#addtocart").click(function() {

	})
})