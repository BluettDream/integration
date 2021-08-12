<template>
  <div>
    <el-table
      :data="tableData"
      :default-sort="{ prop: 'age', order: 'descending' }"
      border
    >
      <el-table-column prop="name" label="姓名" width="100"></el-table-column>
      <el-table-column
        prop="age"
        label="年龄"
        width="80"
        sortable
      ></el-table-column>
      <el-table-column prop="sex" label="性别" width="80"></el-table-column>
      <el-table-column prop="address" label="地址" width="880"></el-table-column>
      <el-table-column fixed="right" label="操作" width="220">
        <template #default="scope">
          <el-button
            size="medium"
            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button
            size="medium"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        background
        layout="prev, pager, next"
        :page-size="5"
        :total="100"
        @current-change="page">
    </el-pagination>
  </div>
</template>

<script>
export default {
  name: "Account",
  methods: {
    handleEdit(index, row) {
      console.log(index, row);
    },
    page(currentPage){
        console.log(currentPage)
    },
    handleDelete(index, row) {
      console.log(index, row);
    }
  },
  created(){
    this.$axios.get('http://localhost:8081/account/1/1').then(resp => {
      console.log(resp)
    })
  },
  data() {
    const item = {
      name: "王小虎",
      sex: "男",
      age: 20,
      address: "上海市",
    };
    return {
      tableData: Array(5).fill(item),
    };
  },
};
</script>

