$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'generator/picture/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', width: 50, key: true},
            {label: '教员', name: 'teacherId', index: 'teacher_id', width: 80},
            {label: '图片类型', name: 'type', index: 'type', width: 80, formatter: showPicType},
            {label: '图片', name: 'path', index: 'path', width: 130, formatter: showimg},
            {label: '上传时间', name: 'uploadTime', index: 'upload_time', width: 80, formatter: getMyDateTime},
            {label: '审核状态', name: 'status', index: 'status', width: 80, formatter: showStatus}
        ],
        viewrecords: true,
        height: 785,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        picture: {},
        q: {path: null}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.picture = {};
        },
        update: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },
        check: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            var rowData = $("#jqGrid").jqGrid('getRowData',id);
            $("#img").empty();
            $("#img").append($(rowData.path).data("action","zoom"));
            $("#myModal").modal("show");
        },
        saveOrUpdate: function (event) {
            var url = vm.picture.id == null ? "generator/picture/save" : "generator/picture/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.picture),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "generator/picture/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getInfo: function (id) {
            $.get(baseURL + "generator/picture/info/" + id, function (r) {
                vm.picture = r.picture;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                page: page
            }).trigger("reloadGrid");
        }
    }
});

function showStatus(status) {
    if (status == 0)
        return "<span class='label label-warning'>未审核</span>";
    else if (status == 1)
        return "<span class='label label-success'>已审核</span>";
    else if (status == 2)
        return "<span class='label label-danger'>未通过</span>";
}
function showPicType(type) {
    if (type == 0) {
        return "头像";
    }
}

function showimg(img) {
    if (img != null) {
        return '<img style="width: 80px" src="'+img+'" alt="' + img + '" data-action="zoom" />';
    }
    return "";
}

function checkImg(status) {
    var id = getSelectedRow();
    if (id == null) {
        return;
    }
    var rowData = $("#jqGrid").jqGrid('getRowData',id);
    if(rowData.status.indexOf("已审核") != -1){
        alert("图片已经审核过了！！！");
        return;
    }
    $.ajax({
        url:'generator/picture/checkImg',
        type:'post',
        dataType:"json",
        async:false,
        data:{'status':status,'id':id},
        success:function(data){
            if(data.code == 0){
                $("#myModal").modal('hide');
                vm.reload();
            }else{
                alert(data.msg);
            }
        }
    });
}