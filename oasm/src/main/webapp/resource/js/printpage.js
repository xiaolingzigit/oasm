function printdiv(printpage)  {  
	var headstr = "<html><head><title></title></head><body>";  
	var footstr = "</body>";  
	var newstr = document.all.item(printpage).innerHTML;  
	var oldstr = document.body.innerHTML;  
	document.body.innerHTML =newstr;  
	window.print();  
	document.body.innerHTML = oldstr;  
	return false;  
	}  
