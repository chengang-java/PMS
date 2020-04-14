import Vue from 'vue'
import Vuex from 'vuex'

//1.安装插件
Vue.use(Vuex);

//2.创建对象
const store=new Vuex.Store({
	state:{
		counter:10,
		students:[
			{name:"cg",age:21,sex:'man'},
			{name:"cg1",age:19,sex:'man'},
			{name:"cg2",age:20,sex:'man'},
			{name:"cg3",age:22,sex:'man'}
		]
	},
	mutations:{
		//方法
		increment(state){
			state.counter++
		},
		decrement(state){
			state.counter--	
		},
		addCount(state,count){
			console.log(count+"addCount");
			state.counter=state.counter+count
		},
		inCount(state,count){
			console.log(count+"inCount");
			state.counter=state.counter-count
		}
	},
	actions:{
		
	},
	getters:{
		powerCounter(state){
			return state.counter*state.counter
		},
		moreThan20(state){
			return state.students.filter(
				s=>s.age>20
				// function(s){
				// 	s.age>20
				// }
			);
		},
		ageIs(state){
			return function(age){
				return state.students.filter(s=>s.age==age);
			}
		}
		
	},
	modules:{
		
	}
	
});

//3.导出
export default store
