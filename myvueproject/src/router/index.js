//配置路由相关信息
import VueRouter from 'vue-router'
import Vue from 'Vue'

//1.通过Vue.use(插件),安装插件
Vue.use(VueRouter)

//2.创建VueRouter对象
const routes=[
	]
const router=new VueRouter({
	routes:routes
	})
//3.将ruter对象传入到vue实例中
export default router