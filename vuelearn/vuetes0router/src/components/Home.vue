<template>
	<div>
		首页!!!!!!
		<router-view></router-view>
		<router-link to="/home/news" tag="button">新闻</router-link>
		<router-link to="/home/list" tag="button">列表</router-link>
	</div>
</template>

<script>
	export default{
		name:'Home',
		created() {
			console.log("home 被创建")
		},
		destroyed() {
			console.log("home 被销毁")
		},
		activated() {
				console.log("home处于活跃状态")
		},
		deactivated(){
			console.log("home处于非活跃状态")
		},
		// beforeRouteLeave(to,from,next) {
		// 	this.path=this.$route.path;
		// 	next();
		// }
	}
		
</script>

<style>
</style>
