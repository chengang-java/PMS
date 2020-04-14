### 1.vue cli

#### 1.安装vue cli

##### 1.1下载node js 安装

node -v 查看安装成功

<img src="C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412151938622.png" alt="image-20200412151938622" style="zoom:200%;" />

##### 1.2安装npm 

npm install npm -g

npm -v

![image-20200412152116528](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412152116528.png)

##### 1.3安装cli 3.0

npm install @vue/cli -g

![image-20200412152216389](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412152216389.png)

vue -V 查看是否安装成功

![image-20200412152315208](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412152315208.png)

### 2.通过cli创建vue模板项目

#### 2.1创建项目

```undefined
vue create project-name
```

#### 2.2启动项目

```undefined
cd project-name
npm run serve
```

### 3.vue router

#### 	1.配置路由

##### 			1.1新建home.view 并导出

<template>
	<div>
		<h1>首页</h1>
		<h1>首页</h1>
		<h1>首页</h1>
		<h1>首页</h1>
		<h1>首页</h1>
	</div>
</template>

<script>
	export default{
		name:"home",
		created() {
			console.log("创建首页")
		}
	}
</script>

<style>
</style>

##### 	1.2配置router

//1.导入home组件

import home from '../views/home/Home.vue'

//2.使用插件路由

Vue.use(VueRouter)

//3.定义路由变量

const routes = [
		{
			path:'',
			redirect:'/home'
		},

}

//4.新建router对象，并导出

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

#### 2.路由的懒加载

//1.懒加载命名import 打包时会将对应的home多分一个文件夹js保存

#### 3.嵌套路由

##### 1.1首页下包含list和news组件路由

![image-20200412154105558](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412154105558.png)

![image-20200412153313793](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412153313793.png)

##### 1.2路由传参params，query对象

路由定义

![image-20200412153625960](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412153625960.png)

app.vue定义

![image-20200412153510402](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412153510402.png)

user定义

![image-20200412153450441](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412153450441.png)

###### query对象参数传递

![image-20200412153716261](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412153716261.png)

#### 4.生命周期函数

created函数组件被创建时

mounted函数组件渲染时



#### 5，全局守卫

独享守卫



#### 6.keepalive 缓存组件，防止组件切换时被销毁

**嵌套路由需要在独享守卫守卫before之后

实测不用这句话也可以

![image-20200412120319745](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412120319745.png)

##### route生命周期:

![image-20200412115642932](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412115642932.png)

##### 当route-view 被keepalive包裹时 activated 和deactivated函数才会被执行

![image-20200412115757460](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412115757460.png)

##### keepline全局缓存

![image-20200412120733115](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412120733115.png)

##### keepline选择性缓存

​			keppline exclude

![image-20200412121258198](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412121258198.png)

​			keeplive include

![image-20200412121445990](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412121445990.png)

#### 7.promise封装ajax，异步操作

##### promise封装

![image-20200412172433327](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412172433327.png)

```js
new Promise((resolve,reject)=>{
				setTimeout(()=>{
					//resolve('hello world')
					reject('err data')
				},1000)
			 })
			 //.then((data)=>{
			// 	console.log(data);
			// 	console.log(data);
			// 	console.log(data);
			// 	console.log(data);
			// 	console.log(data);
			// 	console.log(data);
			// 	}).catch((err)=>{
			// 		console.log(err)
			// 	})
			.then((data)=>{
				console.log(data)
				return new Promise((resolve,reject)=>{
					......
					......
					......
				})
			},(err)=>{
				console.log(err)
			})
```

##### PromiseAll

![image-20200412172459910](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412172459910.png)

```js
Promise.all([
				new Promise((resolve,reject)=>{
					setTimeout(()=>{
						resolve("2秒结果");
						console.log("2秒结果");
					},2000)
				}),
				new Promise((resolve,reject)=>{
					setTimeout(()=>{
						console.log("一秒结果");
						resolve("1秒结果")
					},1000)
				})
			]).then(datas=>{
				console.log(datas[0]+datas[1])
			})
```



### 8.vuex存储共用信息的插件

1.安装

2.使用

类似router的使用

```js
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
```

定义属性在state

操作属性在	mutations:{

获取属性在getters

appvue里面的使用

![image-20200413125513316](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200413125513316.png)





### 备注

#### 路径别名：

在package.json的同级页面创建

vue.config.js文件

![image-20200412160231623](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412160231623.png)

const path = require('path');//引入path模块
const resolve = dir => path.join(__dirname, dir)

module.exports = {
  chainWebpack: config => {
    // 设置快捷路径， @ 表示 'src' ，components 表示 'src/components'
    config.resolve.alias
      // .set('@', resolve('src'))
      .set('assets', resolve('src/assets'))
      .set('components', resolve('src/components'))
      .set('views', resolve('src/views'))
  },
}

import 直接引用 views/

src 要加‘~’符号

![image-20200412160345539](C:\Users\chengang\AppData\Roaming\Typora\typora-user-images\image-20200412160345539.png)

