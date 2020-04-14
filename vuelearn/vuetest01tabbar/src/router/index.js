import Vue from 'vue'
import VueRouter from 'vue-router'

import home from '../views/home/Home.vue'
import Login from '../views/login/Login.vue'
import Work from '../views/work/Work.vue'
import Bill from '../views/bill/Bill.vue'

Vue.use(VueRouter)

  const routes = [
		{
			path:'',
			redirect:'/home'
		},
		{
			path:'/login',
			component:Login
		},
		{
			path:'/home',
			component:home,
		},
		{
			path:'/bill',
			component:Bill
		},
		{
			path:'/work',
			component:Work
		}
	]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
