function validatePersonCode(obj) {
	var reg1 = /^[0-9a-zA-Z]*$/;
	if ((obj != "" && !reg1.test(obj)) || obj.length>10 || obj.length<3) {
		alert('只能填数字或字母！且长度在3到10之间');
		document.addInvestor.code.focus();
		return false;
	}
}

function validatePersonFirstName(obj) {
	var reg1 = /^[a-zA-Z]*$/;
	if ((obj != "" && !reg1.test(obj)) || obj.length>30 || obj.length<1) {
		alert('只能填字母！且长度在1到30之间');
		document.addInvestor.firstName.focus();
		return false;
	}
}

function validatePersonLastName(obj) {
	var trimEmpty = /(^\s*)|(\s*$)/g ;
	obj = obj.replace(trimEmpty,"");
	var reg1 = /^[a-zA-Z]*$/;
	if ((obj != "" && !reg1.test(obj)) || obj.length>30 || obj.length<1) {
		alert('只能填字母！且长度在1到30之间');
		document.addInvestor.lastName.focus();
		return false;
	}
}

function validateAddressStreet(obj) {
	var trimEmpty = /(^\s*)|(\s*$)/g ;
	obj = obj.replace(trimEmpty,"");
	var reg1 = /^[0-9a-zA-Z ]*$/;
	if ((obj != "" && !reg1.test(obj)) || obj.length>30 || obj.length<1) {
		alert('只能填字母和数字和空格！且长度在1到30之间');
		document.addInvestor.street.focus();
		return false;
	}
}

function validateAddressState(obj) {
	var reg1 = /^[a-zA-Z ]*$/;
	if ((obj != "" && !reg1.test(obj)) || obj.length>30 || obj.length<1) {
		alert('只能填字母和空格！且长度在1到30之间');
		document.addInvestor.state.focus();
		return false;
	}
}

function validateAddressCountry(obj) {
	var reg1 = /^[a-zA-Z ]*$/;
	if ((obj != "" && !reg1.test(obj)) || obj.length>30 || obj.length<1) {
		alert('只能填字母和空格！且长度在1到30之间');
		document.addInvestor.country.focus();
		return obj;
	}
}