$(function () {
    initDatePicker();
    //图片上传结果回调函数
    $("#uploadFile").on("fileuploaded", function (event, data, previewId, index) {
        if (data.response.code == 0) {
            alert("上传成功");
            $("#myModal").modal("hide");
            vm.reload();
        } else {
            alert("上传失败");
        }
    });

    //模态框隐藏触发事件
    $("#myModal").on('hide.bs.modal', function () {
        //清除上传图片的样式
        $("#uploadFile").empty();
        $(".kv-file-remove").trigger("click");
    });

    $("#jqGrid").jqGrid({
        url: baseURL + 'generator/teacher/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', width: 50, key: true},
            {label: '真实姓名', name: 'name', index: 'name', width: 80},
            {label: '性别', name: 'sex', index: 'sex', width: 40, formatter: showSex},
            {label: '出生年月', name: 'birthday', index: 'birthday', width: 80},
            {label: '最高学历', name: 'education', index: 'education', width: 80},
            {label: '所学专业', name: 'major', index: 'major', width: 120},
            {label: '就读大学', name: 'university', index: 'university', width: 120},
            {label: '联系电话', name: 'phone', index: 'phone', width: 80},
            {label: '电子邮箱', name: 'email', index: 'email', width: 150},
            {label: '辅导经验', name: 'teachingTime', index: 'teaching_time', width: 120},
            {label: '家教经历', name: 'experience', index: 'experience', width: 120},
            {
                label: '头像',
                name: 'avatar',
                index: 'avatar',
                width: 80,
                sortable: false,
                editable: false,
                formatter: showimg
            },
            {label: '上次登录时间', name: 'lastTime', index: 'last_time', width: 140, formatter: getMyDateTime},
            {label: '注册时间', name: 'registerTime', index: 'register_time', width: 140, formatter: getMyDateTime},
            {label: '上次登录ip', name: 'lastIp', index: 'last_ip', width: 120},
            {label: '状态', name: 'isabled', index: 'isabled', width: 80, formatter: showabled},
            {label: '职业', name: 'identity', index: 'identity', width: 120, formatter: showidentity},
            {label: '目前身份', name: 'currentStatus', index: 'current_status', width: 120},
            {label: '是否已验证身份', name: 'isverify', index: 'isverify', width: 120, formatter: showVerify}
        ],
        viewrecords: true,
        height: 475,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        shrinkToFit: false,
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
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "scroll"});
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        teacher: {},
        q: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.teacher = {};
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
        saveOrUpdate: function (event) {
            var url = vm.teacher.id == null ? "generator/teacher/save" : "generator/teacher/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.teacher),
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
        forbidden: function () {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            var rowData = $("#jqGrid").jqGrid('getRowData', id);
            if (rowData.isabled.indexOf("禁用") != -1) {
                alert("该教员已被禁用，不可重复禁用");
                return;
            }
            confirm('确定要禁用所选中的教员？', function () {
                console.log("id = " + id);

                $.ajax({
                    type: "POST",
                    url: baseURL + "generator/teacher/forbidden",
                    data: {
                        "id": id
                    },
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
        recover: function () {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            var rowData = $("#jqGrid").jqGrid('getRowData', id);
            if (rowData.isabled.indexOf("正常") != -1) {
                alert("该教员状态正常，不可重复恢复");
                return;
            }
            var rowData = $("#jqGrid").jqGrid('getRowData');
            console.log(rowData);
            confirm('确定要恢复所选的教员？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "generator/teacher/recover",
                    data: {
                        "id": id
                    },
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
        upload: function () {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            $("#myModal").modal('show');
            initFileInput("uploadFile", "upload/avatar?id=" + id);
        },
        del: function (event) {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "generator/teacher/delete",
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
            $.get(baseURL + "generator/teacher/info/" + id, function (r) {
                vm.teacher = r.teacher;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            vm.q.startTime = $("#startTime").val();
            vm.q.endTime = $("#endTime").val();
            $("#jqGrid").jqGrid('setGridParam', {
                page: page,
                postData: vm.q
            }).trigger("reloadGrid");
        }
    }
});

function showabled(abled) {
    if (abled == 0)
        return "<span class='label label-warning'>未验证邮箱</span>";
    else if (abled == 1)
        return "<span class='label label-danger'>禁用</span>";
    else if (abled == 2)
        return "<span class='label label-success'>正常</span>";
}


function showimg(img) {
    if (img != null) {
        return '<img style="width: 80px;height: 60px" src="' + img + '" alt="' + img + '" data-action="zoom" />';
    }
    return "";
}
function initFileInput(ctrlName, uploadUrl) {
    var control = $('#' + ctrlName);
    console.log(ctrlName);
    console.log(uploadUrl);
    control.fileinput({
        language: 'zh', //设置语言
        uploadUrl: uploadUrl, //上传的地址
        enctype: 'multipart/form-data',
        allowedFileExtensions: ['jpg', 'png', 'bmp', 'jpeg'],//接收的文件后缀
        showUpload: true, //是否显示上传按钮
        showPreview: true,              //展前预览
        showCaption: false,//是否显示标题
        maxFileSize: 10000,//上传文件最大的尺寸
        maxFileCount: 1,//
        minFileCount: 0,
        dropZoneEnabled: true,//是否显示拖拽区域
        browseClass: "btn btn-primary", //按钮样式
        uploadAsync: true,//为true回调才有用
        layoutTemplates: {
            // actionDelete:'', //去除上传预览的缩略图中的删除图标
            actionUpload: '',//去除上传预览缩略图中的上传图片；
            actionZoom: ''   //去除上传预览缩略图中的查看详情预览的缩略图标。
        }
    });
}

function showVerify(verify) {
    if (verify == 0) {
        return "<span class='label label-danger'>未验证身份信息</span>";
    } else if (verify == 1) {
        return "<span class='label label-warning'>未验证教师信息</span>";
    } else if (verify == 2) {
        return "<span class='label label-success'>已验证</span>";
    } else {
        return "<span class='label label-danger'>未知异常</span>";
    }
}