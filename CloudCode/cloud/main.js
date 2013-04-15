// Use Parse.Cloud.define to define as many cloud functions as you want.
// For example:
Parse.Cloud.define("isUserLoggedIn", function(request, response) {
	var imei = request.object.get("imei");
	response.success(imei);
});
