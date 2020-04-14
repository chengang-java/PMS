<template>
  <div id="app">
		<!-- <router-link to="/home" tag="button" replace active-class="active">首页</router-link> --> 
		<!-- <button @click="homeClick">首页</button>
		<button @click="loginClick">登录</button> -->
		<router-link to="/login" tag="button" replace>登录</router-link>
		<router-link to="/home" tag="button" replace >首页</router-link>
		<router-link v-bind:to="'/user/'+userId" tag="button" replace>用户</router-link>
		<!-- <router-link to="/profile" tag="button">profile</router-link> -->
		<router-link v-bind:to="{
			path:'/profile',
			query:{
						name:'cg',
						age:'21',
						sex:'man'
			}
		}" tag="button">profile</router-link>
		<!-- <keep-alive exclude="Profile,User">
			<router-view/>
		</keep-alive> -->
		<keep-alive include="Home">
			<router-view/>
		</keep-alive>
		<button @click="profileClick">profile</button>
  </div>
</template>

<script>
	export default{
		name:'App',
		data(){
			return{
				userId:'张三'
			}
		},
		methods:{
		// 	homeClick(){
		// 		// this.$router.push("/home")
		// 		this.$router.replace("/home")
		// 	},
		// 	loginClick(){
		// 		// this.$router.push("/login")
		// 		this.$router.replace("/login")
		// 	}
			profileClick(){
				this.$router.replace({
					path:"/profile",
					query:{
									name:'cg',
									age:'21',
									sex:'man'
					}
				})
			}
		}
		
	}
</script>

<style>
	.active{
		color:#42B983
	}
</style>
