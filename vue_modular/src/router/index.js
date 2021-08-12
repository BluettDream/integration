import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Account from '../components/Account.vue'
import Bill from '../components/Bill.vue'

const routes = [
  {
    path: '/',
    name: '首页',
    component: Home,
    redirect:'/account',
    children:[
      {
        path: '/account',
        name: '用户',
        component: Account
      },
      {
        path: '/bill',
        name: '账单',
        component: Bill
      },
      {
        path: '/about',
        name: '关于',
        component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
