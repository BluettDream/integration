<template>
<div class="s1">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="80px" class="demo-ruleForm">
        <el-form-item label="姓名" prop="accountName">
            <el-input v-model="ruleForm.accountName" class="s3"></el-input>
        </el-form-item>
        <el-form-item label="年龄" prop="accountAge">
            <el-input v-model="ruleForm.accountAge" class="s2"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="accountSex">
            <el-select v-model="ruleForm.accountSex" placeholder="请选择性别">
                <el-option label="男" value="男"></el-option>
                <el-option label="女" value="女"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="地址" prop="accountAddress">
            <el-input v-model="ruleForm.accountAddress" class="s4"></el-input>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">添加</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
</div>
</template>

<script>
import { ElMessage } from 'element-plus'
export default {
    data() {
        return {
            ruleForm: {
                accountName: '',
                accountSex: '',
                accountAge:18,
                accountAddress:'',
            },
            rules: {
                accountName: [
                    { required: true, message: '请输入姓名', trigger: 'blur' }
                ],
                accountSex: [
                    { required: true, message: '请选择性别', trigger: 'change' }
                ],
                accountAge:[
                    { required: true, message: '请输入年龄', trigger: 'blur' }
                ],
                accountAddress:[
                    { required: false, message: '请输入地址', trigger: 'blur' },
                    { min: 3, message: '最少3个字符', trigger: 'blur' }
                ]
            }
        };
    },
    methods: {
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.axios.post('http://localhost:8081/addAccount',this.ruleForm).then(resp => {
                        if(resp.data == 'success'){
                            this.$router.push('/account');
                            ElMessage.success('用户添加成功!'); 
                        }else{
                            ElMessage.error('用户添加失败,服务端未连接!');
                        }
                    });
                } else {
                    ElMessage.error('用户添加失败,校验不通过!');
                    return false;
                }
            });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        }
    }
}
</script>
<style>
    .s1{
        margin: 20px;
    }
    .s2{
        width: 60px !important;
    }
    .s3{
        width: 150px !important;
    }
    .s4{
        width: 80% !important;
    }
</style>