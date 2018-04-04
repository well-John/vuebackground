$(function () {
    initDatePicker();
    $("#jqGrid").jqGrid({
        url: baseURL + 'generator/teacherrequirement/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', width: 50, key: true},
            {label: '学员id', name: 'studentId', index: 'student_id', width: 80},
            {label: '联系人', name: 'concat', index: 'concat', width: 80},
            {label: '联系人性别', name: 'sex', index: 'sex', width: 80, formatter: showSex},
            {label: '学员年龄', name: 'age', index: 'age', width: 80},
            {label: '学员年级', name: 'grade', index: 'grade', width: 80},
            {label: '联系电话', name: 'phone', index: 'phone', width: 80},
            {label: '电子邮件', name: 'email', index: 'email', width: 80},
            {label: '所在区域', name: 'area', index: 'area', width: 80},
            {label: '详细地址', name: 'address', index: 'address', width: 80},
            {label: '辅导科目', name: 'subject', index: 'subject', width: 80},
            {label: '学员状态详细描述', name: 'studentDescription', index: 'student_description', width: 80},
            {
                label: '学员状态',
                name: 'studentLevel',
                index: 'student_level',
                width: 80,
                formatter: showStudentLevel
            },
            {label: '授课时间', name: 'teachingTime', index: 'teaching_time', width: 80},
            {label: '需求人数', name: 'requireCount', index: 'require_count', width: 80},
            {label: '性别要求', name: 'requireSex', index: 'require_sex', width: 80, formatter: showSex},
            {label: '身份要求', name: 'identity', index: 'identity', width: 80, formatter: showidentity},
            {label: '资格要求', name: 'requirement', index: 'requirement', width: 80},
            {label: '薪酬要求', name: 'payment', index: 'payment', width: 80},
            {label: '辅导方式', name: 'teachingType', index: 'teaching_type', width: 80},
            {
                label: '乘车补贴',
                name: 'ridingAllowance',
                index: 'riding_allowance',
                width: 80,
                formatter: showRidingAllowance
            },
            {label: '发布时间', name: 'releaseTime', index: 'release_time', width: 80, formatter: getMyDateTime},
            {
                label: '发布状态',
                name: 'releaseStatus',
                index: 'release_status',
                width: 80,
                formatter: showReleaseStatus
            }
        ],
        viewrecords: true,
        height: 475,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        shrinkToFit: false,
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
        teacherRequirement: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.teacherRequirement = {};
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
            $("#myModal").modal("show");
        },
        saveOrUpdate: function (event) {
            var url = vm.teacherRequirement.id == null ? "generator/teacherrequirement/save" : "generator/teacherrequirement/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.teacherRequirement),
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
                    url: baseURL + "generator/teacherrequirement/delete",
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
            $.get(baseURL + "generator/teacherrequirement/info/" + id, function (r) {
                vm.teacherRequirement = r.teacherRequirement;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                page: page,
                postData: {
                    startTime: $("#startTime").val(),
                    endTime: $("#endTime").val()
                }
            }).trigger("reloadGrid");
        }
    }
});


function showStudentLevel(studentLevel) {
    if (studentLevel == 0) {
        return "零基础";
    } else if (studentLevel == 1) {
        return "补差型";
    } else if (studentLevel == 2) {
        return "提高型";
    } else if (studentLevel == 3) {
        return "拔尖型";
    } else {
        return "未知类型";
    }
}

function showRidingAllowance(allowance) {
    if (allowance == 0) {
        return "无";
    } else if (allowance == 1) {
        return "有";
    } else if (allowance == 2) {
        return "部分";
    } else if (allowance == 3) {
        return "协商";
    } else {
        return "未知";
    }
}

function showReleaseStatus(status) {
    if (status == 0) {
        return "<span class='label label-warning'>未审核</span>";
    } else if (status == 1) {
        return "<span class='label label-success'>发布中</span>";
    } else if (status == 2) {
        return "<span class='label label-danger'>审核不通过</span>";
    } else if (status == 3) {
        return "<span class='label label-default'>已关闭</span>";
    } else {
        return "<span class='label label-danger'>未知状态</span>";
    }
}

function checkRequire(status) {
    var id = getSelectedRow();
    var rowData = $("#jqGrid").jqGrid('getRowData', id);
    if (rowData.releaseStatus.indexOf("未审核") == -1) {
        alert("已经审核过了,不能重复审核！！！");
        return;
    }
    $.ajax({
        url: 'generator/teacherrequirement/checkRequire',
        type: 'post',
        dataType: "json",
        async: false,
        data: {'status': status, 'id': id},
        success: function (data) {
            if (data.code == 0) {
                $("#myModal").modal('hide');
                vm.reload();
            } else {
                alert(data.msg);
            }
        }
    });
}