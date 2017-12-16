	
	function upload() {
		//选择文件之后执行上传  
			$.ajaxFileUpload({
				url : 'upload/uploadImage',
				secureuri : false,
				fileElementId : 'fileToUpload',//file标签的id  
				dataType : 'text',//返回数据的类型  
				success : function() {
					alert("OK!")
				},
				error : function() {
					alert("ERROR!");
				}
			});
	}