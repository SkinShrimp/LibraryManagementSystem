<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<!DOCTYPE html>
<html xmlns:uri="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jsp/jstl/core" lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="../css/normalize.css"  rel="stylesheet">
    <link href="../css/default.css"  rel="stylesheet">
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="../dist/cropper.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <script src="../assets/js/jquery.min.js"></script>
    <script src="../assets/js/bootstrap.min.js"></script>
    <script src="../dist/cropper.js"></script>
    <script src="../js/main.js"></script>
    <script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
    <style type="text/css">

        td{vertical-align:top;padding-left:10px;}
        .div_photo{
            position:absolute;
            width:150px;
            height:150px;
            border-radius:100px;
        }
    </style>
    <script type="text/javascript">
        var data;

        function getData(){
            var result= $('#cropper-img').cropper("getCroppedCanvas");
            data=result.toDataURL('image/jpeg',1);//获取剪裁的图片并且转为base64格式
            $("#data").val(data);//将剪裁后的base64代码保存的隐藏域中

            $("#isValidate").val(1);//设置是否校验通过

        }
        $.openModel({
            url:'editPhoto.jsp',
            frameId:'bLogoFrame',
            id:'bLogoModel',
            width:900,
            ok:'getCropData'//点击确定按钮执行的函数
        });

    </script>
</head>
<body onload="javascript:$('#cropper-img').cropper('setAspectRatio',1);"><!-- 初始化剪裁你插件的剪裁比例为1:1，如需要其他的查看文档修改-->

<input style="display:none;" id="getData" onclick="getData();" type="button" value="确定"/>
<input id="isValidate" type="hidden" value="0"/>
<input id="picName" type="hidden" value=""/>
<input id="data" type="hidden" value=""/>
<table style="margin-top:20px;">
    <tr style="height:200px;">
        <td rowspan="3">
            <div class="img-container" style="width:630px;height:400px;margin-left:0px;">

                <!-- 传递到这个页面的url不为空则显示要编辑的图片，否则显示默认的图片-->

                <c:choose>
                    <c:when test="${url != null and url !='' }">
                        <img id="cropper-img" src="${url }">
                    </c:when>
                    <c:otherwise>
                        <img id="cropper-img" src="${ctx }/res/img/upimg.jpg">
                    </c:otherwise>
                </c:choose>
            </div>
        </td>
        <td>
            <div class="docs-preview clearfix">
                <div class="img-preview preview-lg"></div>
            </div>
            <div class="docs-preview clearfix">
                <div class="img-preview preview-lg div_photo"></div>
            </div>
        </td>
    </tr>
    <tr style="height:20px;">
        <td>
            <div class="btn-group">
                <label class="btn btn-primary btn-upload" style="border:0px;background-color:red;" for="inputImage" title="Upload image file">
                    <input class="sr-only" id="inputImage" name="file" type="file" accept="image/*">
                    <span class="docs-tooltip pull-left" data-toggle="tooltip" title="选择文件">
                  <span class="icon icon-upload"></span>
                </span>
                    <span class="pull-right">&nbsp;选择图片</span>
                </label>
            </div>
        </td>
    </tr>
    <tr style="height:20px;">
        <td>
            <div class="btn-group">
                <button class="btn btn-primary" data-method="setDragMode" data-option="move" type="button" title="移动">
                <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;setDragMode&quot;, &quot;move&quot;)">
                  <span class="icon icon-move"></span>
                </span>
                </button>
                <button class="btn btn-primary" data-method="setDragMode" data-option="crop" type="button" title="裁剪">
                <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;setDragMode&quot;, &quot;crop&quot;)">
                  <span class="icon icon-crop"></span>
                </span>
                </button>
                <button class="btn btn-primary" data-method="zoom" data-option="0.1" type="button" title="放大">
                <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;zoom&quot;, 0.1)">
                  <span class="icon icon-zoom-in"></span>
                </span>
                </button>
                <button class="btn btn-primary" data-method="zoom" data-option="-0.1" type="button" title="缩小">
                <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;zoom&quot;, -0.1)">
                  <span class="icon icon-zoom-out"></span>
                </span>
                </button>
                <button class="btn btn-primary" data-method="rotate" data-option="-45" type="button" title="向左旋转">
                <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;rotate&quot;, -45)">
                  <span class="icon icon-rotate-left"></span>
                </span>
                </button>
                <button class="btn btn-primary" data-method="rotate" data-option="45" type="button" title="向右旋转">
                <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;rotate&quot;, 45)">
                  <span class="icon icon-rotate-right"></span>
                </span>
                </button>
            </div>
        </td>
    </tr>
</table>
</body>
</html>