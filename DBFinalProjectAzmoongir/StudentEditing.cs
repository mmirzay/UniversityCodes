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
    public partial class StudentEditing : Form
    {
        public StudentEditing()
        {
            InitializeComponent();
        }

        private void StudentEditing_Load(object sender, EventArgs e)
        {
            this.SetBounds(20, 30, this.Width, this.Height);
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select [شماره دانشجویی] from Student";
            sqlcnn.Open();
            SqlDataReader sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read())
                cmbStuID.Items.Add(sqldr["شماره دانشجویی"]);
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
        }

        private void cmbStuID_SelectedIndexChanged(object sender, EventArgs e)
        {
            string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
            SqlConnection sqlcnn = new SqlConnection(strcnn);
            SqlCommand sqlcmd = new SqlCommand();
            sqlcmd.Connection = sqlcnn;
            sqlcmd.CommandText = "select * from Student";
            sqlcnn.Open();
            SqlDataReader sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read())
                if (cmbStuID.Text.Equals("" + sqldr["شماره دانشجویی"]))
                {
                    rtxtStuName.Text = "" + sqldr["نام"];
                    rtxtStuFamily.Text = "" + sqldr["نام خانوادگی"];
                    rtxtStuMajor.Text = "" + sqldr["رشته"];
                    rtxtStuType.Text = "" + sqldr["جنسیت"];
                    txtStuName.Text = rtxtStuName.Text;
                    txtStuFamily.Text = rtxtStuFamily.Text;
                    txtStuID.Text = cmbStuID.Text;
                    txtStuMajor.Text = rtxtStuMajor.Text;
                    cmbStuType.Text = rtxtStuType.Text;
                    grbChange.Enabled = true;
                    break;
                }
            sqlcnn.Close();
            sqlcnn.Dispose();
            sqlcmd.Dispose();
            sqldr.Dispose();
        }

        private void btnSaveChange_Click(object sender, EventArgs e)
        {
            if (cmbStuID.Text.Equals("") ||
                txtStuName.Text.Equals("") || txtStuFamily.Text.Equals("") ||
                cmbStuType.Text.Equals("") || txtStuMajor.Text.Equals("") || txtStuID.Text.Equals(""))
                MessageBox.Show("همه ی مقادیر را وارد کنید.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else
            {
                string strcnn = "server=.;DataBase=Azmoon;Integrated Security=True";
                SqlConnection sqlcnn = new SqlConnection(strcnn);
                SqlCommand sqlcmd = new SqlCommand();
                sqlcmd.Connection = sqlcnn;
                sqlcmd.CommandText = "update Student set نام='" + txtStuName.Text + "',[نام خانوادگی]='" +
                    txtStuFamily.Text + "',[رشته]='" + txtStuMajor.Text + "',[شماره دانشجویی]='" + txtStuID.Text + "',جنسیت='" + cmbStuType.Text + "'" 
                    +" where [شماره دانشجویی]='" + cmbStuID.Text + "'";
                sqlcnn.Open();
                try
                {
                    sqlcmd.ExecuteNonQuery();                    
                    sqlcnn.Close();
                    sqlcnn.Dispose();
                    sqlcmd.Dispose();
                    MessageBox.Show("تغییرات اعمال گردید", "تغییرات", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    this.Close();
                }
                catch (SqlException sqlex)
                {
                    if (sqlex.ErrorCode == -2146232060)
                        MessageBox.Show("کد دانشجو قبلا وارد شده است.", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    else
                        MessageBox.Show(" خطا در وارد کردن مقادیر", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }//else
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
