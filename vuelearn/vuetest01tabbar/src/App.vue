<template>
	<div id="app">
		<div id="header">
			<tab-bar>
				<tab-bar-item path="/home" >
					<img slot="item-icon" src="~assets/img/tabbar/tabbaritem/home.svg" alt=""/>
					<img slot="item-icon-active" src="./assets/img/tabbar/tabbaritem/home_active.svg" alt=""/>
					<div slot="item-text">首页</div>
				</tab-bar-item>
				<tab-bar-item path="/work">
					<img slot="item-icon" src="./assets/img/tabbar/tabbaritem/work.svg" alt=""/>
					<img slot="item-icon-active" src="./assets/img/tabbar/tabbaritem/work_active.svg" alt=""/>
					<div slot="item-text">考勤</div>
				</tab-bar-item>
				<tab-bar-item path="/bill">
					<img slot="item-icon" src="./assets/img/tabbar/tabbaritem/bill.svg" alt=""/>
					<img slot="item-icon-active" src="./assets/img/tabbar/tabbaritem/bill_active.svg" alt=""/>
					<div slot="item-text">发票报销</div>
				</tab-bar-item>
				<tab-bar-item path="/person">
					<img slot="item-icon" src="./assets/img/tabbar/tabbaritem/person.svg" alt=""/>
					<img slot="item-icon-active" src="./assets/img/tabbar/tabbaritem/person_active.svg" alt=""/>
					<div slot="item-text">新人入职</div>
				</tab-bar-item>
			</tab-bar>
		</div>
		<router-view></router-view>
  </div>
</template>

<script>
	import TabBar from './components/tabbar/TabBar.vue'
	import TabBarItem from './components/tabbar/TabBarItem.vue'
	export default{
			name:'App',
			components:{
				TabBar,
				TabBarItem
			}
		}
</script>

<style>
	 @import url("assets/css/base.css"); 
</style>
