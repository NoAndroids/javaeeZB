/**
 * Created by jackiechan on 2017/4/30.
 */
//所有的学生名单
var students=["张三","李四","王五","赵六","fsdf","fsdfasdf","方式发顺丰","嘎嘎嘎撒大哥","飞洒发的说法","张三","李四","王五","赵六","fsdf","fsdfasdf","方式发顺丰","嘎嘎嘎撒大哥","飞洒发的说法","张三","李四","王五","赵六","fsdf","fsdfasdf","方式发顺丰","嘎嘎嘎撒大哥","飞洒发的说法","张三","李四","王五","赵六","fsdf","fsdfasdf","方式发顺丰","嘎嘎嘎撒大哥","飞洒发的说法","张三","李四","王五","赵六","fsdf","fsdfasdf","方式发顺丰","嘎嘎嘎撒大哥","飞洒发的说法","张三","李四","王五","赵六","fsdf","fsdfasdf","方式发顺丰","嘎嘎嘎撒大哥","飞洒发的说法"];
var index=-1;//上次选中的是谁
var span;//每次被选中的
var id;//循环的 id
function cretae() {
    //创建每个学生的区域
    var parent=document.getElementById("parent");//找到用于显示学生的 div
    //遍历学生
    for(var i =0;i<students.length;i++){
        var span = document.createElement("span");
        span.innerHTML=students[i]
        span.id="id"+i;//添加一个标记,用于获取的时候使用
        //创建元素
        //添加到 div 中
        span.className="spans";//指定样式为 spans
        parent.appendChild(span)
    }

}
//只管变化,不管循环,循环交给定时器去处理
function start() {
    //问题,循环的时候上次被选中的没有清掉,需要清掉
    if (index!=-1){
        //需要清理
        span= document.getElementById( "id"+index);
        span.className="spans";//恢复默认
    }

        //生成一个随机数
        //根据随机数,找到那个 span. 然后变色
        index =Math.round(Math.random()*100000000)%students.length;//这么一个数被重复随机到的几率会更小,
        span= document.getElementById( "id"+index);
        span.className="selected";
}

function  begain() {
    id = setInterval(start,100);
}
function stop() {
    //停止循环
    clearInterval(id)
    //弹出一个框,显示谁被选中了
    //根据 index 去数组中找对应的名字
    //为了方式不点开始就点结束
    if (index!=-1){
       alert("点到的人是---"+ students[index])
    }
}