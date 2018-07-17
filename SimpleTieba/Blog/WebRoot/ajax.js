var xmlHttpRequest=null;
function createXHR(){
	try{
		xmlHttpRequest =new XMLHttpRequest();
	}catch(e1)
	{}
	var _msxmlhttp =new Array("Msxml2.XMLHTTP6.0","Msxml2.XMLHTTP5.0","Msxml2.XMLHTTP4.0","Msxml2.XMLHTTP3.0","Msxml2.XMLHTTP","Microsoft.XMLHTTP");
	for(var i=0;i<_msxmlhttp.length;i++){
		try
		{
			xmlHttpRequest=new ActiveXObject(_msxmlhttp[i]);
			if(xmlHttpRequest!=null)
				{break;}
		}catch(e2){}
	}
	if(xmlHttpRequest==null)
		{alert("不能创建");
		}
}

function sendRequest(url,params,method,handler){
	createXHR();
	if(!xmlHttpRequest) return false;
	
	if(method=="GET")
		{
		xmlHttpRequest.open(method, url+'?'+params, true);
		xmlHttpRequest.send(null);
		}
	if(method=="POST")
	{
		
	xmlHttpRequest.open(method, url, true);
	xmlHttpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlHttpRequest.send(params);
	}
	xmlHttpRequest.onreadystatechange =handler;
}