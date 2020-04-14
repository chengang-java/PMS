<template>
	<div>
		<h1>我是profile页面</h1>
		<table>
			<h1>{{$route.query.name}}</h1>
			<ul>
				<li>{{$route.query.name}}</li>
				<li>{{$route.query.age}}</li>
				<li>{{$route.query.sex}}</li>
			</ul>
		</table>
	</div>
</template>

<script>
	export default{
		name:'Profile',
		created() {
			console.log("Profile 被创建")
		},
		destroyed() {
			console.log("Profile 被销毁")
		},
		activated() {
				console.log("Profile处于活跃状态")
		},
		deactivated(){
			console.log("Profile处于非活跃状态")
		},
	}
</script>

<style>
</style>
