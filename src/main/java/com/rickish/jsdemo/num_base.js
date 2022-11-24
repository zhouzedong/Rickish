var test_num = (1342424329.1999999).toFixed(3);

var re_num = num_base(test_num);
console.log("返回值：" + re_num);

function num_base(num1) {
    const replaceStr = (str, index, char) => {
        const strAry = str.split('');
        strAry[index] = char;
        return strAry.join('');
    }
    num =num1 +'';
    var origi_num = num.substring(0,num.indexOf(".") + 3);

    var _num = num.substring(0,num.indexOf(".") + 4);
    console.log('直接截取小数点后两位，不做四舍五入');
    console.log("传入的数：" + num1);
    console.log("原数返回：" + origi_num);
    //传入一个三位数，判定有几位小数
    var _positive = num1.split(".")[0];
    var _decimal = num1.split(".")[1];

    var _detai_1 = _decimal.charAt(0);
    var _detai_2 = _decimal.charAt(1);
    var _detai_3 = _decimal.charAt(2);
    console.log("获取小数点左边部分：" + _positive+"获取小数点右边部分：" + _decimal);
    console.log("传入的数，小数第一位为："+_decimal.charAt(0));
    console.log("传入的数，小数第二位为："+_decimal.charAt(1));
    console.log("传入的数，小数第三位为："+_decimal.charAt(2));
    if(_detai_3 =='0'){
        console.log("这个数的小数其实只有两位数");
        // 去除0
        return origi_num;
    }else{
        console.log("这个数的小数有三位数,需要第二位进一");
        if(_detai_2 =='9'){
            // 第二位是9 小数第二位变为0，第一位加一
            if(_detai_1 =='9'){
            //第一位是9
                var origi_num =  parseInt(_positive)+1;
                //小数点左边加1
                return origi_num;
            }else{
                console.log("第二位是9，第一位不是9");
                return parseFloat(num1).toFixed(2);
            }
        }else{
        //第二位不是9
            var repl_detai_2 = parseInt(_detai_2)+1;
            console.log("第二位（非9）加一:"+repl_detai_2);
            var repl_reture_num = replaceStr(_num,(_num.length-2),repl_detai_2);
            var repl_reture_num_end = repl_reture_num.substring(0,num.indexOf(".") + 3)
            return  repl_reture_num_end;
        }
    }
}

