/**
 * form validations for emp_register.jsp
 */

 function doValidation(frm){
	console.log("hello world charan")
	document.getElementById("empNameErr").innerHTML="";
	document.getElementById("designationErr").innerHTML="";
	document.getElementById("mgrErr").innerHTML="";
	document.getElementById("hireDateErr").innerHTML="";
	document.getElementById("salErr").innerHTML="";
	document.getElementById("deptNoErr").innerHTML="";
	
	//updating vflag. Get the input element by its ID
    var inputElement = document.getElementById('vflag');
    // Update the value of the input element
    inputElement.value = 'false';
    
	//read form data values
	let name = frm.empName.value;
	let desig = frm.designation.value;
	let mgr = frm.mgr.value;
	let hireDate = frm.hireDate.value;
	let sal = frm.sal.value;
	let salary = parseFloat(sal);
	let deptNo = frm.deptNo.value;
	let isValid = true;
	
	//form validation logics
	if(name==""){
		document.getElementById("empNameErr").innerHTML="name is mandatory";
		isValid = false;
	}
	else if(name.length<5 || name.length>20){
		document.getElementById("empNameErr").innerHTML="name must contain 5 to 20 characters";
		isValid = false;
	}
	
	if(desig==""){
		document.getElementById("designationErr").innerHTML="designation is mandatory";
		isValid = false;
	}
	else if(desig.length<5 || desig.length>20){
		document.getElementById("designationErr").innerHTML="designation must contain 5 to 20 characters";
		isValid = false;
	}
	
	if(mgr==""){
		document.getElementById("mgrErr").innerHTML="Employee mgr is mandatory";
		isValid = false;
	}
	/*else if(mgr.isNan){
		document.getElementById("mgrErr").innerHTML="Employee mgr is mandatory";
		isValid = false;
	}*/
	
	if(hireDate==""){
		document.getElementById("hireDateErr").innerHTML="Hire Date is mandatory";
		isValid = false;
	}
	if(sal==""){
		document.getElementById("salErr").innerHTML="salary is mandatory";
		isValid = false;
	}
	else if( isNaN(salary) || salary<25000.0){
		document.getElementById("salErr").innerHTML="salary must be greater than 25000.0";
		isValid = false;
	}
	let dept = Number(deptNo);
	if(deptNo==""){
		document.getElementById("deptNoErr").innerHTML="department number is mandatory";
		isValid = false;
	}
	else if(isNaN(dept) || dept<10 || dept>90){
		document.getElementById("deptNoErr").innerHTML="department number must be in range 10 to 90";
		isValid = false;	
	}

	return isValid;
 }