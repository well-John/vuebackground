$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'generator/appointment/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '预约时间', name: 'appointmentDate', index: 'appointment_date', width: 80 ,formatter:getMyDateTime},
			{ label: '教员id', name: 'teacherId', index: 'teacher_id', width: 80 }, 			
			{ label: '学员id', name: 'studentId', index: 'student_id', width: 80 }, 			
			{ label: '预约发起人身份(1:学员，2：教员)', name: 'organiser', index: 'organiser', width: 80 ,formatter:showOrganiser},
			{ label: '预约状态(0:待接受，1：已接受)', name: 'status', index: 'status', width: 80 ,formatter:showStatus},
			{ label: '教员名', name: 'teacherName', index: 'teacher_name', width: 80 }
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
		appointment: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.appointment = {};
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
			var url = vm.appointment.id == null ? "generator/appointment/save" : "generator/appointment/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.appointment),
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
				    url: baseURL + "generator/appointment/delete",
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
			$.get(baseURL + "generator/appointment/info/"+id, function(r){
                vm.appointment = r.appointment;
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

function showOrganiser(organiser) {
	if (organiser == 1){
		return "学员";
	} else if (organiser == 2){
		return "教员";
	} else{
		return "未知身份";
	}
}
function showStatus(status) {
    if (status == 0){
        return "待接受";
    } else if (status == 2){
        return "已接受";
    } else{
        return "未知状态";
    }
}
