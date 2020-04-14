<template>
  <div id="app">
	   <h1>{{message}}</h1>
	   <h1>{{$store.getters.powerCounter}}</h1>
	   <h3>{{$store.getters.moreThan20}}</h3>
	   <h4>{{$store.getters.ageIs(20)}}</h4>
	 <!--  <button v-on:click="$store.commit.commit()">+</button>
	   <button v-on:click="$store.mutations.decrement">-</button> -->
	   <button v-on:click="addCounter">+</button>
	   <button v-on:click="increCounter">-</button>
	   <button v-on:click="addConunt(5)">+5</button>
	   <button v-on:click="inConunt(5)">-5</button>
	   <router-view></router-view>
	   
  </div>
</template>

<script>
	import home from "@/views/Home.vue"
	export default{
		name:"App",
		data(){
			return{
				message:"app主键",
			}
		},
		methods:{
			addCounter:function(){
				this.$store.commit('increment')
			},
			increCounter:function(){
				this.$store.commit('decrement')
			},
			addConunt:function(count){
				console.log("+5");
				this.$store.commit('addCount',count)
			},
			inConunt:function(count){
				console.log("-5");
				this.$store.commit('inCount',count)
				
			}
		}
	}
</script>

<style>

</style>
