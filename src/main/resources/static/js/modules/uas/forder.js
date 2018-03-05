$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'generator/forder/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '发布时间', name: 'releaseDate', index: 'release_date', width: 80 ,formatter:getMyDateTime},
			{ label: '年级科目', name: 'subject', index: 'subject', width: 80 }, 			
			{ label: '订单状态', name: 'status', index: 'status', width: 80,formatter:showStatus},
			{ label: '预约记录id', name: 'appointmentId', index: 'appointment_id', width: 80 }, 			
			{ label: '处理人id', name: 'adminId', index: 'admin_id', width: 80 }, 			
			{ label: '管理员', name: 'adminName', index: 'admin_name', width: 80 },
			{ label: '教员', name: 'teacherId', index: 'teacher_id', width: 80 },
			{ label: '学员', name: 'studentId', index: 'student_id', width: 80 },
			{ label: '家教记录id', name: 'teacherRequirementId', index: 'teacher_requirement_id', width: 80 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		forder: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.forder = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.forder.id == null ? "generator/forder/save" : "generator/forder/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.forder),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "generator/forder/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "generator/forder/info/"+id, function(r){
                vm.forder = r.forder;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});
function showStatus(status) {
	if (status == 1) {
        return "<span class='label label-warning'>待支付</span>";
	} else if(status == 2){
        return "<span class='label label-success'>成功</span>";
	} else if(status == 3){
		return "<span class='label label-danger'>失败</span>";
	} else if(status == 4){
		return "<span class='label label-default'>已关闭</span>";
	}else {
		return "<span class='label label-danger'>未知状态</span>";
	}
}