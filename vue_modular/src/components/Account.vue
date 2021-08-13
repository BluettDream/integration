<template>
  <div class="s1">
    <el-table
      :data="tableData"
      border
      v-loading="loading">
      <el-table-column prop="accountName" label="姓名" width="100"></el-table-column>
      <el-table-column
        prop="accountAge"
        label="年龄"
        width="80"
        sortable
      ></el-table-column>
      <el-table-column prop="accountSex" label="性别" width="80"></el-table-column>
      <el-table-column prop="accountAddress" label="地址" width="860"></el-table-column>
      <el-table-column fixed="right" label="操作" width="220">
        <template #default="scope">
          <el-button
            size="medium"
            @click="dialogFormVisible = true;handleEdit(scope.$index, scope.row)">修改</el-button>
            <el-dialog :destroy-on-close="true" title="用户信息" v-model="dialogFormVisible" :modal="false" :center="true">
              <el-form :model="form">
                <el-form-item label="姓名" :label-width="formLabelWidth">
                  <el-input v-model="form.accountName" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="年龄" :label-width="formLabelWidth">
                  <el-input v-model="form.accountAge" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="性别" :label-width="formLabelWidth">
                  <el-select v-model="form.accountSex" placeholder="请选择性别">
                    <el-option label="男" value="男"></el-option>
                    <el-option label="女" value="女"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="地址" :label-width="formLabelWidth">
                  <el-input v-model="form.accountAddress" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="ID" :label-width="formLabelWidth" v-show="false">
                  <el-input v-model="form.accountId"></el-input>
                </el-form-item>
              </el-form>
              <template #footer>
                <span class="dialog-footer">
                  <el-button @click="dialogFormVisible = false">取 消</el-button>
                  <el-button type="primary" @click="dialogFormVisible = false;submitForm('form')">确 定</el-button>
                </span>
              </template>
            </el-dialog>
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
import { ElMessage } from 'element-plus'
export default {
  name: "Account",
  methods: {
    handleEdit(index, row) {
      this.form = row;
    },
    page(currentPage){
      this.loading = true;
      this.axios.get('http://localhost:8081/accountPage/'+currentPage+'/5').then((resp) => {
        this.tableData = resp.data.records;
        this.total = resp.data.total;
        this.pageSize = resp.data.size;
        this.loading = false;
      })
    },
    handleDelete(index, row) {
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.axios.delete('http://localhost:8081/deleteAccount'+row.accountId).then(resp =>{
            if(resp.data == 'success'){
              window.location.reload();
              this.$message({
                type: 'success',
                message: '删除成功!'
              });
            }else{
              this.$message({
                type: 'error',
                message: '删除失败，服务器未连接!'
              });
            }
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
      });
    },
    submitForm(formName) {
      this.axios.post('http://localhost:8081/updateAccount',this.form).then(resp => {
        if(resp.data == 'success'){
            this.$router.push('/account');
            ElMessage.success('用户修改成功!'); 
        }else{
            ElMessage.error('用户修改失败,连接不到服务器!');
        }
      });
    }
  },
  created(){
    this.loading = true;
    this.axios.get('http://localhost:8081/accountPage/1/5').then((resp) => {
      this.tableData = resp.data.records;
      this.total = resp.data.total;
      this.pageSize = resp.data.size;
      this.loading = false;
    })
  },
  data() {
    return {
      pageSize: null,
      total: null,
      tableData: null,
      loading:true,
      dialogFormVisible: false,
      form:{},
      formLabelWidth: '120px'
    };
  }
};
</script>
<style>
  .s1{
    margin: 10px;
  }
</style>
