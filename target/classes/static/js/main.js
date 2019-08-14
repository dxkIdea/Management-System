initTree = function () {
    layui.use("tree",function () {
        var tree = layui.tree;

        var treeContext = tree.render({
            elem : "#tree",
            data : [{
                title: "1",
                children : [{
                    title : "1.1"
                }]
            }]
        });
    })
};
getVerCode = function (obj) {
    obj.src = "http://127.0.0.1:8080/getVerCode?"+Math.random();
}