//iframe自适应
$(window).on('resize', function () {
    var $content = $('.content');
    $content.height($(this).height() - 120);
    $content.find('iframe').each(function () {
        $(this).height($content.height());
    });
}).resize();


var vm = new Vue({
    el: '#rrapp',
    data: {
        main: "welcome.html",
        navTitle: "欢迎页"
    },
    methods: {
        updatePassword: function () {
            layer.open({
                type: 1,
                skin: 'layui-layer-molv',
                title: "修改密码",
                area: ['550px', '300px'],
                shadeClose: false,
                content: jQuery("#passwordLayer"),
                btn: ['修改', '取消'],
                btn1: function (index) {
                    var data = "oldPassword=" + vm.oldPassword + "&newPassword=" + vm.newPassword + "&twicePassword=" + vm.twicePassword;
                    $.ajax({
                        type: "POST",
                        url: baseURL + "employee/modifyMyPassword",
                        data: data,
                        dataType: "json",
                        success: function (r) {
                            if (r.code == 0) {
                                layer.close(index);
                                layer.alert('修改成功', function () {
                                    location.reload();
                                });
                            } else {
                                layer.alert(r.msg);
                            }
                        }
                    });
                },
                btn2: function (index, layero) {
                    vm.oldPassword = null;
                    vm.newPassword = null;
                    vm.twicePassword = null;
                }
            });
        },
        logout:function () {
            logout();
        }
    }
});

//路由
var router = new Router();
var menus = ["welcome.html", "forder.html", "favorite.html", "picture.html", "teacher.html",
    "student.html", "admin.html", "appointment.html", "comment.html", "deposit.html", "teacherdesire.html", "teacherrequirement.html"];
routerList(router, menus);
router.start();

function routerList(router, menus) {
    for (var index in menus) {
        router.add('#' + menus[index], function () {
            var url = window.location.hash;

            //替换iframe的url
            vm.main = url.replace('#', '');

            //导航菜单展开
            $(".treeview-menu li").removeClass("active");
            $("a[href='" + url + "']").parents("li").addClass("active");

            vm.navTitle = $("a[href='" + url + "']").text();
        });
    }
}

$(function () {
    checkLogin();
});

function checkLogin() {
    $.ajax({
        url:'/generator/admin/checklogin',
        type: "POST",
        dataType: "json",
        success:function (data) {
            if(data.code != 0)
                window.location.href="login.html";
        }
    });
}

function logout() {
    $.ajax({
        url:'/generator/admin/logout',
        type: "POST",
        dataType: "json",
        success:function (data) {
            if(data.code == 0)
                window.location.reload();
        }
    });
}