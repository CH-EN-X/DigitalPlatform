let xmlHttp;

//创建XMLHttpRequest
function createRequest() {
    if (window.XMLHttpRequest) {
        //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlHttp = new XMLHttpRequest();
    } else {
        // IE6, IE5 浏览器执行代码
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlHttp;
}


function ajax(method, url, params, fn) {

    //method POST  或 GET
    //url  地址
    //params    参数   object对象
    //fn    方法
    //参数处理
    //参数处理
    let str = '';
    if (params != null) {

        for (let i in params) {
            str += i + "=" + params[i] + "&";
        }
        str = str.substring(0, str.length - 1);
    }
    if ("GET" == method) {
        if (url.indexOf("?") > 0) { //url?op=add
            url = url + "&" + str;
        } else {
            url = url + "?" + str;
        }

        if (url.lastIndexOf("&") == url.length - 1) {
            url = url.substring(0, url.length - 1);
        }
    }

    let xmlHttp = createRequest();
    xmlHttp.open(method, url, true);
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4) {
            if (xmlHttp.status == 200) {
                let info = xmlHttp.responseText;
                console.log(info);
                info = $.parseJSON(info);

                fn(info);
            } else {
                alert('解析异常' + xmlHttp.status);
            }
        }
    }


    if ("POST" == method) {
        xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xmlHttp.send(str);

    } else {
        xmlHttp.send(null);
    }

}