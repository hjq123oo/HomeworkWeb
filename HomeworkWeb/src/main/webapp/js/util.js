 	function getUrlParam(name){  
    	    //构造一个含有目标参数的正则表达式对象  
    	    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");  
    	    //匹配目标参数  
    	    var r = window.location.search.substr(1).match(reg);  
    	    //返回参数值  
    	    if (r!=null) return unescape(r[2]);  
    	    return null;  
    	}  
 	
 	Date.prototype.getString = function(){
 		return this.getFullYear()+"/"+(this.getMonth()+1)+"/"+this.getDate()+" "+this.getHours()+":"+this.getMinutes();
 	}
 	
 	Date.prototype.getHomeworkString = function(){
 		return this.getFullYear()+"/"+(this.getMonth()+1)+"/"+this.getDate()+"#"+this.getHours()+":"+this.getMinutes();
 	}
 	
 	Date.prototype.format = function(fmt)   
	{  
	  var o = {   
	    "M+" : this.getMonth()+1,                 //月份   
	    "d+" : this.getDate(),                    //日   
	    "h+" : this.getHours(),                   //小时   
	    "m+" : this.getMinutes(),                 //分   
	    "s+" : this.getSeconds(),                 //秒   
	    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
	    "S"  : this.getMilliseconds()             //毫秒   
	  };   
	  if(/(y+)/.test(fmt))   
	    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
	  for(var k in o)   
	    if(new RegExp("("+ k +")").test(fmt))   
	  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
	  return fmt;   
	}  