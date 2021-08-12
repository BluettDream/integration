<template>
  <div>
    <el-table
      :data="tableData"
      border
    >
      <el-table-column prop="accountName" label="姓名" width="100"></el-table-column>
      <el-table-column
        prop="accountAge"
        label="年龄"
        width="80"
        sortable
      ></el-table-column>
      <el-table-column prop="accountSex" label="性别" width="80"></el-table-column>
      <el-table-column prop="accountAddress" label="地址" width="880"></el-table-column>
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
        :page-size="pageSize"
        :total="total"
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
      this.axios.get('http://localhost:8081/accountPage/'+currentPage+'/5').then((resp) => {
        this.tableData = resp.data.records;
        this.total = resp.data.total;
        this.pageSize = resp.data.size;
      })
    },
    handleDelete(index, row) {
      console.log(index, row);
    }
  },
  created(){
    this.axios.get('http://localhost:8081/accountPage/1/5').then((resp) => {
      this.tableData = resp.data.records;
      this.total = resp.data.total;
      this.pageSize = resp.data.size;
    })
  },
  data() {
    return {
      pageSize: null,
      total: null,
      tableData: null
    };
  },
};
</script>

