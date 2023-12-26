let app = new Vue({
    el: '#yc-login',
    data: {
        isLogin: false,
        isOutLogin: true,
        mname: ''
    },
    methods: {},
    mounted: function () {
        axios.get("member?op=check").then(rs => {
            // console.log(rs);
            if(rs.data.code == 601){
                //暂未登录
                location.href = 'login.html';
            }else {
                this.isLogin = true;
                this.isOutLogin = false;
                this.mname = rs.data.data.mname;
            }
        });
    }
});