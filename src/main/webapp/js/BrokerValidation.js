function validatePersonCode(obj) {
	var reg1 = /^[0-9a-zA-Z]*$/;
	if ((obj != "" && !reg1.test(obj)) || obj.length>10 || obj.length<3) {
		alert('只能填数字或字母！且长度在3到10之间');
		document.addBroker.code.focus();
		return false;
	}
}

function validateFirstName(obj) {
	var reg1 = /^[a-zA-Z]*$/;
	if ((obj != "" && !reg1.test(obj)) || obj.length>30 || obj.length<1) {
		alert('只能填字母！且长度在1到30之间');
		document.addBroker.firstName.focus();
		return false;
	}
}

function validateLastName(obj) {
	var trimEmpty = /(^\s*)|(\s*$)/g ;
	obj = obj.replace(trimEmpty,"");
	var reg1 = /^[a-zA-Z]*$/;
	if ((obj != "" && !reg1.test(obj)) || obj.length>30 || obj.length<1) {
		alert('只能填字母！且长度在1到30之间');
		document.addBroker.lastName.focus();
		return false;
	}
}

function validateStreet(obj) {
	var trimEmpty = /(^\s*)|(\s*$)/g ;
	obj = obj.replace(trimEmpty,"");
	var reg1 = /^[0-9a-zA-Z ]*$/;
	if ((obj != "" && !reg1.test(obj)) || obj.length>30 || obj.length<1) {
		alert('只能填字母和数字和空格！且长度在1到30之间');
		document.addBroker.street.focus();
		return false;
	}
}

function validateState(obj) {
	var reg1 = /^[a-zA-Z ]*$/;
	if ((obj != "" && !reg1.test(obj)) || obj.length>30 || obj.length<1) {
		alert('只能填字母和空格！且长度在1到30之间');
		document.addBroker.state.focus();
		return false;
	}
}

function validateCountry(obj) {
	var reg1 = /^[a-zA-Z ]*$/;
	if ((obj != "" && !reg1.test(obj)) || obj.length>30 || obj.length<1) {
		alert('只能填字母和空格！且长度在1到30之间');
		document.addBroker.country.focus();
		return obj;
	}}
	
function validateSecIdentifier(obj) {
	var reg1 = /^[0-9a-zA-Z]*$/;
	if ((obj != "" && !reg1.test(obj)) || obj.length>10 || obj.length<3) {
		alert('只能填数字或字母！且长度在3到10之间');
		document.addBroker.secIdentifier.focus();
		return false;
	}}