function isPasswordMatch() {
    var newPassword = $("#newPassword").val();
    var confirmPassword = $("#newPasswordConfirm").val();

    if (newPassword != confirmPassword) { 
		$("#divCheckPassword").html("Passwords do not match!").css("color", "red"); 
		$("#newPasswordConfirm").val("");
		$("#newPassword").val("").focus();

	} else {
		$("#divCheckPassword").html("Passwords match.").css("color", "green");
	}
}