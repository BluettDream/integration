<template>
  <el-container style="height: 500px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu router :default-openeds="['0']">
        <el-submenu v-for="(item,index) in $router.options.routes" :key="item" :index="index+''">
          <template #title><i class="el-icon-menu"></i>{{ item.name }}</template>
          <el-menu-item-group>
            <el-menu-item v-for="(item2,index2) in item.children" :key="item2" :index="item2.path" :class="$route.path==item2.path?'is-active':''">{{ item2.name }}</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <span>BLUE</span>
      </el-header>
      <router-view/>
    </el-container>
  </el-container>
</template>
<script>
  export default {
    name:'Account'
  };
</script>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }
</style>

