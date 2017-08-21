
function gfn_isNull(str){
	if (str == null) return true;
	if (str == "NaN") return true;
	if (new String(str).valueOf() == "undefined") return true;
	var chkStr = new String(str);
	if( chkStr.valueOf() == "undefined" ) return true;
	if (chkStr == null) return true;
	if (chkStr.toString().length == 0 ) return true;
	return false;
}

function ComSubmit(opt_formId){
	this.formId = gfn_isNull(opt_formId) == true ? "commonForm" : opt_formId;
	this.url = "";

	if(this.formId == "commonForm"){
		$("#commonForm")[0].reset();
	}

	this.addParam = function addParam(key, value) {
		$("#"+this.formId).append($("<input type='hidden' name='"+key+"' id='"+key+"' value='"+value+"' >"));
	};

	this.submit = function submit(){
		var form = $("#"+this.formId)[0];
		form.action = this.url;
		form.method = "post";
		form.submit();
	};
}

function page_back() {
	history.go(-1)();
}

