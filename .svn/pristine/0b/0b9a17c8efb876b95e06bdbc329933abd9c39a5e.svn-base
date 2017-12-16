/** 
 * Created with IntelliJ IDEA. 
 * User: Administrator 
 * Date: 13-7-3 
 * Time: 上午9:20 
 * To change this template use File | Settings | File Templates. 
 */  
$(document).ready(function () {  
    $("#up1").click(function(){  
    	var temp = ['DocOne','DocTwo','DocThree','DocFour'];
        ajaxFileUpload(temp);  
    });  
  
    $("#addInput").click(function(){  
        addInputFile();  
    });  
  
});  
  
//动态添加一组文件  
function addInputFile(){  
    $("#calculation_model").append(" <tr>"+  
        "<td><input type='file'  name='gridDoc' class='input'></td>   "+  
      /*  "<td><input type='file' name='caseDoc' class='input'></td> "+  */
        "</tr>");  
}  
  
  
//直接使用下载下来的文件里的demo代码  
function ajaxFileUpload(id)  
{  
    //starting setting some animation when the ajax starts and completes  
    $("#loading").ajaxStart(function(){  
            $(this).show();  
        }).ajaxComplete(function(){  
            $(this).hide();  
        });  
  
    /* 
     prepareing ajax file upload 
     url: the url of script file handling the uploaded files 
     fileElementId: the file type of input element id and it will be the index of  $_FILES Array() 
     dataType: it support json, xml 
     secureuri:use secure protocol 
     success: call back function when the ajax complete 
     error: callback function when the ajax failed 
 
     */  
    $.ajaxFileUpload({  
            url:'upload/uploadImage',  
            //secureuri:false,  
            fileElementId:id,  
            dataType: 'text' ,
            success: function(data, status){ 
//            	var info = JSON.parse(data);
                alert(data.info);
            },
            error: function(data, status, e){ 
                alert(e);
            }
        }  
    )  
    
//    return false;  
  
}  