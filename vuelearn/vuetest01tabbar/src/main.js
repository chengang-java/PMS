import Vue from 'vue'
import App from './App.vue'
import router from './router'

Vue.config.productionTip = false

new Vue({
  router,
  //runtime-only
  render: h => h(App)
}).$mount('#app')

//require('./assets/css/base.css')
