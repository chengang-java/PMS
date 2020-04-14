<template>
	<div class="tab-bar-item" v-on:click="itemClick">
		<div v-if="!isActive"><slot  name="item-icon"></slot></div>
		<div v-else><slot  name="item-icon-active"></slot></div>
		<div v-bind:style="activeColor"><slot  name="item-text"></slot></div>
	</div>
</template>

<script>
	export default {
	  name: 'TabBarItem',
	  props:{
		  path:String,
		  active_color:{
			  type:String,
			  default:'deepPink'
		  }
	  },
	  data(){
		  return{
			  // isActive:true
		  }
		},
		computed:{
			isActive(){
				return this.$route.path.indexOf(this.path)!==-1
			},
			activeColor(){
				return this.isActive?{color:this.active_color}:{}
			}
		},
	   methods:{
			itemClick:function(){
				console.log(this.path)
				this.$router.replace(this.path);
			}
		}
	}
</script>

<style>
	.tab-bar-item {
		 flex: 1;
		 text-align: center;
		 height: 49px;
	}
	.tab-bar-item img{
		width: 24px;
		height: 25px;
	}
</style>
