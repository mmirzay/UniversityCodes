using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace Azmoongir
{
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
        }

        private void Login_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }

        private void rdbMaster_CheckedChanged(object sender, EventArgs e)
        {
            grbMaster.Enabled = true;
            grbStu.Enabled = false;
            txtStuID.Text = "";
            txtMasterUser.Text = "modir";
            txtMasterPass.Text = "12345";
        }

        private void rdbStu_CheckedChanged(object sender, EventArgs e)
        {
            grbMaster.Enabled = false;
            grbStu.Enabled = true;
        }

        private void Login_Load(object sender, EventArgs e)
        {
            this.SetBounds(20, 30, this.Width, this.Height);
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnEnter_Click(object sender, EventArgs e)
        {
            if (rdbMaster.Checked == false && rdbStu.Checked == false)
                MessageBox.Show("لطفا کاربر را انتخاب کنید", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else if (rdbMaster.Checked && (txtMasterUser.Text.Equals("") || txtMasterPass.Text.Equals("")))
                MessageBox.Show("همه ی مقادیر را وارد کنید.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else if (rdbStu.Checked && (txtStuID.Text.Equals("")))
                MessageBox.Show("همه ی مقادیر را وارد کنید.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else if (rdbMaster.Checked)
            {
                if (txtMasterUser.Text.Equals("modir") && txtMasterPass.Text.Equals("12345"))
                    this.Hide();
                else
                    MessageBox.Show("رمز عبور یا نام کاربری اشتباه است", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else if (rdbStu.Checked)
            {
                bool exist=false;
                string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
                SqlConnection sqlcnn = new SqlConnection(strcnn);
                SqlCommand sqlcmd = new SqlCommand();
                sqlcmd.Connection = sqlcnn;
                sqlcmd.CommandText = "select [شماره دانشجویی] from Student";
                sqlcnn.Open();
                SqlDataReader sqldr = sqlcmd.ExecuteReader();
                while (sqldr.Read())
                    if(txtStuID.Text.Equals(sqldr["شماره دانشجویی"])){
                        exist=true;
                        new Testing(txtStuID.Text).ShowDialog();
                    }
                if(!exist)
                    MessageBox.Show("شماره دانشجویی شما ثبت نشده است", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                sqlcnn.Close();
                sqlcnn.Dispose();
                sqlcmd.Dispose();
                sqldr.Dispose();
            }
        }
    }
}
