// import Vue from 'vue'
// import VueRouter from 'vue-router'
// import Home from '../views/Home.vue'

// Vue.use(VueRouter)

//   const routes = [
//   {
//     path: '/',
//     name: 'Home',
//     component: Home
//   },
//   {
//     path: '/about',
//     name: 'About',
//     // route level code-splitting
//     // this generates a separate chunk (about.[hash].js) for this route
//     // which is lazy-loaded when the route is visited.
//     component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
//   }
// ]

// const router = new VueRouter({
//   mode: 'history',
//   base: process.env.BASE_URL,
//   routes
// })

// export default router

import Vue from 'vue'
import VueRouter from 'vue-router'
import home from '../components/Home.vue'
import login from '../components/Login.vue'
import user from '../components/User.vue'
import news from '../components/Home/new.vue'
import list from '../components/Home/list.vue'
import profile from '../components/Profile.vue'
//1.懒加载命名import 打包时会将对应的home多分一个文件夹js保存
//const home = ()=>import('../components/Home.vue')

Vue.use(VueRouter)

const routes=[
	{
		path:'/',
		redirect:"/home"
	},
	{
		path:'/login',
		component:login
	},
	{
		path:'/home',
		component:home,
		meta:{
			title:'首页'
		},
		// //独享守卫
		// beforeEnter:(to,from,next)=>{
		// 	console.log("独享守卫")
		// },
		children:[
			{
				path:'/',
				redirect:"/home/news"
			},
			{
				path:'news',
				component:news
			},
			{
				path:'list',
				component:list
			}
		]
	},
	{
		path:'/user/:userId',
		component:user,
		// //独享守卫
		// beforeEnter:(to,from,next)=>{
		// 	console.log("独享守卫")
		// },
		meta:{
			title:'用户信息详情'
		}
	},
	{
		path:"/profile",
		component:profile,
		// //独享守卫
		// beforeEnter:(to,from,next)=>{
		// 	console.log("独享守卫")
		// },
		meta:{
			title:'profile信息详情'
		}
	}
]
	

const router=new VueRouter({
	routes,
	mode:'history',
	linkActiveClass:'active'
})

//监听路由变化,并做相应的操作
//全局守卫
//前置守卫(gurd)
router.beforeEach(function(to ,from, next){
	//从from 跳到to  且两者类型为route
	document.title=to.matched[0].meta.title,
	//console.log(to),
	//console.log("前置守卫")
	next()
})

//后置守卫(gurd)_
//页面跳转之后执行
// router.afterEach(function(to,from){
// 	console.log("后置守卫")
// })


export default router
