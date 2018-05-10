$(function () {
    initDatePicker();
    $("#jqGrid").jqGrid({
        url: baseURL + 'generator/student/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', width: 50, key: true},
            {label: '学员用户名', name: 'name', index: 'name', width: 80},
            {label: '性别', name: 'sex', index: 'sex', width: 80, formatter: showSex},
            {label: '登录密码', name: 'password', index: 'password', width: 80},
            {label: '联系电话', name: 'phone', index: 'phone', width: 80},
            {label: '注册邮箱', name: 'email', index: 'email', width: 80},
            {label: '上次登录ip', name: 'lastIp', index: 'last_ip', width: 80},
            {label: '上次登录时间', name: 'lastTime', index: 'last_time', width: 80, formatter: getMyDateTime},
            {label: '注册时间', name: 'regTime', index: 'reg_time', width: 80, formatter: getMyDateTime},
            {label: '账户余额', name: 'balance', index: 'balance', width: 80},
            {label: '账户状态', name: 'isabled', index: 'isabled', width: 80, formatter: showabled},
            {label: '登陆次数', name: 'loginTimes', index: 'login_times', width: 80}
        ],
        viewrecords: true,
        height: 385,
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
        student: {},
        q: {
            startTime:null,
            endTime:null,
            studentName:null,
            email:null
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.student = {};
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
        forbidden: function () {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            confirm('确定要禁用的学员？', function () {
                console.log("id = " + id)
                $.ajax({
                    type: "POST",
                    url: baseURL + "generator/student/forbidden",
                    data: {
                        "id": id
                    } ,
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

            confirm('确定要禁用所选的学员？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "generator/student/recover",
                    data:  {
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
        saveOrUpdate: function (event) {
            var url = vm.student.id == null ? "generator/student/save" : "generator/student/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.student),
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
                    url: baseURL + "generator/student/delete",
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
            $.get(baseURL + "generator/student/info/" + id, function (r) {
                vm.student = r.student;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            vm.q.startTime = $("#startTime").val();
            vm.q.endTime = $("#endTime").val();
            console.log(vm.q);
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