<template>
	<div>
		<h2>用户信息</h2>
		<h2>用户id{{userId}}</h2>
		<h2>用户id{{$route.params.userId}}</h2>
	</div>
</template>

<script>
	export default{
		name:'User',
		computed:{
			userId(){
				return this.$route.params.userId
			}
		},
		created() {
			console.log("user 被创建")
		},
		destroyed() {
			console.log("user 被销毁")
		},
		activated() {
				console.log("user处于活跃状态")
		},
		deactivated(){
			console.log("user处于非活跃状态")
		},
	}
</script>

<style>
</style>
