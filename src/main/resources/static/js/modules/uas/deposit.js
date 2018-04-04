$(function () {
    initDatePicker();
    $("#jqGrid").jqGrid({
        url: baseURL + 'generator/deposit/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', width: 50, key: true},
            {label: '充值时间', name: 'chargeDate', index: 'charge_date', width: 80, formatter: getMyDateTime},
            {label: '充值金额', name: 'chargeMoney', index: 'charge_money', width: 80},
            {label: '充值状态(0:成功，1:失败)', name: 'status', index: 'status', width: 80, formatter: showStatus},
            {label: '充值人身份(1:学员，2：教员)', name: 'organiser', index: 'organiser', width: 80, formatter: showOrganiser},
            {label: '充值人id', name: 'organiserId', index: 'organiser_id', width: 80}
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
        deposit: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.deposit = {};
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
            var url = vm.deposit.id == null ? "generator/deposit/save" : "generator/deposit/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.deposit),
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
                    url: baseURL + "generator/deposit/delete",
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
            $.get(baseURL + "generator/deposit/info/" + id, function (r) {
                vm.deposit = r.deposit;
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

function showStatus(status) {

    if (status == 0) {
        return "<span class='label label-success'>成功</span>";
    } else if (status == 1) {
        return "<span class='label label-danger'>失败</span>";
    } else {
        return "<span class='label label-danger'>未知状态</span>";
    }
}
function showOrganiser(organiser) {
    if (organiser == 1) {
        return "学员";
    } else if (organiser == 2) {
        return "教员";
    } else {
        return "未知身份";
    }
}